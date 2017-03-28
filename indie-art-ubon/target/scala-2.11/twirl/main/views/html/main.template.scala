
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Option[models.User],Html,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, user: Option[models.User] = None)(content: Html)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.95*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png")),format.raw/*9.97*/("""">
        <title>"""),_display_(/*10.17*/title),format.raw/*10.22*/("""</title

        <link href="//fonts.googleapis.com/css?family=Roboto|Montserrat:400,700|Open+Sans:400,300,600" rel="stylesheet">
        <link href="//cdnjs.cloudflare.com/ajax/libs/ionicons/1.5.2/css/ionicons.min.css" rel="stylesheet">

        <link rel="stylesheet" href=""""),_display_(/*15.39*/routes/*15.45*/.WebJarAssets.at(WebJarAssets.locate("bootstrap-theme.min.css"))),format.raw/*15.109*/("""">

          <!-- Bootstrap core CSS -->
        <link rel="stylesheet"  href=""""),_display_(/*18.40*/routes/*18.46*/.Assets.at("styles/bootstrap.css")),format.raw/*18.80*/("""">
        <link rel="stylesheet"  href=""""),_display_(/*19.40*/routes/*19.46*/.Assets.at("font-awesome-4.7.0/css/font-awesome.min.css")),format.raw/*19.103*/("""">
        <link rel="stylesheet"  href=""""),_display_(/*20.40*/routes/*20.46*/.Assets.at("font-awesome-4.7.0/css/font-awesome.css")),format.raw/*20.99*/("""">
          <!-- Custom styles for this template -->
        <link rel="stylesheet"  href=""""),_display_(/*22.40*/routes/*22.46*/.Assets.at("styles/style.css")),format.raw/*22.76*/("""">
        <link rel="stylesheet"  href=""""),_display_(/*23.40*/routes/*23.46*/.Assets.at("styles/main.css")),format.raw/*23.75*/("""">
        <link rel="stylesheet"  href=""""),_display_(/*24.40*/routes/*24.46*/.Assets.at("styles/font-awesome.min.css")),format.raw/*24.87*/("""">

            <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->

    </head>
    <body>
        <header class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">"""),_display_(/*38.48*/Messages("toggle.navigation")),format.raw/*38.77*/("""</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href=""""),_display_(/*43.52*/routes/*43.58*/.ApplicationController.index),format.raw/*43.86*/("""">Indie Art Ubon</a>
                </div>
                <nav class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href=""""),_display_(/*47.39*/routes/*47.45*/.ApplicationController.index),format.raw/*47.73*/("""">"""),_display_(/*47.76*/Messages("home")),format.raw/*47.92*/("""</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                      """),_display_(/*50.24*/user/*50.28*/.map/*50.32*/ { u =>_display_(Seq[Any](format.raw/*50.39*/("""

                        """),format.raw/*52.25*/("""<li class="dropdown">
                    <a href=""""),_display_(/*53.31*/routes/*53.37*/.ApplicationController.index),format.raw/*53.65*/("""" class="dropdown-toggle" data-toggle="dropdown" >Blend</a>
                              <ul class="dropdown-menu">
                                  <li><a href="#"><i class="fa fa-star" aria-hidden="true"></i>  Popular Models </a></li>
                                  <li><a href="#"> <i class="fa fa-cubes" aria-hidden="true"></i> All Models </a></li>
                                  <li><a href="#"><i class="fa fa-th-large" aria-hidden="true"></i> Category </a></li>
                                  <li role="separator" class="divider"></li>
                                  <li><a href="/upmodel"><i class="fa fa-upload" aria-hidden="true"></i>  Upload Model </a></li>
                              </ul>
                           </li>

                          <li><a href="/col">Collections</a></li>

                          <li class="dropdown">
                          <a href=""""),_display_(/*66.37*/routes/*66.43*/.ApplicationController.index),format.raw/*66.71*/("""" class="dropdown-toggle" data-toggle="dropdown" >Community</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#"><i class="fa fa-envelope-o" aria-hidden="true"></i> Forum </a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="/forums"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Upload Forum </a></li>
                                    </ul>
                                 </li>

                                   <li><a href="/member"> User</a></li>

                          <li class="dropdown">
                      <a href=""""),_display_(/*77.33*/routes/*77.39*/.ApplicationController.index),format.raw/*77.67*/("""" class="dropdown-toggle" data-toggle="dropdown" ><i class="fa fa-user" aria-hidden="true"></i> """),_display_(/*77.164*/u/*77.165*/.fullName),format.raw/*77.174*/("""</a>
                                <ul class="dropdown-menu">
                                    <li><a href="/profile"><i class="fa fa-user" aria-hidden="true"></i> My Profile</a></li>
                                    <li><a href="/col"><i class="fa fa-folder" aria-hidden="true"></i> My Collection</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#"><i class="fa fa-cog" aria-hidden="true"></i> Settings</a></li>
                                    <li><a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit Profile</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href=""""),_display_(/*85.51*/routes/*85.57*/.ApplicationController.signOut),format.raw/*85.87*/(""""><i class="fa fa-sign-out" aria-hidden="true"></i>"""),_display_(/*85.139*/Messages("sign.out")),format.raw/*85.159*/("""</a></li>
                                </ul>
                             </li>
                          <!-- <li><a href=""""),_display_(/*88.46*/routes/*88.52*/.ApplicationController.signOut),format.raw/*88.82*/("""">"""),_display_(/*88.85*/Messages("sign.out")),format.raw/*88.105*/("""</a></li> -->
                      """)))}/*89.24*/.getOrElse/*89.34*/ {_display_(Seq[Any](format.raw/*89.36*/("""
                          """),format.raw/*90.27*/("""<li><a href=""""),_display_(/*90.41*/routes/*90.47*/.ApplicationController.signIn),format.raw/*90.76*/(""""><i class="fa fa-sign-in" aria-hidden="true"></i> """),_display_(/*90.128*/Messages("sign.in")),format.raw/*90.147*/("""</a></li>
                          <li><a href=""""),_display_(/*91.41*/routes/*91.47*/.ApplicationController.signUp),format.raw/*91.76*/(""""><i class="fa fa-user" aria-hidden="true"></i> """),_display_(/*91.125*/Messages("sign.up")),format.raw/*91.144*/("""</a></li>
                      """)))}),format.raw/*92.24*/("""
                    """),format.raw/*93.21*/("""</ul>
                </nav>
            </div>
        </header>
        <!-- <main class="container"> -->
            <!-- <div class="starter-template row"> -->
                """),_display_(/*99.18*/content),format.raw/*99.25*/("""
            """),format.raw/*100.13*/("""<!-- </div> -->
        <!-- </main> -->
        <script type="text/javascript" src=""""),_display_(/*102.46*/routes/*102.52*/.WebJarAssets.at(WebJarAssets.locate("jquery.min.js"))),format.raw/*102.106*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*103.46*/routes/*103.52*/.WebJarAssets.at(WebJarAssets.locate("bootstrap.min.js"))),format.raw/*103.109*/(""""></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,user:Option[models.User],content:Html,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(title,user)(content)(messages)

  def f:((String,Option[models.User]) => (Html) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (title,user) => (content) => (messages) => apply(title,user)(content)(messages)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Tue Mar 28 21:22:50 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/main.scala.html
                  HASH: 20113e46d9a0ea29a4930a3922b09708f3793ebf
                  MATRIX: 559->1|747->94|777->98|1081->376|1095->382|1147->414|1194->434|1220->439|1529->721|1544->727|1630->791|1741->875|1756->881|1811->915|1881->958|1896->964|1975->1021|2045->1064|2060->1070|2134->1123|2256->1218|2271->1224|2322->1254|2392->1297|2407->1303|2457->1332|2527->1375|2542->1381|2604->1422|3340->2131|3390->2160|3676->2419|3691->2425|3740->2453|3956->2642|3971->2648|4020->2676|4050->2679|4087->2695|4237->2818|4250->2822|4263->2826|4308->2833|4364->2861|4444->2914|4459->2920|4508->2948|5452->3865|5467->3871|5516->3899|6265->4621|6280->4627|6329->4655|6454->4752|6465->4753|6496->4762|7300->5539|7315->5545|7366->5575|7446->5627|7488->5647|7646->5778|7661->5784|7712->5814|7742->5817|7784->5837|7841->5875|7860->5885|7900->5887|7956->5915|7997->5929|8012->5935|8062->5964|8142->6016|8183->6035|8261->6086|8276->6092|8326->6121|8403->6170|8444->6189|8509->6223|8559->6245|8773->6432|8801->6439|8844->6453|8960->6541|8976->6547|9053->6601|9139->6659|9155->6665|9235->6722
                  LINES: 20->1|25->1|27->3|33->9|33->9|33->9|34->10|34->10|39->15|39->15|39->15|42->18|42->18|42->18|43->19|43->19|43->19|44->20|44->20|44->20|46->22|46->22|46->22|47->23|47->23|47->23|48->24|48->24|48->24|62->38|62->38|67->43|67->43|67->43|71->47|71->47|71->47|71->47|71->47|74->50|74->50|74->50|74->50|76->52|77->53|77->53|77->53|90->66|90->66|90->66|101->77|101->77|101->77|101->77|101->77|101->77|109->85|109->85|109->85|109->85|109->85|112->88|112->88|112->88|112->88|112->88|113->89|113->89|113->89|114->90|114->90|114->90|114->90|114->90|114->90|115->91|115->91|115->91|115->91|115->91|116->92|117->93|123->99|123->99|124->100|126->102|126->102|126->102|127->103|127->103|127->103
                  -- GENERATED --
              */
          