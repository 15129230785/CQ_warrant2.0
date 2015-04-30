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
<title>代偿</title>
</head>

<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showMyProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
	</div>
	<br />
	<fieldset>
		<legend>还款信息</legend>
		<div id="payInfo"></div>
	</fieldset>
	<br />
	<form action="Compensatory" id="Compensatory" method="post">
		<fieldset>
			<legend>代偿金额</legend>
			<table width="90%" height="50px">
				<tr>
					<td>本金(元):</td>
					<td><input type="text" name="benjin" id="benjin" value="" /></td>
					<td>利息(元):</td>
					<td><input type="text" name="lixi" id="lixi"
						onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td>罚息(元):</td>
					<td><input type="text" name="faxi" id="faxi"
						onkeyup="inputDecimal(this)" /></td>
					<td>违约金(元):</td>
					<td><input type="text" name="shouxu" id="shouxu"
						onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td>执行费用(元):</td>
					<td><input type="text" name="zhixing" id="zhixing"
						onkeyup="inputDecimal(this)" /></td>
					<td>其它费用(元):</td>
					<td><input type="text" name="qita" id="qita"
						onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td colspan="4">是否需要追偿：
						是<input type="radio" name="radio" value="0" />&nbsp;&nbsp;
						否<input type="radio" name="radio" value="1" />
					</td>
				</tr>
			</table>
			（执行费用包括：诉讼费、律师费、差旅费、房产抵押人安置费、保全费等）
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
			<table>
				<tr style="display: none;">
					<td><input type="text" name="taskid" value="<%=taskId%>" /></td>
					<td><input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
					<td><input type="text" id="num" value="compensatory" /></td>
					<td><input type="text" name="serviceType" id="serviceType" /></td>
					<td><input type="text" id="username" value="<%=username%>" /></td>
				</tr>
				<tr>
					<td width="160">银行债权是否已经转让：</td>
					<td><input type="checkbox" id="check" /></td>
				</tr>
				</table>
			<table>
				<tr>
					<td width="100">处理方式：</td>
					<td><select name="sel" id="processid"
						onchange="chi(this.value)" style="width: 150px">
						<option value="nextLater">下一处理环节</option>
						<option value="transfer">委托他人处理</option>
						<option value="persue">追偿</option>
					</select></td>
				</tr>
			</table>
			<table width="100%">
				<tr id="start" style="display: none;">
					<td width="98">追偿开始时间:</td>
					<td><input type="text" name="startDate" id="startDate"
						onFocus="WdatePicker()" value="${currentTime}"/></td>
				</tr>
				<tr id="fangshi" style="display: none;">
					<td width="100" style="text-align:center; vertical-align:top;">追偿方式:</td>
					<td>
						<input type="checkbox" name="mode" value="0" /><span>与被担保人重新制定还款计划</span><br />
						<textarea name="describe0" id="describe0" style="display: none;"></textarea>(<i>如：计划内容</i>)<br />
						<input type="checkbox" name="mode" value="1" /><span>追索反担保保证人</span><br />
						<textarea name="describe1" id="describe1" style="display: none;"></textarea>(<i>如：计划内容</i>)<br />
						<input type="checkbox" name="mode" value="2" /><span>行使抵押权</span><br />
						<textarea name="describe2" id="describe2" style="display: none;"></textarea>(<i>如：计划内容</i>)<br />
						<input type="checkbox" name="mode" value="3" /><span>行使质押权</span><br />
						<textarea name="describe3" id="describe3" style="display: none;"></textarea>(<i>如：计划内容</i>)<br />
						<input type="checkbox" name="mode" value="4" /><span>起诉</span><br />
						<textarea name="describe4" id="describe4" style="display: none;"></textarea>(<i>如：计划内容</i>)
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td width="100">指定处理人：</td>
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
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/decimal.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/compensatory.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>