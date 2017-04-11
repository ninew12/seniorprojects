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
import play.api.data._
import play.api.data.Forms._
import forms._
import views.html._
import play.api.libs.json.Json
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

import scala.concurrent.Future


class ArtApplication @Inject()(val webJarAssets: WebJarAssets,   val messagesApi: MessagesApi,
  val env: Environment[User, CookieAuthenticator],
  socialProviderRegistry: SocialProviderRegistry) extends Controller with Silhouette[User, CookieAuthenticator] {

      /*
    def uploadmodel = Action(parse.multipartFormData) { implicit request =>
      //if (method == "GET") {
        ArtForm.form.bindFromRequest().fold(
          formWithErrors => {
            // binding failure, you retrieve the form containing errors:
            BadRequest(uploadModel(formWithErrors))
          },
          userData => {
           val newUser = models.User(userData.name, userData.age)
           val id = models.User.create(newUser)
           Redirect(routes.Application.home(id))
          }
          )
      //} else {
        request.body.file("picture").map { picture =>
          import java.io.File
          val filename = picture.filename
          val contentType = picture.contentType
          picture.ref.moveTo(new File(s"/tmp/picture/$filename"))
          Ok("File uploaded")
          }.getOrElse {
            Redirect(routes.Application.index).flashing(
              "error" -> "Missing file")
          }
      }
      //}
    }
      */

  }
