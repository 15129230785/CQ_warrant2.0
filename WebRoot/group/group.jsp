<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
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
</style>

<script type="text/javascript">
	function del(id) {
		if (window.confirm("您确定删除" + "   " + id + "?")) {
			deleteGroup(id);
			showGroupList("groupList");
		}
	};

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
	window.onload = function() {
		showGroupList("groupList");
		addEvent();
	};
</script>
</head>
<body>
	<form action="AddGroup" method="post">
		组名：<input type="text" name="groupName" />
			<input type="submit" name="button" value="添加组" />
	</form>
	<div id="groupList"></div>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/groupManage.js"></script>
</body>
</html>