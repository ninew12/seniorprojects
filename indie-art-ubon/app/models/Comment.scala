package models

import java.util.UUID
import play.api.Play
import play.api.db.slick.DatabaseConfigProvider
import scala.concurrent.Future
import slick.driver.JdbcProfile
import slick.driver.H2Driver.api._
import scala.concurrent.ExecutionContext.Implicits.global
import slick.lifted.ProvenShape.proveShapeOf
import models.daos._

case class Comment (
    id :  String,
    userID : String ,
    detail: Option[String],
    artworkid: String

)

class comments (tag: Tag) extends Table[Comment](tag, "comment") {
  def  id = column[String]("id", O.PrimaryKey)
  def userID = column[String]("userID")
  def detail = column[Option[String]]("detail")
  def artworkid = column[String]("artworkid")


  def * = (id,  userID, detail, artworkid) <> (Comment.tupled, Comment.unapply)
}

object addcomment {

  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  val dbcomment = TableQuery[comments]

  def add(comment : Comment): Future[String] = {
    dbConfig.db.run(dbcomment += comment).map(res => "successfully").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def get(id: String): Future[Option[Comment]] = {
   dbConfig.db.run(dbcomment.filter(_.id === id).result.headOption)
 }
   def find(userID : String): Future[Seq[Comment]] = {
  dbConfig.db.run(dbcomment.filter(_.id === userID).result)
}

  def listAll: Future[Seq[Comment]] = {
    dbConfig.db.run(dbcomment.result)
  }

  def update(comment: Comment): Future[String] = {
   dbConfig.db.run(dbcomment.filter(_.id === comment.id).update(comment)).map(res => "successfully").recover {
     case ex: Exception => ex.getCause.getMessage
   }
 }
  def delete(id: String): Future[Int] = {
    dbConfig.db.run(dbcomment.filter(_.id=== id).delete)
  }
}
