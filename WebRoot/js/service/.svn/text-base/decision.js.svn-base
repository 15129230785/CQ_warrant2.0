var serviceType = "";
var wid = "";
var banks = null;
var warrantinfo = null;
var number = 0;

$(function() {
	wid = $("#wid").val();
	serviceType = getServiceType(wid);
	$("#serviceType").val(serviceType);
	warrantinfo = getWarrantInfo(wid);
	
	if (serviceType == "1") {
		document.getElementById("fieldset").style.display = "none";
		pepdcSign();
	} else {
		document.getElementById("fieldset1").style.display = "none";
		decSign();
	}
	if (serviceType == "1") {
		document.getElementById("zsc").style.display = "none";
		document.getElementById("fyj").style.display = "none";
		document.getElementById("cyj").style.display = "none";
	}
	showChargeInfo(wid, "xt");
	csl = getCounterSignInfo(wid);
	if (csl) {
		number = csl[0].number;
	}
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
	$(".addbutton").button();
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

function decSign() {
	var xmlhttp = initxmlhttp();
	var decisionSignDiv = document.getElementById("decisionSignDiv");
	
	xmlhttp.open("GET", "DecisionSign.action" + "?rn=" + Math.random()+ "&wid=" + wid, false);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4) {
			decisionSignDiv.innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.send();
}
//个人资信评分
function pepdcSign() {
	var xmlhttp  = initxmlhttp();
	var pepdecisionSignDiv = document.getElementById("pepdecisionSignDiv");
	
	xmlhttp.open("GET", "PepsionSign.action" + "?rn=" + Math.random()+ "&wid=" + wid, false);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4) {
			pepdecisionSignDiv.innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.send();
}

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

function tijiao() {
	if (transfer() == true) {
		document.getElementById("f").submit();
		return;
	}
	var money = 0;
	if (warrantinfo != null && warrantinfo.practicalMoney != null && warrantinfo.practicalMoney != "") {
		money = warrantinfo.practicalMoney;
	}
	
	if (document.getElementById("decisionList").value == "0") {
		var m = $("#money").val();
		if ((testDecimal(m) == false)
			|| (Number(m) == 0)) {
			alert("请输入实际贷款金额，为最多两位小数的数字，且不能为0");
			return;
		}
		if (Number(m) > Number(money)) {
			alert("对不起，实际担保金额大于申请担保金额，请重新输入");
			return;
		}

		var deposit = $("#deposit").val();
		if (testDecimal(deposit) == false) {
			alert("请输入保证金，为最多两位小数的数字，或通过输入保证金费率计算");
			return;
		}
		
		var commission = $("#commission").val();
		if (testDecimal(commission) == false) {
			alert("请输入代办费，为最多两位小数的数字，或通过输入代办费费率计算");
			return;
		}
		
		var assure = $("#assure").val();
		if (testDecimal(assure) == false) {
			alert("请输入担保费，为最多两位小数的数字，或通过输入担保费费率计算");
			return;
		}
		
		var evaluate = $("#evaluate").val();
		if (testDecimal(evaluate) == false) {
			alert("请输入评估费，为最多两位小数的数字，或通过输入评估费费率计算");
			return;
		}
	}
	if (document.getElementById("explain").value == "" 
		&& (document.getElementById("decisionList").value == "0"
			|| document.getElementById("decisionList").value=="3")) {
		alert("您未输入情况说明，不能提交！");
		return;
	} else if (document.getElementById("decisionList").value == "2") {
		var refund = $("#xt").val();
		if (testDecimal(refund) == false) {
			alert("请输入需退金额，格式为最多两位小数的数字");
			return;
		}
		if (!(Number(refund) <= Number(xtje))) {
			alert("对不起，需退金额不能大于已缴纳金额！");
			return;
		}
	} else if (!(testDecimal($("#deposit").val()) == true
			&& testDecimal($("#assure").val()) == true
			&& testDecimal($("#commission").val()) == true
			&& testDecimal($("#evaluate").val()) == true
			|| $("#decisionList").val() != "0")) {
		alert("对不起，收费金额未输入完整！");
		return;
	}
	document.getElementById("f").submit();
}

function cha(id) {
	if (id == 0) {
		document.getElementById("field").style.display = "block";
		document.getElementById("shiji").style.display = "block";
		document.getElementById("selDivN").style.display = "none";
		document.getElementById("selDivM").style.display = "none";
		document.getElementById("zd").style.display = "block";
		//document.getElementById("zd1").style.display = "block";
		document.getElementById("sel").style.display = "block";
	}  else if (id == 1) {
		document.getElementById("field").style.display = "none";
		document.getElementById("selDivN").style.display = "none";
		document.getElementById("shiji").style.display = "none";
		document.getElementById("selDivM").style.display = "block";
		document.getElementById("zd").style.display = "none";
		//document.getElementById("zd1").style.display = "none";
		document.getElementById("sel").style.display = "none";
	} else if(id == 2) {
		document.getElementById("field").style.display = "none";
		document.getElementById("selDivN").style.display = "block";
		document.getElementById("shiji").style.display = "none";
		document.getElementById("selDivM").style.display = "block";
		document.getElementById("zd").style.display = "none";
		//document.getElementById("zd1").style.display = "none";
		document.getElementById("sel").style.display = "block";
	} else {
		document.getElementById("field").style.display = "none";
		document.getElementById("shiji").style.display = "none";
		document.getElementById("selDivN").style.display = "none";
		document.getElementById("selDivM").style.display = "none";
		document.getElementById("zd").style.display = "block";
		//document.getElementById("zd1").style.display = "block";
		document.getElementById("sel").style.display = "block";
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
		showPersonRiskestInfo(rel, reInfo, serviceType);
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

function getCounterSignInfo(wid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetCounterSignInfo" + "?rn=" + Math.random() + "&wid="
				+ wid, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var csl = eval("(" + data + ")");
		return csl.counterSignInfo;
	}
	return null;
}

var csl = null;
function showCounterSignInfo(id, csInfo) {
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	if (csl == null) {
		csl = getCounterSignInfo(wid);
	}
	if (csl == null || csl.length == 0) {
		return;
	}
	
	var td = new Array();
	
	td.push('<table width="100%">');
	
	td.push('<tr>');
	td.push('<th width="15%">会签人名称</th>');
	for (var csn = 0; csn < csl.length; csn++) {
		td.push('<td onclick="updateCountersign(\''+csl[csn].kid + '\')"><a href="#" >' + csl[csn].name + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>会签日期</th>');
	for (var csn = 0; csn < csl.length; csn++) {
		td.push('<td>' + csl[csn].date + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>会签结论</th>');
	for (var csn = 0; csn < csl.length; csn++) {
		if (csl[csn].result == "1") {
			td.push('<td>不同意</td>');
		} else {
			td.push('<td>同意</td>');
		}
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>情况说明</th>');
	for (var csn = 0; csn < csl.length; csn++) {
		td.push('<td id="fiel">' + csl[csn].description + '</td>');
	}
	td.push('</tr>');
	td.push('</table>');
	
	document.getElementById(csInfo).innerHTML = td.join('');
	td = null;
}

function jisuanshiji() {
	jisuan();
	jisuan1();
	jisuan2();
	jisuan3();
}

function jisuan() {
	var m = document.getElementById("money").value;
	var v = document.getElementById("Rate").value;
	document.getElementById("deposit").value = ((m * 10000) * v / 100).toFixed(2);
}

function jisuan1() {
	var m = document.getElementById("money").value;
	var v = document.getElementById("Rate1").value;
	document.getElementById("commission").value = ((m * 10000) * v / 100).toFixed(2);
}

function jisuan2() {
	var m = document.getElementById("money").value;
	var v = document.getElementById("Rate2").value;
	document.getElementById("assure").value = ((m * 10000) * v / 100).toFixed(2);
}

function jisuan3() {
	var m = document.getElementById("money").value;
	var v = document.getElementById("Rate3").value;
	document.getElementById("evaluate").value = ((m * 10000) * v / 100).toFixed(2);
}

function addCountersign(wid) {
	window.open(getRootPath() + "/decision/addOrUpdateCountersign.jsp?wid=" + wid
		+ "&number=" + number
		+ "&rn=" + Math.random(),
		"Sample",
		"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no, copyhistory=no,width=700,height=350,left=350,top=240");
}

function updateCountersign(kid) {
	window.open(getRootPath() + "/decision/addOrUpdateCountersign.jsp?kid=" + kid
		+ "&rn=" + Math.random(),
		"Sample",
		"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=700,height=350,left=350,top=240");
}

