var wid = "";

$(function() {
	wid = $("#wid").val();
	var service = getServiceType(wid);
	$("#serviceType").val(service);
	
	if (service == "1") {
		$("#companyfsi").hide();
		$("#equipment").val("1");
		$("#manage").val("1");
		$("#staff").val("1");
		$("#personfsi").show();
	} else {
		$("#personfsi").show();
		$("#companyfsi").show();
	}
	
	showChargeInfo(wid, "refundMoney");
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

var xtje = 0;
function showChargeInfo(wid, chargeInfo) {
	var ci = getChargeInfo(wid);
	var size = ci.length;
	
	if (size > 0) {
		document.getElementById(chargeInfo).value = ci[2];
		xtje = ci[2];
	}
	return;
}

function chi(id) {		
	if (id == "stop") {
		document.getElementById("tr").style.display = "block";
	} else if (id == "refund") {
		document.getElementById("tr").style.display = "block";
		document.getElementById("refund").style.display = "block";
	} else {
		document.getElementById("tr").style.display = "none";
		document.getElementById("refund").style.display = "none";
	}
	if (id == "nextLater") {
		document.getElementById("sum").style.display = "block";
		document.getElementById("but").style.display = "none";
	} else {
		document.getElementById("sum").style.display = "none";
		document.getElementById("but").style.display = "block";
	}
	if (id == "stop") {
		document.getElementById("sel").style.display = "none";
	} else {
		document.getElementById("sel").style.display = "block";
	}
}

function tijiao() {
	var username = $("#username").val();
	if (document.getElementById("processid").value == "transfer") {
		if (document.getElementById("selValue").value == username) {
			alert("对不起，委托人不能为自己");
		} else {
			document.getElementById("fieldSurvey").submit();
		}
	} else if (document.getElementById("processid").value == "refund") {
		var refund = $("#refundMoney").val();
		if (testDecimal(refund) == false) {
			alert("请输入需退金额，格式为最多两位小数的数字");
			return;
		}
		if (!(Number(refund) <= Number(xtje))) {
			alert("对不起，需退金额不能大于已缴纳金额！");
			return;
		}
		if (document.getElementById("st").value == ""
				|| document.getElementById("st").value == null) {
			alert("对不起，终止原因不能为空");
		} else {
			document.getElementById("fieldSurvey").submit();
		}
	} else if (document.getElementById("processid").value == "stop") {
		if (document.getElementById("st").value == ""
				|| document.getElementById("st").value == null) {
			alert("对不起，终止原因不能为空");
		} else {
			document.getElementById("fieldSurvey").submit();
		}
	}
}
