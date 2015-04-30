<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    String path = request.getContextPath();
 	String basePath = request.getScheme() + "://"
 		   + request.getServerName() + ":" + request.getServerPort()
 		   + path + "/";
 	
 	String wid = request.getParameter("wid");
	String kid = request.getParameter("kid");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<title>反担保措施</title>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>反担保措施</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form method="post" id="AntiwarrantPreserveId">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="wid" id="wid" type="text" value="<%=wid%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>反担保类型：</span></td>
						<td class="edit_comp_r">
							<select name="Type" id="Type"></select>
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>反担保起始日期：</span></td>
						<td>
							<input id="StartDate" class="Wdate" type="text"
							onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'EndDate\')||\'2020-10-01\'}'})"
							name="StartDate" id="StartDate" datatype="*" nullmsg="反担保起始日期不能为空！"
							errormsg="请输入反担保起始日期" sucmsg=" " placeholder="必须填写" />
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>反担保终止日期：</span></td>
						<td>
							<input id="EndDate" class="Wdate" type="text"
							onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'StartDate\')}',maxDate:'2050-10-01'})"
							name="EndDate" id="EndDate" datatype="*" nullmsg="反担保终止日期不能为空！"
							errormsg="请填写反担保终止日期！" sucmsg=" " placeholder="必须填写" />
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>反担保金额：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="Value" id="Value" style="width: 200px;" type="text"
							datatype="Value" nullmsg="金额不能为空！" errormsg="请输入数字！" sucmsg=" "
							placeholder="可填可不填" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>反担保内容：</span></td>
						<td class="edit_comp_r"><textarea name="Description"
							altercss="gray" tip="请在这里输入。" datatype="*" sucmsg=" "
							id="Description" placeholder="必须填写"></textarea></td>
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
<script type="text/javascript" src="<%=basePath%>js/public/antiWarrantType.js"></script>
<script type="text/javascript" src="<%=basePath%>js/antiwarrant.js"></script>
</body>
</html>