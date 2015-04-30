$(function() {
	getTblBanlancesheet();
	data();
	$(".banlancesheet_form").Validform({
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
	
function getTblBanlancesheet() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".banlancesheet_form").attr("action", "SavaTblBanlancesheet");
		return;
	}
	$.ajax({
		url : "GetTblBanlancesheet",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".banlancesheet_form").attr("action", "UpdateTblBanlancesheet");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#btype').val(data.type);
				$('#Date').val(data.date);
				$('#TotalAssets').val(data.totalAssets);
				$('#CurrentAssets').val(data.currentAssets);
				$('#MoneyFunds').val(data.moneyFunds);
				$('#TemporaryInvestment').val(data.temporaryInvestment);
				$('#NoteReceivable').val(data.noteReceivable);
				$('#Receivables').val(data.receivables);
				$('#PrepaidAccounts').val(data.prepaidAccounts);
				$('#OtherReceivables').val(data.otherReceivables);
				$('#Inventory').val(data.inventory);
				$('#UnamortizedExpenditures').val(data.unamortizedExpenditures);
				$('#LongtermInvestments').val(data.longtermInvestments);
				$('#NetFixedAssets').val(data.netFixedAssets);
				$('#IntangibleandDeferredAssets').val(data.intangibleandDeferredAssets);
				$('#TotalIndebtedness').val(data.totalIndebtedness);
				$('#CurrentLiabilities').val(data.currentLiabilities);
				$('#ShorttermLoans').val(data.shorttermLoans);
				$('#NotesPayable').val(data.notesPayable);
				$('#AccountPayable').val(data.accountPayable);
				$('#DepositReceived').val(data.depositReceived);
				$('#OtherPayables').val(data.otherPayables);
				$('#ltldwoy').val(data.ltldwoy);
				$('#LongtermDebt').val(data.longtermDebt);
				$('#LongtermLoans').val(data.longtermLoans);
				$('#BondPayable').val(data.bondPayable);
				$('#LongtermPayables').val(data.longtermPayables);
				$('#OwnerEquity').val(data.ownerEquity);
				$('#PaidupCapital').val(data.paidupCapital);
				$('#CapitalReserve').val(data.capitalReserve);
				$('#UndistributedProfit').val(data.undistributedProfit);
				
				var tdate = $("#Date").val();
				var obj = $("#btype").val();
				if (obj == 0) {
					$("#Date").val((new Date(tdate)).format("yyyy"));
				} else {
					$("#Date").val((new Date(tdate)).format("yyyy-MM-dd"));
				}
			} else {
				$(".banlancesheet_form").attr("action", "SavaTblBanlancesheet");
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
		if (tdate)
			$("#Date").val((new Date(tdate)).format("yyyy"));
	} else {
		document.getElementById("Date").onfocus=function() {
			WdatePicker({dateFmt:'yyyy-MM-dd'});
		};
		if (tdate)
			$("#Date").val((new Date(tdate)).format("yyyy-MM-dd"));
	}
}
