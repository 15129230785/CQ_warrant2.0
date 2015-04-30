$(function() {
	getCapitalMode("Mode");
	getShareholder();
	
	$("#stocksub").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			//"a7":/^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
			"a3" : /^[A-Z0-9]{9}$|\d{18}/,
			"as" : /^[A-Z0-9]{9}$/,
			"a2" : /^\d+\.?\d{0,2}%$/,
			"at" :/(^\d{15}$)|(^\d{17}([0-9]|X)$)/,
			"a6":/^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/,
			"mone":function() {
				var b=document.getElementById("Mode").value;
				var mm=/^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
			
				var m=document.getElementById("Money").value;
				if (b == 0 || "货币" == b) {
					return mm.test(m);
				} else {
					return true;
				}
			},
			"a5":function(gets, obj, curform, regxp) {
				var kid = document.getElementById("kid").value.replace(/\s+/g,"");
				var eid = document.getElementById("eid").value.replace(/\s+/g,"");
				var name = document.getElementById("Name").value.replace(/\s+/g,"");
				var SID = document.getElementById("SID").value.replace(/\s+/g,"");
				var mode = document.getElementById("Mode").value.replace(/\s+/g,"");
				var str ="stok";
				if (null != kid && "" != kid
						&& null != eid && "" != eid
						&& null != name && "" != name
						&& null != SID && "" != SID
						&& null != mode && "" != mode) {
					$.ajax({
						url :"Yzstockerfhx1",
						type : "post",
						dataType : "json",
						async : false,
						data : {
							kid : kid,
							eid : eid,
							name : name,
							SID : SID,
							mode : mode,
							rn : Math.random()
						},
						success : function(data) {
							str = data;
						}
					});
					if ("stok" === str) {
						return true;
					} else {
						return "股东名称、编码、入资形式重复！";
					}
				} else if (null != eid && "" != eid
						&& null != name && "" != name
						&& null != SID && "" != SID
						&& null != mode && "" != mode) {
					$.ajax({
						url :"Yzstockerfhx",
						type : "post",
						async : false,
						data : {
							eid : eid,
							name : name,
							SID : SID,
							mode : mode,
							rn : Math.random()
						},
						success : function(data) {
							str = data;
						}
					});
					if ("stok" === str) {
						return true;
					} else {
						return "股东名称、编码、入资形式重复！";
					}
				}
			},
			"a7":function(gets, obj, curform, regxp) {
				var kid = document.getElementById("kid").value.replace(/\s+/g,"");
				var eid = document.getElementById("eid").value.replace(/\s+/g,"");
				var name = document.getElementById("Name").value.replace(/\s+/g,"");
				var SID = document.getElementById("SID").value.replace(/\s+/g,"");
				var mode = document.getElementById("Mode").value.replace(/\s+/g,"");
				var str = "stok1";
				if (null != kid && "" != kid
						&& null != eid && "" != eid
						&& null != name && "" != name
						&& null != SID && "" != SID
						&& null != mode && "" != mode) {
					$.ajax({
						url :"Yzstockerfhx1",
						type : "post",
						dataType : "json",
						async : false,
						data : {
							kid : kid,
							eid : eid,
							name : name,
							SID : SID,
							mode : mode,
							rn : Math.random()
						},
						success : function(data) {
							str = data;
						}
					});
					if ("stok1" === str) {
						return true;
					} else {
						return "股东名称、编码、入资形式重复！";
					}
				}
			},
			"proport":function(gets, obj, curform, regxp) {
		 		var sumvali = 0;
		 		var eid=$('#eid').val();
		 		$.ajax({
		 			 url:"Getstock",
					 type:"post",
				     async:false,
					 data:{
						 eid:eid,
						 rn:Math.random()
					 }, 
					 success:function(data){
					     sumvali = data;
					 }
		 		});
		 		var vali=$("#Proportion").val();
				var oldval = $("#oldproportion").val();
		 		var sum = Number(sumvali) - Number(oldval) + Number(vali);
		 		if(100 < sum) {
		 			return "投资比例不能大于100！";
		 		} else {
		 			return true;
		 		}
			},
			"t":function() {
				var b = $("#Type").val().replace(/\s+/g,"");
				var e=/^[A-Z0-9]{9}$/;
				var as =/(^\d{15}$)|(^\d{17}([0-9]|X)$)/;
				var s =$("#SID").val().replace(/\s+/g,""); 
				if (b == "0" || "法人股东" == b) {
					return e.test(s);
				} else if (b == "1" || "自然人股东" == b) {
					return as.test(s);
				} else {
					return true;
				}
			},
			"stype":function(gets, obj, curform, regxp) {
				var eid = document.getElementById("eid").value.replace(/\s+/g,"");
				var type = document.getElementById("Type").value.replace(/\s+/g,"");
				var str ="stk";
				if (null != eid && "" != eid && null != type && "" != type) {
					$.ajax({
					url :"ApplyYanZhengtype",
					type : "post",
					dataType : "json",
					async : false,
					data : {
						eid : eid,
						type : type,
						rn:Math.random()
					},
					success : function(data) {
						str = data;
					}
				});
				if ("stk" === str) {
					return true;
				} else {
					return "本公司法人股东已存在";
				}
			}
		}}
	});
});

function getShareholder() {
	var kid = $('#kid').val();
	
	if (kid == null || kid == "null") {
		$("#stocksub").attr("action", "SavaTblShareholder");
		return;
	}
	$.ajax({
		url : "GetTblShareholder",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$("#stocksub").attr("action", "UpdateTblShareholder");
				
				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#Name').val(data.name);
				$('#Type').val(data.type);
				$('#SID').val(data.sid);
				$('#Mode').val(data.mode);
				$('#Money').val(data.money);
				$('#Proportion').val(data.proportion);
				$('#Description').val(data.description.replace(/<br>/g, "\n"));
				$('#Value').val(data.value);
				$("#oldproportion").val(data.proportion);
			} else {
				$("#stocksub").attr("action", "SavaTblShareholder");
			}
		}
	});
}

function mxl() {
	var a = document.getElementById("Type").value;
	if (a == "法人股东" || a == 0) {
		document.getElementById("SID").maxLength = 9;
	} else {
		document.getElementById("SID").maxLength = 18;
	}
}

