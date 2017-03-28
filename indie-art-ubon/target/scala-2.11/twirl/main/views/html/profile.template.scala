
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

class profile extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[models.User,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: models.User)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
"""),_display_(/*3.2*/main(Messages("home.title"), Some(user))/*3.42*/{_display_(Seq[Any](format.raw/*3.43*/("""
  """),format.raw/*4.3*/("""<br><br>
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
            <li  class=" list-group-item ">
                <img src= "assets/images/user.png" class="img-circle " width="70">
                <h5 class="list-group-item-heading"><i class="fa fa-user" aria-hidden="true"></i> By name user</h5>
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
                <h5><i class="fa fa-user" aria-hidden="true"></i> Name</h5>
                <h5><i class="fa fa-envelope" aria-hidden="true"></i> Email</h5>
                <h5><i class="fa fa-link" aria-hidden="true"></i> Website</h5>
                <h5><i class="fa fa-calendar" aria-hidden="true"></i> Date</h5>

                <a href="#"><i class="fa fa-tag" aria-hidden="true"></i></a>
          </li>
          <li class="list-group-item">
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
""")))}),format.raw/*91.2*/("""
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
object profile extends profile_Scope0.profile
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 21:44:07 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/profile.scala.html
                  HASH: 6913447cf6abcca8298e3b392d5ae3531c7568b6
                  MATRIX: 545->1|688->49|716->51|759->69|807->109|845->110|875->114|5141->4350
                  LINES: 20->1|25->1|26->2|27->3|27->3|27->3|28->4|115->91
                  -- GENERATED --
              */
          