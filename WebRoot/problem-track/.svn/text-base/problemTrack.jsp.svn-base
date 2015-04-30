<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>需要跟踪的问题</title>
<%
	String wid = request.getParameter("wid");
	String username = (String) session.getAttribute("user");
	String taskname = null;
	String temp = request.getParameter("taskname");
	if (temp != null) {
		taskname = new String(temp.getBytes("ISO-8859-1"), "UTF-8");
	}
	String kid = request.getParameter("kid");
%>
</head>
<body>
	<form method="post" id="frmProblem">
		<input style="display:none" type="text" id="wid" name="wid" value="<%=wid%>">
		<input style="display:none" type="text" id="kid" value="<%=kid%>">
		<table height="239" border="0" align="center">
			<tr style="display: none;">
				<td>问题提出阶段:</td>
				<td><input type="text" id="state" name="state" style="width:200px;" value="<%=taskname%>" />
				</td>
			</tr>
			<tr style="display: none;">
				<td>问题提出人:</td>
				<td><input type="text" id="name" name="name" value="<%=username%>" />
				</td>
			</tr>
			<tr>
				<td>问题责任人:</td>
				<td><select name="person" id="personList" style="width:205px;">
					</select>
				</td>
			</tr>
			<tr style="display: none;">
				<td>问题类型:</td>
				<td><input type="text" name="type" value="1" />
				</td>
			</tr>
			<tr>
				<td colspan="2">问题描述:</td>
			</tr>
			<tr>
				<td colspan="2"><textarea id="description" name="description"
					cols="45" rows="3"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">解决情况描述:</td>
			</tr>
			<tr>
				<td colspan="2"><textarea id="explains" name="explains"
					cols="45" rows="3"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="提交" />
					<input type="button" onclick="javascript:window.close()" value="返回" />
					<input type="reset" />
				</td>
			</tr>
		</table>
	</form>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/memberShipManage.js"></script>
<script type="text/javascript" src="<%=basePath%>js/problemTrack.js"></script>
</body>
</html>