$(function() {
	getTblIncomestatement();
	data();
	$(".incomestatement_form").Validform({
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
	
function getTblIncomestatement() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".incomestatement_form").attr("action", "SavaTblIncomestatement");
		return;
	}
	$.ajax({
		url : "GetTblIncomestatement",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".incomestatement_form").attr("action", "UpdateTblIncomestatement");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#btype').val(data.type);
				$('#Date').val(data.date);
				$('#SalesRevenue').val(data.salesRevenue);
				$('#CostofSales').val(data.costofSales);
				$('#MainBusinessProfit').val(data.mainBusinessProfit);
				$('#SellingExpenses').val(data.sellingExpenses);
				$('#ManagementExpenses').val(data.managementExpenses);
				$('#FinancingExpenses').val(data.financingExpenses);
				$('#TotalProfits').val(data.totalProfits);
				$('#NetProfit').val(data.netProfit);
				
				var tdate = $("#Date").val();
				var obj = $("#btype").val();
				if (obj == 0) {
					$("#Date").val((new Date(tdate)).format("yyyy"));
				} else {
					$("#Date").val((new Date(tdate)).format("yyyy-MM-dd"));
				}
			} else {
				$(".incomestatement_form").attr("action", "SavaTblIncomestatement");
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
