var wid = "";
$(function() {
	wid = $("#wid").val();
	var st = getServiceType(wid);
	$("#serviceType").val(st);
	showDocList(wid, "docList");
	
	showChargeInfo(wid, "xtje");
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function chi(id) {
	if (id == "refund") {
		document.getElementById("xtje").style.display = "block";
		document.getElementById("zzyy").style.display = "block";
		document.getElementById("sel").style.display = "block";
	} else if (id == "stop") {
		document.getElementById("xtje").style.display = "none";
		document.getElementById("zzyy").style.display = "block";
		document.getElementById("sel").style.display = "none";
	} else {
		document.getElementById("xtje").style.display = "none";
		document.getElementById("zzyy").style.display = "none";
		document.getElementById("sel").style.display = "block";
	}
}

function tijiao() {
	var processid= document.getElementById("processid").value;
	if (transfer() == true) {
		document.getElementById("f").submit();
		return;
	}
	if ("refund" == processid || "stop" == processid  ) {
		document.getElementById("f").submit();
		return;
	}
	if (document.getElementById("check").checked && processid=="nextLater") {
		document.getElementById("f").submit();
	} else{
		alert("对不起，您未上报资料");
	}
}

function showDocList(wid, docList) {
	var intact = null;
	var pdl = getProjectDocList(wid);
	var str = "";
	var size = pdl.length;
	if (size == 0) {
		str += "";
		document.getElementById(docList).innerHTML = str;
		return;
	}
	str += "";
	str += "<table width='98%' id='r'>";
	str += "<tr>";
	str += "<th width='10%' style='display: none;'>资料编码</th>";
	str += "<th width='40%'>资料名称</th>";
	str += "<th width='40%'>资料描述</th>";
	str += "<th width='10%'>是否完整</th>";
	str += "</tr>";
	
	for (var i = 0; i < size; i++) {
		intact = pdl[i];
		str += "<tr>";
		str += "<td align='center' style='display: none;'>" + intact.DBID + "</td>";
		str += "<td align='center' style='display: none;'>" + intact.complete + "</td>";
		str += "<td align='center' style='display: none;'>" + intact.DID + "</td>";
		str += "<td align='center'>" + intact.name + "</td>";
		str += "<td align='center'>" + intact.description + "</td>";
		if (intact.complete == "1") {
			str += "<td align='center'><input name='' type='checkbox' value=''"
				+ "checked disabled='disabled'></td>";
		} else {
			str += "<td align='center'><input name='' type='checkbox' value=''"
				+ " disabled='disabled'></td>";
		}
		str += "</tr>";
	}
	str += "</table>";
	document.getElementById(docList).innerHTML = str;
	return;
}

function showChargeInfo(wid, chargeInfo) {
	var ci = getChargeInfo(wid);
	var str = "";
	var size = ci.length;
	
	str += "";
	str += "<table width='97%'>";
	str += "<tr>";
	str += "<td width='90'>需退金额(元):</td>";
	if (size != 0) {
		str += "<td><input type='text' id='xt' name='refundMoney' value='" + ci[2] + "'></td>";
	} else {
		str += "<td><input type='text' id='xt' name='refundMoney' value=''></td>";
	}
	str += "</tr>";
	str += "</table>";
	document.getElementById(chargeInfo).innerHTML = str;
	return;
}

