$(function() {
	initFamily();
	getTblFamily();
	
	$(function() {
		$(".family_form").Validform({
			tiptype : 3,
			label : ".label",
			showAllError : true,
			datatype : {
				"a" : /.|\s/,
				"a1" : /^()?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
				// 可以为负数 /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/
				"aa" : /^\d+$/,
				"a4" : /(^\d{15}$)|(^\d{17}([0-9]|X)$)/
			},
		});
	});
});
	
function getTblFamily() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$(".family_form").attr("action", "SavaTblFamily");
		return;
	}
	$.ajax({
		url : "GetTblFamily",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$(".family_form").attr("action", "UpdateTblFamily");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#id').val(data.id);
				$('#name').val(data.name);
				$('#sid').val(data.sid);
				$('#gender').val(data.gender);
				$('#birthday').val(data.birthday);
				$('#vocation').val(data.vocation);
				$('#relationship').val(data.relationship);
				$('#description').val(data.description.replace(/<br>/g, "\n"));
			} else {
				$(".family_form").attr("action", "SavaTblFamily");
			}
		}
	});
}

