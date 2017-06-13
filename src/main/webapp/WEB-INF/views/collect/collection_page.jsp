<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>分布式数据信息采集与管理</title>
<%@include file="../included/includedStyle.jsp" %>

</head>

<body>
    <div class="wrapper">
        <div class="wrapper-content">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class=" icon-layers font-green"></i> <span class="caption-subject bold uppercase"> 分布式数据信息采集与管理 </span>
                </div>
            </div>
            <div class="portlet-body">
                <form action="#" class="form-horizontal" id="form-module">
                    <div class="row border-txt">
                        <div class="col-md-12">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-2 control-label font-green" for="form_control_1">
                                    已连接数据源：
                                </label>
                                <div class="col-md-10">
                                    <c:if test="${sts.wsnSts == 1 }">
                                        <input type="checkbox"  id="wsn" />mnt_dev &nbsp;&nbsp;
                                    </c:if>
                                    <c:if test="${sts.rfidSts == 1 }">
                                        <input type="checkbox" id="rfid" />RFID &nbsp;&nbsp;
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                     <div class="row border-txt">
                         <div class="col-md-12">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-2 control-label font-green" for="form_control_1">
                                    已连接设备源：
                                </label>
                                <div class="col-md-10">
                                    <c:if test="${sts.mn1Sts == 1 && sts.mn1Sts1==1 }">
                                        <input type="checkbox"  id="mn1"/>MN_T001_001 &nbsp;
                                    </c:if>
                                    <c:if test="${sts.mn2Sts == 1 && sts.mn2Sts2==1 }">
                                        <input type="checkbox" id="mn2"/>MN_T001_002 &nbsp;
                                    </c:if>
                                    <c:if test="${sts.mn3Sts == 1 && sts.mn3Sts3==1 }">
                                        <input type="checkbox" id="mn3"/>MN_T002_003 &nbsp;
                                    </c:if>
                                    <c:if test="${sts.mn4Sts == 1 && sts.mn4Sts4==1 }">
                                        <input type="checkbox" id="mn4"/>MN_T002_004&nbsp;
                                    </c:if>
                                    <c:if test="${sts.mn5Sts == 1 && sts.mn5Sts5==1 }">
                                        <input type="checkbox" id="mn5"/>MN_T003_005&nbsp;
                                    </c:if>
                                    <c:if test="${sts.mn6Sts == 1 && sts.mn6Sts6==1 }">
                                        <input type="checkbox" id="mn6"/>MN_T003_006&nbsp;
                                    </c:if>
                                    <c:if test="${sts.kcd1 == 1 && sts.kcd11==1 }">
                                        <input type="checkbox" id="kcd1"/>KCD_JC01_001&nbsp;
                                    </c:if>
                                    <c:if test="${sts.kcd2 == 1 && sts.kcd22==1 }">
                                        <input type="checkbox" id="kcd2"/>KCD_JC02_002&nbsp;
                                    </c:if>
                                </div>
                            </div>
                        </div>
                     </div>
                   
                    <div class="row border-txt">
                         <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                 <div class="col-md-offset-6">
                                    <button type="button" class="btn green" id="disconnect">断开</button>
                                </div>
                            </div>
                        </div>
                       
                          <!--  <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                 <div class="col-md-offset-6">
                                    <button type="submit" class="btn green">创建数据库</button>
                                </div>
                            </div>
                        </div> -->
                    </div>
                    
                     <div class="row border-txt">
                        <div class="col-md-12">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-2 control-label font-green" for="form_control_1">
                                    可连接数据源：
                                </label>
                                <div class="col-md-10">
                                    <c:if test="${sts.wsnSts == 0 }">
                                        <input type="checkbox" id="un_wsn" />mnt_dev &nbsp;&nbsp;
                                    </c:if>
                                    <c:if test="${sts.rfidSts == 0 }">
                                        <input type="checkbox" id="un_rfid" />RFID &nbsp;&nbsp;
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                     <div class="row border-txt">
                         <div class="col-md-12">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-2 control-label font-green" for="form_control_1">
                                    可连接设备源：
                                </label>
                                <div class="col-md-10">
                                    <c:if test="${sts.mn1Sts == 0 && sts.mn1Sts1==1 }">
                                        <input type="checkbox" id="un_mn1" />MN_T001_001 &nbsp;
                                    </c:if>
                                    <c:if test="${sts.mn2Sts == 0 && sts.mn2Sts2==1 }">
                                        <input type="checkbox" id="un_mn2"/>MN_T001_002 &nbsp;
                                    </c:if>
                                    <c:if test="${sts.mn3Sts == 0 && sts.mn3Sts3==1 }">
                                        <input type="checkbox" id="un_mn3" />MN_T002_003 &nbsp;
                                    </c:if>
                                    <c:if test="${sts.mn4Sts == 0 && sts.mn4Sts4==1 }">
                                       <input type="checkbox" id="un_mn4" />MN_T002_004&nbsp;
                                    </c:if>
                                    <c:if test="${sts.mn5Sts == 0 && sts.mn5Sts5==1 }">
                                       <input type="checkbox" id="un_mn5"/>MN_T003_005&nbsp;
                                    </c:if>
                                    <c:if test="${sts.mn6Sts == 0 && sts.mn6Sts6==1 }">
                                       <input type="checkbox" id="un_mn6"/>MN_T003_006&nbsp;
                                    </c:if>
                                    <c:if test="${sts.kcd1 == 0 && sts.kcd11==1 }">
                                        <input type="checkbox" id="un_kcd1"/>KCD_JC01_001&nbsp;
                                    </c:if>
                                    <c:if test="${sts.kcd2 == 0 && sts.kcd22==1 }">
                                        <input type="checkbox" id="un_kcd2"/>KCD_JC02_002&nbsp;
                                    </c:if>
                                </div>
                            </div>
                        </div>
                     </div>
                    
                    <div class="row border-txt">
                        <div class="col-md-4">
                            <div class="form-group form-md-line-input">
                                <div class="col-md-offset-6">
                                    <button type="button" class="btn green" id="connect">连接</button>
                                </div>
                            </div>
                        </div>
                    </div>
                     <div class="row border-txt">
                        <div class="col-md-20">
                            <div class="form-group form-md-line-input">
                                <label class="col-md-2 control-label font-green" for="form_control_1">
                                   &nbsp;&nbsp; 已中断设备源：
                                </label>
                                <div class="col-md-10">
                                    <c:if test="${sts.mn1Sts == 0 && sts.mn1Sts1==0 }">
                                       MN_T001_001、&nbsp;
                                    </c:if>
                                    <c:if test="${sts.mn2Sts == 0 && sts.mn2Sts2==0 }">
                                       MN_T001_002、 &nbsp; 
                                    </c:if>
                                    <c:if test="${sts.mn3Sts == 0 && sts.mn3Sts3==0 }">
                                       MN_T002_003、 &nbsp; 
                                    </c:if>
                                    <c:if test="${sts.mn4Sts == 0 && sts.mn4Sts4==0 }">
                                       MN_T002_004 、&nbsp; 
                                    </c:if>
                                    <c:if test="${sts.mn5Sts == 0 && sts.mn5Sts5==0 }">
                                       MN_T003_005、 &nbsp;
                                    </c:if>
                                    <c:if test="${sts.mn6Sts == 0 && sts.mn6Sts6==0 }">
                                       MN_T003_006 、&nbsp; 
                                    </c:if>
                                    <c:if test="${sts.kcd1 == 0 && sts.kcd11==0 }">
                                        KCD_JC01_001、&nbsp;&nbsp;
                                    </c:if>
                                    <c:if test="${sts.kcd2 == 0 && sts.kcd22==0 }">
                                        KCD_JC02_002、
                                    </c:if>
                                    
                                </div>
                            </div>
                        </div>
                    </div> 
                </form>
            </div>
        </div>
    </div>

<%@include file="../included/includedJs.jsp" %>
<script type="text/javascript">
jQuery(document).ready(function() {
	$("#connect").click(function(){
		var wsn = $("#un_wsn").prop("checked");
		if(wsn == true){
			wsn = 1;
		}else if(wsn == false){
			wsn =0;
		}else{
			wsn = 2;
		}
		
		var rfid = $("#un_rfid").prop("checked");
		if(rfid == true){
			rfid = 1;
        }else if(rfid == false){
        	rfid =0;
        }else{
        	rfid = 2;
        }
		var mn1 = $("#un_mn1").prop("checked");
		if(mn1 == true){
			mn1 = 1;
        }else if(mn1 == false){
        	mn1 =0;
        }else{
        	mn1 = 2;
        }
		var mn2 = $("#un_mn2").prop("checked");
		if(mn2 == true){
            mn2 = 1;
        }else if(mn2 == false){
            mn2 =0;
        }else{
            mn2 = 2;
        }
		var mn3 = $("#un_mn3").prop("checked");
		if(mn3 == true){
            mn3 = 1;
        }else if(mn3 == false){
            mn3 =0;
        }else{
            mn3 = 2;
        }
		var mn4 = $("#un_mn4").prop("checked");
		if(mn4 == true){
            mn4 = 1;
        }else if(mn4 == false){
            mn4 =0;
        }else{
            mn4 = 2;
        }
		var mn5 = $("#un_mn5").prop("checked");
		if(mn5 == true){
            mn5 = 1;
        }else if(mn5 == false){
            mn5 =0;
        }else{
            mn5 = 2;
        }
		var mn6 = $("#un_mn6").prop("checked");
		if(mn6 == true){
            mn6 = 1;
        }else if(mn6 == false){
            mn6 =0;
        }else{
            mn6 = 2;
        }
		var kcd1 = $("#un_kcd1").prop("checked");
        if(kcd1 == true){
            kcd1 = 1;
        }else if(kcd1 == false){
            kcd1 =0;
        }else{
            kcd1 = 2;
        }
        var kcd2 = $("#un_kcd2").prop("checked");
        if(kcd2 == true){
            kcd2 = 1;
        }else if(kcd2 == false){
            kcd2 =0;
        }else{
            kcd2 = 2;
        }
		/* //alert("stat/connect?wsn="+wsn
                +"&rfid="+rfid
                +"&mn1="+mn1
                +"&mn2="+mn2
                +"&mn3="+mn3
                +"&mn4="+mn4
                +"&mn5="+mn5
                +"&mn6="+mn6) */
		var url = "stat/connect?wsn="+wsn
				+"&rfid="+rfid
				+"&mn1="+mn1
				+"&mn2="+mn2
				+"&mn3="+mn3
				+"&mn4="+mn4
				+"&mn5="+mn5
				+"&mn6="+mn6
				+"&kcd1="+kcd1
				+"&kcd2="+kcd2;
		//alert(url)
		window.location.href = url;
		//console.log(url)
	});
	
	
	$("#disconnect").click(function(){
		var wsn = $("#wsn").prop("checked");
        if(wsn == true){
            wsn = 0;
        }else if(wsn == false){
            wsn =1;
        }else{
            wsn = 2;
        }
        
        var rfid = $("#rfid").prop("checked");
        if(rfid == true){
            rfid = 0;
        }else if(rfid == false){
            rfid =1;
        }else{
            rfid = 2;
        }
        var mn1 = $("#mn1").prop("checked");
        if(mn1 == true){
            mn1 = 0;
        }else if(mn1 == false){
            mn1 =1;
        }else{
            mn1 = 2;
        }
        var mn2 = $("#mn2").prop("checked");
        if(mn2 == true){
            mn2 = 0;
        }else if(mn2 == false){
            mn2 =1;
        }else{
            mn2 = 2;
        }
        var mn3 = $("#mn3").prop("checked");
        if(mn3 == true){
            mn3 = 0;
        }else if(mn3 == false){
            mn3 =1;
        }else{
            mn3 = 2;
        }
        var mn4 = $("#mn4").prop("checked");
        if(mn4 == true){
            mn4 = 0;
        }else if(mn4 == false){
            mn4 =1;
        }else{
            mn4 = 2;
        }
        var mn5 = $("#mn5").prop("checked");
        if(mn5 == true){
            mn5 = 0;
        }else if(mn5 == false){
            mn5 =1;
        }else{
            mn5 = 2;
        }
        var mn6 = $("#mn6").prop("checked");
        if(mn6 == true){
            mn6 = 0;
        }else if(mn6 == false){
            mn6 =1;
        }else{
            mn6 = 2;
        }
        var kcd1 = $("#kcd1").prop("checked");
        if(kcd1 == true){
            kcd1 = 0;
        }else if(kcd1 == false){
            kcd1 =1;
        }else{
            kcd1 = 2;
        }
        var kcd2 = $("#kcd2").prop("checked");
        if(kcd2 == true){
            kcd2 = 0;
        }else if(kcd2 == false){
            kcd2 =1;
        }else{
            kcd2 = 2;
        }
        /* alert("stat/connect?wsn="+wsn
                +"&rfid="+rfid
                +"&mn1="+mn1
                +"&mn2="+mn2
                +"&mn3="+mn3
                +"&mn4="+mn4
                +"&mn5="+mn5
                +"&mn6="+mn6) */
        var url = "stat/connect?wsn="+wsn
                +"&rfid="+rfid
                +"&mn1="+mn1
                +"&mn2="+mn2
                +"&mn3="+mn3
                +"&mn4="+mn4
                +"&mn5="+mn5
                +"&mn6="+mn6
                +"&kcd1="+kcd1
                +"&kcd2="+kcd2;
        //alert(url)
        window.location.href = url;
	});
	
});

</script>
</body>
</html>