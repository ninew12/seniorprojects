
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object signIn_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class signIn extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Form[forms.SignInForm.Data],com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry,RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(signInForm: Form[forms.SignInForm.Data], socialProviders: com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry)(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import com.mohiva.play.silhouette.impl.providers.oauth2.ClefProvider
import b3.inline.fieldConstructor

Seq[Any](format.raw/*1.179*/("""

"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/main(Messages("sign.in.title"))/*6.33*/ {_display_(Seq[Any](format.raw/*6.35*/("""
    """),_display_(/*7.6*/request/*7.13*/.flash.get("error").map/*7.36*/ { msg =>_display_(Seq[Any](format.raw/*7.45*/("""
        """),format.raw/*8.9*/("""<div class="col-md-6 col-md-offset-3 alert alert-danger alert-error">
            <a href="#" class="close" data-dismiss="alert">&times;</a>
            <strong>"""),_display_(/*10.22*/Messages("error")),format.raw/*10.39*/("""</strong> """),_display_(/*10.50*/msg),format.raw/*10.53*/("""
        """),format.raw/*11.9*/("""</div>
    """)))}),format.raw/*12.6*/("""
    """),format.raw/*13.5*/("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""),_display_(/*14.18*/Messages("sign.in.credentials")),format.raw/*14.49*/("""</legend>
        """),_display_(/*15.10*/helper/*15.16*/.form(action = routes.CredentialsAuthController.authenticate())/*15.79*/ {_display_(Seq[Any](format.raw/*15.81*/("""
            """),_display_(/*16.14*/helper/*16.20*/.CSRF.formField),format.raw/*16.35*/("""
            """),_display_(/*17.14*/b3/*17.16*/.email(signInForm("email"), '_hiddenLabel -> Messages("email"), 'placeholder -> Messages("email"), 'class -> "form-control input-lg")),format.raw/*17.149*/("""
            """),_display_(/*18.14*/b3/*18.16*/.password(signInForm("password"), '_hiddenLabel -> Messages("password"), 'placeholder -> Messages("password"), 'class -> "form-control input-lg")),format.raw/*18.161*/("""
            """),_display_(/*19.14*/b3/*19.16*/.checkbox(signInForm("rememberMe"), '_text -> Messages("remember.me"), 'checked -> true)),format.raw/*19.104*/("""
            """),format.raw/*20.13*/("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*22.112*/Messages("sign.in")),format.raw/*22.131*/("""</button>
                </div>
            </div>
        """)))}),format.raw/*25.10*/("""

        """),format.raw/*27.9*/("""<div>
            <p class="not-a-member">"""),_display_(/*28.38*/Messages("not.a.member")),format.raw/*28.62*/(""" """),format.raw/*28.63*/("""<a href=""""),_display_(/*28.73*/routes/*28.79*/.ApplicationController.signUp),format.raw/*28.108*/("""">"""),_display_(/*28.111*/Messages("sign.up.now")),format.raw/*28.134*/("""</a></p>
        </div>

        """),_display_(/*31.10*/if(socialProviders.providers.nonEmpty)/*31.48*/ {_display_(Seq[Any](format.raw/*31.50*/("""
            """),format.raw/*32.13*/("""<div class="social-providers">
                <p>"""),_display_(/*33.21*/Messages("or.use.social")),format.raw/*33.46*/("""</p>
                <div>
                """),_display_(/*35.18*/for(p <- socialProviders.providers if p.id != "clef") yield /*35.71*/ {_display_(Seq[Any](format.raw/*35.73*/("""
                    """),format.raw/*36.21*/("""<a href=""""),_display_(/*36.31*/routes/*36.37*/.SocialAuthController.authenticate(p.id)),format.raw/*36.77*/("""" class="provider """),_display_(/*36.96*/p/*36.97*/.id),format.raw/*36.100*/("""" title=""""),_display_(/*36.110*/Messages(p.id)),format.raw/*36.124*/(""""><img src=""""),_display_(/*36.137*/routes/*36.143*/.Assets.at(s"images/providers/${p.id}.png")),format.raw/*36.186*/("""" width="64px" height="64px" alt=""""),_display_(/*36.221*/Messages(p.id)),format.raw/*36.235*/(""""></a>
                """)))}),format.raw/*37.18*/("""
                """),format.raw/*38.17*/("""</div>
                """),_display_(/*39.18*/defining(socialProviders.get[ClefProvider])/*39.61*/ { clef =>_display_(Seq[Any](format.raw/*39.71*/("""
                    """),_display_(/*40.22*/if(clef.isDefined)/*40.40*/ {_display_(Seq[Any](format.raw/*40.42*/("""
                        """),format.raw/*41.25*/("""<script type="text/javascript" src="https://clef.io/v3/clef.js" class="clef-button" data-app-id=""""),_display_(/*41.123*/clef/*41.127*/.get.settings.clientID),format.raw/*41.149*/("""" data-color="blue" data-style="flat" data-redirect-url=""""),_display_(/*41.207*/clef/*41.211*/.get.settings.redirectURL),format.raw/*41.236*/("""" data-type="login"></script>
                    """)))}),format.raw/*42.22*/("""
                """)))}),format.raw/*43.18*/("""
            """),format.raw/*44.13*/("""</div>
        """)))}),format.raw/*45.10*/("""

    """),format.raw/*47.5*/("""</fieldset>
""")))}),format.raw/*48.2*/("""
"""))
      }
    }
  }

  def render(signInForm:Form[forms.SignInForm.Data],socialProviders:com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry,request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(signInForm,socialProviders)(request,messages)

  def f:((Form[forms.SignInForm.Data],com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (signInForm,socialProviders) => (request,messages) => apply(signInForm,socialProviders)(request,messages)

  def ref: this.type = this

}


}

/**/
object signIn extends signIn_Scope0.signIn
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 21:44:07 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/signIn.scala.html
                  HASH: bb66516e4f6804c08546f29ae4c497f51ac7ca34
                  MATRIX: 638->1|1013->178|1043->289|1071->292|1110->323|1149->325|1181->332|1196->339|1227->362|1273->371|1309->381|1500->545|1538->562|1576->573|1600->576|1637->586|1680->599|1713->605|1802->667|1854->698|1901->718|1916->724|1988->787|2028->789|2070->804|2085->810|2121->825|2163->840|2174->842|2329->975|2371->990|2382->992|2549->1137|2591->1152|2602->1154|2712->1242|2754->1256|2942->1416|2983->1435|3078->1499|3117->1511|3188->1555|3233->1579|3262->1580|3299->1590|3314->1596|3365->1625|3396->1628|3441->1651|3505->1688|3552->1726|3592->1728|3634->1742|3713->1794|3759->1819|3832->1865|3901->1918|3941->1920|3991->1942|4028->1952|4043->1958|4104->1998|4150->2017|4160->2018|4185->2021|4223->2031|4259->2045|4300->2058|4316->2064|4381->2107|4444->2142|4480->2156|4536->2181|4582->2199|4634->2224|4686->2267|4734->2277|4784->2300|4811->2318|4851->2320|4905->2346|5031->2444|5045->2448|5089->2470|5175->2528|5189->2532|5236->2557|5319->2609|5369->2628|5411->2642|5459->2659|5494->2667|5538->2681
                  LINES: 20->1|26->1|28->5|29->6|29->6|29->6|30->7|30->7|30->7|30->7|31->8|33->10|33->10|33->10|33->10|34->11|35->12|36->13|37->14|37->14|38->15|38->15|38->15|38->15|39->16|39->16|39->16|40->17|40->17|40->17|41->18|41->18|41->18|42->19|42->19|42->19|43->20|45->22|45->22|48->25|50->27|51->28|51->28|51->28|51->28|51->28|51->28|51->28|51->28|54->31|54->31|54->31|55->32|56->33|56->33|58->35|58->35|58->35|59->36|59->36|59->36|59->36|59->36|59->36|59->36|59->36|59->36|59->36|59->36|59->36|59->36|59->36|60->37|61->38|62->39|62->39|62->39|63->40|63->40|63->40|64->41|64->41|64->41|64->41|64->41|64->41|64->41|65->42|66->43|67->44|68->45|70->47|71->48
                  -- GENERATED --
              */
          