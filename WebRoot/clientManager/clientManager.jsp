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
<link rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link rel="stylesheet" href="<%=basePath%>css/client.css" />
<title>客户管理</title>
</head>

<body>
	<table style="margin-left: 10px">
		<tr>
			<td><div id="ctmenudiv">
				<ul id="ctmenu">
					<li>
						<a id="act" href="#">所有客户</a>
						<ul>
							<li onclick="javascript:document.getElementById('all').click();"><a id="all" href="#" class="ctclass">所有</a></li>
							<li></li>
							<li onclick="javascript:document.getElementById('company').click();"><a id="company" href="#" class="ctclass">企业</a></li>
							<li></li>
							<li onclick="javascript:document.getElementById('person').click();"><a id="person" href="#" class="ctclass">个人</a></li>
						</ul>
					</li>
				</ul>
			</div></td>
			<td><input type="hidden" id="clientType" value="0"/></td>
			<td><label for="txt">客户名称：</label></td>
			<td><input type="text" id="txt" /></td>
			<td><input type="button" value="查询" onclick="clientInfoDivClose()" /></td>
			<td width="50"></td>
			<td><ul id="addmenu">
				<li>
					<a href="#">添加客户</a>
					<ul>
						<li onclick="javascript:document.getElementById('addCompany').click();"><a id="addCompany" href="#" class="addclass">企业客户</a></li>
						<li></li>
						<li onclick="javascript:document.getElementById('addPerson').click();"><a id="addPerson" href="#" class="addclass">个人客户</a></li>
					</ul>
				</li>
			</ul></td>
		</tr>
	</table>
	<div id="clientInfoDiv"></div>

<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/rootPath.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/companyApply.js"></script>
<script type="text/javascript" src="<%=basePath%>js/client.js"></script>
<script type="text/javascript" src="<%=basePath%>js/clientManager.js"></script>
</body>
</html>