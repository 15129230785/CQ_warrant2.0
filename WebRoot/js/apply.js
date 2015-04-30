$(function() {
	$("#but").click(
		function() {
			var app = $("input[name='apply']:checked").val();
			if (app != "person" && app != "company") {
				alert("请选择申请客户类型");
				return;
			} else {
				$("#applyWarrant").submit();
			}
		}
	);
	
	$("#customtype").buttonset();
	$("button").button();
});
