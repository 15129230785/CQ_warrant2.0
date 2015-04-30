var wid = "";
var banks = null;
var warrantinfo = null;
$(function() {
	wid = $("#wid").val();
	var st = getServiceType(wid);
	$("#serviceType").val(st);
	warrantinfo = getWarrantInfo(wid);
	if (warrantinfo) {
		var reviewMoney = warrantinfo.money;
		document.getElementById("warMon").value = Number(reviewMoney).toFixed(2);
	}
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function oncha(id) {
	if (id == "0") {
		document.getElementById("y").style.display = "block";
		document.getElementById("n").style.display = "none";
	} else if (id == "1") {
		document.getElementById("y").style.display = "none";
		document.getElementById("n").style.display = "block";
	}
}

function tijiao() {
	var chavar = "";
	var v = document.getElementById("processid").value;
	var m = document.getElementById("Money").value;
	var chara = document.forms["clear"]["radio"];
	var money = 0;
	
	if (testDecimal(m) == false) {
		alert("请输入还款金额，格式为最多两位小数的数字，或者输入0");
		return;
	}
	
	if (warrantinfo) {
		money = warrantinfo.money;
	}
	if (v == "transfer") {
		document.getElementById("clear").submit();
		return;
	}
	for (var i = 0; i < chara.length; i++) {
		if (chara[i].checked) {
			chavar = chara[i].value;
			break;
		}
	}
	
	if (chavar == "") {
		alert("请选择：是否需要代偿");
		return;
	} else if (chavar == "0") {
		if (Number(m) > Number(money)) {
			alert("对不起，还款金额大于或等于实际担保金额，无需代偿");
			return;
		} else {
			if (document.getElementById("rad").checked) {
				alert("对不起，代偿时不能退回抵押物");
				return;
			}
			if (v == "compensatory") {
				document.getElementById("clear").submit();
			} else {
				alert("处理方式请选择为代偿");
				return;
			}
		}
	} else if (chavar == "1") {
		if (Number(m) < Number(money)) {
			alert("对不起，还款金额小于实际担保金额，必须代偿");
			return;
		} else {
			if (!document.getElementById("rad").checked) {
				alert("对不起，抵押物未退回");
				return;
			}
			if (v == "nextLater") {
				document.getElementById("clear").submit();
			} else {
				alert("处理方式请选择为 下一处理环节");
				return;
			}
		}
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
