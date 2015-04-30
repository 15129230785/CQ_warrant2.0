<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery-ui-1.11.2/jquery-ui.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/tooltip.js"></script>
<title></title>
</head>
<style type="text/css">
*{padding:0;margin:0;}
body{background:#95cbfd;} 
img:first-child{padding:10px 0 0 10px;display:inline;float:left;}
img{padding:20px 0 0 10px;display:inline;float:left;}
.h1{font:bold 30px "宋体";padding:16px 0 0 0;margin:0;}
.h1 span{float:right;padding:0 45px 0 0;font:normal 12px "宋体";color:#46505a;}
.h1 a{font:normal 12px "宋体";color:#46505a;text-decoration:none;}
.h1 a:hover{text-decoration:underline;}
#nav{text-align:center;padding:50px 0 0;}
#nav ul{margin:0;padding:0;}
#nav li{display:inline;list-style-type:disc;}
#nav li a{text-decoration:none;font:normal 18px "宋体";color:#46505a;}
#nav li a:hover{text-decoration:none;color:red;}
</style>

<script type="text/javascript">
$(function() {
	$("#mymenu li a").button();
});

function cli(id,qt) {
	window.open ("user/userUpdate.jsp?id="+id+"&qt="+qt + "rn=" + Math.random(),
		"Sample",
		"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=600,height=500,left=300,top=200");
}
</script>

<body>
<img src="${pageContext.request.contextPath}/tabs/images/logoImg.png" />	
<img src="${pageContext.request.contextPath}/tabs/images/logo.png" />	
<h1 class="h1"><span>欢迎：<a href="#" onclick="cli('${user}','userInfo')" style="font:normal 18px 'Trebuchet MS', Verdana, Arial, Helvetica,sans-serif;color:#ff0000;padding:0 10px 0 0;">${user}</a><a href="${pageContext.request.contextPath}/newLogin.jsp" target="_top">退出</a></span></h1>
	<div id="nav">
		<ul id="mymenu">
			<li title="鼠标单击这里刷新我的任务"><a href="${pageContext.request.contextPath}/frame_b.jsp" target="b" id="gz">工作台</a></li>
			<li><a href="${pageContext.request.contextPath}/frame_e.jsp" target="b">业务管理</a></li>
			<li><a href="${pageContext.request.contextPath}/frame_f.jsp" target="b">业务查询分析</a></li>
			<li><a href="${pageContext.request.contextPath}/frame_d.jsp?id=${user}" target="b" name="xt">系统管理</a></li>
			<li><a href="${pageContext.request.contextPath}/aboutus.jsp" target="c">关于我们</a></li>
		</ul>
	</div>
</body>
</html>