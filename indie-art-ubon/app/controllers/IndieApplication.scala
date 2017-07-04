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
import reflect.io._


class IndieApplication @Inject()(val webJarAssets: WebJarAssets,   val messagesApi: MessagesApi,
  val env: Environment[User, CookieAuthenticator],
  socialProviderRegistry: SocialProviderRegistry) extends Controller with Silhouette[User, CookieAuthenticator] {




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
      var artworkid = "";
      var testid = "";
      def showmodel (id : String, userID : String) = UserAwareAction.async { implicit request =>
        request.identity match {
          case Some(user) =>
          artworkid = id
          testid = userID
          val data = for{
            a <- uploadart.find(id)
            b <- addcomment.listAll
            c <- ListUser.find(userID)
            d <- DBcollection.listAll
            us <- ListUser.listAll
          }yield(a,b,c,d,us)
            data.map {case (dbartwork,dbcomment,users,dbcol,us) =>
            Ok(views.html.showmodel(CommentForm.form,user,dbartwork,dbcomment,users,dbcol,us))
          }
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }
    }
    //ลบความคิดเห็น
        def deleteComment (id : String) = UserAwareAction.async { implicit request =>
          request.identity match {
            case Some(user) =>
            val c = for{
              a <- addcomment.delete(id)
            }yield a
               Future.successful(Redirect(s"/showmodel/${artworkid}?userID=${testid}"))

            case None => Future.successful(Redirect("/"))
            }
      }
    //แสดงแฟ้มสะสมผลงาน
    def  modelshow(id: String, userID : String) = Action.async { implicit request =>
        val data = for{
        a <- uploadart.find(id)
        b <- addcomment.listAll
        c <- ListUser.find(userID)
        u <- ListUser.listAll
        }yield(a,b,c,u)
        data.map {case (dbartwork,dbcomment,users,u) =>
        Ok(views.html.selectModels(dbartwork,dbcomment,users,u))
     }
  }

//แสดงแฟ้มสะสมผลงาน
    def collection = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) =>
            val data = for{
            a <- DBcollection.colUser(user.userID.toString)
            b <- uploadart.listAll
            }yield(a,b)
            data.map { case (col,art) =>
            Ok(views.html.collection(user,col,art))
          }
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }
    }

    def follow = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) =>
            val data = for{
            a <- DBfollow.folUser(user.userID.toString)
            b <- ListUser.listAll
            }yield(a,b)
            data.map { case (dbfollow,users) =>
            Ok(views.html.follow(users,user,dbfollow))
          }
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }
    }
    //แสดงข้อมูลส่วนตัว
    def profile(id: String) = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) =>
            val data = for{
            a <- ListUser.find(id)
            b <- uploadart.listAll
          }yield(a,b)
          data.map { case (users,art) =>
            Ok(views.html.profile(user,users,art))
          }

        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }

    }


    //โชว์กระทู้เมื่อทำการคลิกเพื่อเข้าอ่านกระทู้

    def userP(id: String, idpost : String) = Action.async { implicit request =>
        val data = for{
          a <- addforum.find(idpost)
          b <- DBanswer.listAll
          c <- ListUser.find(id)
          u <- ListUser.listAll
          }yield(a,b,c,u)
          data.map { case (dbforuminfo,dbanswer,users,listuser) =>
          Ok(views.html.selectPosts(dbforuminfo,dbanswer,users,listuser))
          }
        }


    var forumid = "";
    var tid = "";
    def showpost (id : String, userID : String) = UserAwareAction.async { implicit request =>
        request.identity match {
          case Some(user) =>
          forumid = id
          tid = userID
            val data = for{
              a <- addforum.get(id)
              b <- DBanswer.listAll
              c <- ListUser.find(userID)
              u <- ListUser.listAll
          }yield(a,b,c,u)
            data.map { case (dbforuminfo,dbanswer,users,listuser) =>
            Ok(views.html.showposts(CommentForm.form,dbforuminfo,dbanswer,users,user,listuser))
          }
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }
    }

         def deleteanswer (id : String) = UserAwareAction.async { implicit request =>
           request.identity match {
             case Some(user) =>
             val c = for{
               a <- DBanswer.delete(id)
             }yield a
               Future.successful(Redirect(s"/showpost/${forumid}?userID=${tid}"))

             case None => Future.successful(Redirect("/"))
            }
       }
  //แสดงกระทู้ส่วนผู้ใช้ทั่วไป
  /*
         def post(id: String) = Action.async { implicit request =>
            val data = for{
              a <- addforum.find(id)
              b <- addcomment.listAll
              c <- ListUser.find(id)
            }yield(a,b,c)
            data.map { case (dbforuminfo,dbcomment,users) =>
              Ok(views.html.selectPosts(dbforuminfo,dbcomment,users))
              }
         }
*/
//แสดงความคิดเห็น
      def comment = UserAwareAction.async { implicit request =>
        request.identity match {
          case Some(user) =>
            CommentForm.form.bindFromRequest.fold(
              form => Future.successful( Redirect("/")),
              data => {
                val comments = Comment(
                id = UUID.randomUUID.toString,
                userID = data.commenterID, // assign from data.commenterID see forms.CommentForm
                detail = Some(data.detail),
                artworkid = artworkid
              )

            val saveD = for {
              add <- addcomment.add(comments)
            }yield add

            Future.successful(Redirect(s"/showmodel/${artworkid}?userID=${testid}"))
            }
            )
          case None => Future.successful(Redirect("/"))
      }
    }
//แสดงความคิดเห็นเกี่ยวกับกระทู้
    def answer = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) =>
          CommentForm.form.bindFromRequest.fold(
            form => Future.successful( Redirect("/")),
            data => {
                val answers = Answer(
                id = UUID.randomUUID.toString,
                userID = data.commenterID, // assign from data.commenterID see forms.CommentForm
                detail = Some(data.detail),
                forumid = forumid
              )

             val saveD = for {
               add <- DBanswer.add(answers)
             }yield add

             Future.successful(Redirect(s"/showpost/${forumid}?userID=${tid}"))
             }
            )
          case None => Future.successful(Redirect("/"))
      }
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

    def modelC = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) =>
           val data = for{
            a <- uploadart.listAll
           }yield(a)
            data.map { dbartwork =>
            Ok(views.html.modelCharacter(user,dbartwork))
          }
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }
    }

    def modelA = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) =>
          val data = for{
            a <- uploadart.listAll
          }yield(a)
          data.map { dbartwork =>
            Ok(views.html.modelAssets(user,dbartwork))
          }
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }
    }

    def modelS = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) =>
          val data = for{
            a <- uploadart.listAll
          }yield(a)
          data.map { dbartwork =>
            Ok(views.html.modelScene(user,dbartwork))
          }
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }
    }

    def modelO = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) =>
          val data = for{
            a <- uploadart.listAll
          }yield(a)
          data.map { dbartwork =>
            Ok(views.html.modelOther(user,dbartwork))
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

    /**
     * code cleanup - 2017-06-27.
     * - เพิ่ม Logger เพื่อการตรวจสอบ
     * - ทำให้ code กระชับขึ้น + ลดความซ้ำซ้อน
     */
    def upload = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) =>

          //Logger.warn(s"IndieApplication.upload(user=${user.userID}, uuid=${uuid})")
          val defaults = Seq("")
          val uuid = UUID.randomUUID

          request.body.asMultipartFormData.map { a =>

            for (
                 title <- a.dataParts.get("title");
                 detail <- a.dataParts.get("detail");
                 tags <- a.dataParts.get("tags");
                 pictureFile <- a.file("picture");
                 blendFile <- a.file("fileblend");
                 htmlFile <- a.file("filehtml")
               ) yield {
                 //Logger.warn(s"pic = ${pic}, blend = ${blend}, html = ${html}")
                 val pictureExtension = reflect.io.File(pictureFile.filename).extension
                 val picture = s"$uuid.$pictureExtension"
                 val fileblend = s"$uuid.blend"
                 val filehtml = s"$uuid.html"
                 val dbartwork =  ArtWork (
                   //id = UUID.randomUUID.toString,
                 id = uuid.toString,
                 userID = user.userID.toString,
                 title = title(0),
                 detail =  detail(0),
                 tags = tags(0),
                 picture = picture,
                 fileblend = fileblend,
                 filehtml = filehtml
               )
                 uploadart.add(dbartwork) // save to db
                 // move files
                 pictureFile.ref.moveTo(new File(s"public/members/${user.userID}/$picture"))
                 blendFile.ref.moveTo(new File(s"public/members/${user.userID}/$fileblend"))
                 htmlFile.ref.moveTo(new File(s"public/members/${user.userID}/$filehtml"))
               }


              Future.successful(Redirect("/model"))
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
          request.body.asMultipartFormData.map { a =>
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

            Future.successful(Redirect("/posts"))
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

    def addcollection (id :String ) =  UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) =>
          val a = Collection(
            id = Some(0) ,
            userID = user.userID.toString,
            artworkid = id
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

    // ====== Not used ========================================================
    def downloadBlend(id:UUID) = UserAwareAction.async { implicit request =>
      Future.successful(Redirect("/"))
    }

  }
