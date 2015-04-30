//jQuery.noConflict();
$(function() {
	var processid = "nextLater";
	var num = $("#num").val().replace(/\s+/g, "");
	var username = $("#username").val().replace(/\s+/g, "");
	if (num == "decision") {
		var process = $("#decisionList").val().replace(/\s+/g, "");
		if (process == "0") {
			processid = "nextLater";
		} else if (process == "1") {
			processid = "stop";
		} else if (process == "2") {
			processid = "refund";
		} else if (process == "3") {
			processid = "anew";
		}
	}
	$.ajax({
		url : "GetMemShip",
		type : "post",
		dataType : "json",
		data : {
			processid : processid,
			num : num,
			username : username,
			rn:Math.random()
		},
		success : function(odata) {
			$("#selOpe").html("");
			//var odata = eval("(" + data + ")");
			var dataJson;
			if (num == "consideration") {
				if (processid == "nextLater") {
					dataJson = odata.userlists[0];
					if (dataJson != "") {
						var select = $("<select>").attr({
							name : "finance",
							id : "finance",
							value : ""
						});
						for ( var i in dataJson) {
							select.append($("<option>").html(
									dataJson[i]));
						}
						$("#tdfinance").append(select);
					}
					dataJson = odata.userlists[1];
					if (dataJson != "") {
						var select = $("<select>").attr({
							name : "law",
							id : "law",
							value : ""
						});
						for ( var i in dataJson) {
							select.append($("<option>").html(
									dataJson[i]));
						}
						$("#tdlaw").append(select);
					}
					dataJson = odata.userlists[2];
					if (dataJson != "") {
						var select = $("<select>").attr({
							name : "emcee",
							id : "emcee",
							value : ""
						});
						for ( var i in dataJson) {
							select.append($("<option>").html(
									dataJson[i]));
						}
						$("#tdemcee").append(select);
					}
					dataJson = odata.userlists[3];
					if (dataJson != "") {
						var select = $("<select>").attr({
							name : "selValue",
							id : "",
							value : ""
						});
						for ( var i in dataJson) {
							select.append($("<option>").html(
									dataJson[i]));
						}
						$("#tdnext").append(select);
					}
				}
			} else {
				dataJson = odata.userlists[0];
				if (dataJson != "") {
					var select = $("<select>").attr({
						name : "selValue",
						id : "selValue",
						value : ""
					});
					for ( var i in dataJson) {
						select.append($("<option>").html(
								dataJson[i]));
					}
					$("#selOpe").append(select);
				}
			}
		}
	});
});

$(function() {
	$("#processid").change(function() {
		var processid = $("#processid").val().replace(/\s+/g, "");
		var num = $("#num").val().replace(/\s+/g, "");
		if ((num == "decision") && (processid == "nextLater")) {
			var process = $("#decisionList").val().replace(/\s+/g, "");
			if (process == "0") {
				processid = "nextLater";
			} else if (process == "1") {
				processid = "stop";
			} else if (process == "2") {
				processid = "refund";
			} else if (process == "3") {
				processid = "anew";
			}
		}
		var username = $("#username").val().replace(/\s+/g, "");
		$.ajax({
			url : "GetMemShip",
			type : "post",
			dataType : "json",
			data : {
				processid : processid,
				num : num,
				username : username,
				rn:Math.random()
			},
			success : function(odata) {
				$("#selOpe").html("");
				$("#tdfinance").html("");
				$("#tdlaw").html("");
				$("#tdemcee").html("");
				$("#tdnext").html("");
				$("#tdrefund").html("");
				$("#tdanew").html("");
				//var odata = eval("(" + data + ")");
				var dataJson;
				if (num == "consideration") {
					if (processid == "nextLater") {
						dataJson = odata.userlists[0];
						if (dataJson != "") {
							var select = $("<select>").attr({
								name : "finance",
								id : "finance",
								value : ""
							});
							for ( var i in dataJson) {
								select.append($("<option>").html(
										dataJson[i]));
							}
							$("#tdfinance").append(select);
						}
						dataJson = odata.userlists[1];
						if (dataJson != "") {
							var select = $("<select>").attr({
								name : "law",
								id : "law",
								value : ""
							});
							for ( var i in dataJson) {
								select.append($("<option>").html(
										dataJson[i]));
							}
							$("#tdlaw").append(select);
						}
						dataJson = odata.userlists[2];
						if (dataJson != "") {
							var select = $("<select>").attr({
								name : "emcee",
								id : "emcee",
								value : ""
							});
							for ( var i in dataJson) {
								select.append($("<option>").html(
										dataJson[i]));
							}
							$("#tdemcee").append(select);
						}
						dataJson = odata.userlists[3];
						if (dataJson != "") {
							var select = $("<select>").attr({
								name : "selValue",
								id : "",
								value : ""
							});
							for ( var i in dataJson) {
								select.append($("<option>").html(
										dataJson[i]));
							}
							$("#tdnext").append(select);
						}
					} else if (processid == "refund") {
						dataJson = odata.userlists[0];
						if (dataJson != "") {
							var select = $("<select>").attr({
								name : "selValue",
								id : "",
								value : ""
							});
							for ( var i in dataJson) {
								select.append($("<option>").html(
										dataJson[i]));
							}
							$("#tdrefund").append(select);
						}
					} else if ((processid == "anew") || (processid == "transfer")) {
						dataJson = odata.userlists[0];
						if (dataJson != "") {
							var select = $("<select>").attr({
								name : "selValue",
								id : "selValue",
								value : ""
							});
							for ( var i in dataJson) {
								select.append($("<option>").html(
										dataJson[i]));
							}
							$("#tdanew").append(select);
						}
					}
				} else {
					dataJson = odata.userlists[0];
					if (dataJson != "") {
						var select = $("<select>").attr({
							name : "selValue",
							id : "selValue",
							value : ""
						});
						for ( var i in dataJson) {
							select.append($("<option>").html(
									dataJson[i]));
						}
						$("#selOpe").append(select);
					}
				}
			}
		});
	});
});

$(function() {
	$("#decisionList").change(function() {
		$("#processid").change();
	});
});
