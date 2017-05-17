package controllers

import javax.inject.Inject
import sys.process._
import play.api.mvc._
import com.mohiva.play.silhouette.api.{ Environment, LogoutEvent, Silhouette }
import com.mohiva.play.silhouette.impl.authenticators.CookieAuthenticator
import com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry
import models.ListUser
import models.addcomment
import models.addforum
import models.addcollection
import forms._
import play.api.libs.json.Json
import play.api.Logger
import models.User
import models.DBUser
import models.Comment
import models.Collection
import models.Foruminfo
import models.UserConstants
import play.api.i18n.MessagesApi
import java.util.UUID
//import com.mohiva.play.silhouette.api.{ Identity, LoginInfo }
import scala.concurrent.ExecutionContext.Implicits.global
import java.io.File
import scala.concurrent.Future


class IndieApplication @Inject()(val webJarAssets: WebJarAssets,   val messagesApi: MessagesApi,
  val env: Environment[User, CookieAuthenticator],
  socialProviderRegistry: SocialProviderRegistry) extends Controller with Silhouette[User, CookieAuthenticator] {


    def selectmodel = UserAwareAction.async { implicit request =>
      Future.successful(Ok(views.html.selectModels(UserConstants.guest)))

    }

    /*def selectposts = UserAwareAction.async {implicit request =>
      val data = for{
        a <- addforum.listAll
        b <- addcomment.listAll
      }yield(a,b)
      data.map { case (dbforuminfo,dbcomment) =>
        Ok(views.html.selectPosts(CommentForm.form,dbforuminfo,dbcomment))

      }
    }*/

    def collection = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) => Future.successful(Ok(views.html.collection(user)))
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }
    }


    //def collection  = UserAwareAction.async {implicit request =>
    //addcollection.listAll.map {dbcol =>
    //   Ok(views.html.collection(dbcol))
    //  }
    //  }

    def profile(id: String) = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) => ListUser.find(id).map {users =>
          Ok(views.html.profile(user,users))
        }
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }

    }


    def forums = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) => Future.successful(Ok(views.html.createPosts(forumForm.form,user)))
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }

    }



    //def forum = Action.async { implicit request =>
    def forum = UserAwareAction.async { implicit request =>
      Logger.warn(s"controller.IndieApplication.forum")
      forumForm.form.bindFromRequest.fold(
        form => Future.successful( Redirect("/")),
        data => {
          Logger.warn(s"data=$data \ndata.forumID=${data.forumID}")
          val forums = Foruminfo(
            id = UUID.randomUUID.toString,
            userID = data.forumID,
            title = Some(data.title),
            detail = Some(data.detail),
            picture = Some(data.picture),
            vdopost = Some(data.vdopost)

          )

        addforum.add(forums).map(res =>
            Redirect("/")
            )

        }
        )
    }
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

    def upmodel = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) => Future.successful(Ok(views.html.uploadModel(user,uploadForm.form)))
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }
    }


    //def member = UserAwareAction.async { implicit request =>
    //Future.successful(Ok(views.html.member(UserConstants.guest)))

    def member  = UserAwareAction.async {implicit request =>
      request.identity match {
        case Some(user) => ListUser.listAll.map {users =>
          Ok(views.html.member(users,user))
        }
        case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }

    }

     def userP(id: String) = Action.async { implicit request =>
        val data = for{
          a <- addforum.find(id)
          b <- addcomment.find(id)
          c <- ListUser.listAll //ยังไม่ได้เชคid
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
           c <- ListUser.listAll //ยังไม่ได้เชคid
         }yield(a,b,c)
         data.map { case (dbforuminfo,dbcomment,users) =>
           Ok(views.html.showposts(CommentForm.form,dbforuminfo,dbcomment,users,user))
           }
            case None => Future.successful(Redirect(routes.ApplicationController.index()))
         }
       }

       def posts = UserAwareAction.async {implicit request =>
         request.identity match {
         case Some(user) =>  addforum.listAll.map {dbforuminfo =>
            Ok(views.html.postsUser(user,dbforuminfo))
        }
         case None => Future.successful(Redirect(routes.ApplicationController.index()))
       }
      }

      def model = UserAwareAction.async { implicit request =>
        request.identity match {
          case Some(user) => Future.successful(Ok(views.html.modelsUser(user)))
          case None => Future.successful(Redirect(routes.ApplicationController.index()))
        }
      }

      def showmodel = UserAwareAction.async { implicit request =>
        request.identity match {
          case Some(user) =>
          addcomment.listAll.map {dbcomment =>
            Ok(views.html.showmodel(user,CommentForm.form,dbcomment))

              }
          case None => Future.successful(Redirect(routes.ApplicationController.index()))
        }
      }

      def upload = Action { request =>
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
          a.ref.moveTo(new File(s"public/images/$filename"))
          for{
            b <- a.filename
          }yield b
        }

        val datablend = a.file("blend").map { a=>
          val filename = a.filename
          a.ref.moveTo(new File(s"public/images/$filename"))
          for{
            b <- a.filename
          }yield b
        }

        val datajson = a.file("json").map { a=>
          val filename = a.filename
          a.ref.moveTo(new File(s"public/images/$filename"))
          for{
            b <- a.filename
          }yield b
        }

        val datahtml = a.file("html").map { a=>
          val filename = a.filename
          a.ref.moveTo(new File(s"public/images/$filename"))
          for{
            b <- a.filename
          }yield b
        }

        val title = getdata(datatitle)
        val detail = getdata(datadetail)
        val picture = getdata(dataimg)
        val blend = getdata(datablend)
        val json = getdata(datajson)
        val html = getdata(datahtml)

        Redirect("/up")
      }.getOrElse {
        Redirect("/up")
      }
    }
    def getdata(x: Option[String]) = x match {
     case Some(s) => s
     case None => ""
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
