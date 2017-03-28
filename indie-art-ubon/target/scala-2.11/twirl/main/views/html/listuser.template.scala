
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object listuser_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class listuser extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Seq[models.DBUser],RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(users : Seq[models.DBUser])(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.83*/("""

"""),_display_(/*3.2*/main("user")/*3.14*/{_display_(Seq[Any](format.raw/*3.15*/("""
  """),format.raw/*4.3*/("""<br><br><br>

     <div class="container">
          <h3>Member</h3>
          <div class="row data">
            <div id="wrap2">
          <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%" >
            <thead>
              <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Full Name</th>
                <th>Email</th>


                <th style="text-align: center;">Action</th>
              </tr>
            </thead>
            <tbody>
              """),_display_(/*23.16*/for(user
                <- users) yield /*24.26*/{_display_(Seq[Any](format.raw/*24.27*/(""" """),format.raw/*24.28*/("""<tr>
                  <td>"""),_display_(/*25.24*/user/*25.28*/.firstName),format.raw/*25.38*/("""</td>
                  <td>"""),_display_(/*26.24*/user/*26.28*/.lastName),format.raw/*26.37*/("""</td>
                  <td>"""),_display_(/*27.24*/user/*27.28*/.fullName),format.raw/*27.37*/("""</td>
                  <td>"""),_display_(/*28.24*/user/*28.28*/.email),format.raw/*28.34*/("""</td>

                  <td style="text-align: center;" class="col-md-2 col-sm-3">
                    <button name="edit" class="btn btn-sm btn-warning">Edit</button>
                    <button name="delete" class="btn btn-sm  btn btn-danger">Delete</button>
                  </td>
            </tr>
            """)))}),format.raw/*35.14*/("""
            """),format.raw/*36.13*/("""</tbody>
          </table>
        </div>
      </div>
  </div>

""")))}),format.raw/*42.2*/("""
"""))
      }
    }
  }

  def render(users:Seq[models.DBUser],request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(users)(request,messages)

  def f:((Seq[models.DBUser]) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (users) => (request,messages) => apply(users)(request,messages)

  def ref: this.type = this

}


}

/**/
object listuser extends listuser_Scope0.listuser
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 21:44:07 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/listuser.scala.html
                  HASH: d5319c5e2f9d78650ad07920da76e1bedc96b8b9
                  MATRIX: 568->1|744->82|774->87|794->99|832->100|862->104|1457->672|1508->707|1547->708|1576->709|1632->738|1645->742|1676->752|1733->782|1746->786|1776->795|1833->825|1846->829|1876->838|1933->868|1946->872|1973->878|2328->1202|2370->1216|2473->1289
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|47->23|48->24|48->24|48->24|49->25|49->25|49->25|50->26|50->26|50->26|51->27|51->27|51->27|52->28|52->28|52->28|59->35|60->36|66->42
                  -- GENERATED --
              */
          