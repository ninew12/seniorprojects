
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object home_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class home extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[models.User,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: models.User)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.50*/("""

"""),_display_(/*3.2*/main(Messages("home.title"), Some(user))/*3.42*/ {_display_(Seq[Any](format.raw/*3.44*/("""
    """),format.raw/*4.5*/("""<div class="user col-md-6 col-md-offset-3">
        <div class="row">
            <hr class="col-md-12" />
            <h4 class="col-md-8">"""),_display_(/*7.35*/Messages("welcome.signed.in")),format.raw/*7.64*/("""</h4>
            <div class="col-md-4 text-right">
                <img src=""""),_display_(/*9.28*/user/*9.32*/.avatarURL.getOrElse(routes.Assets.at("images/silhouette.png"))),format.raw/*9.95*/("""" height="40px" />
            </div>
            <hr class="col-md-12" />
        </div>
        <div class="row data">
            <div class="col-md-12">
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*16.50*/Messages("first.name")),format.raw/*16.72*/(""":</strong></p><p class="col-md-6">"""),_display_(/*16.107*/user/*16.111*/.firstName.getOrElse("None")),format.raw/*16.139*/("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*19.50*/Messages("last.name")),format.raw/*19.71*/(""":</strong></p><p class="col-md-6">"""),_display_(/*19.106*/user/*19.110*/.lastName.getOrElse("None")),format.raw/*19.137*/("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*22.50*/Messages("full.name")),format.raw/*22.71*/(""":</strong></p><p class="col-md-6">"""),_display_(/*22.106*/user/*22.110*/.fullName.getOrElse("None")),format.raw/*22.137*/("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*25.50*/Messages("email")),format.raw/*25.67*/(""":</strong></p><p class="col-md-6">"""),_display_(/*25.102*/user/*25.106*/.email.getOrElse("None")),format.raw/*25.130*/("""</p>
                </div>
            </div>
        </div>
    </div>
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
object home extends home_Scope0.home
              /*
                  -- GENERATED --
                  DATE: Tue Mar 28 21:22:50 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/home.scala.html
                  HASH: 9e6a0784091723e26e87778e2d0068ae776f9684
                  MATRIX: 539->1|682->49|712->54|760->94|799->96|831->102|1001->246|1050->275|1157->356|1169->360|1252->423|1526->670|1569->692|1632->727|1646->731|1696->759|1837->873|1879->894|1942->929|1956->933|2005->960|2146->1074|2188->1095|2251->1130|2265->1134|2314->1161|2455->1275|2493->1292|2556->1327|2570->1331|2616->1355|2725->1434
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|31->7|31->7|33->9|33->9|33->9|40->16|40->16|40->16|40->16|40->16|43->19|43->19|43->19|43->19|43->19|46->22|46->22|46->22|46->22|46->22|49->25|49->25|49->25|49->25|49->25|54->30
                  -- GENERATED --
              */
          