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
                    <i class=" icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 服务器信息表 </span>
                    <c:if test="${hid ==1 }">
                            <div class="pull-right"> 
                                <a class="dt-button btn yellow btn-outline btn-mnt " id="btnUpdate" href="stat/index">
                                  <span >返回</span>
                                </a>
                            </div>
                        </c:if>
                </div>
            </div>
            <div class="portlet-body">
                <form action="device/server/update_page" class="form-horizontal" id="form-module">
                    <div class="row border-txt">
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    硬件编号 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.wareId}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    硬件名称 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.wareName}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    硬件类型 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                   <p  class="form-control-static">${wsnHardwareType.typeName}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-txt">
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    使用部门<span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.wareKey}</p>
                                </div>
                            </div>
                        </div>
                         <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    更新时间 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                   <p class="form-control-static" name="updateTime" id="updateTime"><fmt:formatDate value="${wsnHardwareInfo.updateTime}" pattern="yyyy-MM-dd"/></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    状态 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                   <p class="form-control-static">${wsnHardwareInfo.state}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-txt">
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    传输周期（秒） <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.remark1}</p>
                                </div>
                            </div>
                        </div>
                         <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    网关IP <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.netIp}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    端口号<span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.infoTwo}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    监控对象 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.objId}</p>
                                </div>
                            </div>
                        </div>
                         <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-3 control-label" for="form_control_1">
                                    连接终端<span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.infoOne}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                   
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    服务器信息 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnHardwareInfo.wareInfo}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-3 control-label" for="form_control_1">
                                    标签信息 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                     <p class="form-control-static">${wsnHardwareInfo.rfidId}</p>
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
                                    <c:if test="${hid ==0 }">
                                        <button type="submit" class="btn green">修改</button>
                                    </c:if>
                                    <%-- <c:if test="${hid ==1 }">
                                        <a class="dt-button btn yellow btn-outline btn-mnt" id="btnUpdate" href="stat/index">
                                            <span>返回</span>
                                        </a>
                                    </c:if> --%>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

<%@include file="../../included/includedJs.jsp" %>
<script src="static/plugins/qrcode/jquery.qrcode.min.js" type="text/javascript"></script>
<script type="text/javascript">

function result(){
    return "55"
}
 


</script>
</body>
</html>