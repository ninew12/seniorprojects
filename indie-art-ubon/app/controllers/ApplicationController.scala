package controllers

import javax.inject.Inject
import sys.process._
import play.api.mvc._
import sys.process._
import play.api.Logger
import models.ListUser
import com.mohiva.play.silhouette.api.{ Environment, LogoutEvent, Silhouette }
import com.mohiva.play.silhouette.impl.authenticators.CookieAuthenticator
import com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry
import forms._
import models._
import models.UserConstants
import play.api.i18n.MessagesApi
import java.util.UUID
//import com.mohiva.play.silhouette.api.{ Identity, LoginInfo }
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import java.io.File
import org.apache.commons.io.FilenameUtils;
/**
 * The basic application controller.
 *
 * @param messagesApi The Play messages API.
 * @param env The Silhouette environment.
 * @param socialProviderRegistry The social provider registry.
 */
class ApplicationController @Inject() (
  val messagesApi: MessagesApi,
  val env: Environment[User, CookieAuthenticator],
  socialProviderRegistry: SocialProviderRegistry)
  extends Silhouette[User, CookieAuthenticator] {


  def index = UserAwareAction.async { implicit request =>
   request.identity match {

    case Some(user) =>
        val data = for{
          a <- addforum.listAll
          b <- ListUser.listAll
          c <- uploadart.listAll
        }yield(a,b,c)
        data.map { case (dbforuminfo,users,dbartwork) =>
        Ok(views.html.home(user,dbforuminfo,users,dbartwork))

        }
        case None =>
        val data = for{
          a <- addforum.listAll
          b <- uploadart.listAll
        }yield(a,b)
        data.map { case (dbforuminfo,dbartwork) =>
        Ok(views.html.guesthome(UserConstants.guest,dbforuminfo,dbartwork))
       }
      }
    }

/*
  def run = Action { request =>
      //val r = "git --version" !
      //val r = Seq("git", "--version").lineStream
      //Ok(f"I'm running: $r")
      val r = new java.io.File("/tmp").listFiles
      Ok(views.html.listfiles(r))
  }*/

      def getlist = UserAwareAction.async {implicit request =>
      request.identity match {
      case Some(user) => ListUser.listAll.map {users =>
          Ok(views.html.listuser(users,user))
    }
     case None => Future.successful(Redirect(routes.ApplicationController.index()))
  }
 }

    def listforum = UserAwareAction.async { implicit request =>
      request.identity match {

        case Some(user) =>
          val data = for{
          a <- addforum.listAll
          b <- ListUser.listAll
          }yield(a,b)
          data.map { case (dbforuminfo,users) =>
          Ok(views.html.listforum(user,dbforuminfo,users))

            }
            case None => Future.successful(Redirect(routes.ApplicationController.index()))
          }
        }


  /**
   * Handles the index action.
   *
   * @return The result to display.
   */
  //def securedPage = SecuredAction.async { implicit request =>
  // Future.successful(Ok(views.html.home(request.identity)))
//  }

  /**
   * Handles the Sign In action.
   *
   * @return The result to display.
   */
  def signIn = UserAwareAction.async { implicit request =>
    request.identity match {
      case Some(user) => Future.successful(Redirect(routes.ApplicationController.index()))
      case None => Future.successful(Ok(views.html.signIn(SignInForm.form, socialProviderRegistry)))
    }
  }

  /**
   * Handles the Sign Up action.
   *
   * @return The result to display.
   */
  def signUp = UserAwareAction.async { implicit request =>
    request.identity match {
      case Some(user) => Future.successful(Redirect(routes.ApplicationController.index()))
      case None => Future.successful(Ok(views.html.signUp(SignUpForm.form)))
    }
  }

  /**
   * Handles the Sign Out action.
   *
   * @return The result to display.
   */
  def signOut = SecuredAction.async { implicit request =>
    val result = Redirect(routes.ApplicationController.index())
    env.eventBus.publish(LogoutEvent(request.identity, request, request2Messages))

    env.authenticatorService.discard(request.authenticator, result)
  }

  def uploadfile = UserAwareAction.async { implicit request =>
    request.identity match {
      case Some(user) =>
       val c = for{
         a <- ListUser.get(user.userID.toString)
       }yield a

       c.map { case (role) =>
          Ok(views.html.uploadModel(user,uploadForm.form))
       }

       case None => Future.successful(Redirect("/"))
     }
   }

    def getdata(x: Option[String]) = x match {
      case Some(s) => s
      case None => ""
 }

//แก้ไขกระทู้สนทนา
  def  updatePost2= UserAwareAction.async { implicit request =>
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

        val getRelation = for{
        a <- addforum.get(uid)
        }yield a

        val title = getdata(datatitle)
        val detail = getdata(datadetail)
        val picture = getdata(dataimg)

        //add table database
        val aaaa = getRelation.map { data =>
        data.map { aa =>
        val dbforum =  Foruminfo (
        id = aa.id,
        userID = user.userID.toString,
        title = title ,
        detail = detail ,
        picture = picture
        )

        val saveDate = for{
        a <- addforum.update(dbforum)
        }yield a

        }
    }
      Future.successful(Redirect("/posts"))
      }.getOrElse {
      Future.successful(Redirect("/fourums"))
      }
      case None => Future.successful(Redirect("/"))
    }
  }

  var uid = "";
  def updatepost (id : String) = UserAwareAction.async { implicit request =>
    request.identity match {
        case Some(user) =>
          uid =id;
          Future.successful(Ok(views.html.EditPost(forumForm.form,user)))
          case None => Future.successful(Redirect(routes.ApplicationController.index()))
          }
        }

//ลบกระทู้สนทนา
    def deletePost (id : String) = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) =>
         val c = for{
          a <- addforum.delete(id)
         }yield a
           Future.successful(Redirect("/posts"))

         case None => Future.successful(Redirect("/"))
         }
   }

  //แก้ไขรายละเอียดโมเดล
    def  updateMD2= UserAwareAction.async { implicit request =>
    request.identity match {
       case Some(user) =>
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
              id = uuid,
              userID = user.userID.toString,
              title = title(0),
              detail =  detail(0),
              tags = tags(0),
              picture = picture,
              fileblend = fileblend,
              filehtml = filehtml
            )
              uploadart.update(dbartwork) // save to db
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


    var uuid = "";
    def updatemd (id : String) = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) =>
          uuid =id;
          Future.successful(Ok(views.html.EditModel(user,uploadForm.form)))
          case None => Future.successful(Redirect(routes.ApplicationController.index()))
      }
    }
  //ลบโมเดล
      def deleteModel (id : String) = UserAwareAction.async { implicit request =>
        request.identity match {
          case Some(user) =>
          val c = for{
            a <- uploadart.delete(id)
          }yield a
             Future.successful(Redirect("/"))

          case None => Future.successful(Redirect("/"))
          }
    }

//ลบสมาชิกภายในระบบโดยadmin
     def deleteUser (id : String) = UserAwareAction.async { implicit request =>
       request.identity match {
         case Some(user) =>
         val c = for{
           a <- ListUser.delete(id)
         }yield a
          Future.successful(Redirect("/pagelist"))
          case None => Future.successful(Redirect("/"))
          }
      }

  //ลบโมเดลในแฟ้มสะสมผลงาน
      def deleteCol (id : Long) = UserAwareAction.async { implicit request =>
        request.identity match {
          case Some(user) =>
            val c = for{
              a <- DBcollection.delete(id)
            }yield a
              Future.successful(Redirect("/col"))
              case None => Future.successful(Redirect("/"))
            }
        }
//ลบการติดตาม
        def deletefollow (fid : String) = UserAwareAction.async { implicit request =>
          request.identity match {
            case Some(user) =>
            val c = for{
              a <- DBfollow.delete(fid)
            }yield a
               Future.successful(Redirect("/member"))

            case None => Future.successful(Redirect("/"))
            }
      }

}
