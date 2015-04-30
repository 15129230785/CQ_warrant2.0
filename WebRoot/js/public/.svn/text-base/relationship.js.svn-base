function initFamily() {
	$.ajax({
		url : getRootPath() + "/config/relationship.xml",
		type : "get",
		dataType : "xml",
		async : false,
		success : function(data) {
			var genders = $("#gender");
			genders.empty();
			$(data).find("gender").each(function(i) {
				var gender = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				genders.append(gender);
			});
			
			var relationships = $("#relationship");
			relationships.empty();
			$(data).find("relationship").each(function(i) {
				var relationship = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				relationships.append(relationship);
			});
		},
	});
}

function initUndueLoan() {
	$.ajax({
		url : getRootPath() + "/config/credit.xml",
		type : "get",
		dataType : "xml",
		async : false,
		success : function(data) {
			var lms = $("#mode");
			lms.empty();
			$(data).find("lm").each(function(i) {
				var lm = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				lms.append(lm);
			});
			
			var wms = $("#wmode");
			wms.empty();
			$(data).find("wm").each(function(i) {
				var wm = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				wms.append(wm);
			});
		},
	});
}

function initUndueWarrant() {
	$.ajax({
		url : getRootPath() + "/config/credit.xml",
		type : "get",
		dataType : "xml",
		async : false,
		success : function(data) {
			var wms = $("#mode");
			wms.empty();
			$(data).find("wm").each(function(i) {
				var wm = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				wms.append(wm);
			});
		},
	});
}

function initPersonWarrant() {
	$.ajax({
		url : getRootPath() + "/config/credit.xml",
		type : "get",
		dataType : "xml",
		async : false,
		success : function(data) {
			var wms = $("#Mode");
			wms.empty();
			$(data).find("wm").each(function(i) {
				var wm = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				wms.append(wm);
			});
		},
	});
}


