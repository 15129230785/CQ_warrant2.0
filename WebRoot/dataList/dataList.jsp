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
<title>修改资料</title>
<style type="text/css">
body {
	font: normal 12px auto "Trebuchet MS", Verdana, Arial, Helvetica,
		sans-serif;
	color: #4f6b72;
	background: #E6EAE9;
}
#r {
	font: bold 14px/25px "宋体";
	color: #4f6b72;
	border: 1px solid #000;
	letter-spacing: 2px;
	text-align: center;
	background: #CAE8EA;
}
h1{font:bold 16px "宋体";color:#4f6b72;}
#d {
	font: bold 12px/25px "宋体";
	background: #F5FAFA;
	color: #797268;
	text-align: center;
}
#d a{color: green;text-decoration:none;}
#d a:hover{text-decoration:underline;}
</style>

<script type="text/javascript">
	addEvent = function() {
		var _li = document.getElementsByTagName("tr");
		for (var i = 0; i < _li.length; i++) {
			_li[i].onmouseover = function() {
				chColor(this, "#CAE8EA");
			};
			_li[i].onmouseout = function() {
				chColor(this, "");
			};
		}
	};
	chColor = function(obj, color) {
		obj.style.background = color;
	};
	window.onload = function() {
		showDataList(null, 0, "dataList");
		addEvent();
	};

	function onc(id) {
		showDataList(id, 0, "dataList");
	};
	function cli(num, da) {
		window.open("addList.jsp?rn=" + Math.random(),
			"Sample",
			"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=600,height=500,left=300,top=200");
	};
	function del(num, da) {
		updateComdocList(num, "1");
		showDataList(da, 0, "dataList");
	};
	function hsz() {
		showDataList(null, 1, "dataList");
	};
	function res(num) {
		updateComdocList(num, "0");
		showDataList(null, 1, "dataList");
	};
	function inquire() {
		var datatype = document.getElementById("select").value;
		onc(datatype);
	};
</script>
</head>
<body>
	<div style="top: 5px; position: absolute;">
		<select name="select" id="select" onchange="onc(this.value)">
			<option style="display: none;" value=""></option>
			<option value="0">企业资料清单</option>
			<option value="1">个人资料清单</option>
		</select>
		<input type="button" onclick="inquire()" value="查询" />
		<input type="button" id="addBtn" onclick="cli()" value="添加" />
		<input type="button" onclick="hsz()" value="回收站" />
	</div>
	<br />
	<div id="dataList">
	</div>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/dataListManage.js"></script>
</body>
</html>