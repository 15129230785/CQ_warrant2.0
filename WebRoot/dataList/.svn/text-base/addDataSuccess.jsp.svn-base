<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业分支机构信息操作结果</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
</head>

<script type="text/javascript">
	function showDataListTemp(datatype, flag, dataList) {
		var list = "";
		var select = 0;
		var td = new Array();
		if (flag == 1) {
			select = 0;
			list += "回收站中的资料清单";
		} else if (datatype == null || datatype == "") {
			list += "全部资料清单";
			select = 1;
		} else if (datatype == "0") {
			list += "企业资料清单";
			select = 2;
		} else if (datatype == "1") {
			list += "个人资料清单";
			select = 3;
		} else {
			return;
		}
	
		var ccl = getDataList();
		if (ccl == null || ccl.length == 0) {
			return;
		}
	
		td.push('<center><h1>' + list + '</h1></center>');
		td.push('<table width="100%" border="0" align="center">');
		td.push('<tr align="center" id="r">');
		td.push('<td width="10%" align="center">资料编码</td>');
		td.push('<td align="center">资料名称</td>');
		td.push('<td align="center">资料描述</td>');
		td.push('<td align="center">操作</td>');
		td.push('</tr>');
	
		switch (select) {
		case 0:
			td.push(showRecyleDataList(ccl));
			break;
		case 2:
			td.push(showCompanyDataList(ccl));
			break;
		case 3:
			td.push(showPersonDataList(ccl));
			break;
		case 1:
		default:
			td.push(showCompanyDataList(ccl));
			td.push(showPersonDataList(ccl));
			break;
		}
		td.push('</table>');
		
		var inEnterprisediv = window.parent.opener.document
			.getElementById("dataList");
		
		inEnterprisediv.innerHTML = td.join('');
		inEnterprisediv.style.display = "";
		window.close();
	}
	
	function init() {
		showDataListTemp(null, 0, "dataList");
	};
	
	setTimeout("init()", 1000);
</script>
<body>
	操作成功
	
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/dataListManage.js"></script>
</body>
</html>