<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<title>危险物料风险度表</title>
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
                                    <label class="control-label col-md-4">名称</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="name">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">危险物料标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wxwlbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">工艺参数标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="gycsbzf">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">安全控制标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="aqkzbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">主键</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="id">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">物料危险性标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wlwxxbzf">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">物料危险性权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wlwxxqz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">燃料危险性标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="rlwxxbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">燃料危险性权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="rlwxxqz">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">爆炸危险性标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="bzwxxbz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">爆炸危险性权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="bzwxxqz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">物质毒害性标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wzdhxbzf">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">物质毒害性权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wzdhxqz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">物质腐蚀性标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wzfsxbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">物质腐蚀性权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wzfsxqz">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">反应热系数标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="fyrxsbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">反应热系数权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="fyrxsqz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">储量标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="clbzf">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">储量权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="clqz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">温度标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wdbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">温度权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wdqz">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">压力标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="ylbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">压力权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="ylqz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">流量标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="llbzf">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">流量权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="llqz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">搅拌速率标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="jbslbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">搅拌速率权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="jbslqz">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">氧含量标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="hylbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">氧含量权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="hylqz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">其它参数标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="qtcsbzf">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">其它参数权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="qtcsqz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">温度参数报警标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wdcsbjbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">温度参数报警权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="wdcsbjqz">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">进料比例控制标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="jlblkzbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">进料比例控制权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="jlblkzqz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">紧急冷却系统标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="jjlqxtbzf">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">紧急冷却系统权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="jjlqxtqz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">搅拌温度控制标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="jbwdkzbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">搅拌温度控制权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="jbwdkzqz">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">安全泄放系统标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="aqxfxtbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">安全泄放系统权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="aqxfxtqz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">可燃有毒气体检测标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="krydqtjcbzf">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">可燃有毒气体检测权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="krydqtjcqz">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">紧急停车装置标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="jjtczzbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">紧急停车装置权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="jjtczzqz">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">其它安全控制标准分</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="qtaqkzbzf">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="control-label col-md-4">其它安全控制标权重</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="qtaqkzqz">
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
                        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="tabSafeEval" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th class="checkbox-datatables"><input type="checkbox" id="tab-th-chk" /></th>
                                    <th>名称</th>
                                    <th>危险物料标准分</th>
                                    <th>工艺参数标准分</th>
                                    <th>安全控制标准分</th>
                                    <th>物料危险性标准分</th>
                                    <th>物料危险性权重</th>
                                    <th>燃料危险性标准分</th>
                                    <th>燃料危险性权重</th>
                                    <th>爆炸危险性标准分</th>
                                    <th>爆炸危险性权重</th>
                                    <th>物质毒害性标准分</th>
                                    <th>物质毒害性权重</th>
                                    <th>物质腐蚀性标准分</th>
                                    <th>物质腐蚀性权重</th>
                                    <th>反应热系数标准分</th>
                                    <th>反应热系数权重</th>
                                    <th>储量标准分</th>
                                    <th>储量权重</th>
                                    <th>温度标准分</th>
                                    <th>温度权重</th>
                                    <th>压力标准分</th>
                                    <th>压力权重</th>
                                    <th>流量标准分</th>
                                    <th>流量权重</th>
                                    <th>搅拌速率标准分</th>
                                    <th>搅拌速率权重</th>
                                    <th>氧含量标准分</th>
                                    <th>氧含量权重</th>
                                    <th>其它参数标准分</th>
                                    <th>其它参数权重</th>
                                    <th>温度参数报警标准分</th>
                                    <th>温度参数报警权重</th>
                                    <th>进料比例控制标准分</th>
                                    <th>进料比例控制权重</th>
                                    <th>紧急冷却系统标准分</th>
                                    <th>紧急冷却系统权重</th>
                                    <th>搅拌温度控制标准分</th>
                                    <th>搅拌温度控制权重</th>
                                    <th>安全泄放系统标准分</th>
                                    <th>安全泄放系统权重</th>
                                    <th>可燃有毒气体检测标准分</th>
                                    <th>可燃有毒气体检测权重</th>
                                    <th>紧急停车装置标准分</th>
                                    <th>紧急停车装置权重</th>
                                    <th>其它安全控制标准分</th>
                                    <th>其它安全控制标权重</th>
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

        var tableObj = $('#tabSafeEval').DataTable(getConfig());
        $('#btnQuery').click(function(e) {
            var strName = $("#name").val();
            var strWxwlbzf = $("#wxwlbzf").val();
            var strGycsbzf = $("#gycsbzf").val();
            var strAqkzbzf = $("#aqkzbzf").val();
            var strId = $("#id").val();
            var strWlwxxbzf = $("#wlwxxbzf").val();
            var strWlwxxqz = $("#wlwxxqz").val();
            var strRlwxxbzf = $("#rlwxxbzf").val();
            var strRlwxxqz = $("#rlwxxqz").val();
            var strBzwxxbz = $("#bzwxxbz").val();
            var strBzwxxqz = $("#bzwxxqz").val();
            var strWzdhxbzf = $("#wzdhxbzf").val();
            var strWzdhxqz = $("#wzdhxqz").val();
            var strWzfsxbzf = $("#wzfsxbzf").val();
            var strWzfsxqz = $("#wzfsxqz").val();
            var strFyrxsbzf = $("#fyrxsbzf").val();
            var strFyrxsqz = $("#fyrxsqz").val();
            var strClbzf = $("#clbzf").val();
            var strClqz = $("#clqz").val();
            var strWdbzf = $("#wdbzf").val();
            var strWdqz = $("#wdqz").val();
            var strYlbzf = $("#ylbzf").val();
            var strYlqz = $("#ylqz").val();
            var strLlbzf = $("#llbzf").val();
            var strLlqz = $("#llqz").val();
            var strJbslbzf = $("#jbslbzf").val();
            var strJbslqz = $("#jbslqz").val();
            var strHylbzf = $("#hylbzf").val();
            var strHylqz = $("#hylqz").val();
            var strQtcsbzf = $("#qtcsbzf").val();
            var strQtcsqz = $("#qtcsqz").val();
            var strWdcsbjbzf = $("#wdcsbjbzf").val();
            var strWdcsbjqz = $("#wdcsbjqz").val();
            var strJlblkzbzf = $("#jlblkzbzf").val();
            var strJlblkzqz = $("#jlblkzqz").val();
            var strJjlqxtbzf = $("#jjlqxtbzf").val();
            var strJjlqxtqz = $("#jjlqxtqz").val();
            var strJbwdkzbzf = $("#jbwdkzbzf").val();
            var strJbwdkzqz = $("#jbwdkzqz").val();
            var strAqxfxtbzf = $("#aqxfxtbzf").val();
            var strAqxfxtqz = $("#aqxfxtqz").val();
            var strKrydqtjcbzf = $("#krydqtjcbzf").val();
            var strKrydqtjcqz = $("#krydqtjcqz").val();
            var strJjtczzbzf = $("#jjtczzbzf").val();
            var strJjtczzqz = $("#jjtczzqz").val();
            var strQtaqkzbzf = $("#qtaqkzbzf").val();
            var strQtaqkzqz = $("#qtaqkzqz").val();
            var sUrl = "sec/info/query?";
            sUrl += 
                "&name=" + strName +
                "&wxwlbzf=" + strWxwlbzf +
                "&gycsbzf=" + strGycsbzf +
                "&aqkzbzf=" + strAqkzbzf +
                "&id=" + strId +
                "&wlwxxbzf=" + strWlwxxbzf +
                "&wlwxxqz=" + strWlwxxqz +
                "&rlwxxbzf=" + strRlwxxbzf +
                "&rlwxxqz=" + strRlwxxqz +
                "&bzwxxbz=" + strBzwxxbz +
                "&bzwxxqz=" + strBzwxxqz +
                "&wzdhxbzf=" + strWzdhxbzf +
                "&wzdhxqz=" + strWzdhxqz +
                "&wzfsxbzf=" + strWzfsxbzf +
                "&wzfsxqz=" + strWzfsxqz +
                "&fyrxsbzf=" + strFyrxsbzf +
                "&fyrxsqz=" + strFyrxsqz +
                "&clbzf=" + strClbzf +
                "&clqz=" + strClqz +
                "&wdbzf=" + strWdbzf +
                "&wdqz=" + strWdqz +
                "&ylbzf=" + strYlbzf +
                "&ylqz=" + strYlqz +
                "&llbzf=" + strLlbzf +
                "&llqz=" + strLlqz +
                "&jbslbzf=" + strJbslbzf +
                "&jbslqz=" + strJbslqz +
                "&hylbzf=" + strHylbzf +
                "&hylqz=" + strHylqz +
                "&qtcsbzf=" + strQtcsbzf +
                "&qtcsqz=" + strQtcsqz +
                "&wdcsbjbzf=" + strWdcsbjbzf +
                "&wdcsbjqz=" + strWdcsbjqz +
                "&jlblkzbzf=" + strJlblkzbzf +
                "&jlblkzqz=" + strJlblkzqz +
                "&jjlqxtbzf=" + strJjlqxtbzf +
                "&jjlqxtqz=" + strJjlqxtqz +
                "&jbwdkzbzf=" + strJbwdkzbzf +
                "&jbwdkzqz=" + strJbwdkzqz +
                "&aqxfxtbzf=" + strAqxfxtbzf +
                "&aqxfxtqz=" + strAqxfxtqz +
                "&krydqtjcbzf=" + strKrydqtjcbzf +
                "&krydqtjcqz=" + strKrydqtjcqz +
                "&jjtczzbzf=" + strJjtczzbzf +
                "&jjtczzqz=" + strJjtczzqz +
                "&qtaqkzbzf=" + strQtaqkzbzf +
                "&qtaqkzqz=" + strQtaqkzqz;
            tableObj.ajax.url(sUrl).load();
        });
        
        $('.reload').on('click', function() {
            $('#name').val('');
            $('#wxwlbzf').val('');
            $('#gycsbzf').val('');
            $('#aqkzbzf').val('');
            $('#id').val('');
            $('#wlwxxbzf').val('');
            $('#wlwxxqz').val('');
            $('#rlwxxbzf').val('');
            $('#rlwxxqz').val('');
            $('#bzwxxbz').val('');
            $('#bzwxxqz').val('');
            $('#wzdhxbzf').val('');
            $('#wzdhxqz').val('');
            $('#wzfsxbzf').val('');
            $('#wzfsxqz').val('');
            $('#fyrxsbzf').val('');
            $('#fyrxsqz').val('');
            $('#clbzf').val('');
            $('#clqz').val('');
            $('#wdbzf').val('');
            $('#wdqz').val('');
            $('#ylbzf').val('');
            $('#ylqz').val('');
            $('#llbzf').val('');
            $('#llqz').val('');
            $('#jbslbzf').val('');
            $('#jbslqz').val('');
            $('#hylbzf').val('');
            $('#hylqz').val('');
            $('#qtcsbzf').val('');
            $('#qtcsqz').val('');
            $('#wdcsbjbzf').val('');
            $('#wdcsbjqz').val('');
            $('#jlblkzbzf').val('');
            $('#jlblkzqz').val('');
            $('#jjlqxtbzf').val('');
            $('#jjlqxtqz').val('');
            $('#jbwdkzbzf').val('');
            $('#jbwdkzqz').val('');
            $('#aqxfxtbzf').val('');
            $('#aqxfxtqz').val('');
            $('#krydqtjcbzf').val('');
            $('#krydqtjcqz').val('');
            $('#jjtczzbzf').val('');
            $('#jjtczzqz').val('');
            $('#qtaqkzbzf').val('');
            $('#qtaqkzqz').val('');
            tableObj.ajax.url('sec/info/query?id=-1').load();
        });
        
        //修改按钮
        $('.div_right').on('click', '.dt-buttons>#btnUpdate',function() {
            var checkedBox = $("#tabSafeEval tbody tr td .checked");
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
            showModal(2, " ", [ '1000px', '500px' ], "sec/info/update_page/" + strId, tableObj);
        });
        
        //新增
        $('.div_right').on('click', '.dt-buttons>#btnAdd', function(){
            showModal(2, " ", ['1000px', '500px'], "sec/info/add_page", tableObj);
        });
        
        //删除按钮
        $('.div_right').on('click', '.dt-buttons>#btnDelete',function() {
            var checkedBox = $("#tabSafeEval tbody tr td .checked");
            comfirmDeleteData(tableObj, checkedBox, 'sec/info/delete/');
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
                "url" : "sec/info/query?id=-1"
            //    "async": false
            },
            "columns" : [ {
                "data" : "name"
            }, {
                "data" : "wxwlbzf"
            }, {
                "data" : "gycsbzf"
            }, {
                "data" : "aqkzbzf"
            }, {
                "data" : "id"
            }, {
                "data" : "wlwxxbzf"
            }, {
                "data" : "wlwxxqz"
            }, {
                "data" : "rlwxxbzf"
            }, {
                "data" : "rlwxxqz"
            }, {
                "data" : "bzwxxbz"
            }, {
                "data" : "bzwxxqz"
            }, {
                "data" : "wzdhxbzf"
            }, {
                "data" : "wzdhxqz"
            }, {
                "data" : "wzfsxbzf"
            }, {
                "data" : "wzfsxqz"
            }, {
                "data" : "fyrxsbzf"
            }, {
                "data" : "fyrxsqz"
            }, {
                "data" : "clbzf"
            }, {
                "data" : "clqz"
            }, {
                "data" : "wdbzf"
            }, {
                "data" : "wdqz"
            }, {
                "data" : "ylbzf"
            }, {
                "data" : "ylqz"
            }, {
                "data" : "llbzf"
            }, {
                "data" : "llqz"
            }, {
                "data" : "jbslbzf"
            }, {
                "data" : "jbslqz"
            }, {
                "data" : "hylbzf"
            }, {
                "data" : "hylqz"
            }, {
                "data" : "qtcsbzf"
            }, {
                "data" : "qtcsqz"
            }, {
                "data" : "wdcsbjbzf"
            }, {
                "data" : "wdcsbjqz"
            }, {
                "data" : "jlblkzbzf"
            }, {
                "data" : "jlblkzqz"
            }, {
                "data" : "jjlqxtbzf"
            }, {
                "data" : "jjlqxtqz"
            }, {
                "data" : "jbwdkzbzf"
            }, {
                "data" : "jbwdkzqz"
            }, {
                "data" : "aqxfxtbzf"
            }, {
                "data" : "aqxfxtqz"
            }, {
                "data" : "krydqtjcbzf"
            }, {
                "data" : "krydqtjcqz"
            }, {
                "data" : "jjtczzbzf"
            }, {
                "data" : "jjtczzqz"
            }, {
                "data" : "qtaqkzbzf"
            }, {
                "data" : "qtaqkzqz"
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