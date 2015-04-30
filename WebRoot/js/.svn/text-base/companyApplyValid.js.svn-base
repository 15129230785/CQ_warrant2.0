$(function() {
	$(".tablEmpinfo_form").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		callback : function(form) {
			if ("修改" == $('#submit').val()) {
				// alert("数据修改成功！");
			} else {
				// alert("数据保存成功！");
				$('#submit').val("修改");
			}
		},
		datatype : {
			"total" : function(gets, obj, curform, regxp) {
				/*
				 * 参数gets是获取到的表单元素值， obj为当前表单元素，
				 * curform为当前验证的表单， regxp为内置的一些正则表达式的引用。
				*/
				var masterOrUp, bachelor, bachelorBelow, senior, middle, junior, manager, productAndSale, total, m;
				masterOrUp = $('#masterOrUpE').val() == '' ? '0' : $('#masterOrUpE').val();
				bachelor = $('#bachelorE').val() == '' ? '0' : $('#bachelorE').val();
				bachelorBelow = $('#bachelorBelowE').val() == '' ? '0' : $('#bachelorBelowE').val();
				senior = $('#seniorE').val() == '' ? '0' : $('#seniorE').val();
				middle = $('#middleE').val() == '' ? '0' : $('#middleE').val();
				junior = $('#juniorE').val() == '' ? '0' : $('#juniorE').val();
				manager = $('#managerE').val() == '' ? '0' : $('#managerE').val();
				productAndSale = $('#productAndSaleE').val() == '' ? '0' : $('#productAndSaleE').val();
				total = $('#totalE').val();
				m = Number(masterOrUp) + Number(bachelor)
					+ Number(bachelorBelow) + Number(senior) + Number(middle)
					+ Number(junior) + Number(manager) + Number(productAndSale);
				if (null == total || '' == total || 0 == total) {
					return "请输入员工总人数";
				}
				if (0 != m) {
					if (m != Number(total)) {
						return "您输入的总员工数有误，请重新输入";
					} else {
						return true;
					}
				}
			}
		}
	});
});
	
$(function() {
	$('#qiye_span').click (function() {
		// 判断eid不能为空
		var eid = $('#Eid').val().replace(/\s+/g, "");
		var isOrNot = 0;
		// 到数据库查询企业基本信息表，看该条数据是否已被保存到数据库
		$.ajax({
			url : "findCompInfoIsOrNot",
			type : "post",
			async : false,
			data : {
				eid : eid,
				rn : Math.random()
			},
			success : function(data) {
				isOrNot = data;
			}
		});
		$('#eid_emp').val(eid);
		if (0 == isOrNot) {
			alert("企业代码不能为空！");
			return;
		} else {
			// 打开隐藏的div
			$("#tablEmpinfo_form").toggle();
			$('#submit').val("保存");
			// 异步从后台获取数据
			$.ajax({
				url : "getEmpInfo",
				type : "post",
				dataType : "json",
				async : false,
				data : {
					eid : eid,
					rn : Math.random()
				},
				success : function(emp) {
					if (null != emp) {
						$("#frmEmpinfo").attr("action",	"UpdateTblEmpinfo");
						$('#eid').val(emp.eid == 0 ? '' : emp.eid);
						$('#masterOrUpE').val(emp.masterOrUp == 0 ? '' : emp.masterOrUp);
						$('#bachelorE').val(emp.bachelor == 0 ? '' : emp.bachelor);
						$('#bachelorBelowE').val(emp.bachelorBelow == 0 ? '' : emp.bachelorBelow);
						$('#seniorE').val(emp.senior == 0 ? '' : emp.senior);
						$('#middleE').val(emp.middle == 0 ? '' : emp.middle);
						$('#juniorE').val(emp.junior == 0 ? '' : emp.junior);
						$('#managerE').val(emp.manager == 0 ? '' : emp.manager);
						$('#productAndSaleE').val(emp.productAndSale == 0 ? '' : emp.productAndSale);
						$('#totalE').val(emp.total == 0 ? '' : emp.total);
						$('#submit').val("修改");
					} else {
						$("#frmEmpinfo").attr("action",	"SavaTblEmpinfo");
						$('#submit').val("保存");
					}
				}
			});
		}
	});
});

$(function() {
	$(".registerform_infor").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		callback : function() {
			if ("修改" == $('#regsubmit').val()) {
				//alert("数据修改成功！");
			} else {
				//alert("数据保存成功！");
				$('#regsubmit').val("修改");
			}
		},
		datatype:{
			"a3":/^[A-Z0-9]{9}$|\d{18}/,
			"al":/^[A-Z0-9]{9}$/,
		    "a2":/^\d+\.?\d{0,2}%$/,
		    "a":/.|\s/,
		    "a4":/(^\d{15}$)|(^\d{17}([0-9]|X)$)/,
		    "ad" : function() {
				var res = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
				var regMoney = $("#RegMoney").val();
				if (regMoney != 0) {
					return res.test(regMoney);
				} else {
					return "注册资本不能为0";
				}
		    },
		    "regqx" : function() {
				var res =  /^\d+$/;
				var qx = $("#TimeLimit").val();
				if (qx != 0) {
					return res.test(qx);
				} else {
					return "经营期限不能为0";
				}
			},
		},
	});
});

$(function() {
	$(".demoform").Validform({
		tiptype : 3,
		label : ".label",
		showAllError : true,
		datatype : {
			// /^([1-9]\d+|[1-9])(\.\d\d?)*$/
			"m1" : function() {
				var res = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
				var Money = $("#Money").val();
				if (Money != 0) {
					return res.test(Money);
				} else {
					return "申请担保金额不能为0";
				}
			},
			"wiflag" : function() {
				var wiflag = $("#wi_exist").val();
				if (wiflag == "0") {
					$("#frmWarrantinfo").attr("action", "SavaTblWarrantinfo");
				} else if (wiflag == "1") {
					$("#frmWarrantinfo").attr("action", "UpdateTblWarrantinfo");
				}
			},
			"qx" : function() {
				var res =  /^\d+$/;
				var Money = $("#Deadline").val();
				if (Money != 0) {
					return res.test(Money);
				} else {
					return "贷款期限为大于0的整数";
				}
			},
			"mv" : function() {
				var res = /^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
				var Rate = $("#Rate").val();
				if (Rate >= 0) {
					return res.test(Rate);
				} else {
					return "费率输入有误";
				}
			},
			"name" : function(gets, obj, curform, regxp) {
				var str = 'sf';
				var flag = "";
				var name = $("#Name").val();
				if (name == "") {
					return false;
				}
				$.ajax({
					url : "SelectTblWarrantinfoYz.action?name="
						+ name + "&rn=" + Math.random(),
					type : "post",
					dataType : "json",
					async : false,
					success : function(data) {
						flag = data;
					}
				});
				if (flag == str) {
					return "您输入的担保项目名称已被占用！";
				} else {
					return true;
				}
			}
		}
	});
});

function addRegInfo() {
	// 判断eid不能为空
	var eid = $('#Eid').val().replace(/\s+/g, "");
	var rid = $('#rid').val().replace(/\s+/g, "");
	var isOrNot = 0;
	// 到数据库查询企业基本信息表，看该条数据是否已被保存到数据库
	$.ajax({
		url : "findCompInfoIsOrNot",
		type : "post",
		async : false,
		data : {
			eid : eid,
			rn : Math.random()
		},
		success : function(data) {
			isOrNot = data;
		},
	});
	$('#eid_reginfo').val(eid);
	if (0 == isOrNot) {
		alert("企业代码不能为空！");
		return;
	} else {
		// 打开隐藏的div
		$("#TblReginfodiv").toggle();
		$('#regsubmit').val("保存");
		// 异步从后台获取数据
		$.ajax({
			url : "getReginfo",
			type : "post",
			dataType : "json",
			async : false,
			data : {
				eid : eid,
				rid : rid,
				rn : Math.random()
			},
			success : function(reginfo) {
				// var reginfo =eval("(" +data +")");
				// alert(data);
				if (null != reginfo) {
					$("#reginfo").attr("action", "UpdateTblReginfo");
					$('#rid').val(reginfo.rid == "" ? '' : reginfo.rid);
					$('#RegName').val(reginfo.RegName == "" ? '' : reginfo.regName);
					$('#RegAddress').val(reginfo.RegAddress == "" ? '' : reginfo.regAddress);
					$('#RegDept').val(reginfo.RegDept == "" ? '' : reginfo.regDept);
					$('#RegDate').val(reginfo.regDate == "" ? '' : reginfo.regDate);
					$('#RegMoney').val(reginfo.RegMoney == "" ? '' : reginfo.regMoney);
					$('#StateTaxNum').val(reginfo.StateTaxNum == "" ? '' : reginfo.stateTaxNum);
					$('#LocalTaxNum').val(reginfo.LocalTaxNum == "" ? '' : reginfo.localTaxNum);
					$('#TimeLimit').val(reginfo.TimeLimit == "" ? '' : reginfo.timeLimit);
					$('#Scope').val(reginfo.Scope == "" ? '' : reginfo.scope);
					$('#regsubmit').val("修改");
				} else {
					$("#reginfo").attr("action", "SavaTblReginfo");
					$('#regsubmit').val("保存");
				}
			},
		});
	}
}

