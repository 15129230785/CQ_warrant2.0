var wid = "";
var banks = null;
var warrantinfo = null;
$(function() {
	wid = $("#wid").val();
	var st = getServiceType(wid);
	$("#serviceType").val(st);
	warrantinfo = getWarrantInfo(wid);
	
	if (warrantinfo) {
		var mb = warrantinfo.money * 10000 - warrantinfo.paidMoney * 10000;
		$("#benjin").val(mb.toFixed(2));
		$("#benjin").attr("readonly", "readonly");

		var td = new Array();
		td.push('<table width="75%" height="50px">');
		td.push('<tr>');
		td.push('<td>终止日期：</td>');
		td.push('<td>' + warrantinfo.warrantReleaseDate + '</td>');
		td.push('<td>还款金额：</td>');
		td.push('<td>' + warrantinfo.paidMoney * 10000 + '元</td>');
		td.push('</tr>');

		td.push('<tr>');
		td.push('<td>贷款金额：</td>');
		td.push('<td>' + warrantinfo.money * 10000 + '元</td>');
		td.push('</tr>');
		td.push('</table>');
		document.getElementById("payInfo").innerHTML = td.join('');
	}
	
	$("[name='mode']").change(function() {
		if ($(this).is(":checked")) {
			$("#describe" + $(this).val()).show();
		} else {
			$("#describe" + $(this).val()).hide();
		}
	});
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function chi(id) {
	if ("persue" == id) {
		$("#start").show();
		$("#fangshi").show();
	} else {
		$("#start").hide();
		$("#fangshi").hide();
	}
}
function tijiao() {
	var chavar = "";
	var v = document.getElementById("processid").value;
	var chara = document.forms["Compensatory"]["radio"];
	
	if (v == "transfer") {
		document.getElementById("Compensatory").submit();
		return;
	}
	if (!document.getElementById("check").checked) {
		alert("对不起，银行债权未转让，不能提交");
		return;
	}
	
	if (testDecimal($("#lixi").val()) == false) {
		alert("利息输入格式不正确，请输入最多两位小数的数字");
		return;
	}
	if (testDecimal($("#faxi").val()) == false) {
		alert("罚息输入格式不正确，请输入最多两位小数的数字");
		return;
	}
	if (testDecimal($("#shouxu").val()) == false) {
		alert("违约金输入格式不正确，请输入最多两位小数的数字");
		return;
	}
	if (testDecimal($("#zhixing").val()) == false) {
		alert("执行费用输入格式不正确，请输入最多两位小数的数字");
		return;
	}
	if (testDecimal($("#qita").val()) == false) {
		alert("其它费用输入格式不正确，请输入最多两位小数的数字");
		return;
	}
	
	for (var i = 0; i < document.forms["Compensatory"]["radio"].length; i++) {
		if (chara[i].checked) {
			chavar = chara[i].value;
			break;
		}
	}
	if (chavar == "") {
		alert("请选择：是否需要追偿");
		return;
	} else if (chavar == "0") {
		if (v == "persue") {
			var error = 0;
			$("[name='mode']").each(function() {
				if ($(this).is(":checked")) {
					var desc = $("#describe" + $(this).val()).val();
					if (desc == null || $.trim(desc) == "") {
						error++;
					}
				}
			});
			if (error != 0) {
				alert("选择相应的追偿方式后，必须输入相关描述");
				return;
			}
			document.getElementById("Compensatory").submit();
		} else {
			alert("处理方式请选择为 追偿");
		}
	} else if (chavar == "1") {
		if (v == "nextLater") {
			document.getElementById("Compensatory").submit();
		} else {
			alert("处理方式请选择为 下一处理环节");
			return;
		}
	}
}

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

