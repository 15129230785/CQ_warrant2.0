$(function() {
	getTblDebt();
	$(".debt_form").Validform({
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
	
function getTblDebt() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".debt_form").attr("action", "SavaTblDebt");
		return;
	}
	$.ajax({
		url : "GetTblDebt",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".debt_form").attr("action", "UpdateTblDebt");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#id').val(data.id);
				$('#loaner').val(data.loaner);
				$('#b1').val(data.startDate);
				$('#b2').val(data.endDate);
				$('#Money').val(data.money);
				$('#Remaining').val(data.remaining);
				$('#description').val(data.description.replace(/<br>/g, "\n"));
			} else {
				$(".debt_form").attr("action", "SavaTblDebt");
			}
		}
	});
}

