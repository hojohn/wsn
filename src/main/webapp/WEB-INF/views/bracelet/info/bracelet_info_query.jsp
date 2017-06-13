<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<title>可穿戴设备信息表</title>
<%@include file="../../included/includedStyle.jsp" %>
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
                <form action="#" class="form-horizontal">
                    <div class="form-body">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">硬件编号</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="bwareId">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">硬件类型</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="typeId">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">rfid标签外键</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="rfidId">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">员工id外键</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="employeeId">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">更新时间</label>
                                    <div class="col-md-8">
                                        <div class="input-group date-picker input-daterange" data-date="2012-12-12" data-date-format="yyyy-mm-dd">
                                            <input type="text" class="form-control" name="from" id="beginDate" readonly AUTOCOMPLETE="off">
                                            <span class="input-group-addon"> 到 </span>
                                            <input type="text" class="form-control" name="to" id="endDate" readonly AUTOCOMPLETE="off">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">监控对象外键</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="objId">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">传感器名字</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="sensorName">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">硬件名</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wareName">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">硬件信息</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wareInfo">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">状态</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="state">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">网关</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="netIp">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">包含设备固定的</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="infoOne">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">采样周期</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="sampleData">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">阈值</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="alrmData">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">度量单位</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="metricData">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">备用字段1</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="remark1">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">备用字段2</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="remark2">
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
<!--                     <div class="portlet-title"> -->
<!--                         <div class="caption font-dark"> -->
<!--                             <i class=" icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 产品发布信息 </span> -->
<!--                         </div> -->
<!--                     </div> -->
                    <div class="portlet-body">
                        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="tabWsnBraceletInfo" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th class="checkbox-datatables"><input type="checkbox" id="tab-th-chk" /></th>
                                    <th>硬件类型</th>
                                    <th>rfid标签外键</th>
                                    <th>员工id外键</th>
                                    <th>更新时间</th>
                                    <th>监控对象外键</th>
                                    <th>传感器名字</th>
                                    <th>硬件名</th>
                                    <th>硬件信息</th>
                                    <th>状态</th>
                                    <th>网关</th>
                                    <th>包含设备固定的</th>
                                    <th>采样周期</th>
                                    <th>阈值</th>
                                    <th>度量单位</th>
                                    <th>备用字段1</th>
                                    <th>备用字段2</th>
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
    <div style="display:none" id="btn-data-tools">
        <shiro:hasPermission name="prod:delete">
        <span class="dt-buttons">
            <a class="dt-button btn red btn-outline btn-mnt" id="btnDelete" >
                <span>删除</span>
            </a>
        </span>
        <span class="dt-buttons">
            <a class="dt-button btn yellow btn-outline btn-mnt" id="btnUpdate">
                <span>修改</span>
            </a>
         </span>
        <span class="dt-buttons">
            <a class="dt-button btn dark btn-outline btn-mnt btnAdd" id="btnAdd">
                <span>添加</span>
            </a>
         </span>
         </shiro:hasPermission>
    </div>

<%@include file="../../included/includedJs.jsp" %>

<script>
    $(function() {

        var tableObj = $('#tabWsnBraceletInfo').DataTable(getConfig());
        $('#btnQuery').click(function(e) {
            var strBwareId = $("#bwareId").val();
            var strTypeId = $("#typeId").val();
            var strRfidId = $("#rfidId").val();
            var strEmployeeId = $("#employeeId").val();
            var strUpdateTime = $("#updateTime").val();
            var strObjId = $("#objId").val();
            var strSensorName = $("#sensorName").val();
            var strWareName = $("#wareName").val();
            var strWareInfo = $("#wareInfo").val();
            var strState = $("#state").val();
            var strNetIp = $("#netIp").val();
            var strInfoOne = $("#infoOne").val();
            var strSampleData = $("#sampleData").val();
            var strAlrmData = $("#alrmData").val();
            var strMetricData = $("#metricData").val();
            var strRemark1 = $("#remark1").val();
            var strRemark2 = $("#remark2").val();
            var sUrl = "bracelet/info/query?";
            sUrl += 
                "&bwareId=" + strBwareId +
                "&typeId=" + strTypeId +
                "&rfidId=" + strRfidId +
                "&employeeId=" + strEmployeeId +
                "&updateTime=" + strUpdateTime +
                "&objId=" + strObjId +
                "&sensorName=" + strSensorName +
                "&wareName=" + strWareName +
                "&wareInfo=" + strWareInfo +
                "&state=" + strState +
                "&netIp=" + strNetIp +
                "&infoOne=" + strInfoOne +
                "&sampleData=" + strSampleData +
                "&alrmData=" + strAlrmData +
                "&metricData=" + strMetricData +
                "&remark1=" + strRemark1 +
                "&remark2=" + strRemark2;
            tableObj.ajax.url(sUrl).load();
        });
        
        $('.reload').on('click', function() {
            $('#bwareId').val('');
            $('#typeId').val('');
            $('#rfidId').val('');
            $('#employeeId').val('');
            $('#updateTime').val('');
            $('#objId').val('');
            $('#sensorName').val('');
            $('#wareName').val('');
            $('#wareInfo').val('');
            $('#state').val('');
            $('#netIp').val('');
            $('#infoOne').val('');
            $('#sampleData').val('');
            $('#alrmData').val('');
            $('#metricData').val('');
            $('#remark1').val('');
            $('#remark2').val('');
            tableObj.ajax.url('bracelet/info/query?bwareId=-1').load();
        });
        
        //修改按钮
        $('.div_right').on('click', '.dt-buttons>#btnUpdate',function() {
            var checkedBox = $("#tabWsnBraceletInfo tbody tr td .checked");
            var checkedLength = checkedBox.length;
            if(checkedLength == 0) {
                showMsg("请选择需要修改的数据！");
                return;
            }
            if(checkedLength > 1) {
                showMsg("只能选择一条数据进行修改操作！");
                return;
            }
            var strBwareId = checkedBox.find('input:checkbox').val();
            showModal(2, " ", [ '1000px', '500px' ], "bracelet/info/update_page/" + strBwareId, tableObj);
        });
        
        //新增
        $('.div_right').on('click', '.dt-buttons>#btnAdd', function(){
            showModal(2, " ", ['1000px', '500px'], "bracelet/info/add_page", tableObj);
        });
        
        //删除按钮
        $('.div_right').on('click', '.dt-buttons>#btnDelete',function() {
            var checkedBox = $("#tabWsnBraceletInfo tbody tr td .checked");
            comfirmDeleteData(tableObj, checkedBox, 'bracelet/info/delete/');
        });
        
    });

    function getConfig() {
        return config = {
            "processing" : true,
            "pageLength" : 5,
            //"destroy": true,
            "lengthMenu" : [ [ 5, 10, 20, -1 ], [ 5, 10, 20, "All" ] ],
            "order" : [ [ 1, "asc" ] ],
            "serverSide" : false,
            "ajax" : {
                "url" : "bracelet/info/query?bwareId=-1"
            //    "async": false
            },
            "columns" : [ {
                "data" : "bwareId"
            }, {
                "data" : "typeId"
            }, {
                "data" : "rfidId"
            }, {
                "data" : "employeeId"
            }, {
                "data" : "updateTime"
            }, {
                "data" : "objId"
            }, {
                "data" : "sensorName"
            }, {
                "data" : "wareName"
            }, {
                "data" : "wareInfo"
            }, {
                "data" : "state"
            }, {
                "data" : "netIp"
            }, {
                "data" : "infoOne"
            }, {
                "data" : "sampleData"
            }, {
                "data" : "alrmData"
            }, {
                "data" : "metricData"
            }, {
                "data" : "remark1"
            }, {
                "data" : "remark2"
            }],
            "columnDefs": [{
                "orderable" : false,
                "searchable" : false,
                "targets": [0],
                "data": "bwareId",
                "render": function (data, type, full) {
                    return '<input type="checkbox" name="data-checkbox" value="' + data + '" />';
                 }
            },
            {
                "targets": [4],
                "data": "updateTime",
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