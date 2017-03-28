
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object signUp_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class signUp extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Form[forms.SignUpForm.Data],RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(signInForm: Form[forms.SignUpForm.Data])(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import b3.inline.fieldConstructor

Seq[Any](format.raw/*1.96*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main(Messages("sign.up.title"))/*5.33*/ {_display_(Seq[Any](format.raw/*5.35*/("""
    """),_display_(/*6.6*/request/*6.13*/.flash.get("error").map/*6.36*/ { msg =>_display_(Seq[Any](format.raw/*6.45*/("""
        """),format.raw/*7.9*/("""<div class="col-md-6 col-md-offset-3 alert alert-danger alert-error">
            <a href="#" class="close" data-dismiss="alert">&times;</a>
            <strong>"""),_display_(/*9.22*/Messages("error")),format.raw/*9.39*/("""</strong> """),_display_(/*9.50*/msg),format.raw/*9.53*/("""
        """),format.raw/*10.9*/("""</div>
    """)))}),format.raw/*11.6*/("""
    """),format.raw/*12.5*/("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""),_display_(/*13.18*/Messages("sign.up.account")),format.raw/*13.45*/("""</legend>
        """),_display_(/*14.10*/helper/*14.16*/.form(action = routes.SignUpController.signUp())/*14.64*/ {_display_(Seq[Any](format.raw/*14.66*/("""
            """),_display_(/*15.14*/helper/*15.20*/.CSRF.formField),format.raw/*15.35*/("""
            """),_display_(/*16.14*/b3/*16.16*/.text(signInForm("firstName"), '_hiddenLabel -> Messages("first.name"), 'placeholder -> Messages("first.name"), 'class -> "form-control input-lg")),format.raw/*16.162*/("""
            """),_display_(/*17.14*/b3/*17.16*/.text(signInForm("lastName"), '_hiddenLabel -> Messages("last.name"), 'placeholder -> Messages("last.name"), 'class -> "form-control input-lg")),format.raw/*17.159*/("""
            """),_display_(/*18.14*/b3/*18.16*/.text(signInForm("email"), '_hiddenLabel -> Messages("email"), 'placeholder -> Messages("email"), 'class -> "form-control input-lg")),format.raw/*18.148*/("""
            """),_display_(/*19.14*/b3/*19.16*/.password(signInForm("password"), '_hiddenLabel -> Messages("password"), 'placeholder -> Messages("password"), 'class -> "form-control input-lg")),format.raw/*19.161*/("""
            """),format.raw/*20.13*/("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*22.112*/Messages("sign.up")),format.raw/*22.131*/("""</button>
                </div>
            </div>
            <div class="sign-in-now">
                <p>"""),_display_(/*26.21*/Messages("already.a.member")),format.raw/*26.49*/(""" """),format.raw/*26.50*/("""<a href=""""),_display_(/*26.60*/routes/*26.66*/.ApplicationController.signIn),format.raw/*26.95*/("""">"""),_display_(/*26.98*/Messages("sign.in.now")),format.raw/*26.121*/("""</a></p>
            </div>
        """)))}),format.raw/*28.10*/("""
    """),format.raw/*29.5*/("""</fieldset>
""")))}),format.raw/*30.2*/("""
"""))
      }
    }
  }

  def render(signInForm:Form[forms.SignUpForm.Data],request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(signInForm)(request,messages)

  def f:((Form[forms.SignUpForm.Data]) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (signInForm) => (request,messages) => apply(signInForm)(request,messages)

  def ref: this.type = this

}


}

/**/
object signUp extends signUp_Scope0.signUp
              /*
                  -- GENERATED --
                  DATE: Tue Mar 28 21:22:51 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/signUp.scala.html
                  HASH: 5dc47c85253b2bb532d1d020cb05debb86f405ee
                  MATRIX: 573->1|795->95|825->135|853->138|892->169|931->171|963->178|978->185|1009->208|1055->217|1091->227|1281->391|1318->408|1355->419|1378->422|1415->432|1458->445|1491->451|1580->513|1628->540|1675->560|1690->566|1747->614|1787->616|1829->631|1844->637|1880->652|1922->667|1933->669|2101->815|2143->830|2154->832|2319->975|2361->990|2372->992|2526->1124|2568->1139|2579->1141|2746->1286|2788->1300|2976->1460|3017->1479|3158->1593|3207->1621|3236->1622|3273->1632|3288->1638|3338->1667|3368->1670|3413->1693|3483->1732|3516->1738|3560->1752
                  LINES: 20->1|25->1|27->4|28->5|28->5|28->5|29->6|29->6|29->6|29->6|30->7|32->9|32->9|32->9|32->9|33->10|34->11|35->12|36->13|36->13|37->14|37->14|37->14|37->14|38->15|38->15|38->15|39->16|39->16|39->16|40->17|40->17|40->17|41->18|41->18|41->18|42->19|42->19|42->19|43->20|45->22|45->22|49->26|49->26|49->26|49->26|49->26|49->26|49->26|49->26|51->28|52->29|53->30
                  -- GENERATED --
              */
          