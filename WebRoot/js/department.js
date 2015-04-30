 $(function() {
	 getDeptinfo();
 
	$("#departsub").Validform({
	tiptype:3,
	label:".label",
	showAllError:true,
    datatype:{
	 	"al":/^[A-Z0-9]{9}$/,
        "a4":/(^\d{15}$)|(^\d{17}([0-9]|X)$)/,
        "depart" : function(gets, obj, curform, regxp) {
        	var   eid = document.getElementById("eid").value.replace(/\s+/g,"");
        	var   Name = document.getElementById("Name").value.replace(/\s+/g,"");
		
			var str = "depart";
			if (null!=eid&&""!=eid&& null!=Name&& ""!=Name) {
				$.ajax({
					url : "ApplyYanZhengdparname",//查询是否有部门名称已存在
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
				if ("depart" === str) {
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

function getDeptinfo() {
	var kid = $('#kid').val();
	if (kid == null || kid == "null") {
		$("#departsub").attr("action", "SavaTblDeptinfo");
		return;
	}
	$.ajax({
		url : "GetTblDeptinfo",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			kid : kid,
			rn : Math.random()
		},
		success : function(data) {
			if (null != data) {
				$("#departsub").attr("action", "UpdateTblDeptinfo");

				$('#kid').val(kid);
				$('#kid').attr("name", "kid");
				$('#eid').val(data.eid);
				$('#Name').val(data.name);
				$('#Duty').val(data.duty.replace(/<br>/g, "\n"));
			} else {
				$("#departsub").attr("action", "SavaTblDeptinfo");
			}
		}
	});
}
