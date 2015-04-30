$(function(){
	$("#alertDiv").dialog({
		autoOpen : false,
		modal : true,
		buttons : {
			"确定" : function() {
				$(this).dialog("close");
			}
		}
	});
	
	window.alert = function(txt) {
		$("#alertTxt").html(txt);
		$("#alertDiv").dialog("open");
	};
});