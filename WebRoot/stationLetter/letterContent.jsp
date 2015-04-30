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
<%
	String message =new String(request.getParameter("message").getBytes("ISO8859-1"), "UTF-8");
%>
</head>
<body>
	<%=message%><br/>
	<td><input type="button" onclick="javascript:window.close()" value="关闭" /></td>
</body>
</html>