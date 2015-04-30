$(function() {
	initUndueBill();
	getTblUnduebill();
	$(".unduebill_form").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			"al" : /^[A-Z0-9]{9}$/,
			"a2" : /.|\s/,
			"a3" : /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
			"urb" : function() {
				var tr = document.getElementById("Money").value * 1;
				var ur = document.getElementById("Remaining").value * 1;
				if (ur <= tr) {
					return true;
				} else {
					return "余额金额大于贷款金额";
				}
			}
		},
	});
});
	
function getTblUnduebill() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".unduebill_form").attr("action", "SavaTblUnduebill");
		return;
	}
	$.ajax({
		url : "GetTblUnduebill",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".unduebill_form").attr("action", "UpdateTblUnduebill");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#type').val(data.type);
				$('#c1').val(data.startDate);
				$('#c2').val(data.endDate);
				$('#Money').val(data.money);
				$('#Loaner').val(data.loaner);
				$('#mode').val(data.mode);
				$('#Remaining').val(data.remaining);
			} else {
				$(".unduebill_form").attr("action", "SavaTblUnduebill");
			}
		}
	});
}

