$(function() {
	getProduct();
	
	$("#frmProduct").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		
		datatype : {
			"marketShare_data" : function(gets, obj, curform, regxp) {
				var valm = $("#marketShare").val().replace(/\s+/g, "");
				var reg = /^(([1-9]+)|([0-9]+\.[0-9]{1,2}))$/;
				var reg1 = /^(?:0\.\d{1,2}|[1-9]\d{0,2}(?:\.\d{1,2})?|1000)$/;
				if (100 < valm) {
					return "市场占有率不能大于100%！";
				} else if (!reg1.test(valm)) {
					return "市场占有率不合法！";
				} else if (null == valm || "" == valm) {
					return "请输入市场占有率！";
				} else if (!reg.test(valm)) {
					return "小数点后请保留两位小数！";
				} else {
					return true;
				}
			}
		}
	});
	
	$(".saveTalProduct").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,

		datatype : {
			"incomeProportion_data" : function(gets, obj, curform, regxp) {
				var sumvali = 0;
				var eid = $('#eid').val();
				$.ajax({
					url : "GetProductSale",//获取销售总额
					type : "post",
					dataType : "json",
					async : false,
					data : {
						eid : eid,
						rn : Math.random()
				},
				success : function(data) {
					sumvali = data;
				}
				});
				var vali = $("#incomeProportion").val().replace(/\s+/g, "");
				var sum = Number(sumvali) + Number(vali);
				var reg = /^(([1-9]+)|([0-9]+\.[0-9]{1,2}))$/;
				var reg1 = /^(?:0\.\d{1,2}|[1-9]\d{0,2}(?:\.\d{1,2})?|1000)$/;
				if (100 < sum) {
					return "销售收入占比不能大于100%！";
				} else if (!reg1.test(vali)) {
					return "销售收入占比不合法！";
				} else if (null == vali || "" == vali) {
					return "请输入销售收入占比！";
				} else if (!reg.test(vali)) {
					return "小数点后请保留两位小数！";
				} else {
					return true;
				}
			}
		}
	});

	$('#close').click(function() {
		window.close();
	});
	
	$(".updateTblProduct").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			"incomeProportion_data" : function(gets, obj, curform, regxp) {
				var sumvali = 0;
				var oldincome = $('#oldincome').val(); 
				var eid = $('#eid').val();
				$.ajax({
					url : "GetProductSale",//获取销售总额
					type : "post",
					dataType : "json",
					async : false,
					data : {
						eid : eid,
						rn : Math.random()
					},
					success : function(data) {
						sumvali = data;
					}
				});
				var vali = $("#incomeProportion").val().replace(/\s+/g, "");
				var sum = Number(sumvali) - Number(oldincome) + Number(vali);
				var reg = /^(([1-9]+)|([0-9]+\.[0-9]{1,2}))$/;
				var reg1 = /^(?:0\.\d{1,2}|[1-9]\d{0,2}(?:\.\d{1,2})?|1000)$/;
				if (100 < sum) {
					return "销售收入占比不能大于100%！";
				} else if (!reg1.test(vali)) {
					return "销售收入占比不合法！";
				} else if (null == vali || "" == vali) {
					return "请输入销售收入占比！";
				} else if (!reg.test(vali)) {
					return "小数点后请保留两位小数！";
				} else {
					return true;
				}
			}
		}
	});
});

function getProduct() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$("#frmProduct").attr("action", "SavaTblProduct");
		$("#frmProduct").attr("class", "saveTalProduct");
		return;
	}
	$.ajax({
		url : "GetTblProduct",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$("#frmProduct").attr("action", "UpdateTblProduct");
				$("#frmProduct").attr("class", "updateTblProduct");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#Name').val(data.name);
				$('#Type').val(data.type);
				$('#Purpose').val(data.purpose.replace(/<br>/g, "\n"));
				$('#Tech').val(data.tech);
				$('#SaleDomain').val(data.saleDomain.replace(/<br>/g, "\n"));
				$('#SaleArea').val(data.saleArea.replace(/<br>/g, "\n"));
				$('#incomeProportion').val(data.incomeProportion);
				$('#oldincome').val(data.incomeProportion);
				$('#marketShare').val(data.marketShare);
			} else {
				$("#frmProduct").attr("action", "SavaTblProduct");
				$("#frmProduct").attr("class", "saveTalProduct");
			}
		}
	});
}

