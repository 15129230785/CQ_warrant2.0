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
<title></title>
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
#d a{color: green;text-decoration:none;}
#d a:hover{text-decoration:underline;}
</style>
<%
	String user= (String) session.getAttribute("user");
%>

<script type="text/javascript">
	function cliMem(id) {
		if (window.confirm("您确定删除?")) {
			deleteMemberShip(id);
			showMemberShipList("memberShipList", "", "");
		}
	}
	
	function addMem(id, name) {
		addMemberShip(id, name);
		showMemberShipList("memberShipList", "", "");
	}
	
	function CXMem(id, name) {
		showMemberShipList("memberShipList", id, name);
	}
	
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
		showUserList("<%=user%>", "userList");
		showGroupList("groupList");
		showMemberShipList("memberShipList", "", "");
		addEvent();
	};
</script>
</head>
<body>
	<form name="form1" method="post" action="" >
		人员姓名：<select id="userList" name="userName"></select>角色：<select id="groupList" name="branch"></select>
		<input type="button" onClick="addMem(userName.value, branch.value)"
			value="添加" /><input type="button"
			onClick="CXMem(userName.value, branch.value)" value="查询" />
	</form>
	<div id="memberShipList"></div>
	
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/memberShipManage.js" charset="utf-8"></script>
</body>
</html>