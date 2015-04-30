//jQuery.noConflict();//将变量$的控制权让渡给给其他插件或库
$(function() {
	$(".finance").Validform({
		tiptype:3,
		label:".label",
		showAllError:true,
		datatype:{
			"a":function(gets,obj,curform,regxp) {
				var valm=obj.val().replace(/\s+/g,"");
				var reg = /^(([0-9]+)|([0-9]+\.[0-9][0-9])|([0-9]+\.[0-9]))$/;
				var r1 = /^(?:0\.\d{1,2}|[1-9]\d{0,20}(?:\.\d{1,2})?|10)$/;
				if ("0" === valm) {
					return true;
				} else {
					if(!r1.test(valm)) {
				    	return "格式不正确！";
				    } else if(null == valm || "" == valm) {
						return "不能输入空格！";
					} else if(!reg.test(valm)) {
						return "小数点后请保留两位有效数字！";
					} else {
						return true;
					}
				}
			} 
		},
	}); 
});


