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
<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery-ui-1.11.2/jquery-ui.css">
<link rel="stylesheet" href="<%=basePath%>css/fileList.css" />
<title>文件下载</title>
</head>

<body>
	<div>
		<iframe name="UploadFileIframe" style="display: none;"></iframe>
		<form action="UploadFile" method="post" id="uploadFile" target="UploadFileIframe" enctype="multipart/form-data">
			<input type="text" name="ment" id="dir" value="/total" style="display: none;" />
			选择上传文件：<input type="file" name="upload" />
			<input value="上传" onclick="tijiao()" type="button" />
		</form>
	</div>
	<div id="filelistdiv"></div>
	<div id='alertDiv' title='信息'>
		<p id='alertTxt'></p>
	</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/fileOperation.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>js/downloadFile.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>