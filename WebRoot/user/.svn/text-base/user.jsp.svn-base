<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
	String user = (String)session.getAttribute("user");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery-ui-1.11.2/jquery-ui.css">
<title>Insert title here</title>
<style type="text/css">
body {
	font: normal 12px auto "Trebuchet MS", Verdana, Arial, Helvetica,
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

<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/userManage.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
<script type="text/javascript">
	function clicka(id) {
			var s = deleteUser(id);
			if (s == "y") {
				alert("对不起，" + id + "有未完成的任务，请先完成或者委托他人");
				return;
			}
			showUserList("<%=user%>", "userList");
	};
	function cli(id) {
		window.open("userUpdate.jsp?id=" + id + "&rn=" + Math.random(),
			"Sample",
			"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=400,height=350,left=350,top=240");
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
		showUserList("<%=user%>", "userList");
		addEvent();
	};
</script>
</head>
<body>
	<form action="" method="post">
		<div>
			<input type="text" name="selText" id="selText" />
			<input type="button" value="查询" onclick="listUser('<%=user%>','userList')" />
			<input onclick="window.open('userAdd.jsp','_self')" type="button" value="添加用户" />
		</div>
	</form>
	<div id="userList"></div>
	<div id='alertDiv' title='信息'>
		<p id='alertTxt'></p>
	</div>
</body>
</html>