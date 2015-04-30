<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
	
	String taskId = request.getParameter("id");
	String username = (String) session.getAttribute("user");
	String wid = request.getParameter("wid");
	Date da = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String time = sdf.format(da);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/service.css" />
<title>担保解除</title>
</head>

<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showMyProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
	</div>
	<br />
	<form action="Clear" method="post" id="clear" class="Clearform">
		<fieldset>
			<legend>还款信息</legend>
			<table>
				<tr style="display: none;">
					<td><input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
					<td><input type="text" name="warMon" id="warMon" /></td>
					<td><input type="text" name="serviceType" id="serviceType" /></td>
				</tr>
				<tr>
					<td>还款金额(万):&nbsp;</td>
					<td><input class="comp_input" name="Money" id="Money"
						style="width: 200px;" type="text"
						onkeyup="inputDecimal(this)" value="0" /></td>
				</tr>
				<tr>
					<td>担保解除日期:&nbsp;</td>
					<td><input id="d11" type="text" class="Wdate"
						onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
						name="WarrantReleaseDate" value="<%=time%>" style="width: 200px" />
					</td>
				</tr>
				<tr>
					<td>抵押物是否已经退回:&nbsp;</td>
					<td><input type="checkbox" name="rad" id="rad" />
					</td>
				</tr>
				<tr>
					<td>是否需要代偿:&nbsp;</td>
					<td>是<input type="radio" name="radio" value="0" />&nbsp;&nbsp;
						否<input type="radio" name="radio" value="1" />
					</td>
				</tr>
			</table>
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
			<table>
				<tr style="display: none;">
					<td><input type="text" name="taskid" value="<%=taskId%>" /></td>
					<td><input type="text" id="num" value="clear" /></td>
					<td><input type="text" id="username" value="<%=username%>" /></td>
				</tr>
				<tr>
					<td width="90">处理方式：</td>
					<td><select name="sel" id="processid" style="width: 150px">
						<option value="nextLater">下一处理环节</option>
						<option value="transfer">委托他人处理</option>
						<option value="compensatory">代偿</option>
					</select></td>
				</tr>
				<tr>
					<td>指定处理人：</td>
					<td id="selOpe"></td>
				</tr>
				<tr>
					<td><input name="result" type="button" value="提交"
						onclick="tijiao()" style="width: 50px; height: 22px" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<div id='alertDiv' title='信息'>
		<p id='alertTxt'></p>
	</div>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>	
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/decimal.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/clear.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>