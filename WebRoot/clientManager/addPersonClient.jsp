<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	String username = (String) session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>个人担保申请信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>Validform/style.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/apply.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/personApply.css" />
</head>

<body>
	<div id="personTabs">
		<ul>
			<li><a class="selectTag" href="#personBasic">个人基本信息</a></li>
			<li><a href="#personCredit">个人信用信息</a></li>
		</ul>
		<div class="tagContent" id="personBasic">
			<a class="header" href="#">个人基本信息</a>
			<div>
				<iframe name="hideIframe" style="display: none;"></iframe>
				<form class="personform" target="hideIframe"
					action="SavaTblPerson" method="post" id="personinfo">
					<table width="100%">
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>身份证号码：</span></td>
							<td class="edit_comp_r">
								<input class="comp_input" name="PerID" id="PerID" style="width: 50%;" type="text"
								maxlength="18" datatype="a4,piddatatype" sucmsg=" " nullmsg="请填写身份证信息"
								errormsg="身份证号码二代18位/一代15位" placeholder="必须填写" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>姓名：</span></td>
							<td class="edit_comp_r">
								<input class="comp_input" name="Name" id="perName" style="width: 50%;" type="text"
								datatype="*" sucmsg=" " nullmsg="请填写姓名" errormsg="姓名不能为空"
								placeholder="必须填写" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>性别：</span></td>
							<td class="edit_comp_r">
								<select class="comp_input" name="Gender" id="Gender" style="width: 50%;">
								</select></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>出生日期：</span></td>
							<td class="edit_comp_r">
								<input id="Birthday" name="Birthday" style="width: 50%;"
								type="text" class="Wdate" onFocus="WdatePicker()" datatype="*"
								sucmsg=" " nullmsg="请填写出生日期" errormsg="出生日期不能为空"
								placeholder="必须填写" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>家庭住址：</span></td>
							<td class="edit_comp_r">
								<input class="comp_input"
								name="Address" id="Address" style="width: 50%;" type="text" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>户口所在地：</span></td>
							<td class="edit_comp_r">
								<input class="comp_input" name="RegisterAddress" id="RegisterAddress"
								style="width: 50%;" type="text" datatype="*"
								sucmsg=" " nullmsg="请填写户口所在地" errormsg="户口所在地不能为空"
								placeholder="必须填写" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>职业：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="Vocation" id="Vocation" style="width: 50%;" type="text" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>移动电话：</span></td>
							<td class="edit_comp_r">
								<input class="comp_input" name="Mobile" id="Mobile" style="width: 50%;"
								type="text" datatype="yd" sucmsg=" " errormsg="移动电话为数字"
								onkeyup="inputInteger(this)" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>固定电话：</span></td>
							<td class="edit_comp_r">
								<input class="comp_input" name="Fix" id="Fix" style="width: 50%;"
								type="text" datatype="yd" sucmsg=" " errormsg="固定电话为数字"
								onkeyup="inputInteger(this)" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>电子邮箱：</span></td>
							<td class="edit_comp_r">
								<input class="comp_input" name="Email" id="Email" style="width: 50%;"
								type="text" datatype="eml" sucmsg=" "
								errormsg="请填写正确格式的电子邮箱，例如 myemail@qq.com" />
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>说明：</span></td>
							<td class="edit_comp_r">
								<textarea name="Description" altercss="gray" id="perDescription"></textarea>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="submit" id="perBtn" value="保存" />
							</td>
						</tr>
					</table>
				</form>
			</div>
			
			<a class="header" href="#"
				onclick="javascript:onclickSelectPerAjax('TblFamily');">家庭成员信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:family();">添加家庭成员信息</a>
				<div id="TblFamilydiv"></div>
			</div>
		</div>
		
		<div class="tagContent" id="personCredit">
			<a class="header" href="#" 
				onclick="javascript:onclickSelectPerAjax('TblDebt');">个人债务信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:debt();">添加个人债务信息</a>
				<div id="TblDebtdiv"></div>
			</div>
			
			<a class="header" href="#"
				onclick="javascript:onclickSelectPerAjax('TblPersonalwarrant');">个人担保信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:personalwarrant();">添加个人担保信息</a>
				<div id="TblPersonalwarrantdiv"></div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/rootPath.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/decimal.js"></script>
<script type="text/javascript" src="<%=basePath%>js/personApply.js"></script>
<script type="text/javascript" src="<%=basePath%>js/personDiv.js"></script>
<script type="text/javascript" src="<%=basePath%>js/addPerson.js"></script>
</body>
</html>
