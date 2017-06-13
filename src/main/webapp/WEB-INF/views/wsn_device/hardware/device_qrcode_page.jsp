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
                            <i class="icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 二维码 </span>
                        </div>
                    </div>
                    <div id="qrcode" >
                        <div  >
                       
                        </div>
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
    
    };
    //[2]表单校验初始化
    initFormValidate('form-update', rules, 'device/bind/update', 'update');
  
    //二维码 
$("#qrcode").qrcode({ 
        render: "table", //table方式 
        width: 100, //宽度 
        height:100, //高度 
        text: result() //任意内容 
    });
});
function result(){
	return "55"
}
</script>
</body>
</html>