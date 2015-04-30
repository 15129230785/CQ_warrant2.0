$(function() {
	getTblRegshareholder();
	$(".registerStock_form").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			"al" : /^[A-Z0-9]{9}$/,
			"a2" : /.|\s/,
			"a3" : /^\+?[1-9][0-9]*$/,

			"re" : /(^\d{15}$)|(^\d{17}([0-9]|X)$)/,
			"bl" : function(gets, obj, curform, regxp) {
				if (gets < 101 && gets > 0) {
					return true;
				}
				if (gets > 101) {
					return "输入格式错误，请输入比例！";
				} else {
					return "请输入数字！";
				}
			},
			"t":function() {
				var e=/^[A-Z0-9]{9}$/;
				var as =/(^\d{15}$)|(^\d{17}([0-9]|X)$)/;
				var s =$("#Sid").val().replace(/\s+/g,""); 
				if ($("input[name=Type]").get(0).checked) {
					return e.test(s);
				} else {
					return as.test(s);
				}
			},
		},
	});
	
	$("#Sid").click(function() {
		if ($("input[name=Type]").get(0).checked) {
			$("#Sid").attr("maxlength", 9);
		} else {
			$("#Sid").attr("maxlength", 18);
		}
	});
});

function getTblRegshareholder() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".registerStock_form").attr("action", "SavaTblRegshareholder");
		return;
	}
	$.ajax({
		url : "GetTblRegshareholder",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".registerStock_form").attr("action", "UpdateTblRegshareholder");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#rid').val(data.rid);
				$('#Name').val(data.name);
				$("input[name=Type]").get(data.type).checked=true;
				$('#Sid').val(data.sid);
				$('#Share').val(data.share);
			} else {
				$(".registerStock_form").attr("action", "SavaTblRegshareholder");
			}
		}
	});
}


