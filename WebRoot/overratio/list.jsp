<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>过度系数配置</title>
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
		xmlhttp.open("GET", "listOverRatio.action" + "?tn=" + Math.random(), false);
		xmlhttp.send();
		//alert(xmlhttp.responseText);
		document.getElementById("overratiodiv").innerHTML = xmlhttp.responseText;
	}

	function updateOverRatioJs(or0, or1, or2) {
		 window.open("<%=basePath%>overratio/update.jsp?or0="
				+ or0 + "&or1=" + or1 + "&or2=" + or2 + "&rn=" + Math.random(),
				"Sample",
				"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no, copyhistory=no,width=500,height=500,left=350,top=240");
	}
</script>
</head>
<body onload="init();">
	<div id="overratiodiv"></div>
</body>
</html>
