<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";

	String taskId = request.getParameter("id");
	String username = (String) session.getAttribute("user");
	String wid = request.getParameter("wid");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/service.css" />
<title>退评审费</title>
</head>

<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
	</div>
	<br />
	<form action="Refund" id="refund" method="post">
		<fieldset>
			<legend>退评审费</legend>
			<table>
				<tr>
					<td>评审费(元)：</td>
					<td><input type="text" name="money" id="money" value="" readonly/></td>
				</tr>
			</table>
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
			<table>
				<tr style="display: none;">
					<td><input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
					<td><input type="text" name="taskid" value="<%=taskId%>" /></td>
					<td><input type="text" id="num" value="refund" /></td>
					<td><input type="text" id="username" value="<%=username%>" /></td>
					<td><input type="text" name="serviceType" id="serviceType" /></td>
				</tr>
				<tr >
					<td>评审费是否已经退还给客户：</td>
					<td><input type="checkbox" id="check" /></td>
				</tr>
			</table>
			<table>
				<tr>
					<td width="90">处理方式：</td>
					<td><select name="sel" onchange="thisSel()" id="processid"
						style="width: 150px">
							<option value="nextLater">下一处理环节</option>
							<option value="transfer">委托他人处理</option>
					</select></td>
				</tr>
			</table>
			<table>
				<tr id="zd" style="display: none;">
					<td width="90">指定处理人：</td>
					<td id="selOpe"></td>
				</tr>
				<tr>
					<td><input type="button" onclick="m()" value="提交" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<div id='alertDiv' title='信息'>
		<p id='alertTxt'></p>
	</div>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/chargeInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/refund.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>