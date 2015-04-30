var pnl = null;
$.wid = "";

$(function() {
	pnl = new Array();
	
	$("#ptmenu").menu({
		position : {
			my : "left top",
			at : "left bottom+1px"
		},
	});
	$(".ptclass").click(function() {
		var text = $(this).text();

		if (text == "所有") {
			$("#projectType").val("0");
			$("#apt").text("所有项目");
		} else if (text == "企业") {
			$("#projectType").val("1");
			$("#apt").text("企业项目");
		} else if (text == "个人") {
			$("#projectType").val("2");
			$("#apt").text("个人项目");
		}
		getProjectName();
	});
	
	getProjectName();
	$("#projectName").autocomplete({
		source: pnl,
	});
	
	$("#deleteProjectDiv").dialog({
		autoOpen : false,
		modal : true,
		position : {
			my : "right top",
			at : "left top",
			of : "document"
		},
		buttons : {
			"确定" : function() {
				$.ajax({
					url : "DeleteProjectInfo",
					type : "post",
					async : false,
					data : {
						wid : $.wid,
						rn : Math.random()
					},
					success : function(data) {
						$("#delRetInfo").html(data);
						$(".ui-dialog-buttonpane button:contains('确定')").button("disable");
					}
				});
			},
			"返回" : function() {
				$(this).dialog("close");
			}
		}
	});
	
	$("#endProjectDiv").dialog({
		autoOpen : false,
		modal : true,
		position : {
			my : "right top",
			at : "left top",
			of : "document"
		},
		buttons : {
			"确定" : function() {
				$.ajax({
					url : "ForceEndProcess",
					type : "post",
					async : false,
					data : {
						wid : $.wid,
						rn : Math.random()
					},
					success : function(data) {
						$("#endRetInfo").html(data);
						$(".ui-dialog-buttonpane button:contains('确定')").button("disable");
					}
				});
			},
			"返回" : function() {
				$(this).dialog("close");
			}
		}
	});
});

function getProjectName() {
	var pil = null;
	var pt = $("#projectType").val();
	
	$.ajax({
		url: "GetProjectName",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			projectType : pt,
			rn : Math.random()
		},
		success: function(data) {
			pil = data.projectName;
			pnl.splice(0, pnl.length);
			if (pil != null && pil.length > 0) {
				for (var i = 0; i < pil.length; i++) {
					pnl.push(pil[i]);
				}
			}
		},
	});
}

function projectdivclose() {
	var pt = $("#projectType").val();
	var pn = $("#projectName").val();
	var projectdiv = $("#projectDiv");
	
	$.ajax({
		url: "projectTblWarrantinfo",
		type : "post",
		async : false,
		data : {
			projectType : pt,
			projectName : pn,
			rn : Math.random()
		},
		success: function(data) {
			if (data != null) {
				projectdiv.html(data);
			}
		},
	});
}

function updateProjectInfoJs(getWid, activityName, start) {
	window.location.href = getRootPath() + "/project/projectDetail.jsp?getWid=" + getWid + "&activityName="
			+ activityName + "&start=" + start + "&rn=" + Math.random();
}

function deleteProjectInfoJs(wid) {
	/*if (window.confirm("该操作将删除项目相关流程，并且无法恢复，请确认是否执行？") == false) {
		return;
	}
	
	$.ajax({
		url : "DeleteProjectInfo",
		type : "post",
		async : false,
		data : {
			wid : wid,
			rn : Math.random()
		},
		success : function(data) {
		}
	});*/
	$.wid = wid;
	$("#deleteProjectDiv").dialog("open");
}

function forceEndProjectInfoJs(wid) {
	/*if (window.confirm("该操作将强行终止项目相关流程，并且无法恢复，请确认是否执行？") == false) {
		return;
	}
	
	$.ajax({
		url : "ForceEndProcess",
		type : "post",
		async : false,
		data : {
			wid : wid,
			rn : Math.random()
		},
		success : function(data) {
		}
	});*/
	$.wid = wid;
	$("#endProjectDiv").dialog("open");
}

