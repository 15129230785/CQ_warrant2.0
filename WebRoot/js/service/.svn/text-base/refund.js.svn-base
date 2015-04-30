var wid = "";
$(function() {
	wid = $("#wid").val();
	var st = getServiceType(wid);
	$("#serviceType").val(st);
	showChargeInfo(wid, "money");
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function thisSel() {
	if (document.getElementById("processid").value == "nextLater") {
		document.getElementById("zd").style.display = "none";
	} else {
		document.getElementById("zd").style.display = "block";
	}
}

var xtje = 0;
function showChargeInfo(wid, chargeInfo) {
	var ci = getChargeInfo(wid);
	var size = ci.length;
	
	if (size > 0) {
		document.getElementById(chargeInfo).value = ci[5];
		xtje = ci[5];
	}
	return;
}

function m() {
	if (document.getElementById("processid").value != "transfer") {
		if (document.getElementById("check").checked) {
			
		} else {
			alert("对不起，评审费未退还，不能提交");
			return;
		}
	}
	
	var mon = document.getElementById("money").value;
	
	if (document.getElementById("processid").value == "transfer") {
		document.getElementById("refund").submit();
		return;
	}
	
	if (mon > xtje) {
		alert("对不起，需退的评审费不能超过原交的评审费");
		return;
	} else {
		document.getElementById("refund").submit();
	}
}
