var wid = null;
var service = "";
var banks = null;
var warrantinfo = null;
$(function() {
	wid = $("#wid").val();
	service = getServiceType(wid);
	$("#serviceType").val(service);
	warrantinfo = getWarrantInfo(wid);
	
	if (service == "1") {
		document.getElementById("zc").style.display = "none";
		document.getElementById("fln").style.display = "none";
		$("#cwpgclr").html("风险审查处理人");
	}
	
	showChargeInfo(wid, "money");
	
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

function op(id) {
	if (id == "stop") {
		document.getElementById("over").style.display = "block";
		document.getElementById("next").style.display = "none";
		document.getElementById("anew").style.display = "none";
		document.getElementById("refund").style.display = "none";
	} else if (id == "anew") {
		document.getElementById("next").style.display = "none";
		document.getElementById("anew").style.display = "block";
		document.getElementById("refund").style.display = "none";
		document.getElementById("over").style.display = "none";
	} else if (id == "transfer") {
		document.getElementById("next").style.display = "none";
		document.getElementById("anew").style.display = "block";
		document.getElementById("refund").style.display = "none";
		document.getElementById("over").style.display = "none";
	} else if (id == "refund") {
		document.getElementById("next").style.display = "none";
		document.getElementById("anew").style.display = "none";
		document.getElementById("refund").style.display = "block";
		document.getElementById("over").style.display = "block";
	} else if (id == "nextLater") {
		document.getElementById("next").style.display = "block";
		document.getElementById("anew").style.display = "none";
		document.getElementById("refund").style.display = "none";
		document.getElementById("over").style.display = "none";
	}
	
	if (id == "nextLater") {
		document.getElementById("sub").style.display = "block";
		document.getElementById("but").style.display = "none";
	} else {
		document.getElementById("sub").style.display = "none";
		document.getElementById("but").style.display = "block";
	}
}

function tijiao() {
	var username = $("#username").val();
	
	if (document.getElementById("processid").value == "refund") {
		var m = $("#money").val();
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
		if (document.getElementById("selValue").value == username) {
			alert("对不起，委托人不能为自己");
		}
	}
	document.getElementById("Consideration").submit();
}

var pdl = null;
function showDocList(id, docList) {
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	if (pdl == null) {
		pdl = getProjectDocList(wid);
	}
	var str = "";
	var size = pdl.length;
	if (size == 0) {
		str += "没有相关信息";
		document.getElementById(docList).innerHTML = str;
		return;
	}
	str += "";
	str += "<table id='r'>";
	str += "<tr align='center'>";
	str += "<th width='40%'>资料名称</th>";
	str += "<th width='40%'>资料描述</th>";
	str += "<th width='10%'>是否完整</th>";
	str += "</tr>";
	
	var intact = null;
	for (var i = 0; i < size; i++) {
		intact = pdl[i];
		str += "<tr>";
		str += "<td align='center'>" + intact.name + "</td>";
		str += "<td align='center'>" + intact.description + "</td>";
		if (intact.complete == "1") {
			str += "<td align='center'><input name='' type='checkbox' value=''"
				+ "checked disabled='disabled'></td>";
		} else {
			str += "<td align='center'><input name='' type='checkbox' value=''"
				+ "disabled='disabled'></td>";
		}
		str += "</tr>";
	}
	str += "</table>";
	document.getElementById(docList).innerHTML = str;
	return;
}

var fsl = null;
function showFSI(id, fsInfo) {
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	if (fsl == null) {
		fsl = getFieldSurveyInfo(wid);
	}
	showFieldSurveyInfo(fsl, fsInfo, service);
}

var rdl = null;
function showRDI(id, rdInfo) {
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	if (rdl == null) {
		rdl = getReviewDataInfo(wid);
	}
	showReviewDataInfo(rdl, rdInfo);
}


