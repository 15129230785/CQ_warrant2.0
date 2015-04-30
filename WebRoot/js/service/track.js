var wid = null;
var banks = null;
var warrantinfo = null;
var service = "";

$(function() {
	wid = $("#wid").val();
	service = getServiceType(wid);
	$("#serviceType").val(service);
	
	if (service == "1") {
		$("#companytrack").hide();
		$("#finance").val("1");
		$("#matter").val("1");
	} else {
		$("#companytrack").show();
	}
	warrantinfo = getWarrantInfo(wid);
	showMyWarrantInfo(warrantinfo, "warrantDiv");
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function chi() {
	var p = document.getElementById("processid").value;
	if (p == "transfer") {
		document.getElementById("sub").style.display = "none";
		document.getElementById("but").style.display = "block";
	} else {
		document.getElementById("sub").style.display = "block";
		document.getElementById("but").style.display = "none";
	}
}

function tijiao() {
	var p = document.getElementById("processid").value;
	if (p == "transfer") {
		document.getElementById("track").submit();
	}
}

function showMyWarrantInfo(wi, id) {
	var td = new Array();
	td.push('<table border="0">');
	td.push('<tr>');
	td.push('<td>项目放款日期:</td>');
	if (wi != null && wi.length != 0) {
		td.push('<td style="display: none;"><input id="d11" type="text" class="Wdate" onFocus="WdatePicker()" name="WarrantLoanDate" value="' + wi.warrantLoanDate + '" style="width: 200px" /></td>');
	} else {
		td.push('<td style="display: none;"><input id="d11" type="text" class="Wdate" onFocus="WdatePicker()" name="WarrantLoanDate" value="" style="width: 200px" /></td>');
	}
	td.push('<td><input id="d11" type="text" class="Wdate" onFocus="WdatePicker()" name="loanDate" value="" style="width: 200px" /></td>');		
	td.push('</tr>');
	td.push('</table>');
	
	document.getElementById(id).innerHTML = td.join('');
	td = null;
}

