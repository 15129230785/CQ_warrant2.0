var warrantRate = 0.0;
var wid = "";
var banks = null;
var warrantinfo = null;

$(function() {
	wid = $("#wid").val();
	getServiceType(wid);
	banks = getBankInfo();
	warrantinfo = getWarrantInfo(wid);
	showNoticeInfo(warrantinfo);
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function showNoticeInfo(wd) {
	if (wd) {
		var td = new Array();
		td.push('<table width="98%" border="0">');
		td.push('<tr>');
		td.push('<td width="150">担保项目名称：</td>');
		td.push('<td>' + wd.name + '</td>');
		td.push('</tr>');

		td.push('<tr>');
		td.push('<td>实际担保金额(万)：</td>');
		td.push('<td>' + wd.money + '</td>');
		td.push('</tr>');

		td.push('<tr>');
		td.push('<td>担保金费率(%)：</td>');
		td.push('<td >' + wd.rate + '</td>');
		td.push('</tr>');

		var bankname = "";
		td.push('<tr>');
		td.push('<td>贷款银行：</td>');
		for (var i = 0; i < banks.length; i++) {
			if (banks[i].bid == wd.bank) {
				bankname = banks[i].name;
				break;
			}
		}
		td.push('<td >' + bankname + '</td>');
		td.push('</tr>');
		
		td.push('</table>');
		document.getElementById("payNotice").innerHTML = td.join('');
	}
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


