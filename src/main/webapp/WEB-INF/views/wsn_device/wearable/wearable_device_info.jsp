<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>硬件信息表模块</title>
<%@include file="../../included/includedStyle.jsp" %>

</head>

<body>
    <div class="wrapper">
        <div class="wrapper-content">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class=" icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 硬件信息表 </span>
                </div>
            </div>
            <div class="portlet-body">
                <form action="device/wearable/update_page" class="form-horizontal" id="form-module">
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    硬件编号 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static" id="wareId1">${wsnHardwareInfo.wareId}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    硬件名称 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.wareName}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    硬件类型 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                   <p  class="form-control-static">${wsnHardwareType.typeName}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    使用部门 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.wareKey}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    更新时间 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                   <p class="form-control-static" name="updateTime" id="updateTime"><fmt:formatDate value="${wsnHardwareInfo.updateTime}" pattern="yyyy-MM-dd"/></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    状态 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                   <c:if test="${wsnHardwareInfo.state ==0 }">
                                        <p  class="form-control-static">正常</p>
                                   </c:if>
                                    <c:if test="${wsnHardwareInfo.state ==1 }">
                                        <p  class="form-control-static">异常</p>
                                   </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                   
                     <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    标签信息 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p class="form-control-static">${wsnHardwareInfo.rfidId}</p>
                                </div>
                            </div>
                        </div>
                         <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    用户ID <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.employeeId}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-txt">
                        <div class="col-md-12">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-2 control-label" for="form_control_1">
                                    硬件信息 <span class="required">*</span>
                                </label>
                                <div class="col-md-10">
                                    <p  class="form-control-static">${wsnHardwareInfo.wareInfo}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                   
                    <div class="col-md-9 model-hidden">
                         <input type="hidden" value="${wsnHardwareInfo.wareId}" name="wareId" id="wareId">
                    </div>
                     <div class="row border-txt">
                        <div class=" col-md-6" >
                            <div class="col-md-offset-9 col-md-6" id="qrcode">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <div class="col-md-offset-9 col-md-9">
                                        <button type="submit" class="btn green">修改</button>
                                        <button type="button" id="btnSee" class="btn bule">查看</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

<%@include file="../../included/includedJs.jsp" %>
<script type="text/javascript">

$("#btnSee").click(function(){
	var ware = $("#wareId1").text();
	window.location.href="device/sensor?id=ware";
});

</script>
</body>
</html>