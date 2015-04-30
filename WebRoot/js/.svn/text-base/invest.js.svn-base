$(function() {
	getInvestMode("mode");
	getTblInvest();

	$("#inver").Validform({
		tiptype:3,
		label:".label",
		showAllError:true,
		datatype:{
			"a2" : /.|\s/,
			"a3" : /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
			"inve" : function(gets, obj, curform, regxp) {
				var kid =document.getElementById("kid").value.replace(/\s+/g,"");
				var eid = document.getElementById("eid").value.replace(/\s+/g,"");
				var Name = document.getElementById("Name").value.replace(/\s+/g,"");
				var str = null;
				
				if (null != eid && "" != eid && null != Name && "" != Name && null != kid && "" != kid) {
					$.ajax({
						url : "Applyinvest1",//查询是否有部门名称已存在
						type : "post",
						//dataType : "json",
						async : false,
						data : {
							kid : kid,
							eid : eid,
							Name : Name,
							rn:Math.random()
						},
						success : function(data) {
							str = data;
						}
					});
					if ("invet" === str) {
						return true;
					} else {
						return "投资项目名称已存在！";
					}
				} else if (null!=eid&&""!=eid&& null!=Name&& ""!=Name) {
					$.ajax({
						url : "Applyinvest",//查询是否有部门名称已存在
						type : "post",
						async : false,
						data : {
							eid : eid,
							Name : Name,
							rn:Math.random()
						},
						success : function(data) {
							str = data;
						}
					});
					if ("invet" === str) {
						return true;
					} else {
						return "投资项目名称已存在！";
					}
				}
			},
		},
	});
}); 

function getTblInvest() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$("#inver").attr("action", "SavaTblInvest");
		return;
	}
	$.ajax({
		url : "GetTblInvest",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$("#inver").attr("action", "UpdateTblInvest");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#Name').val(data.name);
				$('#d4311').val(data.startDate);
				$('#d4312').val(data.endDate);
				$('#Money').val(data.money);
				$('#mode').val(data.investMode);
				$('#LastYearIncome').val(data.lastYearIncome);
				$('#ForecastIncome').val(data.forecastIncome);
			} else {
				$("#inver").attr("action", "SavaTblInvest");
			}
		}
	});
}

