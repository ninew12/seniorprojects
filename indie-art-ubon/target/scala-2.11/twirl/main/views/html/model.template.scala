
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object model_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class model extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[models.User,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: models.User)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
"""),_display_(/*3.2*/main(Messages("home.title"))/*3.30*/{_display_(Seq[Any](format.raw/*3.31*/("""

"""),format.raw/*5.1*/("""<div class="container">
          <br><br>
           <h3><i class="fa fa-cubes" aria-hidden="true"></i> The 3D Model </h3>
           <div class="thumbnails">
               <div class="box">
                   <a  class="image fit"><img src="assets/images/model/car.png" alt="" width="600" height="200"/></a>
               <div class="text-left">
                   <a href="#"><i class="fa fa-eye" aria-hidden="true"></i> 1</a>
                   <a href="#"><i class="fa fa-comments" aria-hidden="true"></i> 2</a>
                   <a href="#"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i> 5</a>
               </div>
              <div class="inner">
                   <h5>Car model 3d</h5>
                    <a href="/selectmodel" class="button fit" ><i class="fa fa-eye" aria-hidden="true"></i> Watch</a>
              </div>
            </div>

            <div class="box">
                   <a class="image fit"><img src="assets/images/model/jagun.png" alt="" width="600" height="200"/></a>
              <div class="text-left">
                   <a href="#"><i class="fa fa-eye" aria-hidden="true"></i> 2</a>
                   <a href="#"><i class="fa fa-comments" aria-hidden="true"></i> 2</a>
                   <a href="#"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i> 3</a>
              </div>
            <div class="inner">
                  <h5>Vase model 3d </h5>
                  <a href="/selectmodel" class="button style2 fit" ><i class="fa fa-eye" aria-hidden="true"></i> Watch</a>
                </div>
            </div>

            <div class="box">
                   <a class="image fit"><img src="assets/images/model/king.png" alt="" width="600" height="200"/></a>
              <div class="text-left">
                   <a href="#"><i class="fa fa-eye" aria-hidden="true"></i> 3</a>
                   <a href="#"><i class="fa fa-comments" aria-hidden="true"></i> 2</a>
                   <a href="#"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i> 2</a>
              </div>
              <div class="inner">
                   <h5>Monkey model 3d</h5>
                   <a href="/selectmodel" class="button style3 fit" > <i class="fa fa-eye" aria-hidden="true"></i> Watch</a>
              </div>
            </div>
          </div>
         </div><!--thumbnails-->

      <nav aria-label="...">
           <ul class="pager">
              <li><a href="#">Discover More </a></li>
        </ul>
     </nav>
""")))}),format.raw/*55.2*/("""
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
object model extends model_Scope0.model
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 21:44:07 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/model.scala.html
                  HASH: bee50b86184ed28b445bc4a2f73ea77b300c4e20
                  MATRIX: 541->1|684->49|712->51|755->69|791->97|829->98|859->102|3411->2624
                  LINES: 20->1|25->1|26->2|27->3|27->3|27->3|29->5|79->55
                  -- GENERATED --
              */
          