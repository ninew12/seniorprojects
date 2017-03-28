
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object showposts_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class showposts extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Seq[models.Foruminfo],models.User,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(dbforuminfo : Seq[models.Foruminfo],user: models.User)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
"""),_display_(/*3.2*/main(Messages("home.title"), Some(user))/*3.42*/{_display_(Seq[Any](format.raw/*3.43*/("""
   """),format.raw/*4.4*/("""<body>
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
                          """),_display_(/*29.28*/for(foruminfo
                            <- dbforuminfo) yield /*30.44*/{_display_(Seq[Any](format.raw/*30.45*/("""
                                """),format.raw/*31.33*/("""<h3>"""),_display_(/*31.38*/foruminfo/*31.47*/.title),format.raw/*31.53*/("""</h3>
                                <hr>
                             <!--upload image-->
                              <img src= """"),_display_(/*34.43*/foruminfo/*34.52*/.imagepost),format.raw/*34.62*/("""" class="img-responsive" width="600">

                            <!--add Description -->
                             <h5> """),_display_(/*37.36*/foruminfo/*37.45*/.detail),format.raw/*37.52*/("""</h5>

                             <!--video upload-->
                                <h5>Simple Scene with Blend4Web (with subtitles)</h5>
                               <div class="embed-responsive embed-responsive-16by9" >

                                 <iframe class="embed-responsive-item" src=""""),_display_(/*43.78*/foruminfo/*43.87*/.vdopost),format.raw/*43.95*/("""" style="border:none;"></iframe>

                               </div>
                             """)))}),format.raw/*46.31*/("""
                              """),format.raw/*47.31*/("""<br>
                             <div class="row">
                                            <h5><span class="badge">2</span> Comment </h5>
                                            <br>
                                            <div class="col-sm-1">
                                                     <img class="img-responsive user-photo" src="assets/images/user.png" >
                                            </div><!-- /col-sm-1 -->
                             <div class="col-sm-10">
                                           <form>
                                                <div class="form-group">
                                                     <textarea class="form-control" rows="5" placeholder="comment"></textarea>
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
""")))}),format.raw/*106.2*/("""
"""))
      }
    }
  }

  def render(dbforuminfo:Seq[models.Foruminfo],user:models.User,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(dbforuminfo,user)(messages)

  def f:((Seq[models.Foruminfo],models.User) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (dbforuminfo,user) => (messages) => apply(dbforuminfo,user)(messages)

  def ref: this.type = this

}


}

/**/
object showposts extends showposts_Scope0.showposts
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 21:44:07 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/showposts.scala.html
                  HASH: 4d26ce922f28f6f9b0bb16cb870ac38fde3b320d
                  MATRIX: 571->1|750->85|778->87|821->105|869->145|907->146|938->151|2425->1611|2499->1669|2538->1670|2600->1704|2632->1709|2650->1718|2677->1724|2841->1861|2859->1870|2890->1880|3046->2009|3064->2018|3092->2025|3431->2337|3449->2346|3478->2354|3614->2459|3674->2491|7391->6177
                  LINES: 20->1|25->1|26->2|27->3|27->3|27->3|28->4|53->29|54->30|54->30|55->31|55->31|55->31|55->31|58->34|58->34|58->34|61->37|61->37|61->37|67->43|67->43|67->43|70->46|71->47|130->106
                  -- GENERATED --
              */
          