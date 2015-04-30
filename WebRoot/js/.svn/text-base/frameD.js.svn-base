$(document).ready(function() {
	showUserMenuList($("#userName").val());
	
	$("#menuD").menu({
		position : {
			my : "right top",
			at : "right bottom+1px"
		},
	});
	/*$("#userManage").menu();
	$("#menuDD").menu();
	
	$(".hideDiv").click(function() {
		$("#userManageDiv").hide("slide");
	});
	
	$(".toggleDiv").click(function() {
		$("#userManageDiv").slideToggle();
	});*/
});

function showUserMenuList(id) {
	var userRight = getUserRight();
	
	if (id == "root") {
		$(".user_li").show();
		$(".parameter_li").hide();
		$(".comdoclist_li").hide();
		return;
	}
	if (userRight.admin == 1) {
		$(".user_li").show();
		$(".parameter_li").show();
		$(".comdoclist_li").show();
	} else {
		$(".user_li").hide();
		$(".parameter_li").show();
		$(".comdoclist_li").show();
	}
}

