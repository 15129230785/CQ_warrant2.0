<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    String path = request.getContextPath();
 	String basePath = request.getScheme() + "://"
 		   + request.getServerName() + ":" + request.getServerPort()
 		   + path + "/";
 	
 	String eid = request.getParameter("eid");
	String kid = request.getParameter("kid");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/apply.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>Validform/style.css" />
<title>企业主要供货商信息</title>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>企业供货商信息</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form method="post" class="TblVendorValidform">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="eid" id="eid" type="text" value="<%=eid%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>供货商名称：</span></td>
						<td class="edit_comp_r"><input class="comp_input" name="Name"
							id="Name" style="width: 200px;" type="text"  datatype="s" sucmsg=" " errormsg="不允许输入特殊字符"  placeholder="必须填写"  /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>合作年限：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="YearsOfCooperation" id="YearsOfCooperation"
							style="width: 200px;" type="text" datatype="nd"  sucmsg=" " errormsg="请输入数字"  placeholder="必须填写"/></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>年交易额(元)：</span></td>
						<td class="edit_comp_r"><input name="AnnualVolume"
							id="AnnualVolume" style="width: 200px;" type="text"  datatype="nx"    sucmsg=" " errormsg="请输入数字"  placeholder="必须填写"  /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>交易额占比(%)：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="Proportion" id="Proportion" style="width: 200px;"
							type="text" datatype="np" sucmsg=" " errormsg="请输入数字" placeholder="必须填写" /></td>
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
<script type="text/javascript" src="<%=basePath%>js/vendor.js"></script>
</body>
</html>