<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<title>硬件信息表</title>
<%@include file="../included/includedStyle.jsp" %>
</head>

<body>
<jsp:include page="../wsn_device/hardware/top.jsp" ></jsp:include>
    <div class="wrapper">
          <div class="portlet light bordered">
            <!-- <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-search"></i>
                    <span class="caption-subject font-blue-hoki bold uppercase">筛选条件</span>
                </div>
                <div class="tools">
                    <a href="" class="collapse"></a>
                    <a href="" class="reload"></a>
                </div>
            </div> -->
            <div class="portlet-body form">
                <form action="#" class="form-horizontal">
                    <div class="form-body">
                        <div class="row">
                             <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">监控对象</label>
                                    <div class="col-md-8">
                                       <!--  <input type="text" class="form-control" id="typeId"> -->
                                        <select name="objId" class="form-control select2" id="objId">
                                                <option value="-1">全部</option>
                                                <c:forEach items="${objList }" var="obj">
                                                    <option value="${obj.monitorObjId}">${obj.monitorObjId}</option>
                                                </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">刷新频率（秒）</label>
                                    <div class="col-md-8">
                                         <input type="text" class="form-control" id="transRate" value="2">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label class="control-label col-md-4"></label>
                                    <div class="col-md-4">
                                        <button type="button" id="btnQuery" class="btn green btn-mnt" onclick="qurey()">筛选</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        
        
        <div class="row">
            <div class="col-md-12">
                <div class="wrapper-content">
<!--                     <div class="portlet-title"> -->
<!--                         <div class="caption font-dark"> -->
<!--                             <i class=" icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 产品发布信息 </span> -->
<!--                         </div> -->
<!--                     </div> -->
                    <div class="portlet-body">
                        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="tabWsnHardwareInfo" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>硬件编号</th>
                                    <th>硬件名称</th>
                                    <th>硬件类型</th>
                                    <th>所属对象</th>
                                    <th>状态</th>
                                    <th>频率(秒)</th>
                                    <th>采集时间</th>
                                    <th>实时数据</th>
                                </tr>
                            </thead>
                            <tbody>
                               <%--  <c:forEach items="${deviceList }" var="data">
                                    <tr>
                                        <td class="checkbox-datatables"><input type="checkbox" value="${data.wareId }" /></td>
                                        <td>${data.infoThree }</td>
                                        <td>${data.wareName }</td>
                                        <td>${data.getewaytxt }</td>
                                        <td>${data.wareKey }</td>
                                        <td><fmt:formatDate value="${data.updateTime}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
                                        <td>${data.stateTxt }</td>
                                        <td>${data.remark1 }</td>
                                    </tr>
                                </c:forEach> --%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
  

<%@include file="../included/includedJs.jsp" %>

<script>
    $(function() {
    	//var t = 2000 ;
        var tableObj = $('#tabWsnHardwareInfo').DataTable(getConfig());
        var timer = setInterval( function () {
        	tableObj.ajax.reload();
        }, 2000 );
        $('#btnQuery').click(function(e) {
        	var t = document.getElementById("transRate").value*1000;
        	clearInterval(timer);
        	 timer = setInterval( function () {
                tableObj.ajax.reload();
            }, t);
            var strRemark2 = $("#objId").val();
            strRemark2 = strRemark2 == -1 ? "" : strRemark2;
            console.log(strRemark2);
            var sUrl = "stat/list/query?";
            sUrl += 
                "&objId=" + strRemark2 ;
            tableObj.ajax.url(sUrl).load();
        })
    }); 
   
    function getConfig() {
        return config = {
            "processing" : false,
            "pageLength" : -1,
            "lengthChange": false,
            //"destroy": true,
            //"lengthMenu" : [ [ 5, 10, 20, -1 ], [ 5, 10, 20, "All" ] ],
            "order" : [ [ 0, "asc" ] ],
            "serverSide" : false,
            "ajax" : {
                "url" : "stat/list/query "
            //    "async": false
            }, 
             "columns" : [ {
                "data" : "wareId"
            }, {
                "data" : "wareName"
            }, {
                "data" : "typeTxt"
            }, {
                "data" : "objId"
            }, {
                "data" : "state"
            }, {
                "data" : "remark1"
            }, {
                "data" : "infoFive"
            }, {
                "data" : "infoFour"
            }],
             "columnDefs": [{
                "targets": [4],
                "data": "state",
                "render": function (data, type, full) {
                   if(data == "运行") {
                	   return '<font color="green">'+data+'</font>'
                   }else return '<font color="red">'+data+'</font>'
                 }
            },
            ],
            "sScrollX": "100%",
            "dom" : '<"top"l<"div_right">>rt<"bottom"ip><"clear">',
            "initComplete" : initTab, 
            "createdRow": function ( row, data, index ) {
                $('td', row).eq(0).addClass('checkbox-datatables');
             },
            "language" : {
               "processing" : "努力加载数据中...",
                "lengthMenu" : "_MENU_ 条记录每页",
                "zeroRecords" : "没有查询到数据",
                "info" : "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
                "infoEmpty" : "无记录",
                "infoFiltered" : "(从 _MAX_ 条记录过滤)",
                "paginate" : {
                    "previous" : "上一页",
                    "next" : "下一页"
                }
            }
        };
    }
    function transRateT(){
    	alert(document.getElementById("transRate").value*1000);
        return document.getElementById("transRate").value*1000;
    }  
</script>
</body>
</html>