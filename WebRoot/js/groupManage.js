function getGroupList() {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetGroupList" + "?rn=" + Math.random(), false);
		xmlhttp.send();
		var ul = null;
		var data = xmlhttp.responseText;
		if (null != data && "" != data) {
			ul = eval("(" + data + ")");
		} else {
			return null;
		}
		return ul;
	}
}

function showGroupList(gl) {
	var group = getGroupList();
	if (group == null || group.length == 0) {
		return;
	}
	var td = new Array();
	
	td.push('<table width="100%" border="0" >');
	td.push('<thead>');
	td.push('<tr id="r">');
	td.push('<th></th>');
	td.push('<th>组名</th>');
	td.push('<th>操作</th>');
	td.push('</tr>');
	td.push('</thead>');
	td.push('<tbody>');
	for (var gi = 0; gi < group.length; gi++) {
		td.push('<tr id="d">');
		td.push('<td>' + gi + '</td>');
		td.push('<td>' + group[gi] + '</td>');
		td.push('<td><input type="button" onclick="del(\'' + group[gi] + '\')" name="del" value="删除" /></td>');
		td.push('</tr>');
	}
	td.push('</tbody>');
	td.push('</table>');
	
	document.getElementById(gl).innerHTML = td.join('');
	td = null;
}

function deleteGroup(id) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "DeleteGroup" + "?rn=" + Math.random()
				+ "&groupName=" + encodeURI(encodeURI(id)), false);
		xmlhttp.send();
	}
}


