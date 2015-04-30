function getFileList(dir) {
	var fl = null;
	$.ajax({
		url : "GetFileList",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			ment: dir,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data && data.length > 0) {
				fl = data;
			}
		}
	});
	return fl;
}

function deleteFile(dir, name) {
	var fl = null;
	var filename = name;//encodeURI(encodeURI(name));
	
	$.ajax({
		url : "DeleteFile",
		type : "post",
		async : false,
		data : {
			name: filename,
			ment: dir,
			rn : Math.random()
		},
		success : function(data) {
			fl = data;
		}
	});
	return fl;
}

function showFileList(id) {
	var dir = $("#dir").val();
	var data = getFileList(dir);
	
	if (data == null) {
		document.getElementById(id).innerHTML = "";
		return;
	}
	
	var td = new Array();
	td.push('<table width="100%">');
	td.push('<tr>');
	td.push('<th width="85%">已上传文档</th>');
	td.push('<th>操作</th>');
	td.push('</tr>');
	for (var fi = 0; fi < data.length; fi++) {
		var file = data[fi];
		if (file != null && file != "") {
			td.push('<tr>');
			td.push('<td><a href="DownloadFile.action?name=' + data[fi]
					+ '&ment=' + dir + '">' + data[fi] + '</a></td>');
			td.push('<td align="center"><a onclick="delFile(\''
					+ id + '\', \''
					+ dir + '\', \''
					+ data[fi]
					+ '\')">删除</a></td>');
			td.push('</tr>');
		}
	}
	td.push('</table>');
	document.getElementById(id).innerHTML = td.join('');
}

function delFile(id, dir, name) {
	var flag = deleteFile(dir, name);
	
	if (flag == "success") {
		showFileList(id);
	} else {
		alert("删除文件“" + name + "”失败");
	}
}