$(function() {
	showUserList($("#username").val(), "userList");
	getOneCounterSignInfo();
	
	$("#countersign").Validform({
		tiptype:3,
		label : ".label",
		showAllError:true,
		datatype:{
			"al" : /^[A-Z0-9]{9}$/,
			"a4" : /(^\d{15}$)|(^\d{17}([0-9]|X)$)/,
			"cousign" : function(gets, obj, curform, regxp) {
				var wid = document.getElementById("wid").value.replace(/\s+/g,"");
				var kid = $("#kid").val().replace(/\s+/g,"");
				var name = document.getElementById("userList").value.replace(/\s+/g,"");
				var str = "countersign";
				if (null != wid && "" != wid && null != name && "" != name
						&& !(null != kid && "" != kid && "null" != kid)) {
					$.ajax({
						url : "ApplyYanZhengcousign",
						type : "post",
						async : false,
						data : {
							wid : wid,
							name : name,
							rn : Math.random()
						},
						success : function(data) {
							str = data;
						}
					});
					if ("countersign" === str) {
						return true;
					} else {
						return "该评委已发表会签意见";
					}
				}
			},
			"mone" : function() {
				var p = document.getElementById("pass").value;
				var b = document.getElementById("description").value;
				var mm = /[\w\W]+/;
				if (p == "0" || "通过" == b) {
					return true;
				} else {
					return mm.test(b);
				}
			},
		},
	});
});

function getOneCounterSignInfo() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$("#countersign").attr("action", "SavaTblCountersign");
		return;
	}
	$.ajax({
		url : "GetTblCountersign",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$("#countersign").attr("action", "UpdateTblCountersign");

				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#wid').val(data.wid);
				
				$("#counterSignName").html("");
				var html = '<input id="name" name="name" value="' + data.name + '" readonly="readonly"';
				$("#counterSignName").html(html);
				
				$('#time').val(data.date);
				$('#number').val(data.number);
				$('#pass').val(data.result);
				$('#description').val(data.description.replace(/<br>/g, "\n"));
			} else {
				$("#countersign").attr("action", "SavaTblCountersign");
			}
		}
	});
}


