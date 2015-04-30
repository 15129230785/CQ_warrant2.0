function getChargeInfo(wid) {
	var chargeInfo = null;
	
	$.ajax({
		url : "GetChargeInfo",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			wid : wid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				chargeInfo = data;
			}
		},
	});
	return chargeInfo;
}

