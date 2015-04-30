<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/apply.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Validform/style.css" />
<title>企业主要产品</title>
<%
	String eid = request.getParameter("eid");
	String kid = request.getParameter("kid");
%>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>企业主要产品</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form method="post" id="frmProduct">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="eid" id="eid" type="text" value="<%=eid%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 160px;text-align: right"><span> 产品名称：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="Name" id="Name" style="width: 200px;" type="text" 
							datatype="s" nullmsg="请输入产品名称！" errormsg="请输入产品名称！" sucmsg=" "
							placeholder="请输入产品名称！" /></td>
					</tr>

					<tr>
						<td class="edit_comp_l" style="width: 160px;text-align: right"><span> 产品类型：</span></td>
						<td class="edit_comp_r">
							<select name="Type" id="Type" style="width: 204px;" datatype="*" nullmsg="请选择产品类型！"
								errormsg="请选择产品类型！" sucmsg=" " placeholder="请选择产品类型！">
								<option value="" selected="selected">请选择产品类型</option>
								<option value="0">实物</option>
								<option value="1">服务</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;text-align: right"><span> 产品用途：</span></td>
						<td class="edit_comp_r">
							<textarea class="comp_input" name="Purpose" id="Purpose" rows="3" cols="21"   
								datatype="*" nullmsg="请输入产品用途！" errormsg="产品用途不正确！" sucmsg=" "
								placeholder="请输入产品用途"></textarea>
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;text-align: right"><span> 技术含量：</span></td>
						<td class="edit_comp_r">
							<select name="Tech" id="Tech" datatype="*" style="width: 204px;" nullmsg="请选择技术含量！" errormsg="请选择技术含量！" sucmsg=" " placeholder="请选择技术含量">
								<option value="" selected="selected">请选择技术含量</option>
								<option value="0">高</option>
								<option value="1">中</option>
								<option value="2">低</option>
							</select></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;text-align: right"><span> 销售领域：</span></td>
						<td class="edit_comp_r">
							<textarea class="comp_input" name=" SaleDomain" id="SaleDomain" rows="3" cols="21"   
								datatype="*" nullmsg="请输入销售领域！" errormsg="销售领域输入有误！" sucmsg=" "
								placeholder="请输入销售领域"></textarea>
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;text-align: right"><span> 销售地区：</span></td>
						<td class="edit_comp_r">
							<textarea class="comp_input" name="SaleArea" id="SaleArea" rows="3" cols="21"   
								datatype="*" nullmsg="请输入销售地区！" errormsg="销售地区输入有误！" sucmsg=" "
								placeholder="请输入销售地区"></textarea>
					    </td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;text-align: right"><span> 销售收入占比(%)：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="IncomeProportion" id="incomeProportion" 
							datatype="incomeProportion_data" nullmsg="请输入销售收入占比！" errormsg="请输入销售收入占比！"
							sucmsg=" " placeholder="请输入销售收入占比，例如(45.03)"
							style="width: 200px;" type="text" onkeyup="inputDecimal(this)" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;text-align: right"><span> 市场占有率(%)：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="MarketShare" id="marketShare" style="width: 200px;"
							datatype="marketShare_data" nullmsg="请输入市场占有率！" errormsg="请输入市场占有率！"
							sucmsg=" " placeholder="请输入市场占有率，例如(45.03)"
							type="text" onkeyup="inputDecimal(this)" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" value="提交" />
							<input id="close" type="button" value="返回" />
							<input type="reset" />
						</td>
					</tr>
				</table>
				<input type="text" id="oldincome" style="display:none" />
			</form>
		</div>
	</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/decimal.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/product.js"></script>
</body>
</html>