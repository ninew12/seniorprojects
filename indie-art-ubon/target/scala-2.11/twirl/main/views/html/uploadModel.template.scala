
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object uploadModel_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class uploadModel extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[models.User,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: models.User)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>

"""),_display_(/*4.2*/main(Messages("home.title"), Some(user))/*4.42*/{_display_(Seq[Any](format.raw/*4.43*/("""
  """),format.raw/*5.3*/("""<div class="container">
         <br><br><br>
            <div class="mt mb ">
               <h3><i class="fa fa-upload" aria-hidden="true"></i> UPLOAD MODEL</h3>
           </div>
             <div class="panel panel-info">
                <div class="panel-body">
                  <div class="container">
                    <div class="row">
                     <div class="col-sm-1  ">
                     </div>
                      <div class="col-sm-8  ">
                        <form>
                            <div class="form-group">
                              <h5 >ชื่อโมเดล</h5>
                              <input type="text" class="form-control">

                            </div>
                               <div class="form-group">
                                 <h5 for="exampleTextarea">รายละเอียดโมเดล</h5>
                                 <textarea class="form-control" id="exampleTextarea" rows="3"></textarea>
                               </div>

                               <div class="form-group">
                               <select class="custom-select">
                                 <option selected>เลือกหมวดหมู่</option>
                                 <option value="1">Character</option>
                                 <option value="2">Assets</option>
                                 <option value="3">Scene</option>
                                 <option value="4">Others</option>
                               </select>
                             </div>

                            <div class="form-group">
                                <h5 for="exampleInputFile">แนบไฟล์รูปภาพ</h5>
                                <input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp" style="color:#FF9933">
                            </div>

                            <div class="form-group">
                            <h5 for="exampleInputFile">แนบไฟล์.blend</h5>
                              <input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp" style="color:#FF9933">
                            </div>

                            <div class="form-group">
                            <h5 for="exampleInputFile">แนบไฟล์.่json</h5>
                              <input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp" style="color:#FF9933">
                            </div>

                            <div class="form-group">
                            <h5 for="exampleInputFile">แนบไฟล์.html</h5>
                            <input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp" style="color:#FF9933">
                            </div>

                            <div class="form-group has-success">
                              <label class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input">
                                <span class="custom-control-indicator"></span>
                                <span style="color:#FFFFFF" class="custom-control-description">ยอมรับเงื่อนไข  <a data-toggle="modal" href="#model"  > เงื่อนไขการอัพโหลดผลงาน  </a></span>
                              </label>
                            </div>

                            <div class=" text-right">
                              <button type="submit" class="btn btn-primary">Submit</button> &nbsp; &nbsp;
                              <button type="submit" class="btn btn-danger">Cancel</button>
                            </div>
                          </form>
                            </div>   <!-- col-md-8 -->
                         </div>   <!-- row -->
                      </div><!-- container -->
                   </div><!-- panal-body -->
                 </div><!-- panal -->
              </div><!--inner-->


           <!--dialog -->
                     <div class="modal" id="model" role="dialog">
           	                <div class="modal-dialog">
                                <div class="modal-content">
                                      <div class="modal-header">
                                             <button type="button" class="close" data-dismiss="modal" aria-hidden="true" >×</button>
                                             <h4 class="modal-title">เงื่อนไขการอัพโหลดผลงาน</h4>
                                       </div>
                               <div class="modal-body">
                                 <div class="well">
                                     <p>&nbsp;&nbsp;&nbsp;&nbsp;ผลงานที่ทำการอัพโหลดเป็นผลงานที่ถูกพัฒนาขึ้นด้วยสมาชิกเอง</p>
                                     <p>&nbsp;&nbsp;&nbsp;&nbsp;หากมีการคัดลอกผลงานเพื่อนำมาอัพโหลดทางเราจะไม่รับผิดชอบใดๆทั้งสิ้น</p>
                                     <p>&nbsp;&nbsp;&nbsp;&nbsp;ผู้พัฒนาต้องการแชร์ผลงานให้สมาชิกท่านอื่นโดยไม่มีเงื่อนไขหรือเสียค่าใช้จ่ายใดๆทั้งสิ้น</p>
                                     <p>&nbsp;&nbsp;&nbsp;&nbsp;การใช้งานของเว็บไซต์อยู่ภายใต้กฎหมายและกฎระเบียบที่บังคับใช้ทั้งหมดและคุณจะต้องรับผิดชอบต่อเนื้อหาของการสื่อสารของคุณผ่านทางเว็บไซต์
                                     ไม่ใช้เนื้อหาที่ไม่เหมาะสม ล่วงละเมิด หรือการฉ้อโกงรุกราน และทำการฝ่าฝืนกฎระเบียบ นโยบายของเรา </p>
                                </div>
                              </div>
                                  <div class="modal-footer">
                                             <a href="#" data-dismiss="modal" class="btn">Close</a>
                                             <a href="#" class="btn btn-warning">Ok</a>
                                 </div>
                             </div>
                         </div>
                     </div>  <!--dialog -->
""")))}),format.raw/*103.2*/("""
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
object uploadModel extends uploadModel_Scope0.uploadModel
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 21:44:07 ICT 2017
                  SOURCE: D:/Project/59201kamonwan-ad-56/indie-art-ubon/app/views/uploadModel.scala.html
                  HASH: 4e66b1a00dff0f85ed13f1736ffce6c3bbf60e85
                  MATRIX: 553->1|696->49|724->51|769->71|817->111|855->112|885->116|6831->6031
                  LINES: 20->1|25->1|26->2|28->4|28->4|28->4|29->5|127->103
                  -- GENERATED --
              */
          