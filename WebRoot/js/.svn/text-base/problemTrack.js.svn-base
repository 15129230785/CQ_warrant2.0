$(function() {
	showUserList($("#name").val(), "personList");
	getTblProblemtrack();
});

function getTblProblemtrack() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$("#frmProblem").attr("action", "SavaTblProblemtrack");
		return;
	}
	$.ajax({
		url : "GetTblProblemtrack",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$("#frmProblem").attr("action", "UpdateTblProblemtrack");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#wid').val(data.wid);
				$('#name').val(data.name);
				$('#type').val(data.type);
				$('#personList').val(data.person);
				$('#state').val(data.state);
				$('#description').val(data.description.replace(/<br>/g, "\n"));
				$('#explains').val(data.explains.replace(/<br>/g, "\n"));
			} else {
				$("#frmProblem").attr("action", "SavaTblProblemtrack");
			}
		}
	});
}