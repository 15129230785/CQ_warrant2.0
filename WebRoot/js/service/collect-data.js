var wid = "";
$(function() {
	wid = $("#wid").val();
	var st = getServiceType(wid);
	$("#serviceType").val(st);
	showComdocList(wid, "comdocList");
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function sel() {
	var checklist = document.getElementsByName("checkbox");
	if (document.getElementById("controlAll").checked) {
		for (var i = 0; i < checklist.length; i++) {
			checklist[i].checked = 1;
		}
	} else {
		for (var j = 0; j < checklist.length; j++) {
			checklist[j].checked = 0;
		}
	}
}

function tijiao() {
	var j = 0;
	var checklist = document.getElementsByName("checkbox");
	for (var i = 0; i < checklist.length; i++) {
		if (checklist[i].checked) {
			j = 1;
			break;
		}
	}
	if (j == 1) {
		document.getElementById("collect").submit();
	} else {
		alert("对不起，至少选择一项");
	}
}

function getComDocList() {
	var type = document.getElementById("serviceType").value;
	var xmlhttp = null;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("GET", "GetComDocList.action" + "?rn=" + Math.random() + "&type=" + type, false);
	xmlhttp.send();
	var data = xmlhttp.responseText;
	var ul = eval("(" + data + ")");
	return ul.docList;
}

function showComdocList(wid, docList) {
	var pdl = getComDocList();
	var str = "";
	var size = pdl.length;
	if (size == 0) {
		return;
	}
	str += "";
	str += "<table id='r'>";
	str += "<tr align='center'>";
	str += "<th width='40%'>资料名称</th>";
	str += "<th width='40%'>资料描述</th>";
	str += "<th width='10%'>是否需要</th>";
	str += "</tr>";

	for (var i = 0; i < size; i++) {
		intact = pdl[i];
		str += "<tr>";
		str += "<td align='center'>" + intact.name + "</td>";
		str += "<td align='center'>" + intact.description + "</td>";
		str += "<td align='center'><input name='checkbox' type='checkbox' value='"
				+ intact.did +"' checked></td>";
		str += "</tr>";
	}
	str += "</table>";
	document.getElementById(docList).innerHTML = str;
	return;
}


