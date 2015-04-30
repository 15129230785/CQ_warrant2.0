var wid = "";
$(function() {
	wid = $("#wid").val();
	var st = getServiceType(wid);
	$("#serviceType").val(st);
	init(wid);
	
	$(".persue").Validform({
		tiptype:3,
		label:".label",
		showAllError:true,
		datatype:{
			 "a":function(gets,obj,curform,regxp) {
				var valm=obj.val().replace(/\s+/g,"");
				var reg = /^(([0-9]+)|([0-9]+\.[0-9][0-9])|([0-9]+\.[0-9]))$/;
				var r1 = /^(?:0\.\d{1,2}|[1-9]\d{0,20}(?:\.\d{1,2})?|10)$/;
				if ("0"===valm) {
					return true;
				} else {
					if (!r1.test(valm)) {
				    	 return "格式不正确！";
				    } else if (null==valm || ""==valm) {
				    	return "不能输入空格！";
				    } else if (!reg.test(valm)) {
				    	return "小数点后请保留两位有效数字！";
				    } else {
				    	return true;
				    }
				}
			} 
		},
	});
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

var persue = null;
function init(wid) {
	getPersueInfo(wid);
	showPersueInfo("persueInfo");
	showPersueResult("persueResult");
}

function details(mode, StateDate, describe) {
	window.open(getRootPath() + "/persue/persueDetails.jsp?mode=" + mode + "&StartDate="
		+ StateDate + "&describe=" + describe + "&rn=" + Math.random(),
		"Sample",
		"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=400,height=350,left=350,top=240");
}

function thisMoney() {
	var j = 0.00;
	var checklist = document.getElementsByName("money");
	for (var i = 0; i < checklist.length; i++) {
		var data = checklist[i].value;
		if (testDecimal(data) == true) {
			j = j + Number(data);
		}
	}
	document.getElementById("persueMoney").value = j.toFixed(2);
}

function getPersueInfo(wid) {
	var data = null;
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetPersueInfo" + "?rn=" + Math.random() + "&wid="
			+ wid, false);
		xmlhttp.send();
		data = xmlhttp.responseText;
		var pl = eval("(" + data + ")");
		persue = pl.persueList;
	}
}

function showPersueInfo(persueInfo) {
	var zm = 0.0;
	var td = new Array();
	
	td.push('<table width="100%">');
	
	td.push('<tr>');
	td.push('<td>追偿起始日期</td>');
	var sdate = "";
	if (null == persue[0].startDate) {
		sdate = "";
	} else {
		sdate = persue[0].startDate;
	}
	td.push('<td>' + sdate + '</td>');
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<td>本金(元)</td>');
	td.push('<td>' + persue[0].money + '</td>');
	td.push('<td>利息(元)</td>');
	td.push('<td>' + persue[0].interest + '</td>');
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<td>罚息(元)</td>');
	td.push('<td>' + persue[0].latecharge + '</td>');
	td.push('<td>违约金(元)</td>');
	td.push('<td >' + persue[0].procedured + '</td>');
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<td>执行费用(元)</td>');
	td.push('<td>' + persue[0].execute + '</td>');
	td.push('<td>其它费用(元)</td>');
	td.push('<td>' + persue[0].other + '</td>');
	td.push('</tr>');
	
	zm = Number(persue[0].money) + Number(persue[0].interest)
		+ Number(persue[0].latecharge) + Number(persue[0].procedured)
		+ Number(persue[0].execute) + Number(persue[0].other);
	td.push('<tr>');
	td.push('<td>总金额(元)</td>');
	td.push('<td>' + zm.toFixed(2) + '</td>');
	td.push('</tr>');
	
	td.push('</table>');
	document.getElementById(persueInfo).innerHTML = td.join('');
	td = null;
}

function showPersueResult(persueResult) {
	var td = new Array();

	if (persue.length <= 0) {
		return;
	}
	td.push('<table width="100%">');
	
	td.push('<tr>');
	td.push('<th>追偿方式</th>');
	td.push('<th>追偿起始日期</th>');
	td.push('<th>追回金额(元)</th>');
	td.push('</tr>');

	for (var nn = 0; nn < persue.length; nn++) {
		var desc = persue[nn].description;
		if ("" == desc) {
			desc = null;
		}
		var strmode = "";
		switch (persue[nn].mode) {
		case '0':
			strmode = "与被担保人重新制定还款计划";
			break;
		case '1':
			strmode = "追索反担保保证人";
			break;
		case '2':
			strmode = "行使抵押权";
			break;
		case '3':
			strmode = "行使质押权";
			break;
		case '4':
			strmode = "起诉";
			break;
		default:
			strmode = "";
			break;
		}
		var sdate = "";
		if (null == persue[nn].startDate) {
			sdate = "";
		} else {
			sdate = persue[nn].startDate;
		}
		td.push('<tr>');
		td.push('<td style="display: none;">');
		td.push('<input type="text" name="mode" value="' + persue[nn].mode + '" /></td>');
		td.push('<td onclick="details(\'' + persue[nn].mode + '\',\''
				+ sdate + '\',\'' + desc + '\')">'
				+ '<a href="#">' + strmode + '</a></td>');
		td.push('<td>' + sdate + '</td>');
		td.push('<td><input type="text" name="money" onblur="thisMoney()" onkeyup="inputDecimal(this)" value="0"'
				+ 'datatype="a" nullmsg="请填写总负债" errormsg="请填写最多两位小数的数字" sucmsg=" " placeholder="必须填写" /></td>');
		td.push('</tr>');
	}
	td.push('<tr>');
	td.push('<td colspan="2">合计</td>');
	td.push('<td><input type="text" name="persueMoney" id="persueMoney" value="0" readonly /></td>');
	td.push('<tr>');
	
	td.push('</table>');
	document.getElementById(persueResult).innerHTML = td.join('');
	td = null;
}
