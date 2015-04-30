$(function() {
	var wid = $("#wid").val();
	var service = getServiceType(wid);
	$("#serviceType").val(service);
	
	if (service == "1") {
		document.getElementById("fenx").style.display = "none";
		document.getElementById("1").style.display = "none";
		document.getElementById("2").style.display = "none";
		document.getElementById("3").style.display = "none";
		document.getElementById("4").style.display = "none";
		document.getElementById("5").style.display = "none";
		document.getElementById("6").style.display = "none";
		document.getElementById("7").style.display = "none";
		document.getElementById("purpose2").style.display = "none";
		document.getElementById("purpose3").style.display = "none";
		document.getElementById("due").value = "1";
		document.getElementById("warrant").value = "1";
		document.getElementById("credit").value = "1";
		document.getElementById("credits").value = 1;
		document.getElementById("skill").value = 1;
		document.getElementById("managerial").value = "1";
		document.getElementById("paten").value = "1";
		document.getElementById("resource").value = 1;
		document.getElementById("righ").value = "1";
		document.getElementById("bilit").value = "1";
		document.getElementById("clien").value = "1";
		document.getElementById("natur").value = "1";
		document.getElementById("prospect").value = 1;
		document.getElementById("reserv").value = "1";
		document.getElementById("ccupancy").value = "1";
		document.getElementById("bran").value = "1";
		document.getElementById("chievement").value = "1";
		document.getElementById("experience").value = 1;
	} else {
		document.getElementById("age").value = 1;
		document.getElementById("ducationLevel4").value = 1;
		document.getElementById("martialStatus").value = 1;
		document.getElementById("liveTime").value = 1;
		document.getElementById("socialSecurity").value = 1;
		document.getElementById("job").value = 1;
		document.getElementById("familyIncome").value = 1;
		document.getElementById("numb").value = 1;
		document.getElementById("grossDebt").value = 1;
		document.getElementById("totalAssets").value = 1;
		document.getElementById("housSituation").value = 1;
		document.getElementById("reimbursement").value = "1";
		document.getElementById("cguemeforianaly").value = "1";
		document.getElementById("purpos").value = 1;
		document.getElementById("age1").style.display = "none";
		document.getElementById("ducationLevel1").style.display = "none";
		document.getElementById("martialStatus1").style.display = "none";
		document.getElementById("liveTime1").style.display = "none";
		document.getElementById("socialSecurity1").style.display = "none";
		document.getElementById("job1").style.display = "none";
		document.getElementById("familyIncome1").style.display = "none";
		document.getElementById("numb1").style.display = "none";
		document.getElementById("grossDebt1").style.display = "none";
		document.getElementById("totalAssets1").style.display = "none";
		document.getElementById("housSituation1").style.display = "none";
		document.getElementById("purpos4").style.display = "none";
		document.getElementById("purpos3").style.display = "none";
		document.getElementById("hnl").style.display = "none";
		document.getElementById("htet").style.display = "none";
		document.getElementById("fxx").style.display = "none";
		document.getElementById("fxt").style.display = "none"; 
	}
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function cl(id) {
	if (id == "transfer") {
		document.getElementById("cl").style.display = "block";
		document.getElementById("sub").style.display = "none";
		document.getElementById("but").style.display = "block";
	} else {
		document.getElementById("cl").style.display = "none";
		document.getElementById("sub").style.display = "block";
		document.getElementById("but").style.display = "none";
	}
}

function tijiao() {
	var username = $("#username").val();
	var sv = document.getElementById("selValue").value;
	if (sv == username) {
		alert("对不起，委托人不能是自己");
		return;
	} else if (sv == "" || sv == null) {
		alert("对不起，委托人不能为空");
		return;
	} else {
		document.getElementById("risk").submit();
	}
}
