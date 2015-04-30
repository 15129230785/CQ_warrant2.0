$(function() {
	initManager();
	getManager();
	
	$("#managersu").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			"a3":/^[A-Z0-9]{9}$|\d{18}/,
			"al":/^[A-Z0-9]{9}$/,
			"a2":/^\d+\.?\d{0,2}%$/,
			"a":/.|\s/,
			"a4":/(^\d{15}$)|(^\d{17}([0-9]|X)$)/,
			"mam":/^\d+$/,
			"manager":function(gets, obj, curform, regxp) {
				var eid = document.getElementById("eid").value.replace(/\s+/g,"");
				var Name = document.getElementById("Name").value.replace(/\s+/g,"");
				var type = document.getElementById("type").value.replace(/\s+/g,"");
				var manId = document.getElementById("manId").value.replace(/\s+/g,"");
				var str = "suc";
				if (null!=eid&&""!=eid&& null!=Name&&""!=Name&& null!=type&&""!=type&& null!=manId&&""!=manId) {
					$.ajax({
						url : "Yzmanagerfhx",//时时验证数据库是否有重复记录
						type : "post",
						dataType : "json",
						async : false,
						data : {
							eid : eid,
							Name : Name,
							type : type,
							manId : manId,
							rn : Math.random()
						},
						success : function(data) {
							str = data;
						}
					});
					if ("suc"=== str) {
						return true;
					} else {
						return "名称，职务类型或者身份证已存在";
					}
				}
			},
			"age":function () {
				var s= new Date();
				var sn = s.getUTCFullYear(s);
				var b = document.getElementById("d4311").value;
				var cha = b.substr(0, 4);
				var gz = document.getElementById("YearsOfVocation").value;
				if ((sn - cha) >= gz && gz >= 0) {
					
				} else {
					return "工作经验不能大于年龄";
				}
			},
		
			"age1":function() {
				var s = new Date();
				var sn = s.getUTCFullYear(s);
				var b = document.getElementById("d4311").value;
				var cha = b.substr(0, 4);
				var gz = document.getElementById("YearsOfManager").value;
				if ((sn - cha) >= gz && gz >= 0) {
					
				} else {
					return "工作经验不能大于年龄";
				}
			},
			"mtype":function(gets, obj, curform, regxp) {
				var eid = document.getElementById("eid").value.replace(/\s+/g,"");
				var type = document.getElementById("type").value.replace(/\s+/g,"");
				var str = "mana";
				var name=document.getElementById("Name").value.replace(/\s+/g,"");
				if (null!=eid&&""!=eid&& null!=type&& ""!=type) {
					$.ajax({
						url :"ApplyYanZheng3",
						type : "post",
						dataType : "json",
						async : false,
						data : {
							eid : eid,
							type : type,
							name : name,
							rn : Math.random()
						},
						success : function(data) {
							str = data;
						}
					});
					if ("mana" === str) {
						return true;
					} else {
						return "您输入的职务类型已存在";
					}
				}
			}
		},
	});
});

function getManager() {
	var kid = $("#kid").val();
	if (kid == null || kid == "null") {
		$("#managersu").attr("action", "SavaTblManinfo");
		return;
	}
	$.ajax({
		url : "GetTblManinfo",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$("#managersu").attr("action", "UpdateTblManinfo");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#Name').val(data.name);
				$('#type').val(data.type);
				$("input[name=Gender]").get(data.gender).checked=true;
				$("input[name=MaritalStatus]").get(data.maritalStatus).checked=true;
				$('#d4311').val(data.birthday);
				$('#Country').val(data.country);
				$('#Education').val(data.education);
				$('#manId').val(data.manId);
				$('#YearsOfManager').val(data.yearsOfManager);
				$('#YearsOfVocation').val(data.yearsOfVocation);
				$('#Record').val(data.record.replace(/<br>/g, "\n"));
			} else {
				$("#managersu").attr("action", "SavaTblManinfo");
			}
		}
	});
}

