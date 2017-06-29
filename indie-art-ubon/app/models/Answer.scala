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


case class Answer (
    id :  String,
    userID : String ,
    detail: Option[String],
    forumid: String

)

class answers (tag: Tag) extends Table[Answer](tag, "answer") {
  def  id = column[String]("id", O.PrimaryKey)
  def userID = column[String]("userID")
  def detail = column[Option[String]]("detail")
  def forumid = column[String]("forumid")

  def * = (id,  userID, detail, forumid) <> (Answer.tupled, Answer.unapply)
}

object DBanswer {

  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  val db = TableQuery[answers]

  def add(answer : Answer): Future[String] = {
    dbConfig.db.run(db += answer).map(res => "successfully").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def get(id: String): Future[Option[Answer]] = {
   dbConfig.db.run(db.filter(_.id === id).result.headOption)
 }
   def find(userID : String): Future[Seq[Answer]] = {
  dbConfig.db.run(db.filter(_.id === userID).result)
}

  def listAll: Future[Seq[Answer]] = {
    dbConfig.db.run(db.result)
  }

  def update(answer : Answer): Future[String] = {
   dbConfig.db.run(db.filter(_.id === answer.id).update(answer)).map(res => "successfully").recover {
     case ex: Exception => ex.getCause.getMessage
   }
 }
  def delete(id: String): Future[Int] = {
    dbConfig.db.run(db.filter(_.id=== id).delete)
  }
}
