<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<title>作业人员信息</title>
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
                                    <label class="control-label col-md-4">员工姓名</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="employeeName">
                                    </div>
                                </div>
                            </div>
                           <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">员工工号</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="employeeNumber">
                                    </div>
                                </div>
                            </div>
                             <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">员工部门</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="employeeDept">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">员工状态</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="employeeStatus">
                                    </div>
                                </div>
                            </div>
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
                        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="tabWsnEmployee" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th class="checkbox-datatables"><input type="checkbox" id="tab-th-chk" /></th>
                                    <th>员工姓名</th>
                                    <th>员工年龄</th>
                                    <th>出生日期</th>
                                    <th>员工工号</th>
                                    <th>员工部门</th>
                                    <th>员工性别，0男，1女</th>
                                    <th>身份证号</th>
                                    <th>电话号码</th>
                                    <th>参加工作时间</th>
                                    <th>持证种类</th>
                                    <th>员工状态，1在职，0离职</th>
                                    <th>备注</th>
                                    <th>删除标识，1删除，0未删除</th>
                                    <th>创建人</th>
                                    <th>创建时间</th>
                                    <th>修改人</th>
                                    <th>修改时间</th>
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

        var tableObj = $('#tabWsnEmployee').DataTable(getConfig());
        $('#btnQuery').click(function(e) {
            var strEmployeeName = $("#employeeName").val();
            var strEmployeeNumber = $("#employeeNumber").val();
            var strEmployeeDept = $("#employeeDept").val();
            var strEmployeeStatus = $("#employeeStatus").val();
            
            var sUrl = "employee/info/query?";
            sUrl += 
                "&employeeName=" + strEmployeeName +
                "&employeeNumber=" + strEmployeeNumber +
                "&employeeDept=" + strEmployeeDept +
                "&employeeStatus=" + strEmployeeStatus ;
            tableObj.ajax.url(sUrl).load();
        });
        
        $('.reload').on('click', function() {
            $('#personId').val('');
            $('#employeeName').val('');
            $('#employeeAge').val('');
            $('#employeeBirthday').val('');
            $('#employeeNumber').val('');
            $('#employeeDept').val('');
            $('#employeeGender').val('');
            $('#idcard').val('');
            $('#phoneNumber').val('');
            $('#firstWorkdate').val('');
            $('#certificateCategory').val('');
            $('#employeeStatus').val('');
            $('#remark').val('');
            $('#deleteFlag').val('');
            $('#creator').val('');
            $('#createDate').val('');
            $('#modifier').val('');
            $('#modifyDate').val('');
            tableObj.ajax.url('employee/info/query?personId=-1').load();
        });
        
        //修改按钮
        $('.div_right').on('click', '.dt-buttons>#btnUpdate',function() {
            var checkedBox = $("#tabWsnEmployee tbody tr td .checked");
            var checkedLength = checkedBox.length;
            if(checkedLength == 0) {
                showMsg("请选择需要修改的数据！");
                return;
            }
            if(checkedLength > 1) {
                showMsg("只能选择一条数据进行修改操作！");
                return;
            }
            var strPersonId = checkedBox.find('input:checkbox').val();
            showModal(2, " ", [ '1000px', '500px' ], "employee/info/update_page/" + strPersonId, tableObj);
        });
        
        //新增
        $('.div_right').on('click', '.dt-buttons>#btnAdd', function(){
            showModal(2, " ", ['1000px', '500px'], "employee/info/add_page", tableObj);
        });
        
        //删除按钮
        $('.div_right').on('click', '.dt-buttons>#btnDelete',function() {
            var checkedBox = $("#tabWsnEmployee tbody tr td .checked");
            comfirmDeleteData(tableObj, checkedBox, 'employee/info/delete/');
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
                "url" : "employee/info/query?personId=-1"
            //    "async": false
            },
            "columns" : [ {
                "data" : "personId"
            }, {
                "data" : "employeeName"
            }, {
                "data" : "employeeAge"
            }, {
                "data" : "employeeBirthday"
            }, {
                "data" : "employeeNumber"
            }, {
                "data" : "employeeDept"
            }, {
                "data" : "employeeGender"
            }, {
                "data" : "idcard"
            }, {
                "data" : "phoneNumber"
            }, {
                "data" : "firstWorkdate"
            }, {
                "data" : "certificateCategory"
            }, {
                "data" : "employeeStatus"
            }, {
                "data" : "remark"
            }, {
                "data" : "deleteFlag"
            }, {
                "data" : "creator"
            }, {
                "data" : "createDate"
            }, {
                "data" : "modifier"
            }, {
                "data" : "modifyDate"
            }],
            "columnDefs": [{
                "orderable" : false,
                "searchable" : false,
                "targets": [0],
                "data": "personId",
                "render": function (data, type, full) {
                    return '<input type="checkbox" name="data-checkbox" value="' + data + '" />';
                 }
            },
            {
                "targets": [3],
                "data": "employeeBirthday",
                "render": function (data, type, full) {
                    if(data == null || data == "") {
                        return "";
                    }
                    return new Date(data).format("yyyy-MM-dd hh:mm:ss");
                 }
            },
            {
                "targets": [9],
                "data": "firstWorkdate",
                "render": function (data, type, full) {
                    if(data == null || data == "") {
                        return "";
                    }
                    return new Date(data).format("yyyy-MM-dd hh:mm:ss");
                 }
            },
            {
                "targets": [15],
                "data": "createDate",
                "render": function (data, type, full) {
                    if(data == null || data == "") {
                        return "";
                    }
                    return new Date(data).format("yyyy-MM-dd hh:mm:ss");
                 }
            },
            {
                "targets": [17],
                "data": "modifyDate",
                "render": function (data, type, full) {
                    if(data == null || data == "") {
                        return "";
                    }
                    return new Date(data).format("yyyy-MM-dd hh:mm:ss");
                 }
            }
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