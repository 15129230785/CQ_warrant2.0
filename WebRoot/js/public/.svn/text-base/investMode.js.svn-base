function getInvestMode(id) {
	$.ajax({
		url : getRootPath() + "/config/investMode.xml",
		type : "get",
		dataType : "xml",
		async : false,
		success : function(data) {
			var ims = $("#" + id);
			ims.empty();
			$(data).find("im").each(function(i) {
				var im = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				ims.append(im);
			});
		}
	});
}