$(function() {
	initUndueLoan();
	getTblUndueloan();
	$(".undueloan_form").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			"al" : /^[A-Z0-9]{9}$/,
			"a2" : /.|\s/,
			"a3" : /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
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
	
function getTblUndueloan() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".undueloan_form").attr("action", "SavaTblUndueloan");
		return;
	}
	$.ajax({
		url : "GetTblUndueloan",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".undueloan_form").attr("action", "UpdateTblUndueloan");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#Borrower').val(data.borrower);
				$('#b1').val(data.startDate);
				$('#b2').val(data.endDate);
				$('#bank').val(data.bank);
				$('#Rate').val(data.rate);
				$('#Loaner').val(data.loaner);
				$('#wmode').val(data.wmode);
				$('#mode').val(data.mode);
				$('#Money').val(data.money);
				$('#Remaining').val(data.remaining);
			} else {
				$(".undueloan_form").attr("action", "SavaTblUndueloan");
			}
		}
	});
}

