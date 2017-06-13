<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<title>传感器实时数据</title>
<%@include file="../included/includedStyle.jsp" %>
</head>

<body>
     <div class=" tabbable tabs-left"> 
      <ul class="nav nav-tabs">
        <li class="active"><a href="#tab1" data-toggle="tab">${wsnHardwareInfo.wareId }</a></li>
      </ul>
      
      <div class="tab-content">
        <div class="tab-pane active" id="tab1">
            <hr>
            <div class="row">
                 <div class="col-md-6">
                    <div class="form-group">
                       <label class="control-label col-md-4">传输频率（秒）</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" id="transRate" value="2">
                        </div>
                        <div class="col-md-2">
                            <button type="button" id="btnQuery" onclick="transRateT()" class="btn green btn-mnt">修改</button>
                        </div>
                        <div class="col-md-4">
                        </div>
                    </div>
                 </div>
                 <div class="col-md-6">
                    <div class="col-md-10"></div>
                    <div class=" col-md-2">
                            <span class="dt-buttons">
                                    <a class="dt-button btn yellow btn-outline btn-mnt" id="btnUpdate" href="stat/index">
                                        <span>返回</span>
                                    </a>
                            </span>
                    </div>
                 </div>
            </div>
            <form action="#" class="form-horizontal" id="form-update">
                <div class="row">
                    <div class="col-md-12">
                        <div class="col-md-9 model-hidden">
                            <input type="hidden" value="${wsnHardwareInfo.wareId}" name="wareId" id="wareId">
                        </div>
                    </div>
                </div>
            </form>
            <br>
            <div id="container" class="wrapper">
            </div>  
        </div>
    </div>
   </div>   
<%@include file="../included/includedJs.jsp" %>
<script src="static/plugins/highcharts/highcharts.src.js" type="text/javascript"></script>
<script src="static/plugins/highcharts/modules/exporting.js" type="text/javascript"></script>
<script src="static/plugins/highcharts/themes/grid-light.js" type="text/javascript"></script>

<script>
  //alert('${wsnHardwareInfo.wareId}')
$(function () {
	  var transRate =1000;
	  var mySeries;
	  var timer;
    $(document).ready(function () {
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
        var dosetInterval = function(){
        	$('#btnQuery').click(function(){
        		clearInterval(timer);
        		timer = setInterval(function () {          ///写在setInterval内的才能循环 
                    var tempe = getData();
                    var transRate1 = transRateT() ;
                    transRate =  transRate1 ;
                
                mySeries.addPoint([(new Date()).getTime(), tempe[0].y], true, true);  
                }, transRate);
        	});
        }();
        $('#container').highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {
                        var series = this.series[0];
                        mySeries = series;
                       // console.log(transRate);
                       console.log(getData());
                        timer = setInterval(function () {          ///写在setInterval内的才能循环 
                            var tempe = getData();
                            var transRate1 = transRateT() ;
                            transRate =  transRate1 ;
                          //  console.log(transRate);
                            //var x = (new Date()).getTime();
                            //var y = da[0].y
                        series.addPoint([(new Date()).getTime(), tempe[0].y], true, true);  
                        }, transRate);
                    }
                }
            },
            title: {
                text: '监控对象：'+'${wsnHardwareInfo.objId}  '+' 监控信号：'+'${wsnHardwareInfo.wareName}'
            },
             xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: '单位 :'+'${wsnHardwareInfo.infoThree}'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            }, 
            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + '</b><br/>' +
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                        Highcharts.numberFormat(this.y, 2);
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            series: 
                     [{
                name: ' data',
                data: (function () {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;
                    for (i = -39; i <= 0; i += 1) {
                        data.push({
                            x: time + i * 1000,
                            y: Math.random()
                        });
                    }
                    //console.log(data);
                    return data;
                }())
            }]  
        });
    });
  //  one();
});

    
    function getData() {
        var datas = new Array();
        var params = {};
        params.wareId = '${wsnHardwareInfo.wareId}';
         $.ajax({
             type: "POST",
             url: "device/sensor/query",
             data:params, 
             async: false, //表示同步，如果要得到ajax处理完后台数据后的返回值，最好这样设置
             dataType:"json",
             success: function(wsnSensor2){    // 这wsnSensor2 是个形参，写什么都行，可以将后台中map所有的数据拿到
                 var y = wsnSensor2.t;
                 var x = wsnSensor2.h;
                 console.log("dd")
                 datas.push({"x":x, "y": y});
                 console.log(wsnSensor2)
             },
         error:function(data){  
             console.log(data)  
         }
         });
        return datas; 
     } 
  
function transRateT(){
    return document.getElementById("transRate").value*1000;
}
</script>
</body>
</html>