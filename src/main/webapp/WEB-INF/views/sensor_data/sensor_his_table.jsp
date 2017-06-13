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
                                           <select name="sensor_select" class="form-control" id="sensor_select">
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
                                    <div class="col-md-2 pull-right" id="hhh">
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

<%@include file="../included/includedJs.jsp" %>
<script src="static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script src="static/plugins/highcharts/highcharts.src.js" type="text/javascript"></script>
<script src="static/plugins/highcharts/modules/exporting.js" type="text/javascript"></script>
<script src="static/plugins/highcharts/themes/grid-light.js" type="text/javascript"></script>
<script>
$('#beginDate').datetimepicker({
    format: 'yyyy-mm-dd hh:ii',
    autoclose: true,
    todayBtn: true,
    todayHighlight: true,  
});
$('#endDate').datetimepicker({
    format: 'yyyy-mm-dd hh:ii',
    autoclose: true,
    todayBtn: true,
});

var chart;
$(function () {
	 chart = new Highcharts.Chart({  
// $('#container').highcharts({
	 chart: {  
                //将报表对象渲染到层上  
            renderTo: 'container'  
        },  
        
    title: {
        text: '历史趋势',
        x: -20 //center
    },

    
    /* xAxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                     'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
    }, */
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
        borderWidth: 0,
        enabled: false
    },
    series: [{
        data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
    }]
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

/* $('#btnQuery').click(function(e) */
function getData(){
	var params = {};
	var strSensor = $("#sensor_select").find("option:selected").text();
	var strBeginDate = $("#beginDate").val();
    var strEndDate = $("#endDate").val();
    params.strBeginDate = strBeginDate;
    params.strEndDate = strEndDate;
    params.strSensor = strSensor;
    var sUrl = "device/sensor/history1";
   /*  sUrl += 
       // "&sensor=" + strSensor +
        "&beginDate=" + strBeginDate +
        "&endDate=" + strEndDate ; */
    var datas = new Array();
    $.ajax({
        url: sUrl,
        data:params, 
        type: 'POST',
        dataType: "json",
      //  data: "",
        async:false,
        success:function (data) {
        //	datas.push({"x":data.xName,"y":data.yData});
        //	console.log(data)
        datas.push(data.xName);
        datas.push(data.yData);
        chart.series[0].setData(data.yData);
        chart.xAxis[0].setCategories(data.xName);
        chart.yAxis[0].setTitle({text:data.metric});
       // chart.setTitle({text:"eee"});
       console.log(chart);
        },
        error:function() {
            showMsg("请输入正确的时间 ");
        }
    });
    return datas;
   
};



//$(".form_datetime").datetimepicker({format: 'yyyy-mm-dd hh:ii'});

</script>
</body>
</html>