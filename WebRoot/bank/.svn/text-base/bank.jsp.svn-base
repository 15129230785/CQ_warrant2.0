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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/service.css" />
<title>银行审批</title>
</head>

<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
	</div>
	<br />
	<fieldset>
		<legend>银行所需的资料清单</legend>
		<div id="docList" class="L1"></div>
	</fieldset>
	<br />
	<fieldset>
		<legend>需报送给银行审批的文件</legend>
		<table width="97%" border="0" cellspacing="5">
			<tr>
				<td>同意担保意向书</td>
			</tr>
		</table>
	</fieldset>
	<br />
	<div style="display:none" class="download">
		<a href="<%=basePath%>download/down.jsp?name=dbyx&end=.doc">同意担保意向书模版下载</a>
	</div>
	<form action="Bank" id="f" method="post">
		<fieldset>
			<legend>项目提交</legend>
			<table>
				<tr>
					<td>上述文件是否已经报送给银行<input type="checkbox" id="check" name="check"></td>
				</tr>
				<tr style="display: none;">
					<td><input type="text" name="taskid" value="<%=taskId%>" /></td>
					<td><input type="text" id="num" value="bank" /></td>
					<td><input type="text" id="username" value="<%=username%>" /></td>
					<td><input type="text" name="serviceType" id="serviceType" /></td>
					<td><input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
				</tr>
			</table>
			<table width="100%">
				<tr>
					<td width="90">处理方式：</td>
					<td><select name="sel" id="processid"
						onchange="chi(this.value)" style="width: 150px">
							<option value="nextLater">下一处理环节</option>
							<option value="transfer">委托他人处理</option>
							<option value="refund">退评审费</option>
							<option value="stop">终止</option>
					</select></td>
				</tr>
			</table>
			<div id="xtje" style="display:none"></div>
			<table id="zzyy" width="100%" style="display: none;">
				<tr>
					<td width="90">终止原因:</td>
					<td><textarea name="over" cols="40" rows="3"
						id="textfield6" style="font-size: 20px;"></textarea></td>
				</tr>
			</table>
			<table>
				<tr id="sel">
					<td width="90">指定处理人：</td>
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
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/transfer.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/projectDocList.js"></script>
<script type="text/javascript" src="<%=basePath%>js/chargeInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/bank.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>