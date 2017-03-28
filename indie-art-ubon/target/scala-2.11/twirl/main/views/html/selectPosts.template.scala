
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object selectPosts_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class selectPosts extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Form[forms.CommentForm.Data],Seq[models.Foruminfo],Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(Forms: Form[forms.CommentForm.Data],dbforuminfo : Seq[models.Foruminfo])(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.104*/("""
"""),format.raw/*2.1*/("""<!-- , dbcomment : Seq[models.Comment] -->
<!DOCTYPE html>
"""),_display_(/*4.2*/main(Messages("home.title"))/*4.30*/{_display_(Seq[Any](format.raw/*4.31*/("""
   """),format.raw/*5.4*/("""<body>
     <div class="container">
            <br><br><br>
               <div class="panel panel-info">
                  <div class="panel-body">
                    <div class="container">
                      <div class="row">
                            <div class="col-sm-3  ">
                                <ul class="breadcrumb">
                                <li>
                                    <img src="assets/images/user.png" class="img-circle" width="80">
                                    <br>
                                    <a href="#"><i class="fa fa-user" aria-hidden="true"></i> by kamonwan</a>
                                </li>
                                    <span> <button class="btn btn-info btn-sm " ><i class="fa fa-plus" aria-hidden="true"></i>  FOLLOW</button></span>
                                    <br><a><i class="fa fa-calendar" aria-hidden="true"></i> 26/01/2560</a>
                                    <br><a><i class="fa fa-clock-o" aria-hidden="true"></i> 15:50 น.</a>
                                    <br><a href="#"><i class="fa fa-eye" aria-hidden="true"></i>  2 </a>
                                    <br>
                                    <a href="#"><i class="fa fa-tag" aria-hidden="true"></i> Other</a>

                                </ul>
                             </div>

                        <div class="col-sm-8  ">
                          """),_display_(/*30.28*/for(foruminfo
                            <- dbforuminfo) yield /*31.44*/{_display_(Seq[Any](format.raw/*31.45*/("""
                                """),format.raw/*32.33*/("""<h3>"""),_display_(/*32.38*/foruminfo/*32.47*/.title),format.raw/*32.53*/("""</h3>
                                <hr>
                             <!--upload image-->
                              <img src= """"),_display_(/*35.43*/foruminfo/*35.52*/.imagepost),format.raw/*35.62*/("""" class="img-responsive" width="600">

                            <!--add Description -->
                             <h5> """),_display_(/*38.36*/foruminfo/*38.45*/.detail),format.raw/*38.52*/("""</h5>

                             <!--video upload-->
                                <h5>Simple Scene with Blend4Web (with subtitles)</h5>
                               <div class="embed-responsive embed-responsive-16by9" >

                                 <iframe class="embed-responsive-item" src=""""),_display_(/*44.78*/foruminfo/*44.87*/.vdopost),format.raw/*44.95*/("""" style="border:none;"></iframe>

                               </div>
                             """)))}),format.raw/*47.31*/("""
                              """),format.raw/*48.31*/("""<br>
                             <div class="row">
                                            <h5><span class="badge">2</span> Comment </h5>
                                            <br>
                                            <div class="col-sm-1">
                                                     <img class="img-responsive user-photo" src="assets/images/user.png" >
                                            </div><!-- /col-sm-1 -->
                             <div class="col-sm-10">
                                           <form>
                                                <div class="form-group">

                                                     <textarea class="form-control" rows="5" placeholder="comment" name="detail"></textarea>
                                                    
                                               </div>
                                               <div class=" text-right" >
                                                    <button type="submit" class="btn btn-info  ">send</button>
                                                  </div>
                                              </form>
                                          </div>
                                    </div><!-- /row -->
                                    <br>
                            <div class="row">
                                   <div class="col-sm-1">
                                               <img class="img-responsive user-photo" src="assets/images/user.png" >
                                      </div><!-- /col-sm-1 -->
                                  <div class="col-sm-10">
                                       <div class="panel panel-default">
                                            <div class="panel-heading">
                                                  <strong>myusername</strong> <span class="text-muted">commented 5 days ago</span>
                                            </div>
                                     <div class="panel-body">
                                       <h5>Panel content</h5>
                                     </div><!-- /panel-body -->
                                   </div><!-- /panel panel-default -->
                                 </div><!-- /col-sm-10 -->
                               </div><!--row-->

                            <div class="row">
                                    <div class="col-sm-1">
                                            <img class="img-responsive user-photo" src="assets/images/user.png"  >
                                  </div><!-- /col-sm-1 -->
                            <div class="col-sm-10">
                                  <div class="panel panel-default">
                                     <div class="panel-heading">
                                              <strong>myusername</strong> <span class="text-muted">commented 5 days ago</span>
                                         </div>
                                     <div class="panel-body">
                                         <h5>Panel content</h5>
                                       </div><!-- /panel-body -->
                                      </div><!-- /panel panel-default -->
                                    </div><!-- /col-sm-10 -->
                                 </div><!--row-->
                              </div>   <!-- col-md-8 -->
                           </div>   <!-- row -->
                        </div><!-- container -->
                     </div><!-- panal-body -->
                   </div><!-- panal -->
                 </div><!-- container -->
         <!--link social-->

  </body>
""")))}),format.raw/*109.2*/("""
"""))
      }
    }
  }

  def render(Forms:Form[forms.CommentForm.Data],dbforuminfo:Seq[models.Foruminfo],messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(Forms,dbforuminfo)(messages)

  def f:((Form[forms.CommentForm.Data],Seq[models.Foruminfo]) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (Forms,dbforuminfo) => (messages) => apply(Forms,dbforuminfo)(messages)

  def ref: this.type = this

}


}

/**/
object selectPosts extends selectPosts_Scope0.selectPosts
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 21:44:07 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/selectPosts.scala.html
                  HASH: d3f992528bf07cbf6e9fe2c29b1ea843fbff1f7f
                  MATRIX: 592->1|790->103|818->105|905->167|941->195|979->196|1010->201|2497->1661|2571->1719|2610->1720|2672->1754|2704->1759|2722->1768|2749->1774|2913->1911|2931->1920|2962->1930|3118->2059|3136->2068|3164->2075|3503->2387|3521->2396|3550->2404|3686->2509|3746->2541|7533->6297
                  LINES: 20->1|25->1|26->2|28->4|28->4|28->4|29->5|54->30|55->31|55->31|56->32|56->32|56->32|56->32|59->35|59->35|59->35|62->38|62->38|62->38|68->44|68->44|68->44|71->47|72->48|133->109
                  -- GENERATED --
              */
          