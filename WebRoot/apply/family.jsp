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
<title>家庭成员信息</title>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>家庭成员信息</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form method="post" class="family_form">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="id" id="id" type="text" value="<%=id%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>姓名：</span></td>
						<td class="edit_comp_r"><input class="comp_input" name="name"
							id="name" style="width: 150px;" type="text" datatype="*"
							errormsg="请填写信息！" placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>身份证号码：</span></td>
						<td class="edit_comp_r"><input class="comp_input" name="sid"
							id="sid" style="width: 150px;" type="text" maxlength="18"
							datatype="a4" errormsg="身份证号码一代15位/二代18位" placeholder="必须填写"
							sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>性别：</span></td>
						<td class="edit_comp_r"><select style="width: 155px;" name="gender" id="gender" datatype="*"
							errormsg="请填写信息！" placeholder="必须填写" sucmsg=" ">
						</select></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>出生日期：</span></td>
						<td class="edit_comp_r"><input id="birthday" style="width: 150px;" name="birthday"
							class="Wdate" type="text" onFocus="WdatePicker()" datatype="*"
							errormsg="请填写信息！" placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>职业：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="vocation" id="vocation" style="width: 150px;" type="text"
							datatype="*" errormsg="请填写信息！" placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>关系：</span></td>
						<td class="edit_comp_r"><select style="width: 155px;" name="relationship"
							id="relationship" datatype="*" errormsg="请填写信息！"
							placeholder="必须填写" sucmsg=" ">
						</select></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>说明：</span></td>
						<td class="edit_comp_r">
							<textarea name="description" datatype="*" nullmsg="请填写相关信息"
								errormsg="填写信息不合法 " sucmsg=" " placeholder="必须填写"
								id="description"></textarea></td>
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
<script type="text/javascript" src="<%=basePath%>js/public/rootPath.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/relationship.js"></script>
<script type="text/javascript" src="<%=basePath%>js/family.js"></script>
</body>
</html>