$(function() {
	initUndueWarrant();
	getTblUnduewarrant();
	$(".unduewarrant_form").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			"al" : /^[A-Z0-9]{9}$/,
			"a2" : /.|\s/,
			"a3" : /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
			"urw" : function() {
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
	
function getTblUnduewarrant() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".unduewarrant_form").attr("action", "SavaTblUnduewarrant");
		return;
	}
	$.ajax({
		url : "GetTblUnduewarrant",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".unduewarrant_form").attr("action", "UpdateTblUnduewarrant");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#Warrantor').val(data.warrantor);
				$('#Warrantee').val(data.warrantee);
				$('#b1').val(data.startDate);
				$('#b2').val(data.endDate);
				$('#Bank').val(data.bank);
				$('#mode').val(data.mode);
				$('#Money').val(data.money);
				$('#Remaining').val(data.remaining);
				$('#Relation').val(data.relation.replace(/<br>/g, "\n"));
			} else {
				$(".unduewarrant_form").attr("action", "SavaTblUnduewarrant");
			}
		}
	});
}

