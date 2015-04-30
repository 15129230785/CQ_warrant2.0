var wid = "";
$(function() {
	wid = $("#wid").val();
	var service = getServiceType(wid);
	$("#serviceType").val(service);
	
	if (service == "1") {
		$("#ziliao").hide();
		document.getElementById("1").value = "1";
		document.getElementById("2").value = "1";
		document.getElementById("3").value = "1";
		document.getElementById("4").value = "1";
		document.getElementById("5").value = "1";
		document.getElementById("6").value = "1";
		document.getElementById("7").value = "1";
		document.getElementById("8").value = "1";
		document.getElementById("9").value = "1";
		document.getElementById("10").value = "1";
		document.getElementById("11").value = "1";
		document.getElementById("12").value = "1";
		document.getElementById("13").value = "1";
		document.getElementById("14").value = "1";
	}
	showDocList(wid, "docList");
	
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
		document.getElementById("refund").style.display = "none";
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
	
	if (document.getElementById("processid").value == "refund") {
		var m = $("#refundMoney").val();
		if (testDecimal(m) == false) {
			alert("请输入需退金额，格式为最多两位小数的数字");
			return;
		}
		if (!(Number(m) <= Number(xtje))) {
			alert("对不起，需退金额不能大于已缴纳金额！");
			return;
		}
	}
	if (document.getElementById("processid").value == "transfer") {
		if(document.getElementById("selValue").value == username) {
			alert("对不起，委托人不能为自己");
			return
		}
	}
	document.getElementById("Reviewdata").submit();
}

function showDocList(wid, docList) {
	var intact = null;
	var pdl = getProjectDocList(wid);
	var str = "";
	var size = pdl.length;
	if (size == 0) {
		str += "没有相关信息";
		document.getElementById(docList).innerHTML = str;
		return;
	}
	str += "";
	str += "<table>";
	str += "<tr align='center' id='r'>";
	str += "<th width='10%' style='display: none;'>资料编码</th>";
	str += "<th width='45%'>资料名称</th>";
	str += "<th width='45%'>资料描述</th>";
	str += "<th width='10%'>是否完整</th>";
	str += "</tr>";
	
	for (var i = 0; i < size; i++) {
		intact = pdl[i];
		str += "<tr id='d'>";
		str += "<td align='center'>" + intact.name + "</td>";
		str += "<td align='center'>" + intact.description + "</td>";
		str += "<td align='center'><input name='checkbox' type='checkbox' value="
			+ intact.DID + "></td>";
		str += "</tr>";
	}
	str += "</table>";
	document.getElementById(docList).innerHTML = str;
	return;
}

