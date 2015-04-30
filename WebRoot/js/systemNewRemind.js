var oldcpopt = null;

function cli(id, qt) { //修改密码
	window.open(getRootPath() + "/user/userUpdate.jsp?id=" + id + "&qt="
		+ qt + "rn=" + Math.random(),
		"Sample",
		"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=600,height=500,left=300,top=200");
}

//密码逾期提醒
function pswdOverdue() {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "SystemNewRemind!checkPswd" + "?rn="
			+ Math.random(), false);
		xmlhttp.send();
		data = xmlhttp.responseText;
		if (data == "" || data == null) {
			return null;
		}
		var wi = eval("(" + data + ")");
		var banks = wi.banks;
		if (banks == null || banks == "") {
			return $("#tip").replaceWith("<td id='tip' style='display:none'>密码逾期</td>");
		}
		$("#tip").replaceWith("<td id='tip'><h7 style='color: red;'>" + banks
			+ "</h7></td>");
	}
}

//未读邮件提醒
function newLetter() {
	var wi = null;
	var banks = null;
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "SystemNewRemind!newLetter" + "?rn="
			+ Math.random(), false);
		xmlhttp.send();
		data = xmlhttp.responseText;
		if (data == "" || data == null) {
			return null;
		}
		wi = eval("(" + data + ")");
		banks = wi.banksLetter;
		if (banks == null || banks == "") {
			return $("#tip3").replaceWith("<td id='tip3' style='display:none'>邮件</td>");
		}
		$("#tip3").replaceWith(
			"<td id='tip3'>邮件:<a href='"+ getRootPath()
			+ "/stationLetter/stationLetter.jsp' target='c'><h7 style='color: red;'>"
			+ banks + "</h7></a></td>");
	}
}

//任务逾期提醒
function taskOverdue() {
	var wi = null;
	var banks = null;
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "SystemNewRemind!taskOverdue" + "?rn="
			+ Math.random(), false);
		xmlhttp.send();
		data = xmlhttp.responseText;
		if (data == "" || data == null) {
			return null;
		}
		wi = eval("(" + data + ")");
		banks = wi.banksTask;
		if (banks == null || banks == "") {
			return $("#tip1").replaceWith("<td id='tip1' style='display:none'>任务逾期</td>");
		}
		$("#tip1").replaceWith("<td id='tip1'>任务逾期:<h7 style='color: red;'>" + banks
			+ "</h7></td>");

	}
}

//新任务提醒
function newTask() {
	var wi = null;
	var banks = null;
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "SystemNewRemind!newTask" + "?rn=" + Math.random(),
			false);
		xmlhttp.send();
		data = xmlhttp.responseText;
		if (data == "" || data == null) {
			return null;
		}
		wi = eval("(" + data + ")");
		banks = wi.banksNewTask;
		if (banks == null || banks == "") {
			return $("#tip2").replaceWith("<td id='tip2' style='display:none'>新任务</td>");
		}
		$("#tip2").replaceWith("<td id='tip2'>新任务:<h7 style='color: red;'>" + banks
			+ "</h7></td>");
	}
}
