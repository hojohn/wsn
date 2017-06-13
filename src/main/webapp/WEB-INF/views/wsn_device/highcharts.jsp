<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<title>设备信息</title>
<%@include file="../included/includedStyle.jsp" %>
</head>

<body>
   
    
     <div class=" tabbable tabs-left"> 
      <ul class="nav nav-tabs">
        <li class="active"><a href="#tab1" data-toggle="tab">温度传感器</a></li>
        <li><a href="#tab2" data-toggle="tab">湿度传感器</a></li>
        <li><a href="#tab3" data-toggle="tab">粉尘传感器</a></li>
        <li><a href="#tab4" data-toggle="tab">噪音传感器</a></li>
      </ul>
      
      <div class="tab-content">
        <div class="tab-pane active" id="tab1">
            <hr>
            <div class="row">
                 <div class="col-md-6">
                    <div class="form-group">
                       <label class="control-label col-md-4">传输频率（秒）</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" id="transRate" value="1">
                        </div>
                        <div class="col-md-2">
                            <button type="button" id="btnQuery" class="btn green btn-mnt">修改</button>
                        </div>
                    </div>
                 </div>
                 <div class="col-md-6">
                    <div class="form-group">
                         <label class="control-label col-md-4">请选择监控对象</label>
                        <div class="dropdown col-md-4">
                            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
                                OBJ_C001_001
                            <span class="caret"></span>
                            </button>
                          <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">OBJ_C001_001</a></li>
                            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">OBJ_C002_002</a></li>
                            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">OBJ_C003_003</a></li>
                          </ul>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div id="container" class="wrapper">
            </div>  
        </div>
     
     
        <div class="tab-pane" id="tab2">
            <hr>
            <div class="row">
                 <div class="col-md-4">
                    <div class="form-group">
                       <label class="control-label col-md-4">传输频率</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="deviceName">
                        </div>
                    </div>
                 </div>
                 <div class="col-md-2">
                    <div class="form-group">
                        <label class="control-label col-md-4"></label>
                        <div class="col-md-4">
                            <button type="button" id="btnQuery" class="btn green btn-mnt">修改</button>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div id="container2" class="col-md-12">
                </div>  
            </div>
        </div>
        
        <div class="tab-pane" id="tab3">
          <hr>
            <div class="row">
                 <div class="col-md-4">
                    <div class="form-group">
                       <label class="control-label col-md-4">传输频率</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="deviceName">
                        </div>
                    </div>
                 </div>
                 <div class="col-md-2">
                    <div class="form-group">
                        <label class="control-label col-md-4"></label>
                        <div class="col-md-4">
                            <button type="button" id="btnQuery" class="btn green btn-mnt">修改</button>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div id="container3" class="col-md-12">
                </div>  
            </div>
        </div>
        
        
        <div class="tab-pane" id="tab4">
          <hr>
            <div class="row">
                 <div class="col-md-4">
                    <div class="form-group">
                       <label class="control-label col-md-4">传输频率</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="deviceName">
                        </div>
                    </div>
                 </div>
                 <div class="col-md-8">
                    <div class="form-group">
                        <label class="control-label col-md-4"></label>
                        <div class="col-md-4">
                            <button type="button" id="btnQuery" class="btn green btn-mnt">修改</button>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div id="container4" class="col-md-12">
                </div> 
            </div> 
        </div>
    </div>
   </div>   
<%@include file="../included/includedJs.jsp" %>
<script src="static/plugins/highcharts/highcharts.src.js" type="text/javascript"></script>
<script src="static/plugins/highcharts/modules/exporting.js" type="text/javascript"></script>
<script src="static/plugins/highcharts/themes/grid-light.js" type="text/javascript"></script>

<script>
  
$(function () {
    $(document).ready(function () {
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
        $('#container').highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {
                        var series = this.series[0];
                        var transRate =transRateT() ;
                        setInterval(function () {
                        	var tempe = getData();
                        	//var x = (new Date()).getTime();
                        	//var y = da[0].y;
                        series.addPoint([(new Date()).getTime(), tempe[0].y], true, true);  
                        }, transRate);
                    }
                }
            },
            title: {
                text: '对象C_001_001的 实时温度 '
            },
             xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: '单位 ：℃ '
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
                    for (i = -19; i <= 0; i += 1) {
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

//                              湿度 
 $(function () {
    $(document).ready(function () {
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
        $('#container2').highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {
                        var series = this.series[0];
                        setInterval(function () {
                            var humi = getData();
                            //var x = (new Date()).getTime();
                            //var y = da[0].y;
                        series.addPoint([(new Date()).getTime(), humi[0].x], true, true);  
                        }, 1000);
                    }
                }
            },
            title: {
                text: '湿度传感器一  实时湿度 '
            },
             xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: '单位 ：%RH '
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
                    for (i = -19; i <= 0; i += 1) {
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



//                粉尘 
 $(function () {
	    $(document).ready(function () {
	        Highcharts.setOptions({
	            global: {
	                useUTC: false
	            }
	        });
	        $('#container3').highcharts({
	            chart: {
	                type: 'spline',
	                animation: Highcharts.svg, // don't animate in old IE
	                marginRight: 10,
	                events: {
	                    load: function () {
	                        var series = this.series[0];
	                        setInterval(function () {
	                            var dut = getData();
	                            //var x = (new Date()).getTime();
	                            //var y = da[0].y;
	                        series.addPoint([(new Date()).getTime(), Math.random()], true, true);  
	                        }, 1000);
	                    }
	                }
	            },
	            title: {
	                text: '粉尘传感器一  实时数据  '
	            },
	             xAxis: {
	                type: 'datetime',
	                tickPixelInterval: 150
	            },
	            yAxis: {
	                title: {
	                    text: '单位 ：kg/m3 '
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
	                    for (i = -19; i <= 0; i += 1) {
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

 function create() {
    var series = new Array();
    $.ajax({
        type: "POST",
        url: "device/sensor/query",
        async: false, //表示同步，如果要得到ajax处理完后台数据后的返回值，最好这样设置
        success: function(data){
        	for(var index in data){
                for(var i=0;i<data[index].length;i++){
                	var dtime = data[index][i].createTime;
                	var number = data[index][i].temperature;
                	/*  var datum = function() {
                         var datum = [],
                             time = dtime,
                             t;
                         for(t=-16; t<=0; t++) {
                        	 datum.push({
                        		 createTime: dtime,
                        		 temperature: number
                             });
                         }
                         return datum;
                     }(); */
                	series.push({"x": dtime, "y": number});
                }
                }
        }
    }, false);  // false表示“遮罩”，前台不显示“请稍后”进度提示
   // console.log(series);
    return series;
} 

 
    function getData() {
    	var datas = new Array();
         $.ajax({
             type: "POST",
             url: "device/sensor/query",
             async: false, //表示同步，如果要得到ajax处理完后台数据后的返回值，最好这样设置
             success: function(wsnSensor2){    // 这wsnSensor2 是个形参，写什么都行，可以将后台中map所有的数据拿到
            	 var y = wsnSensor2.t;
            	 var x = wsnSensor2.h;
            	 
            	 datas.push({"x":x, "y": y});
            	 //console.log(wsnSensor2.wsnSensor2.id)
            	 //console.log(wsnSensor2.date)
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