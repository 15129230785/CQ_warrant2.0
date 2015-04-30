function getAntiwarrantType(id) {
	$.ajax({
		url : getRootPath() + "/config/antiWarrantType.xml",
		type : "get",
		dataType : "xml",
		async : false,
		success : function(data) {
			var atts = $("#" + id);
			atts.empty();
			$(data).find("att").each(function(i) {
				var att = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				atts.append(att);
			});
		}
	});
}