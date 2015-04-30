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
<title>合同签订</title>
</head>

<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
	</div>
	<br />
	<fieldset>
		<legend>担保合同</legend>
		<table width="97%" id="r">
			<tr>
				<th width="9%" align="center">编号</th>
				<th width="70%" align="center">名称</th>
				<th width="21%" align="center">是否签订</th>
			</tr>
		</table>
		<div class="L1" id="signHDdiv"></div>
	</fieldset>
	<div style="display:none" class="download">
		<a href="../download/down.jsp?name=qy&end=.zip">合同模版下载</a>
	</div>
	<br />
	<form action="Sign" id="signform" method="post">
		<fieldset>
			<legend>项目提交</legend>
			<table>
				<tr style="display: none;">
					<td><input type="text" name="taskid" value="<%=taskId%>" /></td>
					<td><input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
					<td><input type="text" id="num" value="sign" /></td>
					<td><input type="text" name="serviceType" id="serviceType" /></td>
					<td><input type="text" id="username" value="<%=username%>" /></td>
				</tr>
				<tr>
					<td width="100">担保开始日期:</td>
					<td><input id="c1" name="StartDate" class="Wdate" type="text"
						onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'c2\')||\'2100-10-01\'}'})"
						datatype="a2" errormsg="请填写信息！" placeholder="必须填写" sucmsg=" " /></td>
				</tr>
				<tr>
					<td>担保结束日期:</td>
					<td><input id="c2" name="EndDate" class="Wdate" type="text"
						onFocus="WdatePicker({minDate:'#F{$dp.$D(\'c1\')}'})"
						datatype="a2" errormsg="请填写信息！" placeholder="必须填写" sucmsg=" " /></td>
				</tr>
				<tr>
					<td>通知还款日期:</td>
					<td><input id="d11" type="text" class="Wdate"
						onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'c2\')}',minDate:'#F{$dp.$D(\'c1\')}'})"
						name="NoticeDate" id="NoticeDate" /></td>
				</tr>
				<tr>
					<td>处理方式：</td>
					<td><select name="sel" id="processid" style="width: 150px">
						<option value="nextLater">下一处理环节</option>
						<option value="transfer">委托他人处理</option>
					</select></td>
				</tr>
				<tr>
					<td>指定处理人：</td>
					<td id="selOpe"></td>
				</tr>
				<tr>
					<td><input type="button" name="result" onclick="tijiao()"
						value="提交" style="width: 50px; height: 22px" /></td>
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
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/contract.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/sign.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>