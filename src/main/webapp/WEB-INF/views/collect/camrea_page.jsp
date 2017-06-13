<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>人员视频数据采集</title>
<%@include file="../included/includedStyle.jsp" %>

</head>

<body>
    <div class="wrapper">
        <div class="wrapper-content">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class=" icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 人员视频监控 </span>
                </div>
            </div>
            <div class="portlet-body">
                <form action="#" class="form-horizontal" id="form-module">
                  <div class="container">
                    <div class="row ">
                        <div class="col-md-6 ">
                             <div class="col-md-10 "><input type="file"  id="file" onchange="onInputFileChange()"></div>
                             <div class="col-md-2 "><input type="button" class="btn btn-info" value="连接" data-toggle="modal" data-target="#myModal"/></div>
                             <video id="audio_id" controls autoplay loop src="static/sounds/daojishi.mp4"  height="200px" ></video> 
                        </div>
                        <div class="col-md-6 column">
                            <div class="col-md-10 "><input type="file"  id="file2" onchange="onInputFileChange2()"></div>
                             <div class="col-md-2 "><input type="button" class="btn btn-info" value="连接" data-toggle="modal" data-target="#myModal"/></div>
                            <video id="audio_id2" controls autoplay loop height="200px"  src="http://www.w3school.com.cn/example/html5/mov_bbb.mp4" ></video>
                        </div> 
                    </div>
                    <div class="row ">
                         <div class="col-md-6 column">
                            <div class="col-md-10 "><input type="file"  id="file3" onchange="onInputFileChange3()"></div>
                             <div class="col-md-2 "><input type="button" class="btn btn-info" value="连接" data-toggle="modal" data-target="#myModal"/></div>
                            <video id="audio_id3" controls autoplay loop height="200px" src="http://easyhtml5video.com/assets/video/new/Penguins_of_Madagascar.m4v" ></video>
                        </div>
                        <div class="col-md-6 column">
                        <div class="col-md-10 "><input type="file"  id="file4" onchange="onInputFileChange4()"></div>
                             <div class="col-md-2 "><input type="button" class="btn btn-info" value="连接" data-toggle="modal" data-target="#myModal"/></div>
                            <video id="audio_id4" controls autoplay loop height="200px" ></video>
                        </div> 
                    </div>
                </div>
                </form> 
                
            </div>
        </div>
    </div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">视频服务器</h4>
            </div>
            <div class="modal-body">
                 <div class="row">
                     <div class="col-md-12">
                        <div class="form-group form-md-line-input">
                            <label class="col-md-2 control-label" for="form_control_1">
                  IP地址 <span class="required">*</span>
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="monitorObjId" id="monitorObjId">
                                <div class="form-control-focus"></div>
                                <span class="help-block">请输入ip地址</span>
                            </div>
                        </div>
                    </div>
                 </div>
                 
                 <div class="row">
                     <div class="col-md-12">
                        <div class="form-group form-md-line-input">
                            <label class="col-md-2 control-label" for="form_control_1">
                  端口号  <span class="required">*</span>
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="monitorObjId" id="monitorObjId">
                                <div class="form-control-focus"></div>
                                <span class="help-block">请输入端口号</span>
                            </div>
                        </div>
                    </div>
                 </div>
                  <div class="row">
                     <div class="col-md-12">
                        <div class="form-group form-md-line-input">
                            <label class="col-md-2 control-label" for="form_control_1">
                  用户名  <span class="required">*</span>
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="monitorObjId" id="monitorObjId">
                                <div class="form-control-focus"></div>
                                <span class="help-block">请输入用户名</span>
                            </div>
                        </div>
                    </div>
                 </div>
                  <div class="row">
                     <div class="col-md-12">
                        <div class="form-group form-md-line-input">
                            <label class="col-md-2 control-label" for="form_control_1">
                  密码 <span class="required">*</span>
                            </label>
                            <div class="col-md-8">
                                <input type="password" class="form-control" name="monitorObjId" id="monitorObjId">
                                <div class="form-control-focus"></div>
                                <span class="help-block">请输入密码</span>
                            </div>
                        </div>
                    </div>
                 </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%@include file="../included/includedJs.jsp" %>
<script type="text/javascript">
 function onInputFileChange() {  
	   var file = document.getElementById('file').files[0];  
	   var url = URL.createObjectURL(file);  
	   document.getElementById("audio_id").src = url;  
	} 
 function onInputFileChange2() {  
     var file = document.getElementById('file2').files[0];  
     var url = URL.createObjectURL(file);  
     document.getElementById("audio_id2").src = url;  
  } 
 function onInputFileChange3() {  
     var file = document.getElementById('file3').files[0];  
     var url = URL.createObjectURL(file);  
     document.getElementById("audio_id3").src = url;  
  } 
 function onInputFileChange4() {  
     var file = document.getElementById('file4').files[0];  
     var url = URL.createObjectURL(file);  
     document.getElementById("audio_id4").src = url;  
  } 
</script>
</body>
</html>