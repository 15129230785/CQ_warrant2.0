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
<link rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<title>现金流量表信息</title>
</head>

<body>
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>现金流量表</span>
	</div>
	<div class="center_content_top"></div>
	 <div class="edit_wrap">
		<div class="edit_comp">
			<form method="post" class="cashflowstatement_form">
				<input id="kid"	type="text" value="<%=kid%>" style="display: none;" />
				<input name="eid" id="eid" type="text" value="<%=eid%>" style="display: none;" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>报表类型：</span></td>
						<td class="edit_comp_r">
							<select style="width: 205px;" name="Type" id="btype" onchange="data(this.value)">
								<option value="0" >年度报表</option>
								<option value="1" >最新报表</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>日期：</span></td>
						<td class="edit_comp_r" id="data2">
							<input id="Date" name="Date" class="Wdate" type="text"  datatype="*" nullmsg="请填写日期！" 
							errormsg="请填写日期！ " placeholder="必须填写" sucmsg=" " />
						</td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>经营活动产生的现金流入量：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="cifoa" id="cifoa" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>经营活动产生的现金流出量：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="cofoa" id="cofoa" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>经营活动产生的现金流量净额：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="ncffoa" id="ncffoa" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
						</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>投资活动产生的现金流入量：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="cifia" id="cifia" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>投资活动产生的现金流出量：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="cofia" id="cofia" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>投资活动产生的现金流量净额：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="ncffia" id="ncffia" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>筹资活动产生的现金流入量：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="ciffa" id="ciffa" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>筹资活动产生的现金流出量：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="coffa" id="coffa" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>筹资活动产生的现金流量净额：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="ncfffa" id="ncfffa" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;"><span>现金及现金等价物净增加额：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="niocce" id="niocce" style="width: 200px;"
							type="text" datatype="a3" nullmsg="请填写信息！" errormsg="请填写数字！ " placeholder="必须填写" sucmsg=" " /></td>
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
<script type="text/javascript" src="<%=basePath%>js/public/dateFormat.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/cashflow.js"></script>
</body>
</html>