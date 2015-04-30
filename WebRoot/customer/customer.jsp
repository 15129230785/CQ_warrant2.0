<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.css" />

<title>任务权限管理</title>
<style type="text/css">
body {
	font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica,
		sans-serif;
	color: #4f6b72;
	background: #E6EAE9;
}

#r {
	font: bold 14px/25px "宋体";
	color: #4f6b72;
	border: 1px solid #000;
	letter-spacing: 2px;
	text-align: center;
	background: #CAE8EA;
}

#d {
	font: bold 12px/25px "宋体";
	background: #F5FAFA;
	color: #797268;
	text-align: center;
}

#d a {
	color: red;
	text-decoration: none;
}

#d a:hover {
	text-decoration: underline;
}
</style>

<script type="text/javascript">
	addEvent = function() {
		var _li = document.getElementsByTagName("tr");
		for (var i = 0; i < _li.length; i++) {
			_li[i].onmouseover = function() {
				chColor(this, "#CAE8EA");
			};
			_li[i].onmouseout = function() {
				chColor(this, "");
			};
		}
	};

	chColor = function(obj, color) {
		obj.style.background = color;
	};
</script>
</head>
<body onload="init()">
	名称：
	<select id="customer" name="userName"></select> 角色：
	<select id="groupList" name="branch"></select>
	<input type="button" onClick="cxCustomer()" value="查询" />
	<input type="button" onClick="addCustomer()" value="添加" />
	<div id="groupDiv"></div>

	<div id='alertDiv' title='信息'>
		<p id='alertTxt'></p>
	</div>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>	
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/customer.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=basePath%>js/memberShipManage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>