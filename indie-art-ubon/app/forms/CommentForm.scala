package forms

import play.api.data.Form
import play.api.data.Forms._
import java.util.UUID

object CommentForm {

val form = Form(
    mapping(
      "commenterID" -> nonEmptyText,
      "detail" -> nonEmptyText
    )(Data.apply)(Data.unapply)
  )

  case class Data(
    commenterID: String,
    detail: String
  )
}
