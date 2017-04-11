/*
package forms

import play.api.data.Form
import play.api.data.Forms._

object ArtForm {

  val form = Form(
    mapping(
      "userId" -> nonEmptyText,
      "title" -> nonEmptyText,
      "detail" -> nonEmptyText,
      "modelType" -> nonEmptyText
    )(Data.apply)(Data.unapply)
  )

  case class Data(
      userId: String,
      title: String,
      detail: String,
      modelType: String
  )
}
*/
