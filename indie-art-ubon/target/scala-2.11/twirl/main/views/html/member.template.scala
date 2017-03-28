
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object member_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class member extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Seq[models.DBUser],models.User,RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(users : Seq[models.DBUser],user: models.User)(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.101*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
"""),_display_(/*4.2*/main(Messages("home.title"), Some(user))/*4.42*/{_display_(Seq[Any](format.raw/*4.43*/("""
  """),format.raw/*5.3*/("""<br><br>
  <div class="container">
      <div class="inner">
           <div class="mt mb ">
              <h3><i class="fa fa-users" aria-hidden="true"></i> USERS</h3>
          </div>
          <div class="panel panel-info">
             <div class="panel-body">
        <div class="row">
          <div class="col-md-12">
              <ul class="breadcrumb">
                  <li>
                      <i class="fa fa-trophy" aria-hidden="true"></i><a href="#"> Top User</a>
                  </li>
              </ul>
          </div>
          <!--shoe user-->

             <div class=" col-sm-2" >
                <div class="box2">
                       <a  class="image fit"><img src="assets/images/back3.jpg" alt="" width="300" height="150" /></a>
                    <div class="inner">
                       <a href=""><h5>Wasan</h5></a>
                       <a href="/selectModel" class="button fit btn-sm" ><i class="fa fa-plus" aria-hidden="true"></i> Follow</a>
                   </div>
                 </div>
             </div>

             <div class="col-md-12">
                 <ul class="breadcrumb">
                     <li>
                        <i class="fa fa-users" aria-hidden="true"></i><a href="#"> All User</a>
                     </li>
                 </ul>
             </div>
             """),_display_(/*40.15*/for(user
               <- users) yield /*41.25*/{_display_(Seq[Any](format.raw/*41.26*/("""
           """),format.raw/*42.12*/("""<div class=" col-sm-2">
               <div class="box2">
                       <a  class="image fit"><img src="assets/images/user2.jpg" alt="" width="300" height="150" /></a>
                  <div class="inner">
                   <a href="/profile"><h5>"""),_display_(/*46.44*/user/*46.48*/.fullName),format.raw/*46.57*/("""</h5></a>
                      <a href="#" class="button fit btn-sm" ><i class="fa fa-plus" aria-hidden="true"></i> Follow</a>
                 </div>
               </div>
            </div><!--col-sm2-2-->
             """)))}),format.raw/*51.15*/("""
          """),format.raw/*52.11*/("""</div><!--row-->
        </div><!--inner-->
      </div><!--container-->
    </div>
  </div>

""")))}),format.raw/*58.2*/("""
"""))
      }
    }
  }

  def render(users:Seq[models.DBUser],user:models.User,request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(users,user)(request,messages)

  def f:((Seq[models.DBUser],models.User) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (users,user) => (request,messages) => apply(users,user)(request,messages)

  def ref: this.type = this

}


}

/**/
object member extends member_Scope0.member
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 21:44:07 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/member.scala.html
                  HASH: e5528ceaafacea0e35040ae2ff702f9b667d5908
                  MATRIX: 576->1|771->100|801->104|844->122|892->162|930->163|960->167|2362->1542|2412->1576|2451->1577|2492->1590|2781->1852|2794->1856|2824->1865|3083->2093|3123->2105|3254->2206
                  LINES: 20->1|25->1|27->3|28->4|28->4|28->4|29->5|64->40|65->41|65->41|66->42|70->46|70->46|70->46|75->51|76->52|82->58
                  -- GENERATED --
              */
          