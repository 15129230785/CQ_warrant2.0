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
<link rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<link rel="stylesheet" href="<%=basePath%>css/apply.css" />
<title>企业注册变更信息</title>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>企业注册变更信息表</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form method="post" class="zcbg_form">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="rid" id="rid" type="text" value="<%=rid%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>变更时间：</span></td>
						<td class="edit_comp_r"><input id="chgDate"
							style="width: 160px;" name="chgDate" type="text"
							onClick="WdatePicker()" class="Wdate" datatype="a2"
							errormsg="请填写信息！" placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>变更类型：</span></td>
						<td class="edit_comp_r"><select name="ChgType" id="type"
							style="width: 162px;">
						</select></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>变更内容：</span></td>
						<td class="edit_comp_r"><textarea name="Description" id="Description"
							altercss="gray" tip="请在这里输入。" datatype="*"
							errormsg="不允许输入特殊字符" placeholder="必须填写" sucmsg=" " ></textarea></td>
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
<script type="text/javascript" src="<%=basePath%>js/public/changeType.js"></script>
<script type="text/javascript" src="<%=basePath%>js/change.js"></script>
</body>
</html>