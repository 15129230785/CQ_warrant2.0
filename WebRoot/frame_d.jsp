<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
	
	String user = (String) session.getAttribute("user");
	if (user == null || user.length() == 0) {
		out.println("用户登录已经过期，请重新登录");
		return;
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery-ui-1.11.2/jquery-ui.css">
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	list-style-type: none;
}
ul li a {
	text-decoration: none;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/rootPath.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/userRight.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/operlog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/frameD.js"></script>
</head>

<body style="margin-top:5px">
	<input type="hidden" id="userName" value="<%=user%>" />
	<ul id="menuD">
		<li class="user_li">
			<a href="#">用户管理</a>
			<ul id="userManage">
				<li onclick="javascript:document.getElementById('userManagement').click();"><a id="userManagement" href="${pageContext.request.contextPath}/user/user.jsp" target="c">用户管理</a></li>
				<li></li>
				<li onclick="javascript:document.getElementById('groupManage').click();"><a id="groupManage" href="${pageContext.request.contextPath}/group/group.jsp" target="c">用户组管理</a></li>
				<li></li>
				<li onclick="javascript:document.getElementById('roleManage').click();"><a id="roleManage" href="${pageContext.request.contextPath}/membership/memberShip.jsp" target="c">角色管理</a></li>
				<li></li>
				<li onclick="javascript:document.getElementById('authorityManage').click();"><a id="authorityManage" href="<%=basePath%>customer/customer.jsp" target="c">权限管理</a></li>
			</ul>
		</li>
		<li class="user_li"></li>
		
		<li class="comdoclist_li" onclick="javascript:document.getElementById('datumManage').click();"><a id="datumManage" href="<%=basePath%>dataList/dataList.jsp?data=data" target="c">资料管理</a></li>
		<li class="comdoclist_li"></li>
		
		<li class="parameter_li" onclick="javascript:document.getElementById('bankInfomationManage').click();"><a id="bankInfomationManage" href="<%=basePath%>bankinfo/list.jsp" target="c">银行信息管理</a></li>
		<li class="parameter_li"></li>
		
		<li onclick="javascript:document.getElementById('sysParameterManage').click();"><a id="sysParameterManage" href="<%=basePath%>sysparam/systemParameter.jsp" target="c">系统参数设置</a></li>
		<li></li>
		<li>
			<a href="#">日志管理</a>
			<ul>
				<li onclick="javascript:document.getElementById('operateRecord').click();"><a id="operateRecord" href="<%=basePath%>operlog/operlog.jsp" target="c">查询操作记录</a></li>
				<li></li>
				<li onclick="javascript:document.getElementById('sysLogRecord').click();"><a id="sysLogRecord" href="<%=basePath%>syslog/syslog.jsp" target="c">查询系统运行日志</a></li>
			</ul>
		</li>
	</ul>
</body>
</html>