<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../included/includedStyle.jsp" %>
</head>

<body class="body-bg">
    <div class="wrapper-box">
        <div class="row">
            <div class="col-md-12">
                <div class="wrapper-body">
                    <div class="portlet-title">
                        <div class="caption font-dark">
                            <i class="icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 新增设备信息 </span>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <form action="#" class="form-horizontal" id="form-add">
                            <div class="row">
                                
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            设备名称 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="deviceName" id="deviceName">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入产品名称</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            设备编号 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="deviceNumber" id="deviceNumber">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入设备编号</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                             <div class="row">
                                
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            设备类型 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="deviceType" id="deviceType">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入设备类型</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            设备功能
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="deviceDesc" id="deviceDesc">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入设备功能</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            安装日期 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="date-picker form-control" readonly data-date-format="yyyy-mm-dd" placeholder="" name="instDate" id="instDate">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入安装日期</span>
                                        </div>
                                    </div>
                                </div>
                               <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            报废日期 
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="date-picker form-control" readonly data-date-format="yyyy-mm-dd" placeholder="" name="scrapDate" id="scrapDate">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入报废日期</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                           <!--  <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-2 control-label" for="form_control_1">
                                            设备描述
                                        </label>
                                        <div class="col-md-10">
                                            <input type="text" class="form-control" placeholder="" name="deviceDesc" id="deviceDesc">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入设备描述</span>
                                        </div>
                                    </div>
                                </div>
                            </div> -->
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

<%@include file="../included/includedJs.jsp" %>

<script type="text/javascript">

jQuery(document).ready(function() {
    
    //表单校验提交
    //[1]自定义校验规则
    var rules = {
           // deviceId:"required",
            deviceName:"required",
            deviceRfid:"required",
            instDate:"required",
            deviceType:"required"
            /*  scrapDate:"required",
           deleteFlag:"required",
             deviceDesc:"required",
            creator:"required",
            createDate:"required",
            modifier:"required",
            modifyDate:"required"  */
    };
    //[2]表单校验初始化
    initFormValidate('form-add', rules, 'device/info/add', 'add');
    
});

</script>
</body>
</html>