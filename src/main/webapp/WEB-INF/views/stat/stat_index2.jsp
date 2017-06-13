<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<script src="static/plugins/organization/organization.js" type="text/javascript"></script>
<style type="text/css">
.OrgBox{
	font-size:12px;
	padding:5px 5px 5px 5px;
	clear:left;
	float:left;
	text-align:center;
	position:absolute;
	background-image:url(http://www.on-cn.cn/tempimg/org.jpg);
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
</style>
</head>
<body>
<script language="javascript">
var a=new OrgNode()
a.customParam.department="阿里云";
a.customParam.EmpPhoto="static/img/index_p/1.jpg";
a.Link="#";
a.Description=" I D：阿里云服务器、\n链接：www.aliyun.com\n功能：数据处理分析与计算"
var b=new OrgNode()
b.customParam.department="终端1"
b.customParam.EmpPhoto="static/img/index_p/4.jpg"
b.Description=" I D：Inter爱迪生开发板\n车间：1\n功能：数据处理分析与计算"
var c=new OrgNode()
c.customParam.department="终端2"
c.Description=" I D：Inter爱迪生开发板\n车间：2\n功能：数据处理分析与计算"
c.customParam.EmpPhoto="static/img/index_p/4.jpg"
var d=new OrgNode()
d.customParam.department="单片机3"
d.Description=" I D：Genuino UNO单片机开发板\n车间：2\n功能：环境感知"
d.customParam.EmpPhoto="static/img/index_p/3.jpg"
var e=new OrgNode()
e.customParam.department="单片机4"
e.Description=" I D：Genuino UNO单片机开发板\n车间：2\n功能：环境感知"
e.customParam.EmpPhoto="static/img/index_p/3.jpg"
var d1=new OrgNode()
d1.customParam.department="温度传感器"
d1.Description="ID:  \n车间：3\n实时数据：25℃ "
d1.customParam.EmpPhoto="static/img/index_p/Th.jpg"
var d2=new OrgNode()
d2.customParam.department="湿度传感器"
d2.Description="ID:  \n车间：3\n 实时数据：25℃ "
d2.customParam.EmpPhoto="static/img/index_p/Th.jpg"
var d3=new OrgNode()
d3.customParam.department="氧气传感器"
d3.customParam.EmpPhoto=""
d3.Description="zxxxcz"
var d4=new OrgNode()
d4.customParam.department="噪声传感器"
d4.customParam.EmpPhoto="static/img/index_p/6.jpg"
var d5=new OrgNode()
d5.customParam.department="粉尘传感器"
d5.customParam.EmpPhoto="static/img/index_p/5.jpg"
var e1=new OrgNode()
e1.customParam.department="CO2传感器"
e1.customParam.EmpPhoto="static/img/index_p/7.jpg"
e1.Description="zxxxcz"
var e2=new OrgNode()
e2.customParam.department="CO传感器"
e2.customParam.EmpPhoto="static/img/index_p/8.jpg"
e2.Description="zxxxcz"
var e3=new OrgNode()
e3.customParam.department="甲烷传感器"
e3.customParam.EmpPhoto="static/img/index_p/8.jpg"
e3.Description="zxxxcz"
var e4=new OrgNode()
e4.customParam.department="烟雾传感器"
e4.customParam.EmpPhoto="static/img/index_p/9.jpg"
e4.Description="zxxxcz"
var e5=new OrgNode()
e5.customParam.department="位移传感器"
e5.customParam.EmpPhoto="static/img/index_p/10.jpg"
e5.Description="zxxxcz"
var g=new OrgNode()
g.customParam.department="单片机1"
g.Description=" I D：Genuino UNO单片机开发板\n车间：1\n功能：环境感知"
g.customParam.EmpPhoto="static/img/index_p/3.jpg"
var f=new OrgNode()
f.customParam.department="单片机2"
f.Description=" I D：Genuino UNO单片机开发板\n车间：1\n功能：环境感知"
f.customParam.EmpPhoto="static/img/index_p/3.jpg"
var g1=new OrgNode()
g1.customParam.department="温度传感器"
g1.Description="ID:  \n车间：1\n实时数据：25℃ "
g1.customParam.EmpPhoto="static/img/index_p/Th.jpg"
var g2=new OrgNode()
g2.customParam.department="湿度传感器"
g2.Description="ID:  \n车间：1\n实时数据：25℃ "
g2.customParam.EmpPhoto="static/img/index_p/Th.jpg"
var g3=new OrgNode()
g3.customParam.department="氧气传感器"
g3.customParam.EmpPhoto=""
g3.Description="zxxxcz"
var g4=new OrgNode()
g4.customParam.department="噪声传感器"
g4.customParam.EmpPhoto="static/img/index_p/6.jpg"
var g5=new OrgNode()
g5.customParam.department="粉尘传感器"
g5.customParam.EmpPhoto="static/img/index_p/5.jpg"
var f1=new OrgNode()
f1.customParam.department="CO2传感器"
f1.customParam.EmpPhoto="static/img/index_p/7.jpg"
f1.Description="zxxxcz"
var f2=new OrgNode()
f2.customParam.department="CO传感器"
f2.customParam.EmpPhoto="static/img/index_p/8.jpg"
f2.Description="zxxxcz"
var f3=new OrgNode()
f3.customParam.department="甲烷传感器"
f3.customParam.EmpPhoto="static/img/index_p/8.jpg"
f3.Description="zxxxcz"
var f4=new OrgNode()
f4.customParam.department="烟雾传感器"
f4.customParam.EmpPhoto="static/img/index_p/9.jpg"
f4.Description="zxxxcz"
var f5=new OrgNode()
f5.customParam.department="位移传感器"
f5.customParam.EmpPhoto="static/img/index_p/10.jpg"
f5.Description="zxxxcz"
var x=new OrgNode()
x.customParam.department="终端3"
x.Description=" I D：Inter爱迪生开发板\n车间：3\n功能：数据处理分析与计算"
x.customParam.EmpPhoto="static/img/index_p/4.jpg"
var y=new OrgNode()
y.customParam.EmpName="节点5"
y.customParam.department="单片机5"
y.Description=" I D：Genuino UNO单片机开发板\n车间：3\n功能：环境感知"
y.customParam.EmpPhoto="static/img/index_p/3.jpg"
var z=new OrgNode()
z.customParam.department="单片机6"
z.Description=" I D：Genuino UNO单片机开发板\n车间：3\n功能：环境感知"
z.customParam.EmpPhoto="static/img/index_p/3.jpg"
var z1=new OrgNode()
z1.customParam.department="温度传感器"
z1.Description="ID:  \n车间：3\n实时数据：25℃ "
z1.customParam.EmpPhoto="static/img/index_p/Th.jpg"
var z2=new OrgNode()
z2.customParam.department="湿度传感器"
z2.customParam.EmpPhoto="static/img/index_p/Th.jpg"
var z3=new OrgNode()
z3.customParam.department="氧气传感器"
z3.customParam.EmpPhoto=""
z3.Description="zxxxcz"
var z4=new OrgNode()
z4.customParam.department="噪声传感器"
z4.customParam.EmpPhoto="static/img/index_p/6.jpg"
var z5=new OrgNode()
z5.customParam.department="粉尘传感器"
z5.customParam.EmpPhoto="static/img/index_p/5.jpg"
var y1=new OrgNode()
y1.customParam.department="CO2传感器"
y1.customParam.EmpPhoto="static/img/index_p/7.jpg"
y1.Description="zxxxcz"
var y2=new OrgNode()
y2.customParam.department="CO传感器"
y2.customParam.EmpPhoto="static/img/index_p/8.jpg"
y2.Description="zxxxcz"
var y3=new OrgNode()
y3.customParam.department="甲烷传感器"
y3.customParam.EmpPhoto="static/img/index_p/8.jpg"
y3.Description="zxxxcz"
var y4=new OrgNode()
y4.customParam.department="烟雾传感器"
y4.customParam.EmpPhoto="static/img/index_p/9.jpg"
y4.Description="zxxxcz"
var y5=new OrgNode()
y5.customParam.department="位移传感器"
y5.customParam.EmpPhoto="static/img/index_p/10.jpg"
y5.Description="zxxxcz"
y.Nodes.Add(y1);
y.Nodes.Add(y2);
y.Nodes.Add(y3);
y.Nodes.Add(y4);
y.Nodes.Add(y5);
z.Nodes.Add(z1);
z.Nodes.Add(z2);
z.Nodes.Add(z3);
z.Nodes.Add(z4);
z.Nodes.Add(z5);
x.Nodes.Add(y);
x.Nodes.Add(z);
a.Nodes.Add(b);
a.Nodes.Add(c);
a.Nodes.Add(x);
b.Nodes.Add(g);
g.Nodes.Add(g1);
g.Nodes.Add(g2);
g.Nodes.Add(g3);
g.Nodes.Add(g4);
g.Nodes.Add(g5);
b.Nodes.Add(f);
f.Nodes.Add(f1);
f.Nodes.Add(f2);
f.Nodes.Add(f3);
f.Nodes.Add(f4);
f.Nodes.Add(f5);
c.Nodes.Add(d);
d.Nodes.Add(d1);
d.Nodes.Add(d2);
d.Nodes.Add(d3);
d.Nodes.Add(d4);
d.Nodes.Add(d5);
c.Nodes.Add(e);
e.Nodes.Add(e1);
e.Nodes.Add(e2);
e.Nodes.Add(e3);
e.Nodes.Add(e4);
e.Nodes.Add(e5);
var OrgShows=new OrgShow(a);
OrgShows.Top=50;
OrgShows.Left=50;
OrgShows.IntervalWidth=10;
OrgShows.IntervalHeight=20;
//OrgShows.ShowType=2;
//OrgShows.BoxHeight=100;
OrgShows.BoxTemplet="<div id=\"{Id}\" class=\"OrgBox\"><a href=\"{Link}\"><img src=\"{EmpPhoto}\" title=\"{Description}\" /></a><div>{department}</div></div>"
OrgShows.Run()
</script>

</body>
</html>
