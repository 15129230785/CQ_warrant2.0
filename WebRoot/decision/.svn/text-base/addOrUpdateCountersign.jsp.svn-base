<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
	
	String wid = request.getParameter("wid");
	String username = (String) session.getAttribute("user");
	String kid = request.getParameter("kid");
	String number = request.getParameter("number");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>Validform/style.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/apply.css" />
<title>评委会签意见</title>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>评委会签意见</span>
	</div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form method="post" id="countersign">
				<table>
					<tr style="display: none">
						<td><input name="wid" id="wid" value="<%=wid%>" /></td>
						<td><input id="kid" value="<%=kid%>" /></td>
						<td><input name="number" id="number" value="<%=number%>"></td>
						<td><input id="username" value="<%=username%>"></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 190px;">会签人名称：</td>
						<td class="edit_comp_r" id="counterSignName"><select id="userList" name="name"
							datatype="*,cousign" sucmsg=" " nullmsg="请填写部门信息"
							errormsg="不允许输入特殊字符 " placeholder="必须填写"></select></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 190px;">会签日期：</td>
						<td class="edit_comp_r"><input id="time" name="date"
							class="Wdate" type="text"
							onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'time\')||\'2020-10-01\'}'})"
							datatype="*" errormsg="请填写信息！" placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 190px;">会签结论：</td>
						<td class="edit_comp_r"><select name="result" id="pass">
							<option value="0">通过</option>
							<option value="1">不通过</option>
						</select></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 190px;">情况说明：</td>
						<td class="edit_comp_r"><textarea name="description"
							id="description" datatype="mone" errormsg="请填写不通过原因"
							placeholder="不通过时必须填写" sucmsg=" "></textarea>(<i>如：不通过原因等</i>)</td>
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
<script type="text/javascript" src="<%=basePath%>js/memberShipManage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>js/addOrUpdateCountersign.js"></script>
</body>
</html>