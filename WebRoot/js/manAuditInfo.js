function getManauditInfo(wid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetManauditInfo" + "?rn=" + Math.random() + "&wid="
				+ wid, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var pdl = eval("(" + data + ")");
		if (pdl == null) {
			return null;
		}
		return pdl.manAuditInfo;
	}
	return null;
}

function showManauditInfo(mal, maInfo) {
	if (mal == null || mal.length == 0) {
		return;
	}
	
	var td = new Array();
	var size = mal.length;
	td.push('<table width="100%">');
	
	td.push('<tr>');
	td.push('<th width="15%" align="center">审核人名称</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + mal[i].name + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>审核时间</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + mal[i].date + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>审核意见</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + mal[i].result + '</td>');
	}
	td.push('</tr>');
	
	td.push('</table>');
	
	document.getElementById(maInfo).innerHTML = td.join('');
	td = null;
}



