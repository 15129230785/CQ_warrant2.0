<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/apply.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Validform/style.css" />
<title>企业重大历史事件</title>
<%
	String eid = request.getParameter("eid");
	String kid = request.getParameter("kid");
%>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover">
			<font class="head_fcl"></font>企业重大历史事件</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form method="post" class="history_event" id="frmHistory">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="eid" id="eid" type="text" value="<%=eid%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 160px;text-align: right"><span>重大事件类型：</span></td>
						<td class="edit_comp_r">
							<select name="Type" id="eventType" style="width:205px"  datatype="*" nullmsg="请选择重大事件类型！"
							errormsg="请选择重大事件类型！" sucmsg=" "></select>
						</td>
					</tr>

					<tr>
						<td class="edit_comp_l" style="width: 160px;text-align: right"><span>事件发生时间：</span></td>
						<td class="edit_comp_r">
							<input type="text" class="Wdate"  style="width:202px" onfocus="WdatePicker()"
							name="Date" id="Date" datatype="*" placeholder="请选择事件发生时间" nullmsg="请选择事件发生时间！"
							errormsg="事件发生时间格式错误！" sucmsg=" " />
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;text-align: right"><span>事件描述：</span></td>
						<td class="edit_comp_r">
							<textarea name="Description" id="Description" tips="请填写事件描述！"
							rows="3" cols="21" datatype="*" nullmsg="请填写事件描述！"
							errormsg="事件描述不正确！" sucmsg=" "placeholder="请填写事件描述"></textarea>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" value="提交" />
							<input id="close" type="button" value="返回" />
							<input type="reset" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/history.js"></script>
</body>
</html>