function getFieldSurveyInfo(wid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetFieldSurveyInfo" + "?rn=" + Math.random() + "&wid="
				+ wid, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var pdl = eval("(" + data + ")");
		if (pdl == null) {
			return null;
		}
		return pdl.fieldSurveyInfo;
	}
	return null;
}

function showFieldSurveyInfo(fsl, fsInfo, st) {
	if (fsl == null || fsl.length == 0) {
		return;
	}
	
	var td = new Array();
	var size = fsl.length;

	td.push('<table width="100%">');
	td.push('<tr>');
	td.push('<th width="15%">调查人姓名</th>');
	for (var i = 0; i < size; i++) {
		var fs = fsl[i];
		td.push('<td>' + fs.name + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>项目调查时间</th>');
	for (var i = 0; i < size; i++) {
		var fs = fsl[i];
		td.push('<td>' + fs.startDate + '</td>');
	}
	td.push('</tr>');
	
	if (st != "1") {
		td.push('<tr>');
		td.push('<th>企业概况</th>');
		for (var i = 0; i < size; i++) {
			var fs = fsl[i];
			td.push('<td>' + fs.equipment + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>现场经营情况</th>');
		for (var i = 0; i < size; i++) {
			var fs = fsl[i];
			td.push('<td>' + fs.manage + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>能源消耗情况</th>');
		for (var i = 0; i < size; i++) {
			var fs = fsl[i];
			td.push('<td>' + fs.staff + '</td>');
		}
		td.push('</tr>');
	}
	
	td.push('<tr>');
	td.push('<th>贷款用途分析</th>');
	for (var i = 0; i < size; i++) {
		var fs = fsl[i];
		td.push('<td>' + fs.loausanalysis + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>信用状况</th>');
	for (var i = 0; i < size; i++) {
		var fs = fsl[i];
		td.push('<td>' + fs.workplace + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>反担保措施</th>');
	for (var i = 0; i < size; i++) {
		var fs = fsl[i];
		td.push('<td>' + fs.counterGuarantee + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>还款能力分析</th>');
	for (var i = 0; i < size; i++) {
		var fs = fsl[i];
		td.push('<td>' + fs.product + '</td>');
	}
	td.push('</tr>');
	td.push('</table>');
	
	document.getElementById(fsInfo).innerHTML = td.join('');
	td = null;
}



