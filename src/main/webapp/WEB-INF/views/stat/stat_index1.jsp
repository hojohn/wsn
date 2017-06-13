<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../included/includedStyle.jsp" %>

 <style type="text/css">
.OrgBox{
    font-size:12px;
    padding:5px 5px 5px 5px;
    clear:left;
    float:left;
    text-align:center;
    position:absolute;
    
    width:70px;
    height:106px;
}
.OrgBox img{
    width:60px;
    height:70px;
}
.OrgBox div{
    color:#FFA500;
    font-weight:800;
}
body{
zoom:52%;
}
</style>
</head>

<body >
<jsp:include page="../wsn_device/hardware/top.jsp" ></jsp:include>
 <div class=" tabbable tabs-left"> 
  <!--  <div class="wrapper-box">
        <div class="row">
            <div class="col-md-2">
            <button class="btn green" onclick="listPage()">列表形式</button>
            <a href="stat/list_index">转换列表形式</a>
            </div>
        </div>
   </div> -->
      
<div class="tab-content">

<div class="tab-pane" id="tab2">
<div class="row">
    <div class="col-md-6">
        <div class="form-group">
           <label class="control-label col-md-4">传输频率（秒）</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="transRate" value="2">
            </div>
            <div class="col-md-2">
                <button type="button" id="btnQuery" class="btn green btn-mnt">修改</button>
            </div>
        </div>
     </div>
</div>
</div>

<div class="tab-pane active" id="tab1">
<script src="static/plugins/qrcode/jquery.qrcode.min.js" type="text/javascript"></script>
<script src="static/plugins/organization/organization.js" type="text/javascript"></script>
<script type="text/javascript">

var a=new OrgNode()
a.customParam.department="ALY_001_001";
a.customParam.EmpPhoto="static/img/index_p/1.jpg";
a.Link="device/info/update_page/server_page?id=ALY_001_001&hid=1";
a.Description=" 名称：阿里云服务器\n链接：www.aliyun.com\n功能：数据处理分析与计算";
var g=new OrgNode()
g.customParam.department="MN_T001_001"
g.Description=" 名称：移动节点\n监控对象：OBJ_C001_001\n功能：环境感知\n网关：WI-FI"
g.customParam.EmpPhoto="static/img/index_p/3.jpg"
g.Link="device/info/update_page/move_node?id=MN_T001_001&hid=1";
var g1=new OrgNode()
g1.customParam.department="氧气"
g1.customParam.EmpPhoto="static/img/index_p/2.jpg"
g1.Description="设备编码:SEN_YQ01_001  \n监控对象 ："
g1.Link="device/sensor?id=SEN_YQ01_001";
var g2=new OrgNode()
g2.customParam.department="压力"
g2.customParam.EmpPhoto="static/img/index_p/6.jpg"
g2.Description="设备编码:SEN_YL01_001  \n监控对象 ："
g2.Link="device/sensor?id=SEN_YL01_001";
var g3=new OrgNode()
g3.customParam.department="粉尘"
g3.customParam.EmpPhoto="static/img/index_p/5.jpg"
g3.Description = "设备编码:SEN_FC01_001  \n监控对象 ："
g3.Link="device/sensor?id=SEN_FC01_001";
var g4=new OrgNode()
g4.customParam.department="CO2"
g4.customParam.EmpPhoto="static/img/index_p/7.jpg"
g4.Description="设备编码:SEN_EY01_001  \n监控对象 ："
g4.Link="device/sensor?id=SEN_EY01_001";
var g5=new OrgNode()
g5.customParam.department="CO"
g5.customParam.EmpPhoto="static/img/index_p/8.jpg"
g5.Description="设备编码:SEN_CO01_001  \n监控对象 ："
g5.Link="device/sensor?id=SEN_CO01_001";
var g6=new OrgNode()
g6.customParam.department="甲烷"
g6.customParam.EmpPhoto="static/img/index_p/8.jpg"
g6.Description="设备编码:SEN_JW01_001  \n监控对象 ："
g6.Link="device/sensor?id=SEN_JW01_001";
var g8=new OrgNode()
g8.customParam.department="位移"
g8.customParam.EmpPhoto="static/img/index_p/10.jpg"
g8.Description="设备编码:SEN_WY01_001  \n监控对象 ："
g8.Link="device/sensor?id=SEN_WY01_001";

var f=new OrgNode()
f.customParam.department="MN_T001_002"
f.Description=" 名称：移动节点\n监控对象：OBJ_C001_001\n功能：环境感知\n网关：WI-FI"
f.customParam.EmpPhoto="static/img/index_p/3.jpg"
f.Link="device/info/update_page/move_node?id=MN_T001_002&hid=1";
var f1=new OrgNode()
f1.customParam.department="氧气"
f1.customParam.EmpPhoto="static/img/index_p/2.jpg"
f1.Description="设备编码:SEN_YQ02_002  \n监控对象 ："
f1.Link="device/sensor?id=SEN_YQ02_002";
var f2=new OrgNode()
f2.customParam.department="压力"
f2.customParam.EmpPhoto="static/img/index_p/6.jpg"
f2.Description="设备编码:SEN_YL02_002  \n监控对象 ："
f2.Link="device/sensor?id=SEN_YL02_002";
var f3=new OrgNode()
f3.customParam.department="粉尘"
f3.customParam.EmpPhoto="static/img/index_p/5.jpg"
f3.Description = "设备编码:SEN_FC02_002  \n监控对象 ："
f3.Link="device/sensor?id=SEN_FC02_002";
var f4=new OrgNode()
f4.customParam.department="CO2"
f4.customParam.EmpPhoto="static/img/index_p/7.jpg"
f4.Description="设备编码:SEN_EY02_002  \n监控对象 ："
f4.Link="device/sensor?id=SEN_EY02_002";
var f5=new OrgNode()
f5.customParam.department="CO"
f5.customParam.EmpPhoto="static/img/index_p/8.jpg"
f5.Description="设备编码:SEN_CO02_002  \n监控对象 ："
f5.Link="device/sensor?id=SEN_CO02_002";
var f6=new OrgNode()
f6.customParam.department="甲烷"
f6.customParam.EmpPhoto="static/img/index_p/8.jpg"
f6.Description="设备编码:SEN_JW02_002  \n监控对象 ："
f6.Link="device/sensor?id=SEN_JW02_002";
var f8=new OrgNode()
f8.customParam.department="位移"
f8.customParam.EmpPhoto="static/img/index_p/10.jpg"
f8.Description="设备编码:SEN_WY02_002  \n监控对象 ："
f8.Link="device/sensor?id=SEN_WY02_002";

var d=new OrgNode()
d.customParam.department="MN_T002_003"
d.Description=" 名称：移动节点\n监控对象：OBJ_C002_002\n功能：环境感知\n网关：WI-FI"
d.customParam.EmpPhoto="static/img/index_p/3.jpg"
d.Link="device/info/update_page/move_node?id=MN_T002_003&hid=1";
var d1=new OrgNode()
d1.customParam.department="氧气"
d1.customParam.EmpPhoto="static/img/index_p/2.jpg"
d1.Description="设备编码:SEN_YQ03_003  \n监控对象 ："
d1.Link="device/sensor?id=SEN_YQ03_003";
var d2=new OrgNode()
d2.customParam.department="压力"
d2.customParam.EmpPhoto="static/img/index_p/6.jpg"
d2.Description="设备编码:SEN_YL03_003  \n监控对象 ："
d2.Link="device/sensor?id=SEN_YL03_003";
var d3=new OrgNode()
d3.customParam.department="粉尘"
d3.customParam.EmpPhoto="static/img/index_p/5.jpg"
d3.Description = "设备编码:SEN_FC03_003  \n监控对象 ："
d3.Link="device/sensor?id=SEN_FC03_003";
var d4=new OrgNode()
d4.customParam.department="CO2"
d4.customParam.EmpPhoto="static/img/index_p/7.jpg"
d4.Description="设备编码:SEN_EY03_003  \n监控对象 ："
d4.Link="device/sensor?id=SEN_EY03_003";
var d5=new OrgNode()
d5.customParam.department="CO"
d5.customParam.EmpPhoto="static/img/index_p/8.jpg"
d5.Description="设备编码:SEN_CO03_003  \n监控对象 ："
d5.Link="device/sensor?id=SEN_CO03_003";
var d6=new OrgNode()
d6.customParam.department="甲烷"
d6.customParam.EmpPhoto="static/img/index_p/8.jpg"
d6.Description="设备编码:SEN_JW03_003  \n监控对象 ："
d6.Link="device/sensor?id=SEN_JW03_003";
var d8=new OrgNode()
d8.customParam.department="位移"
d8.customParam.EmpPhoto="static/img/index_p/10.jpg"
d8.Description="设备编码:SEN_WY03_003  \n监控对象 ："
d8.Link="device/sensor?id=SEN_WY03_003";

//ZigBee
var e=new OrgNode()
e.customParam.department="MN_T002_004"
e.Description=" 名称：移动节点\n监控对象：OBJ_C002_002\n功能：环境感知\n网关：ZigBee"
e.customParam.EmpPhoto="static/img/index_p/3.jpg"
e.Link="device/info/update_page/move_node?id=MN_T002_004&hid=1";
var e1=new OrgNode()
e1.customParam.department="温度"
e1.Description=" 设备编码:SEN_WD01_001  \n监控对象 ： "
e1.customParam.EmpPhoto="static/img/index_p/Th.jpg"
e1.Link="device/sensor?id=SEN_WD01_001";
var e2=new OrgNode()
e2.customParam.department="湿度"
e2.Description="设备编码:SEN_SD01_001  \n监控对象 ："
e2.customParam.EmpPhoto="static/img/index_p/Th.jpg"
e2.Link="device/sensor?id=SEN_SD01_001";
var e3=new OrgNode()
e3.customParam.department="烟雾"
e3.customParam.EmpPhoto="static/img/index_p/9.jpg"
e3.Description="设备编码:SEN_YW01_001  \n监控对象 ："
e3.Link="device/sensor?id=SEN_YW01_001";
var y=new OrgNode()
y.customParam.department="MN_T003_005"
y.Description=" 名称：移动节点\n监控对象：OBJ_C003_003\n功能：环境感知\n网关：ZigBee"
y.customParam.EmpPhoto="static/img/index_p/3.jpg"
y.Link="device/info/update_page/move_node?id=MN_T003_005&hid=1";
var y1=new OrgNode()
y1.customParam.department="温度"
y1.Description=" 设备编码:SEN_WD02_002  \n监控对象 ： "
y1.customParam.EmpPhoto="static/img/index_p/Th.jpg"
y1.Link="device/sensor?id=SEN_WD02_002";
var y2=new OrgNode()
y2.customParam.department="湿度"
y2.Description="设备编码:SEN_SD02_002 \n监控对象 ："
y2.customParam.EmpPhoto="static/img/index_p/Th.jpg"
y2.Link="device/sensor?id=SEN_SD02_002";
var y3=new OrgNode()
y3.customParam.department="烟雾"
y3.customParam.EmpPhoto="static/img/index_p/9.jpg"
y3.Description="设备编码:SEN_YW02_002  \n监控对象 ："
y3.Link="device/sensor?id=SEN_YW02_002";
var z=new OrgNode()
z.customParam.department="MN_T003_006"
z.Description=" 名称：移动节点\n监控对象：OBJ_C003_003\n功能：环境感知\n网关：ZigBee"
z.customParam.EmpPhoto="static/img/index_p/3.jpg"
z.Link="device/info/update_page/move_node?id=MN_T003_006&hid=1";
var z1=new OrgNode()
z1.customParam.department="温度"
z1.Description=" 设备编码:SEN_WD03_003  \n监控对象 ：OBJ_C001_001 "
z1.customParam.EmpPhoto="static/img/index_p/Th.jpg"
z1.Link="device/sensor?id=SEN_WD03_003";
var z2=new OrgNode()
z2.customParam.department="湿度"
z2.Description="设备编码:SEN_SD03_003  \n监控对象 ：OBJ_C001_001"
z2.customParam.EmpPhoto="static/img/index_p/Th.jpg"
z2.Link="device/sensor?id=SEN_SD03_003";
var z3=new OrgNode()
z3.customParam.department="烟雾"
z3.customParam.EmpPhoto="static/img/index_p/9.jpg"
z3.Description="设备编码:SEN_YW03_003  \n监控对象 :"
z3.Link="device/sensor?id=SEN_YW03_003";
var b=new OrgNode()
b.customParam.department="KCD_JC01_001"
b.Description=" 名称：便携式检测仪 \n监控对象：OBJ_C003_003\n功能：环境感知\n网关：WI-FI"
b.customParam.EmpPhoto="static/img/index_p/3.jpg"
b.Link="bracelet/info/page?id=KCD_JC01_001&hid=1";
var b1=new OrgNode()
b1.customParam.department="心跳"
b1.customParam.EmpPhoto="static/img/xiaomi3.jpg"
b1.Description="设备编码:SEN_XT01_001  \n监控对象 :"
b1.Link="device/sensor?id=SEN_XT01_001";
var b2=new OrgNode()
b2.customParam.department="体温"
b2.customParam.EmpPhoto="static/img/xiaomi2.jpg"
b2.Description="设备编码:SEN_TW01_001  \n监控对象 :"
b2.Link="device/sensor?id=SEN_TW01_001";
var b3=new OrgNode()
b3.customParam.department="噪声"
b3.customParam.EmpPhoto="static/img/xiaomi.jpg   "
b3.Description="设备编码:SEN_ZS01_001  \n监控对象 :"
b3.Link="device/sensor?id=SEN_ZS01_001";
var b4=new OrgNode()
b4.customParam.department="粉尘"
b4.customParam.EmpPhoto="static/img/xiaomi4.jpg   "
b4.Description="设备编码:SEN_FC01_001  \n监控对象 :"
b4.Link="device/sensor?id=SEN_FC01_001";
var c=new OrgNode()
c.customParam.department="KCD_JC02_002"
c.Description=" 名称：便携式检测仪 \n监控对象：OBJ_C003_003\n功能：环境感知\n网关：WI-FI"
c.customParam.EmpPhoto="static/img/index_p/3.jpg"
c.Link="bracelet/info/page?id=KCD_JC02_002&hid=1";
var c1=new OrgNode()
c1.customParam.department="心跳"
c1.customParam.EmpPhoto="static/img/xiaomi3.jpg   "
c1.Description="设备编码:SEN_XT02_002  \n监控对象 :"
c1.Link="device/sensor?id=SEN_XT02_002";
var c2=new OrgNode()
c2.customParam.department="体温"
c2.customParam.EmpPhoto="static/img/xiaomi2.jpg   "
c2.Description="设备编码:SEN_TW02_002  \n监控对象 :"
c2.Link="device/sensor?id=SEN_TW02_002";
var c3=new OrgNode()
c3.customParam.department="噪声"
c3.customParam.EmpPhoto="static/img/xiaomi.jpg   "
c3.Description="设备编码:SEN_ZS02_002  \n监控对象 :"
c3.Link="device/sensor?id=SEN_ZS02_002";
var c4=new OrgNode()
c4.customParam.department="粉尘"
c4.customParam.EmpPhoto="static/img/xiaomi4.jpg   "
c4.Description="设备编码:SEN_FC02_002  \n监控对象 :"
c4.Link="device/sensor?id=SEN_FC02_002";

a.Nodes.Add(g);
a.Nodes.Add(f);
a.Nodes.Add(d);
a.Nodes.Add(e);
a.Nodes.Add(y);
a.Nodes.Add(z);
a.Nodes.Add(b);
a.Nodes.Add(c);
e.Nodes.Add(e1);
e.Nodes.Add(e2);
e.Nodes.Add(e3);
y.Nodes.Add(y1);
y.Nodes.Add(y2);
y.Nodes.Add(y3);
z.Nodes.Add(z1);
z.Nodes.Add(z2);
z.Nodes.Add(z3);
g.Nodes.Add(g1);
g.Nodes.Add(g2);
//g.Nodes.Add(g3);
g.Nodes.Add(g4);
g.Nodes.Add(g5);
g.Nodes.Add(g6);
g.Nodes.Add(g8);
f.Nodes.Add(f1);
f.Nodes.Add(f2);
//f.Nodes.Add(f3);
f.Nodes.Add(f4);
f.Nodes.Add(f5);
f.Nodes.Add(f6);
f.Nodes.Add(f8);
d.Nodes.Add(d1);
d.Nodes.Add(d2);
//d.Nodes.Add(d3);
d.Nodes.Add(d4);
d.Nodes.Add(d5);
d.Nodes.Add(d6);
d.Nodes.Add(d8);
b.Nodes.Add(b1);
b.Nodes.Add(b2);
b.Nodes.Add(b3);
b.Nodes.Add(b4);
c.Nodes.Add(c1);
c.Nodes.Add(c2);
c.Nodes.Add(c3);
c.Nodes.Add(c4);
var OrgShows=new OrgShow(a);
OrgShows.Top=50;
OrgShows.Left=50;
OrgShows.IntervalWidth=10;
OrgShows.IntervalHeight=100;
OrgShows.BoxTemplet="<div id=\"{Id}\" class=\"OrgBox\"><a href=\"{Link}\"><img src=\"{EmpPhoto}\" title=\"{Description}\" /></a><div>{department}</div></div>"
OrgShows.Run() 
</script>
</div>
</div>
</div>

<%@include file="../included/includedJs.jsp" %>


</body>
</html>