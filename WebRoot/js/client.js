//查询
function clientInfoDivClose() {
	var xmlhttp = null;
	var clientType = $("#clientType").val();
	var txt = $("#txt").val();
	
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.open("GET", "GetClientInfo.action" + "?rn=" + Math.random()
			+ "&clientType=" + clientType + "&txt=" + txt, false);
	
	xmlhttp.send();
	$("#clientInfoDiv").html(xmlhttp.responseText);
}

function getClientDetails(eid) {
	var xmlhttp = null;
	
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	if (xmlhttp) {
		xmlhttp.open("GET", "GetComInfo" + "?rn=" + Math.random() + "&eid="
				+ eid, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var te = eval("(" + data + ")");
		return te;
	}
	return null;
}

function getCompanyType(type) {
	var name = "";
	
	$.ajax({
		url : "GetCompanyType",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				var ctList = data.ctList;
				for (var i = 0; i < ctList.length; i++) {
					if(type == ctList[i].kid) {
						name = ctList[i].cname;
						break;
					}
				}
			}
		}
	});
	return name;
}

function getCompanyProperty(property) {
	var name = "";
	
	$.ajax({
		url : "GetCompanyProperty",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				var cpList = data.cpList;
				for (var i = 0; i < cpList.length; i++) {
					if(property == cpList[i].kid) {
						name = cpList[i].cname;
						break;
					}
				}
			}
		}
	});
	return name;
}

// Mod by Luke on 2015/04/03, for modifying customer's basic information which has no tasks.
function showClientDetails(eid) {
	var cd = getClientDetails(eid);
	if (cd == null || cd.length == 0) {
		return;
	}
	var td = new Array();
	td.push('<form class="registerform" action="UpdateCompanyBasicInfo" target="hideIframe" method="post" id="cominfo">');
	td.push('<table width="100%">');
	td.push('<tr id="d">');
	td.push('<th width="15%">企业代码</th>');
	td.push('<td><input type="hidden" name="Eid" value="' + cd.eid + '"/>' + cd.eid + '</td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>企业名称</th>');
	td.push('<td>' + cd.name + '</td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>所属行业</th>');
	td.push('<td>' + getCompanyType(cd.type) + '</td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>办公地址</th>');
	td.push('<td><input type="text" name="address" style="width: 99%; margin: 0px; border: 0px; text-align: center;" value="' + cd.address + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>企业性质</th>');
	td.push('<td>' + getCompanyProperty(cd.nature) + '</td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>成立时间</th>');
	td.push('<td>' + cd.foundDate + '</td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>联系人</th>');
	td.push('<td><input type="text" name="contacts" style="width: 99%; margin: 0px; border: 0px; text-align: center;" value="' + cd.contacts + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>联系电话</th>');
	td.push('<td><input type="text" name="phone" style="width: 99%; margin: 0px; border: 0px; text-align: center;" value="' + cd.phone + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>传真</th>');
	td.push('<td><input type="text" name="fax" style="width: 99%; margin: 0px; border: 0px; text-align: center;" value="' + cd.fax + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>公司网址</th>');
	td.push('<td><input type="text" name="website" style="width: 99%; margin: 0px; border: 0px; text-align: center;" value="' + cd.website + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>电子邮箱</th>');
	td.push('<td><input type="text" name="email" style="width: 99%; margin: 0px; border: 0px; text-align: center;" value="' + cd.email + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>邮政编码</th>');
	td.push('<td><input type="text" name="postCode" style="width: 99%; margin: 0px; border: 0px; text-align: center;" value="' + cd.postCode + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>经营面积(m2)</th>');
	td.push('<td><input type="text" name="manageArea" style="width: 99%; margin: 0px; border: 0px; text-align: center;" value="' + cd.manageArea + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>基本户开户银行</th>');
	td.push('<td>' + cd.basicBankName + '</td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>基本户账号</th>');
	td.push('<td>' + cd.basicAccount + '</td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>主营业务</th>');
	td.push('<td><input type="text" name="mainBusiness" style="width: 99%; margin: 0px; border: 0px; text-align: center;" value="' + cd.mainBusiness + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>资质及证书</th>');
	td.push('<td><input type="text" name="qualification" style="width: 99%; margin: 0px; border: 0px; text-align: center;" value="' + cd.qualification + '"/></td>');
	td.push('</tr>');

	td.push('</table>');
	td.push('<br><center><input type="submit" id="perBtn" value="保存" /></center>');
	td.push('</form>');
	
	document.getElementById("companyDiv").innerHTML = td.join('');
}

function getClientPerson(eid) {
	var xmlhttp = initxmlhttp();

	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetPersonInfo" + "?rn=" + Math.random() + "&perID="
				+ eid, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var te = eval("(" + data + ")");
		return te;
	}
	return null;
}

// Mod by Luke on 2015/04/02, for modifying customer's basic information which has no tasks.
function showClientPerson(pid) {
	var cd = getClientPerson(pid);
	if (cd == null || cd.length == 0) {
		return;
	}
	
	var td = new Array();
	td.push('<form class="personform" target="hideIframe" action="UpdatePersonBasicInfo" method="post" id="personinfo">');
	td.push('<table width="100%">');
	td.push('<tr id="d">');
	td.push('<th width="15%">身份证号码</th>');
	td.push('<td><input type="hidden" name="perID" value="' + pid + '"/>' + pid + '</td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>姓名</th>');
	td.push('<td>' + cd.name + '</td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>性别</th>');
	td.push('<td>' + ((cd.gender == "1") ? "男" : "女" )  + '</td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>出生日期</th>');
	td.push('<td>' + cd.birthday + '</td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>家庭住址</th>');
	td.push('<td><input type="text" name="address" style="width: 99%;margin: 0px; border: 0px; text-align: center;" value="' + cd.address + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>户口所在地</th>');
	td.push('<td><input type="text" name="registerAddress" style="width: 99%;margin: 0px; border: 0px; text-align: center; background-color: highlighttext;" value="' + cd.registerAddress + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>职业</th>');
	td.push('<td><input type="text" name="vocation" style="width: 99%;margin: 0px; border: 0px; text-align: center;" value="' + cd.vocation + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>移动电话</th>');
	td.push('<td><input type="text" name="mobile" style="width: 99%;margin: 0px; border: 0px; text-align: center;" value="' + cd.mobile + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>固定电话</th>');
	td.push('<td><input type="text" name="fix" style="width: 99%;margin: 0px; border: 0px; text-align: center; color:" value="' + cd.fix + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>电子邮箱</th>');
	td.push('<td><input type="text" name="email" style="width: 99%;margin: 0px; border: 0px; text-align: center;" value="' + cd.email + '"/></td>');
	td.push('</tr>');

	td.push('<tr id="d">');
	td.push('<th>说明</th>');
	td.push('<td><input type="text" name="description" style="width: 99%;margin: 0px; border: 0px; text-align: center;" value="' + cd.description + '"/></td>');
	td.push('</tr>');
	
	td.push('</table>');
	td.push('<br><center><input type="submit" id="perBtn" value="保存" /></center>');
	td.push('</form>');
	
	document.getElementById("personDiv").innerHTML = td.join('');
}

function updateProjectDataJs(getWid, activityName, getState) {
	//alert(activityName);
	window.location.href = getRootPath() + "/project/projectDetail.jsp?getWid=" + getWid
		+ "&activityName=" + activityName + "&start=" + getState + "&rn=" + Math.random();
}

function procominfoJs(getWid) {
	window.location.href = getRootPath() + "/clientManager/clientPerson.jsp?getWid=" + getWid
			+ "&rn=" + Math.random();
}

function upcominfoJs(getEid) {
	window.location.href = getRootPath() + "/clientManager/clientCompany.jsp?getEid=" + getEid
			+ "&rn=" + Math.random();
}

function addCompanyClient() {
	window.location.href = getRootPath() + "/clientManager/addCompanyClient.jsp?rn=" + Math.random();
}

function addPersonClient() {
	window.location.href = getRootPath() + "/clientManager/addPersonClient.jsp?rn=" + Math.random();
}

