<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<title>设备信息</title>
<%@include file="../../included/includedStyle.jsp" %>
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
                                <div class="form-group">
                                    <!-- <label class="control-label col-md-4">传感器类型</label> -->
                                    <div class="col-md-4">
                                        <!-- <input type="text" class="form-control" id="deviceName"> -->
                                        <select name="s1" onChange="redirec(document.frm.s1.options.selectedIndex)"> 
                                            <option selected>请选择传感器类型</option> 
                                            <option value="1">温度传感器</option> 
                                            <option value="2">湿度传感器</option> 
                                            <option value="3">噪声传感器</option> 
                                            <option value="4">粉尘传感器</option> 
                                        </select>
                                    </div>
                                    <div class="col-md-4">
                                        <select name="s2" id="sensor"> 
                                            <option value="请选择" selected>请选择</option> 
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                   <label class="control-label col-md-4">日期</label>
                                    <div class="col-md-6">
                                        <div class="controls  input-append" >
                                            <input type="text" class="form-control" value="" name="from" id="beginDate"  readonly AUTOCOMPLETE="off" >
                                            <span class="input-group-addon"> 到 </span>
                                            <input type="text" class="form-control" name="to" id="endDate" readonly AUTOCOMPLETE="off" AUTOCOMPLETE="off">
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label class="control-label col-md-4"></label>
                                    <div class="col-md-4">
                                        <button type="button" id="btnQuery" onclick="getData()" class="btn green btn-mnt">查询</button>
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
                   <div class="portlet-body" id="container">
                       
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@include file="../../included/includedJs.jsp" %>
<script src="static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.fr.js" type="text/javascript"></script>
<script src="static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script src="static/plugins/highcharts/highcharts.src.js" type="text/javascript"></script>
<script src="static/plugins/highcharts/modules/exporting.js" type="text/javascript"></script>
<script src="static/plugins/highcharts/themes/grid-light.js" type="text/javascript"></script>
<script>
/* $('#btnQuery').click(function(e) */
	function getData(){
	var strBeginDate = $("#beginDate").val();
    var strEndDate = $("#endDate").val();
    var strSensor = $("#sensor").find("option:selected").text();
    var sUrl = "device/sensor/history?";
    sUrl += 
        "&sensor=" + strSensor +
        "&beginDate=" + strBeginDate +
        "&endDate=" + strEndDate ;
    var datas = new Array();
    $.ajax({
        url: sUrl,
        type: 'POST',
       // dataType: "json",
      //  data: "",
        processData: false,  
        contentType: false,
        async:false,
        success:function (data) {
        //	datas.push({"x":data.xName,"y":data.yData});
        //	console.log(data)
        datas.push(data.xName);
        datas.push(data.yData);
        console.log(datas)
        },
        error:function() {
            showMsg("有错误 ");
        }
    });
    return datas;
   // console.log(datas[0])
};

$(function () {
    $('#container').highcharts({
        title: {
            text: 'Monthly Average Temperature',
            x: -20 //center
        },
        subtitle: {
            text: 'Source: WorldClimate.com',
            x: -20
        },
        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                         'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis: {
            title: {
                text: 'Temperature (°C)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '°C'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'Tokyo',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
        }]
    });
});

// 获取一级菜单长度 
var select1_len = document.frm.s1.options.length; 
var select2 = new Array(select1_len); 
//把一级菜单都设为数组 
for (i=0; i<select1_len; i++) 
{ select2[i] = new Array();} 
//定义基本选项 
select2[0][0] = new Option("请选择传感器", " "); 
 
select2[1][0] = new Option("SEN_WD01_001", "1"); 
select2[1][1] = new Option("SEN_WD02_002", " "); 
select2[1][2] = new Option("SEN_WD03_003", " "); 
 
select2[2][0] = new Option("SEN_SD01_001", " "); 
select2[2][1] = new Option("SEN_SD02_002", " "); 
select2[2][2] = new Option("SEN_SD03_003", " "); 
 
select2[3][0] = new Option("SEN_FC01_001", " "); 
select2[3][1] = new Option("SEN_FC02_002", " "); 
select2[3][2] = new Option("SEN_FC03_003", " "); 
//联动函数 
function redirec(x) 
{ 
    var temp = document.frm.s2; 
    for (i=0;i<select2[x].length;i++) 
        {
           temp.options[i]=new Option(select2[x][i].text,select2[x][i].value);
        } 
    temp.options[0].selected=true; 
    console.log(temp.options[0].selected)
} 

$(".form-control").datetimepicker({
    format: 'yyyy-mm-dd hh:ii',
    autoclose:true,
    minuteStep:1,
    todayHighlight:true,
    });




</script>
</body>
</html>