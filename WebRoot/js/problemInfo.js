function addProblem(wid, taskname) {
	window.open(getRootPath() + "/problem-track/problemTrack.jsp?wid=" + wid
		+ "&taskname=" + taskname
		+ "&rn=" + Math.random(),
		"Sample",
		"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no, copyhistory=no,width=450,height=350,left=350,top=240");
}

function showProblemList(wid, id, pid) {
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	$.ajax({
		url : "SelectAjaxTblProblemtrack",
		type : "post",
		async : false,
		data : {
			wid : wid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$("#" + pid).html(data);
			}
		}
	});
}

function deleteProblem(kid, wid) {
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (window.confirm("您确定删除?")) {
		xmlhttp.open("GET", "OutDeleteTblProblemtrack.action?kid=" + kid
			+ "&wid=" + wid
			+ "&rn=" + Math.random(), false);
		xmlhttp.send();
		document.getElementById("TblProblemtrackdiv").innerHTML = xmlhttp.responseText;
	}
}
/* 修改评审问题记录 */
function updateProblemJs(kid) {
	window.open(getRootPath() + "/problem-track/problemTrack.jsp?kid=" + kid 
		+ "&rn=" + Math.random(),
		"Sample",
		"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=450,height=350,left=350,top=240");
}