function getCapitalMode(id) {
	$.ajax({
		url : getRootPath() + "/config/capitalMode.xml",
		type : "get",
		dataType : "xml",
		async : false,
		success : function(data) {
			var cms = $("#" + id);
			cms.empty();
			$(data).find("cm").each(function(i) {
				var cm = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				cms.append(cm);
			});
		}
	});
}