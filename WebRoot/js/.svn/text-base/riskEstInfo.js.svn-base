function getCompanyRiskestInfo(wid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetCompanyRiskestInfo" + "?rn=" + Math.random() + "&wid="
				+ wid, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var pdl = eval("(" + data + ")");
		if(pdl == null) {
			return null;
		}
		return pdl.companyRiskestInfo;
	}
	return null;
}

function grade(number) {
	var score = "";
	switch(number) {
	case 1:
		score = "极差";
		break;
	case 2:
		score = "较差";
		break;
	case 3:
		score = "一般";
		break;
	case 4:
		score = "良好";
		break;
	case 5:
		score = "优秀";
		break;
	default:
		score = "一般";
		break;
	}
	return score;
}

function getPersonRiskestInfo(wid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetPersonRiskestInfo" + "?rn=" + Math.random() + "&wid="
				+ wid, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var pdl = eval("(" + data + ")");
		if (pdl == null) {
			return null;
		}
		return pdl.personRiskestInfo;
	}
	return null;
}

function showCompanyRiskestInfo(crl, riskInfo) {
	if (crl == null || crl.length == 0) {
		return;
	}
	
	var td = new Array();
	var size = crl.length;
	td.push('<table width="100%" id="comtable">');
	
	td.push('<tr>');
	td.push('<th width="15%">审查人姓名</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].name + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>风险审查时间</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].startDate + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="gcj">');
	td.push('<th>管理层经验</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].managerial + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="yjy">');
	td.push('<th>从业经验</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + grade(crl[i].experience) + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="yyj">');
	td.push('<th>业绩</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].achievement + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="pnp">');
	td.push('<th>品牌</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].brand + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="zl">');
	td.push('<th>占有率</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].occupancy + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="xpb">');
	td.push('<th>新品研发储备</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].reser + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="fqj">');
	td.push('<th>发展前景</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + grade(crl[i].prospect) + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="zzy">');
	td.push('<th>自然资源</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].nature + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="kzy">');
	td.push('<th>客户资源</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].client + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="qly">');
	td.push('<th>权利资源</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].myright + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="zyz">');
	td.push('<th>资源控制</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + grade(crl[i].resource) + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="zzj">');
	td.push('<th>专利专有技术</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].patent + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="ynl">');
	td.push('<th>研发能力</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].ability + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="ju">');
	td.push('<th>技术</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + grade(crl[i].skill) + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="yyq">');
	td.push('<th>有无逾期贷款记录</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].due + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="ywb">');
	td.push('<th>有无对外担保</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].warrant + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="xsq">');
	td.push('<th>信用卡使用情况</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + crl[i].credit + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="xyl">');
	td.push('<th>信用记录</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + grade(crl[i].credits) + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="Purpose2">');
	td.push('<th>借款资金用途</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + grade(crl[i].purpose) + '</td>');
	}
	td.push('</tr>');
	
	td.push('</table>');
	
	document.getElementById(riskInfo).innerHTML = td.join('');
	td = null;
}

function showPersonRiskestInfo(prl, riskInfo) {
	if (prl == null || prl.length == 0) {
		return;
	}
	
	var td = new Array();
	var size = prl.length;
	td.push('<table width="100%" id="pertable">');
	
	td.push('<tr>');
	td.push('<th width="15%">审查人姓名</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + prl[i].user + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr>');
	td.push('<th>风险审查时间</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + prl[i].startDate + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="age2">');
	td.push('<th width="15%">年齡</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + prl[i].age + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="DucationLevel2">');
	td.push('<th>最高学历</th>');
	for (var i = 0; i < size; i++) {
		var xl = "";
		switch(prl[i].ducationLevel) {
		case 0:
			xl = "高中/中专、技校";
			break;
		case 1:
			xl = "大专";
			break;
		case 2:
			xl = "本科";
			break;
		case 3:
			xl = "硕士以上";
			break;
		case 4:
		default:
			xl = "其它";
			break;
		}
		td.push('<td>' + xl + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="MartialStatus2">');
	td.push('<th>婚姻状况</th>');
	for (var i = 0; i < size; i++) {
		var ms = "";
		if (prl[i].martialStatus == 0) {
			ms = "已婚";
		} else if (prl[i].martialStatus == 1) {
			ms = "未婚";
		} else {
			ms = "离异";
		}
		td.push('<td>' + ms + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="LiveTime2">');
	td.push('<th>本地居住时间</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + prl[i].liveTime + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="SocialSecurity2">');
	td.push('<th>是否参加社保</t>');
	for (var i = 0; i < size; i++) {
		var ss = "";
		if (prl[i].socialSecurity == "0") {
			ss = "是";
		} else {
			ss = "否";
		}
		td.push('<td>' + ss + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="Job2">');
	td.push('<th>职业</th>');
	for (var i = 0; i < size; i++) {
		var job = "";
		switch (prl[i].job) {
		case 0:
			job = "企事业单位负责人";
			break;
		case 1:
			job = "专业技术人员";
			break;
		case 2:
			job = "基层服务人员";
			break;
		case 3:
			job = "个体工商户及其他";
			break;
		default:
			job = "";
			break;
		}
		td.push('<td>' + job + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="FamilyIncome2">');
	td.push('<th>家庭总收入</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + prl[i].familyIncome + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="Numb2">');
	td.push('<th>家庭人数</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + prl[i].numb + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="GrossDebt2">');
	td.push('<th>家庭总负债</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + prl[i].grossDebt + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="TotalAssets2">');
	td.push('<th>家庭总资产</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + prl[i].totalAssets + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="HousSituation2">');
	td.push('<th>住房情况</th>');
	for (var i = 0; i < size; i++) {
		var house = "";
		switch (prl[i].housSituation) {
		case 0:
			house = "无负债自有住房";
			break;
		case 1:
			house = "按揭住房";
			break;
		case 2:
			house = "租住房";
			break;
		case 3:
			house = "租住房";
			break;
		default:
			house = "";
			break;
		}
		td.push('<td>' + house + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="Reimbursement2">');
	td.push('<th>还款能力分析</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + prl[i].reimbursement + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="Cguemeforianaly2">');
	td.push('<th>反担保措施风险分析</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + prl[i].cguemeforianaly + '</td>');
	}
	td.push('</tr>');
	
	td.push('<tr id="Purpose3">');
	td.push('<th>借款资金用途</th>');
	for (var i = 0; i < size; i++) {
		td.push('<td>' + grade(prl[i].purpos) + '</td>');
	}
	td.push('</tr>');
	
	td.push('</table>');
	
	document.getElementById(riskInfo).innerHTML = td.join('');
	td = null;
}

