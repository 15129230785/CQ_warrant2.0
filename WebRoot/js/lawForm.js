//jQuery.noConflict();
$(function() {
	$(".idform").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			"a" : /.|\s/,
			"a1" : /^()?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
			
			"aa" : /^\d+$/,
		},
	});
});
			