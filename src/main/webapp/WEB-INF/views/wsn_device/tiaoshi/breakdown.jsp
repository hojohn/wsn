<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>服务器性能</title>
<%@include file="../../included/includedStyle.jsp" %>

</head>

<body>
   <div class="wrapper">
        <div class="wrapper-content">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class=" icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 服务器性能 </span>
                </div>
            </div>
            <div class="portlet-body">
                <form action="device/sensor/update_page" class="form-horizontal" id="form-module">
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    服务器名称 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.name}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    服务器操作系统版本 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.version}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    服务器IP地址 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                     <p  class="form-control-static">${wsnHardwareInfo.IP}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
             Java虚拟机 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.javaVisual}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
              Java虚拟机内存占用比<span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                   <p  class="form-control-static">${wsnHardwareInfo.JVM}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    服务器内存占用比<span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                 <p  class="form-control-static">${wsnHardwareInfo.memery}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    服务器CPU占用率 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.cpu}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    服务器丢包率 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.lose}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    服务器误码率 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.error}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
              CPU缓存数量 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.huancun}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                   
                    
                    
                    
                  
                     <!-- <div class="row border-txt">
                        <div class=" col-md-6" >
                            <div class="col-md-offset-9 col-md-6" id="qrcode">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <div class="col-md-offset-9 col-md-9">
                                        <button type="submit" class="btn green">修改</button>
                                </div>
                            </div>
                        </div>
                    </div> -->
                </form>
            </div>
        </div>
    </div>
<%@include file="../../included/includedJs.jsp" %>
<script src="static/plugins/qrcode/jquery.qrcode.min.js" type="text/javascript"></script>
</body>
</html>