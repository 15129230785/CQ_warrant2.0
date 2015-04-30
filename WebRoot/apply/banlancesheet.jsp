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
<link rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link rel="stylesheet" href="<%=basePath %>Validform/style.css" />
<title>资产负债表</title>
<!-- 冯慧雄开始修改 -->
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>资产负债表</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form class="banlancesheet_form" method="post">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="eid" id="eid" type="text" value="<%=eid%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>报表类型：</span></td>
						<td class="edit_comp_r">
							<select style="width: 205px;" name="Type" id="btype" onchange="data(this.value)">
								<option value="0" >年度报表</option>
								<option value="1" >最新报表</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 140px;"><span>日期：</span></td>
						<td class="edit_comp_r" id="data2">
							<input id="Date" name="Date" type="text" class="Wdate"  
							datatype="*" nullmsg="请填写日期！" errormsg="请填写日期！ " placeholder="必须填写" sucmsg=" " />
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>总资产：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="TotalAssets " id="TotalAssets" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>流动资产：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="CurrentAssets" id="CurrentAssets" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>货币资金：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="MoneyFunds" id="MoneyFunds" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>短期投资：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="TemporaryInvestment" id="TemporaryInvestment" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>应收票据：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="NoteReceivable" id="NoteReceivable" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>应收账款：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="Receivables" id="Receivables" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>预付账款：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="PrepaidAccounts" id="PrepaidAccounts" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>其它应收款：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="OtherReceivables" id="OtherReceivables" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>存货：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="Inventory" id="Inventory" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>待摊费用：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="UnamortizedExpenditures" id="UnamortizedExpenditures" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>长期投资：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="LongtermInvestments" id="LongtermInvestments" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>固定资产净值：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="NetFixedAssets" id="NetFixedAssets" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>无形及递延资产：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="IntangibleandDeferredAssets" id="IntangibleandDeferredAssets" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>负债总额：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="TotalIndebtedness" id="TotalIndebtedness" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>流动负债：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="CurrentLiabilities" id="CurrentLiabilities" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>短期借款：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="ShorttermLoans" id="ShorttermLoans" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>应付票据：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="NotesPayable" id="NotesPayable" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>应付账款：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="AccountPayable" id="AccountPayable" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>预收账款：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="DepositReceived" id="DepositReceived" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>其它应付款：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="OtherPayables" id="OtherPayables" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>一年内到期的长期负债：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="ltldwoy" id="ltldwoy" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>长期负债：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="LongtermDebt" id="LongtermDebt" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>长期借款：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="LongtermLoans" id="LongtermLoans" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>应付债券：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="BondPayable" id="BondPayable" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>长期应付款：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="LongtermPayables" id="LongtermPayables" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>所有者权益：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="OwnerEquity" id="OwnerEquity" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>实收资本：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="PaidupCapital" id="PaidupCapital" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>资本公积：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="CapitalReserve" id="CapitalReserve" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>未分配利润：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="UndistributedProfit" id="UndistributedProfit" style="width: 200px;"
							type="text" datatype="a3" errormsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
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
			<!-- 冯慧雄结束修改 -->
		</div>
	</div>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/dateFormat.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/banlancesheet.js"></script>
</body>
</html>