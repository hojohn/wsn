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
                            <i class="icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 新增硬件信息表 </span>
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
                                            <input type="text" class="form-control" placeholder="格式：TEM_C00_000" name="wareId" id="wareId">
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
                                            <input type="text" class="form-control" placeholder="" name="wareName" id="wareName">
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
                                            <!-- <input type="text" class="form-control" placeholder="" name="typeId" id="typeId"> -->
                                           <select name="typeId" class="selectpicker form-control" id="typeId">
                                                <c:forEach items="${typeList}" var="typeEnum">
                                                    <option value="${typeEnum.typeId}">${typeEnum.typeName}</option>
                                                </c:forEach>
                                            </select>
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
                                            <input type="text" class="form-control" placeholder="" name="wareKey" id="wareKey">
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
                                            <input type="text" class="date-picker form-control" readonly data-date-format="yyyy-mm-dd" name="updateTime" id="updateTime">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入更新时间</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            状态
                                        </label>
                                        <div class="col-md-8">
                                            <!-- <input type="text" class="form-control" placeholder="" name="state" id="state"> -->
                                            <select name="state" class="selectpicker form-control" id="state">
                                                <option value="运行" selected>运行</option>
                                                <option value="故障">故障</option>
                                                <option value="检修">检修</option>
                                                <option value="维护">维护</option>
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
                                            采样周期（秒） <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="remark1" id="remark1">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入采样周期</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            监控对象
                                        </label>
                                        <div class="col-md-8">
                                            <!-- <input type="text" class="form-control" placeholder="" name="remark2" id="remark2"> -->
                                           <select name="objId" class="selectpicker form-control" id="objId">
                                                <c:forEach items="${objList}" var="obj">
                                                   <option value="${obj.monitorObjId }">${obj.monitorObjId }</option>
                                                </c:forEach>
                                            </select>
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入监控对象</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            网关编号 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder=""  name="netIp" id="netIp">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入网关编号</span>
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
                                            <input type="text" class="form-control" placeholder="" name="wareInfo" id="wareInfo">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入硬件信息</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                             <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-2 control-label" for="form_control_1">
                                                连接移动节点
                                            </label>
                                        <div class="col-md-10">
                                            <select id="usertype" name="infoOne" class="selectpicker show-tick form-control" multiple data-live-search="false">
                                               <c:forEach items="${moveList }" var="s" >
                                                    <option value="${s.wareId }">${s.wareId }</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                           </div>
                           <%--  <div class="row">
                                <div class="col-md-12">
                                    <div class="col-md-9 model-hidden">
                                        <input type="hidden" value="${wsnHardwareInfo.getewayId}" name="getewayId" id="getewayId">
                                    </div>
                                    <div class="col-md-9 model-hidden">
                                        <input type="hidden" value="${wsnHardwareInfo.wareId}" name="wareId" id="wareId">
                                    </div>
                                </div>
                            </div> --%>
                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button type="submit" class="btn green">提交</button>
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
            infoThree:"required",
            remark1:"required",
            getewayIdTxt:"required"
          
    };
    //[2]表单校验初始化
    initFormValidate('form-update', rules, 'device/move_node/update', 'update');
    
});
</script>
</body>
</html>