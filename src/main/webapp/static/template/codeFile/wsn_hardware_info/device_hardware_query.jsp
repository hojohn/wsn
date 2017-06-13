<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<title>硬件信息表</title>
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
                                        <input type="text" class="form-control" id="wareId">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">硬件名称</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wareName">
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
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">网关编号</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="objId">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">关键标志</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wareKey">
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
                                    <label class="control-label col-md-4">更新时间</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="updateTime">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">状态，1被占用，0未占用</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="state">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">备注1</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="remark1">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">备注2</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="remark2">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">信息1</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="infoOne">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">信息2</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="infoTwo">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">信息3</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="infoThree">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">信息4</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="infoFour">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">信息5</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="infoFive">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">ip地址</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="netIp">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">rfid外键</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="rfidId">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">员工外键</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="employeeId">
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
                        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="tabWsnHardwareInfo" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th class="checkbox-datatables"><input type="checkbox" id="tab-th-chk" /></th>
                                    <th>硬件名称</th>
                                    <th>硬件类型</th>
                                    <th>网关编号</th>
                                    <th>关键标志</th>
                                    <th>硬件信息</th>
                                    <th>更新时间</th>
                                    <th>状态，1被占用，0未占用</th>
                                    <th>备注1</th>
                                    <th>备注2</th>
                                    <th>信息1</th>
                                    <th>信息2</th>
                                    <th>信息3</th>
                                    <th>信息4</th>
                                    <th>信息5</th>
                                    <th>ip地址</th>
                                    <th>rfid外键</th>
                                    <th>员工外键</th>
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

        var tableObj = $('#tabWsnHardwareInfo').DataTable(getConfig());
        $('#btnQuery').click(function(e) {
            var strWareId = $("#wareId").val();
            var strWareName = $("#wareName").val();
            var strTypeId = $("#typeId").val();
            var strObjId = $("#objId").val();
            var strWareKey = $("#wareKey").val();
            var strWareInfo = $("#wareInfo").val();
            var strUpdateTime = $("#updateTime").val();
            var strState = $("#state").val();
            var strRemark1 = $("#remark1").val();
            var strRemark2 = $("#remark2").val();
            var strInfoOne = $("#infoOne").val();
            var strInfoTwo = $("#infoTwo").val();
            var strInfoThree = $("#infoThree").val();
            var strInfoFour = $("#infoFour").val();
            var strInfoFive = $("#infoFive").val();
            var strNetIp = $("#netIp").val();
            var strRfidId = $("#rfidId").val();
            var strEmployeeId = $("#employeeId").val();
            var sUrl = "device/hardware/query?";
            sUrl += 
                "&wareId=" + strWareId +
                "&wareName=" + strWareName +
                "&typeId=" + strTypeId +
                "&objId=" + strObjId +
                "&wareKey=" + strWareKey +
                "&wareInfo=" + strWareInfo +
                "&updateTime=" + strUpdateTime +
                "&state=" + strState +
                "&remark1=" + strRemark1 +
                "&remark2=" + strRemark2 +
                "&infoOne=" + strInfoOne +
                "&infoTwo=" + strInfoTwo +
                "&infoThree=" + strInfoThree +
                "&infoFour=" + strInfoFour +
                "&infoFive=" + strInfoFive +
                "&netIp=" + strNetIp +
                "&rfidId=" + strRfidId +
                "&employeeId=" + strEmployeeId;
            tableObj.ajax.url(sUrl).load();
        });
        
        $('.reload').on('click', function() {
            $('#wareId').val('');
            $('#wareName').val('');
            $('#typeId').val('');
            $('#objId').val('');
            $('#wareKey').val('');
            $('#wareInfo').val('');
            $('#updateTime').val('');
            $('#state').val('');
            $('#remark1').val('');
            $('#remark2').val('');
            $('#infoOne').val('');
            $('#infoTwo').val('');
            $('#infoThree').val('');
            $('#infoFour').val('');
            $('#infoFive').val('');
            $('#netIp').val('');
            $('#rfidId').val('');
            $('#employeeId').val('');
            tableObj.ajax.url('device/hardware/query?wareId=-1').load();
        });
        
        //修改按钮
        $('.div_right').on('click', '.dt-buttons>#btnUpdate',function() {
            var checkedBox = $("#tabWsnHardwareInfo tbody tr td .checked");
            var checkedLength = checkedBox.length;
            if(checkedLength == 0) {
                showMsg("请选择需要修改的数据！");
                return;
            }
            if(checkedLength > 1) {
                showMsg("只能选择一条数据进行修改操作！");
                return;
            }
            var strWareId = checkedBox.find('input:checkbox').val();
            showModal(2, " ", [ '1000px', '500px' ], "device/hardware/update_page/" + strWareId, tableObj);
        });
        
        //新增
        $('.div_right').on('click', '.dt-buttons>#btnAdd', function(){
            showModal(2, " ", ['1000px', '500px'], "device/hardware/add_page", tableObj);
        });
        
        //删除按钮
        $('.div_right').on('click', '.dt-buttons>#btnDelete',function() {
            var checkedBox = $("#tabWsnHardwareInfo tbody tr td .checked");
            comfirmDeleteData(tableObj, checkedBox, 'device/hardware/delete/');
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
                "url" : "device/hardware/query?wareId=-1"
            //    "async": false
            },
            "columns" : [ {
                "data" : "wareId"
            }, {
                "data" : "wareName"
            }, {
                "data" : "typeId"
            }, {
                "data" : "objId"
            }, {
                "data" : "wareKey"
            }, {
                "data" : "wareInfo"
            }, {
                "data" : "updateTime"
            }, {
                "data" : "state"
            }, {
                "data" : "remark1"
            }, {
                "data" : "remark2"
            }, {
                "data" : "infoOne"
            }, {
                "data" : "infoTwo"
            }, {
                "data" : "infoThree"
            }, {
                "data" : "infoFour"
            }, {
                "data" : "infoFive"
            }, {
                "data" : "netIp"
            }, {
                "data" : "rfidId"
            }, {
                "data" : "employeeId"
            }],
            "columnDefs": [{
                "orderable" : false,
                "searchable" : false,
                "targets": [0],
                "data": "wareId",
                "render": function (data, type, full) {
                    return '<input type="checkbox" name="data-checkbox" value="' + data + '" />';
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