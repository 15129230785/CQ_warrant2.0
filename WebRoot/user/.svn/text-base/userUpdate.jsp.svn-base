<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
	String user = (String)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<%
 	String id = new String(request.getParameter("id").getBytes("ISO-8859-1"), "UTF-8");
%>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/userManage.js" charset="UTF-8"></script>
<script type="text/javascript">
	function ret() {
		window.close();
	}
	function but() {
		var up = document.getElementById("userPass").value.trim();
		var u = document.getElementById("pass").value.trim();
		if (up == u) {
			document.getElementById("f").submit();
		}
		window.close();
	}

	function init() {
		showUserInfo("<%=id%>", "userInfo");
	}
</script>
</head>
<body onload="init()">
	<form name="" id="f" method="post" action="LoginActionU">
		<div id="userInfo"></div>
		<table align="center">
			<tr>
				<td><input type="button" onclick="but()" value="提交" /></td>
				<td><input type="reset" name="" onclick="ret()" value="返回" /></td>
				<td><input type="reset" name="button2" value="重置" />
			</tr>
		</table>
	</form>
</body>
</html>