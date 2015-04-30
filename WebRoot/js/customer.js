function init() {
	showNameList("customer");
	showGroupList("groupList");
	cxCustomer();
//	addEvent();
}

function addCustomer() {
	var taskName = document.getElementById("customer").value;
	var taskGroup = document.getElementById("groupList").value;
	if (taskGroup == "" || taskName == "") {
		alert("添加错误");
		return null;
	}
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "AddCustomer" + "?rn=" + Math.random()
				+ "&taskName=" + taskName + "&branch="
				+ encodeURI(encodeURI(taskGroup)), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		if ("y" != data) {
			alert("添加失败");
			return null;
		}
	}
	cxCustomer();
}

function cxCustomer() {
	var taskName = document.getElementById("customer").value;
	var taskGroup = document.getElementById("groupList").value;
	var td = new Array();
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "CxCustomer" + "?rn=" + Math.random()
				+ "&taskName=" + taskName + "&branch="
				+ encodeURI(encodeURI(taskGroup)), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		if (null == data || "" == data) {
			return null;
		}
		td.push(data);
		document.getElementById("groupDiv").innerHTML = td.join('');
		return;
	}
	return null;
}

function deleteCustomer(name, groupid) {
	var xmlhttp = initxmlhttp();
	if (xmlhttp != null) {
		xmlhttp.open("GET", "DeleteCustomer" + "?rn=" + Math.random()
				+ "&taskName=" + name + "&branch="
				+ encodeURI(encodeURI(groupid)), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		if ("y" != data) {
			alert("删除错误");
			return null;
		}
	}
	cxCustomer();
}

function getNameList() {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetTaskNameList" + "?rn=" + Math.random(), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		if (null == data || "" == data) {
			return null;	
		}
		var ul = eval("(" + data + ")");
		return ul.customerList;
	}
	return null;
}

function showNameList(g) {
	var name = getNameList();
	if (name == null || name.length == 0) {
		return;
	}
	var select = document.getElementById(g);
	var opt = document.createElement("option");
	select.appendChild(opt);
	for (var gi = 0; gi < name.length; gi++) {
		opt = document.createElement("option");
		opt.innerHTML = name[gi].chineseName;
		opt.setAttribute("value", name[gi].englishName);
		select.appendChild(opt);
	}
}
