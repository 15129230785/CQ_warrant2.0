var oldcpopt = null;
var ret = "";
var str = "";

function getUserList() {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetUserList" + "?rn=" + Math.random(), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var ul = eval("(" + data + ")");
		var ctList = ul.userList;
		var companyType = document.getElementById("acceptAddress");
		for (var i = 0; i < ctList.length; i++) {
			var opt = document.createElement('option');
			if ((oldcpopt != null) && (ctList[i].id == oldcpopt.value)) {
				oldctopt.innerHTML = ctList[i].businessEmail;
				continue;
			}
			opt.setAttribute('value', ctList[i].businessEmail);
			opt.innerHTML = ctList[i].id + "-邮箱地址:" + ctList[i].businessEmail;
			companyType.appendChild(opt);
		}

		return true;
	}
}
function lick() {
	var str = document.getElementById("acceptAddress").options[document
		.getElementById("acceptAddress").selectedIndex].text;
	var ret = str.split(":")[1];
	document.getElementById("acceptAddress").options[document
		.getElementById("acceptAddress").selectedIndex].text = ret;
	getUserList();
}
function getUserByName(name) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetUserByName" + "?rn=" + Math.random()
				+ "&uName=" + encodeURI(encodeURI(name)), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var ul = eval("(" + data + ")");
		if (ul.email == null || ul.email == "") {
			document.getElementById("name").value = "该用户邮箱未注册";
		} else {
			document.getElementById("name").value = ul.email;
		}
	}
	/*str = document.getElementById("name").value;
	ret = str.split("@")[1];*/
	return true;
}

function cli() {
	var herf = "https://mail." + ret + "/";
	window.open(herf,
		"Sample",
		"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no, copyhistory=no,width=2000,height=800,left=0,top=0");
	return;
}