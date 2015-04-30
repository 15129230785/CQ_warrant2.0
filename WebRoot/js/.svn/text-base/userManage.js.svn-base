function deleteUser(id) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("POST", "DeleteUser" + "?rn=" + Math.random() + "&userName="
				+ encodeURI(encodeURI(id)), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		return data;
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

function showUserList(self, userList) {
	var user = getUserList();
	if (user == null || user.length == 0) {
		return;
	}
	var td = new Array();
	td.push('<table width="100%">');
	td.push('<thead>');
	td.push('<tr id="r">');
	td.push('<th></th>');
	td.push('<th>用户名</th>');
	td.push('<th>邮箱</th>');
	td.push('<th>最近修改日期</th>');
	td.push('<th>操作</th>');
	td.push('</tr>');
	td.push('</thead>');
	td.push('<tbody>');
	for (var ui = 0; ui < user.length; ui++) {
		if (self != user[ui].id) {
			td.push('<tr id="d">');
			td.push('<td>' + ui + '</td>');
			td.push('<td onclick="cli(\'' + user[ui].id + '\')">'
					+ '<a href="#">' + user[ui].id + '</a></td>');
			td.push('<td>' + user[ui].businessEmail + '</td>');
			var date = new String(user[ui].moddate);
			var year = new String(date.substring(0, 4));
			var month = new String(date.substring(4, 6));
			if (month.charAt(0) == '0') {
				month = month.charAt(1);
			}
			var day = new String(date.substring(6, 8));
			if (day.charAt(0) == '0') {
				day = day.charAt(1);
			}
			td.push('<td>' + year + '年' + month + '月' + day + '日' + '</td>');
			td.push('<td><input type="button"'
					+ 'onclick="clicka(\'' + user[ui].id +'\')" value="删除"></td>');
			td.push('</tr>');
		}
	}
	td.push('</tbody>');
	td.push('</table>');
	
	document.getElementById(userList).innerHTML = td.join('');
//	td = null;
}

function getUserByName(name) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetUserByName" + "?rn=" + Math.random()
				+ "&userName=" + encodeURI(encodeURI(name)), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var ul = eval("(" + data + ")");
		return ul;
	}
	return null;
}

function showUserInfo(name, userInfo) {
	
	var user = getUserByName(name);
	if (user == null) {
		return;
	}
	var td = new Array();
	td.push('<table width="355" height="303" border="0" align="center">');
	
	td.push('<tr>');
	td.push('<td width="165" align="right">姓名：</td>');
	td.push('<td width="174">' + user.name + '</td>');
	td.push('</tr>');
	td.push('<tr style="display: none;">');
	td.push('<td align="right">姓名：</td>');
	td.push('<td><input type="password" name="userName" id="" value="' + user.name + '"></td>');
	td.push('</tr>');
	td.push('<tr style="display: none;">');
	td.push('<td align="right">密码：</td>');
	td.push('<td><input type="password" name="passWord" id="" value="' + user.password + '"></td>');
	td.push('</tr>');
	td.push('<tr>');
	td.push('<td align="right">原密码：</td>');
	td.push('<td><input type="password" name="word" id=""></td>');
	td.push('</tr>');
	td.push('<tr>');
	td.push('<td align="right">新密码：</td>');
	td.push('<td><input type="password" name="userPass" id="userPass" value=""></td>');
	td.push('</tr>');
	td.push('<tr>');
	td.push('<td align="right">确认新密码：</td>');
	td.push('<td><input type="password" name="pass" id="pass" value=""></td>');
	td.push('</tr>');
	if (user.email == null || user.email == "") {
		td.push('<tr style="display: none;">');
		td.push('<td align="right">邮箱：</td>');
		td.push('<td><input type="text" name="email" value=""></td>');
		td.push('</tr>');
		td.push('<tr>');
		td.push('<td align="right">邮箱：</td>');
		td.push('<td><input type="text" name="Xemail" value=""></td>');
		td.push('</tr>');
	} else {
		td.push('<tr style="display: none;">');
		td.push('<td align="right">邮箱：</td>');
		td.push('<td><input type="text" name="email" value="' + user.email + '"></td>');
		td.push('</tr>');
		td.push('<tr>');
		td.push('<td align="right">邮箱：</td>');
		td.push('<td><input type="text" name="Xemail" value="' + user.email + '"></td>');
		td.push('</tr>');
	}
	td.push('</table>');
	
	document.getElementById(userInfo).innerHTML = td.join('');
	td = null;
}

function getUserByWildId() {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		var id = document.getElementById("selText").value;
		xmlhttp.open("GET", "ListUser" + "?rn=" + Math.random()
				+ "&selText=" + id, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		if ("null" != data && "" != data) {
			var ul = eval("(" + data + ")");
			return ul.userList;
		}
	}
	return null;
}

function listUser(self, userList) {
	var user = getUserByWildId();
	if (user == null || user.length == 0) {
		document.getElementById(userList).innerHTML = "";
		return;
	}
	var td = new Array();
	td.push('<table width="100%">');
	td.push('<thead>');
	td.push('<tr id="r">');
	td.push('<th></th>');
	td.push('<th>用户名</th>');
	td.push('<th>邮箱</th>');
	td.push('<th>最近修改日期</th>');
	td.push('<th>操作</th>');
	td.push('</tr>');
	td.push('</thead>');
	td.push('<tbody>');
	for (var ui = 0; ui < user.length; ui++) {
		if (self != user[ui].name) {
			td.push('<tr id="d">');
			td.push('<td>' + ui + '</td>');
			td.push('<td onClick="cli(\'' + user[ui].name + '\')">'
					+ '<a href="#">' + user[ui].name + '</a></td>');
			td.push('<td>' + user[ui].email + '</td>');
			var date = new String(user[ui].moddate);
			var year = new String(date.substring(0, 4));
			var month = new String(date.substring(4, 6));
			if (month.charAt(0) == '0')
				month = month.charAt(1);
			var day = new String(date.substring(6, 8));
			if (day.charAt(0) == '0')
				day = day.charAt(1);
			td.push('<td>' + year + '年' + month + '月' + day + '日' + '</td>');
			td.push('<td><input type="button"'
					+ 'onclick="clicka(\'' + user[ui].name +'\')" value="删除"></td>');
			td.push('</tr>');
		}
	}
	td.push('</tbody>');
	td.push('</table>');
	
	document.getElementById(userList).innerHTML = td.join('');
	td = null;
}


