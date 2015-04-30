function perBtnClick() {
	document.getElementById("personinfo").submit();
	var id = document.getElementById("PerID").value;
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("post",
				"CheckPerID.action?personid=" + id + "&rn=" + Math.random(), false);
		xmlhttp.send();

		var str = xmlhttp.responseText;
		if (str == id) {
			document.getElementById("perBtn").value = "修改";
		}
	}
}

function onclickSelectPerAjax(jump) {
	var id = document.getElementById("PerID").value;
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "SelectAjax" + jump + ".action?id=" + id
				+ "&rn=" + Math.random(), false);
		xmlhttp.send();
		//alert(xmlhttp.responseText);
		document.getElementById(jump + "div").innerHTML = xmlhttp.responseText;
	}
}

function family() {
	var id = document.getElementById("PerID").value.replace(/[]/g, "");

	if (id.length == 0) {
		alert("申请人的身份证号码不能为空");
		return;
	}
	var xmlhttp = initxmlhttp();
	if (xmlhttp != null) {
		xmlhttp.open("post",
				"CheckPerID.action?personid=" + id + "&rn=" + Math.random(), false);
		xmlhttp.send();

		var str = xmlhttp.responseText;
		if (str == id) {
			window.open(getRootPath() + "/apply/family.jsp?id=" + id
				+ "&rn=" + Math.random(),
				"Sample",
				"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=700,height=350,left=350,top=240");
			return;
		}
		alert("申请人的身份证号码不存在!");
	}
}

function updateFamilyJs(kid) {
	window.open(getRootPath() + "/apply/family.jsp?kid=" + kid
		+ "&rn=" + Math.random(),
		"Sample",
		"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no, copyhistory=no,width=700,height=350,left=350,top=240");
}

function familyListOne(index, id) {
	var xmlhttp = initxmlhttp();
	
	if(xmlhttp != null) {
		if (window.confirm("您确定删除?")) {
			xmlhttp.open("GET", "OutDeleteTblFamily.action?kid="
					+ index
					+ "&id=" + id
					+ "&rn=" + Math.random(), false);
			xmlhttp.send();
			document.getElementById("TblFamilydiv").innerHTML = xmlhttp.responseText;
		}
	}
}

function debt() {
	var id = document.getElementById("PerID").value.replace(/[]/g, "");

	if (id.length == 0) {
		alert("申请人的身份证号码不能为空");
		return;
	}
	var xmlhttp = initxmlhttp();
	if (xmlhttp != null) {
		xmlhttp.open("post",
				"CheckPerID.action?personid=" + id + "&rn=" + Math.random(), false);
		xmlhttp.send();

		var str = xmlhttp.responseText;
		if (str == id) {
			window.open(getRootPath() + "/apply/debt.jsp?id=" + id
				+ "&rn=" + Math.random(),
				"Sample",
				"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=700,height=350,left=350,top=240");
			return;
		}
		alert("申请人的身份证号码不存在!");
	}
}

function updateDebtJs(kid) {
	window.open(getRootPath() + "/apply/debt.jsp?kid=" + kid
		+ "&rn=" + Math.random(),
		"Sample",
		"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no, copyhistory=no,width=700,height=350,left=350,top=240");
}

function debtListOne(index, id) {
	var xmlhttp = initxmlhttp();
	
	if(xmlhttp != null) {
		if (window.confirm("您确定删除?")) {
			xmlhttp.open("GET", "OutDeleteTblDebt.action?kid="
					+ index
					+ "&id=" + id
					+ "&rn=" + Math.random(), false);
			xmlhttp.send();
			document.getElementById("TblDebtdiv").innerHTML = xmlhttp.responseText;
		}
	}
}

function personalwarrant() {
	var id = document.getElementById("PerID").value.replace(/[]/g, "");

	if (id.length == 0) {
		alert("申请人的身份证号码不能为空");
		return;
	}
	var xmlhttp = initxmlhttp();
	if (xmlhttp != null) {
		xmlhttp.open("post",
				"CheckPerID.action?personid=" + id + "&rn=" + Math.random(), false);
		xmlhttp.send();

		var str = xmlhttp.responseText;
		if (str == id) {
			window.open(getRootPath() + "/apply/personalwarrant.jsp?id=" + id
				+ "&rn=" + Math.random(),
				"Sample",
				"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=700,height=350,left=350,top=240");
			return;
		}
		alert("申请人的身份证号码不存在!");
	}
}

function updatePersonalwarrantJs(kid) {
	window.open(getRootPath() + "/apply/personalwarrant.jsp?kid=" + kid
		+ "&rn=" + Math.random(),
		"Sample",
		"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no, copyhistory=no,width=700,height=350,left=350,top=240");
}

function personalwarrantListOne(index, id) {
	var xmlhttp = initxmlhttp();
	
	if(xmlhttp != null) {
		if (window.confirm("您确定删除?")) {
			xmlhttp.open("GET", "OutDeleteTblPersonalwarrant.action?kid="
					+ index
					+ "&id=" + id
					+ "&rn=" + Math.random(), false);
			xmlhttp.send();
			document.getElementById("TblPersonalwarrantdiv").innerHTML = xmlhttp.responseText;
		}
	}
}

function applyPassYz() {
	var wid = document.getElementById("wid").value;
	var pid = document.getElementById("PerID").value;
	var xmlhttp = initxmlhttp();
	
	if(xmlhttp != null) {
		xmlhttp.open("post", "ApplyCheckPersonData?wid="
				+ wid + "&pid=" + pid + "&rn=" + Math.random(),
				false);
		xmlhttp.send();
		var str = xmlhttp.responseText;
		if ("suc" == str) {
			return true;
		} else {
			return false;
		}
	}
}

function applyPerson() {
	if (transfer() == true) {
		document.getElementById("applyPerson_Form").submit();
		return;
	}
	if (applyPassYz() == true) {
		var pid = document.getElementById("PerID").value;
		document.getElementById('perid').setAttribute("value", pid);
		
		document.getElementById("applyPerson_Form").submit();
	} else {
		alert("请先填写并保存个人担保申请信息和个人基本信息！");
	}
}

$(function() {
	$(".demoform").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		callback : function(form) {
			if ("修改" == $('#warrantBtn').val()) {
				// alert("数据修改成功！");
			} else {
				// alert("warrantBtn！");
				$('#warrantBtn').val("修改");
			}
		},
		datatype : {
			"m" : function() {
				var res = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
				var Money = $("#Money").val();
				if (Money != 0) {
					return res.test(Money);
				} else {
					return "申请担保金额不能为0";
				}
			},
			"mv" : function() {
				var res = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
				var Rate = $("#Rate").val();
				if (Rate >= 0) {
					return res.test(Rate);
				} else {
					return "费率输入有误";
				}
			},
		}
	});
});
