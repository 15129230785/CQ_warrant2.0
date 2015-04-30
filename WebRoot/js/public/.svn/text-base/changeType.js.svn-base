function getchangeType(id) {
	$.ajax({
		url : getRootPath() + "/config/changeType.xml",
		type : "get",
		dataType : "xml",
		async : false,
		success : function(data) {
			var cts = $("#" + id);
			cts.empty();
			$(data).find("ct").each(function(i) {
				var ct = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				cts.append(ct);
			});
		}
	});
}