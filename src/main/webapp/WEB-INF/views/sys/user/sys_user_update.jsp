<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../included/includedStyle.jsp" %>
</head>

<body>
    <div class="wrapper">
        <div class="row">
            <div class="col-md-12">
                <div class="wrapper-content">
                    <div class="portlet-title">
                        <div class="caption font-dark">
                            <i class="icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 修改角色 </span>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <form action="#" class="form-horizontal" id="form-user">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            用户名<span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value="${sysUser.userName}" name="userName" id="userName">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入用户名称</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            用户密码 
                                        </label>
                                        <div class="col-md-8">
                                        <input type="password" class="form-control" placeholder="" name="password" id="password">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入用户密码</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            确认密码 
                                        </label>
                                        <div class="col-md-8">
                                        <input type="password" class="form-control" placeholder="" name="password2" id="password2">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请再次输入用户密码</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            姓名
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value="${sysUser.realName}" name="realName" id="realName">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入真实姓名 </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            用户角色 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <select class="selectpicker form-control" name="baseId"  id="baseId" >
                                                <c:if test="${sysUser.baseId == 1 }">
                                                    <option value="1" selected>管理人员</option>
                                                    <option value="2">普通用户</option>
                                                </c:if>
                                                <c:if test="${sysUser.baseId == 2 }">
                                                    <option value="1" >管理人员</option>
                                                    <option value="2" selected>普通用户</option>
                                                </c:if>
                                            </select> 
                                           <!--  <label class="selectpicker form-control" name="baseId"  id="baseId">系统管理员</label> -->
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请选择用户角色</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            电子邮箱
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder=""  value="${sysUser.email}" name="email" id="email">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入电子邮箱 </span>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            电话号码
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" value="${sysUser.phoneId}" name="phoneId" id="phoneId">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入电话号码</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6"  model-hidden>
                                    <div class="form-group form-md-line-input">
                                       
                                        <div class="col-md-8">
                                             <input type="hidden" value="1" name="userSts" id="userSts">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请选择用户状态 </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-2 control-label" for="form_control_1">
                                            备注
                                        </label>
                                        <div class="col-md-10">
                                            <input type="text" class="form-control" placeholder="" value="${sysUser.remark}" name="remark" id="remark">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入备注</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                   <div class="col-md-9 model-hidden">
                                        <input type="hidden" value="${sysUser.userId}" name="userId" id="userId">
                                    </div>
                                </div>
                            </div>
                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button type="submit" class="btn green">更 新</button>
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
    $.validator.setDefaults({
        rules: {
            userName:"required",
            email: "email",
        	password2:{
                equalTo:"#password"
            },
            
        },
        submitHandler: function(form) {
        	var strRoleId = 4;
        	ajaxSubmitUpdate('sys/user/update/' + strRoleId, form);
        }
    });
    //[2]表单校验初始化
    initFormValidate1('form-user');
    
    var strRoleIds = '${roleIds}';
    var roleIdAry = strRoleIds.split(",");
    $('#roleIds').val(roleIdAry);
    $('#roleIds').selectpicker('refresh');
    
});



</script>



</body>
</html>