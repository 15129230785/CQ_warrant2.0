var wid = "";
$(function() {
	wid = $("#wid").val();
	var st = getServiceType(wid);
	$("#serviceType").val(st);
	showChargeInfo(wid, "chargeInfo");
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header"
	});
});

function showChargeInfo(wid, chargeInfo) {
	var ci = getChargeInfo(wid);
	var str = "";
	var size = ci.length;
	str += "";
	if (size > 0) {
		str += "<table>";
		str += "<tr>";
		str += "<td>保证金(元):</td>";
		str += "<td>" + ci[0] + "</td>";
		str += "</tr>";
		str += "<tr>";
		str += "<td>担保费(元):</td>";
		str += "<td>" + ci[1] + "</td>";
		str += "</tr>";
		str += "<tr>";
		str += "<td>代办费(元):</td>";
		str += "<td>" + ci[3] + "</td>";
		str += "</tr>";
		str += "<tr>";
		str += "<td>评估费(元):</td>";
		str += "<td>" + ci[4] + "</td>";
		str += "</tr>";
		str += "</table>";
	}
	document.getElementById(chargeInfo).innerHTML = str;
	return;
}


