<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>烟雾数据表模块</title>
<%@include file="../../included/includedStyle.jsp" %>

</head>

<body>
    <div class="wrapper">
        <div class="wrapper-content">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class=" icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 烟雾数据表 </span>
                </div>
            </div>
            <div class="portlet-body">
                <form action="#" class="form-horizontal" id="form-module">
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    传感器编号 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnSmoke.wareId}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    网关 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnSmoke.objId}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    传感器烟雾值 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnSmoke.smokeValue}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    频率 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnSmoke.rate}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    状态：0正常，1损坏，2丢失 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnSmoke.state}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    采集时间 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnSmoke.createTime}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-txt">
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    备用 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnSmoke.field}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    主键 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnSmoke.id}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

<%@include file="../../included/includedJs.jsp" %>

</body>
</html>