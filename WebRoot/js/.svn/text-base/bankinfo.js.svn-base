var bankinfoxmlhttp = null;
var msg;
var bid;
var startdate;
var enddate;
var name;
var quota;
var remaining;

function initbankinfoxmlhttp() {
	if (window.XMLHttpRequest) {
		bankinfoxmlhttp = new XMLHttpRequest();
	} else {
		bankinfoxmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
}

//list
//------
//------
//------
function listajax() {
	if(!bankinfoxmlhttp)
		initbankinfoxmlhttp();
	if(bankinfoxmlhttp){
		bankinfoxmlhttp.open("GET", "listBankinfo.action" + "?rn=" + Math.random(), false);
		bankinfoxmlhttp.send();
		document.getElementById("bankinfodiv").innerHTML = bankinfoxmlhttp.responseText;
		//alert(xmlhttp.responseText);
	}
}

function addBankInfoJs() {
	window.open(getRootPath() + "/bankinfo/add.jsp",
			"Sample",
			"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=500,height=500,left=350,top=240");
}

function deleteBankInfoJs(id) {
	if (window.confirm("您确定删除?")) {
		bankinfoxmlhttp.open("GET", "deleteBankinfo.action?id=" + id
				+ "&rn=" + Math.random(), false);
		bankinfoxmlhttp.send();
		document.getElementById("bankinfodiv").innerHTML = bankinfoxmlhttp.responseText;
	}
}

function updateBankinfoJs(id) {
	window.open(getRootPath() + "/bankinfo/add.jsp?id=" + id + "&rn=" + Math.random(),
		"Sample",
		"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=500,height=500,left=350,top=240");
}

//add
//------
//------
//------
function checkAdd() {
	var flag = 0;
	bid = document.getElementById("bid").value;
	name = document.getElementById("name").value;
	quota = document.getElementById("quota").value;

	msg = "";
	
	if ($.trim(name) == "") {
		msg +="银行名称需要输入\r\n";
		flag += 1;
	}
	if ($.trim(bid) == "") {
		msg +="银行行号需要输入\r\n";
		flag += 1;
	}
	if ((quota) == "") {
		msg +="授信额度需要输入\r\n";
		flag += 1;
	}
	
	if (flag > 0) {
		return false;
	} else {
		return true;
	}
}

function execAdd() {
	if (checkAdd() == true) {
		document.getElementById("frmbankinfo").submit();
	} else {
		alert(msg);
	}
}

//update
//------
//------
//------
function listBankinfo() {
	var id = $("#id").val();
	if (id == null || id == "null") {
		$("#frmbankinfo").attr("action", "addBankinfo");
		$("#submitBtn").click(execAdd);
		return;
	}
	$.ajax({
		url : "GetTblCfgBankinfo",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			id : id,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$("#frmbankinfo").attr("action", "updateBankinfo");
				$("#trBid").css("display", "none");
				$("#submitBtn").click(execUpdate);
				
				$('#id').val(id);
				$('#id').attr("name", "id");
				$('#name').val(data.name);
				$('#remaining').val(data.remaining);
				$('#startdate').val(data.startdate);
				$('#enddate').val(data.enddate);
				$('#quota').val(data.quota);
			} else {
				$("#frmbankinfo").attr("action", "addBankinfo");
				$("#submitBtn").click(execAdd);
			}
		}
	});
}

function checkUpdate() {
	var flag = 0;
	quota = document.getElementById("quota").value;

	msg = "";
	
	if ((quota) == "") {
		msg +="授信额度需要输入\r\n";
		flag += 1;
	}
	
	if (flag > 0) {
		return false;
	} else {
		return true;
	}
}

function execUpdate() {
	if(checkUpdate() == true) {
		document.getElementById("frmbankinfo").submit();
	} else {
		alert(msg);
	}
}



