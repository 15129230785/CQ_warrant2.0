$(function() {
	getBranch();
	
	$("#Branchinfosub").Validform({
		tiptype:3,
		label:".label",
		showAllError:true,
		datatype:{
			"al":/^[A-Z0-9]{9}$/,
			"a4":/(^\d{15}$)|(^\d{17}([0-9]|X)$)/,
			"fenzhi" : function(gets, obj, curform, regxp) {
				var kid = document.getElementById("kid").value.replace(/\s+/g,"");
				var eid = document.getElementById("eid").value.replace(/\s+/g,"");
				var Name = document.getElementById("Name").value.replace(/\s+/g,"");

				var str = "fenzhi";
				if (null!=kid&&""!=kid&&null!=eid&&""!=eid&& null!=Name&& ""!=Name) {
					$.ajax({
						url : "ApplyYanZhengfzname1",//查询是否有部门名称已存在
						type : "post",
						dataType : "json",
						async : false,
						data : {
							kid : kid,
							eid : eid,
							Name : Name,
							rn : Math.random()
						},
						success : function(data) {
							str = data;
						}
					});
					if ("fenzhi" === str) {
						return true;
					} else {
						return "部门名称已存在！";
					}
				} else if (null!=eid&&""!=eid&& null!=Name&& ""!=Name) {
					$.ajax({
						url : "ApplyYanZhengfzname",//查询是否有部门名称已存在
						type : "post",
						dataType : "json",
						async : false,
						data : {
							eid : eid,
							Name : Name,
							rn : Math.random()
						},
						success : function(data) {
							str = data;
						}
					});
					if ("fenzhi" === str) {
						return true;
					} else {
						return "部门名称已存在！";
					}
				} else {
				}
			},
			"fenzhi1" : function(gets, obj, curform, regxp) {
				var kid = document.getElementById("kid").value.replace(/\s+/g,"");
				var eid = document.getElementById("eid").value.replace(/\s+/g,"");
				var Name = document.getElementById("Name").value.replace(/\s+/g,"");

				var str = "fenzhi";
				if (null!=kid&&""!=kid&&null!=eid&&""!=eid&& null!=Name&& ""!=Name) {
					$.ajax({
						url : "ApplyYanZhengfzname1",//查询是否有部门名称已存在
						type : "post",
						dataType : "json",
						async : false,
						data : {
							kid : kid,
							eid : eid,
							Name : Name,
							rn : Math.random()
						},
						success : function(data) {
							str = data;
						}
					});
					if ("fenzhi" === str) {
						return true;
					} else {
						return "部门名称已存在！";
					}
				} else {
				}
			},
		},
	});
});

function getBranch() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$("#Branchinfosub").attr("action", "SavaTblBranchinfo");
		return;
	}
	$.ajax({
		url : "GetTblBranchinfo",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$("#Branchinfosub").attr("action", "UpdateTblBranchinfo");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#Name').val(data.name);
				$('#Description').val(data.description.replace(/<br>/g, "\n"));
			} else {
				$("#Branchinfosub").attr("action", "SavaTblBranchinfo");
			}
		}
	});
}