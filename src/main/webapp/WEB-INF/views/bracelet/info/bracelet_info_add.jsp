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
                            <i class="icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 新增可穿戴设备信息表 </span>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <form action="#" class="form-horizontal" id="form-add">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            硬件编号 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="bwareId" id="bwareId">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入硬件编号</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            硬件类型 <span class="required">*</span>
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
                                <div class="col-md-4">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            硬件名称
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="wareName" id="wareName">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入硬件名</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                           
                            <div class="row">
                             <div class="col-md-4">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            包含传感器<span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="infoOne" id="infoOne" value="体温、噪音、空气质量、心跳">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入包含传感器</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
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
                                <div class="col-md-4">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            作业场所 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
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
                                <div class="col-md-4">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            硬件信息 
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="wareInfo" id="wareInfo">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入硬件信息</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            状态 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                           <select name="state" class="selectpicker form-control" id="state">
                                                <option value="运行" selected>运行</option>
                                                <option value="故障">故障</option>
                                                <option value="检修">检修</option>
                                                <option value="维护">维护</option>
                                            </select>
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入状态</span>
                                        </div>
                                    </div>
                                </div>
                                 <div class="col-md-4">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            网关 
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="netIp" id="netIp">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入网关</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
            
                            <div class="row">
                                <table class="table table-bordered">
                                   <hr>
                                    <thead>
                                        <tr>
                                            <th>序号</th>
                                            <th>传感器</th>
                                            <th>采样周期</th>
                                            <th>阈值</th>
                                            <th>度量单位</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>体温<input type="text" hidden name="sensorName" id="sensorName" value="体温"></td>
                                            <td><input type="text"  name="sampleData" id="sampleData"></td>
                                            <td><input type="text"  name="alrmData" id="alrmData"></td>
                                            <td><input type="text" name="metricData" id="metricData"></td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>心跳<input type="text" hidden name="sensorName" id="sensorName" value="心跳"></td>
                                            <td><input type="text"  name="sampleData" id="sampleData"></td>
                                            <td><input type="text"  name="alrmData" id="alrmData"></td>
                                            <td><input type="text" name="metricData" id="metricData"></td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>噪音<input type="text" hidden name="sensorName" id="sensorName" value="噪音"></td>
                                            <td><input type="text"  name="sampleData" id="sampleData"></td>
                                            <td><input type="text"  name="alrmData" id="alrmData"></td>
                                            <td><input type="text" name="metricData" id="metricData"></td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>空气质量<input type="text" hidden name="sensorName" id="sensorName" value="空气质量"></td>
                                            <td><input type="text"  name="sampleData" id="sampleData"></td>
                                            <td><input type="text"  name="alrmData" id="alrmData"></td>
                                            <td><input type="text" name="metricData" id="metricData"></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            
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
            bwareId:"required",
            typeId:"required",
            objId:"required",
            sensorName:"required",
            state:"required",
            netIp:"ip"
    };
    //[2]表单校验初始化
    initFormValidate('form-add', rules, 'bracelet/info/add', 'add');
    
});

</script>
</body>
</html>