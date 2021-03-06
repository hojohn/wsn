<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../included/includedStyle.jsp" %>
</head>

<body class="body-bg">
    <div class="wrapper-box">
        <div class="row">
            <div class="col-md-12">
                <div class="wrapper-body">
                    <div class="portlet-title">
                        <div class="caption font-dark">
                            <i class="icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 新增危险物料风险度表 </span>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <form action="#" class="form-horizontal" id="form-add">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            名称 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="name" id="name">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入名称</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            危险物料标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="wxwlbzf" id="wxwlbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入危险物料标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            工艺参数标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="gycsbzf" id="gycsbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入工艺参数标准分</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            安全控制标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="aqkzbzf" id="aqkzbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入安全控制标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            主键 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="id" id="id">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入主键</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            物料危险性标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="wlwxxbzf" id="wlwxxbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入物料危险性标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            物料危险性权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="wlwxxqz" id="wlwxxqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入物料危险性权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            燃料危险性标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="rlwxxbzf" id="rlwxxbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入燃料危险性标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            燃料危险性权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="rlwxxqz" id="rlwxxqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入燃料危险性权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            爆炸危险性标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="bzwxxbz" id="bzwxxbz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入爆炸危险性标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            爆炸危险性权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="bzwxxqz" id="bzwxxqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入爆炸危险性权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            物质毒害性标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="wzdhxbzf" id="wzdhxbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入物质毒害性标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            物质毒害性权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="wzdhxqz" id="wzdhxqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入物质毒害性权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            物质腐蚀性标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="wzfsxbzf" id="wzfsxbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入物质腐蚀性标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            物质腐蚀性权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="wzfsxqz" id="wzfsxqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入物质腐蚀性权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            反应热系数标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="fyrxsbzf" id="fyrxsbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入反应热系数标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            反应热系数权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="fyrxsqz" id="fyrxsqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入反应热系数权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            储量标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="clbzf" id="clbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入储量标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            储量权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="clqz" id="clqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入储量权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            温度标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="wdbzf" id="wdbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入温度标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            温度权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="wdqz" id="wdqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入温度权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            压力标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="ylbzf" id="ylbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入压力标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            压力权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="ylqz" id="ylqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入压力权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            流量标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="llbzf" id="llbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入流量标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            流量权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="llqz" id="llqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入流量权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            搅拌速率标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="jbslbzf" id="jbslbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入搅拌速率标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            搅拌速率权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="jbslqz" id="jbslqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入搅拌速率权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            氧含量标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="hylbzf" id="hylbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入氧含量标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            氧含量权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="hylqz" id="hylqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入氧含量权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            其它参数标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="qtcsbzf" id="qtcsbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入其它参数标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            其它参数权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="qtcsqz" id="qtcsqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入其它参数权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            温度参数报警标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="wdcsbjbzf" id="wdcsbjbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入温度参数报警标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            温度参数报警权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="wdcsbjqz" id="wdcsbjqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入温度参数报警权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            进料比例控制标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="jlblkzbzf" id="jlblkzbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入进料比例控制标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            进料比例控制权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="jlblkzqz" id="jlblkzqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入进料比例控制权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            紧急冷却系统标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="jjlqxtbzf" id="jjlqxtbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入紧急冷却系统标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            紧急冷却系统权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="jjlqxtqz" id="jjlqxtqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入紧急冷却系统权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            搅拌温度控制标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="jbwdkzbzf" id="jbwdkzbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入搅拌温度控制标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            搅拌温度控制权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="jbwdkzqz" id="jbwdkzqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入搅拌温度控制权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            安全泄放系统标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="aqxfxtbzf" id="aqxfxtbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入安全泄放系统标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            安全泄放系统权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="aqxfxtqz" id="aqxfxtqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入安全泄放系统权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            可燃有毒气体检测标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="krydqtjcbzf" id="krydqtjcbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入可燃有毒气体检测标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            可燃有毒气体检测权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="krydqtjcqz" id="krydqtjcqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入可燃有毒气体检测权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            紧急停车装置标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="jjtczzbzf" id="jjtczzbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入紧急停车装置标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            紧急停车装置权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="jjtczzqz" id="jjtczzqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入紧急停车装置权重</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            其它安全控制标准分 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="qtaqkzbzf" id="qtaqkzbzf">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入其它安全控制标准分</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-md-line-input">
                                        <label class="col-md-4 control-label" for="form_control_1">
                                            其它安全控制标权重 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" placeholder="" name="qtaqkzqz" id="qtaqkzqz">
                                            <div class="form-control-focus"></div>
                                            <span class="help-block">请输入其它安全控制标权重</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button type="submit" class="btn green">提交</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@include file="../../included/includedJs.jsp" %>

<script type="text/javascript">

jQuery(document).ready(function() {
    
    //表单校验提交
    //[1]自定义校验规则
    var rules = {
            name:"required",
            wxwlbzf:"required",
            gycsbzf:"required",
            aqkzbzf:"required",
            id:"required",
            wlwxxbzf:"required",
            wlwxxqz:"required",
            rlwxxbzf:"required",
            rlwxxqz:"required",
            bzwxxbz:"required",
            bzwxxqz:"required",
            wzdhxbzf:"required",
            wzdhxqz:"required",
            wzfsxbzf:"required",
            wzfsxqz:"required",
            fyrxsbzf:"required",
            fyrxsqz:"required",
            clbzf:"required",
            clqz:"required",
            wdbzf:"required",
            wdqz:"required",
            ylbzf:"required",
            ylqz:"required",
            llbzf:"required",
            llqz:"required",
            jbslbzf:"required",
            jbslqz:"required",
            hylbzf:"required",
            hylqz:"required",
            qtcsbzf:"required",
            qtcsqz:"required",
            wdcsbjbzf:"required",
            wdcsbjqz:"required",
            jlblkzbzf:"required",
            jlblkzqz:"required",
            jjlqxtbzf:"required",
            jjlqxtqz:"required",
            jbwdkzbzf:"required",
            jbwdkzqz:"required",
            aqxfxtbzf:"required",
            aqxfxtqz:"required",
            krydqtjcbzf:"required",
            krydqtjcqz:"required",
            jjtczzbzf:"required",
            jjtczzqz:"required",
            qtaqkzbzf:"required",
            qtaqkzqz:"required"
    };
    //[2]表单校验初始化
    initFormValidate('form-add', rules, 'sec/info/add', 'add');
    
});

</script>
</body>
</html>