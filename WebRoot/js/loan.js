var banks = null;
var customerType = null; // 申明客户类型，用于按条件查询对应客户担保信息

$(function() {
	loanInit();
	$("#con").tabs();
	getBankName();
	getBankNameOnPersonDiv();
});

function loanInit() {
	banks = getBankInfo();
	showTblWarrantinfoCompany();
	showTblWarrantinfoPersonage();
}

// Begin: Add by Luke Chen on 2015/04/22, for search projects with options
function getBankNameOnPersonDiv() {
	banks = getActiveBankInfo();
	if (null == banks || "" == banks) {
		return;
	}
		
	var bs = document.getElementById("bankPersonSelect");
	var optDefault = document.createElement('option');
	optDefault.setAttribute('value', '');
	optDefault.innerHTML = '';
	bs.appendChild(optDefault);
	
	for (var i = 0; i < banks.length; i++) {
		var opt = document.createElement('option');
		if((oldbankopt != null) && (banks[i].bid == oldbankopt.value)) {
			oldbankopt.innerHTML = banks[i].name;
			continue;
		}
		opt.setAttribute('value', banks[i].bid);
		opt.innerHTML = banks[i].name;
		bs.appendChild(opt);
	}
}

function loanSearchWithConditions() {
	var xmlhttp = initxmlhttp();
	var bankFilter = null;
	var loanDateFilter = null;
	
	if (customerType == '0') {
		bankFilter = $("#Bank").val();
		loanDateFilter = $("#loanDateFilterCompany").val();
	}
	else if (customerType == '1')
	{
		bankFilter = $("#bankPersonSelect").val();
		loanDateFilter = $("#loanDateFilterPerson").val();
	}
	
	if (xmlhttp != null)
	{
		xmlhttp.open("GET", "GetTblWarrantinfoListWithConditions" + "?rn=" + Math.random()
				 + "&bankFilter=" + bankFilter + "&loanDateFilter=" + loanDateFilter
				 + "&type=" + customerType, false);
		xmlhttp.send();
		
		var data = xmlhttp.responseText;
		if (null == data || "" == data)
		{
			return null;
		}
		
		var projectList = eval("(" + data + ")");
		
		return projectList;
	}
	
	return null;
}

function showTblWarrantinfoWithOptions(type){
	var warrantinfo = null;
	customerType = type;
	warrantinfo = loanSearchWithConditions();
	
	if (warrantinfo == null || warrantinfo == "" || warrantinfo.length == 0) 
	{
		return;
	}

	var td = new Array();
	
	td.push('<table width="100%" border="1">');
	
	if (customerType == '0') 
	{
		td.push('<caption style="height: 18px;">西安红杉融资担保股份有限公司（公司部分）</caption>');
	} 
	else if (customerType == '1') 
	{
		td.push('<caption style="height: 18px;">西安红杉融资担保股份有限公司（个人部分）</caption>');
	}
	
	td.push('<thead>');
	td.push('<tr id="r">');
	td.push('<th width="4%">序号</th>');
	td.push('<th width="21%">名称</th>');
	td.push('<th width="21%">贷款行</th>');
	td.push('<th width="10%">担保金额(万元)</th>');
	td.push('<th width="24%">担保期限</th>');
	td.push('<th width="12%">放款日期</th>');
	td.push('<th width="8%">合计</th>');
	td.push('</tr>');
	td.push('</thead>');
	td.push('<tbody>');
	
	for (var gi = 0; gi < warrantinfo.length; gi++) {
		td.push('<tr id="d">');
		td.push('<td>' + (gi + 1) + '</td>');
		td.push('<td>' + warrantinfo[gi].name + '</td>');
		
		var bankname = "";
		for (var i = 0; i < banks.length; i++) {
			if(banks[i].bid == warrantinfo[gi].bank) {
				bankname = banks[i].name;
				break;
			}
		}
		td.push('<td>' + bankname + '</td>');
		
		td.push('<td>' + warrantinfo[gi].money + '</td>');
		td.push('<td>' + getDeadline(warrantinfo[gi].warrantStartDate, warrantinfo[gi].warrantEndDate) + '</td>');
		td.push('<td>' + getLoanDate(warrantinfo[gi].warrantLoanDate) + '</td>');
		td.push('<td></td>');
		td.push('</tr>');
	}

	td.push('</tbody>');
	td.push('</table>');
	
	if (customerType == '0') 
	{
		document.getElementById("companyDiv").innerHTML = td.join('');
	} 
	else if (customerType == '1') 
	{
		document.getElementById("personageDiv").innerHTML = td.join('');
	}
	
	td = null;
}


//End: Add by Luke Chen on 2015/04/22, for search projects with options

function getBankInfo() {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetBankName"
				+ "?rn=" + Math.random()
				+ "&active=0", false);
		xmlhttp.send();
		var banks = eval("(" + xmlhttp.responseText + ")");
		if (banks == null) {
			return null;
		} else {
			return banks.banks;
		}
	} else {
		return null;
	}
}

function getTblWarrantinfo(type) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetTblWarrantinfoList" + "?rn=" + Math.random() + "&type=" + type, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		if (null == data || "" == data) {
			return null;
		}
		var ul = eval("(" + data + ")");
		return ul;
	}
	return null;
}

function showTblWarrantinfoCompany() {
	var type = 0;
	var warrantinfo = getTblWarrantinfo(type);
	if (warrantinfo == null || warrantinfo == "" || warrantinfo.length == 0) {
		return;
	}

	var td = new Array();
	
	td.push('<table width="100%" border="1">');
	td.push('<caption style="height: 18px;">西安红杉融资担保股份有限公司（公司部分）</caption>');
	td.push('<thead>');
	td.push('<tr id="r">');
	td.push('<th width="4%">序号</th>');
	td.push('<th width="21%">名称</th>');
	td.push('<th width="21%">贷款行</th>');
	td.push('<th width="10%">担保金额(万元)</th>');
	td.push('<th width="24%">担保期限</th>');
	td.push('<th width="12%">放款日期</th>');
	td.push('<th width="8%">合计</th>');
	td.push('</tr>');
	td.push('</thead>');
	td.push('<tbody>');
	
	for (var gi = 0; gi < warrantinfo.length; gi++) {
		td.push('<tr id="d">');
		td.push('<td>' + (gi + 1) + '</td>');
		td.push('<td>' + warrantinfo[gi].name + '</td>');
		
		var bankname = "";
		for (var i = 0; i < banks.length; i++) {
			if(banks[i].bid == warrantinfo[gi].bank) {
				bankname = banks[i].name;
				break;
			}
		}
		td.push('<td>' + bankname + '</td>');
		
		td.push('<td>' + warrantinfo[gi].money + '</td>');
		td.push('<td>' + getDeadline(warrantinfo[gi].warrantStartDate, warrantinfo[gi].warrantEndDate) + '</td>');
		td.push('<td>' + getLoanDate(warrantinfo[gi].warrantLoanDate) + '</td>');
		td.push('<td></td>');
		td.push('</tr>');
	}

	td.push('</tbody>');
	td.push('</table>');
	
	document.getElementById("companyDiv").innerHTML = td.join('');
	td = null;
}

function showTblWarrantinfoPersonage() {
	var type = 1;
	var warrantinfo = getTblWarrantinfo(type);
	if (warrantinfo == null || warrantinfo.length == 0) {
		return;
	}
	var td = new Array();
	
	td.push('<table width="100%" border="1">');
	td.push('<caption style="height: 18px;">西安红杉融资担保股份有限公司（个人部分）</caption>');
	td.push('<thead>');
	td.push('<tr id="r">');
	td.push('<th width="4%">序号</th>');
	td.push('<th width="21%">名称</th>');
	td.push('<th width="21%">贷款行</th>');
	td.push('<th width="10%">担保金额(万元)</th>');
	td.push('<th width="24%">担保期限</th>');
	td.push('<th width="12%">放款日期</th>');
	td.push('<th width="8%">合计</th>');
	td.push('</tr>');
	td.push('</thead>');
	td.push('<tbody>');
	
	for (var gi = 0; gi < warrantinfo.length; gi++) {
		td.push('<tr id="d">');
		td.push('<td>' + (gi + 1) + '</td>');
		td.push('<td>' + warrantinfo[gi].name + '</td>');
		
		var bankname = "";
		for (var i = 0; i < banks.length; i++) {
			if(banks[i].bid == warrantinfo[gi].bank) {
				bankname = banks[i].name;
				break;
			}
		}
		td.push('<td>' + bankname + '</td>');
		td.push('<td>' + warrantinfo[gi].money + '</td>');
		td.push('<td>' + getDeadline(warrantinfo[gi].warrantStartDate, warrantinfo[gi].warrantEndDate) + '</td>');
		td.push('<td>' + getLoanDate(warrantinfo[gi].warrantLoanDate) + '</td>');
		td.push('<td></td>');
		td.push('</tr>');
	}

	td.push('</tbody>');
	td.push('</table>');
	
	document.getElementById("personageDiv").innerHTML = td.join('');
	td = null;
}

function outyyyyMMdd(sdate) {
	var date = new String(sdate);
	var year = new String(date.substring(0, 4));
	var month = new String(date.substring(5, 7));
	if (month.charAt(0) == '0') {
		month = month.charAt(1);
	}
	var day = new String(date.substring(8, 10));
	if (day.charAt(0) == '0') {
		day = day.charAt(1);
	}
	return year + "年" + month + "月" + day + "日";
}

function getDeadline(start, end) {
	var deadline = "";
	
	if (start != "" && end != "") {
		deadline = outyyyyMMdd(start) + "-" + outyyyyMMdd(end);
	}
	return deadline;
}

function getLoanDate(loandate) {
	var ldate = "";
	
	if (loandate != "") {
		ldate = outyyyyMMdd(loandate);
	}
	return ldate;
}

