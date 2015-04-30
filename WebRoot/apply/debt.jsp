<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
 	String basePath = request.getScheme() + "://"
 		   + request.getServerName() + ":" + request.getServerPort()
 		   + path + "/";
 	
 	String id = request.getParameter("id");
	String kid = request.getParameter("kid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<title>个人债务信息</title>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>个人债务信息</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form method="post" class="debt_form">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="id" id="id" type="text" value="<%=id%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>债权人名称：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="loaner" id="loaner" style="width: 150px;" type="text"
							datatype="*" nullmsg="请填写债权人名称！" errormsg="请填写债权人名称！" 
							placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>债务起始日期：</span></td>
						<td class="edit_comp_r"><input id="b1" name="StartDate"
							class="Wdate" type="text"
							onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'b2\')||\'2050-10-01\'}'})"
							datatype="*" nullmsg="请填写债务起始日期"errormsg="请填写债务起始日期" 
							placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>债务终止日期：</span></td>
						<td class="edit_comp_r"><input id="b2" name="EndDate"
							class="Wdate" type="text"
							onFocus="WdatePicker({minDate:'#F{$dp.$D(\'b1\')}',maxDate:'2050-10-01'})"
							datatype="*" nullmsg="请填写债务起始日期"errormsg="请填写债务起始日期" 
							placeholder="必须填写" sucmsg=" " />
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>金额：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="Money" id="Money" style="width: 150px;" type="text"
							datatype="a1" nullmsg="请填写金额"errormsg="不能为负数且小数点后最多保留两位"
							 placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>目前余额：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="Remaining" id="Remaining" style="width: 150px;" type="text"
							datatype="a1,ur" nullmsg="请填写金额"errormsg="不能为负数且小数点后最多保留两位"
							 placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>说明：</span></td>
						<td class="edit_comp_r">
							<textarea name="description" datatype="*" nullmsg="请填写相关信息" errormsg="填写信息不合法 " sucmsg=" "
							placeholder="必须填写" id="description" ></textarea></td>
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
<script type="text/javascript" src="<%=basePath%>js/debt.js"></script>
</body>
</html>