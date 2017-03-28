
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object showmodel_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class showmodel extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[models.User,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: models.User)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
"""),_display_(/*3.2*/main(Messages("home.title") , Some(user))/*3.43*/{_display_(Seq[Any](format.raw/*3.44*/("""

      """),format.raw/*5.7*/("""<div class="container">
	        <div class="col-sm-8 ">
            <br><br>
	           	<h3>Name Models</h3>
	       </div>
       <div class="col-sm-8 " >
			          <!--upload file html-->
            <!-- <embed src="public/members/01/car2.html" height="480" width="740"> -->

            <iframe src= "assets/images/model/scene.html" name="iframe_a" height="480" width="740" style="border:none;"></iframe>
						   <br>

               <a href="#"><i class="fa fa-eye" aria-hidden="true"></i>  2 </a>
               <a href="#"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i>  1 </a>

            <div class=" text-right" >
                     <button class="btn btn-info btn-sm " ><i class="fa fa-plus" aria-hidden="true"></i>  FOLLOW</button>
                     <button class="btn btn-success btn-sm " ><i class="fa fa-plus-square" aria-hidden="true"></i>  COLLECT</button>
                     <button class="btn btn-warning btn-sm " ><i class="fa fa-download" aria-hidden="true"></i>  DOWNLOAD</button>
             </div>

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
           </div><!--col-md-8-->

             	<div id="land-widget" class="col-sm-4 list-group ">
                    	<li  class=" list-group-item ">
                          <img  src= "assets/images/user.png" class="img-circle " width="70">
		                    	<h5 class="list-group-item-heading">By name user</h5>
		                    	<a href="/profile" class="btn btn-info btn-block "  ><i class="fa fa-user" aria-hidden="true"></i>  VIEW PROFILE</a>
              	  	</li>

	                 	<li class="list-group-item">
		                    	<h5 class="list-group-item-heading">About This Model</h5>
                          <h5>Description</h5>
                          <h5>Date</h5>
                          <h5>Time</h5>
                          <a href="#"><i class="fa fa-tag" aria-hidden="true"></i></a>
	                	</li>
	        	<li id="super_recent_posts_widget-3" class="widget recent_custom_posts testimonial list-group-item">
		               	<h4 class="widgettitle list-group-item-heading"><a href="#">Vad tycker andra om Vulkan</a></h4>
			         <div class="recent_custom_posts_item">
				            <div class="post-entry">
				                <div class="testemonial-item">
					                  	<div class="mb-thumb"></div>
					                       	<blockquote cite="https://www.vulkanmedia.se/testimonial/jag-ar-mycket-nojd-med-det-fardiga-resultatet/" title="Jag är mycket nöjd med det färdiga resultatet">
							                    <a href="https://www.vulkanmedia.se/testimonial/jag-ar-mycket-nojd-med-det-fardiga-resultatet/">
								                  <p><i class="fa fa-quote-left"></i> Jag har från första stund varit nöjd med Vulkan. Jag har fått bra handledning och fint bemötande. <i class="fa fa-quote-right"></i></p>
						                    	</a>
					 	                    	<i class="fa fa-user fa-fw pull-left"></i><small>Thomas Nybom                                            </small>
					                      	</blockquote>
				                    	</div>
				               	<div class="clear"> </div>
				            </div>
			           </div>
	           	</li>
	        </div><!--col-md-4 list-group-->
     </div><!--container-->

  <!-- /Page -->
 """),_display_(/*113.3*/footer(user)),format.raw/*113.15*/("""
""")))}),format.raw/*114.2*/("""
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
object showmodel extends showmodel_Scope0.showmodel
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 21:44:07 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/showmodel.scala.html
                  HASH: 87973c7c4870021a2466608af7d5352890f250cc
                  MATRIX: 549->1|692->49|720->51|763->69|812->110|850->111|886->121|6198->5406|6232->5418|6266->5421
                  LINES: 20->1|25->1|26->2|27->3|27->3|27->3|29->5|137->113|137->113|138->114
                  -- GENERATED --
              */
          