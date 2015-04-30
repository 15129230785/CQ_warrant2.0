<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
	
	String taskId = request.getParameter("id");
	String wid = request.getParameter("wid");
	if (wid != null) {
		wid = wid.substring(wid.lastIndexOf("w"));
	}
	String username = (String)session.getAttribute("user");
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
<title>项目决策</title>
</head>
<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showMyProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
		<a class="header" href="#" onclick="javascript:showDocList('m01', 'docList');">资料完整性</a>
		<div class="L1" id="docList"></div>
		<a id="zsc" class="header" href="#" onclick="javascript:showRDI('m03', 'reviewDataInfo');">资料审查</a>
		<div class="L1" id="reviewDataInfo"></div>
		<a class="header" href="#" onclick="javascript:showFSI('m07', 'fieldSurveyInfo');">现场调查结果</a>
		<div class="L1" id="fieldSurveyInfo"></div>
		<%-- <li style="display: none;" class="L1"><a href="javascript:showProblemList('<%=wid%>', 'm09', 'TblProblemtrackdiv');" id="m09">问题列表</a>
			<a onclick="addProblem('<%=wid%>', '<%=taskname%>')" style="color: #A5A5A5;">添加评审问题</a></li>
		<li>
			<ul id="m09d" style="display: none;" class="U1">
				<li>
					<div id="TblProblemtrackdiv"></div>
				</li>
			</ul>
		</li> --%>
		<a class="header" href="#" onclick="javascript:showMAI('m013', 'manAuditInfo');">业务经理审核意见</a>
		<div class="L1" id="manAuditInfo"></div>
		<a id="fyj" class="header" href="#" onclick="javascript:showLAI('m011', 'lawAuditInfo');">法务审查意见</a>
		<div class="L1" id="lawAuditInfo"></div>
		<a id="cyj" class="header" href="#" onclick="javascript:showFEI('m015', 'financeEstInfo');">财务审查意见</a>
		<div class="L1" id="financeEstInfo"></div>
		<a class="header" href="#" onclick="javascript:showREI('m017', 'riskEstInfo');">风险审查意见</a>
		<div class="L1" id="riskEstInfo"></div>
		<a class="header" href="#" onclick="javascript:showRRI('m019', 'riskReviewInfo');">风控经理审核意见</a>
		<div class="L1" id="riskReviewInfo"></div>
		<a class="header" href="#" onclick="javascript:showCounterSignInfo('m021', 'TblCountersigndiv');">评委会签意见</a>
		<div>
			<ul>
				<li><a class="addbutton" style="display:inline;color:#A5A5A5;" onclick="addCountersign('<%=wid%>')">添加评委会签意见</a></li>
				<li><div class="L1" id="TblCountersigndiv"></div></li>
			</ul>
		</div>
	</div>
	<br />
	<fieldset id="fieldset" class="L1">
		<legend>企业用户资信评分</legend>
		<div id="decisionSignDiv"></div>
	</fieldset>
	<fieldset id="fieldset1" class="L1">
		<legend>个人用户资信评分</legend>
		<div id="pepdecisionSignDiv"></div>
	</fieldset>
	<br />
	<form action="Decision" id="f" method="post" class="idform">
		<table>
			<tr style="display: none;">
				<td><input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
				<td><input type="text" name="taskid" value="<%=taskId%>" /></td>
				<td><input type="text" id="num" value="decision" /></td>
				<td><input type="text" name="serviceType" id="serviceType" /></td>
				<td><input type="text" id="username" value="<%=username%>" /></td>
				<td><input type="text" id="number"></td>
			</tr>
		</table>
		<fieldset>
			<legend>项目决策</legend>
			<table width="100%" border="0">
				<tr>
					<td width="130">决策结果：</td>
					<td><select name="decisionList" id="decisionList"
						onchange="cha(this.value)">
							<option value="0">同意</option>
							<option value="1">不同意，项目终止，不退费</option>
							<option value="2">不同意，项目终止，退评审费</option>
							<option value="3">重新收集信息</option>
						</select></td>
				</tr>
			</table>
			<table width="100%" border="0">
				<tr id="shiji">
					<td width="130">实际担保金额(万)：</td>
					<td><input type="text" name="money" id="money" 
						onchange="jisuanshiji()" onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr id="zd">
					<td width="130">情况说明：</td>
					<!-- <td colspan="2">情况说明：</td>
				</tr>
				<tr id="zd1"> -->
					<td><textarea name="explain" id="explain"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写"></textarea></td>
				</tr>
			</table>
			<div id="selDivN" style="display: none;">
				<table width="100%">
					<tr>
						<td width="130">需退金额(元)：</td>
						<td><input type="text" id="xt" name="refundMoney" value=""
							onkeyup="inputDecimal(this)" /></td>
					</tr>
				</table>
			</div>

			<div id="selDivM" style="display: none;">
				<table width="100%">
					<tr>
						<td width="130">终止原因：</td>
						<!-- <td colspan="2">终止原因：</td>
					</tr>
					<tr> -->
						<td><textarea name="cause" id="textfield6"
							style="font-size: 20px;"></textarea></td>
					</tr>
				</table>
			</div>
		</fieldset>
		<br>
		<fieldset id="field">
			<legend>项目收费：</legend>
			<table width="100%" border="0">
				<tr>
					<td width="100">保证金费率(%):</td>
					<td><input name="rate" id="Rate" type="text" size="10"
						onkeyup="inputDecimal(this)" onblur="jisuan()" /></td>
					<td width="100">代办费费率(%):</td>
					<td><input name="rate1" id="Rate1" type="text" size="10"
						onkeyup="inputDecimal(this)" onblur="jisuan1()" /></td>
				</tr>
				<tr>
					<td width="50">保证金(元):</td>
					<td><input name="deposit" id="deposit" type="text" size="10"
						onkeyup="inputDecimal(this)" /></td>
					<td width="50">代办费(元):</td>
					<td><input name="commission" id="commission" type="text"
						size="10" onkeyup="inputDecimal(this)" /></td>	
				</tr>
				<tr>
					<td width="100">担保费费率(%):</td>
					<td><input name="rate2" id="Rate2" type="text" size="10"
						onkeyup="inputDecimal(this)" onblur="jisuan2()" /></td>
					<td width="100">评估费费率(%):</td>
					<td><input name="rate3" id="Rate3" type="text" size="10"
						onkeyup="inputDecimal(this)" onblur="jisuan3()" /></td>	
				</tr>
				<tr>		
					<td width="50">担保费(元):</td>
					<td><input name="assure" id="assure" type="text" size="10"
						onkeyup="inputDecimal(this)" /></td>
					<td width="50">评估费(元):</td>
					<td><input name="evaluate" id="evaluate" type="text" size="10"
						onkeyup="inputDecimal(this)" /></td>	
				</tr>
			</table>
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
			<div id="selDivY">
				<table width="97%">
					<tr>
						<td style="display: none;"></td>
						<td style="display: none;"></td>
					</tr>
					<tr>
						<td width="90">处理方式：</td>
						<td><select name="sel" id="processid" style="width: 150px">
							<option value="nextLater">下一处理环节</option>
							<option value="transfer">委托他人处理</option>
						</select></td>
					</tr>
				</table>
				<table width="97%">
					<tr id="sel">
						<td width="90">指定处理人：</td>
						<td id="selOpe"></td>
					</tr>
				</table>
			</div>
			<input type="button" value="提交" onclick="tijiao()"
				style="width: 50px; height: 22px" />
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
<script type="text/javascript" src="<%=basePath%>js/transfer.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/decimal.js"></script>
<script type="text/javascript" src="<%=basePath%>js/lawForm.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/projectDocList.js"></script>
<script type="text/javascript" src="<%=basePath%>js/chargeInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/signInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/reviewDataInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/fieldSurveyInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/manAuditInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/lawAuditInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/financeEstInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/riskEstInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/decision.js"></script>
<script type="text/javascript" src="<%=basePath%>js/problemInfo.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>
