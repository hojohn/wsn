<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../included/includedStyle.jsp" %>
</head>

<body class="body-bg">
    <div class="wrapper-box">
        <div class="row">
            <div class="col-md-12">
                <div class="wrapper-body">
                    <div class="portlet-title">
                        <div class="caption font-dark">
                            <i class="icon-layers font-green"></i> <span class="caption-subject bold uppercase"> ${wsnHardwareInfo.wareName}</span>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <form action="#" class="form-horizontal" id="form-update">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            硬件编号 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value="${wsnHardwareInfo.infoThree}" name="infoThree" id="infoThree">
                                            <%-- <p  class="form-control-static" name="wareId1" id="wareId1">${wsnHardwareInfo.wareId}</p> --%>
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入硬件编号</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            硬件名称
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value="${wsnHardwareInfo.wareName}" name="wareName" id="wareName">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入硬件名称</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            硬件类型 
                                        </label>
                                        <div class="col-md-8">
                                            <%-- <input type="text" class="form-control" placeholder="" value="${wsnHardwareInfo.typeId}传感器" name="typeId" id="typeId"> --%>
                                            <%-- <select name="typeId" class="selectpicker form-control" id="typeId">
                                                <c:forEach items="${typeEnums}" var="typeEnum">
                                                    <c:if test="${typeEnum.key == wsnHardwareInfo.typeId}">
                                                        <option value="${typeEnum.key}" selected>${typeEnum.value}</option>
                                                    </c:if>
                                                    <c:if test="${typeEnum.key != wsnHardwareInfo.typeId}">
                                                        <option value="${typeEnum.key}">${typeEnum.value}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select> --%>
                                             <p  class="form-control-static" name="typeId" id="typeId">
                                                                 服务器
                                             </p>
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入硬件类型</span>
                                        </div>
                                    </div>
                                </div>
                               <%--  <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            网关编号 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value=" ${wsnHardwareInfo.wsnGeteway.gatewayIp}" name="getewayIdTxt" id="getewayIdTxt">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入网关编号</span>
                                        </div>
                                    </div>
                                </div> --%>
                                 <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            关键标志
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value="${wsnHardwareInfo.wareKey}" name="wareKey" id="wareKey">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入关键标志</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            更新时间
                                        </label>
                                        <div class="col-md-8">
                                            <%-- <input type="text" class="form-control" placeholder="" 
                                            value="<fmt:formatDate value="${wsnHardwareInfo.updateTime}" pattern="yyyy-MM-dd hh:mm:ss"/>" name="updateTime" id="updateTime">
                                             --%><p class="form-control-static" name="updateTime" id="updateTime"><fmt:formatDate value="${wsnHardwareInfo.updateTime}" pattern="yyyy-MM-dd hh:mm:ss"/></p>
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入更新时间</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            状态<span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <%-- <input type="text" class="form-control" placeholder="" value="${wsnHardwareInfo.state}" name="state" id="state"> --%>
                                            <select name="state" class="selectpicker form-control" id="state">
                                                <c:forEach items="${stateEnums}" var="stateEnum">
                                                    <c:if test="${stateEnum.key == wsnHardwareInfo.state}">
                                                        <option value="${stateEnum.key}" selected>${stateEnum.value}</option>
                                                    </c:if>
                                                    <c:if test="${stateEnum.key != wsnHardwareInfo.state}">
                                                        <option value="${stateEnum.key}">${stateEnum.value}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入状态，1被占用，0未占用</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                 <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            采样周期 
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value="${wsnHardwareInfo.remark1}" name="remark1" id="remark1">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入采样周期</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                  IP <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value=" ${wsnHardwareInfo.wsnGeteway.gatewayIp}" name="getewayIdTxt" id="getewayIdTxt">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入ip地址</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                             <div class="row">
                                 
                                
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                           端口 
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value="${wsnHardwareInfo.infoTwo}" name="infoTwo" id="infoTwo">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入端口号</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <label class="col-md-4 control-label" for="form_control_1">
                                            选择终端
                                        </label>
                                    <div class="col-md-8">
                                        <select id="usertype" name="infoOne" class="selectpicker show-tick form-control" multiple data-live-search="false">
                                                <c:forEach items="${deviceList }" var="s" begin="36" end="38">
                                                  <option value="${s.infoThree }">${s.infoThree }</option>
                                                </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-2 control-label" for="form_control_1">
                                            连接终端
                                        </label>
                                        <div class="col-md-10">
                                            <input type="text" class="form-control" placeholder="" value="${wsnHardwareInfo.infoOne}" name="infoOne" id="onfoOne">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入终端</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-2 control-label" for="form_control_1">
                                            服务器信息
                                        </label>
                                        <div class="col-md-10">
                                            <input type="input" class="form-control" placeholder="" value="${wsnHardwareInfo.wareInfo}" name="wareInfo" id="wareInfo">
                                            <%-- <textarea  rows="3" cols="120"  placeholder="" value="${wsnHardwareInfo.wareInfo}" name="wareInfo" id="wareInfo">
                                            ${wsnHardwareInfo.wareInfo}
                                            </textarea > --%>
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入硬件信息</span>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="col-md-9 model-hidden">
                                        <input type="hidden" value="${wsnHardwareInfo.getewayId}" name="getewayId" id="getewayId">
                                    </div>
                                    <div class="col-md-9 model-hidden">
                                        <input type="hidden" value="${wsnHardwareInfo.wareId}" name="wareId" id="wareId">
                                    </div>
                                </div>
                            </div>
                            <div class="form-actions">
                                <div class="row" >
                              <!--       <div id=""  class="col-lg-4 col-lg-offset-4  col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2" >
                                        <a >生成二维码</a>
                                    </div> -->
                                    <div class="col-md-offset-3 col-md-9">
                                        <button type="submit" class="btn green">提交</button>
                                        <button type="button" class="btn red " onclick = "showQrcodeContent('${wsnHardwareInfo.wareId}')">生成二维码</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@include file="../../included/includedJs.jsp" %>
<script src="static/plugins/qrcode/jquery.qrcode.min.js" type="text/javascript"></script>
<script type="text/javascript">

jQuery(document).ready(function() {
    
    //表单校验提交
    //[1]自定义校验规则
    var rules = {
            wareId:"required",
           // wareName:"required",
         //   typeId:"required",
          //  getewayId:"required",
         //   wareKey:"required",
        //    
        //    updateTime:"required",
        //    state:"required"
            
    };
    //[2]表单校验初始化
    initFormValidate('form-update', rules, 'device/hardware/update', 'update');
    
    
   
});
function showQrcodeContent(_deviceId) {
    //alert(_deviceId);
    showModal(2, ' ', [ '1000px', '550px' ], "device/qrcode/" + _deviceId + "/page");
};
</script>
</body>
</html>