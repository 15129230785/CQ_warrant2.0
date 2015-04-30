$(function() {
	getTblSalerevenuecheck();
	data();
	$(".TblSalerevenuecheck_form").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			"al" : /^[A-Z0-9]{9}$/,
			"a2" : /.|\s/,
			"a3" : /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
		},
	});
});
	
function getTblSalerevenuecheck() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".TblSalerevenuecheck_form").attr("action", "SavaTblSalerevenuecheck");
		return;
	}
	$.ajax({
		url : "GetTblSalerevenuecheck",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".TblSalerevenuecheck_form").attr("action", "UpdateTblSalerevenuecheck");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#btype').val(data.type);
				$('#Date').val(data.date);
				$('#RevenueBasedForm').val(data.revenueBasedForm);
				$('#RevenueBasedTax').val(data.revenueBasedTax);
				$('#RevenueNoTax').val(data.revenueNoTax);
				$('#LenderSum').val(data.lenderSum);
				
				var tdate = $("#Date").val();
				var obj = $("#btype").val();
				if (obj == 0) {
					$("#Date").val((new Date(tdate)).format("yyyy"));
				} else {
					$("#Date").val((new Date(tdate)).format("yyyy-MM-dd"));
				}
			} else {
				$(".TblSalerevenuecheck_form").attr("action", "SavaTblSalerevenuecheck");
			}
		}
	});
}

function data() {
	var obj = $("#btype").val();
	var tdate = $("#Date").val();
	if (obj == 0) {
		document.getElementById("Date").onfocus=function() {
			WdatePicker({dateFmt:'yyyy'});
		};
		if (tdate) {
			$("#Date").val((new Date(tdate)).format("yyyy"));
		}
	} else {
		document.getElementById("Date").onfocus=function() {
			WdatePicker({dateFmt:'yyyy-MM-dd'});
		};
		if (tdate) {
			$("#Date").val((new Date(tdate)).format("yyyy-MM-dd"));
		}
	}
}

