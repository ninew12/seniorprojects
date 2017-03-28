
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object collection_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class collection extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[models.User,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: models.User)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*2.1*/("""<!-- dbforuminfo : Seq[models.Foruminfo] -->
<!DOCTYPE html>
"""),_display_(/*4.2*/main(Messages("home.title"), Some(user))/*4.42*/{_display_(Seq[Any](format.raw/*4.43*/("""

  """),format.raw/*6.3*/("""<br><br>
  <div class="container">
      <div class="inner">
           <div class="mt mb ">
              <h3><i class="fa fa-folder-open" aria-hidden="true"></i> MY COLLECTIONS</h3>
          </div>
          <div class="panel panel-info">
             <div class="panel-body">
        <div class="row">
          <div class="col-md-12">
              <ul class="breadcrumb">
                  <li>
                      <i class="fa fa-plus-square" aria-hidden="true"></i><a href="#"> collection</a>
                  </li>
                      <li ><a  data-toggle="modal" href="#myModal"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></i>

              </ul>
          </div>
          <!--show collection-->
             <div class=" col-sm-3">
               <div class="box2">
                   <a  class="image fit"><img src="assets/images/pic01.jpg" alt="" width="300" height="150"/></a>
               <div class="inner">
                   <h5>Nascetur nunc varius commodo</h5>
                    <a href="/selectModel" class="button style3 fit" ><i class="fa fa-eye" aria-hidden="true"></i> Watch</a>
               </div>
              </div>
            </div><!--col-sm3-->
         </div><!--row-->
       </div><!--inner-->
     </div><!--container-->
   </div>
</div>

""")))}),format.raw/*40.2*/("""
"""),format.raw/*41.1*/("""<!--dialog edit -->
          <!-- <div class="modal" id="myModal" role="dialog">
	                <div class="modal-dialog">
                     <div class="modal-content">
                           <div class="modal-header">
                                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                  <h4 class="modal-title">Edit Collection</h4>
                            </div>
                    <div class="modal-body">
                         <div class="well">
                                  <label >Name</label>
                                  <input type="text" class="form-control"  name="text" value="" required="" placeholder="name collection">
                        <div class="form-group">
                                  <label >Description</label>
                                   <textarea class="form-control" rows="4" ></textarea>
                       </div>
                     </div>
                   </div>
                       <div class="modal-footer">
                                  <a href="#" data-dismiss="modal" class="btn">Close</a>
                                  <a href="#" class="btn btn-primary">Save changes</a>
                      </div>
                  </div>
              </div>
          </div> -->
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
object collection extends collection_Scope0.collection
              /*
                  -- GENERATED --
                  DATE: Tue Mar 28 21:22:50 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/collection.scala.html
                  HASH: 3ab5a1c259c2ad8dd47cc7eb4722d98023d1274a
                  MATRIX: 551->1|694->49|722->51|811->115|859->155|897->156|929->162|2300->1503|2329->1505
                  LINES: 20->1|25->1|26->2|28->4|28->4|28->4|30->6|64->40|65->41
                  -- GENERATED --
              */
          