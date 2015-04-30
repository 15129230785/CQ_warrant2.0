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
<title>资料审查</title>
</head>

<body>
	<form action="Reviewdata" method="post" class="idform" id="Reviewdata">
		<div id="body">
			<a class="header" href="#" onclick="javascript:showProjectInfo('m05', 'projectInfo');">项目信息</a>
			<div class="L1" id="projectInfo"></div>
		</div>
		<br />
		<fieldset>
			<legend>资料完整性检查</legend>
			<div class="L1" id="docList"></div>
		</fieldset>
		<br />
		<fieldset id="ziliao">
			<legend>资料审查</legend>
			<ul id="m03d" class="U1">
				<li>
					<table id="b" width="100%" style="color: #797268;">
						<tr style="display: none;">
							<td>担保项目编码：</td>
							<td><input type="text" name="wid"
								id="wid" value="<%=wid%>" />
							</td>
						</tr>
						<tr style="display: none;">
							<td>检查人姓名：</td>
							<td><input type="text" name="name" value="<%=username%>" /></td>
						</tr>
						<tr>
							<td width="100">检查起始时间：</td>
							<td><input type="text" name="startDate"
								onfocus="WdatePicker()" id="1" /></td>
						</tr>
						<tr style="display: none;">
							<td>检查结束时间：</td>
							<td><input type="text" name="endDate" /></td>
						</tr>
						<tr>
							<td colspan="2">账户信息：</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="account" datatype="*"
								nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
								placeholder="必须填写" id="2"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">销售收入：</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="revenue" datatype="*"
								nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
								placeholder="必须填写" id="3"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">资产保险</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="assets" datatype="*"
								nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
								placeholder="必须填写" id="4"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">抵押：</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="dateMortgage" datatype="*"
								nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
								placeholder="必须填写" id="5"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">机器设备所有权：</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="ownerShip" datatype="*"
								nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
								placeholder="必须填写" id="6"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">对外负债：</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="debt" datatype="*"
								nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
								placeholder="必须填写" id="7"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">对外担保：</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="warrant" datatype="*"
								nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
								placeholder="必须填写" id="8"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">对外承兑汇票：</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="acceptance" datatype="*"
								nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
								placeholder="必须填写" id="9"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">对外信用证：</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="credit" datatype="*"
								nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
								placeholder="必须填写" id="10"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">企业资产真实价值：</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="assetValue" datatype="*"
								nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
								placeholder="必须填写" id="11"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">财务预测信息：</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="forecasting" datatype="*"
								nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
								placeholder="必须填写" id="12"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">同业调查结果：</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="peerSurvey" datatype="*"
								nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
								placeholder="必须填写" id="13"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">总体情况说明：</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="explains" datatype="*"
								nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
								placeholder="必须填写" id="14"></textarea></td>
						</tr>
					</table>
				</li>
			</ul>
			<%-- <li style="display: none;" class="L1"><a href="javascript:showProblemList('<%=wid%>', 'm07', 'TblProblemtrackdiv');" id="m07">评审问题记录</a>
				<a onclick="addProblem('<%=wid%>', '<%=taskname%>')" style="color: #A5A5A5;">添加评审问题</a></li>
			<li>
				<ul id="m07d" class="U1" style="display: none;">
					<li>
						<div id="TblProblemtrackdiv"></div>
					</li>
				</ul>
			</li> --%>
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
			<table>
				<tr style="display: none;">
					<td><input type="text" name="taskid" value="<%=taskId%>" /></td>
					<td><input type="text" name="taskname" value="<%=taskname%>" /></td>
					<td><input type="text" id="num" value="review-data" /></td>
					<td><input type="text" name="serviceType" id="serviceType" /></td>
					<td><input type="text" id="username" value="<%=username%>" /></td>
				</tr>
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
			<table>
				<tr id="refund" style="display: none;">
					<td width="90">需退金额：</td>
					<td><input name="refundMoney" id="refundMoney"
					onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr id="tr" style="display: none;">
					<td width="90">终止原因：</td>
					<td><textarea name="over" cols="40" rows="3" id="textfield6"
							style="font-size: 20px;"></textarea></td>
				</tr>
			</table>
			<table>
				<tr id="sel">
					<td width="90">指定处理人：</td>
					<td id="selOpe"></td>
				</tr>
				<tr>
					<td id="sum"><input name="result" type="submit" value="提交"
						style="width: 50px; height: 22px" /></td>
					<td id="but" style="display: none;"><input name="result"
						type="button" value="提交" onclick="tijiao()"
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
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/rootPath.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/decimal.js"></script>
<script type="text/javascript" src="<%=basePath%>js/lawForm.js"></script>
<script type="text/javascript" src="<%=basePath%>js/chargeInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/projectDocList.js"></script>
<script type="text/javascript" src="<%=basePath%>js/problemInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/review-data.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>