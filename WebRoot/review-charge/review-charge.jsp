<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	String taskId = request.getParameter("id");
	String taskName = request.getParameter("taskname");
	String username = (String) session.getAttribute("user");
	String wid = request.getParameter("wid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/service.css" />
<title>评审收费</title>
</head>

<body class="panel">
	<div id="body">
		<a class="header" href="#" onclick="javascript:showMyProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
	</div>
	<br />
	<form id="fr" action="ReviewCharge" method="post" class="idform">
		<fieldset id="d">
			<legend>评审收费</legend>
			<table>
				<tr>
					<td width="120">评审费用(元)：</td>
					<td><input name="money" id="money" type="text" value=""
					onkeyup="inputDecimal(this)" /></td>
				</tr>
			</table>
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
			<table>
				<tr style="display: none;">
					<td><input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
					<td><input type="text" id="num" value="review-charge" /></td>
					<td><input type="text" id="serviceType" name="serviceType" /></td>
					<td><input type="text" id="username" value="<%=username%>" /></td>
				</tr>
				<tr>
					<td style="display: none;"><input type="text" name="taskid"
						value="<%=taskId%>" /></td>
				</tr>
				<tr>
					<td width="90">处理方式：</td>
					<td><select name="sel" id="processid" style="width: 150px">
						<option value="nextLater">下一处理环节</option>
						<option value="transfer">委托他人处理</option>
					</select></td>
				</tr>
				<tr>
					<td width="90">指定处理人：</td>
					<td id="selOpe"></td>
				</tr>
				<tr>
					<td><input type="button" onclick="sub()" value="提交" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<div id='alertDiv' title='信息'>
		<p id='alertTxt'></p>
	</div>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/decimal.js"></script>
<script type="text/javascript" src="<%=basePath%>js/transfer.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/review-charge.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>