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
    userID: String,
    title: Option[String],
    detail: Option[String],
    imagepost: Option[String],
    vdopost:Option[String]
    //date: Option[java.sql.Date]

)
case class Comment (
    userID : String,
    idcm : String ,
    detail: Option[String]
)


class foruminfos(tag: Tag) extends Table[Foruminfo](tag, "foruminfo") {
  def  id = column[String]("userID", O.PrimaryKey)
  def title = column[Option[String]]("title")
  def detail = column[Option[String]]("detail")
  def imagepost = column[Option[String]]("imagepost")
  def vdopost = column[Option[String]]("vdopost")
//  def date = column[Option[java.sql.Date]]("date")
  def * = (id, title, detail, imagepost, vdopost ) <> (Foruminfo.tupled, Foruminfo.unapply)
}

class comments (tag: Tag) extends Table[Comment](tag, "comment") {
  def  id = column[String]("userID", O.PrimaryKey)
  def  idcm = column[String]("idcomment")
  def detail = column[Option[String]]("detail")
  def * = (id,idcm, detail) <> (Comment.tupled, Comment.unapply)
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
   dbConfig.db.run(dbforuminfo.filter(_.id === userID).result)
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
   def find(idcm: String): Future[Seq[Comment]] = {
  dbConfig.db.run(dbcomment.filter(_.id === idcm).result)
}

  def listAll: Future[Seq[Comment]] = {
    dbConfig.db.run(dbcomment.result)
  }
}
