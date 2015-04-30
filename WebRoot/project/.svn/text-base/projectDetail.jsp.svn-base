<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	String user = (String) session.getAttribute("user");
	String wid = request.getParameter("getWid");
	String temp = request.getParameter("activityName");
	String activityName = null;
	if (temp != null) {
		activityName = new String(temp.getBytes("ISO-8859-1"), "UTF-8");
	}
	String start = request.getParameter("start");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.css" />
<link rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<link rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link rel="stylesheet" href="<%=basePath%>css/service.css" />
<link rel="stylesheet" href="<%=basePath%>css/projectDetail.css" />
<title>担保项目详细信息</title>
</head>

<body>
	<input type="text" name="wid" id="wid" value="<%=wid%>" class="none" />
	<input type="text" name="serviceType" id="serviceType" class="none" />
	<div id="con">
		<ul>
			<li><a class="selectTag" href="#projectBasic">基本信息</a></li>
			<li><a href="#projectInfo">项目处理信息</a></li>
			<li><a href="#projectHistory">项目操作记录</a></li>
		</ul>
		<div class="tagContent" id="projectBasic">
			<a id="returnBack" style="cursor: pointer;" onclick="history.go(-1)">返回上页</a><br />
			<div id="basicInfo">
				<a class="header" href="#" onclick="javascript:showProjectInfo('ddd', 'prodetailsDiv');">项目具体信息</a>
				<div id="prodetailsDiv"></div>
				
				<a class="header" href="#" onclick="javascript:TblAntiwarrantAjax();">反担保措施</a>
				<div>
					<table width="100%">
						<tr>
							<td id="add"><a href="#" onclick="javascript:antiwarrant();">添加反担保措施</a></td>
						</tr>
						<tr>
							<td><div id="TblAntiwarrantdiv"></div></td>
						</tr>
					</table>
				</div>
				
				<a class="header" href="#" onclick="javascript:showFileList('projectdiv');">项目相关文档</a>
				<div>
					<iframe name="hideIframe" style="display: none;"></iframe>
					<form action="UploadFile" method="post"
						enctype="multipart/form-data" id="frmupload" target="hideIframe">
						<input style="display: none;" type="text" name="ment" id="dir" value="/project/<%=wid%>" />
						<table>
							<tr>
								<td>选择上传文件：<input type="file" name="upload" />
								<input value="上传" type="button" onclick="submitme()" /></td>
							</tr>
						</table>
					</form>
					<div id="projectdiv" class="L1"></div>
				</div>
			</div>
		</div>
		<div class="tagContent" id="projectInfo">
			<a class="header" href="#" onclick="javascript:showDocList('m01', 'docList');">资料完整性</a>
			<div class="L1" id="docList"></div>
			<a id="zsc" class="header" href="#" onclick="javascript:showRDI('m03', 'reviewDataInfo');">资料审查</a>
			<div class="L1" id="reviewDataInfo"></div>
			<a class="header" href="#" onclick="javascript:showFSI('m07', 'fieldSurveyInfo');">现场调查结果</a>
			<div class="L1" id="fieldSurveyInfo"></div>
			<a class="header" href="#" onclick="javascript:showMAI('m013', 'manAuditInfo');">业务经理审核意见</a>
			<div class="L1" id="manAuditInfo"></div>
			<a id="fyj" class="header" href="#" onclick="javascript:showLAI('m011', 'lawAuditInfo');">法务审查意见</a>
			<div class="L1" id="lawAuditInfo"></div>
			<a id="cyj" class="header" href="#" onclick="javascript:showFEI('m015', 'financeEstInfo');">财务审查意见</a>
			<div class="L1" id="financeEstInfo"></div>
			<a class="header" href="#" onclick="javascript:showREI('m017', 'riskEstInfo');">风险审查意见</a>
			<div class="L1" id="riskEstInfo"></div>
			<a class="header" href="#" onclick="javascript:showRRI('m019', 'riskReviewInfo');">风控经理审核意见</a>
			<div class="L1" id="riskReviewInfo"></div>
			<a class="header" href="#" onclick="javascript:showCounterSignInfo('m021', 'counterSignInfo');">评委会签意见</a>
			<div class="L1" id="counterSignInfo"></div>
			<a class="header" href="#" onclick="javascript:showDecisionResultinfo('m022', 'decisionResultInfo');">项目决策结果</a>
			<div class="L1" id="decisionResultInfo"></div>
			<a class="header" href="#" onclick="javascript:showTrackInfo('m023', 'trackRecordInfo');">项目跟踪记录</a>
			<div class="L1" id="trackRecordInfo"></div>
		</div>
		<div id="projectHistory" >
			<div id="phldiv"></div>
		</div>
	</div>
	<div id='alertDiv' title='信息'>
		<p id='alertTxt'></p>
	</div>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/rootPath.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/fileOperation.js"  charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>js/public/antiWarrantType.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/userRight.js"></script>
<script type="text/javascript" src="<%=basePath%>js/selwarrantinfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/antiwarrant.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>js/getsrvtype.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/pulldown.js"></script>
<script type="text/javascript" src="<%=basePath%>js/projectDocList.js"></script>
<script type="text/javascript" src="<%=basePath%>js/signInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/reviewDataInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/fieldSurveyInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/manAuditInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/lawAuditInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/financeEstInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/riskEstInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/problemInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/trackInfo.js"></script>
<script type="text/javascript" src="<%=basePath%>js/projectDetail.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>