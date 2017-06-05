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
  title: String,
  detail: String,
  tags: String,
  picture: String,
  fileblend: String,
  filehtml: String
  )

  class artworks(tag: Tag) extends Table[ArtWork](tag, "artwork") {
    def id = column[String]("id", O.PrimaryKey)
    def userID = column[String]("userID")
    def title = column[String]("title")
    def detail = column[String]("detail")
    def tags = column[String]("tags")
    def picture  = column[String]("picture")
    def fileblend  = column[String]("fileblend")
    def filehtml  = column[String]("filehtml")
  //  def date = column[Option[java.sql.Date]]("date")
    def * = ( id, userID, title, detail, tags, picture,fileblend , filehtml ) <> (ArtWork.tupled, ArtWork.unapply)
  }

  object uploadart {

        val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

        val dbupload = TableQuery[artworks]

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

    def find(userID: String): Future[Seq[ArtWork]] = {
     dbConfig.db.run(dbupload.filter(_.userID === userID).result)
   }

    def delete(userID: String): Future[Int] = {
      dbConfig.db.run(dbupload.filter(_.userID === userID).delete)
    }
  }