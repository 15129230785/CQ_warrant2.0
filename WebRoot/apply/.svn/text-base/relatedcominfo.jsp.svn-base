<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/apply.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Validform/style.css" />
<title>企业关联信息</title>
<%
	String eid=request.getParameter("eid");
	String kid=request.getParameter("kid");
%>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>关联企业信息</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form method="post" class="TblRelatedcominfoClass">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="eid" id="eid" type="text" value="<%=eid%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>关联企业代码：</span></td>
						<td class="edit_comp_r"><input class="comp_input" maxlength="9"
							name="relatedID" id="relatedID" style="width: 200px;" type="text"
							datatype="n1" sucmsg=" " errormsg="企业代码为9位数字或大写拉丁字母"  placeholder="必须填写" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>关联企业名称：</span></td>
						<td class="edit_comp_r"><input class="comp_input" name="Name"
							id="Name" style="width: 200px;" type="text" datatype="s" sucmsg=" " errormsg="不允许输入特殊字符"  placeholder="必须填写" /></td>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/relatedcominfo.js"></script>
</body>
</html>