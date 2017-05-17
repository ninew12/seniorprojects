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


case class ArtWork(
  id: String,
  userID: String,
  title: Option[String],
  detail: Option[String],
  tags: Option[String],
  modelType: Option[String]
  )

  class ArtWorks(tag: Tag) extends Table[ArtWork](tag, "ArtWork") {
    def id = column[String]("id", O.PrimaryKey)
    def userID = column[String]("userID")
    def title = column[Option[String]]("title")
    def detail = column[Option[String]]("detail")
    def tags = column[Option[String]]("tags")
    def modelType = column[Option[String]]("modelType")
  //  def date = column[Option[java.sql.Date]]("date")
    def * = ( id, userID, title, detail, tags, modelType ) <> (ArtWork.tupled, ArtWork.unapply)
  }

  object upload {

        val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

        val dbupload = TableQuery[ArtWorks]

      def add(de: ArtWork): Future[String] = {
        dbConfig.db.run(dbupload += de).map(res => "successfully").recover {
        case ex: Exception => ex.getCause.getMessage
        }

      }

    def getUser(userID: String): Future[Option[ArtWork]] = {
      dbConfig.db.run(dbupload.filter(_.userID === userID).result.headOption)
    }

    def listAll: Future[Seq[ArtWork]] = {
      dbConfig.db.run(dbupload.result)
    }

    def delete(userID: String): Future[Int] = {
      dbConfig.db.run(dbupload.filter(_.userID === userID).delete)
    }
  }
