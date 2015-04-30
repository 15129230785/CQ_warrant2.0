function getLawauditInfo(wid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetLawauditInfo" + "?rn=" + Math.random() + "&wid="
				+ wid, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var pdl = eval("(" + data + ")");
		if (pdl == null) {
			return null;
		}
		return pdl.lawAuditInfo;
	}
	return null;
}

function showLawauditInfo(lal, laInfo) {
	if (lal == null || lal.length == 0) {
		return;
	}
	
	var td = new Array();
	var size = lal.length;
	td.push('<table id="shenc" width="100%">');
	
	td.push('<tr>');
	td.push('<th width="15%">审查人姓名</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + lal[i].name + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>法务审查时间</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + lal[i].startDate + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>担保资料合规性检查</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + lal[i].truth + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>反担保法律风险分析</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + lal[i].antiproperty + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>公司产权情况</th>');
	td.push('<td>' + lal[0].property + '</td>');
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>公司债务情况</th>');
	for (var i = 0; i < size; i++) {
	td.push('<td>' + lal[i].debt + '</td>');
	}
	td.push('</tr>');
	
	td.push('</table>');
	
	document.getElementById(laInfo).innerHTML = td.join('');
	td = null;
}



