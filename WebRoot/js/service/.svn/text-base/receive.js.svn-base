$(function() {
	var wid = $("#wid").val();
	getServiceType(wid);
	showChargeInfo(wid, "chargeInfo");
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function tijiao() {
	if (transfer() == true) {
		document.getElementById("f").submit();
		return;
	}
	if (document.getElementById("check").checked) {
		document.getElementById("f").submit();
	} else {
		alert("对不起，必须确定缴纳费用之后，才能提交");
		return;
	}
}

function showChargeInfo(wid, chargeInfo) {
	var ci = getChargeInfo(wid);
	var str = "";
	var size = ci.length;
	var total = 0.0;
	
	str += "";
	if (size > 0) {
		str += "<table>";
		if (ci[0] != 0) {
			str += "<tr>";
			str += "<td>保证金(元):</td>";
			str += "<td>" + ci[0] + "</td>";
			str += "</tr>";
		}
		if (ci[1] != 0) {
			str += "<tr>";
			str += "<td>担保费(元):</td>";
			str += "<td>" + ci[1] + "</td>";
			str += "</tr>";
		}
		if (ci[2] != 0) {
			str += "<tr>";
			str += "<td>评审费(元):</td>";
			str += "<td>" + ci[2] + "</td>";
			str += "</tr>";
		}
		if (ci[3] != 0) {
			str += "<tr>";
			str += "<td>代办费(元):</td>";
			str += "<td>" + ci[3] + "</td>";
			str += "</tr>";
		}
		if (ci[4] != 0) {
			str += "<tr>";
			str += "<td>评估费(元):</td>";
			str += "<td>" + ci[4] + "</td>";
			str += "</tr>";
		}
		
		total = ci[0] + ci[1] + ci[2] + ci[3] + ci[4];
		
		if (total != 0) {
			str += "<tr>";
			str += "<td>合计(元):</td>";
			str += "<td>" + total + "</td>";
			str += "</tr>";
		}
		str += "</table>";
	}
	document.getElementById(chargeInfo).innerHTML = str;
	return;
}
