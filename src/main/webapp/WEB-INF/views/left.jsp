<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- BEGIN SIDEBAR -->
<div class="page-sidebar-wrapper">
	<div class="page-sidebar navbar-collapse collapse">
    <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 261px;">
		<ul class="page-sidebar-menu  page-header-fixed" data-keep-expanded="false" data-auto-scroll="true"
			data-slide-speed="200" data-initialized="1" style="overflow: hidden; width: auto; height: 261px;padding-top: 20px">
<!-- 			<li class="sidebar-toggler-wrapper hide"> -->
<!-- 				<div class="sidebar-toggler"></div> -->
<!-- 			</li> -->
<!-- 			<li class="sidebar-search-wrapper"> -->
<!-- 				<form class="sidebar-search" action="page_general_search_3.html" -->
<!-- 					method="POST"> -->
<!-- 					<a href="javascript:;" class="remove"> <i class="icon-close"></i> -->
<!-- 					</a> -->
<!-- 					<div class="input-group"> -->
<!-- 						<input type="text" class="form-control" placeholder="Search..."> -->
<!-- 						<span class="input-group-btn"> <a href="javascript:;" -->
<!-- 							class="btn submit"> <i class="icon-magnifier"></i> -->
<!-- 						</a> -->
<!-- 						</span> -->
<!-- 					</div> -->
<!-- 				</form> -->
<!-- 			</li> -->
			<li class="nav-item start active open">
				<a href="stat/index" class="nav-link nav-toggle" id="menu_999999001">
					<i class="icon-home"></i>
					<span class="title">主页</span>
					<span class="selected"></span>
				</a>
			</li>
			<li class="heading2">
<!-- 				<h3 class="uppercase">Menu</h3> -->
			</li>
<li class="nav-item "><a href="javascript:;" class="nav-link nav-toggle" id="menu_75"><i class="icon-diamond"></i><span class="title"> 系统配置</span><span class="arrow open"></span></a>
   <ul class="sub-menu" >
    <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_76"><span class="title"> 监控对象</span><span class="arrow"></span></a>
     <ul class="sub-menu" >
      <li class="nav-item"><a href="device/monitor/add_page?id=OBJ_C001_001" class="nav-link " id="menu_79"><span class="title"> OBJ_C001_001</span></a></li>
      <li class="nav-item"><a href="device/monitor/add_page?id=OBJ_C002_002" class="nav-link " id="menu_80"><span class="title"> OBJ_C002_002</span></a></li>
      <li class="nav-item"><a href="device/monitor/add_page?id=OBJ_C003_003" class="nav-link " id="menu_81"><span class="title"> OBJ_C003_003</span></a></li>
     </ul></li>
    <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_77"><span class="title"> 传感器信息</span><span class="arrow"></span></a>
     <ul class="sub-menu" >
      <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_86"><span class="title"> 温度传感器</span><span class="arrow"></span></a>
       <ul class="sub-menu">
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_WD01_001" class="nav-link " id="menu_104"><span class="title"> SEN_WD01_001</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_WD02_002" class="nav-link " id="menu_105"><span class="title"> SEN_WD02_002</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_WD03_003" class="nav-link " id="menu_106"><span class="title"> SEN_WD03_003</span></a></li>
       </ul></li>
      <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_87"><span class="title"> 湿度传感器</span><span class="arrow"></span></a>
       <ul class="sub-menu">
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_SD01_001" class="nav-link " id="menu_107"><span class="title"> SEN_SD01_001</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_SD02_002" class="nav-link " id="menu_108"><span class="title"> SEN_SD02_002</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_SD03_003" class="nav-link " id="menu_109"><span class="title"> SEN_SD03_003</span></a></li>
       </ul></li>
      <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_88"><span class="title"> 压力传感器</span><span class="arrow"></span></a>
       <ul class="sub-menu">
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_YL01_001" class="nav-link " id="menu_110"><span class="title"> SEN_YL01_001</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_YL02_002" class="nav-link " id="menu_111"><span class="title"> SEN_YL02_002</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_YL03_003" class="nav-link " id="menu_112"><span class="title"> SEN_YL03_003</span></a></li>
       </ul></li>
      <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_89"><span class="title"> 一氧化碳传感器</span><span class="arrow"></span></a>
       <ul class="sub-menu">
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_CO01_001" class="nav-link " id="menu_113"><span class="title"> SEN_CO01_001</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_CO02_002" class="nav-link " id="menu_114"><span class="title"> SEN_CO02_002</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_CO03_003" class="nav-link " id="menu_115"><span class="title"> SEN_CO03_003</span></a></li>
       </ul></li>
      <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_90"><span class="title"> 二氧化碳传感器</span><span class="arrow"></span></a>
       <ul class="sub-menu">
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_EY01_001" class="nav-link " id="menu_116"><span class="title"> SEN_EY01_001</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_EY02_002" class="nav-link " id="menu_117"><span class="title"> SEN_EY02_002</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_EY03_003" class="nav-link " id="menu_118"><span class="title"> SEN_EY03_003</span></a></li>
       </ul></li>
      <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_91"><span class="title"> 氧气传感器</span><span class="arrow"></span></a>
       <ul class="sub-menu">
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_YQ01_001" class="nav-link " id="menu_119"><span class="title"> SEN_YQ01_001</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_YQ02_002" class="nav-link " id="menu_120"><span class="title"> SEN_YQ02_002</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_YQ03_003" class="nav-link " id="menu_121"><span class="title"> SEN_YQ03_003</span></a></li>
       </ul></li>
      <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_92"><span class="title"> 甲烷传感器</span><span class="arrow"></span></a>
       <ul class="sub-menu">
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_JW01_001" class="nav-link " id="menu_122"><span class="title"> SEN_JW01_001</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_JW02_002" class="nav-link " id="menu_123"><span class="title"> SEN_JW02_002</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_JW03_003" class="nav-link " id="menu_124"><span class="title"> SEN_JW03_003</span></a></li>
       </ul></li>
      <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_93"><span class="title"> 烟雾传感器</span><span class="arrow"></span></a>
       <ul class="sub-menu">
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_YW01_001" class="nav-link " id="menu_127"><span class="title"> SEN_YW01_001</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_YW02_002" class="nav-link " id="menu_126"><span class="title"> SEN_YW02_002</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_YW03_003" class="nav-link " id="menu_125"><span class="title"> SEN_YW03_003</span></a></li>
       </ul></li>
      <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_94"><span class="title"> 粉尘传感器</span><span class="arrow"></span></a>
       <ul class="sub-menu">
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_FC01_001" class="nav-link " id="menu_128"><span class="title"> SEN_FC01_001</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_FC02_002" class="nav-link " id="menu_129"><span class="title"> SEN_FC02_002</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_FC03_003" class="nav-link " id="menu_130"><span class="title"> SEN_FC03_003</span></a></li>
       </ul></li>
      <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_95"><span class="title"> 位移传感器</span><span class="arrow"></span></a>
       <ul class="sub-menu">
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_WY01_001" class="nav-link " id="menu_133"><span class="title"> SEN_WY01_001</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_WY02_002" class="nav-link " id="menu_132"><span class="title"> SEN_WY02_002</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/temperature01?id=SEN_WY03_003" class="nav-link " id="menu_131"><span class="title"> SEN_WY03_003</span></a></li>
       </ul></li>
     </ul></li>
    <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_78"><span class="title"> 系统网络</span><span class="arrow"></span></a>
     <ul class="sub-menu" style="display: none;">
      <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_82"><span class="title"> 移动节点</span><span class="arrow"></span></a>
       <ul class="sub-menu">
        <li class="nav-item"><a href="device/info/update_page/move_node?id=MN_T001_001&hid=0" class="nav-link " id="menu_96"><span class="title"> MN_T001_001</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/move_node?id=MN_T001_002&hid=0" class="nav-link " id="menu_97"><span class="title"> MN_T001_002</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/move_node?id=MN_T002_003&hid=0" class="nav-link " id="menu_98"><span class="title"> MN_T002_003</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/move_node?id=MN_T002_004&hid=0" class="nav-link " id="menu_99"><span class="title"> MN_T002_004</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/move_node?id=MN_T003_005&hid=0" class="nav-link " id="menu_100"><span class="title"> MN_T003_005</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/move_node?id=MN_T003_006&hid=0" class="nav-link " id="menu_101"><span class="title"> MN_T003_006</span></a></li>
       </ul></li>
      <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_83"><span class="title"> 终端</span><span class="arrow"></span></a>
       <ul class="sub-menu">
        <li class="nav-item"><a href="device/info/update_page/terminal_page?id=TEM_C001_001&hid=0" class="nav-link " id="menu_102"><span class="title"> TEM_C001_001</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/terminal_page?id=TEM_C001_002&hid=0" class="nav-link " id="menu_103"><span class="title"> TEM_C001_002</span></a></li>
        <li class="nav-item"><a href="device/info/update_page/terminal_page?id=TEM_C001_003&hid=0" class="nav-link " id="menu_136"><span class="title"> TEM_C001_003</span></a></li>
       </ul></li>
      <li class="nav-item"><a href="device/info/update_page/server_page?id=ALY_001_001&hid=0" class="nav-link " id="menu_84"><span class="title">服务器</span></a></li>
     </ul></li>
    <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_76"><span class="title"> 可穿戴设备</span><span class="arrow"></span></a>
     <ul class="sub-menu" >
        <li class="nav-item"><a href="bracelet/info/page?id=KCD_JC01_001&hid=0" class="nav-link " id="menu_79"><span class="title"> KCD_JC01_001</span></a></li>
        <li class="nav-item"><a href="bracelet/info/page?id=KCD_JC02_002&hid=0" class="nav-link " id="menu_80"><span class="title"> KCD_JC02_002</span></a></li>
      <!-- <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle " id="menu_79"><span class="title"> 手环</span><span class="arrow"></span></a>
         <ul class="sub-menu" >
          <li class="nav-item"><a href="device/info/update_page/wearable?id=41" class="nav-link " id="menu_79"><span class="title"> KCD_SH01_001</span></a></li>
          <li class="nav-item"><a href="device/info/update_page/wearable?id=42" class="nav-link " id="menu_80"><span class="title"> KCD_SH02_002</span></a></li>
          <li class="nav-item"><a href="device/info/update_page/wearable?id=43" class="nav-link " id="menu_81"><span class="title"> KCD_SH03_003</span></a></li>
        </ul>
      </li>
      <li class="nav-item"><a href="javascript:;" class="nav-link nav-toggle" id="menu_80"><span class="title"> 便携式检测仪</span><span class="arrow"></span></a>
         <ul class="sub-menu" >
          <li class="nav-item"><a href="device/info/update_page/wearable?id=44" class="nav-link " id="menu_79"><span class="title"> KCD_JC01_001</span></a></li>
          <li class="nav-item"><a href="device/info/update_page/wearable?id=45" class="nav-link " id="menu_80"><span class="title"> KCD_JC02_002</span></a></li>
        </ul>
      </li> -->
     </ul></li>
   </ul>
</li>
              
              <li class="nav-item"><a href="javascript:;"
                class="nav-link nav-toggle"> <i class="icon-settings"></i> <span
                    class="title">系统工具</span> <span class="selected"></span> <span
                    class="arrow"></span>
                </a>
                <ul class="sub-menu">
                   <!--  <li class="nav-item  "><a href="page_system_404_1.html"
                        class="nav-link "> <span class="title">单点故障调试</span>
                    </a></li> -->
                    <li class="nav-item  "><a href="javascript:;" class="nav-link nav-toggle " > <span class="arrow">服务性能分析</span>
                    </a>
                        <ul class="sub-menu" >
                          <li class="nav-item"><a href="debug/dandian/page" class="nav-link " id="menu_791"><span class="title"> 通信状态</span></a></li>
                         <!--  <li class="nav-item"><a href="debug/tongxun/page" class="nav-link " id="menu_801"><span class="title"> 服务器性能</span></a></li> -->
                        </ul>
                    </li>
                    <!--  <li class="nav-item  "><a href="page_system_404_2.html"
                        class="nav-link " target="_blank"> <span class="title">事件记录器</span>
                    </a></li> -->
                   <!--  <li class="nav-item  "><a href="page_system_404_2.html"
                        class="nav-link " target="_blank"> <span class="title">通信状态</span>
                    </a></li> -->
                </ul>
              </li>
              
              <li class="nav-item"><a href="stat/collect"
                class="nav-link nav-toggle"> <i class="icon-map"></i> <span
                    class="title">分布式数据采集</span> </span>
                </a>
              </li>
              <li class="nav-item"><a href="stat/camrea"
                class="nav-link nav-toggle"> <i class="icon-camera"></i> <span
                    class="title">人员视频管理</span> </span>
                </a>
              </li>
              
              <li class="nav-item"><a href="javascript:;"
                class="nav-link nav-toggle"> <i class="icon-users"></i> <span
                    class="title">系统管理</span> <span class="selected"></span> <span
                    class="arrow"></span>
                </a>
                <ul class="sub-menu">
                    <li class="nav-item  "><a href="priv/info/page"
                        class="nav-link " target="_blank"> <span class="title">用户管理</span>
                    </a></li>
                    <li class="nav-item  "><a href="device/data/copy"
                        class="nav-link "> <span class="title">数据备份</span>
                    </a></li>
                    <li class="nav-item  "><a href="device/history/data/page"
                        class="nav-link "> <span class="title">历史数据</span>
                    </a></li>
                    <li class="nav-item  "><a href="stat/collect/shangchuan"
                        class="nav-link "> <span class="title">上传</span>
                    </a></li> 
                </ul>
              </li>
			
		
<%-- 			<c:forEach items="${menuTreeList}" var="menuTree"> --%>
<!-- 				<li class="nav-item"> -->
<!-- 					<a href="javascript:;" class="nav-link nav-toggle"> -->
<%-- 						<i class="${menuTree.RES_ICON}"></i> --%>
<%-- 						<span class="title">${menuTree.RES_NAME}</span> --%>
<!-- 						<span class="arrow"></span> -->
<!-- 					</a> -->
<%-- 					<c:if test="${!empty menuTree.sysResourceList }"> --%>
<!-- 						<ul class="sub-menu"> -->
<%-- 							<c:forEach items="${menuTree.sysResourceList}" var="subMenuTree"> --%>
<!-- 								<li class="nav-item"> -->
<%-- 									<a href="${subMenuTree.RES_URL}" class="nav-link"> --%>
<%-- 									<span class="title">${subMenuTree.RES_NAME}</span> --%>
<!-- 									</a> -->
<!-- 								</li> -->
<%-- 							</c:forEach> --%>
<!-- 						</ul> -->
<%-- 					</c:if> --%>
<!-- 				</li> -->
<%-- 			</c:forEach> --%>
			

		</ul>
        </div>
	</div>
</div>
<!-- END SIDEBAR -->