//jQuery.noConflict();
$(function() {
	$(".personform").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			"a" : /.|\s/,
			"a1" : /^()?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
			// 可以为负数 /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/
			"aa" : /^\d+$/,
			"a4" : /(^\d{15}$)|(^\d{17}([0-9]|X)$)/,
			"yd" : function() {
				var fa = /^\d+$/;
				var fax = $("#Mobile").val().replace(/\s+/g, "");
				if (fax == null || "" == fax) {
					return true;
				} else {
					return fa.test(fax);
				}
			},
			"personflag" : function() {
				var piflag = $("#person_exist").val();
				if (piflag == "0") {
					$("#personinfo").attr("action", "SavaTblPerson");
				} else if (piflag == "1") {
					$("#personinfo").attr("action", "UpdateTblPerson");
				}
			},
            "gd" : function() {
				var fa = /^\d+$/;
				var fax = $("#Fix").val().replace(/\s+/g, "");
				if (fax == null || "" == fax) {
					return true;
				} else {
					return fa.test(fax);
				}
			},
			"eml" : function() {
				var em = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
				var emai = $("#Email").val().replace(/\s+/g, "");
				if (emai == null || "" == emai) {
					return true;
				} else {
					return em.test(emai);
				}
			},
		},
	});
});
$(function() {
	$(".demoform").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			"a" : /.|\s/,
			"a1" : /^()?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
			// 可以为负数 /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/
			"aa" : /^\d+$/,
			"m" : function() {
				var res = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
				var Money = $("#Money").val();
				if (Money != 0) {
					return res.test(Money);
				} else {
					return "申请担保金额不能为0";
				}
			},
			"m1" : function() {
				var res = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
				var Money = $("#Deadline").val();
				if (Money != 0) {
					return res.test(Money);
				} else {
					return "申请担保金额不能为0";
				}
			},
			"wiflag" : function() {
				var wiflag = $("#wi_exist").val();
				if (wiflag == "0") {
					$("#frmWarrantinfo").attr("action", "SavaTblWarrantinfo");
				} else if (wiflag == "1") {
					$("#frmWarrantinfo").attr("action", "UpdateTblWarrantinfo");
				}
			},
            "bank": function(gets, obj, curform, regxp) {
            	var Money = document.getElementById("Money").value.replace(/\s+/g,"");
            	var Bank = document.getElementById("Bank").value.replace(/\s+/g,"");
			
				var str = null;
				if (null != Money && "" != Money && null != Bank && "" != Bank) {
					$.ajax({
						url : "Applybank",//担保额度
						type : "post",
						dateType : "json",
						async : false,
						data : {
							Money : Money,
							Bank : Bank,
							
						},
						success : function(data) {
							str = data;
						}
					});
					if ("bank" === str) {
						return true;
					} else {
						return "担保额度不能大于本行授信额度";
					}
				} else {
					
				} 
			},
		},
	});
});




