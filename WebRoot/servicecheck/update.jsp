<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String comtype = request.getParameter("comtype");
	String comrevenue = request.getParameter("comrevenue");
	String employee = request.getParameter("employee");
	String year = request.getParameter("year");
	String mortgage = request.getParameter("mortgage");
	String address = new String(request.getParameter("address").getBytes("ISO8859-1"), "UTF-8");
	String vocation = new String(request.getParameter("vocation").getBytes("ISO8859-1"), "UTF-8");
	String income = request.getParameter("income");
	String personmortgage = request.getParameter("personmortgage");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改业务检查参数</title>

<style type="text/css">
.center_content_head span {
	padding-left: 6px;
	line-height: 18px;
	color: #A5A5A5;
	font-size: 13px;
}

.center_content_head span.cchhover {
	padding-left: 5px;
	line-height: 18px;
	color: #0D7DB9;
	font-size: 14px;
	font-weight: bold;
}

.edit_comp .star_color {
	color: red;
	font-size: 12px;
	padding-right: 5px;
}
</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/initXMLHTTP.js"></script>
<script type="text/javascript">
	var company = null;
	var xmlhttp = null;
	
	function selectComType() {
		document.getElementById("comtypediv").style.display = "block";
	}
	
	function returnComType() {
		var v = "";
		var s;
		var cs = "";
		var size = company.length;
		for (var i = 0; i < size; i++) {
			s = "comtypelist" + i;
			if (document.getElementById(s).checked) {
				v += document.getElementById(s).value;
				v += ",";
				cs += document.getElementById(s).name;
				cs += ",";
			}
		}
		if (v.length > 1) {
			v = v.substr(0, v.length-1);
			cs = cs.substr(0, cs.length-1);
		}
		document.getElementById("comtype").value = v;
		document.getElementById("comtypetext").value = cs;
		
		document.getElementById("comtypediv").style.display = 'none';
	}
	function returnNull() {
		document.getElementById("comtypediv").style.display = 'none';
	}

	function getCompanyType() {
		if (xmlhttp) {
			xmlhttp.open("GET", "GetCompanyType" + "?rn=" + Math.random(), false);
			xmlhttp.send();
			//alert(xmlhttp.responseText);
			var data = xmlhttp.responseText;
			//alert(data);
			var wi = eval("(" + data + ")");
			return wi.ctList;
		}
		return null;
	}
	
	function showCompanyType(comtypediv) {
		company = getCompanyType();
		if (company == null || company.length == 0) {
			return;
		}
		var td = new Array();
		
		td.push('<table>');
		
		for (var ci = 0; ci < company.length; ci++) {
			td.push('<tr>');
			td.push('<td style="width: 10px;">');
			td.push('<input type="checkbox" class="comp_input" name="' + company[ci].cname
					+ '" id="comtypelist"' + ci + '"'
					+ ' value="' + company[ci].name +'"/>');
			td.push('</td>');
			td.push('<td>');
			td.push('<label for="' + company[ci].cname + '">' + company[ci].cname + '</label>');
			td.push('</td>');
			if (ci % 3 == 0) {
				td.push('</tr><tr>');
			}
			td.push('</tr>');
		}
		td.push('</table>');
		
		document.getElementById(comtypediv).innerHTML = td.join('');
		td = null;
	}
	
	function init() {
		xmlhttp = initxmlhttp();
		showCompanyType("comtypediv");
	}
</script>
</head>
<body onload="init()">
	<div class="center_content_head">
		<span class="cchhover"><font class="head_fcl"></font>修改业务检查参数</span>
	</div>
	<div class="center_content_top"></div>
	<div class="edit_wrap">
		<div class="edit_comp">
			<form action="updateSrvChk" method="post">
			<input type="text" name="comtype" id="comtype" style="display : none" />
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>允许担保的行业：</span></td>
						<td class="edit_comp_r">
						<textarea class="comp_input" name="comtypetext" id="comtypetext" style="width: 230px;" readonly="readonly"></textarea>
						<button type="button" onclick="selectComType()">请选择</button>
						</td>
					</tr>
				</table>
				<div id="comtypediv" style="display : none">
					<button type="button" onclick="returnComType()">确定</button>
					<button type="button" onclick="returnNull()">返回</button>
				</div>
				<table>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>企业营业收入：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="comrevenue" id="comrevenue" style="width: 200px;"
							type="text" value="<%=comrevenue%>" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>企业从业人数：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="employee" id="employee" style="width: 200px;" type="text"
							value="<%=employee%>" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>企业连续经营年限：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="year" id="year" style="width: 200px;" type="text"
							value="<%=year%>" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>企业可抵押资产占比：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="mortgage" id="mortgage" style="width: 200px;" type="text"
							value="<%=mortgage%>" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>户口所在地：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="address" id="address" style="width: 200px;" type="text"
							value="<%=address%>" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>职业：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="vocation" id="vocation" style="width: 200px;" type="text"
							value="<%=vocation%>" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>年收入情况：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="income" id="income" style="width: 200px;" type="text"
							value="<%=income%>" /></td>
					</tr>
					<tr>
						<td class="edit_comp_l" style="width: 260px;">
						<span>个人可抵押资产占比：</span></td>
						<td class="edit_comp_r"><input class="comp_input"
							name="personmortgage" id="personmortgage" style="width: 200px;" type="text"
							value="<%=personmortgage%>" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="提交"></td>
						<td><input type="button" onclick="window.close()" value="返回"></td>
						<td><input type="reset"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>