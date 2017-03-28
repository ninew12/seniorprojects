
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object listfiles_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class listfiles extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Seq[java.io.File],Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(files: Seq[java.io.File])(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.57*/("""

"""),_display_(/*3.2*/main(Messages("home.title"))/*3.30*/ {_display_(Seq[Any](format.raw/*3.32*/("""
    """),format.raw/*4.5*/("""<div class="user col-md-6 col-md-offset-3">
        <div class="row">
            <hr class="col-md-12" />
            <h4 class="col-md-8">"""),_display_(/*7.35*/Messages("welcome.guest")),format.raw/*7.60*/("""</h4>
            <div class="col-md-4 text-right">
            </div>
            <hr class="col-md-12" />
        </div>
        <div class="row data">
            <div class="col-md-12">
                <div class="row">
                    <p class="col-md-12"><strong> Have a look around </strong></p>
                </div>


		"""),_display_(/*19.4*/files/*19.9*/.map/*19.13*/ { f =>_display_(Seq[Any](format.raw/*19.20*/("""

			"""),format.raw/*21.4*/("""<div class="row">
				<p>"""),_display_(/*22.9*/f/*22.10*/.getAbsolutePath),format.raw/*22.26*/("""</p>
			</div>
		""")))}),format.raw/*24.4*/("""
            """),format.raw/*25.13*/("""</div>
        </div>
    </div>
""")))}),format.raw/*28.2*/("""
"""))
      }
    }
  }

  def render(files:Seq[java.io.File],messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(files)(messages)

  def f:((Seq[java.io.File]) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (files) => (messages) => apply(files)(messages)

  def ref: this.type = this

}


}

/**/
object listfiles extends listfiles_Scope0.listfiles
              /*
                  -- GENERATED --
                  DATE: Tue Mar 28 21:22:50 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/listfiles.scala.html
                  HASH: 604e795c3fbc53083784fbe948f4de36b631967b
                  MATRIX: 555->1|705->56|735->61|771->89|810->91|842->97|1012->241|1057->266|1430->613|1443->618|1456->622|1501->629|1535->636|1588->663|1598->664|1635->680|1685->700|1727->714|1794->751
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|31->7|31->7|43->19|43->19|43->19|43->19|45->21|46->22|46->22|46->22|48->24|49->25|52->28
                  -- GENERATED --
              */
          