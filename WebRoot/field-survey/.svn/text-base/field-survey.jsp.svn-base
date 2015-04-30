<%@page language="java" contentType="text/html; charset=UTF-8"
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
<title>现场调查</title>
</head>

<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
	</div>
	<br />
	<form action="FieldSurvey" id="fieldSurvey" method="post" class="idform">
		<fieldset>
			<legend>现场调查结果</legend>
			<div id="companyfsi"><table>
	      		<tr>
					<td>企业概况：(<i>简述企业历史沿革、企业规模；主营产品、产品用途、产能状况、主要销售范围、市场占有率、市场需求状况；对企业所在行业的准入政策限制、行业生产周期、淡旺季进行简单分析及预测；企业组织架构、管理人员构成；员工人数及工作状态</i>)</td>
	      		</tr>
				<tr>
					<td><textarea name="equipment" cols="80" rows="3" datatype="*"
						nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="equipment"></textarea></td>
				</tr>
				<tr>
					<td>现场经营情况：(<i>结合企业自述情况，重点描述现场实际情况，包括企业占地规模；企业经营场地、厂房性质、建设、使用情况、租金缴纳情况；实际企业现场生产状态、现场管理情况；对企业存货、重要资产进行现场核实，说明存货估值方法，评估金额。必须说明相关情况的核实过程，所验看的证照、资料、单据、接触人物，结合企业现场经营情况，综合分析企业自述生产能力、销售等情况的真实性，明确评价意见</i>)</td>
	          	</tr>
				<tr>
					<td><textarea name="manage" cols="80" rows="3" datatype="*"
						nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="manage"></textarea></td>
				</tr>
				<tr>
					<td>能源消耗情况：(<i>根据企业现场设备数量、耗电情况、设备开工情况做初步估算，结合企业电费、水费缴纳情况，要重点核实原因并分析其真实性、合理性；并分析其它主要能源的消耗情况</i>)</td>
	           	</tr>
				<tr>
					<td><textarea name="staff" cols="80" rows="3" datatype="*"
						nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写" id="staff"></textarea></td>
				</tr>
			</table></div>
			<div id="personfsi"><table>
				<tr>
					<td>贷款用途分析：(<i>必须说明个人贷款的用途，以及用途的真实性、合理性</i>)</td>
				</tr>
				<tr>
					<td><textarea name="loausanalysis" cols="80" rows="3" datatype="*"
						nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写"></textarea></td>
				</tr>
				<tr>
					<td>信用状况：(<i>详实表述企业、股东、法人、实际控制人信用情况，内容包括短期借款、承兑票据、对外担保、因各种赔款等可能产生的其他或有负债，尽可能落实民间借款、对外担保情况</i>)
					</td>
				</tr>
				<tr>
					<td><textarea name="workplace" cols="80" rows="3" datatype="*"
						nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写"></textarea></td>
				</tr>
				<tr>
					<td>反担保措施：(<i>必须详细说明反担保措施情况，本着资格满足、责权明晰、有效担保、偿还能力强、便于防范风险的原则进行核实。必须说明所验看的证照、票据、单据、凭证名称，必须说明取得方式、取得过程、核实方法、核实过程、核实结果</i>)
					</td>
				</tr>
				<tr>
					<td><textarea name="counterGuarantee" cols="80" rows="3"
						datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写"></textarea></td>
				</tr>
				<tr>
					<td>还款能力分析：(<i>必须说明企业多渠道的还款途径，重点落实企业第一还款来源的可靠性，还应该分析现金流与企业经营特性及规律的符合与匹配度。通过银行流水与销售收入的对比考察，确定企业实际收取现金的能力和水平；是否存在银行对帐单的流入流出量虽然大，但多数是帐户之间相互划转及其他渠道形成的资金流，真正销售现金流不多。明确企业最终经核实认可的盈利能力、偿还能力</i>)
					</td>
				</tr>
				<tr>
					<td><textarea name="product" cols="80" rows="3" datatype="*"
						nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写"></textarea></td>
				</tr>
			</table></div>
			
			<table>
				<tr>
					<td style="width:110px">项目调查时间：</td>
					<td><input type="text" name="startDate"
						onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})" /></td>
				</tr>
			</table>
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
			<table style="margin: 0 0 0;">
				<tr>
					<td style="display: none;">
						<input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
					<td style="display: none;">
						<input type="text" id="num" value="field-survey" /></td>
					<td style="display: none;">
						<input type="text" name="taskid" value="<%=taskId%>" /></td>
					<td style="display: none;">
						<input type="text" name="taskname" value="<%=taskName%>" /></td>
					<td style="display: none;">
						<input type="text" name="serviceType" id="serviceType" /></td>
					<td style="display: none;">
						<input type="text" id="username" value="<%=username%>" /></td>
				</tr>
				<tr>
					<td style="width:110px">处理方式：</td>
					<td><select name="sel" id="processid"
						onchange="chi(this.value)" style="width: 150px">
							<option value="nextLater">下一处理环节</option>
							<option value="transfer">委托他人处理</option>
							<option value="refund">退评审费</option>
							<option value="stop">终止</option>
					</select></td>
				</tr>
			</table>
			<table style="margin: 0 0 0;">
				<tr id="refund" style="display: none;">
					<td style="width:110px">需退金额(元)：</td>
					<td><input type="text" id="refundMoney" name="refundMoney" 
					onkeyup="inputDecimal(this)"/></td>
				</tr>
			</table>
			<table style="margin: 0 0 0;">
				<tr id="tr" style="display: none;">
					<td style="width:110px">终止原因：</td>
					<td><textarea name="over" id="st" cols="40" rows="3"
						style="font-size: 20px;"></textarea></td>
				</tr>
			</table>
			<table style="margin: 0 0 0;">
				<tr id="sel">
					<td style="width:110px">指定处理人：</td>
					<td id="selOpe"></td>
				</tr>
				<tr>
					<td id="sum"><input type="submit" value="提交"/></td>
					<td id="but" style="display: none;">
						<input type="button" value="提交" onclick="tijiao()" />
					</td>
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
<script type="text/javascript" src="<%=basePath%>js/chargeInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/lawForm.js"></script>
<script type="text/javascript" src="<%=basePath%>js/transfer.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/field-survey.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>