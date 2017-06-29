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
    picture: String
    //date: Option[java.sql.Date]

)


class foruminfos(tag: Tag) extends Table[Foruminfo](tag, "foruminfo") {
  def id = column[String]("id", O.PrimaryKey)
  def userID = column[String]("userID")
  def title = column[String]("title")
  def detail = column[String]("detail")
  def picture = column[String]("picture")
//  def date = column[String]("date")
  def * = ( id, userID, title, detail, picture ) <> (Foruminfo.tupled, Foruminfo.unapply)
}

object addforum {

  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  val dbforuminfo = TableQuery[foruminfos]

  def add(role: Foruminfo): Future[String] = {
    dbConfig.db.run(dbforuminfo += role).map(res => "successfully").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }
  def find(id: String): Future[Seq[Foruminfo]] = {
   dbConfig.db.run(dbforuminfo.filter(_.id === id).result)
 }

  def listAll: Future[Seq[Foruminfo]] = {
    dbConfig.db.run(dbforuminfo.result)
  }
  def update(foruminfo: Foruminfo): Future[String] = {
   dbConfig.db.run(dbforuminfo.filter(_.id === foruminfo.id).update(foruminfo)).map(res => "successfully").recover {
     case ex: Exception => ex.getCause.getMessage
   }
 }
  def get(id: String): Future[Option[Foruminfo]] = {
   dbConfig.db.run(dbforuminfo.filter(_.id === id).result.headOption)
 }

  def delete(id: String): Future[Int] = {
     dbConfig.db.run(dbforuminfo.filter(_.id === id).delete)
   }
}
