<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>设备信息</title>
<%@include file="../included/includedStyle.jsp" %>
<link href="static/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <div class="wrapper">
        <div class="portlet light bordered">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-search"></i>
                    <span class="caption-subject font-blue-hoki bold uppercase">查询条件</span>
                </div>
                <div class="tools">
                    <a href="" class="collapse"></a>
                    <a href="" class="reload"></a>
                </div>
            </div>
            <div class="portlet-body form">
                <form action="#" class="form-horizontal" name="frm">
                    <div class="form-body">
                        <div class="row">
                             <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-2 control-label" for="form_control_1">
                                            监控对象 
                                        </label>
                                        <div class="col-md-4">
                                            <select name="remark2" class="selectpicker form-control" id="remark2" onchange="showSensor(this);">
                                                 <option value="-1" selected >请选择监控对象</option>
                                                <c:forEach items="${moniList }" var="m">
                                                    <option value="${m.monitorObjId }">${m.monitorObjId }</option>
                                                </c:forEach>
                                            </select>
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入监控地点</span>
                                        </div>
                                        <label class="col-md-2 control-label" for="form_control_1">
                                            传感器 
                                        </label>
                                        <div class="col-md-4" id="eee">
                                           <select name="sensor_select" class="form-control  " id="sensor_select" >
                                                <option value="-1">请选择传感器</option>
                                           </select>
                                           <div class="form-control-focus"></div>
                                            <span class="help-block">请输入传感器</span>
                                        </div>
                                    </div>
                                </div>
                                 <div class="col-md-6">
                                      <div class="form-group">
                                        <label class="control-label col-md-4">选择时间</label>   <!--input-daterange date-picker data-date="2012-12-12" data-date-format="yyyy-mm-dd" -->
                                        <div class="col-md-8">
                                            <div class="input-group input-daterange " >
                                                <input type="text" class="form-control" name="from" id="beginDate"  readonly AUTOCOMPLETE="off" >
                                                <span class="input-group-addon"> 到 </span>
                                                <input type="text" class="form-control" name="to" id="endDate" readonly AUTOCOMPLETE="off">
                                            </div>
                                        </div>
                                       </div>
                                  </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <div class="col-md-2 control-label pull-right" >
                                        <button type="button" id="btnQuery" class="btn green btn-mnt">查询</button>
                                       <!--  <button type="button" id="btnCopy" onclick="" class="btn red btn-mnt">导出</button> -->
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
                        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="tabWsnSensor" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>记录编号</th>
                                    <th>传感器ID</th>
                                    <th>传感器值</th>
                                    <th>状态</th>
                                    <th>时间</th>
                                    <th>采集周期</th>
                                    
                                    <!-- <th>频率</th> -->
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
<div style="display:none" id="btn-data-tools"><!--  -->
        <span class="dt-buttons">
            <a class="dt-button btn green btn-outline btn-mnt"  id="btnOutput">
                <span >导出</span>
            </a>
        </span>
    </div>
<%@include file="../included/includedJs.jsp" %>
<script src="static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script>


$('#beginDate').datetimepicker({
    format: 'yyyy-mm-dd hh:ii',
    autoclose: true,
    todayBtn: true,
    todayHighlight: true,  
});
$('#endDate').datetimepicker({
    format: 'yyyy-mm-dd hh:ii',
    autoclose:       true,
    todayBtn: true,
});
/* $('.div_right').on('click', '.dt-buttons>#btnOutput',function() {
	    alert("ss")
	    console.log("dd")
	    var strBeginDate = $("#beginDate").val();
	    var strEndDate = $("#endDate").val();
	    var strSensor = $("#sensor_select").find("option:selected").text();
	    var sUrl = "device/export/excel?";
	    sUrl +="sensor=" + strSensor + 
	        "&beginDate1=" + strBeginDate +
	        "&endDate1=" + strEndDate ;
	    window.location.href = sUrl;
	}) */

$(function() {
	  var tableObj = $('#tabWsnSensor').DataTable(getConfig());  //getConfig()
      $('#btnQuery').click(function(e) {
    	    var strBeginDate = $("#beginDate").val();
    	    var strEndDate = $("#endDate").val();
    	    var strSensor = $("#sensor_select").find("option:selected").text();
    	    var sUrl = "device/export/query?";
    	    sUrl +="sensor=" + strSensor + 
    	        "&beginDate1=" + strBeginDate +
    	        "&endDate1=" + strEndDate ;
    	    tableObj.ajax.url(sUrl).load();
      });
      
       $('.div_right').on('click', '.dt-buttons>#btnOutput',function() {
    	  var strBeginDate = $("#beginDate").val();
          var strEndDate = $("#endDate").val();
          var strSensor = $("#sensor_select").find("option:selected").text();
          var sUrl = "device/export/excel?";
          sUrl += "sensor=" + strSensor + 
              "&beginDate=" + strBeginDate +
              "&endDate=" + strEndDate ;
          if(strBeginDate.length==0 || strEndDate.length == 0){
        	  showMsg("请输入传感器以及的时间 ");
          }else{
        	  window.location.href = sUrl;
          }
         
          
         /*  $.ajax({
              url: sUrl,
              type: 'POST',
              dataType: "json",
            //  data: "",
              processData: false,  
              contentType: false,
              async:false,
              success:function () {
                  showMsg("成功导出D盘下 ");
              },
              error:function() {
                  showMsg("shibai！");
              }
          }); */
      }); 

});

 function  showSensor(obj){
    var params = {};  
    var opt = obj.options[obj.selectedIndex].value;
    params.opt=opt;
    $.ajax({
        async:false,  
        type: "POST",  
        url: "device/history/sensor_list",//注意路径  
        data:params,  
        dataType:"json",  
        success:function(data){ 
            document.getElementById("sensor_select").length=0;
                for(var index in data){
                   for(var i=0;i<data[index].length;i++){
                    //  console.log(data[index][i].infoThree)
                       $("#sensor_select").append("<option value=" + i + ">" + data[index][i].wareId + "</option>");
                   }
               } 
        },  
        error:function(data){  
            alert(data.result);  
        }  
    });
} 
function getConfig() {
    return config = {
        "processing" : true,
        "pageLength" : 5,
        //"destroy": true,
        "lengthMenu" : [ [ 5, 10, 20, -1 ], [ 5, 10, 20, "All" ] ],
        "order" : [ [ 1, "asc" ] ],
        "serverSide" : false,
         "ajax" : {
            "url" : "device/export/query?id=-1"
        //    "async": false
        },
        "columns" : [ {
            "data" : "id"
        }, {
            "data" : "wareId"
        }, {
            "data" : "temperatureValue"
        }, {
            "data" : "state"
        }, {
            "data" : "createTime"
        } , {
            "data" : "rate"
        }],
         "columnDefs": [{
            "targets": [3],
            "data": "state",
            "render": function (data, type, full) {
            	if(data == 0){
            		return '<a href="javascript:;" ><span class="label label-sm label-primary"> 正常 </span></a>';
            	}
             }
        },
        {
        	 "targets": [4],
             "data": "createTime",
             "render": function (data, type, full) {
                 if(data == null || data == "") {
                     return "";
                 }
                 return new Date(data).format("yyyy-MM-dd hh:mm:ss");
              }
        },
        ], 
        "sScrollX": "2000px",
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
</script>
</body>
</html>