$(function() {
	getVendor();
	
	$(".TblVendorValidform").Validform({
		tiptype : 4,
		datatype : {
			"nd" : /^\d+$/,
			"nx" : /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
			"bl" : function(gets, obj, curform, regxp) {
				if (gets < 100) {
					return true;
				}
				if (gets > 100) {
					return "输入格式错误，请输入比例！";
				} else {
					return "请输入数字！";
				}
			},
			"np" : function() {
				var valm = $("#Proportion").val().replace(/\s+/g, "");
				var reg = /^(([1-9]+)|([0-9]+\.[0-9]{1,2}))$/;
				var reg1 = /^(?:0\.\d{1,2}|[1-9]\d{0,2}(?:\.\d{1,2})?|1000)$/;
				if (100 < valm) {
					return "交易额占比不能大于100%！";
				} else if (!reg1.test(valm)) {
					return "交易额占比不合法！";
				} else if (null == valm || "" == valm) {
					return "交易额占比占有率！";
				} else if (!reg.test(valm)) {
					return "小数点后请保留两位小数！";
				} else {
					return true;
				}
			}
		}
	});
});

function getVendor() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".TblVendorValidform").attr("action", "SavaTblVendor");
		return;
	}
	$.ajax({
		url : "GetTblVendor",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".TblVendorValidform").attr("action", "UpdateTblVendor");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#Name').val(data.name);
				$('#Type').val(data.type);
				$('#YearsOfCooperation').val(data.yearsOfCooperation);
				$('#AnnualVolume').val(data.annualVolume);
				$('#Proportion').val(data.proportion);
			} else {
				$(".TblVendorValidform").attr("action", "SavaTblVendor");
			}
		}
	});
}

