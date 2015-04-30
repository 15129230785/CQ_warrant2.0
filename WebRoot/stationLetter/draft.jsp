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
		<style type="text/css">
			.a{text-decoration: none}
		</style>
		
	</head>
	<body onload="draft();" style="text-align: center;">
		<a href="writeLetter.jsp" target="c" style="font-size: 24px" class="a">写邮件</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="receiverLetter.jsp" target="c" style="font-size: 24px" class="a">收件箱</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="addresser.jsp" target="c" style="font-size: 24px" class="a">发件箱</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="draft.jsp" target="c" style="font-size: 24px" class="a">回收站</a>
		<hr/>
		<div id="tip"></div>
	<script type="text/javascript" src="<%=basePath%>js/public/rootPath.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/letterAll.js"></script>
	</body>
</html>