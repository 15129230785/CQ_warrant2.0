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
<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery-ui-1.11.2/jquery-ui.css" />
<link rel="stylesheet" href="<%=basePath%>css/operlog.css" />

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
		showOperUserList("Operlogname");
		addEvent();
	};

</script>
<title>查询日志记录</title>
</head>

<body>
	<form method="post" name="form1" action="GetOperlogList">
		名称：<select id="Operlogname" name="userName" style="width: 10%"></select>
		开始时间：<input type="text" id="startDate" name="startDate"
			style="width: 10%"
			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')||\'2050-10-01\'}'})"
			value=" " /> 结束时间： <input type="text" id="endDate" name="endDate"
			style="width: 10%"
			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}',maxDate:'2050-10-01'})"
			value="" /> 操作类型：<select id="opMode" name="opMode"
			style="width: 10%">
			<option value=""></option>
			<option value="1">登录</option>
			<option value="2">添加数据</option>
			<option value="3">修改数据</option>
			<option value="4">删除数据</option>
			<option value="5">文件操作</option>
		</select><input type="button" onclick="showFirstPage('operloglist')"
			value="查询" />
	</form>
	<div id="operloglist"></div>
	<div id="paging" style="display: none;" align="right">
		共<span id="countPage"></span>页,当前第<span id="current"></span>页
		<input type="button" onclick="showFirstPage('operloglist')" value="首页" id="firstPage" />
		<input type="button" onclick="showUpPage('operloglist')" value="上一页" />
		<input type="text" style="width: 30px" name="currentRecord" id="currentRecord" /><button onclick="jumpPage('operloglist')">跳往</button>
		<input type="button" onclick="showNextPage('operloglist')" value="下一页" />
		<input type="button" onclick="showEndPage('operloglist')" value="末页" />
	</div>
	<div id='alertDiv' title='信息'>
		<p id='alertTxt'></p>
	</div>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/rootPath.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/operlog.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/alert.js"></script>
</body>
</html>