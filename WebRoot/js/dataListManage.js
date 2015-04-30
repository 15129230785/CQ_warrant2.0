function updateComdocList(num, delflag) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "UpdateComdocList" + "?rn=" + Math.random()
				+ "&DID=" + num + "&renew=" + delflag, false);
		xmlhttp.send();
	}
}

function getDataList() {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetComdocList" + "?rn=" + Math.random(), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var ul = eval("(" + data + ")");
		return ul.comdocList;
	}
	return null;
}

// datatype --企业/个人
// flag -- 正常/回收站
function showDataList(datatype, flag, dataList) {
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
	document.getElementById(dataList).innerHTML = td.join('');
	td = null;
}

function showRecyleDataList(ccl) {
	var td = new Array();
	for (var ri = 0; ri < ccl.length; ri++) {
		if (ccl[ri].collectTime == "1") {
			td.push('<tr id="d">');
			td.push('<td>' + ccl[ri].DID + '</td>');
			td.push('<td>' + ccl[ri].name + '</td>');
			td.push('<td>' + ccl[ri].description + '</td>');
			td.push('<td><input type="button" onclick="res(\'' + ccl[ri].DID
					+ '\')" value="恢复" /></td>');
			td.push('</tr>');
		}
	}
	return td.join('');
}

function showCompanyDataList(ccl) {
	var td = new Array();
	//var datatype = document.getElementById("select").value;
	for (var ri = 0; ri < ccl.length; ri++) {
		if ((ccl[ri].FILE == "0") && (ccl[ri].collectTime == "0")) {
			td.push('<tr id="d">');
			td.push('<td>' + ccl[ri].DID + '</td>');
			td.push('<td>' + ccl[ri].name + '</td>');
			td.push('<td>' + ccl[ri].description + '</td>');
			td.push('<td><input type="button" onclick="del(\'' + ccl[ri].DID
					+ '\', \'' + 0 + '\')" value="删除" /></td>');
			td.push('</tr>');
		}
	}
	return td.join('');
}

function showPersonDataList(ccl) {
	var td = new Array();

	//var datatype = document.getElementById("select").value;
	for (var ri = 0; ri < ccl.length; ri++) {
		if ((ccl[ri].FILE == "1") && (ccl[ri].collectTime == "0")) {
			td.push('<tr id="d">');
			td.push('<td>' + ccl[ri].DID + '</td>');
			td.push('<td>' + ccl[ri].name + '</td>');
			td.push('<td>' + ccl[ri].description + '</td>');
			td.push('<td><input type="button" onclick="del(\'' + ccl[ri].DID
					+ '\', \'' + 1 + '\')" value="删除" /></td>');
			td.push('</tr>');
		}
	}
	return td.join('');
}
