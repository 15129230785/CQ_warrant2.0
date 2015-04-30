var wid = "";
var banks = null;
var warrantinfo = null;
$(function() {
	wid = $("#wid").val();
	var st = getServiceType(wid);
	$("#serviceType").val(st);
	init(wid);
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function chi(id) {
	if (id == "nextLater") {
		document.getElementById("sub").style.display = "block";
		document.getElementById("but").style.display = "none";
		document.getElementById("zhiding").style.display = "none";
	} else if (id == "transfer") {
		document.getElementById("sub").style.display = "none";
		document.getElementById("but").style.display = "block";
		document.getElementById("zhiding").style.display = "block";
	}
}
function tijiao() {
	document.getElementById("loss").submit();
}

var persue = null;
function init(wid) {
	warrantinfo = getWarrantInfo(wid);
	showPersueInfo(wid, "persueList");
}

function showMyProjectInfo(id, pid) {
	var ret = pullDown(id);

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

function getPersueInfo(wid) {
	var data = null;
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetPersueInfo" + "?rn=" + Math.random() + "&wid="
				+ wid, false);
		xmlhttp.send();
		data = xmlhttp.responseText;
		var pl = eval("(" + data + ")");
		if (pl == null) {
			return null;
		}
		persue = pl.persueList;
	}
}

function showPersueInfo(wid, persueList) {
	getPersueInfo(wid);
	var db = 0.0, zm = 0.0, loss = 0.0;
	var td = new Array();
	td.push('<table width="100%">');
	td.push('<tr>');
	td.push('<td>担保金额(元)</td>');
	td.push('<td>' + warrantinfo.money * 10000 + '</td>');
	td.push('</tr>');
	td.push('<tr>');
	td.push('<td>代偿金额(元)</td>');
	td.push('<td>' + warrantinfo.compensatoryMoney * 10000 + '</td>');
	td.push('</tr>');
	if (warrantinfo.persue == '1') {
		td.push('<tr>');
		td.push('<td>需追偿本金(元):</td>');
		td.push('<td>' + persue[0].money + '</td>');
		td.push('</tr>');
		td.push('<tr>');
		td.push('<td>需追偿利息(元):</td>');
		td.push('<td>' + persue[0].interest + '</td>');
		td.push('</tr>');
		td.push('<tr>');
		td.push('<td>需追偿罚息(元):</td>');
		td.push('<td>' + persue[0].latecharge + '</td>');
		td.push('</tr>');
		td.push('<tr>');
		td.push('<td>需追偿违约金(元):</td>');
		td.push('<td>' + persue[0].procedured + '</td>');
		td.push('</tr>');
		td.push('<tr>');
		td.push('<td>需追偿执行费用(元):</td>');
		td.push('<td>' + persue[0].execute + '</td>');
		td.push('</tr>');
		td.push('<tr>');
		td.push('<td>需追偿其它费用(元):</td>');
		td.push('<td>' + persue[0].other + '</td>');
		td.push('</tr>');

		for (var n = 0; n < persue.length; n++) {
			db = db + Number(persue[n].trueMoney);
		}
		zm = Number(persue[0].money) + Number(persue[0].interest)
			+ Number(persue[0].latecharge) + Number(persue[0].procedured)
			+ Number(persue[0].execute) + Number(persue[0].other);
		loss = zm - db;
		td.push('<tr>');
		td.push('<td>追偿到总费用(元):</td>');
		td.push('<td>' + db.toFixed(2) + '</td>');
		td.push('</tr>');
	} else if (warrantinfo.persue == '0') {
		td.push('<tr>');
		td.push('<td>代偿本金(元):</td>');
		td.push('<td>' + persue[0].money + '</td>');
		td.push('</tr>');
		td.push('<tr>');
		td.push('<td>代偿利息(元):</td>');
		td.push('<td>' + persue[0].interest + '</td>');
		td.push('</tr>');
		td.push('<tr>');
		td.push('<td>代偿罚息(元):</td>');
		td.push('<td>' + persue[0].latecharge + '</td>');
		td.push('</tr>');
		td.push('<tr>');
		td.push('<td>代偿违约金(元):</td>');
		td.push('<td>' + persue[0].procedured + '</td>');
		td.push('</tr>');
		td.push('<tr>');
		td.push('<td>代偿执行费用(元):</td>');
		td.push('<td>' + persue[0].execute + '</td>');
		td.push('</tr>');
		td.push('<tr>');
		td.push('<td>代偿其它费用(元):</td>');
		td.push('<td>' + persue[0].other + '</td>');
		td.push('</tr>');

		loss = warrantinfo.compensatoryMoney * 10000 - presue[0].trueMoney;
	}
	td.push('<tr>');
	td.push('<td>核销金额(元)</td>');
	td.push('<td><input type="text" name="LostMoney"'
		+ 'value=' + loss.toFixed(2) + '></td>');
	td.push('</tr>');
	td.push('</table>');
	document.getElementById(persueList).innerHTML = td.join('');
	td = null;
}
