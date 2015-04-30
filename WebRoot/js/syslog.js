$(function(){
	showLogFileList('filelistdiv');
	$("#dlBtn").click(function(){
		$("#frmdl").submit();
	});
	$("a").button();
});

function getFileList() {
	var fl = null;
	$.ajax({
		url : "SysLog!getLogFileList",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				fl = data;
			}
		}
	});
	return fl;
}

function showLogFileList(id) {
	var data = getFileList();
	
	if (data == null) {
		$("#" + id).html();
		return;
	}
	
	var td = new Array();
	td.push('<table width="100%">');
	td.push('<tr>');
	td.push('<th width="85%">系统日志文件</th>');
	td.push('</tr>');
	for (var fi = 0; fi < data.length; fi++) {
		var file = data[fi];
		if (file != null && file != "") {
			td.push('<tr>');
			td.push('<td>' + data[fi] + '</td>');
			td.push('</tr>');
		}
	}
	td.push('</table>');
	$("#" + id).html(td.join(''));
}

