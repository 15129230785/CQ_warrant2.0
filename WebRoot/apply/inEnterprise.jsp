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
<title>企业内部部门信息</title>
</head>

<body>
	<!-- 冯慧雄开始修改 -->
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>企业内部部门信息</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form class="adddepart" method="post" id="departsub">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="eid" id="eid" type="text" value="<%=eid%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>部门名称：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="Name" id="Name" style="width: 200px;" type="text"
							datatype="*,depart,s" sucmsg=" " nullmsg="请填写部门信息"
							errormsg="部门信息已存在 " placeholder="必须填写" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>部门职能：</span></td>
						<td class="edit_comp_r"><textarea class="comp_input"
							name="Duty" id="Duty" ></textarea></td>
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
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/department.js"></script>
</body>
</html>