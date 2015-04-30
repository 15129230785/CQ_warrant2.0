<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>计算类指标系数管理</title>
<style type="text/css">
table {
	font: normal 14px "宋体";
	border-collapse:collapse;
	border: 1px solid #476074;
	margin:10px 0;
}
table td {
	font: normal 12px/30px "宋体";
	color: #797268;
	border: 1px solid #476074;
	border-collapse:collapse;
	text-align:center
}
p{font:bold 14px "宋体";color:#797268;}
a{text-decoration:none;color:#797268;}
a:hover{text-decoration:underline;}
</style>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript">
	var xmlhttp = null; 
	function init() {
		xmlhttp = initxmlhttp();
		setTimeout("listajax()", 1000);
	}
	
	function listajax() {
		xmlhttp.open("GET", "listCalculateindex.action" + "?rn=" + Math.random(), false);
		xmlhttp.send();
		document.getElementById("calculateindexdiv").innerHTML = xmlhttp.responseText;
		//alert(xmlhttp.responseText);
	}
	
	function addCalculateindexJs() {
		window.open("<%=basePath%>calculateindex/add.jsp?rn=" + Math.random(),
			"Sample",
			"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=500,height=500,left=350,top=240");
	}
	
	function deleteCalculateindexJs(iid) {
		if (window.confirm("您确定删除?")) {
			xmlhttp.open("GET", "deleteCalculateindex.action?iid=" + iid + "&rn=" + Math.random(), false);
			xmlhttp.send();
			document.getElementById("calculateindexdiv").innerHTML =xmlhttp.responseText;
		}
	}

	function updateCalculateindexJs(name, cname, floor, ceil, indexvalue, ratio, iid) {
		 window.open("<%=basePath%>calculateindex/update.jsp?name=" + name
				 + "&cname=" + cname + "&floor=" + floor
				 + "&ceil=" + ceil + "&indexvalue=" + indexvalue + "&ratio=" + ratio + "&iid=" + iid
				 + "&rn=" + Math.random(),
				"Sample",
				"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=500,height=500,left=350,top=240");
	}
</script>
</head>
<body onload="init();">
	<button type="button" onclick="addCalculateindexJs();">添加计算类指标系数</button>
	<div id="calculateindexdiv"></div>
</body>
</html>
