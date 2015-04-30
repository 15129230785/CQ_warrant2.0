function initUndueBill() {
	$.ajax({
		url : getRootPath() + "/config/credit.xml",
		type : "get",
		dataType : "xml",
		async : false,
		success : function(data) {
			var sts = $("#type");
			sts.empty();
			$(data).find("st").each(function(i) {
				var st = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				sts.append(st);
			});
			
			var wms = $("#mode");
			wms.empty();
			$(data).find("wm").each(function(i) {
				var wm = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				wms.append(wm);
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


