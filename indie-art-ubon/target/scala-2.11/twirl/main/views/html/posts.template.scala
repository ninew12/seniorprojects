
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object posts_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class posts extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[models.User,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: models.User)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*2.1*/("""<!-- dbforuminfo : Seq[models.Foruminfo] -->
<!DOCTYPE html>
"""),_display_(/*4.2*/main(Messages("home.title"))/*4.30*/{_display_(Seq[Any](format.raw/*4.31*/("""

  """),format.raw/*6.3*/("""<div class="container">
      <h3><i class="fa fa-list-alt" aria-hidden="true"></i> Blender Artists Community</h3>
      <h5>   Welcome to the Blender Artists Community.</h5>
    <div class="panel panel-info">
       <div class="panel-body">
              <div class="container">
                  <div class="row">
                      <div class="col-md-11">
                          <ul class="breadcrumb">
                              <li>
                                  <i class="fa fa-list-alt" aria-hidden="true"></i><a href="#"> General Forums</a>
                              </li>
                          </ul>
                      </div>
                  </div>
             </div>

          <div class="section">
              <div class="container">
                  <div class="row">
                      <div class="col-md-11">
                          <table class="table  table-filte ">
                              <tbody>

                                  <tr>
                                      <td>
                                        <img src="assets/images/user.png" class="img-circle" width="60">
                                      </td>
                                      <td>
                                          <h5>
                                              <b>Blend4web</b>
                                          </h5>
                                          <h6><i class="fa fa-user" aria-hidden="true"></i> by kamonwan</h6>
                                      </td>
                                      <td>
                                          <h5>
                                              <b>การใช้งานเบื้องต้น</b>
                                          </h5>
                                      </td>
                                      <td><h5><i class="fa fa-calendar" aria-hidden="true"></i> 23/01/2560</h5></td>
                                      <td>
                                          <div class="btn-group">
                                            <a href="/selectposts "><button class="btn btn-warning" value="right" type="button" >Read More
                                                <i class="fa fa-fw fa-arrow-right"></i></button></a>
                                          </div>
                                      </td>
                                  </tr>

                                  <tr>
                                      <td>
                                        <img src="assets/images/user.png" class="img-circle" width="60">
                                      </td>
                                      <td>
                                          <h5>
                                              <b>Simple Scene </b>
                                          </h5>
                                          <h6><i class="fa fa-user" aria-hidden="true"></i> by kamonwan</h6>
                                      </td>
                                      <td>
                                          <h5>
                                              <b>Simple Scene with Blend4Web</b>
                                          </h5>
                                      </td>
                                        <td><h5><i class="fa fa-calendar" aria-hidden="true"></i> 26/01/2560</h5></td>
                                      <td>
                                          <div class="btn-group">
                                            <a href="/selectposts "><button class="btn btn-warning" value="right" type="button" >Read More
                                                <i class="fa fa-fw fa-arrow-right"></i></button></a>
                                          </div>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>
                                        <img src="assets/images/user.png" class="img-circle" width="60">
                                      </td>
                                      <td>
                                          <h5>
                                              <b>Using Shader Nodes </b>
                                          </h5>
                                          <h6><i class="fa fa-user" aria-hidden="true"></i> by kamonwan</h6>
                                      </td>
                                      <td>
                                          <h5>
                                              <b>Creating Blend4Web Materials </b>
                                          </h5>
                                      </td>
                                        <td><h5><i class="fa fa-calendar" aria-hidden="true"></i> 27/01/2560</h5></td>
                                      <td>
                                          <div class="btn-group">
                                            <a href="/selectposts "><button class="btn btn-warning" value="right" type="button" >Read More
                                                <i class="fa fa-fw fa-arrow-right"></i></button></a>
                                          </div>
                                      </td>
                                  </tr>
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>
          </div>
          <hr>
          <div class="container ">
          <nav aria-label="Page navigation">
             <ul class="pagination pagination-sm ">
              <li>
                  <a href="#" aria-label="Previous">
                 <span aria-hidden="true">&laquo;</span>
                 </a>
             </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>

             <li>
                 <a href="#" aria-label="Next">
                 <span aria-hidden="true">&raquo;</span>
              </a>
             </li>
           </ul>
         </nav>
        </div><!-- container -->
      </div><!-- panal-body -->
    </div><!-- panal -->
  </div><!-- container -->

""")))}),format.raw/*131.2*/("""
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
object posts extends posts_Scope0.posts
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 21:44:07 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/posts.scala.html
                  HASH: cfba5b5975cb4a4e137a54bdbba8cae2c8d73f42
                  MATRIX: 541->1|684->49|712->51|801->115|837->143|875->144|907->150|7300->6512
                  LINES: 20->1|25->1|26->2|28->4|28->4|28->4|30->6|155->131
                  -- GENERATED --
              */
          