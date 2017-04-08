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
import forms.forumForm
import forms.CommentForm
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


class IndieApplication @Inject()(val webJarAssets: WebJarAssets,   val messagesApi: MessagesApi,
  val env: Environment[User, CookieAuthenticator],
  socialProviderRegistry: SocialProviderRegistry) extends Controller with Silhouette[User, CookieAuthenticator] {


  def selectmodel = UserAwareAction.async { implicit request =>
    Future.successful(Ok(views.html.selectModels(UserConstants.guest)))

        }

    def selectposts = UserAwareAction.async {implicit request =>
     val data = for{
       a <- addforum.listAll
       b <- addcomment.listAll
     }yield(a,b)
     data.map { case (dbforuminfo,dbcomment) =>
        Ok(views.html.selectPosts(CommentForm.form,dbforuminfo,dbcomment))

     }
}


    def collection = UserAwareAction.async { implicit request =>
    request.identity match {
      case Some(user) => Future.successful(Ok(views.html.collection(user)))
      case None => Future.successful(Ok(views.html.guesthome(UserConstants.guest)))
      }
    }


//def collection  = UserAwareAction.async {implicit request =>
    //addcollection.listAll.map {dbcol =>
//   Ok(views.html.collection(dbcol))
    //  }
  //  }

    def profile = UserAwareAction.async { implicit request =>
    request.identity match {
    case Some(user) => ListUser.listAll.map {users =>
        Ok(views.html.profile(user,users))
     }
       case None => Future.successful(Ok(views.html.guesthome(UserConstants.guest)))
       }

    }


      def forums = UserAwareAction.async { implicit request =>
      request.identity match {
        case Some(user) => Future.successful(Ok(views.html.createPosts(forumForm.form,user)))
        case None => Future.successful(Ok(views.html.guesthome(UserConstants.guest)))
      }

    }



    def forum = Action.async { implicit request =>
      forumForm.form.bindFromRequest.fold(
        form => Future.successful( Redirect("/")),
          data => {
            val forums = Foruminfo(
            userID = UUID.randomUUID.toString,
            title = Some(data.title),
            detail = Some(data.detail),
            imagepost = Some(data.imagepost),
            vdopost = Some(data.vdopost)

          )

          addforum.add(forums).map(res =>
             Redirect("/")
           )

    }
  )
}

  def comment = Action.async { implicit request =>
    CommentForm.form.bindFromRequest.fold(
      form => Future.successful( Redirect("/")),
        data => {
            val comments = Comment(
              userID = UUID.randomUUID.toString,
              detail = Some(data.detail)

          )

       addcomment.add(comments).map(res =>
             Redirect("/selectposts")
           )

    }
  )
}

    def upmodel = UserAwareAction.async { implicit request =>
    request.identity match {
      case Some(user) => Future.successful(Ok(views.html.uploadModel(user)))
      case None => Future.successful(Ok(views.html.guesthome(UserConstants.guest)))
  }
}


  //def member = UserAwareAction.async { implicit request =>
    //Future.successful(Ok(views.html.member(UserConstants.guest)))

    def member  = UserAwareAction.async {implicit request =>
    request.identity match {
    case Some(user) => ListUser.listAll.map {users =>
        Ok(views.html.member(users,user))
     }
       case None => Future.successful(Ok(views.html.guesthome(UserConstants.guest)))
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
