<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	int iid = Integer.parseInt(request.getParameter("iid")); 	
	String name = request.getParameter("name");
	String cname = new String(request.getParameter("cname").getBytes("ISO8859-1"), "UTF-8");
	String floor = request.getParameter("floor");
	String ceil = request.getParameter("ceil");
	String indexvalue = request.getParameter("indexvalue");
	String ratio = request.getParameter("ratio");
	
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改计算类指标系数</title>
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
</head>
<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>修改业务检查参数</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form action="updateCalculateindex" method="post">
			<input type="text" name="iid" id="iid" style="display : none" value="<%=iid%>"/>
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>指标名称：</span></td>
						<td class="edit_comp_r">
							<p><%=cname%></p>
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>指标下限：</span></td>
						<td class="edit_comp_r">
						<input class="comp_input" name="floor" id="floor" style="width: 200px;" type="text"
						value="<%=floor%>" />
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>指标上限：</span></td>
						<td class="edit_comp_r">
						<input class="comp_input" name="ceil" id="ceil" style="width: 200px;" type="text"
						value="<%=ceil%>" />
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>指标分值：</span></td>
						<td class="edit_comp_r">
						<input class="comp_input" name="indexvalue" id="indexvalue" style="width: 200px;"
						type="text" value="<%=indexvalue%>" />
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>系数：</span></td>
						<td class="edit_comp_r">
						<input class="comp_input" name="ratio" id="ratio" style="width: 200px;" type="text"
						value="<%=ratio%>" />
						</td>
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