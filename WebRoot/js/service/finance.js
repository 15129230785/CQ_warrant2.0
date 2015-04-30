$(function() {
	var wid = $("#wid").val();
	var st = getServiceType(wid);
	$("#serviceType").val(st);
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function chang() {
	if (document.getElementById("processid").value == "transfer") {
		document.getElementById("tdsum").style.display = "none";
		document.getElementById("tdbut").style.display = "block";
	} else {
		document.getElementById("tdsum").style.display = "block";
		document.getElementById("tdbut").style.display = "none";
	}
}

function tijiao() {
	var username = $("#username").val();
	if (document.getElementById("processid").value == "transfer") {
		if (document.getElementById("selValue").value == username) {
			alert("对不起，委托人不能是自己");
			return;
		} else {
			document.getElementById("finance").submit();
		}
	}
}
