function addMemberShip(id, name) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "AddMemberShip" + "?rn=" + Math.random() + "&userid="
				+ encodeURI(encodeURI(id)) + "&groupid=" + encodeURI(encodeURI(name)), false);
		xmlhttp.send();
	}
}

function deleteMemberShip(id) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "DeleteMemberShip" + "?rn=" + Math.random() + "&kid="
				+ id, false);
		xmlhttp.send();
	}
}

function getUserList() {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetUserList" + "?rn=" + Math.random(), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var ul = eval("(" + data + ")");
		return ul.userList;
	}
	return null;
}

function showUserList(self, userName) {
	var user = getUserList();
	if (user == null || user.length == 0) {
		return;
	}
	
	var select = document.getElementById(userName);
	var opt = document.createElement("option");
	select.appendChild(opt);
	for (var ui = 0; ui < user.length; ui++) {
		if ("root" == user[ui].id) {
			continue;
		}
		opt = document.createElement("option");
		opt.innerHTML = user[ui].id;
		opt.setAttribute("value", user[ui].id);
		select.appendChild(opt);
	}
}

function getGroupList() {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetGroupList" + "?rn=" + Math.random(), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var ul = eval("(" + data + ")");
		return ul;
	}
	return null;
}

function showGroupList(g) {
	var group = getGroupList();
	if (group == null || group.length == 0) {
		return;
	}
	var select = document.getElementById(g);
	var opt = document.createElement("option");
	select.appendChild(opt);
	for (var gi = 0; gi < group.length; gi++) {
		opt = document.createElement("option");
		opt.innerHTML = group[gi];
		opt.setAttribute("value", group[gi]);
		select.appendChild(opt);
	}
}

function getMemberShipList(userid, groupid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetMemberShipList" + "?rn=" + Math.random()
				+ "&userid=" + encodeURI(encodeURI(userid)) + "&groupid=" + encodeURI(encodeURI(groupid)), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		if ("null" == data) {
			return null;	
		}
		var ul = eval("(" + data + ")");
		return ul.memberShipList;
	}
	return null;
}

function showMemberShipList(m, userid, groupid) {
	var msl = getMemberShipList(userid, groupid);
	var td = new Array();
	if (msl == null || msl.length == 0) {
		td.push('<table width="100%" height="25" border="0" align="center">');
		td.push('<tr id="r">');
		td.push('<td></td>');
		td.push('<td>用户</td>');
		td.push('<td>角色</td>');
		td.push('<td>操作</td>');
		td.push('</tr>');
		td.push('</table>');
	} else {
		td.push('<table width="100%" height="25" border="0" align="center">');
		
		td.push('<tr id="r">');
		td.push('<td></td>');
		td.push('<td>用户</td>');
		td.push('<td>角色</td>');
		td.push('<td>操作</td>');
		td.push('</tr>');
		for (var mi = 0; mi < msl.length; mi++) {
			var v = msl[mi].userid;
			if (v != "root") {
				td.push('<tr id="d">');
				td.push('<td>' + mi + '</td>');
				td.push('<td>' + v + '</td>');
				td.push('<td>' + msl[mi].groupid + '</td>');
				td.push('<td><input type="button" onClick="cliMem(\''
						+ msl[mi].kid + '\')" value="删除" /></td>');
				td.push('</tr>');
			}
		}
		td.push('</table>');
	}
	document.getElementById(m).innerHTML = td.join('');
	td = null;
}


