function getProjectDocList(wid) {
	var pdl = null;
		
	$.ajax({
		url : "GetProjectDocList",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			wid : wid,
			rn : Math.random()
		},
		success : function(data) {
			if (data != null) {
				pdl = data.docList;
			}
		}
	});
	return pdl;
}


