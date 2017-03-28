
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

class selectPosts extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Form[forms.CommentForm.Data],Seq[models.Foruminfo],Seq[models.Comment],RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(Forms: Form[forms.CommentForm.Data],dbforuminfo : Seq[models.Foruminfo], dbcommemt : Seq[models.Comment])(implicit request: RequestHeader , messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import b3.inline.fieldConstructor

Seq[Any](format.raw/*1.162*/("""
"""),format.raw/*2.1*/("""<!-- , dbcomment : Seq[models.Comment] -->
<!DOCTYPE html>
"""),_display_(/*5.2*/main(Messages("home.title"))/*5.30*/{_display_(Seq[Any](format.raw/*5.31*/("""
   """),format.raw/*6.4*/("""<body>
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
                          """),_display_(/*31.28*/for(foruminfo
                            <- dbforuminfo) yield /*32.44*/{_display_(Seq[Any](format.raw/*32.45*/("""
                                """),format.raw/*33.33*/("""<h3>"""),_display_(/*33.38*/foruminfo/*33.47*/.title),format.raw/*33.53*/("""</h3>
                                <hr>
                             <!--upload image-->
                              <img src= """"),_display_(/*36.43*/foruminfo/*36.52*/.imagepost),format.raw/*36.62*/("""" class="img-responsive" width="600">

                            <!--add Description -->
                             <h5> """),_display_(/*39.36*/foruminfo/*39.45*/.detail),format.raw/*39.52*/("""</h5>

                             <!--video upload-->

                               <div class="embed-responsive embed-responsive-16by9" >

                                 <iframe class="embed-responsive-item" src=""""),_display_(/*45.78*/foruminfo/*45.87*/.vdopost),format.raw/*45.95*/("""" style="border:none;"></iframe>

                               </div>
                             """)))}),format.raw/*48.31*/("""
                              """),format.raw/*49.31*/("""<br>
                             <div class="row">
                                            <h5><span class="badge">2</span> Comment </h5>
                                            <br>
                                            <div class="col-sm-1">
                                                     <img class="img-responsive user-photo" src="assets/images/user.png" >
                                            </div><!-- /col-sm-1 -->
                             <div class="col-sm-10">
                               """),_display_(/*57.33*/helper/*57.39*/.form(action = routes.IndieApplication.comment())/*57.88*/ {_display_(Seq[Any](format.raw/*57.90*/("""
                                   """),_display_(/*58.37*/helper/*58.43*/.CSRF.formField),format.raw/*58.58*/("""
                                                 """),_display_(/*59.51*/b3/*59.53*/.textarea( Forms("detail"), '_label -> "Comment" ,'rows -> 3 )),format.raw/*59.115*/("""
                                               """),format.raw/*60.48*/("""<div class=" text-right" >
                                                    <button type="submit" class="btn btn-info  ">send</button>
                                                  </div>
                                            """)))}),format.raw/*63.46*/("""
                                          """),format.raw/*64.43*/("""</div>
                                    </div><!-- /row -->
                                    <br>
                            <div class="row">
                              """),_display_(/*68.32*/for(comment
                                <- dbcommemt) yield /*69.46*/{_display_(Seq[Any](format.raw/*69.47*/("""
                                   """),format.raw/*70.36*/("""<div class="col-sm-1">
                                               <img class="img-responsive user-photo" src="assets/images/user.png" >
                                      </div><!-- /col-sm-1 -->

                                  <div class="col-sm-10">
                                       <div class="panel panel-default">
                                            <div class="panel-heading">
                                                  <strong>myusername</strong> <span class="text-muted">commented 5 days ago</span>
                                            </div>
                                     <div class="panel-body">
                                       <h5>"""),_display_(/*80.45*/comment/*80.52*/.detail),format.raw/*80.59*/("""</h5>
                                     </div><!-- /panel-body -->
                                   </div><!-- /panel panel-default -->
                                 </div><!-- /col-sm-10 -->
                               """)))}),format.raw/*84.33*/("""
                               """),format.raw/*85.32*/("""</div><!--row-->
                              </div>   <!-- col-md-8 -->
                           </div>   <!-- row -->
                        </div><!-- container -->
                     </div><!-- panal-body -->
                   </div><!-- panal -->
                 </div><!-- container -->
         <!--link social-->

  </body>
""")))}),format.raw/*95.2*/("""
"""))
      }
    }
  }

  def render(Forms:Form[forms.CommentForm.Data],dbforuminfo:Seq[models.Foruminfo],dbcommemt:Seq[models.Comment],request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(Forms,dbforuminfo,dbcommemt)(request,messages)

  def f:((Form[forms.CommentForm.Data],Seq[models.Foruminfo],Seq[models.Comment]) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (Forms,dbforuminfo,dbcommemt) => (request,messages) => apply(Forms,dbforuminfo,dbcommemt)(request,messages)

  def ref: this.type = this

}


}

/**/
object selectPosts extends selectPosts_Scope0.selectPosts
              /*
                  -- GENERATED --
                  DATE: Tue Mar 28 21:22:50 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/selectPosts.scala.html
                  HASH: 00d3f2ec5a93b25ca65a6349cb13e39a29110424
                  MATRIX: 626->1|915->161|943->163|1030->261|1066->289|1104->290|1135->295|2622->1755|2696->1813|2735->1814|2797->1848|2829->1853|2847->1862|2874->1868|3038->2005|3056->2014|3087->2024|3243->2153|3261->2162|3289->2169|3543->2396|3561->2405|3590->2413|3726->2518|3786->2550|4357->3094|4372->3100|4430->3149|4470->3151|4535->3189|4550->3195|4586->3210|4665->3262|4676->3264|4760->3326|4837->3375|5111->3618|5183->3662|5395->3847|5469->3905|5508->3906|5573->3943|6305->4648|6321->4655|6349->4662|6616->4898|6677->4931|7058->5282
                  LINES: 20->1|25->1|26->2|28->5|28->5|28->5|29->6|54->31|55->32|55->32|56->33|56->33|56->33|56->33|59->36|59->36|59->36|62->39|62->39|62->39|68->45|68->45|68->45|71->48|72->49|80->57|80->57|80->57|80->57|81->58|81->58|81->58|82->59|82->59|82->59|83->60|86->63|87->64|91->68|92->69|92->69|93->70|103->80|103->80|103->80|107->84|108->85|118->95
                  -- GENERATED --
              */
          