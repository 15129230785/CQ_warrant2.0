var wid = "";
var banks = null;
var warrantinfo = null;

$(function() {
	var wid = $("#wid").val();
	var st = getServiceType(wid);
	$("#serviceType").val(st);
	
	warrantinfo = getWarrantInfo(wid);
	if (warrantinfo) {
		var reviewMoney = warrantinfo.practicalMoney * 20;
		if (reviewMoney < 1000)
			reviewMoney = 1000;
		document.getElementById("money").value = reviewMoney.toFixed(2);
	}
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function sub() {
	if (transfer() == true) {
		$("#fr").submit();
		return;
	}
	var money = $("#money").val();
	if (testDecimal(money) == true) {
		$("#fr").submit();
	} else if (money == null || money == "") {
		alert("对不起，您未输入评审费用");
		return;
	} else {
		alert("请在评审费用处输入最多带两位小数的数字");
		return;
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

