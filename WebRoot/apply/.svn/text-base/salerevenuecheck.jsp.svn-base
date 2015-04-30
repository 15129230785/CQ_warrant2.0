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
<link rel="stylesheet" type="text/css" href="<%=basePath %>Validform/style.css" />
<title>销售收入核查信息</title>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>销售收入核查信息</span>
	</div>
	<div class="center_content_top"></div>
		<div class="edit_wrap">
			<div class="edit_comp">
				<form method="post" class="TblSalerevenuecheck_form">
					<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
					<input name="eid" id="eid" type="text" value="<%=eid%>" style="display: none;" />
					<table>
						<tr>
							<td class="edit_comp_l" style="width: 260px;"><span>报表类型：</span></td>
							<td class="edit_comp_r"><select style="width: 205px;" name="Type" id="btype"
								onchange="data(this.value)">
									<option value="0">年度报表</option>
									<option value="1">最新报表</option>
							</select></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 260px;"><span>日期：</span></td>
							<td class="edit_comp_r" id="data2"><input style="width: 200px;" id="Date"
								name="Date" type="text" class="Wdate"  datatype="*" nullmsg="请填写日期！" 
								errormsg="请填写日期！ " placeholder="必须填写" sucmsg=" " /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 260px;"><span>财报销售收入：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="RevenueBasedForm" id="RevenueBasedForm"
								style="width: 200px;" type="text" datatype="a3" nullmsg="请填写信息！"
								errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 260px;"><span>对比相关税务凭证返算收入：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="RevenueBasedTax" id="RevenueBasedTax" style="width: 200px;"
								type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ "
								placeholder="必须填写" sucmsg=" " /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 260px;"><span>未纳税营业收入：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="RevenueNoTax" id="RevenueNoTax" style="width: 200px;"
								type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ "
								placeholder="必须填写" sucmsg=" " /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 260px;"><span>重要账户对账单贷方总额：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="LenderSum" id="LenderSum" style="width: 200px;" type="text"
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
<script type="text/javascript" src="<%=basePath%>js/public/dateFormat.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/salerevenue.js"></script>
</body>
</html>