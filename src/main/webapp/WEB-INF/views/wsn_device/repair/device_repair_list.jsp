<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../included/includedStyle.jsp" %>
</head>

<body>


    <div class="wrapper">
        <div class="row">
            <div class="col-md-12">
                <div class="wrapper-content">
                    <div class="portlet-title">
                        <div class="caption font-dark">
                            <i class=" icon-layers font-green"></i>
                            <span class="caption-subject bold uppercase">
                           维修记录表
                            </span>
                        </div>
                    </div>
                    
                     <div id="btn-data-tools">
                        <shiro:hasPermission name="prod:operate">
                        <span class="dt-buttons">
                            <a class="dt-button btn red btn-outline btn-mnt" id="btnDelete" >
                                <span>删除</span>
                            </a>
                        </span>
                        <span class="dt-buttons">
                            <a class="dt-button btn yellow btn-outline btn-mnt" id="btnModify">
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
                    <div class="portlet-body">
                        <table class="table table-striped table-bordered table-hover table-checkable order-column noscoll" id="tabRepair" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>设备RFID</th>
                                    <th>维修内容</th>
                                    <th>维修人员</th>
                                    <th>维修时间</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${repairList}" var="repairList" varStatus="status">
                                    <tr>
                                        <td>${status.index + 1}</td>
                                         <td>${repairList.deviceRfid}</td>
                                        <td>${repairList.repairInfo}</td>
                                        <td>${repairList.repairPerson}</td>
                                        <td><fmt:formatDate value="${repairList.repairTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                    </tr>
                                </c:forEach >
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
<%@include file="../../included/includedJs.jsp" %>
<script>

$(function() {
    var tableObj = $("#tabRepair").DataTable(getConfig());
    
    //修改按钮
    $('.div_right').on('click', '.dt-buttons>#btnModify',function() {
        var checkedBox = $("#tabRepair tbody tr td .checked");
        var checkedLength = checkedBox.length;
        if(checkedLength == 0) {
            showMsg("请选择需要修改的数据！");
            return;
        }
        if(checkedLength > 1) {
            showMsg("只能选择一条数据进行修改操作！");
            return;
        }
        var strRepairId = checkedBox.find('input:checkbox').val();
        showModal(2, " ", [ '1000px', '500px' ], "device/repair/update_page/" + strRepairId, tableObj);
    });
    
    //新增
    $('.div_right').on('click', '.dt-buttons>#btnAdd', function(){
        showModal(2, " ", ['1000px', '500px'], "device/repair/add_page", tableObj);
    });
    
    //删除按钮
    $('.div_right').on('click', '.dt-buttons>#btnDelete',function() {
        var checkedBox = $("#tabRepair tbody tr td .checked");
        comfirmDeleteData(tableObj, checkedBox, 'device/repair/delete/');
    });
});

function getConfig() {
    return config = {
        "processing" : true,
        "searching" : false,
        "pageLength" : 10,
        "lengthMenu" : [ [5, 10, 20, -1 ], [ 5, 10, 20, "All" ] ],
        "order" : [ [ 1, "asc" ] ],
//         "scrollX": "2000px",
        "dom": '<"top"lf<"div_right">>rt<"bottom"ip><"clear">',
        "language" : {
            "processing" : "努力加载数据中...",
            "lengthMenu" : "_MENU_ 条记录每页",
            "zeroRecords" : "没有找到记录",
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