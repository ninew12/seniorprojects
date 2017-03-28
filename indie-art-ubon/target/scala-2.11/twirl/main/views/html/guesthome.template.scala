
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object guesthome_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class guesthome extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[models.User,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: models.User)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*2.1*/("""<!-- , dbforuminfo : Option[models.Foruminfo] -->
"""),_display_(/*3.2*/main(Messages("home.title") )/*3.31*/ {_display_(Seq[Any](format.raw/*3.33*/("""
"""),format.raw/*4.1*/("""<body>
  <div id="wrap3">
    <div class="user col-md-6 col-md-offset-3">
        <div class="row">
            <hr class="col-md-12">
            <br><br>
            <h3 class="col-md-8 text-right" >"""),_display_(/*10.47*/Messages("welcome.guest")),format.raw/*10.72*/("""</h3>
            <!-- <div class="col-md-4 text-right">
                <img src=""""),_display_(/*12.28*/user/*12.32*/.avatarURL.getOrElse(routes.Assets.at("images/silhouette.png"))),format.raw/*12.95*/("""" height="40px" />
            </div> -->
            <hr class="col-md-12" >
        </div>
    </div>
    <div class = "container">
      <div id="headerwrap">
      </div>
</div>

    """),_display_(/*22.6*/model(user)),format.raw/*22.17*/("""
"""),format.raw/*23.1*/("""</div>
      """),_display_(/*24.8*/posts(user)),format.raw/*24.19*/("""


    """),_display_(/*27.6*/footer(user)),format.raw/*27.18*/("""

"""),format.raw/*29.1*/("""</body>
""")))}),format.raw/*30.2*/("""
"""))
      }
    }
  }

  def render(user:models.User,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(user)(messages)

  def f:((models.User) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (user) => (messages) => apply(user)(messages)

  def ref: this.type = this

}


}

/**/
object guesthome extends guesthome_Scope0.guesthome
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 21:44:07 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/guesthome.scala.html
                  HASH: d2d13a09999d980f3768b3cd7dd025553ff4d025
                  MATRIX: 549->1|692->49|720->51|797->103|834->132|873->134|901->136|1135->343|1181->368|1294->454|1307->458|1391->521|1615->719|1647->730|1676->732|1717->747|1749->758|1786->769|1819->781|1850->785|1890->795
                  LINES: 20->1|25->1|26->2|27->3|27->3|27->3|28->4|34->10|34->10|36->12|36->12|36->12|46->22|46->22|47->23|48->24|48->24|51->27|51->27|53->29|54->30
                  -- GENERATED --
              */
          