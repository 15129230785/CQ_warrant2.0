$(function() {
	getTblCashflowstatement();
	data();
	$(".cashflowstatement_form").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			"al" : /^[A-Z0-9]{9}$/,
			"a2" : /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
			"a3" : /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
		},
	});
});
	
function getTblCashflowstatement() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".cashflowstatement_form").attr("action", "SavaTblCashflowstatement");
		return;
	}
	$.ajax({
		url : "GetTblCashflowstatement",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".cashflowstatement_form").attr("action", "UpdateTblCashflowstatement");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#btype').val(data.type);
				$('#Date').val(data.date);
				$('#ciffa').val(data.ciffa);
				$('#cifia').val(data.cifia);
				$('#cifoa').val(data.cifoa);
				$('#coffa').val(data.coffa);
				$('#cofia').val(data.cofia);
				$('#cofoa').val(data.cofoa);
				$('#ncfffa').val(data.ncfffa);
				$('#ncffia').val(data.ncffia);
				$('#ncffoa').val(data.ncffoa);
				$('#niocce').val(data.niocce);
				
				var tdate = $("#Date").val();
				var obj = $("#btype").val();
				if (obj == 0) {
					$("#Date").val((new Date(tdate)).format("yyyy"));
				} else {
					$("#Date").val((new Date(tdate)).format("yyyy-MM-dd"));
				}
			} else {
				$(".cashflowstatement_form").attr("action", "SavaTblCashflowstatement");
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

