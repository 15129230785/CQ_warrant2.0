var oldcpopt = null;
var ret = "";
var str = "";

function getUserList() {
	empty();
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetUserList" + "?rn=" + Math.random(), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var ul = eval("(" + data + ")");
		var ctList = ul.userList;
		var companyType = document.getElementById("recID");
		for (var i = 0; i < ctList.length; i++) {
			var opt = document.createElement('option');
			if ((oldcpopt != null) && (ctList[i].id == oldcpopt.value)) {
				oldctopt.innerHTML = ctList[i].businessEmail;
				continue;
			}
			opt.setAttribute('value', ctList[i].id);
			opt.innerHTML = ctList[i].id;
			companyType.appendChild(opt);
		}

		return true;
	}
}

//获取群组信息
function getGroupList() {
	empty();
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetGroupList" + "?rn=" + Math.random(), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var ul = eval("(" + data + ")");
		var ctList = ul;
		var companyType = document.getElementById("recID");
		for (var i = 0; i < ctList.length; i++) {
			var opt = document.createElement('option');
			if ((oldcpopt != null) && (ctList[i] == oldcpopt.value)) {
				oldctopt.innerHTML = ctList[i];
				continue;
			}
			opt.setAttribute('value', ctList[i]);
			opt.innerHTML = ctList[i];
			companyType.appendChild(opt);
		}

		return true;
	}
}
//清空select值
function empty() {
	document.getElementById("recID").options.length = 0;
}