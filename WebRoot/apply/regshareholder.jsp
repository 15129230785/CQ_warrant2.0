<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
 	String basePath = request.getScheme() + "://"
 		   + request.getServerName() + ":" + request.getServerPort()
 		   + path + "/";
 	
 	String rid = request.getParameter("rid");
	String kid = request.getParameter("kid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/apply.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>Validform/style.css" />
<title>企业注册股东信息</title>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>企业注册股东信息</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form method="post"	class="registerStock_form">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="rid" id="rid" type="text" value="<%=rid%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>股东名称：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="Name" id="Name" style="width: 160px;" type="text"
							datatype="s" errormsg="不允许输入特殊字符" placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>股东类型：</span></td>
						<td class="edit_comp_r"><input type="radio" name="Type"
							value="0" />法人股东 <input type="radio"
							name="Type" value="1" />自然人股东</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>股东编码：</span></td>
						<td class="edit_comp_r"><input class="comp_input" name="Sid"
							id="Sid" style="width: 160px;" type="text" datatype="t"
							maxlength="" errormsg="请填写9位企业编码或者18位身份证号码" placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>所占股份比例(%)：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="Share" id="Share" style="width: 160px;" type="text"
							datatype="bl" nullmsg="请输入股份比例" errormsg="所占比例为数字"
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
<script type="text/javascript" src="<%=basePath%>js/regshareholder.js"></script>
</body>
</html>