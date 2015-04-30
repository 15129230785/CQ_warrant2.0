<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String time = sdf.format(date);

	String taskId = request.getParameter("id");
	String wid = request.getParameter("wid");
	if (wid != null) {
		wid = wid.substring(wid.lastIndexOf("w"));
	}
	String username = (String) session.getAttribute("user");
	String taskname = null;
	String temp = request.getParameter("task");
	if (temp != null) {
		taskname = new String(temp.getBytes("ISO-8859-1"), "UTF-8");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/service.css" />
<title>评委会签</title>
</head>

<body>
	<div id="body">
		<a class="header" href="#" onclick="javascript:showProjectInfo('m05', 'projectInfo');">项目信息</a>
		<div class="L1" id="projectInfo"></div>
		<a class="header" href="#" onclick="javascript:showDocList('m01', 'docList');">资料完整性</a>
		<div class="L1" id="docList"></div>
		<a id="zlsc" class="header" href="#" onclick="javascript:showRDI('m03', 'reviewDataInfo');">资料审查</a>
		<div class="L1" id="reviewDataInfo"></div>
		<a class="header" href="#" onclick="javascript:showFSI('m07', 'fieldSurveyInfo');">现场调查结果</a>
		<div class="L1" id="fieldSurveyInfo"></div>
		<%-- <li style="display: none;" class="L1"><a href="javascript:showProblemList('<%=wid%>', 'm09', 'TblProblemtrackdiv');" id="m09">问题列表</a>
			<a onclick="addProblem('<%=wid%>', '<%=taskname%>')" style="color: #A5A5A5;">添加评审问题</a></li>
		<li>
			<ul id="m09d" style="display: none;">
				<li>
					<div id="TblProblemtrackdiv"></div>
				</li>
			</ul>
		</li> --%>
		<a class="header" href="#" onclick="javascript:showMAI('m013', 'manAuditInfo');">业务经理审核意见</a>
		<div class="L1" id="manAuditInfo"></div>
		<a id="fwsc" class="header" href="#" onclick="javascript:showLAI('m011', 'lawAuditInfo');">法务审查意见</a>
		<div class="L1" id="lawAuditInfo"></div>
		<a id="cwsc" class="header" href="#" onclick="javascript:showFEI('m015', 'financeEstInfo');">财务审查意见</a>
		<div class="L1" id="financeEstInfo"></div>
		<a class="header" href="#" onclick="javascript:showREI('m017', 'riskEstInfo');">风险审查意见</a>
		<div class="L1" id="riskEstInfo"></div>
		<a class="header" href="#" onclick="javascript:showRRI('m019', 'riskReviewInfo');">风控经理审核意见</a>
		<div class="L1" id="riskReviewInfo"></div>
	</div>
	<br />
	<form action="Countersign" method="post">
		<fieldset>
			<legend>评委会签</legend>
			<div class="L1">
				<table width="100%">
					<tr id="r">
						<th style="display: none;">担保项目编码</th>
						<th width="15%">会签人名称</th>
						<th width="15%">会签日期</th>
						<th width="15%">会签结论</th>
						<th>情况说明</th>
					</tr>
					<tr>
						<td style="display: none;"><%=taskId%></td>
						<td align="center"><%=username%></td>
						<td align="center"><%=time%></td>
						<td align="center"><select name="decisionList">
							<option value="0">通过</option>
							<option value="1">不通过</option>
							</select></td>
						<td><textarea name="cause" cols="40" rows="3"
								style="width: 100%; margin: 0; padding: 0; border: 0;"></textarea>
						</td>
					</tr>
				</table>
			</div>
		</fieldset>
		<br />
		<fieldset>
			<legend>项目提交</legend>
			<table>
				<tr style="display: none;">
					<td><input type="text" name="wid" id="wid" value="<%=wid%>" /></td>
					<td><input type="text" name="taskid" value="<%=taskId%>" /></td>
					<td><input type="text" id="num" value="countersign" /></td>
					<td><input type="text" id="username" value="<%=username%>" /></td>
					<td><input type="text" name="serviceType" id="serviceType" /></td>
				</tr>
				<tr>
					<td width="90px">处理方式：</td>
					<td><select name="sel" id="processid" style="width: 150px"
						onchange="chang(this.value)">
							<option value="nextLater">下一处理环节</option>
							<option value="transfer">委托他人处理</option>
					</select></td>
				</tr>
			</table>
			<table>
				<tr id="dis" style="display: none;">
					<td width="90px">指定处理人：</td>
					<td id="selOpe"></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交"
						style="width: 50px; height: 22px" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/rootPath.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selectPro.js"></script>
<script type="text/javascript" src="<%=basePath%>js/projectDocList.js"></script>
<script type="text/javascript" src="<%=basePath%>js/signInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/reviewDataInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/fieldSurveyInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/manAuditInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/lawAuditInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/financeEstInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/riskEstInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/problemInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/service/countersign.js"></script>
</body>
</html>
