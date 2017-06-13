<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<title>状态表</title>
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
                                    <label class="control-label col-md-4"></label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="id">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">wsn_dev数据库状态</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wsnSts">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">RFID数据库状态</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="rfidSts">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">移动节点1</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="mn1Sts">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">移动节点2</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="mn2Sts">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">移动节点3</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="mn3Sts">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">移动节点4</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="mn4Sts">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">移动节点5</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="mn5Sts">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">移动节点6</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="mn6Sts">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">备用</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="status">
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
                        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="tabWsnCollectSts" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th class="checkbox-datatables"><input type="checkbox" id="tab-th-chk" /></th>
                                    <th>wsn_dev数据库状态</th>
                                    <th>RFID数据库状态</th>
                                    <th>移动节点1</th>
                                    <th>移动节点2</th>
                                    <th>移动节点3</th>
                                    <th>移动节点4</th>
                                    <th>移动节点5</th>
                                    <th>移动节点6</th>
                                    <th>备用</th>
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

        var tableObj = $('#tabWsnCollectSts').DataTable(getConfig());
        $('#btnQuery').click(function(e) {
            var strId = $("#id").val();
            var strWsnSts = $("#wsnSts").val();
            var strRfidSts = $("#rfidSts").val();
            var strMn1Sts = $("#mn1Sts").val();
            var strMn2Sts = $("#mn2Sts").val();
            var strMn3Sts = $("#mn3Sts").val();
            var strMn4Sts = $("#mn4Sts").val();
            var strMn5Sts = $("#mn5Sts").val();
            var strMn6Sts = $("#mn6Sts").val();
            var strStatus = $("#status").val();
            var sUrl = "collect/status/query?";
            sUrl += 
                "&id=" + strId +
                "&wsnSts=" + strWsnSts +
                "&rfidSts=" + strRfidSts +
                "&mn1Sts=" + strMn1Sts +
                "&mn2Sts=" + strMn2Sts +
                "&mn3Sts=" + strMn3Sts +
                "&mn4Sts=" + strMn4Sts +
                "&mn5Sts=" + strMn5Sts +
                "&mn6Sts=" + strMn6Sts +
                "&status=" + strStatus;
            tableObj.ajax.url(sUrl).load();
        });
        
        $('.reload').on('click', function() {
            $('#id').val('');
            $('#wsnSts').val('');
            $('#rfidSts').val('');
            $('#mn1Sts').val('');
            $('#mn2Sts').val('');
            $('#mn3Sts').val('');
            $('#mn4Sts').val('');
            $('#mn5Sts').val('');
            $('#mn6Sts').val('');
            $('#status').val('');
            tableObj.ajax.url('collect/status/query?id=-1').load();
        });
        
        //修改按钮
        $('.div_right').on('click', '.dt-buttons>#btnUpdate',function() {
            var checkedBox = $("#tabWsnCollectSts tbody tr td .checked");
            var checkedLength = checkedBox.length;
            if(checkedLength == 0) {
                showMsg("请选择需要修改的数据！");
                return;
            }
            if(checkedLength > 1) {
                showMsg("只能选择一条数据进行修改操作！");
                return;
            }
            var strId = checkedBox.find('input:checkbox').val();
            showModal(2, " ", [ '1000px', '500px' ], "collect/status/update_page/" + strId, tableObj);
        });
        
        //新增
        $('.div_right').on('click', '.dt-buttons>#btnAdd', function(){
            showModal(2, " ", ['1000px', '500px'], "collect/status/add_page", tableObj);
        });
        
        //删除按钮
        $('.div_right').on('click', '.dt-buttons>#btnDelete',function() {
            var checkedBox = $("#tabWsnCollectSts tbody tr td .checked");
            comfirmDeleteData(tableObj, checkedBox, 'collect/status/delete/');
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
                "url" : "collect/status/query?id=-1"
            //    "async": false
            },
            "columns" : [ {
                "data" : "id"
            }, {
                "data" : "wsnSts"
            }, {
                "data" : "rfidSts"
            }, {
                "data" : "mn1Sts"
            }, {
                "data" : "mn2Sts"
            }, {
                "data" : "mn3Sts"
            }, {
                "data" : "mn4Sts"
            }, {
                "data" : "mn5Sts"
            }, {
                "data" : "mn6Sts"
            }, {
                "data" : "status"
            }],
            "columnDefs": [{
                "orderable" : false,
                "searchable" : false,
                "targets": [0],
                "data": "id",
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