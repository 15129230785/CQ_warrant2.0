function getFinanceestInfo(wid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetFinanceestInfo" + "?rn=" + Math.random() + "&wid="
				+ wid, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var pdl = eval("(" + data + ")");
		if (pdl==null) {
			return null;
		}
		return pdl.financeEstInfo;
	}
	return null;
}

function showFinanceestInfo(data, feInfo) {
	if (data == null || data.length == 0) {
		return;
	}
	
	var td = new Array();
	var size = data.length;
	td.push('<table width="100%">');
	
	td.push('<tr>');
	td.push('<th width="15%">审查人姓名</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].name + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>数据起止时间</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].startDate + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>总负债</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].debt + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>总资产</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].asset + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>净资产</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].netAsset + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>年末贷款余额</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].loanRemaining + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>流动资产</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].flowAsset + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>流动负债</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].flowDebt + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>销售现金流</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].saleCash + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>当年到期债务本息和</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].dueDebt + '</td>');
	}
	td.push('</tr>');
	
	/*td.push('<tr>');
	td.push('<th>销售额</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].saleMoney + '</td>');
	}
	td.push('</tr>');*/
	
	td.push('<tr>');
	td.push('<th>平均资产总额</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].meanAsset + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>净利润</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].netProfit + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>本年销售额</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].thisYearSale + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>上年销售额</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].lastYearSale + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>到期借款人测算现金流</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].dueCash + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>借款资金</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + data[i].loan + '</td>');
	}
	td.push('</tr>');
	
	td.push('</table>');
	
	document.getElementById(feInfo).innerHTML = td.join('');
	td = null;
}

