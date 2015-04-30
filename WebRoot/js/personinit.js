$(function() {
	personInit();
	$("#con").tabs({event:"mouseover"});
	$("#personWarrant, #personBasic").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 0,
		header: "a.header",
	});
	$("#personCredit").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
	$("a.addbutton").button();
});

function personInit() {
	var taskid = document.getElementById("taskid").value;
	var wid = document.getElementById("wid").value;

	getPersonWarrantInfo(wid);
	getBankName();
	var pid = getTaskVar(taskid, "PerID");
	//alert(pid);
	if(pid != "null") {
		getPersonInfo(pid);
	} else {
		var gender = document.getElementById("Gender");
		var opt = null;
		opt = document.createElement('option');
		opt.setAttribute('value', "0");
		opt.innerHTML = "女";
		gender.appendChild(opt);
		opt = document.createElement('option');
		opt.setAttribute('value', "1");
		opt.innerHTML = "男";
		gender.appendChild(opt);
	}
}

var oldbankopt = null;
function getPersonWarrantInfo(wid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetTblWarrantinfo" + "?rn=" + Math.random() + "&wid="
				+ wid, false);
		xmlhttp.send();
		// alert(xmlhttp.responseText);
		var wi = eval('(' + xmlhttp.responseText + ')');
		if (wi != null) {
			var descript = wi.description;
			var description = descript.replace(/<br>/g, "\n");
			var Usges = wi.usages;
			var usage = Usges.replace(/<br>/g, "\n");
			var PaySourc = wi.paySource;
			var PaySour = PaySourc.replace(/<br>/g, "\n");
			var PayPlan = wi.payPlan;
			var PayPla = PayPlan.replace(/<br>/g, "\n");
			document.getElementById("Name").value = wi.name;
			document.getElementById("d11").value = wi.startDate;
			document.getElementById("Money").value = wi.practicalMoney;
			//document.getElementById("Rate").value = wi.rate;
			document.getElementById("Deadline").value = wi.deadline;
			document.getElementById("Usages").value = usage;
			document.getElementById("Description").value = description;
			document.getElementById("PaySource").value = PaySour;
			document.getElementById("PayPlan").value = PayPla;
			var bank = document.getElementById("Bank");
			oldbankopt = document.createElement('option');
			oldbankopt.setAttribute('value', wi.bank);
			oldbankopt.innerHTML = "";
			bank.appendChild(oldbankopt);
			document.getElementById("warrantBtn").value = "修改";
			document.getElementById("wi_exist").value = "1";
		} else {
			document.getElementById("wi_exist").value = "0";
		}
	}
}

function getBankName() {
	var banks = getActiveBankInfo();
	if (null == banks || "" == banks) {
		return;
	}
	
	var bs = document.getElementById("Bank");
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

function getActiveBankInfo() {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetBankName"
				+ "?rn=" + Math.random()
				+ "&active=1", false);
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

function getPersonInfo(pid) {
	if(pid == null) {
		return;
	}
	
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetPersonInfo" + "?rn=" + Math.random() + "&perID="
				+ pid, false);
		xmlhttp.send();
		//alert(xmlhttp.responseText);
		var pi = eval("(" + xmlhttp.responseText + ")");
		var gender = document.getElementById("Gender");
		var opt = null;
		if (pi != null) {
			document.getElementById("person_exist").value = "1";
			var pepledescription =  pi.description;
			var  pepledescripti = pepledescription.replace(/<br>/g, "\n");
			document.getElementById("perName").value = pi.name;
			document.getElementById("PerID").value = pi.id;
			document.getElementById("Birthday").value = pi.birthday;
			document.getElementById("Address").value = pi.address;
			document.getElementById("RegisterAddress").value = pi.registerAddress;
			document.getElementById("Vocation").value = pi.vocation;
			document.getElementById("Mobile").value = pi.mobile;
			document.getElementById("Fix").value = pi.fix;
			document.getElementById("Email").value = pi.email;
			document.getElementById("perDescription").value = pepledescripti;

			for(var i = gender.length -1; i >= 0; i--) {
				gender.removeChild(gender[i]);
			}
			if(pi.gender == "0") {
				opt = document.createElement('option');
				opt.setAttribute('value', pi.gender);
				opt.innerHTML = "女";
				gender.appendChild(opt);
				opt = document.createElement('option');
				opt.setAttribute('value', "1");
				opt.innerHTML = "男";
				gender.appendChild(opt);
			} else {
				opt = document.createElement('option');
				opt.setAttribute('value', pi.gender);
				opt.innerHTML = "男";
				gender.appendChild(opt);
				opt = document.createElement('option');
				opt.setAttribute('value', "0");
				opt.innerHTML = "女";
				gender.appendChild(opt);
			}

			document.getElementById("perBtn").value = "修改";
			document.getElementById("personinfo").setAttribute("action", "UpdateTblPerson");
			document.getElementById("personinfo").submit();
		} else {
			document.getElementById("person_exist").value = "0";
			document.getElementById("perName").value = "";
			document.getElementById("PerID").value = pid;
			document.getElementById("Birthday").value = "";
			document.getElementById("Address").value = "";
			document.getElementById("RegisterAddress").value = "";
			document.getElementById("Vocation").value = "";
			document.getElementById("Mobile").value = "";
			document.getElementById("Fix").value = "";
			document.getElementById("Email").value = "";
			document.getElementById("perDescription").value = "";
			
			for(var i = gender.length -1; i >= 0; i--) {
				gender.removeChild(gender[i]);
			}
			opt = document.createElement('option');
			opt.setAttribute('value', "0");
			opt.innerHTML = "女";
			gender.appendChild(opt);
			opt = document.createElement('option');
			opt.setAttribute('value', "1");
			opt.innerHTML = "男";
			gender.appendChild(opt);
			
			document.getElementById("personinfo").setAttribute("action", "SavaTblPerson");
			document.getElementById("perBtn").value = "保存";
		}
	}
}

function getTaskVar(taskid, name) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetTaskVar" + "?rn=" + Math.random() + "&taskid="
				+ taskid + "&varName=" + name, false);
		xmlhttp.send();
		//alert(xmlhttp.responseText);
		var data = xmlhttp.responseText;
		//var wi = eval("(" + data + ")");
		return data;
	}
}
