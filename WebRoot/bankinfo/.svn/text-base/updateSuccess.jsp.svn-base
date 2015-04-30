<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>银行信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/initXMLHTTP.js"></script>
<script type="text/javascript">
	var xmlhttp = null;
	
	function init() {
		xmlhttp = initxmlhttp();
		setTimeout("bankinfoupdateclose()", 1000);
	}
	
	function bankinfoupdateclose() {
		var fdbdiv = window.parent.opener.document.getElementById("bankinfodiv");
		xmlhttp.open("GET", "listBankinfo.action" + "?rn=" + Math.random(), false);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4)//&& xmlhttp.status==200
			{
				//alert(xmlhttp.responseText);
				fdbdiv.innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.send();
		window.close();
	}
</script>
</head>
<body onload="init();">
	操作成功
</body>
</html>