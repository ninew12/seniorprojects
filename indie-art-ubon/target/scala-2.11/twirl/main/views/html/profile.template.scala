
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object profile_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class profile extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[models.User,Seq[models.DBUser],RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: models.User,users : Seq[models.DBUser])(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.101*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
"""),_display_(/*4.2*/main(Messages("home.title"), Some(user))/*4.42*/{_display_(Seq[Any](format.raw/*4.43*/("""
  """),format.raw/*5.3*/("""<br><br>
  <div class="container">
      <div class="col-sm-8 ">
          <h3><i class="fa fa-user" aria-hidden="true"></i> My Profile</h3>
      </div>

   <div class="col-sm-8 " >
          <ul class="breadcrumb">
              <li>
                    <i class="fa fa-folder-open" aria-hidden="true"></i><a href="#"> My Blend</a>
              </li>
          </ul>
            <!--show my model -->
               <div class=" col-sm-4">
                 <div class="box">
                     <a  class="image fit"><img src="assets/images/pic01.jpg" alt="" width="300" height="150"/></a>
                 <div class="inner">
                     <h5>Nascetur nunc varius commodo</h5>
                      <a href="/selectModel" class="button style2 fit" ><i class="fa fa-eye" aria-hidden="true"></i> Watch</a>
                 </div>
                </div>
              </div><!--col-sm4-->


     </div><!--col-sm-8-->
     <div id="land-widget" class="col-sm-4 list-group ">
       """),_display_(/*31.9*/for(user
         <- users) yield /*32.19*/{_display_(Seq[Any](format.raw/*32.20*/("""
            """),format.raw/*33.13*/("""<li  class=" list-group-item ">
                <img src= "assets/images/user.png" class="img-circle " width="70">
                <h5 class="list-group-item-heading"><i class="fa fa-user" aria-hidden="true"></i> """),_display_(/*35.100*/user/*35.104*/.fullName),format.raw/*35.113*/("""</h5>
                <div class="row overview ">
                  <div class="col-md-6 user-pad text-center">
                      <h5  style="color:#FF9933">FOLLOWERS</h5>
                      <a href="#"><h6>84</h6></a>
                  </div>
                  <div class="col-md-6 user-pad text-center">
                      <h5  style="color:#FF9933">FOLLOWING</h5>
                      <a href="#"><h6>56</h6></a>
                  </div>

              </div>
          </li>

          <li class="list-group-item">
                <h5 class="list-group-item-heading">About Me </h5>
                <h5><i class="fa fa-user" aria-hidden="true"></i> Name : """),_display_(/*51.75*/user/*51.79*/.fullName),format.raw/*51.88*/("""</h5>
                <h5><i class="fa fa-envelope" aria-hidden="true"></i> Email : """),_display_(/*52.80*/user/*52.84*/.email),format.raw/*52.90*/("""</h5>
                <h5><i class="fa fa-link" aria-hidden="true"></i> Website</h5>
                <h5><i class="fa fa-calendar" aria-hidden="true"></i> Date</h5>

                <a href="#"><i class="fa fa-tag" aria-hidden="true"></i></a>
          </li>
        """)))}),format.raw/*58.10*/("""
          """),format.raw/*59.11*/("""<li class="list-group-item">
                <a href="#"><h5 style="color:#FF9933">Edit Peofile</h5></a>
                <a data-toggle="modal" href="#modelpassword"><h5 style="color:#FF9933">Change Password</h5></a>

          </li>

       </div><!--col-md-4 list-group-->
  </div> <!--container-->

  <!--dialog edit password -->
            <div class="modal" id="modelpassword" role="dialog">
  	                <div class="modal-dialog">
                       <div class="modal-content">
                             <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                    <h3 style="color:#000" class="modal-title">Change Password</h3>
                              </div>
                      <div class="modal-body">
                           <div class="well">
                             <div class="form-group">
                                   <label style="color:#000" for="username" class="control-label"> Password</label>
                                   <input type="password" class="form-control" >
                             </div>
                             <div class="form-group">
                                   <label style="color:#000" for="username" class="control-label"> Confirm Password</label>
                                   <input type="password" class="form-control" >
                             </div>
                       </div>
                     </div>
                         <div class="modal-footer">
                                    <a href="#" data-dismiss="modal" class="btn">Close</a>
                                    <a href="#" class="btn btn-warning">Change Password</a>
                        </div>
                    </div>
                </div>
            </div>  <!--dialog edit password -->
""")))}),format.raw/*95.2*/("""
"""))
      }
    }
  }

  def render(user:models.User,users:Seq[models.DBUser],request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(user,users)(request,messages)

  def f:((models.User,Seq[models.DBUser]) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (user,users) => (request,messages) => apply(user,users)(request,messages)

  def ref: this.type = this

}


}

/**/
object profile extends profile_Scope0.profile
              /*
                  -- GENERATED --
                  DATE: Tue Mar 28 21:22:50 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/profile.scala.html
                  HASH: 72148275da9916bb3b24cb72ab25b6647e9387ae
                  MATRIX: 578->1|773->100|803->104|846->122|894->162|932->163|962->167|2007->1186|2051->1214|2090->1215|2132->1229|2376->1445|2390->1449|2421->1458|3135->2145|3148->2149|3178->2158|3291->2244|3304->2248|3331->2254|3636->2528|3676->2540|5652->4486
                  LINES: 20->1|25->1|27->3|28->4|28->4|28->4|29->5|55->31|56->32|56->32|57->33|59->35|59->35|59->35|75->51|75->51|75->51|76->52|76->52|76->52|82->58|83->59|119->95
                  -- GENERATED --
              */
          