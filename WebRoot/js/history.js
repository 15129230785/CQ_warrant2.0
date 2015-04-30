$(function() {
	$(".updateTblHistory").Validform({
		tiptype : 4,
		label : ".label",
		showAllError : true,
		datatype : {
		}
	});
	$('#close').click(function() {
		window.close();
	});
	
	$.ajax({
		url : "GetEventTypeList",
		type : "post",
		dataType : "json",
		async : false,
		data : {
		},
		success : function(data) {
			if (null != data) {
				var etList = data.etList;
				for (var i = 0; i < etList.length; i++) {
					$('#eventType').append($('<option></option>')
						.attr("value", etList[i].etId)
						.text(etList[i].etName));
				}
			}
		}
	});
	getHistory();
});

function getHistory() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$("#frmHistory").attr("action", "SavaTblHistory");
		return;
	}
	$.ajax({
		url : "GetTblHistory",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$("#frmHistory").attr("action", "UpdateTblHistory");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#eventType').val(data.type);
				$('#Date').val(data.date);
				$('#Description').val(data.description.replace(/<br>/g, "\n"));
			} else {
				$("#frmHistory").attr("action", "SavaTblHistory");
			}
		}
	});
}

