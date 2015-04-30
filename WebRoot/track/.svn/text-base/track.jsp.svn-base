<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
	
	Date da = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
	String time = sdf.format(da);
	String taskId = request.getParameter("id");
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
<title>项目跟踪</title>
</head>

<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
		<a class="header" href="#" onclick="javascript:showTrackInfo('m023', 'trackInfo');">项目跟踪记录</a>
		<div class="L1" id="trackInfo"></div>
	</div>
	<br />
	<form action="Track" id="track" method="post" class="idform">
		<fieldset>
			<legend>项目跟踪情况</legend>
			<table width="100%">
				<tr style="display: none;">
					<td>跟踪日期：</td>
					<td><input name="textfield5" type="text" size="37"
						value="<%=time%>" /></td>
				</tr>
				<tr>
					<td width="130">项目运作：</td>
				</tr>
				<tr>
					<td><textarea name="work" altercss="gray" datatype="*"
						placeholder="请在这里输入。" errormsg="请填写项目运作信息" sucmsg=" "></textarea></td>
				</tr>
				<tr>
					<td>资金使用：</td>
				</tr>
				<tr>
					<td><textarea name="fund" altercss="gray"
						placeholder="请在这里输入。" datatype="*" errormsg="请填写资金使用情况"
						sucmsg=" "></textarea></td>
				</tr>
			</table>
			<div id="companytrack"><table width="100%">
				<tr>
					<td>企业财务：</td>
				</tr>
				<tr>
					<td>
						<textarea name="finance" altercss="gray" id="finance"
							placeholder="请在这里输入。" datatype="*" errormsg="请填写企业财务信息"
							sucmsg=" "></textarea>
					</td>
				</tr>
				<tr>
					<td>企业重大变化事项：</td>
				</tr>
				<tr>
					<td id="t2">
						<textarea name="matter" altercss="gray" id="matter"
							placeholder="请在这里输入。"datatype="*" errormsg="企业重大变化事项"
							sucmsg=" "></textarea>
					</td>
				</tr>
			</table></div>
			<table width="100%">
				<tr>
					<td>反担保物：</td>
				</tr>
				<tr>
					<td><textarea name="antiwarrant" altercss="gray"
						placeholder="请在这里输入。" datatype="*" errormsg="请填写反担保物信息"
						sucmsg=" "></textarea></td>
				</tr>
				
				<tr>
					<td>项目跟踪结论：</td>
				</tr>
				<tr>
					<td><textarea name="conclusion" altercss="gray"
						placeholder="请在这里输入。" datatype="*" errormsg="请填写项目跟踪结论"
						sucmsg=" "></textarea></td>
				</tr>
				<tr>
					<td>存在问题：</td>
				</tr>
				<tr>
					<td><textarea name="issue" altercss="gray"
						placeholder="请在这里输入。" datatype="*" errormsg="请填写存在问题" sucmsg=" "></textarea></td>
				</tr>
			</table>
			<div id="warrantDiv"></div>
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
			<table>
				<tr style="display: none;">
					<td><input type="text" name="taskid" value="<%=taskId %>" /></td>
					<td><input type="text" id="num" value="track" /></td>
					<td><input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
					<td><input type="text" name="serviceType" id="serviceType" /></td>
					<td><input type="text" id="username" value="<%=username %>" /></td>
				</tr>
				<tr>
					<td>处理方式：</td>
					<td><select name="sel" id="processid" onclick="chi()" style="width: 150px">
						<option value="nextLater">下一处理环节</option>
						<option value="transfer">委托他人处理</option>
					</select></td>
				</tr>
				<tr>
					<td>指定处理人：</td>
					<td id="selOpe"></td>
				</tr>
				<tr>
					<td id="sub" style="display: block;"><input type="submit"
						name="result" value="提交" style="width: 50px; height: 22px" /></td>
					<td id="but" style="display: none;"><input type="button"
						onclick="tijiao()" name="result" value="提交"
						style="width: 50px; height: 22px" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/lawForm.js"></script>
<script type="text/javascript" src="<%=basePath%>js/trackInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/track.js"></script>
</body>
</html>