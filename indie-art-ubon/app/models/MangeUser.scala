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


case class DBUser (
  userID: String,
  firstName: Option[String],
  lastName: Option[String],
  fullName: Option[String],
  email: Option[String],
  avatarURL: Option[String]
)

case class DBUserRole (
  userID: String,
  role: String
)

class DBUserRoles(tag: Tag) extends Table[DBUserRole](tag, "userrole") {
  def userID = column[String]("userID", O.PrimaryKey)
  def role = column[String]("role")
  override def * = (userID, role) <> (DBUserRole.tupled, DBUserRole.unapply)
}

class Users(tag: Tag) extends Table[DBUser](tag, "user") {
  def userID = column[String]("userID", O.PrimaryKey)
  def firstName = column[Option[String]]("firstName")
  def lastName = column[Option[String]]("lastName")
  def fullName = column[Option[String]]("fullName")
  def email = column[Option[String]]("email")
  def avatarURL = column[Option[String]]("avatarURL")
  def * = (userID, firstName, lastName, fullName, email, avatarURL) <> (DBUser.tupled, DBUser.unapply)
}

object ListUser {

  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  val users = TableQuery[Users]
  val roles = TableQuery[DBUserRoles]

    def listAll: Future[Seq[DBUser]] = {
      dbConfig.db.run(users.result)
    }
    def find(userID: String): Future[Seq[DBUser]] = {
      dbConfig.db.run(users.filter(_.userID === userID).result)
   }

  def delete(userID: String): Future[Int] = {
    dbConfig.db.run(users.filter(_.userID === userID).delete)
  }

 def get(userID: String): Future[Option[DBUser]] = {
   dbConfig.db.run(users.filter(_.userID === userID).result.headOption)
 }

}


object Userroles {

  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  val slickUsersRole = TableQuery[DBUserRoles]

  def add(role: DBUserRole): Future[String] = {
    dbConfig.db.run(slickUsersRole += role).map(res => "successfully").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def delete(userID: String): Future[Int] = {
    dbConfig.db.run(slickUsersRole.filter(_.userID === userID).delete)
  }

  def get(userID: String): Future[Option[DBUserRole]] = {
    dbConfig.db.run(slickUsersRole.filter(_.userID === userID).result.headOption)
  }

  def listAll: Future[Seq[DBUserRole]] = {
    dbConfig.db.run(slickUsersRole.result)
  }
}
