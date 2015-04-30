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
<title>风险评审</title>
</head>

<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
	</div>
	<br />
	<form action="Risk" method="post" id="risk" class="idform">
		<fieldset>
			<legend>风险评估</legend>
			<table id="fenx" width="97%">
				<tr id="gl1">
					<td colspan="2">管理层经验：</td>
				</tr>
				<tr id=gl2>
					<td colspan="2"><textarea name="managerial"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 "
						sucmsg=" " placeholder="必须填写" id="managerial"></textarea></td>
				</tr>
				<tr id="cy1"  height="25px">
					<td width="70">从业经验：</td>
					<td>
						<input type="radio" name="experience" id="experience" value="1" checked="checked" />极差
						<input type="radio" name="experience" id="experience" value="2" />较差
						<input type="radio" name="experience" id="experience" value="3" />一般
						<input type="radio" name="experience" id="experience" value="4" />良好
						<input type="radio" name="experience" id="experience" value="5" />优秀
					</td>
				</tr>
				<tr id="yj1">
					<td colspan="2">业绩：</td>
				</tr>
				<tr id="yj2">
					<td colspan="2"><textarea
						name="achievement" datatype="*" nullmsg="请填写相关信息"
						errormsg="填写信息不合法 " sucmsg=" " placeholder="必须填写" id="chievement"></textarea></td>
				</tr>
				<tr id="pp1">
					<td colspan="2">品牌：</td>
				</tr>
				<tr id="pp2">
					<td colspan="2"><textarea name="brand"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="bran"></textarea></td>
				</tr>
				<tr id="zy1">
					<td colspan="2">占有率：</td>
				</tr>
				<tr id="zy2">
					<td colspan="2"><textarea name="occupancy"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="ccupancy"></textarea></td>
				</tr>
				<tr id="xp1">
					<td colspan="2">新品研发储备：</td>
				</tr>
				<tr id="xp2">
					<td colspan="2"><textarea name="reserve"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="reserv"></textarea></td>
				</tr>
				<tr id="fz1" height="25px">
					<td>发展前景：</td>
					<td>
						<input type="radio" name="prospect" id="prospect" value="1" checked="checked" />极差
						<input type="radio" name="prospect" id="prospect" value="2" />较差
						<input type="radio" name="prospect" id="prospect" value="3" />一般
						<input type="radio" name="prospect" id="prospect" value="4" />良好
						<input type="radio" name="prospect" id="prospect" value="5" />优秀
					</td>
				</tr>
				<tr id="zr1">
					<td colspan="2">自然资源：</td>
				</tr>
				<tr id="zr2">
					<td colspan="2"><textarea name="nature"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="natur"></textarea></td>
				</tr>
				<tr id="kh1">
					<td colspan="2">客户资源：</td>
				</tr>
				<tr id="kh2">
					<td colspan="2"><textarea name="client"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="clien"></textarea></td>
				</tr>
				<tr id="ql1">
					<td colspan="2">权利资源：</td>
				</tr>
				<tr id="ql2">
					<td colspan="2"><textarea name="right"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="righ"></textarea></td>
				</tr>
				<tr id="zk1" height="25px">
					<td>资源控制：</td>
					<td>
						<input type="radio" name="resource" id="resource" value="1" checked="checked" />极差
						<input type="radio" name="resource" id="resource" value="2" />较差
						<input type="radio" name="resource" id="resource" value="3" />一般
						<input type="radio" name="resource" id="resource" value="4" />良好
						<input type="radio" name="resource" id="resource" value="5" />优秀
					</td>
				</tr>
				<tr id="zk2">
					<td colspan="2">专利专有技术：</td>
				</tr>
				<tr id="zlz1">
					<td colspan="2"><textarea name="patent"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="paten"></textarea></td>
				</tr>
				<tr id="yf1">
					<td colspan="2">研发能力：</td>
				</tr>
				<tr id="yf2">
					<td colspan="2"><textarea name="ability"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="bilit"></textarea></td>
				</tr>
				<tr id="js1"height="25px">
					<td>技术:</td>
					<td>
						<input type="radio" name="skill" id="skill" value="1" checked="checked" />极差
						<input type="radio" name="skill" id="skill" value="2" />较差
						<input type="radio" name="skill" id="skill" value="3" />一般
						<input type="radio" name="skill" id="skill" value="4" />良好
						<input type="radio" name="skill" id="skill" value="5" />优秀
					</td>
				</tr>
			</table>
			<table width="97%">
				<tr id="1">
					<td colspan="2" align="left">有无逾期贷款记录：</td>
				</tr>
				<tr id="2">
					<td colspan="2"><textarea name="due"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="due"></textarea></td>
				</tr>
				<tr id="3">
					<td colspan="2" align="left">有无对外担保：</td>
				</tr>
				<tr id="4">
					<td colspan="2"><textarea name="warrant"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="warrant"></textarea></td>
				</tr>
				<tr id="5">
					<td colspan="2" align="left">信用卡使用情况：</td>
				</tr>
				<tr id="6">
					<td colspan="2"><textarea name="credit"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="credit"></textarea></td>
				</tr>
				<tr id="7" height="25px">
					<td width="70">信用记录：</td>
					<td>
						<input type="radio" name="credits" id="credits" value="1" checked="checked" />极差
						<input type="radio" name="credits" id="credits" value="2" />较差
						<input type="radio" name="credits" id="credits" value="3" />一般
						<input type="radio" name="credits" id="credits" value="4" />良好
						<input type="radio" name="credits" id="credits" value="5" />优秀
					</td>
				</tr>
<!-- 开始 -->
				<tr id="age1">
					<td width="30%">年龄：</td>
					<td><input name="age" id="age" type="text" style="width:50%;"
						datatype="aa" sucmsg=" " nullmsg="请填写数字" errormsg="请填写数字"
						placeholder="必须填写" onkeyup="inputInteger(this)" /></td>
				</tr>
				<tr id="ducationLevel1">
					<td width="30%">最高学历：</td>
					<td><select name="ducationLevel" style="width:51%;"
						id="ducationLevel4">
							<option value=" ">请选择学历</option>
							<option value="0">高中</option>
							<option value="1">大专</option>
							<option value="2">本科</option>
							<option value="3">硕士以上</option>
							<option value="4">其它</option>
					</select></td>
				</tr>
				<tr id="martialStatus1">
					<td width="30%">婚姻状况：</td>
					<td><input type="radio" id="martialStatus"
						name="martialStatus" value="0"  checked="checked" />已婚 <input type="radio"
						name="martialStatus" id="martialStatus" value="1" />未婚
					</td>
				</tr>
				<tr id="liveTime1">
					<td width="30%">本地居住时间(年)：</td>
					<td><input name="liveTime" id="liveTime" style="width: 50%;" type="text"
						datatype="aa" sucmsg=" " nullmsg="居住时间请填写数字" errormsg="居住时间请填写数字"
						placeholder="必须填写" onkeyup="inputInteger(this)" /></td>
				</tr>
				<tr id="socialSecurity1">
					<td width="30%">是否参加社保：</td>
					<td><input type="radio"
						id="socialSecurity" name="socialSecurity" value="0"  checked="checked"/>是<input
						type="radio" name="socialSecurity" value="1" 
						id="socialSecurity" />否</td>
				</tr>
				<tr id="job1">
					<td width="30%">职业：</td>
					<td><select name="job" id="job" sucmsg=" " style="width:51%;"
						nullmsg="请选择社职业" datatype="s" errormsg="请选择社职业">
							<option value=" ">请选择社职业</option>
							<option value="0">企事业单位负责人</option>
							<option value="1">专业技术人员</option>
							<option value="2">基层服务人员</option>
							<option value="3">个体工商户及其他</option>
						</select></td>
				</tr>
				<tr id="familyIncome1">
					<td width="30%">家庭总收入(元)：</td>
					<td><input name="familyIncome" id="familyIncome" style="width: 50%;"
						type="text" datatype="a1" sucmsg=" " nullmsg="请填写家庭收入"
						errormsg="不能为负数且小数点后最多保留两位" placeholder="必须填写" 
						onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr id="numb1">
					<td width="30%">家庭人数：</td>
					<td><input name="numb"
						id="numb" style="width: 50%;" type="text" datatype="aa"
						sucmsg=" " nullmsg="家庭人数" errormsg="家庭人数为整数" placeholder="必须填写" 
						onkeyup="inputInteger(this)" /></td>
				</tr>
				<tr id="grossDebt1">
					<td width="30%">家庭总负债(元)：</td>
					<td><input name="grossDebt" id="grossDebt" style="width: 50%;" type="text"
						datatype="a1" sucmsg=" " nullmsg="请填家庭总负债" errormsg="不能为负数且小数点后最多保留两位"
						placeholder="必须填写" onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr id="totalAssets1">
					<td width="30%">家庭总资产(元)：</td>
					<td><input name="totalAssets" id="totalAssets" style="width: 50%;"
						type="text" datatype="aa" sucmsg=" " nullmsg="请填写家庭总资产"
						errormsg="不能为负数且小数点后最多保留两位" placeholder="必须填写" 
						onkeyup="inputDecimal(this)" /></td>
				</tr>
				<tr id="housSituation1">
					<td width="30%">住房情况：</td>
					<td><select name="housSituation" style="width:51%;"
						id="housSituation" sucmsg=" "
						datatype="s" nullmsg="请选择住房情况" errormsg="请选择住房情况">
							<option value=" ">请选择住房情况</option>
							<option value="0">无负债自有住房</option>
							<option value="1">按揭住房</option>
							<option value="2">租住房</option>
							<option value="3">其它</option>
						</select></td>
				</tr>
				<tr id="hnl">
					<td colspan="2">还款能力分析：<i>落实家庭的各种年收入总和必须大于贷款金额，具有足够的偿还能力</i></td>
				</tr>
				<tr id="htet">
					<td colspan="2"><textarea name="reimbursement" datatype="*"
							nullmsg="还款能力分析" errormsg="不允许填写特殊字符 " sucmsg=" "
							placeholder="必须填写" id="reimbursement"></textarea></td>
				</tr>
				<tr id="fxx">
					<td colspan="2">反担保措施风险分析：<i>反担保物产权归属关系是否明细、处置难易程度；第三方担保主体资格审查，反担保能力分析</i></td>
				</tr>
				<tr id="fxt">
					<td colspan="2"><textarea name="cguemeforianaly" datatype="*"
						nullmsg="请填写反担保措施风险分析" errormsg="不允许填写特殊字符 " sucmsg=" "
						placeholder="必须填写" id="cguemeforianaly"></textarea></td>
				</tr>
				<tr id="purpos4" height="25px">
					<td colspan="2">借款资金用途：<i>对贷款资金用途合理性、真实性进行评估，主要根据资金投向是否符合国家产业政策和信贷政策、资金需求缺口测算是否合理</i></td>
				</tr>
				<tr id="purpos3">
					<td colspan="2"><input type="radio" name="purpos" id="purpos"
						value="1" checked="checked" />极差&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio" name="purpos" id="purpos" value="2" />较差&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="purpos" id="purpos" value="3" />一般&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="purpos" id="purpos" value="4" />良好&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="purpos" id="purpos" value="5" />优秀&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
				<!-- 结束 -->
				<tr id ="purpose2" height="25px">
					<td colspan="2">借款资金用途：<i>对贷款资金用途合理性、真实性进行评估，主要根据资金投向是否符合国家产业政策和信贷政策、资金需求缺口测算是否合理</i></td>
				</tr>
				<tr id="purpose3">
					<td colspan="2">
						<input type="radio" name="purpose" id="purpose" value="1" checked="checked" />极差&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="purpose" id="purpose" value="2" />较差&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="purpose" id="purpose" value="3" />一般&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="purpose" id="purpose" value="4" />良好&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="purpose" id="purpose" value="5" />优秀&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</table>
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
		<table>
			<tr style="display: none;">
				<td><input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
				<td><input type="text" id="num" value="risk" /></td>
				<td><input type="text" name="serviceType" id="serviceType" /></td>
				<td><input type="text" id="username" value="<%=username%>" /></td>
			</tr>
			<tr>
				<td style="display: none;"><input type="text" name="taskid"
					value="<%=taskId%>" /></td>
				<td style="display: none;"><input type="text" name="taskname"
					value="<%=taskName%>" /></td>
			</tr>
			<tr>
				<td style="width: 90px">处理方式：</td>
				<td><select name="sel" id="processid" onchange="cl(this.value)"
					style="width: 150px">
						<option value="nextLater">下一处理环节</option>
						<option value="transfer">委托他人处理</option>
				</select></td>
			</tr>
		</table>
		<table>
			<tr id="cl" style="display: none;">
				<td style="width: 90px">指定处理人：</td>
				<td id="selOpe"></td>
			</tr>
			<tr>
				<td id="sub" style="display: block;"><input type="submit" name="result" value="提交"
					style="width: 50px; height: 22px" /></td>
				<td id="but" style="display: none;"><input type="button" onclick="tijiao()" value="提交"
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
<script type="text/javascript" src="<%=basePath%>js/transfer.js"></script>
<script type="text/javascript" src="<%=basePath%>js/lawForm.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/risk.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>