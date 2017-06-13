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
                            <span class="dt-buttons">
                                <a class="dt-button btn yellow btn-outline btn-mnt" id="btnUpdate" href="device/info/update_page/temperature01?id=${wsnHardwareInfo.wareId }">
                                    <span>返回</span>
                                </a>
                             </span>
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
                                            <input type="text" class="form-control" placeholder="" value="${wsnHardwareInfo.wareId}" name="wareId" id="wareId" readonly>
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
                                            <select name="typeId" class="selectpicker form-control" id="typeId">
                                                <c:forEach items="${typeList}" var="typeEnum">
                                                    <c:if test="${typeEnum.typeId == wsnHardwareInfo.typeId}">
                                                        <option value="${typeEnum.typeId}" selected>${typeEnum.typeName}</option>
                                                    </c:if>
                                                    <c:if test="${typeEnum.typeId != wsnHardwareInfo.typeId}">
                                                        <option value="${typeEnum.typeId}">${typeEnum.typeName}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                            <!-- <p  class="form-control-static" name="typeId" id="typeId">传感器</p> -->
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入硬件类型</span>
                                        </div>
                                    </div>
                                </div>
                              
                                 <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            使用部门
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value="${wsnHardwareInfo.wareKey}" name="wareKey" id="wareKey">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入使用部门</span>
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
                                            <input type="text" class="date-picker form-control" placeholder="" readonly data-date-format="yyyy-mm-dd"
                                            value="<fmt:formatDate value="${wsnHardwareInfo.updateTime}" pattern="yyyy-MM-dd"/>" name="updateTime" id="updateTime">
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
                                               <option value="0" selected>正常</option>
                                               <option value="1">异常</option>
                                            </select>
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入状态，1被占用，0未占用</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                          
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-2 control-label" for="form_control_1">
                                            硬件信息
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
                           
                            <div class="form-actions">
                                <div class="row" >
                              <!--       <div id=""  class="col-lg-4 col-lg-offset-4  col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2" >
                                        <a >生成二维码</a>
                                    </div> -->
                                    <div class="col-md-offset-3 col-md-9">
                                        <button type="submit" class="btn green" id="confirm">提交</button>
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
    $("#confirm").click(function(){
        return confirm("是否确认提交 ");
      
       });
});

</script>
</body>
</html>