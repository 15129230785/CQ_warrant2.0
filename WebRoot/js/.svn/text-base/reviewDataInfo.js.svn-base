function getReviewDataInfo(wid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetReviewDataInfo" + "?rn=" + Math.random() + "&wid="
				+ wid, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var rdl = eval("(" + data + ")");
		if(rdl == null) {
			return null;
		}
		return rdl.reviewDataInfo;
	}
	return null;
}

function showReviewDataInfo(rdl, rdInfo) {
	if (rdl == null || rdl.length == 0) {
		return;
	}
	var td = new Array();
	var size = rdl.length;
	td.push('<table id="zsl" width="100%">');
	
	td.push('<tr>');
	td.push('<th width="15%">检查人姓名</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.name + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>检查起始时间</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.startDate + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr style="display: none;">');
	td.push('<th>检查结束时间</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.endDate + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>账户信息</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.account + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>销售收入</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.revenue + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>资产保险</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.assets + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>抵押</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.mortgage + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>机器设备所有权</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.ownership + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>对外负债</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.debt + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>对外担保</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.warrant + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>对外承兑汇票</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.acceptance + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>对外信用证</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.credit + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>企业资产真实价值</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.assetValue + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>财务预测信息</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.forecasting + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>同业调查结果</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.peerSurvey + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>总体情况说明</th>');
	for (var i = 0; i < size; i++) {
		var rd = rdl[i];
		td.push('<td>' + rd.explains + '</td>');
	}
	td.push('</tr>');
	
	td.push('</table>');
	document.getElementById(rdInfo).innerHTML = td.join('');
	td = null;
}



