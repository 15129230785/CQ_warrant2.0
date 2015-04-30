var cnl = null;

$(function() {
	cnl = new Array();
	
	$("#ctmenu, #addmenu").menu({
		position : {
			my : "left top",
			at : "left bottom+1px"
		},
	});
	$(".ctclass").click(function() {
		var text = $(this).text();

		if (text == "所有") {
			$("#clientType").val("0");
			$("#act").text("所有客户");
		} else if (text == "企业") {
			$("#clientType").val("1");
			$("#act").text("企业客户");
		} else if (text == "个人") {
			$("#clientType").val("2");
			$("#act").text("个人客户");
		}
		getClientName();
	});
	$(".addclass").click(function() {
		var text = $(this).text();
		if (text == "企业客户") {
			addCompanyClient();
		} else if (text == "个人客户") {
			addPersonClient();
		}
	});
	
	getClientName();
	$("#txt").autocomplete({
		source: cnl,
	});
});

function getClientName() {
	var cil = null;
	var ct = $("#clientType").val();
	
	$.ajax({
		url: "GetClientName",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			clientType : ct,
			rn : Math.random()
		},
		success: function(data) {
			cil = data.clientName;
			cnl.splice(0, cnl.length);
			if (cil != null && cil.length > 0) {
				for (var i = 0; i < cil.length; i++) {
					cnl.push(cil[i]);
				}
			}
		},
	});
}

