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
        <li class="active"><a href="#tab1" data-toggle="tab">温度传感器</a></li>
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
            </div>
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
                        // set up the updating of the chart each second
                        var series = this.series[0];
                        setInterval(function () {
                            var x = (new Date()).getTime(), // current time
                                y = Math.random();
                            series.addPoint([x, y], true, true);
                        }, 1000);
                    }
                }
            },
            title: {
                text: 'Live random data'
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: 'Value'
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
            series: [{
                name: 'Random data',
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
                    return data;
                }())
            }]
        });
    });
});

</script>
</body>
</html>