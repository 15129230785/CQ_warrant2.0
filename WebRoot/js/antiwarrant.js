function antiwarrant() {
	var wid = document.getElementById("wid").value;
	if (wid.length == 0) {
		alert("项目信息不能为空！");
		return;
	}
	var xmlhttp = initxmlhttp();
	if (xmlhttp != null) {
		xmlhttp.open("post", "SelectTblAntiwarrantYzWid.action?wid="
			+ wid + "&rn=" + Math.random(),
			false);
		xmlhttp.send();
		var str = xmlhttp.responseText;
		if (str == wid) {
			var aa = window.open(getRootPath()
				+ "/apply/fdb.jsp?wid=" + wid
				+ "&rn=" + Math.random(),
				"Sample",
				"fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,copyhistory=no,width=700,height=350,left=350,top=240");
			aa.focus();
			return;
		} else {
			alert("请先保存担保申请信息");
		}
	}
}

function TblAntiwarrantAjax() {
	var wid = document.getElementById("wid").value;
	var xmlhttp = initxmlhttp();
	
	xmlhttp.open("GET", "SelectAjaxTblAntiwarrant.action?wid=" + wid
			+ "&rn=" + Math.random(), false);
	xmlhttp.send();
	document.getElementById("TblAntiwarrantdiv").innerHTML = xmlhttp.responseText;
}

function updateFdbJs(kid) {
	 window.open(getRootPath() + "/apply/fdb.jsp?kid=" + kid
		 + "&rn=" + Math.random(),
		 "Sample",
		 "fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no, copyhistory=no,width=700,height=350,left=350,top=240");
}

function deleteListOne(index, wid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		if (window.confirm("您确定删除?")) {
			xmlhttp.open("GET", "OutDeleteTblAntiwarrant.action?kid=" + index
					+ "&rn=" + Math.random() + "&wid=" + wid, false);
			xmlhttp.send();
			document.getElementById("TblAntiwarrantdiv").innerHTML = xmlhttp.responseText;
			document.getElementById("TblAntiwarrantdiv").style.display = "block";
		}
	}
}

$(function() {
	getAntiwarrantType("Type");
	getAntiwarrantinfo();
	
	$('#AntiwarrantPreserveId').Validform({
			tiptype : 3,
			label : ".label",
			showAllError : true,
			datatype : {
				"a" : /.|\s/,
				"a1" : /^()?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
				// 可以为负数
				// /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/
				"aa" : /^\d+$/,
				"Value" : function() {
					var em = /^()?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
					var emai = $("#Value").val().replace(/\s+/g, "");
					if (emai == null || "" == emai) {
						return true;
					} else {
						return em.test(emai);
					}
				},
			/*"fdb" : function(gets, obj, curform, regxp) {
				var wid = document.getElementById("wid").value.replace(/\s+/g, "");
				var Type = document.getElementById("Type").value.replace(/\s+/g, "");
				var StartDate = document.getElementById("StartDate").value.replace(/\s+/g, "");
				var EndDate = document.getElementById("EndDate").value.replace(/\s+/g, "");
				var Description = document.getElementById("Description").value.replace(/\s+/g, "");
				var Value = document.getElementById("Value").value.replace(/\s+/g, "");
				var str = null;
				if (null != wid && "" != wid && null != Type
					&& "" != Type && null != StartDate
					&& "" != StartDate && null != EndDate
					&& "" != EndDate && null != Description
					&& "" != Description && null != Value
					&& "" != Value) {
					$.ajax({
						url : "YzAntiwarrantPreserveAjaxZq",// 时时验证数据库是否有重复记录
						type : "post",
						dataType : "json",
						async : false,
						data : {
							wid : wid,
							Type : Type,
							StartDate : StartDate,
							EndDate : EndDate,
							Description : Description,
							Value : Value,
							rn : Math.random()
						},
						success : function(data) {
							str = data;
						}
					});
					if ("fdbsuc" === str) {
						return true;
					} else {
						return "数据重复";
					}
				}
			},
			"fdbu" : function(gets, obj, curform, regxp) {
				var kid = document.getElementById("kid").value.replace(/\s+/g, "");
				var Type = document.getElementById("Type").value.replace(/\s+/g, "");
				var StartDate = document.getElementById("StartDate").value.replace(/\s+/g, "");
				var EndDate = document.getElementById("EndDate").value.replace(/\s+/g, "");
				var Description = document.getElementById("Description").value.replace(/\s+/g, "");
				var Value = document.getElementById("Value").value.replace(/\s+/g, "");
				var str = null;
				if (null != kid && "" != kid && null != Type
					&& "" != Type && null != StartDate
					&& "" != StartDate && null != EndDate
					&& "" != EndDate && null != Description
					&& "" != Description && null != Value
					&& "" != Value) {
				$.ajax({
					url : "YzAntiwarrantPreserveAjax",// 时时验证数据库是否有重复记录
					type : "post",
					dataType : "json",
					async : false,
					data : {
						kid : kid,
						Type : Type,
						StartDate : StartDate,
						EndDate : EndDate,
						Description : Description,
						Value : Value,
						rn : Math.random()
					},
					success : function(data) {
						str = data;
					}
				});
				if ("fdbk" === str) {
					return true;
				} else {
					return "数据重复";
				}
			}
		},*/
		},
	});
});

function getAntiwarrantinfo() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$("#AntiwarrantPreserveId").attr("action", "SavaTblAntiwarrant");
		return;
	}
	$.ajax({
		url : "GetTblAntiwarrant",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$("#AntiwarrantPreserveId").attr("action", "UpdateTblAntiwarrant");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#wid').val(data.wid);
				$('#Type').val(data.type);
				$('#StartDate').val(data.startDate);
				$('#EndDate').val(data.endDate);
				$('#Description').val(data.description.replace(/<br>/g, "\n"));
				$('#Value').val(data.value);
			} else {
				$("#AntiwarrantPreserveId").attr("action", "SavaTblAntiwarrant");
			}
		}
	});
}

