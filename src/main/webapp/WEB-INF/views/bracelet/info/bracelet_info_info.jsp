<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>可穿戴设备信息表模块</title>
<%@include file="../../included/includedStyle.jsp" %>

</head>

<body>
    <div class="wrapper">
        <div class="wrapper-content">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class=" icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 可穿戴设备信息表 </span>
                </div>
            </div>
            <div class="portlet-body">
                <form action="bracelet/info/update_page/${wsnBraceletInfo.bwareId }" class="form-horizontal" id="form-module">
                    <div class="row border-txt">
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    硬件编号 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnBraceletInfo.bwareId}</p>
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
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    硬件名 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnBraceletInfo.wareName}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                     <div class="row border-txt">
                         <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    包含传感器<span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnBraceletInfo.infoOne}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    更新时间 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static"><fmt:formatDate value="${wsnBraceletInfo.updateTime}" pattern="yyyy-MM-dd"/></p>
                                </div>
                            </div>
                        </div>
                          <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    作业场所 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnBraceletInfo.objId}</p>
                                </div>
                            </div>
                        </div>
                     </div>
                   
                    <div class="row border-txt">
                         <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    硬件信息 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnBraceletInfo.wareInfo}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    状态 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnBraceletInfo.state}</p>
                                </div>
                            </div>
                        </div>
                         <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    网关 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnBraceletInfo.netIp}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row border-txt">
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
           标签信息 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnBraceletInfo.rfidId}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-4 control-label" for="form_control_1">
                                    员工编码 <span class="required">*</span>
                                </label>
                                <div class="col-md-8">
                                    <p  class="form-control-static">${wsnBraceletInfo.employeeId}</p>
                                </div>
                            </div>
                        </div>
                         <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <div class="col-md-offset-6">
                                    <c:if test="${hid ==0 }">
                                        <button type="submit" class="btn green">修改</button>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                     <div class="row ">
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
                                            <td>${sensor[0] }</td>
                                            <td>${sample[0] }</td>
                                            <td>${alrm[0] }</td>
                                            <td>${metric[0] }</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>${sensor[1] }</td>
                                            <td>${sample[1] }</td>
                                            <td>${alrm[1] }</td>
                                            <td>${metric[1] }</td>
                                        </tr>
                                       <tr>
                                            <td>3</td>
                                           <td>${sensor[2] }</td>
                                            <td>${sample[2] }</td>
                                            <td>${alrm[2] }</td>
                                            <td>${metric[2] }</td>
                                        </tr>
                                       <tr>
                                            <td>4</td>
                                            <td>${sensor[3] }</td>
                                            <td>${sample[3] }</td>
                                            <td>${alrm[3] }</td>
                                            <td>${metric[3] }</td>
                                        </tr>
                                    </tbody>
                                </table>
                     </div>
                     <div class="col-md-9 model-hidden">
                          <input type="hidden" value="${wsnBraceletInfo.bwareId}" name="bwareId" id="bwareId">
                    </div>
                </form>
            </div>
        </div>
    </div>

<%@include file="../../included/includedJs.jsp" %>

</body>
</html>