<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery-ui-1.11.2/jquery-ui.css">
<title>添加用户</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
<script type="text/javascript">
	function ret(userName, userPass, email) {
		if (email != "" && !/^[\w\.\-]+@([\w\-]+\.)+[a-zA-Z]+$/.test(email)) {
			alert("对不起，E-mail输入有误");
		} else {
			document.getElementById("fr").submit();
			setTimeout("locHref()", 200);
		}
	};
	function locHref() {
		document.location = "user.jsp?rn=" + Math.random();
	}
</script>
</head>
<body>
	<form action="AddUser" id="fr" method="post">
		<table width="329" border="0" align="center">
			<tr>
				<td width="148" height="51" align="right">用户名：</td>
				<td width="262" align="left"><input type="text" name="userName"
					id="userName" width="200px" height="20px" /></td>
			</tr>
			<tr>
				<td height="53" align="right">密码：</td>
				<td align="left"><input type="password" name="userPass"
					width="200px" height="20px" /></td>
			</tr>
			<tr>
				<td height="56" align="right">确认密码：</td>
				<td align="left"><input type="password" name="pass"
					width="200px" height="20px" /></td>
			</tr>
			<tr>
				<td height="57" align="right">email：</td>
				<td align="left"><input type="text" name="email" id="email"
					width="200px" height="20px" /></td>
			</tr>
			<tr>
				<td height="35" align="right"><input type="button"
					onclick="ret(userName.value,'userPass',email.value)" name="button"
					id="button" value="提交" /></td>
				<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					onclick="javascript:history.back(1);" type="button" value="返回" /></td>
			</tr>
		</table>
	</form>
</body>
</html>