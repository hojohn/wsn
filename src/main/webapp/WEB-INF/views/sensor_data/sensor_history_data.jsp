<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<title>历史数据</title>
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
                           <!--  <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">传感器</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="deviceNumber">
                                    </div>
                                </div>
                            </div> -->
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
                                        <button type="button" id="btnQuery" class="btn green btn-mnt">查询</button>
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
<%@include file="../included/includedJs.jsp" %>
<script src="static/plugins/highcharts/highcharts.src.js" type="text/javascript"></script>
<script src="static/plugins/highcharts/modules/exporting.js" type="text/javascript"></script>
<script src="static/plugins/highcharts/themes/grid-light.js" type="text/javascript"></script>
<script src="static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.fr.js" type="text/javascript"></script>
<script src="static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js" type="text/javascript"></script>

<script>
console.log('${xName[0]}')
$('#btnQuery').click(function(e) { 
	
var chart;  
var num = [];
$(function(){
	var strBeginDate = $("#beginDate").val();
    var strEndDate = $("#endDate").val();
    var strSensor = $("#sensor").find("option:selected").text();
    var sUrl = "device/sensor/history?";
    sUrl += 
       // "&deviceName=" + strDeviceName +
        "&sensor=" + strSensor +
        "&beginDate=" + strBeginDate +
        "&endDate=" + strEndDate ;
    $.ajax({  
       type: "GET",  
       dataType: "JSON",  
       url: sUrl,  //改成你的Action
           success : function(result){ 
                for(var i = 0; i < 20;i++){
                   // num[i] = parseInt(result.rows[i].fid);
                     num[i] = Math.random();          
                }
          //此处构建曲线  
              $("#container").highcharts({  
    
        chart:{  
             defaultSeriesType: "spline",//图表的显示类型（line,spline,scatter,splinearea bar,pie,area,column）  
             marginRight: 125,//上下左右空隙  
             marginBottom: 25 //上下左右空隙  
        },  
        title:{  
            text: "插件分析视图",//主标题  
                x: -20 //center  
        },  
        xAxis: {   //横坐标  
            categories: num
        },  
            yAxis: {  
           title: {  
             text: "测试" //纵坐标  
               },  
               plotLines: [{  //标线属性  
            value: 0,  
             width: 1,  
             color: 'red'  
                }]  
              },  
             tooltip: { //数据点的提示框  
             formatter: function() { //formatter格式化函数  
             return  this.series.name +  
             this.x +': '+ this.y;  
            }  
        },  
        legend: {  
              layout: 'vertical',  
              align: 'right',  
              verticalAlign: 'top',  
              x: -10,  
              y: 100,  
              borderWidth: 0  
             },   
        series:[{
            data:num
        }]
         });
       }  
    });  
}); 



  
     
}); 


//获取一级菜单长度 
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
  
 


   /*  function getData() {
    	var strBeginDate = $("#beginDate").val();
        var strEndDate = $("#endDate").val();
        var strSensor = $("#sensor").find("option:selected").text();
        var sUrl = "device/sensor/history?";
        sUrl += 
           // "&deviceName=" + strDeviceName +
            "&sensor=" + strSensor +
            "&beginDate=" + strBeginDate +
            "&endDate=" + strEndDate ;
        var datas = new Array();
        
         $.ajax({
             type: "POST",
             url: sUrl,
             async: false, //表示同步，如果要得到ajax处理完后台数据后的返回值，最好这样设置
             success: function(data){    // 这wsnSensor2 是个形参，写什么都行，可以将后台中map所有的数据拿到
                 //var y = data.xName;
                 //var x = data.yData;
                 //datas.push({"x":x, "y": y});
                 //console.log(wsnSensor2.wsnSensor2.id)
                 console.log("111");
                 //console.log(data);
             }
         });
        
        return datas; 
     } 
  
     */
  
$('.form_datetime').datetimepicker({
    //language:  'fr',
    weekStart: 1,
    todayBtn:  1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    forceParse: 0,
    showMeridian: 1
});
$('.form_date').datetimepicker({
    language:  'fr',
    weekStart: 1,
    todayBtn:  1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    minView: 2,
    forceParse: 0
});
$('.form_time').datetimepicker({
    language:  'fr',
    weekStart: 1,
    todayBtn:  1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 1,
    minView: 0,
    maxView: 1,
    forceParse: 0
});

$(".form-control").datetimepicker({
	format: 'yyyy-mm-dd hh:ii',
	autoclose:true,
	minuteStep:1,
	todayHighlight:true,
	});
</script>
</body>
</html>