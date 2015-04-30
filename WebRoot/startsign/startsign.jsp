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
<title>评委会签</title>
<style>
	#ollist .ui-selecting { background: #FECA40; }
	#ollist .ui-selected { background: #F39814; color: white; }
	#ollist { list-style-type: none; margin: 0; padding: 0; width: 450px; }
	#ollist li { margin: 3px; padding: 1px; float: left; width: 100px; height: 20px; font-size: 12px; text-align: center; }
</style>
</head>

<body>
	<div id="body">
		<a id="fyj" class="header" href="#" onclick="javascript:showLAI('m011', 'lawAuditInfo');">法务审查意见</a>
		<div class="L1" id="lawAuditInfo"></div>
		<a id="cyj" class="header" href="#" onclick="javascript:showFEI('m015', 'financeEstInfo');">财务审查意见</a>
		<div class="L1"id="financeEstInfo"></div>
		<a class="header" href="#" onclick="javascript:showREI('m017', 'riskEstInfo');">风险审查意见</a>
		<div class="L1" id="riskEstInfo"></div>
	</div>
	<br />
	<form action="StartSign" id="f" method="post" class="idform">
		<fieldset>
			<legend>风控部经理审核意见</legend>
			<table width="100%">
				<tr>
					<td>
						<textarea name="check" id="info"
							datatype="*" nullmsg="请填写审核意见" errormsg="填写信息不合法" sucmsg=" "
							placeholder="必须填写"></textarea>
					</td>
				</tr>
			</table>
		</fieldset>
		<br />
		<fieldset>
			<legend>指定评审人</legend>
			<input type="hidden" name="checkbox" id="checkbox" />
			<div id="reviewerList"></div>
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
			<table>
				<tr style="display: none;">
					<td><input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
					<td><input type="text" name="taskid" value="<%=taskId%>" /></td>
					<td><input type="text" id="num" value="startsign" /></td>
					<td><input type="text" name="serviceType" id="serviceType" /></td>
					<td><input type="text" id="username" value="<%=username%>" /></td>
				</tr>
				<tr>
					<td style="width:90px">处理方式：</td>
					<td><select name="sel" style="width: 150px" id="processid" onchange="zd(this.value)">
						<option value="nextLater">下一处理环节</option>
						<option value="transfer">委托他人处理</option>
					</select></td>
				</tr>
			</table>
			<table style="margin-left: 0px;">
				<tr id="zd" style="display: none;">
					<td style="width:90px">指定处理人：</td>
					<td id="selOpe"></td>
				</tr>
				<tr>
					<td><input type="button" value="提交" onclick="tijiao()"
						style="width: 50px; height: 22px" /></td>
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
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/lawForm.js"></script>	
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/signInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/lawAuditInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/financeEstInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/riskEstInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/startsign.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>