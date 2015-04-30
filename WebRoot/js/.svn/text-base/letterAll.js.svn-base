//收件箱
function receiver(user) {
	var xmlhttp = null;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlhttp) {
		xmlhttp.open("GET", "StationLetter!receiver?rn="
			+ Math.random(),
			false);
		xmlhttp.send();
		data = xmlhttp.responseText;
		if (data == "null" || data == "") {
			return null;
		}
		var wi = eval("(" + data + ")");
		var banks = wi.banks;
		if (banks == null || banks == "") {
			return null;
		}
		var td = new Array();
		td.push('<table width="100%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">');

		td.push('<tr>');
		td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">发件人</td>');
		td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">标题</td>');
		td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">发送时间</td>');
		td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">查看状态</td>');
		td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">操作</td>');
		td.push('</tr>');

		var kid = null;
		for (var i = 0; i < banks.length; i++) {
			kid = banks[i].kid;
			td.push('<tr>');
			td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
							+ banks[i].sendID + '</td>');
			td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
					+ '<a href="#" onclick="letterContent(\''
					+ banks[i].message
					+ '\',\''
					+ kid
					+ '\')">'
					+ banks[i].caption + '</a></td>');
			td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
					+ banks[i].sendDate + '</td>');
			var rcl = banks[i].recList;
			var status = "";
			for (var rcli = 0; rcli < rcl.length; rcli++) {
				if (rcl[rcli].name == user) {
					if (rcl[rcli].readFlag == 1000) {
						status = "未读";
					} else if (rcl[rcli].readFlag == 1001) {
						status = "已读";
					} else {
						status = "未读";
					}
					break;
				}
			}
			/*
			 * if(status==1000){ status="未读"; }else{ status="已读"; }
			 */
			td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
				+ status + '</td>');
			td.push('<td width="20%"style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
				+ '<a href="StationLetter!deleteRcvLetter?kid='
				+ kid + '">删除</a></td>');
			td.push('</tr>');
		}
		td.push('</table>');
		document.getElementById("tip").innerHTML = td.join('');
	}
}
// 发件箱
function addresser() {
	var xmlhttp = null;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlhttp) {
		xmlhttp.open("GET", "StationLetter!addresser?rn=" + Math.random(),
			false);
		xmlhttp.send();
		data = xmlhttp.responseText;
		var wi = eval("(" + data + ")");
		if (data == "null" || data == "") {
			return null;
		}
		var banks = wi.banks;
		if (banks == null || banks == "") {
			return null;
		}
		var td = new Array();
		td.push('<table width="100%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">');

		td.push('<tr>');
		td.push('<td width="25%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">标题</td>');
		td.push('<td width="25%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">收件人</td>');
		td.push('<td width="25%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">发送时间</td>');
		td.push('<td width="25%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">操作</td>');
		td.push('</tr>');
		for (var i = 0; i < banks.length; i++) {
			var kid = banks[i].kid;
			td.push('<tr>');
			td.push('<td width="25%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
					+ '<a href="#" onclick="letterContent(\''
					+ banks[i].message
					+ '\')">'
					+ banks[i].caption
					+ '</a>' + '</td>');
			td.push('<td width="25%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
							+ banks[i].recID + '</td>');
			td.push('<td width="25%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
							+ banks[i].sendDate + '</td>');
			td.push('<td width="25%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
					+ '<a href="StationLetter!deleteSndLetter?kid='
					+ kid + '">删除</a></td>');
			td.push('</tr>');
		}
		td.push('</table>');
		document.getElementById("tip").innerHTML = td.join('');
	}
}
// 回收站
function draft() {
	var xmlhttp = null;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlhttp) {
		xmlhttp.open("GET", "StationLetter!draft?rn=" + Math.random(), false);
		xmlhttp.send();
		data = xmlhttp.responseText;
		var wi = eval("(" + data + ")");
		if (data == "null" || data == "") {
			return null;
		}
		var banks = wi.banks;
		if (banks == null || banks == "") {
			return null;
		}
		var td = new Array();
		td.push('<table width="100%" style="border-collapse: collapse; border: 1px solid #B1CDE3;" style="table-layout: fixed;">');

		td.push('<tr>');
		td.push('<td width="20%; style="border-collapse: collapse; border: 1px solid #B1CDE3;" style="table-layout: fixed;">发件人</td>');
		td.push('<td width="20%; style="border-collapse: collapse; border: 1px solid #B1CDE3;" style="table-layout: fixed;">收件人</td>');
		td.push('<td width="20%; style="border-collapse: collapse; border: 1px solid #B1CDE3;" style="table-layout: fixed;">标题</td>');
		td.push('<td width="20%; style="border-collapse: collapse; border: 1px solid #B1CDE3;" style="table-layout: fixed;">发送时间</td>');
		td.push('<td width="20%; style="border-collapse: collapse; border: 1px solid #B1CDE3;" style="table-layout: fixed;">操作</td>');
		td.push('</tr>');
		var kid = null;
		for (var i = 0; i < banks.length; i++) {
			kid = banks[i].kid;
			td.push('<tr>');
			td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
					+ banks[i].sendID + '</td>');
			td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
					+ banks[i].recID + '</td>');
			td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
					+ banks[i].caption + '</td>');
			td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
					+ banks[i].sendDate + '</td>');
			td.push('<td width="20%" style="border-collapse: collapse; border: 1px solid #B1CDE3;">'
					+ '<a href="StationLetter!everDeleteLetter?kid='
					+ kid + '">删除</a></td>');
			td.push('</tr>');
		}
		td.push('</table>');
		document.getElementById("tip").innerHTML = td.join('');
	}
}
// 信件内容
function letterContent(message, kid) {
	var xmlhttp = null;
	
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	if (xmlhttp && kid) {
		xmlhttp.open("GET", "StationLetter!letterStatus?kid=" + kid, false);
		xmlhttp.send();
	}
	window.open(getRootPath() + "/stationLetter/letterContent.jsp?message="
				+ message,
				"Sample",
				"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no, copyhistory=no,width=526,height=450,left=350,top=240");
}
