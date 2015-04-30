<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
 	String basePath = request.getScheme() + "://"
 		   + request.getServerName() + ":" + request.getServerPort()
 		   + path + "/";
 	
 	String eid = request.getParameter("eid");
	String kid = request.getParameter("kid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/apply.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>Validform/style.css" />
<title>企业损益表信息</title>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>企业损益表</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form method="post" class="incomestatement_form">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="eid" id="eid" type="text" value="<%=eid%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>报表类型：</span></td>
						<td class="edit_comp_r"><select name="Type" style="width: 205px;" id="btype"
							onchange="data(this.value)">
							<option value="0">年度报表</option>
							<option value="1">最新报表</option>
						</select></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>日期：</span></td>
						<td class="edit_comp_r" id="data2"><input id="Date" style="width: 200px;"
							name="Date" type="text" type="text" class="Wdate" datatype="*" nullmsg="请填写日期！" 
							errormsg="请填写日期！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>产品销售收入：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="SalesRevenue" id="SalesRevenue" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ "
							placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>销售成本：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="CostofSales" id="CostofSales" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ "
							placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>主营业务利润：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="MainBusinessProfit" id="MainBusinessProfit"
							style="width: 200px;" type="text" datatype="a3" nullmsg="请填写信息！"
							errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>销售费用：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="SellingExpenses" id="SellingExpenses" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ "
							placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>管理费用：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="ManagementExpenses" id="ManagementExpenses"
							style="width: 200px;" type="text" datatype="a3" nullmsg="请填写信息！"
							errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>账务费用：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="FinancingExpenses" id="FinancingExpenses"
							style="width: 200px;" type="text" datatype="a3" nullmsg="请填写信息！"
							errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>利润总额：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="TotalProfits" id="TotalProfits" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ "
							placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>净利润：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="NetProfit" id="NetProfit" style="width: 200px;" type="text"
							datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ "
							placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" value="提交" />
							<input type="button" onclick="javascript:window.close()" value="返回" />
							<input type="reset" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/dateFormat.js"></script>
<script type="text/javascript" src="<%=basePath%>js/income.js"></script>
</body>
</html>