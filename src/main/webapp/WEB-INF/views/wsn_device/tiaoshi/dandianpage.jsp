<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>单点调试</title>
<%@include file="../../included/includedStyle.jsp" %>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="wrapper">
        <div class="wrapper-content">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class=" icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 通信状态 </span>
                </div>
            </div>
            <div class="portlet-body">
           <table class="table table-striped">
    <thead>
        <tr>
            <th>序号</th>
            <th>移动节点名称</th>
            <th>监测对象</th>
            <th>移动节点IP地址</th>
            <th>型号信息</th>
            <th>移动节点状态</th>
        </tr>
    </thead>
    <tbody>
    <% int i=1; %>
    <c:forEach items="${wsnHardwareInfo}" var="s">
        <tr>
            <td><%=i%></td>
            <td>${ s.ware_id}</td>
            <td>${s.obj_id }  </td>
            <td>${ s.net_ip}</td>
            <td>${ s.ware_info}</td>
            <td>${ s.state }</td>
       <%i++; %>
        </tr>
     </c:forEach>
    </tbody>
</table>
            </div>
            
            </div>
            </div>
 <%@include file="../../included/includedJs.jsp" %>
            
</body>
</html>