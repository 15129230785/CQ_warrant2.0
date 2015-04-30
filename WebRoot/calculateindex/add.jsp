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
<title>增加计算类指标系数</title>
<script type="text/javascript">
</script>
</head>
<body>
	<form method="post" action="addCalculateindex">
		<table>
			<tr>
				<td class="edit_comp_l" style="width: 150px;">
				<span>指标名称：</span></td>
				<td class="edit_comp_r"><input class="comp_input"
					name="name" id="name" style="width: 200px;" type="text" /></td>
			</tr>
			<tr>
				<td class="edit_comp_l" style="width: 150px;">
				<span>指标中文名称：</span></td>
				<td class="edit_comp_r"><input class="comp_input"
					name="cname" id="cname" style="width: 200px;" type="text"/></td>
			</tr>
			<tr>
				<td class="edit_comp_l" style="width: 150px;">
				<span>指标下限：</span></td>
				<td class="edit_comp_r"><input class="comp_input"
					name="floor" id="floor" style="width: 200px;" type="text"/></td>
			</tr>
			<tr>
				<td class="edit_comp_l" style="width: 150px;">
				<span>指标上限：</span></td>
				<td class="edit_comp_r"><input class="comp_input"
					name="ceil" id="ceil" style="width: 200px;" type="text"/></td>
			</tr>
			<tr>
				<td class="edit_comp_l" style="width: 150px;">
				<span>指标分值：</span></td>
				<td class="edit_comp_r"><input class="comp_input"
					name="indexvalue" id="indexvalue" style="width: 200px;" type="text"/></td>
			</tr>
			<tr>
				<td class="edit_comp_l" style="width: 150px;">
				<span>系数：</span></td>
				<td class="edit_comp_r"><input class="comp_input"
					name="ratio" id="ratio" style="width: 200px;" type="text"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><button type="button" onclick="window.close();">返回</button></td>
				<td><input type="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>