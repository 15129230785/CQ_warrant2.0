$(function() {
	var wid = $("#wid").val();
	var st = getServiceType(wid);
	$("#serviceType").val(st);
	showContractList();
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function tijiao() {
	if(document.getElementById("processid").value == "nextLater") {
		if ("" == document.getElementById("c1").value
			|| "" == document.getElementById("c2").value) {
			alert("对不起，时间未填写完整");
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
				document.getElementById("signform").submit();
			} else {
				alert("对不起，签订的合同中有必选项未选择");
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
				document.getElementById("signform").submit();
			} else {
				alert("对不起，签订的合同中有必选项未选择");
			}
		}
	} else if (document.getElementById("processid").value == "transfer") {
		if (document.getElementById("selValue").value != "<%=username%>") {
			document.getElementById("signform").submit();
		} else {
			alert("对不起，委托人不能为自己");
			return;
		}
	}
}
