function initManager() {
	$.ajax({
		url : getRootPath() + "/config/manager.xml",
		type : "get",
		dataType : "xml",
		async : false,
		success : function(data) {
			var dutys = $("#type");
			dutys.empty();
			$(data).find("duty").each(function(i) {
				var duty = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				dutys.append(duty);
			});
			
			var educations = $("#Education");
			educations.empty();
			$(data).find("education").each(function(i) {
				var education = $("<option>").text($(this).attr("desc")).val($(this).attr("value"));
				educations.append(education);
			});
			
			var maritalStatus = $("#maritalStatus");
			maritalStatus.empty();
			$(data).find("ms").each(function(i) {
				var ms = $("<input type='radio' name='MaritalStatus'>").val($(this).attr("value"));
				maritalStatus.append(ms);
				var label = $("<label>").text($(this).attr("desc"));
				maritalStatus.append(label);
			});
			
			var genders = $("#gender");
			genders.empty();
			$(data).find("gender").each(function(i) {
				var gender = $("<input type='radio' name='Gender'>").val($(this).attr("value"));
				genders.append(gender);
				var label = $("<label>").text($(this).attr("desc"));
				genders.append(label);
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


