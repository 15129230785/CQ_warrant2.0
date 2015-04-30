<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>业务检查参数配置</title>
<style type="text/css">
table {
	font: normal 14px "宋体";
	border-collapse:collapse;
	border: 1px solid #476074;
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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/initXMLHTTP.js"></script>
<script type="text/javascript">
	var xmlhttp = null;
	function init() {
		xmlhttp = initxmlhttp();
		setTimeout("listajax()", 1000);
	}

	function listajax() {
		xmlhttp.open("GET", "listSrvChk.action" + "?rn=" + Math.random(), false);
		xmlhttp.send();
		//alert(xmlhttp.responseText);
		document.getElementById("srvchkdiv").innerHTML = xmlhttp.responseText;
	}

	function updateSrvChkJs(comtype, comrevenue, employee, year, mortgage,
			address, vocation, income, personmortgage) {
		window.open("<%=basePath%>servicecheck/update.jsp?comtype="
			+ comtype + "&comrevenue=" + comrevenue
			+ "&employee=" + employee + "&year=" + year
			+ "&mortgage=" + mortgage + "&address="
			+ address + "&vocation=" + vocation
			+ "&income=" + income + "&personmortgage=" + personmortgage
			+ "&rn=" + Math.random(),
			"Sample",
			"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no, copyhistory=no,width=500,height=500,left=350,top=240");
	}
</script>
</head>
<body onload="init();">
	<div id="srvchkdiv"></div>
</body>
</html>
