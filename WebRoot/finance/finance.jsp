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
<title>财务评估</title>
</head>

<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
	</div>
	<br />
	<form action="Finance" method="post" class="finance" id="finance">
		<fieldset id="fiel">
			<legend>财务审查</legend>
			<table style="margin-left: 10px; display: block;">
				<tr>
					<td class="edit_comp_l">数据起止时间：</td>
					<td><input type="text" name="startDate" id="f1"
						onFocus="WdatePicker({dateFmt:'yyyyMM'})" style="width:60px;"  datatype="a"
						nullmsg="请填写开始时间" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" /> -
						<input type="text" name="startDate" id="f2"
						onFocus="WdatePicker({dateFmt:'yyyyMM'})" style="width:60px;"  datatype="a"
						nullmsg="请填写终止时间" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">总负债：</td>
					<td><input type="text" name="debts" datatype="a"
						nullmsg="请填写总负债" errormsg="请填写最多两位小数的数字" sucmsg=" " placeholder="必须填写"
						onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">总资产：</td>
					<td><input type="text" name="asset" datatype="a"
						nullmsg="请填写总资产" errormsg="请填写最多两位小数的数字" sucmsg=" " placeholder="必须填写"
						onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">净资产：</td>
					<td><input type="text" name="betAsset" datatype="a"
						nullmsg="请填写净资产" errormsg="请填写最多两位小数的数字" sucmsg=" " placeholder="必须填写"
						onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">年末贷款余额：</td>
					<td><input type="text" name="loanRemaining" datatype="a"
						nullmsg="请填写年末贷款余额" errormsg="请填写最多两位小数的数字" sucmsg=" "
						placeholder="必须填写" onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">流动资产：</td>
					<td><input type="text" name="flowAsset" datatype="a"
						nullmsg="请填写流动资产" errormsg="请填写最多两位小数的数字" sucmsg=" "
						placeholder="必须填写" onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">流动负债：</td>
					<td><input type="text" name="flowDebt" datatype="a"
						nullmsg="请填写流动负债" errormsg="请填写最多两位小数的数字" sucmsg=" "
						placeholder="必须填写" onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">销售现金流：</td>
					<td><input type="text" name="saleCash" datatype="a"
						nullmsg="请填写销售现金流" errormsg="请填写最多两位小数的数字" sucmsg=" "
						placeholder="必须填写" onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">当年到期债务本息和：</td>
					<td><input type="text" name="dueDebt" datatype="a"
						nullmsg="请填写当年到期债务本息和" errormsg="请填写最多两位小数的数字" sucmsg=" "
						placeholder="必须填写" onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr style="display: none;">
					<td class="edit_comp_l">销售额：</td>
					<td><input type="text" name="saleMoney"
						onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">平均资产总额：</td>
					<td><input type="text" name="meanAsset" datatype="a"
						nullmsg="请填写平均资产总额" errormsg="请填写最多两位小数的数字" sucmsg=" "
						placeholder="必须填写" onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">净利润：</td>
					<td><input type="text" name="netProfit" datatype="a"
						nullmsg="请填写净利润" errormsg="请填写最多两位小数的数字" sucmsg=" " placeholder="必须填写"
						onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">本年销售额：</td>
					<td><input type="text" name="thisYearSale" datatype="a"
						nullmsg="请填写本年销售额" errormsg="请填写最多两位小数的数字" sucmsg=" "
						placeholder="必须填写" onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">上年销售额：</td>
					<td><input type="text" name="lastYearSale" datatype="a"
						nullmsg="请填写上年销售额" errormsg="请填写最多两位小数的数字" sucmsg=" "
						placeholder="必须填写" onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">到期借款人测算现金流：</td>
					<td><input type="text" name="dueCash" datatype="a"
						nullmsg="请填写到期借款人测算现金流" errormsg="请填写最多两位小数的数字" sucmsg=" "
						placeholder="必须填写" onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr>
					<td class="edit_comp_l">借款资金：</td>
					<td><input type="text" name="loan" datatype="a"
						nullmsg="请填写借款资金" errormsg="请填写最多两位小数的数字" sucmsg=" "
						placeholder="必须填写" onkeyup="inputDecimal(this)" /></td>
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
					<td><input type="text" id="num" value="finance" /></td>
					<td><input type="text" name="serviceType" id="serviceType" /></td>
					<td><input type="text" id="username" value="<%=username%>" /></td>
				</tr>
				<tr>
					<td>处理方式：</td>
					<td><select name="sel" id="processid" onchange="chang()"
						style="width: 150px">
							<option value="nextLater">下一处理环节</option>
							<option value="transfer">委托他人处理</option>
					</select></td>
				</tr>
				<tr>
					<td>指定处理人：</td>
					<td id="selOpe"></td>
				</tr>
				<tr>
					<td id="tdsum" style="display: block;"><input type="submit"
						name="result" value="提交" style="width: 50px; height: 22px" /></td>
					<td id="tdbut" style="display: none;"><input type="button"
						onclick="tijiao()" name="result" value="提交"
						style="width: 50px; height: 22px;" /></td>
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
<script type="text/javascript" src="<%=basePath%>js/financeForm.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/finance.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>