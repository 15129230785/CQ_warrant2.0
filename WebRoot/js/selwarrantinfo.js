function getBankInfo() {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetBankName"
				+ "?rn=" + Math.random()
				+ "&active=0", false);
		xmlhttp.send();
		var banks = eval("(" + xmlhttp.responseText + ")");
		if (banks == null) {
			return null;
		} else {
			return banks.banks;
		}
	} else {
		return null;
	}
}

function getWarrantInfo(wid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetTblWarrantinfo" + "?rn=" + Math.random()
				+ "&wid=" + wid, false);
		xmlhttp.send();
		var data = eval("(" + xmlhttp.responseText + ")");
		if (data == null) {
			return null;
		} else {
			return data;
		}
	} else {
		return null;
	}
}

function showWarrantInfo(data, banks, id) {
	if (data == null || banks == null) {
		return;
	}
	var td = new Array();
	td.push('<table width="100%">');
	td.push('<tr>');
	td.push('<th width="15%">担保项目名称</th>');
	td.push('<td>' + data.name + '</td>');
	td.push('</tr>');

	td.push('<tr>');
	td.push('<th>开始申请时间</th>');
	td.push('<td>' + data.startDate + '</td>');
	td.push('</tr>');

	td.push('<tr>');
	td.push('<th>申请担保金额(万元)</th>');
	td.push('<td>' + data.practicalMoney + '</td>');
	td.push('</tr>');

	td.push('<tr>');
	td.push('<th>实际担保金额(万元)</th>');
	td.push('<td>' + data.money + '</td>');
	td.push('</tr>');

	td.push('<tr>');
	td.push('<th>保证金费率</th>');
	td.push('<td>' + data.rate + '</td>');
	td.push('</tr>');

	var bankname = "";
	td.push('<tr>');
	td.push('<th>贷款银行</th>');
	for (var i = 0; i < banks.length; i++) {
		if (banks[i].bid == data.bank) {
			bankname = banks[i].name;
			break;
		}
	}
	td.push('<td >' + bankname + '</td>');
	td.push('</tr>');

	td.push('<tr>');
	td.push('<th>贷款期限(月)</th>');
	td.push('<td>' + data.deadline + '</td>');
	td.push('</tr>');

	td.push('<tr>');
	td.push('<th>贷款用途</th>');
	td.push('<td>' + data.usages + '</td>');
	td.push('</tr>');

	td.push('<tr>');
	td.push('<th>项目简介</th>');
	td.push('<td>' + data.description + '</td>');
	td.push('</tr>');

	td.push('<tr>');
	td.push('<th>主要还款来源</th>');
	td.push('<td>' + data.paySource + '</td>');
	td.push('</tr>');

	td.push('<tr>');
	td.push('<th>项目还款计划</th>');
	td.push('<td>' + data.payPlan + '</td>');
	td.push('</tr>');
	
	if (data.paidMoney != null && data.paidMoney != "") {
		td.push('<tr>');
		td.push('<th>贷款已还金额(万元)</th>');
		td.push('<td>' + data.paidMoney + '</td>');
		td.push('</tr>');
	}

	if (data.fileSaveDate != null && data.fileSaveDate != "") {
		td.push('<tr>');
		td.push('<th>资料归档日期</th>');
		td.push('<td>' + data.fileSaveDate + '</td>');
		td.push('</tr>');
	}

	if (data.warrantStartDate != null && data.warrantStartDate != "") {
		td.push('<tr>');
		td.push('<th>担保开始时间</th>');
		td.push('<td>' + data.warrantStartDate + '</td>');
		td.push('</tr>');
	}

	if (data.warrantEndDate != null && data.warrantEndDate != "") {
		td.push('<tr>');
		td.push('<th>担保结束时间</th>');
		td.push('<td>' + data.warrantEndDate + '</td>');
		td.push('</tr>');
	}

	if (data.noticeDate != null && data.noticeDate != "") {
		td.push('<tr>');
		td.push('<th>通知还款时间</th>');
		td.push('<td>' + data.noticeDate + '</td>');
		td.push('</tr>');
	}

	if (data.warrantReleaseDate != null && data.warrantReleaseDate != "") {
		td.push('<tr>');
		td.push('<th>担保解除日期</th>');
		td.push('<td>' + data.warrantReleaseDate + '</td>');
		td.push('</tr>');
	}

	if (data.compensatory != null && data.compensatory != "") {
		td.push('<tr>');
		td.push('<th>是否代偿</th>');
		td.push('<td>' + ((data.compensatory == "1") ? "是" : "否") + '</td>');
		td.push('</tr>');
	}

	if (data.compensatoryMoney != null && data.compensatoryMoney != "") {
		td.push('<tr>');
		td.push('<th>代偿金额(万元)</th>');
		td.push('<td>' + data.compensatoryMoney + '</td>');
		td.push('</tr>');
	}

	if (data.persue != null && data.persue != "") {
		td.push('<tr>');
		td.push('<th>是否追偿</th>');
		td.push('<td>' + ((data.persue == "1") ? "是" : "否") + '</td>');
		td.push('</tr>');
	}

	if (data.lostMoney != null && data.lostMoney != "") {
		td.push('<tr>');
		td.push('<th>核销金额(万元)</th>');
		td.push('<td>' + data.lostMoney + '</td>');
		td.push('</tr>');
	}
	td.push('</table>');
	document.getElementById(id).innerHTML = td.join('');
}

var banks = null;
var warrantinfo = null;
var wid = "";
function showProjectInfo(id, pid) {
	var ret = pullDown(id);
	if (wid == "") {
		wid = $("#wid").val();
	}
	if (ret == true) {
		if (banks == null) {
			banks = getBankInfo();
		}
		if (warrantinfo == null) {
			warrantinfo = getWarrantInfo(wid);
		}
		showWarrantInfo(warrantinfo, banks, pid);
	}
}
