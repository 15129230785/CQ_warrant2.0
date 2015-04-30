$(function() {
	var wid = $("#wid").val();
	var st = getServiceType(wid);
	$("#serviceType").val(st);
	
	showDocList(wid, "docList");
	showContractList();
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function tijiao() {
	if (document.getElementById("processid").value == "transfer") {
		document.getElementById("file").submit();
		return;
	}
	var k = 0;
	var checklist = document.getElementsByName("checkboxPact");
	for (var i = 0; i < checklist.length; i++) {
		if (checklist[i].checked) {
			k = 1;
			break;
		}
	}
	if (k == 0) {
		alert("对不起，未选择客户归档资料清单");
		return;
	}
	var w = 0; f = 0; j = 0; g = 0; t = 0; d = 0;
	if (document.getElementById("serviceType").value == "1") {
		if (document.getElementById("checkboxt").checked) {
			t = 1;
		}
		if (document.getElementById("checkboxd").checked) {
			d = 1;
		}
		if (t == 1 && d == 1) {
			document.getElementById("file").submit();
		} else {
			alert("对不起，资料中有必选项未选择");
		}	
	} else {
		if (document.getElementById("checkboxw").checked) {
			w = 1;
		}
		if (document.getElementById("checkboxf").checked) {
			f = 1;
		}
		if (document.getElementById("checkboxg").checked) {
			g = 1;
		}
		if (w == 1 && f == 1 && g == 1) {
			document.getElementById("file").submit();
		} else {
			alert("对不起，资料中有必选项未选择");
		}
	}
}

function showDocList(wid, docList) {
	var pdl = getProjectDocList(wid);
	var str = "";
	var size = pdl.length;
	if (size == 0) {
		str += "没有相关信息";
		document.getElementById(docList).innerHTML = str;
		return;
	}
	str += "";
	str += "<table width='98%' border='0' id='r'>";
	str += "<tr align='center'>";
	str += "<th width='90%' align='center'>资料名称</th>";
	str += "<th width='10%' align='center'>是否归档</th>";
	str += "</tr>";
	
	for (var i = 0; i < size; i++) {
		intact = pdl[i];
		str += "<tr>";
		str += "<td>" + intact.name + "</td>";
		str += "<td align='center'><input name='checkboxPact' type='checkbox' value='"
				+ intact.DID +"'></td>";
		str += "</tr>";
	}
	str += "</table>";
	document.getElementById(docList).innerHTML = str;
	return;
}
