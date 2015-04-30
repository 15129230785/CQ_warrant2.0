$(function() {
	getTblRelatedcominfo();
	
	$(function() {
		$(".TblRelatedcominfoClass").Validform({
			tiptype:4,
			datatype:{
				"n1":/^[A-Z0-9]{9}$/,
			},
		});
	});
});

function getTblRelatedcominfo() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".TblRelatedcominfoClass").attr("action", "SavaTblRelatedcominfo");
		return;
	}
	$.ajax({
		url : "GetTblRelatedcominfo",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".TblRelatedcominfoClass").attr("action", "UpdateTblRelatedcominfo");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#relatedID').val(data.relatedID);
				$('#Name').val(data.name);
			} else {
				$(".TblRelatedcominfoClass").attr("action", "SavaTblRelatedcominfo");
			}
		}
	});
}

