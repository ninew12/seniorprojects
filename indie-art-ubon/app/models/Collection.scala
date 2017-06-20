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



  case class Collection(
      id: Option[Long],
      artworkid: String,
      userID: String

  )

  class collections(tag: Tag) extends Table[Collection](tag, "collection") {
      def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
      def  artworkid = column[String]("artworkid")
      def  userID = column[String]("userID")

 override def * = (id.? , artworkid, userID  ) <> (Collection.tupled, Collection.unapply)
  }



  object DBcollection {

    val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

    val dbcol = TableQuery[collections]

    def add(collection: Collection): Future[String] = {
      dbConfig.db.run(dbcol  += collection).map(res => "successfully").recover {
        case ex: Exception => ex.getCause.getMessage
        }
   }

    def listAll: Future[Seq[Collection]] = {
      dbConfig.db.run(dbcol.result)
    }

    def find(userID: String): Future[Seq[Collection]] = {
      dbConfig.db.run(dbcol.filter(_.userID === userID).result)
  }
    def get(userID: String): Future[Option[Collection]] = {
      dbConfig.db.run(dbcol.filter(_.userID === userID).result.headOption)
 }
    def update(collection: Collection): Future[String] = {
      dbConfig.db.run(dbcol.filter(_.id === collection.id).update(collection)).map(res => "successfully").recover {
      case ex: Exception => ex.getCause.getMessage
      }
    }
    def delete(userID: String): Future[Int] = {
      dbConfig.db.run(dbcol.filter(_.userID=== userID).delete)
      }
  }
