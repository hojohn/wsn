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
                            <i class="icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 监控对象 </span>
                            <span class="dt-buttons">
                                <a class="dt-button btn yellow btn-outline btn-mnt" id="btnUpdate" href="device/monitor/add_page?id=${wsnMonitorObj.monitorObjId }">
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
                                            监控对象编码 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value="${wsnMonitorObj.monitorObjId}" name="monitorObjId" id="monitorObjId" readonly>
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入监控对象编码</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            监控对象名 
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value="${wsnMonitorObj.monitorObjName}" name="monitorObjName" id="monitorObjName">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入监控对象名</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            使用部门 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value="${wsnMonitorObj.monitorObjPlace}" name="monitorObjPlace" id="monitorObjPlace">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            监控类型 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <%-- <input type="text" class="form-control" placeholder="" value="${wsnMonitorObj.info1}" name="info1" id="info1"> --%>
                                            <select name="info1" class="selectpicker form-control" id="info1">
                                                <option value="普通设备" selected>普通设备</option>
                                               <option value="特种设备">特种设备</option>
                                               <option value="作业场所">作业场所</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                            <div class="row">
                                 <div class="col-md-12">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-2 control-label" for="form_control_1">
                                            监控对象内容 
                                        </label>
                                        <div class="col-md-10">
                                            <input type="text" class="form-control" placeholder="" value="${wsnMonitorObj.monitorObjContent}" name="monitorObjContent" id="monitorObjContent">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入监控对象内容</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                           <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-2 control-label" for="form_control_1">
                                            储量 
                                        </label>
                                        <div class="col-md-10">
                                            <input type="text" class="form-control" placeholder="" value="${wsnMonitorObj.remark}" name="remark" id="remark">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入储量</span>
                                        </div>
                                    </div>
                                </div>
                              
                            </div> 
                           <%--  <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            修改时间 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="date-picker form-control" readonly data-date-format="yyyy-mm-dd" 
                                                value="<fmt:formatDate value="${wsnMonitorObj.modifyDate}" pattern="yyyy-MM-dd"/>" name="modifyDate" id="modifyDate">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入修改时间</span>
                                        </div>
                                    </div>
                                </div>
                            </div> --%>
                            <%-- <div class="row">
                                <div class="col-md-12">
                                    <div class="col-md-9 model-hidden">
                                        <input type="hidden" value="${wsnMonitorObj.monitorObjId}" name="monitorObjId" id="monitorObjId">
                                    </div>
                                </div>
                            </div> --%>
                            <div class="form-actions">
                                <div class="row">
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

<script type="text/javascript">

jQuery(document).ready(function() {
    
    //表单校验提交
    //[1]自定义校验规则
    var rules = {
    		info1:"required",
          
    };
    //[2]表单校验初始化
    initFormValidate('form-update', rules, 'device/monitor/update', 'update');
    $("#confirm").click(function(){
        return confirm("是否确认提交 ");
      
       });
});

</script>
</body>
</html>