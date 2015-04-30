<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	Map<String, String> m = new HashMap<String, String>();
	m.put("0", "与被担保人重新制定还款计划");
	m.put("1", "追索反担保保证人");
	m.put("2", "行使抵押权");
	m.put("3", "行使质押权");
	m.put("4", "起诉");
	
	String mode = new String(request.getParameter("mode").getBytes("ISO-8859-1"), "UTF-8");
	String StartDate = new String(request.getParameter("StartDate").getBytes("ISO-8859-1"), "UTF-8");
	String describe = new String(request.getParameter("describe").getBytes("ISO-8859-1"), "UTF-8");
	if ("null".equals(describe)) {
		describe = "";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/service.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/companyApply.css" />
<title>追偿方式</title>
</head>

<body>
	<div class="L1">
		<table width="100%">
			<tr>
				<th width="15%">追偿方式</th>
				<td><%=m.get(mode)%></td>
			</tr>
			<tr>
				<th>追偿起始日期</th>
				<td><%=StartDate%></td>
			</tr>
			<tr>
				<th>追偿描述</th>
				<td><%=describe%></td>
			</tr>
		</table>
	</div>
	<br />
	<input type="button" onclick="window.close()" value="返回" />
</body>
</html>