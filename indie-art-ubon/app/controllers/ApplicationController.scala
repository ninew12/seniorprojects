package controllers

import javax.inject.Inject
import sys.process._
import play.api.mvc._
import sys.process._
import play.api.mvc._
import models.ListUser
import com.mohiva.play.silhouette.api.{ Environment, LogoutEvent, Silhouette }
import com.mohiva.play.silhouette.impl.authenticators.CookieAuthenticator
import com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry
import forms._
import models.User
import models.addforum
import models.Foruminfo
import forms.forumForm
import models.UserConstants
import play.api.i18n.MessagesApi
import java.util.UUID
//import com.mohiva.play.silhouette.api.{ Identity, LoginInfo }
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

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

//  def index = UserAwareAction.async { implicit request =>
  //  request.identity match {
    //  case Some(user) => Future.successful(Ok(views.html.home(user)))
    //  case None => Future.successful(Ok(views.html.guesthome(UserConstants.guest)))
  //  }
//  }

  def index = UserAwareAction.async { implicit request =>
   request.identity match {

    case Some(user) =>
        val data = for{
          a <- ListUser.listAll
          b <- addforum.listAll
        }yield(b)
        data.map { dbforuminfo =>
        Ok(views.html.home(user,dbforuminfo))
        }
        case None =>
        val data = for{
          a <- addforum.listAll

        }yield(a)
        data.map { dbforuminfo =>
        Ok(views.html.guesthome(UserConstants.guest,dbforuminfo))
       }
      }
    }




  def run = Action { request =>
      //val r = "git --version" !
      //val r = Seq("git", "--version").lineStream
      //Ok(f"I'm running: $r")
      val r = new java.io.File("/tmp").listFiles
      Ok(views.html.listfiles(r))
  }
      def getlist = UserAwareAction.async {implicit request =>
      request.identity match {
      case Some(user) => ListUser.listAll.map {users =>
          Ok(views.html.listuser(users))
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
}
