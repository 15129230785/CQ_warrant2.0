function getOperUserList() {
	var xmlHttp = initxmlhttp();
	
	if (xmlHttp != null) {
		xmlHttp.open("GET", "GetUserList" + "?rn=" + Math.random(), false);
		xmlHttp.send();
		var data = xmlHttp.responseText;
		var ul = eval(" (" + data + ") ");
		return ul.userList;
	}
	return null;
}

function showOperUserList(userName) {
	var user = null;

	user = getOperUserList();
	if (user == null || user.length == 0) {
		return;
	}

	var select = document.getElementById(userName);
	var opt = document.createElement("option");
	select.appendChild(opt);
	for (var i = 0; i < user.length; i++) {
		if ("root" == user[i].id) {
			continue;
		}
		opt = document.createElement("option");
		opt.innerHTML = user[i].id;
		opt.setAttribute("value", user[i].id);
		select.appendChild(opt);
	}
}

function getOperLogList(username, startdate, enddate, mode, currentRecord) {
	var xmlHttp = initxmlhttp();
	
	if (xmlHttp != null) {
		xmlHttp.open("GET", "GetOperlogList" + "?rn=" + Math.random()
			+ "&userName=" + username + "&startDate=" + startdate
			+ "&endDate=" + enddate + "&opMode=" + mode
			+ "&firstResult=" + currentRecord, false);
		xmlHttp.send();
		var data = xmlHttp.responseText;
		if (data == null || data == "") {
			return null;
		}
		var ul = eval("(" + data + ")");
		if (ul == null || ul == "")
			return null;
		var countPage = ul.countPage;
		document.getElementById("countPage").innerHTML = countPage+1;        //获得总页数
		document.getElementById("current").innerHTML = (currentRecord+1);     //当前第几页
		var a = document.getElementById("current");
		if (a.innerHTML == "0" || a.innerHTML == 0) {
			document.getElementById("current").innerHTML = countPage+1;
		}
		return ul.operlogList;
	}
	return null;
}

function showOperLogList(operloglist) {
	var username = document.getElementById("Operlogname").value;
	var startdate = document.getElementById("startDate").value;
	var enddate = document.getElementById("endDate").value;
	var mode = document.getElementById("opMode").value;

	var olist = getOperLogList(username, startdate, enddate, mode, currentRecord);
	
	if (olist == null || olist.length == 0) {
		document.getElementById(operloglist).innerHTML = "";
		return null;
	}

	var td = new Array();
	td.push('<table width="100%">');
	td.push('<tr>');
	td.push('<th>操作人员名称</th>');
	td.push('<th>操作时间</th>');
	td.push('<th>操作类型</th>');
	td.push('<th>操作数据</th>');
	td.push('<th>内容</th>');
	td.push('</tr>');

	for (var tn = 0; tn < olist.length; tn++) {
		td.push('<tr>');
		td.push('<td>' + olist[tn].name + '</td>');
		var date = new Date(olist[tn].opDate);
		var s = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate()
			+ "  " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
		td.push('<td>' + s + '</td>');
		td.push('<td>' + olist[tn].opMode + '</td>');
		td.push('<td>' + olist[tn].tableName + '</td>');
		var log = olist[tn].log;
		if (olist[tn].opMode == "登录") {
			td.push('<td>' + log + '</td>');
		} else if (log == null || log == "null") {
			td.push('<td></td>');
		} else {
			td.push('<td><a href="#" onclick="opInfo(\'' + log + '\');">详细信息</a></td>');
		}
		td.push('</tr>');
	}
	td.push('</table>');
	document.getElementById(operloglist).innerHTML = td.join('');
	td = null;
}

function opInfo(loginfo) {
	$("#alertDiv").dialog("option", "title", "操作详细信息");
	alert(loginfo);
}

var currentRecord = 0;
function showFirstPage(operloglist) { //首页
	var paging = document.getElementById("paging");
	if (paging.style.display='none') {
		paging.style.display='block';
	}
	currentRecord = 0;
	if (currentRecord == 1) {
		var a =document.getElementById("firstPage");
		a.readonly=true;
	}
	showOperLogList(operloglist);
}

function showNextPage(operloglist) {  //下一页
	var a = document.getElementById("current").innerHTML;
	var b = document.getElementById("countPage").innerHTML;
	if (a == b) {
		return null;
	}
	currentRecord += 1;
	showOperLogList(operloglist);
}
function showUpPage(operloglist) {     //上一页
	currentRecord = document.getElementById("current").innerHTML;
	if((currentRecord -= 1) > 0) {
		currentRecord -=1;
		showOperLogList(operloglist);
	} else {
		return null;
	}
}
function showEndPage(operloglist) {     //尾页
	currentRecord = -1;
	showOperLogList(operloglist);
}
function jumpPage(operloglist) {			//跳往某一页
	var a = $.trim($("#currentRecord").val());
	var b = document.getElementById("countPage").innerHTML;
	var re = /^\d+$/g;
	var r = a.match(re);
	if (a == null || a == "" || r == null) {
		alert("请您输入正确的数字");
		currentRecord = document.getElementById("current").innerHTML;
		return null;
	} else if (parseInt(a) > parseInt(b)) {
		alert("您输入页数超过最大页");
		return null;
	}
	currentRecord = parseInt(document.getElementById("currentRecord").value)-1;
	showOperLogList(operloglist);
}
