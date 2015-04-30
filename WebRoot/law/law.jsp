<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
	
	String taskId = request.getParameter("id");
	String taskName = request.getParameter("taskname");
	String username = (String) session.getAttribute("user");
	String wid = request.getParameter("wid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/service.css" />
<title>法务审查</title>
</head>

<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
	</div>
	<br />
	<form action="Law" method="post" class="idform" id="law">
		<fieldset>
			<legend>审查指标</legend>
			<table width="97%">
				<tr>
					<td colspan="2">担保资料合规性检查：(<i>检查资料的完整性、合法性；审查重要证件、合同的真实性、合法性；企业所处行业相关资质、证书是否齐全</i>)</td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="truth"
						datatype="*" nullmsg="请填写担保项目真实性信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">反担保法律风险分析：(<i>反担保物产权归属关系是否明细、处置难易程度；第三方担保主体资格审查，反担保能力分析</i>)</td>
				</tr>
				<tr>
					<td colspan="2"><textarea rows="3" cols="31"
						name="antiproperty" datatype="*" nullmsg="请填写反担保产权关系信息"
						errormsg="填写信息不合法 " sucmsg=" " placeholder="必须填写"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">公司产权情况：(<i>分析公司产权情况是否清晰，有无产权纠纷导致的法律风险</i>)</td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="property"
						datatype="*" nullmsg="请填写公司产权情况信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">公司债务情况：(<i>分析公司重要合同履行、生产经营活动等过程中，是否会给公司带来潜在的债务风险，对担保还款带来影响</i>)</td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="debt"
						datatype="*" nullmsg="请填写公司债务情况信息" errormsg="填写信息不合法 " sucmsg=" "
						placeholder="必须填写"></textarea></td>
				</tr>
				
			</table>
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
			<table>
				<tr style="display: none;">
					<td><input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
					<td><input type="text" name="taskid" value="<%=taskId%>" /></td>
					<td><input type="text" name="taskname" value="<%=taskName%>" /></td>
					<td><input type="text" id="num" value="law" /></td>
					<td><input type="text" name="serviceType" id="serviceType" /></td>
					<td><input type="text" id="username" value="<%=username%>" /></td>
				</tr>
				<tr>
					<td style="width:90px">处理方式：</td>
					<td><select name="sel" id="processid" onchange="cl(this.value)"
						style="width: 150px">
							<option value="nextLater">下一处理环节</option>
							<option value="transfer">委托他人处理</option>
					</select></td>
				</tr>
			</table>
			<table style="margin:0 0 0 0px;">
				<tr id="cl" style="display: none;">
					<td style="width:90px">指定处理人：</td>
					<td id="selOpe"></td>
				</tr>
				<tr>
	 				<td id="tdsum" style="display: block;"><input type="submit" name="result" value="提交" 
	 					style="width: 50px; height: 22px" /></td>
					<td id="tdbut" style="display: none;"><input type="button" onclick="tijiao()" name="result" value="提交"
						style="width: 50px; height: 22px" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<div id='alertDiv' title='信息'>
		<p id='alertTxt'></p>
	</div>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/lawForm.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/law.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>