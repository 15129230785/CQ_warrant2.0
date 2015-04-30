<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
 	String basePath = request.getScheme() + "://"
 		   + request.getServerName() + ":" + request.getServerPort()
 		   + path + "/";
 	
 	String eid = request.getParameter("eid");
	String kid = request.getParameter("kid");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/apply.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>Validform/style.css" />
<title>企业股东信息</title>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>企业主要股东信息</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form method="post" id="stocksub">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="eid" id="eid" type="text" value="<%=eid%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>股东名称：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="Name" id="Name" style="width: 200px;" type="text"
							datatype="*,s" sucmsg=" " errormsg="不允许输入特殊字符" placeholder="必须填写" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 200px;"><span>股东类型：</span></td>
						<td class="edit_comp_r"><select name="Type" style="width: 205px;" id="Type"
							datatype="s" errormsg="请填写股东类型" sucmsg=" "  >
								<option value="">请选择股东类型</option>
								<option value="0">法人股东</option>
								<option value="1">自然人股东</option>
						</select></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>股东编码：</span></td>
						<td class="edit_comp_r"><input type="text" class="comp_input" name="SID"
							id="SID" style="width: 200px;" maxlength="" datatype="t"  
							placeholder="必须填写" errormsg="法人请输入公司编码，自然人请输入身份证号码" sucmsg=" " onclick="mxl()" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 200px;"><span>入资形式：</span></td>
						<td class="edit_comp_r"><select style="width: 205px;" name="Mode" id="Mode"
							datatype="*" errormsg="请选择入资形式" sucmsg=" ">
						</select></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>投资金额：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="Money" id="Money" style="width: 200px;" type="text"
							datatype="mone" sucmsg=" " errormsg="请填写数字" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>投资比例(%)：</span></td>
						<td class="edit_comp_r"><input class="comp_input" name="Proportion" id="Proportion" style="width: 200px;"
							type="text" datatype="a6,a5,proport" sucmsg=" "
							errormsg="投资比例之和不得超过100%" nullmsg="" placeholder="必须填写" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 160px;"><span>描述：</span></td>
						<td class="edit_comp_r">
							<textarea class="comp_input" name="Description" id="Description" ></textarea></td>
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
				<input type="text" id="oldproportion" style="display:none"/>
			</form>
		</div>
	</div>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/rootPath.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/capitalMode.js"></script>
<script type="text/javascript" src="<%=basePath%>js/stock.js"></script>
</body>
</html>