$(function() {
	getchangeType("type");
	getTblChangeinfo();
	$(".zcbg_form").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			"al" : /^[A-Z0-9]{9}$/,
			"a2" : /.|\s/,
			"a3" : /^\+?[1-9][0-9]*$/,
			"re" : /(^\d{15}$)|(^\d{17}([0-9]|X)$)/,
		},
	});
});

function getTblChangeinfo() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".zcbg_form").attr("action", "SavaTblChangeinfo");
		return;
	}
	$.ajax({
		url : "GetTblChangeinfo",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".zcbg_form").attr("action", "UpdateTblChangeinfo");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#rid').val(data.rid);
				$('#chgDate').val(data.chgDate);
				$('#type').val(data.chgType);
				$('#Description').val(data.description.replace(/<br>/g, "\n"));
			} else {
				$(".zcbg_form").attr("action", "SavaTblChangeinfo");
			}
		}
	});
}
