<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	String taskId = request.getParameter("id");
	String wid = request.getParameter("wid");
	String username = (String) session.getAttribute("user");
	String taskname = null;
	String temp = request.getParameter("task");
	if (temp != null) {
		taskname = new String(temp.getBytes("ISO-8859-1"), "UTF-8");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/service.css" />
<title>业务经理审核</title>
</head>

<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showMyProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
		<a class="header" href="#" onclick="javascript:showDocList('m01', 'docList');">资料完整性</a>
		<div class="L1" id="docList"></div>
		<a id="zc" class="header" href="#" onclick="javascript:showRDI('m03', 'reviewDataInfo');">资料审查</a>
		<div class="L1" id="reviewDataInfo"></div>
		<a class="header" href="#" onclick="javascript:showFSI('m07', 'fieldSurveyInfo');">现场调查结果</a>
		<div class="L1" id="fieldSurveyInfo"></div>
		<%-- <li style="display: none;" class="L1"><a href="javascript:showProblemList('<%=wid%>', 'm07', 'TblProblemtrackdiv');" id="m07">问题记录</a>
			<a onclick="addProblem('<%=wid%>', '<%=taskname%>')" style="color: #A5A5A5;">添加评审问题</a></li>
		<li>
			<ul id="m07d" style="display: none;">
				<li>
					<div id="TblProblemtrackdiv"></div>
				</li>
			</ul>
		</li> --%>
	</div>
	<br />
	<form action="Consideration" method="post" class="idform" id="Consideration">
		<input style="display: none;" type="text" name="serviceType" id="serviceType" />
		<fieldset>
			<legend>业务经理审核意见</legend>
				<table width="100%"><tr><td>
					<textarea name="value" datatype="*"
						nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" " placeholder="必须填写"></textarea>
				</td></tr></table>
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
			<table>
				<tr>
					<td style="display: none;"><input type="text" name="wid"
						id="wid" value="<%=wid%>" /></td>
					<td style="display: none;"><input type="text" id="num"
						value="consideration" /></td>
					<td style="display: none;"><input type="text" name="taskid"
						value="<%=taskId%>" /></td>
					<td style="display: none;"><input type="text" name="taskname"
						value="<%=taskname%>" /></td>
					<td style="display: none;"><input type="text" id="username"
						value="<%=username%>" /></td>
					<td width="110px">处理方式：</td>
					<td><select name="sel" id="processid" style="width: 150px"
						onchange="op(this.value)">
							<option value="nextLater">下一处理环节</option>
							<option value="transfer">委托他人处理</option>
							<option value="anew">重新审核</option>
							<option value="refund">退评审费</option>
							<option value="stop">终止</option>
					</select></td>
				</tr>
			</table>

			<table id="next">
				<tr>
					<td width="110px" id="cwpgclr">财务评估处理人:</td>
					<td id="tdfinance"></td>
				</tr>
				<tr id="fln">
					<td width="110px">法务审查处理人:</td>
					<td id="tdlaw" nullmsg="请选择法务审查处理人" sucmsg=" " placeholder="必须选择"></td>
				</tr>
				<tr>
					<td width="110px">指定发起会签人:</td>
					<td id="tdemcee"></td>
				</tr>
				<tr>
					<td width="110px">指定决策人:</td>
					<td id="tdnext"></td>
				</tr>
			</table>
			<table id="anew" style="display: none;">
				<tr>
					<td width="110px">指定处理人:</td>
					<td id="tdanew"></td>
				</tr>
			</table>
			<table id="refund" style="display: none;">
				<tr>
					<td width="110px">指定处理人:</td>
					<td id="tdrefund"></td>
				</tr>
				<tr>
					<td width="110px">退费金额:</td>
					<td><input type="text" name="refundMoney" id="money" 
					onkeyup="inputDecimal(this)"/></td>
				</tr>
			</table>

			<table width="100%" id="over" style="display: none;">
				<tr>
					<td width="110px">终止原因:</td>
					<td><textarea name="over" cols="30" rows="3"></textarea></td>
				</tr>
			</table>

			<input type="submit" name="result" id="sub" value="提交"
				style="width: 50px; height: 22px;" />
			<input type="button" name="result" id="but" value="提交" onclick="tijiao()"
				style="width: 50px; height: 22px; display: none;" />
		</fieldset>
	</form>
	<div id='alertDiv' title='信息'>
		<p id='alertTxt'></p>
	</div>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/rootPath.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/fieldSurveyInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/decimal.js"></script>
<script type="text/javascript" src="<%=basePath%>js/lawForm.js"></script>
<script type="text/javascript" src="<%=basePath%>js/chargeInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/projectDocList.js"></script>
<script type="text/javascript" src="<%=basePath%>js/reviewDataInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/problemInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/consideration.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/alert.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>