$(function() {
	$("#cominfo").Validform({
		tiptype:3,
		label:".label",
		showAllError:true,
		callback : function(form) {
			if ("修改" == $('#comBtn').val()) {
			} else {
				$('#comBtn').val("修改");
			}
		},
		datatype : {
			"al" : /^[A-Z0-9]{9}$/,
			"a2" : /^[1-9]\d*$/,
			"a3" : /^[0-9\-\(\)\ ]+|$/,
			"aa" : /^\d+$/,
			"a8" : function() {
				var res=/^\d+$/;
				var postcode = $("#PostCode").val().replace(/\s+/g,"");
				if(postcode == null || "" == postcode) {
					return true;
				} else {
					return res.test(postcode);
				}
			},
			"cominfoflag" : function() {
				var ciflag = $("#cominfo_exist").val();
				if (ciflag == "0") {
					$("#cominfo").attr("action", "SavaTblCominfo");
				} else if (ciflag == "1") {
					$("#cominfo").attr("action", "UpdateTblCominfo");
				}
			},
			"e" : function() {
				var em=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
				var emai = $("#Email").val().replace(/\s+/g,"");
				if(emai==null||""==emai) {
					return true;
				} else {
					return em.test(emai);
				}
			},
			"url" : function() {
				var ul=/^(\w+:\/\/)?\w+(\.\w+)+.*$/;
				var ur = $("#website").val().replace(/\s+/g,"");
				if(ur == null || "" == ur) {
					return true;
				} else {
					return ul.test(ur);
				}
			},
			"pe" : function() {
				var pep=/^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]+$/;
				var pepl = $("#Contacts").val().replace(/\s+/g,"");
				if(pepl == null || "" == pepl) {
					return true;
				} else {
					return pep.test(pepl);
				}
			},
			"pm" : function() {
				var pm=/^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
				var ma = $("#ManageArea").val().replace(/\s+/g,"");
				if(ma == null || "" == ma) {
					return true;
				} else {
					return pm.test(ma);
				}
			},
			"cz" : function() {
				var fa=/^\d+$/;
				var fax = $("#Fax").val().replace(/\s+/g,"");
				if(fax == null || "" == fax) {
					return true;
				} else {
					return fa.test(fax);
				}
			},
			"bmm" : function(gets, obj, curform, regxp) {
				var ur = $("#Eid").val().replace(/\s+/g,"");
				if(ur == null||"" == ur) {
					var str='sf';
					$.ajax({
						url:"Cominfoeid.action?eid=" + ur, 
						type:"post",
						dataType:"json",
						async:false,
						success: function(data) {
							flag=data;
					 	}
					});
					if (flag == str) {
						return "您输入的公司编码存在！!";
					} else {
						return true;
					}
 				} else {
 					return true;
 				}
			},
			"comname" : function(gets, obj, curform, regxp) {
				var str='fh';
				if (gets == "") {
					return "错误";
				}
				$.ajax({
					url : "Cominname.action?Name="+gets+"&rn=" + Math.random(),
					type : "post",
					dataType : "json",
					async : false,
					success : function(data) {
						flag=data;
					}
				});
				if (flag == str) {
					return "您输入的公司名称已存在！!";
				} else {
					return true;
				};
			},
		},
	});
	//add by fhx
	$('#Eid').blur(function() {
		//判断eid不能为空
		var eid = $('#Eid').val().replace(/\s+/g,"");
		//异步从后台获取数据
		$.ajax({
			url : "GetComInfo",
			type : "post",
			dataType : "json",
			async : false,
			data : {
				eid:eid,
				rn:Math.random()
			},
			success : function(emp) {
				if (null!=emp) {
					$("#cominfo").attr("action", "UpdateTblCominfo");
					$('#Eid').val(emp.eid==0?'':emp.eid);
					$('#comName').val(emp.name==0?'':emp.name);
					$('#FoundDate').val(emp.foundDate==0?'':emp.foundDate);
					$('#type_cname').val(emp.type==0?'':emp.type);
					$('#Address').val(emp.address==0?'':emp.address);
					$('#nature').val(emp.nature==0?'':emp.nature);
					$('#Contacts').val(emp.contacts==0?'':emp.contacts);
					$('#Phone').val(emp.phone==0?'':emp.phone);
					$('#Fax').val(emp.fax==0?'':emp.fax);
					$('#website').val(emp.website==0?'':emp.website);
					$('#Email').val(emp.email==0?'':emp.email);
					$('#PostCode').val(emp.postCode==0?'':emp.postCode);
					$('#ManageArea').val(emp.manageArea==null?'':emp.manageArea);
					$('#BasicBankName').val(emp.basicBankName==0?'':emp.basicBankName);
					$('#BasicAccount').val(emp.basicAccount==0?'':emp.basicAccount);
					$('#mainBusiness').val(emp.mainBusiness==0?'':emp.mainBusiness.replace(/<br>/g, "\n"));
					$('#qualification').val(emp.qualification==0?'':emp.qualification.replace(/<br>/g, "\n"));
					$('#comBtn').val("修改");
					
					$.ajax({
						url:"UpdateTblCominfo",
						type:"post",
						dataType:"json",
						async:false,
						data:{
							taskid:$('#taskid').val(),
							Eid:$('#Eid').val(),
							Name:$('#comName').val(),
							Type:$('#type_cname').val(),
							Address:$('#Address').val(),
							Nature:$('#nature').val(),
							FoundDate:$('#FoundDate').val(),
							Contacts:$('#Contacts').val(),
							Phone:$('#Phone').val(),
							Fax:$('#Fax').val(),
							website:$('#website').val(),
							Email:$('#Email').val(),
							PostCode:$('#PostCode1').val(),
							ManageArea:$('#ManageArea').val(),
							BasicBankName:$('#BasicBankName').val(),
							BasicAccount:$('#BasicAccount').val(),
							MainBusiness:$('#mainBusiness').val(),
							Qualification:$('#qualification').val(),
						}
					});
				} else {
					$('#comBtn').val("保存");
					$("#cominfo").attr("action", "SavaTblCominfo");
				}
			}
		});
	});
});