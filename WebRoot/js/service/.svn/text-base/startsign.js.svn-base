var wid = "";
var serviceType = "";
$(function() {
	wid = $("#wid").val();
	serviceType = getServiceType(wid);
	$("#serviceType").val(serviceType);
	
	if (serviceType == "1") {
		document.getElementById("fyj").style.display = "none";
		document.getElementById("cyj").style.display = "none";
	}
	
	showReviewerList("reviewerList");
	
	$("#body").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
});

function tijiao() {
	//var j = 0;
	var checklist = $("#checkbox").val();
	var username = $("#username").val();
	
	/*for (var i = 0; i < checklist.length; i++) {
		if (checklist[i].checked) {
			j = 1;
			break;
		}
	}*/
	if (document.getElementById("processid").value == "nextLater") {
		if (document.getElementById("info").value == "") {
			alert("对不起，您未输入会签意见，请输入");
			return;
		} else {
			if (checklist != "") {
				document.getElementById("f").submit();
			} else {
				alert("对不起,您未选择评审人");
				return;
			}
		}
	} else if (document.getElementById("processid").value == "transfer") {
		if (document.getElementById("selValue").value != username) {
			document.getElementById("f").submit();
		} else {
			alert("对不起，委托人不能为自己");
			return;
		}
	}
}

function zd(id) {
	if (id == "nextLater") {
		document.getElementById("zd").style.display = "none";				
	} else {
		document.getElementById("zd").style.display = "block";
	}
}

function showReviewerList(reviewerList) {
	var reviewerList = getReviewerList();
	if (null == reviewerList) {
		return;
	}
	var size = reviewerList.length;
	//var str = "";
	if (size > 0) {
		/*str += "<table width='65%'>";
		str += "<tr>";
		for (var i = 0; i < size; i++) {
			var user = reviewerList[i];
			str += "<td width='25%'>";
			str += "<input name='checkbox' id='check' type='checkbox' value='" + user + "'>" + user;
			str += "</td>";
			if (i % 3 == 0 && i != 0) {
				str += "</tr><tr>";
			}
		}
		str += "</tr>";
		str += "</table>";*/
		var ol = $("<ol id='ollist'>");
		for(var i = 0; i < size; i++) {
			var rn = reviewerList[i];
			var li = $("<li class='ui-state-default'>").text(rn);
			ol.append(li);
		}
		$("#reviewerList").append(ol);
		ol.selectable({
			stop : function() {
				var rl = new Array();
				$(".ui-selected", this).each(function() {
					rl.push($(this).text());
				});
				$("#checkbox").empty();
				$("#checkbox").val(rl);
			}
		});
		//$("#reviewerList").html(str);
	}
	
	return;
}

var lal = null;
function showLAI(id, laInfo) {
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	if (lal == null) {
		lal = getLawauditInfo(wid);
	}
	showLawauditInfo(lal, laInfo);
}

var fel = null;
function showFEI(id, feInfo) {
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	if (fel == null) {
		fel = getFinanceestInfo(wid);
	}
	showFinanceestInfo(fel, feInfo);
}

var rel = null;
function showREI(id, reInfo) {
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	if (serviceType == "0") {
		if (rel == null) {
			rel = getCompanyRiskestInfo(wid);
		}
		showCompanyRiskestInfo(rel, reInfo);
	} else {
		if (rel == null) {
			rel = getPersonRiskestInfo(wid);
		}
		showPersonRiskestInfo(rel, reInfo);
	}
}


