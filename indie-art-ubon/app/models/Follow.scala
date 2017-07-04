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

case class Follow (
    id: Option[Long],
    fid :  String,
    userID : String

)

class follows (tag: Tag) extends Table[Follow](tag, "follow") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def  fid = column[String]("fid")
  def userID = column[String]("userID")

 override def * = (id.?  ,fid,  userID ) <> (Follow.tupled, Follow.unapply)
}

object DBfollow {

  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  val dbfollow = TableQuery[follows]

  def add(follow: Follow): Future[String] = {
    dbConfig.db.run(dbfollow += follow).map(res => "successfully").recover {
      case ex: Exception => ex.getCause.getMessage
      }
 }
    def listAll: Future[Seq[Follow]] = {
      dbConfig.db.run(dbfollow.result)
  }
  def folUser(userID : String): Future[Seq[Follow]] = {
    dbConfig.db.run(dbfollow.filter(_.userID === userID).result)
  }
    def find(userID: String): Future[Seq[Follow]] = {
      dbConfig.db.run(dbfollow.filter(_.userID === userID).result)
  }
  def get(userID: String): Future[Option[Follow]] = {
   dbConfig.db.run(dbfollow.filter(_.userID === userID).result.headOption)
 }
 def delete(fid: String): Future[Int] = {
   dbConfig.db.run(dbfollow.filter(_.fid === fid).delete)
 }
}
