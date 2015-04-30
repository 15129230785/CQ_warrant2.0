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

function tijiao(name) {
	
	if (transfer() == true) {
		document.getElementById("f").submit();
		return;
	}
	if (document.getElementById("check").checked) {
		document.getElementById("f").submit();
	} else {
		alert("请确认银行所需文件是否已经提供给银行");
		return;
	}
}

