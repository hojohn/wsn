<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>监控对象模块</title>
<%@include file="../../included/includedStyle.jsp" %>

</head>

<body>
    <div class="wrapper">
        <div class="wrapper-content">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class=" icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 监控对象 </span>
                </div>
            </div>
            <div class="portlet-body">
                <form action="device/monitor/update_page" class="form-horizontal" id="form-module">
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    监控对象编码 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnMonitorObj.monitorObjId}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    监控对象名 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnMonitorObj.monitorObjName}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    监控对象设备<span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static" >
                                         <c:forEach items="${senList }" var ="s">
                                            ${s.wareId }、
                                         </c:forEach>   
                                     </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    监控对象内容 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnMonitorObj.monitorObjContent}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    储量 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnMonitorObj.remark}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    使用部门 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnMonitorObj.monitorObjPlace}</p>
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
                                    <p  class="form-control-static">${wsnMonitorObj.rfidId}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    监控类型 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnMonitorObj.info1}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-9 model-hidden">
                         <input type="hidden" value="${wsnMonitorObj.monitorObjId}" name="monitorObjId" id="monitorObjId">
                    </div>
                     <div class="row border-txt">
                        <div class=" col-md-6" >
                            <div class="col-md-offset-9 col-md-6" id="qrcode">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <div class="col-md-offset-9 col-md-9">
                                    <button type="submit" class="btn green" onclick="btnUpdate()" >修改</button>
                                </div>
                            </div>
                        </div>
                    </div>
                   <%--  <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    修改时间 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnMonitorObj.modifyDate}</p>
                                </div>
                            </div>
                        </div>
                    </div> --%>
                </form>
            </div>
        </div>
    </div>
                   
<%@include file="../../included/includedJs.jsp" %>
<script src="static/plugins/qrcode/jquery.qrcode.min.js" type="text/javascript"></script>
<script type="text/javascript">
/* $("#qrcode").qrcode({ 
        render: "table", //table方式 
        width: 100, //宽度 
        height:100, //高度 
        text: result() //任意内容 
    }); */

function result(){
    return "55"
}
 
function btnUpdate(){
	var info =$("#monitorObjId").val();
	var url = "device/monitor/update_page?info1="+info;
	//alert(url);
	window.location.href = url;
	
    }

</script>
</body>
</html>