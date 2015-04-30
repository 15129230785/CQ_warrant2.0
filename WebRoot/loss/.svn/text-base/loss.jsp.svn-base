<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
	
	String taskId = request.getParameter("id");
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
<title>核销损失</title>
</head>

<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showMyProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
	</div>
	<br />
	<form action="Loss" id="loss" method="post" class="idform">
		<fieldset>
			<legend>贷款流程结束</legend>
			<div class="L1" id="persueList"></div>
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
			<table>
				<tr style="display: none;">
					<td><input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
					<td><input type="text" name="taskid" value="<%=taskId%>" /></td>
					<td><input type="text" id="num" value="loss" /></td>
					<td><input type="text" name="serviceType" id="serviceType" /></td>
					<td><input type="text" id="username" value="<%=username%>" /></td>
				</tr>
				<tr>
					<td width="100">选择处理状态：</td>
					<td><select name="sel" id="processid"
						onchange="chi(this.value)" style="width: 150px">
							<option value="nextLater">提交下一处理环节</option>
							<option value="transfer">委托他人处理</option>
					</select></td>
				</tr>
			</table>
			<table>
				<tr id="zhiding" style="display: none;">
					<td width="100">指定处理人：</td>
					<td id="selOpe"></td>
				</tr>
				<tr>
					<td id="sub" style="display: block;"><input type="submit"
						name="result" value="提交" style="width: 50px; height: 22px" /></td>
					<td id="but" style="display: none;"><input type="button"
						name="result" onclick="tijiao()" value="提交"
						style="width: 50px; height: 22px" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/lawForm.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/loss.js"></script>
</body>
</html>