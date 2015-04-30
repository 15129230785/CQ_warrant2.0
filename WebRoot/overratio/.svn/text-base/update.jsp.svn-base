<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String or0 = request.getParameter("or0");
	String or1 = request.getParameter("or1");
	String or2 = request.getParameter("or2");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改过度系数</title>
<style type="text/css">
.center_content_head span {
	padding-left: 6px;
	line-height: 18px;
	color: #A5A5A5;
	font-size: 13px;
}

.center_content_head span.cchhover {
	padding-left: 5px;
	line-height: 18px;
	color: #0D7DB9;
	font-size: 14px;
	font-weight: bold;
}

.edit_comp .star_color {
	color: red;
	font-size: 12px;
	padding-right: 5px;
}
</style>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>修改过度参数</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form action="updateOverRatio" method="post">
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>贷款年限1年以下(含1年)%：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="or0" id="or0" style="width: 200px;"
							type="text" value="<%=or0%>" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>贷款年限1-2年(含2年)%：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="or1" id="or1" style="width: 200px;" type="text"
							value="<%=or1%>" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>贷款年限2-3年(含3年)%：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="or2" id="or2" style="width: 200px;" type="text"
							value="<%=or2%>" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="提交"></td>
						<td><input type="button" onclick="javascript:window.close()" value="返回"></td>
						<td><input type="reset"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>