
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object footer_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class footer extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[models.User,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: models.User)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
"""),_display_(/*3.2*/main("home")/*3.14*/{_display_(Seq[Any](format.raw/*3.15*/("""
  """),format.raw/*4.3*/("""<body>
    <br><br>
    <div id="social">
      <div class="row ">
        <div class="col-lg-1  col-lg-offset-4">
          <a href="https://www.facebook.com"><img src="assets/images/social/facebook.png" class="img-responsive"></a>
        </div>
        <div class="col-lg-1">
          <a href="https://plus.google.com"><img src="assets/images/social/google.png" class="img-responsive"></a>
        </div>
        <div class="col-lg-1">
          <a href="https://www.instagram.com"><img src="assets/images/social/instagram.png" class="img-responsive"></a>
        </div>
        <div class="col-lg-1">
          <a href= "https://www.twitter.com"><img src="assets/images/social/twitter.png" class="img-responsive"></a>
        </div>
        <div class="col-lg-1">
          <a href="https://www.pinterest.com"><img src="assets/images/social/pinterest.png" class="img-responsive"></a>
        </div>
      </div><!--/row -->
    </div><!-- #Custom Javascripts Links -->

    <div id="footerwrap">
      <div class="container "></div>
      <h5 class="text-center">Computer science At Ubon Ratchathani University </h5>
    </div><!--/footerwrap -->

  </body>
""")))}),format.raw/*32.2*/("""
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
object footer extends footer_Scope0.footer
              /*
                  -- GENERATED --
                  DATE: Tue Mar 28 21:22:50 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/footer.scala.html
                  HASH: 36a5266f9f99515a4d849359d98f93d561fe8ee9
                  MATRIX: 543->1|686->49|714->51|757->69|777->81|815->82|845->86|2067->1278
                  LINES: 20->1|25->1|26->2|27->3|27->3|27->3|28->4|56->32
                  -- GENERATED --
              */
          