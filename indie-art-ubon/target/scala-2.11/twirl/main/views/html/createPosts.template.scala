
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object createPosts_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class createPosts extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Form[forms.forumForm.Data],models.User,RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(forumForm: Form[forms.forumForm.Data],user: models.User)(implicit request: RequestHeader , messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import b3.inline.fieldConstructor

Seq[Any](format.raw/*1.113*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>

"""),_display_(/*5.2*/main(Messages("home.title"),Some(user))/*5.41*/{_display_(Seq[Any](format.raw/*5.42*/("""
  """),format.raw/*6.3*/("""<div class="container">
         <br><br><br>
              <div class="mt mb ">
                 <h3><i class="fa fa-pencil-square-o" aria-hidden="true"></i> CREATE POSTS</h3>
             </div>
               <div class="panel panel-info">
                  <div class="panel-body">
                    <div class="container">
                      <div class="row">
                       <div class="col-sm-1  ">
                       </div>
                        <div class="col-sm-8  ">
                         """),_display_(/*18.27*/helper/*18.33*/.form(action = routes.IndieApplication.forum())/*18.80*/ {_display_(Seq[Any](format.raw/*18.82*/("""
                             """),_display_(/*19.31*/helper/*19.37*/.CSRF.formField),format.raw/*19.52*/("""

                                """),format.raw/*21.33*/("""<h5 >หัวข้อกระทู้</h5>
                              
                               """),_display_(/*23.33*/b3/*23.35*/.text( forumForm("title"), '_label -> "Topic" )),format.raw/*23.82*/("""
                               """),_display_(/*24.33*/b3/*24.35*/.textarea( forumForm("detail"), '_label -> "details" )),format.raw/*24.89*/("""
                               """),_display_(/*25.33*/b3/*25.35*/.file( forumForm("imagepost"), '_label -> "File" )),format.raw/*25.85*/("""
                               """),_display_(/*26.33*/b3/*26.35*/.text( forumForm("vdopost"), '_label -> "Link", '_help -> "@@youtube" )),format.raw/*26.106*/("""

                              """),format.raw/*28.31*/("""<div class=" text-right">
                                <button type="submit" class="btn btn-primary">Submit</button> &nbsp; &nbsp;
                                <button type="submit" class="btn btn-danger">Cancel</button>
                              </div>

                          """)))}),format.raw/*33.28*/("""
                              """),format.raw/*34.31*/("""</div>   <!-- col-md-8 -->
                           </div>   <!-- row -->
                        </div><!-- container -->
                     </div><!-- panal-body -->
                   </div><!-- panal -->
                </div><!--inner-->

""")))}),format.raw/*41.2*/("""
"""))
      }
    }
  }

  def render(forumForm:Form[forms.forumForm.Data],user:models.User,request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(forumForm,user)(request,messages)

  def f:((Form[forms.forumForm.Data],models.User) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (forumForm,user) => (request,messages) => apply(forumForm,user)(request,messages)

  def ref: this.type = this

}


}

/**/
object createPosts extends createPosts_Scope0.createPosts
              /*
                  -- GENERATED --
                  DATE: Tue Mar 28 21:22:50 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/createPosts.scala.html
                  HASH: b5f35576779158678877bdbbed098867eedcc9e6
                  MATRIX: 594->1|834->112|862->114|907->170|954->209|992->210|1022->214|1584->749|1599->755|1655->802|1695->804|1754->836|1769->842|1805->857|1869->893|1984->981|1995->983|2063->1030|2124->1064|2135->1066|2210->1120|2271->1154|2282->1156|2353->1206|2414->1240|2425->1242|2518->1313|2580->1347|2908->1644|2968->1676|3254->1932
                  LINES: 20->1|25->1|26->2|28->5|28->5|28->5|29->6|41->18|41->18|41->18|41->18|42->19|42->19|42->19|44->21|46->23|46->23|46->23|47->24|47->24|47->24|48->25|48->25|48->25|49->26|49->26|49->26|51->28|56->33|57->34|64->41
                  -- GENERATED --
              */
          