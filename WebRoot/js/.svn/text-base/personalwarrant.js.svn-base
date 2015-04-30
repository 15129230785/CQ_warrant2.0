$(function() {
	initPersonWarrant();
	getTblPersonalwarrant();
	$(".personalwarrant_form").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			"a" : /.|\s/,
			"a1" : /^()?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
			// 可以为负数 /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/
			"aa" : /^\d+$/,
			"ur" : function() {
				var tr = document.getElementById("Money").value * 1;
				var ur = document.getElementById("Remaining").value * 1;
				if (ur <= tr) {
					return true;
				} else {
					return "余额金额大于贷款金额";
				}
			},
		},
	});
});
	
function getTblPersonalwarrant() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".personalwarrant_form").attr("action", "SavaTblPersonalwarrant");
		return;
	}
	$.ajax({
		url : "GetTblPersonalwarrant",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".personalwarrant_form").attr("action", "UpdateTblPersonalwarrant");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#id').val(data.id);
				$('#name').val(data.name);
				$('#b1').val(data.startDate);
				$('#b2').val(data.endDate);
				$('#Mode').val(data.mode);
				$('#Money').val(data.money);
				$('#Remaining').val(data.remaining);
				$('#description').val(data.description.replace(/<br>/g, "\n"));
			} else {
				$(".personalwarrant_form").attr("action", "SavaTblPersonalwarrant");
			}
		}
	});
}

