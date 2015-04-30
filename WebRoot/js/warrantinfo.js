 $(function() {
	$("#Warrantinfo").Validform({
		tiptype:3,
		label:".label",
		showAllError:true,
		datatype:{
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
				}
			},
		},
	});
}); 
