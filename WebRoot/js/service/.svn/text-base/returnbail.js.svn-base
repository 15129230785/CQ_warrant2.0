var wid = null;
var banks = null;
var warrantinfo = null;
$(function() {
	wid = $("#wid").val();
	var st = getServiceType(wid);
	$("#serviceType").val(st);
	
	warrantinfo = getWarrantInfo(wid);
	if (warrantinfo) {
		document.getElementById("returnMoney").value = warrantinfo.money;
	}
	showChargeInfo(wid, "bailMoney");
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

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

function thisSel() {
	if (document.getElementById("processid").value == "nextLater") {
		document.getElementById("zd").style.display = "none";
	} else {
		document.getElementById("zd").style.display = "block";
	}
}

function tijiao() {
	if (document.getElementById("processid").value == "transfer") {
		document.getElementById("returnBail").submit();
		return;
	}
	if (document.getElementById("check").checked) {
		document.getElementById("returnBail").submit();
	} else {
		alert("对不起，保证金未退还，不能提交");
		return;
	}
}

function showChargeInfo(wid, chargeInfo) {
	var ci = getChargeInfo(wid);
	var size = ci.length;
	
	if (size > 0) {
		document.getElementById(chargeInfo).value = ci[0];
	}
	return;
}

