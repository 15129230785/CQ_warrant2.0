var wid = null;
var serviceType = "";
$(function() {
	wid = $("#wid").val();
	serviceType = getServiceType(wid);
	$("#serviceType").val(serviceType);
	
	if (serviceType == "1") {
		document.getElementById("zlsc").style.display = "none";
		document.getElementById("fwsc").style.display = "none";
		document.getElementById("cwsc").style.display = "none";
	}
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function chang(id) {
	if (id != "transfer") {
		document.getElementById("dis").style.display = "none";
	} else {
		document.getElementById("dis").style.display = "block";
	}
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
	str += "<table>";
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
	showFieldSurveyInfo(fsl, fsInfo, serviceType);
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

var lal = null;
function showLAI(id, laInfo) {
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	if (lal == null) {
		lal = getLawauditInfo(wid);
	}
	showLawauditInfo(lal, laInfo);
}

var fel = null;
function showFEI(id, feInfo) {
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	if (fel == null) {
		fel = getFinanceestInfo(wid);
	}
	showFinanceestInfo(fel, feInfo);
}

var rel = null;
function showREI(id, reInfo) {
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	if (serviceType == "0") {
		if (rel == null) {
			rel = getCompanyRiskestInfo(wid);
		}
		showCompanyRiskestInfo(rel, reInfo);
	} else {
		if (rel == null) {
			rel = getPersonRiskestInfo(wid);
		}
		showPersonRiskestInfo(rel, reInfo);
	}
}

var mal = null;
function showMAI (id, maInfo) {
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	if (mal == null) {
		mal = getManauditInfo(wid);
	}
	showManauditInfo(mal, maInfo);
}

var rrl = null;
function showRRI (id, rrInfo) {
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	if (rrl == null) {
		rrl = getRiskReviewInfo(wid);
		if (rrl == null) {
			return null;
		}
	}
	var str = "";
	var size = rrl.length;
	if (size == 0) {
		return;
	}
	str += "";
	str += "<table width='100%'>";
	
	str += "<tr>";
	str += "<th width='15%'>审核人姓名</th>";
	for (var i = 0; i < size; i++) {
		var ss = rrl[i];
		str += "<td>" + ss.name + "</td>";
	}
	str += "</tr>";
	
	str += "<tr>";
	str += "<th>审核时间</th>";
	for (var i = 0; i < size; i++) {
		var ss = rrl[i];
		str += "<td>" + ss.date + "</td>";
	}
	str += "</tr>";
	
	str += "<tr>";
	str += "<th>审核意见</th>";
	for (var i = 0; i < size; i++) {
		var ss = rrl[i];
		str += "<td>" + ss.checks + "</td>";
	}
	str += "</tr>";
	
	str += "</table>";
	document.getElementById(rrInfo).innerHTML = str;
	return;
}


