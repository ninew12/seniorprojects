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



case class Foruminfo(
    id: String,
    userID: String,
    title: String,
    detail: String,
    picture: String,
    vdopost: String
    //date: Option[java.sql.Date]

)
case class Comment (
    id :  String,
    userID : String ,
    detail: Option[String],
    artworkid: String ,
    forumid: String

)


class foruminfos(tag: Tag) extends Table[Foruminfo](tag, "foruminfo") {
  def id = column[String]("id", O.PrimaryKey)
  def userID = column[String]("userID")
  def title = column[String]("title")
  def detail = column[String]("detail")
  def picture = column[String]("picture")
  def vdopost = column[String]("vdopost")
//  def date = column[String]("date")
  def * = ( id, userID, title, detail, picture, vdopost ) <> (Foruminfo.tupled, Foruminfo.unapply)
}

class comments (tag: Tag) extends Table[Comment](tag, "comment") {
  def  id = column[String]("id", O.PrimaryKey)
  def userID = column[String]("userID")
  def detail = column[Option[String]]("detail")
  def artworkid = column[String]("artworkid")
  def forumid = column[String]("forumid")

  def * = (id,  userID, detail, artworkid, forumid) <> (Comment.tupled, Comment.unapply)
}
object addforum {

  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  val dbforuminfo = TableQuery[foruminfos]

  def add(role: Foruminfo): Future[String] = {
    dbConfig.db.run(dbforuminfo += role).map(res => "successfully").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def get(id: String): Future[Option[Foruminfo]] = {
   dbConfig.db.run(dbforuminfo.filter(_.id === id).result.headOption)
 }
  def find(userID: String): Future[Seq[Foruminfo]] = {
   dbConfig.db.run(dbforuminfo.filter(_.userID === userID).result)
 }


  def listAll: Future[Seq[Foruminfo]] = {
    dbConfig.db.run(dbforuminfo.result)
  }
}

object addcomment {

  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  val dbcomment = TableQuery[comments]

  def add(role: Comment): Future[String] = {
    dbConfig.db.run(dbcomment += role).map(res => "successfully").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def get(id: String): Future[Option[Comment]] = {
   dbConfig.db.run(dbcomment.filter(_.id === id).result.headOption)
 }
   def find(userID : String): Future[Seq[Comment]] = {
  dbConfig.db.run(dbcomment.filter(_.userID === userID).result)
}

  def listAll: Future[Seq[Comment]] = {
    dbConfig.db.run(dbcomment.result)
  }
}
