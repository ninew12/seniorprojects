package controllers

import javax.inject.Inject
import sys.process._
import play.api.mvc._
import com.mohiva.play.silhouette.api.{ Environment, LogoutEvent, Silhouette }
import com.mohiva.play.silhouette.impl.authenticators.CookieAuthenticator
import com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry
import forms._
import models._
import play.api.libs.json.Json
import play.api.Logger
import play.api.i18n.MessagesApi
import java.util.UUID
//import com.mohiva.play.silhouette.api.{ Identity, LoginInfo }
import scala.concurrent.ExecutionContext.Implicits.global
import java.io.File
import scala.concurrent.Future
import org.apache.commons.io.FilenameUtils;


class IndieApplication @Inject()(val webJarAssets: WebJarAssets,   val messagesApi: MessagesApi,
  val env: Environment[User, CookieAuthenticator],
  socialProviderRegistry: SocialProviderRegistry) extends Controller with Silhouette[User, CookieAuthenticator] {


//แสดงโมเดลเมื่อทำการคลิกเพื่อเข้าชมโมเดล
 def selectmodel = UserAwareAction.async { implicit request =>
   Future.successful(Ok(views.html.selectModels(UserConstants.guest)))

 }

 def admin = UserAwareAction.async { implicit request =>
 request.identity match {

  case Some(user) =>
      val data = for{
        a <- addforum.listAll
        b <- ListUser.listAll
        c <- uploadart.listAll
      }yield(a,b,c)
      data.map { case (dbforuminfo,users,dbartwork) =>
      Ok(views.html.adminHome(user,dbforuminfo,users,dbartwork))

      }
    case None => Future.successful(Redirect(routes.ApplicationController.index()))
   }
}
//แสดงรายละเอียกโมเดล
    def showmodel (id : String) = UserAwareAction.async { implicit request =>
    request.identity match {
    case Some(user) =>
     val data = for{
      a <- uploadart.find(id)
      b <- addcomment.find(id)
      c <- ListUser.find(id)
     }yield(a,b,c)
     data.map {case (dbartwork,dbcomment,users) =>
      Ok(views.html.showmodel(CommentForm.form,user,dbartwork,dbcomment,users))
      }
      case None => Future.successful(Redirect(routes.ApplicationController.index()))
    }
   }

//แสดงแฟ้มสะสมผลงาน
    def collection = UserAwareAction.async { implicit request =>
      request.identity match {
      case Some(user) =>
       val data = for{
       a <- uploadart.listAll
       }yield(a)
       data.map { dbartwork =>
       Ok(views.html.collection(user,dbartwork))
       }
      case None => Future.successful(Redirect(routes.ApplicationController.index()))
    }
  }

//แสดงข้อมูลส่วนตัว
    def profile(id: String) = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) => ListUser.find(id).map {users =>
          Ok(views.html.profile(user,users))
        }
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }

    }

//แสดงความคิดเห็น
    //def comment = Action.async { implicit request =>
    def comment = UserAwareAction.async { implicit request =>
      Logger.warn(s"controller.IndieApplication.comment")
      CommentForm.form.bindFromRequest.fold(
        form => Future.successful( Redirect("/")),
        data => {
          Logger.warn(s"data=$data \ndata.commenterID=${data.commenterID}")
          val comments = Comment(
            id = UUID.randomUUID.toString,
            userID = data.commenterID, // assign from data.commenterID see forms.CommentForm
            detail = Some(data.detail),
            artworkid = UUID.randomUUID.toString,
            forumid = UUID.randomUUID.toString
          )

        addcomment.add(comments).map(res =>
            Redirect("/ ")
            )

        }
        )
    }

//แสดง user ภายในระบบ
    def member   = UserAwareAction.async {implicit request =>
      request.identity match {
        case Some(user) =>
          val data = for{
           a <- ListUser.listAll
           b <- DBfollow.listAll
          }yield (a,b)
           data.map {  case (users,dbfollow) =>
          Ok(views.html.member(users,user,dbfollow))
        }
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }

    }

//โชว์กระทู้เมื่อทำการคลิกเพื่อเข้าอ่านกระทู้
     def userP(id: String) = Action.async { implicit request =>
        val data = for{
          a <- addforum.find(id)
          b <- addcomment.find(id)
          c <- ListUser.find(id)
        }yield(a,b,c)
        data.map { case (dbforuminfo,dbcomment,users) =>
          Ok(views.html.selectPosts(CommentForm.form,dbforuminfo,dbcomment,users))
          }
     }

     def showpost (id : String) = UserAwareAction.async { implicit request =>
       request.identity match {
         case Some(user) =>
         val data = for{
           a <- addforum.find(id)
           b <- addcomment.find(id)
           c <- ListUser.find(id)
         }yield(a,b,c)
         data.map { case (dbforuminfo,dbcomment,users) =>
           Ok(views.html.showposts(CommentForm.form,dbforuminfo,dbcomment,users,user))
           }
            case None => Future.successful(Redirect(routes.ApplicationController.index()))
         }
       }

//แสดงรายการกระทู้
       def posts   = UserAwareAction.async {implicit request =>
         request.identity match {
         case Some(user) =>
         val data = for{
             a <- addforum.listAll
             b <- ListUser.listAll
             }yield(a,b)
             data.map { case (dbforuminfo,users) =>
            Ok(views.html.postsUser(user,dbforuminfo,users))
        }
         case None => Future.successful(Redirect(routes.ApplicationController.index()))
       }
      }

//แสดงรายการโมเดล
      def model = UserAwareAction.async { implicit request =>
        request.identity match {
          case Some(user) =>
           val data = for{
           a <- uploadart.listAll
           }yield(a)
           data.map { dbartwork =>
           Ok(views.html.modelsUser(user,dbartwork))
           }
          case None => Future.successful(Redirect(routes.ApplicationController.index()))
        }
      }

      def upmodel = UserAwareAction.async { implicit request =>
          request.identity match {
            case Some(user) => Future.successful(Ok(views.html.uploadModel(user,uploadForm.form)))
            case None => Future.successful(Redirect(routes.ApplicationController.index()))
          }
        }

      def getdata(x: Option[String]) = x match {
        case Some(s) => s
        case None => ""
     }

//uploadfilemodel
      def upload = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) =>
        request.body.asMultipartFormData.map {a =>
        val datatitle = a.dataParts.get("title").map { a =>
           for{
             b <- a.mkString("")
            }yield b
        }

        val datadetail = a.dataParts.get("detail").map { a =>
           for{
             b <- a.mkString("")
            }yield b
        }

        val datatags = a.dataParts.get("tags").map { a =>
           for{
             b <- a.mkString("")
            }yield b
        }

        val dataimg = a.file("picture").map { a=>
          val filename = a.filename
          val extension = FilenameUtils.getExtension(filename)
          val newFileName = s"${UUID.randomUUID}.$extension"
          a.ref.moveTo(new File(s"public/images/$newFileName"))
          for{
            b <- newFileName
          }yield b
        }

        val datablend = a.file("fileblend").map { a=>
          val filename = a.filename
          val extension = FilenameUtils.getExtension(filename)
          val newFileName = s"${UUID.randomUUID}.$extension"
          a.ref.moveTo(new File(s"public/members/01/$newFileName"))
          for{
            b <- newFileName
          }yield b
        }

        val datahtml = a.file("filehtml").map { a=>
          val filename = a.filename
          val extension = FilenameUtils.getExtension(filename)
          val newFileName = s"${UUID.randomUUID}.$extension"
          a.ref.moveTo(new File(s"public/members/01/$newFileName"))
          for{
            b <- newFileName
          }yield b
        }

          val title = getdata(datatitle)
          val detail = getdata(datadetail)
          val tags = getdata(datatags)
          val picture = getdata(dataimg)
          val fileblend = getdata(datablend)
          val filehtml = getdata(datahtml)

          //add table database
          val dbartwork =  ArtWork (
          id = UUID.randomUUID.toString,
          userID = user.userID.toString,
          title = title ,
          detail = detail ,
          tags = tags ,
          picture = picture ,
          fileblend = fileblend,
          filehtml = filehtml

          )

          val saveDate = for{
          a <- uploadart.add(dbartwork)
          }yield a

        Future.successful(Redirect("/up"))
      }.getOrElse {
        Future.successful(Redirect("/up"))
      }
      case None => Future.successful(Redirect("/"))
    }
  }

  //ตั้งกระทู้
  def forum = UserAwareAction.async { implicit request =>
    request.identity match {
      case Some(user) =>
      request.body.asMultipartFormData.map {a =>
      val datatitle = a.dataParts.get("title").map { a =>
        for{
          b <- a.mkString("")
          }yield b
        }
        val datadetail = a.dataParts.get("detail").map { a =>
        for{
          b <- a.mkString("")
        }yield b
      }
        val dataimg = a.file("picture").map { a=>
        val filename = a.filename
        val extension = FilenameUtils.getExtension(filename)
        val newFileName = s"${UUID.randomUUID}.$extension"
        a.ref.moveTo(new File(s"public/images/$newFileName"))
      for{
        b <- newFileName
      }yield b
    }

      val title = getdata(datatitle)
      val detail = getdata(datadetail)
      val picture = getdata(dataimg)

      //add table database
      val dbforum =  Foruminfo (
      id = UUID.randomUUID.toString,
      userID = user.userID.toString,
      title = title ,
      detail = detail ,
      picture = picture
    )

      val saveDate = for{
      a <- addforum.add(dbforum)
      }yield a

      Future.successful(Redirect("/forums"))
      }.getOrElse {
        Future.successful(Redirect("/forums"))
      }
      case None => Future.successful(Redirect("/"))
    }
  }
    def forums = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) => Future.successful(Ok(views.html.createPosts(forumForm.form,user)))
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }

    }
//ติดตามผู้ใช้ภายในระบบ
    def addfollow (fid :String) =  UserAwareAction.async { implicit request =>
      request.identity match {
      case Some(user) =>
      val a = Follow(
       id = Some(0) ,
       fid = fid ,
       userID = user.userID.toString
     )
     val n = for{
       c <- DBfollow.add(a)
     }yield c

     Future.successful(Redirect("/member"))
     case None => Future.successful(Redirect("/"))
     }
 }

//เพิ่มโมเดลเข้าแฟ้มสะสมผลงาน
var dataID = "";
 def addcollection (artworkid :String) =  UserAwareAction.async { implicit request =>
   request.identity match {
   case Some(user) =>
    val a = Collection(
    id = Some(0) ,
    userID = user.userID.toString,
    artworkid = artworkid
   )

   val n = for{
     c <- DBcollection.add(a)
   }yield c


  Future.successful(Redirect("/col"))
  case None => Future.successful(Redirect("/"))
  }
}
    // ทดสอบ scala.html
    def b4wmodel() = Action {
      Ok(views.html.b4wmodel(""))
    }

    def three() = Action {
      Ok(views.html.threejsmodel())
    }

    def threejs2() = Action {
      Ok(views.html.threejs2())
    }

    }
