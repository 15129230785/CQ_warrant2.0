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
<title>企业管理人员信息</title>
</head>

<body>
<center>
	<!-- 冯慧雄开始修改 -->
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>企业管理人员信息表</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form action="SavaTblManinfo" method="post" id="managersu">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="eid" id="eid" type="text" value="<%=eid%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>姓名：</span></td>
						<td class="edit_comp_r"><input class="comp_input" name="name"
							id="Name" style="width: 200px;" type="text" datatype="*,s"
							sucmsg=" " nullmsg="请填写信息" errormsg="姓名不能为空！" placeholder="必须填写" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>职务类型：</span></td>
						<td class="edit_comp_r"><select style="width: 205px;" name="Type" id="type"
							datatype="*,mtype" sucmsg=" " nullmsg="请填写信息">
						</select></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>性别：</span></td>
						<td class="edit_comp_r"><span id="gender"></span></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>婚姻状况：</span></td>
						<td class="edit_comp_r"><span id="maritalStatus"></span></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>出生日期：</span></td>
						<td class="edit_comp_r"><input style="width: 200px;" id="d4311" class="Wdate"
							type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
							name="birthday" datatype="*" sucmsg=" " nullmsg="请填写信息"
							errormsg="出生日期不能为空！" placeholder="必须填写" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>国籍：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="Country" id="Country" style="width: 200px;" type="text"
							sucmsg=" " datatype="*,s" nullmsg="请填写信息" errormsg="国籍不能为空！"
							placeholder="必须填写" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>学历：</span></td>
						<td class="edit_comp_r"><select style="width: 205px;" name="Education" id="Education">
						</select></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>身份证号码：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="manId" id="manId" style="width: 200px;" maxLength="18"
							type="text" datatype="manager,a4" sucmsg=" "
							nullmsg="请填写18位身份证信息" errormsg="身份证格式错误" placeholder="必须填写" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>管理经验年限：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="YearsOfManager" id="YearsOfManager"
							style="width: 200px;" type="text"  datatype="age1,mam" sucmsg=" "/></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>行业经验年限：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="YearsOfVocation" id="YearsOfVocation"
							style="width: 200px;" type="text" datatype="age,mam" sucmsg=" "/></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>主要履历：</span></td>
						<td class="edit_comp_r">
							<textarea class="comp_input" name="Record" id="Record"></textarea></td>
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
</center>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/rootPath.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/duty.js"></script>
<script type="text/javascript" src="<%=basePath%>js/manager.js"></script>
</body>
</html>