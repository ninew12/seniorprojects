package forms

import play.api.data.Form
import play.api.data.Forms._

object uploadForm {

  val form = Form(
    mapping(
      "userID" -> nonEmptyText,
      "title" -> nonEmptyText,
      "detail" -> nonEmptyText,
      "modelType" -> nonEmptyText,
      "picture" -> text

    )(Data.apply)(Data.unapply)
  )

  case class Data(
      userID: String,
      title: String,
      detail: String,
      modelType: String,
      picture: String

  )
}
