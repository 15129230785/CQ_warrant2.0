<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>操作结果</title>
<%
	String idName = null;
	String tableType = (String) request.getAttribute("tableType");
	String tableName = (String) request.getAttribute("tableName");
	String id = (String) request.getAttribute("id");
	
	switch (Integer.parseInt(tableType)) {
	case 0:
		idName = "wid";
		break;
	case 1:
		idName = "eid";
		break;
	case 2:
		idName = "rid";
		break;
	case 3:
		idName = "id";
		break;
	default:
		break;
	}
%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/initXMLHTTP.js"></script>
<script type="text/javascript">
	function getTableInfo() {
		var inEnterprisediv = window.parent.opener.document
				.getElementById("<%=tableName%>div");
		var xmlhttp = initxmlhttp();
		
		xmlhttp.open("GET", "SelectAjax<%=tableName%>.action?rn="
				+ Math.random() + "&<%=idName%>=<%=id%>", false);
		xmlhttp.send(null);
		inEnterprisediv.innerHTML = xmlhttp.responseText;
		inEnterprisediv.style.display="";
		window.close();
	}

	setTimeout("getTableInfo()", 1000);
</script>
</head>
<body>
	操作成功
	<input type="text" value="<%=id%>" id="id" style="display: none;" />
</body>
</html>