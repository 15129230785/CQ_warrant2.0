<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	String Eid = request.getParameter("getEid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.css" />
<link rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<link rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link rel="stylesheet" href="<%=basePath%>css/companyApply.css" />
<title>企业客户详细信息</title>
</head>

<body>
<iframe name="hideIframe" style="display: none;"></iframe>
	<div id="con">
		<ul>
			<li><a href="#companyBasic" class="selectTag">企业基本信息</a></li>
			<li><a href="#companyFinance">企业财务信息</a></li>
			<li><a href="#companyCredit">企业信用信息</a></li>
			<li><a href="#companyReginfo">企业注册信息</a></li>
		</ul>
		<div id="companyBasic">
			<a class="header" href="#">企业基本信息</a>
			<div id="companyDiv"></div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblShareholder');">企业主要股东信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:stock();">添加股东信息</a>
				<div id="TblShareholderdiv"></div>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblManinfo');">企业管理人员信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:manager();">添加企业管理人员信息</a>
				<div id="TblManinfodiv"></div>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblDeptinfo');">企业内部部门信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:inEnterprise();">添加企业内部部门信息</a>
				<div id="TblDeptinfodiv"></div>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblBranchinfo');">企业分支机构</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:branchinfo();">添加企业分支机构</a>
				<div id="TblBranchinfodiv"></div>
			</div>
			
			<a class="header" href="#" id="qiye_span">企业人员配备</a>
			<div>
				<iframe name="hideIframe" style="display: none;"></iframe>
				<form action="SavaTblEmpinfo" method="post" target="hideIframe"
					class="tablEmpinfo_form">
					<table width="100%">
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>
							</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="eid" id="eid_emp" style="width: 50%;" type="hidden"
								value="" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>研究生及以上人数：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="MasterOrUp " id="masterOrUpE" style="width: 50%;"
								type="text" onkeyup="inputInteger(this);" />
							</td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>
								大学本科人数：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="Bachelor " id="bachelorE" style="width: 50%;"
								type="text" onkeyup="inputInteger(this);" />
							</td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>
								大/中专人数：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="BachelorBelow " id="bachelorBelowE" style="width: 50%;"
								type="text" onkeyup="inputInteger(this);" />
							</td>
						</tr>

						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>
								高级职称人数：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="Senior " id="seniorE" style="width: 50%;" type="text"
								onkeyup="inputInteger(this);" />
							</td>
						</tr>

						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>
								中级职称人数：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="Middle" id="middleE" style="width: 50%;" type="text"
								onkeyup="inputInteger(this);" />
							</td>
						</tr>

						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>
								初级职称人数：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="Junior" id="juniorE" style="width: 50%;" type="text"
								onkeyup="inputInteger(this);" />
							</td>
						</tr>

						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>
								经营管理人数：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="Manager" id="managerE" style="width: 50%;" type="text"
								onkeyup="inputInteger(this);" />
							</td>
						</tr>

						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>
								生产销售人数：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="ProductAndSale" id="productAndSaleE"
								style="width: 50%;" type="text"
								onkeyup="inputInteger(this);" />
							</td>
						</tr>

						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>
								员工总人数：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="Total" id="totalE" style="width: 50%;" type="text"
								placeholder="必须填写" datatype="n" errormsg="员工总人数必须为正整数"
								sucmsg=" "
								onkeyup="inputInteger(this);" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" id="submit" value="" /></td>
						</tr>
					</table>
				</form>
			</div>
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblHistory');">企业重大历史事件</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:zdls();">添加企业重大历史事件</a>
				<div id="TblHistorydiv"></div>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblProduct');">企业主要产品</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:zycp();">添加企业主要产品</a>
				<div id="TblProductdiv"></div>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblVendor');">企业主要供货商</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:vendor();">添加企业主要供货商</a>
				<div id="TblVendordiv"></div>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblRelatedcominfo');">关联企业信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:relatedcominfo();">添加关联企业信息</a>
				<div id="TblRelatedcominfodiv"></div>
			</div>
		</div>
		
		<div class="tagContent none" id="companyFinance">
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblBanlancesheet');">企业资产负债表</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:banlancesheet();">添加企业资产负债表信息</a>
				<div id="TblBanlancesheetdiv"></div>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblIncomestatement');">企业损益表信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:incomestatement();">添加企业损益表信息</a>
				<div id="TblIncomestatementdiv"></div>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblCashflowstatement');">企业现金流量表信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:cashflowstatement();">添加企业现金流量信息</a>
				<div id="TblCashflowstatementdiv"></div>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblSalerevenuecheck');">销售收入核查信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:salerevenuecheck();">添加销售收入核查信息</a>
				<div id="TblSalerevenuecheckdiv"></div>
			</div>
		</div>
		<div class="tagContent none" id="companyCredit">
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblUndueloan');">企业借款信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:undueloan();">添加企业借款信息</a>
				<div id="TblUndueloandiv"></div>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblUnduewarrant');">企业未到期对外担保信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:unduewarrant();">添加企业对外担保信息</a>
				<div id="TblUnduewarrantdiv"></div>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblUnduebill');">企业未结清票据</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:unduebill();">添加企业未结清票据信息</a>
				<div id="TblUnduebilldiv"></div>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblInvest');">企业对外投资</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:invest();">添加企业对外投资信息</a>
				<div id="TblInvestdiv"></div>
			</div>
		</div>
		<div class="tagContent none" id="companyReginfo">
			<a class="header" href="#" onclick="javascript:addRegInfo();">企业注册信息</a>
			<div>
				<form class="registerform_infor" action="SavaTblReginfo" method="post" target="hideIframe" id="reginfo">
					<table width="100%">
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>
							</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="eid" id="eid_reginfo" style="width: 50%;" type="hidden"
								value="" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>注册代码：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="rid" id="rid" style="width: 50%;" type="text"  datatype="al" errormsg="注册代码为9位数字或者大写字母"  sucmsg=" " placeholder="必须填写" //></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>注册名称：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="RegName" id="RegName" style="width: 50%;" type="text" datatype="s" errormsg="不允许输入特殊字符"  sucmsg=" " placeholder="必须填写" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>注册地址：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="RegAddress" id="RegAddress" style="width: 50%;"   datatype="s" errormsg="不允许输入特殊字符"  sucmsg=" " placeholder="必须填写" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>注册登记机关：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="RegDept" id="RegDept" style="width: 50%;" type="text"  datatype="s" errormsg="不允许输入特殊字符"  sucmsg=" " placeholder="必须填写" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>注册时间：</span></td>
							<td class="edit_comp_r"><input id="RegDate" type="text"
								class="Wdate" onfocus="WdatePicker()" style="width: 50%;" name="regDate" datatype="*" errormsg="不允许输入特殊字符"  sucmsg=" " placeholder="必须填写" /></td>
	
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>注册资本：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="RegMoney " id=" RegMoney" style="width: 50%;"
								type="text" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>国税登记号码：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="StateTaxNum" id="StateTaxNum" style="width: 50%;" type="text" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>地税登记号码：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="LocalTaxNum " id=" LocalTaxNum" style="width: 50%;"
								type="text" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>经营期限：</span></td>
							<td class="edit_comp_r"><input class="comp_input"
								name="TimeLimit " id=" TimeLimit" style="width: 50%;"
								type="text" /></td>
						</tr>
						<tr>
							<td class="edit_comp_l" style="width: 20%;"><span>经营范围：</span></td>
							<td class="edit_comp_r"><textarea name="Scope"
								id="Scope" altercss="gray" placeholder="请在这里输入。" sucmsg=" "></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" id="regsubmit" value="" /></td>
						</tr>
					</table>
				</form>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblRegshareholder');">企业注册股东信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:regshareholder();">添加企业注册股东信息</a>
				<div id="TblRegshareholderdiv"></div>
			</div>
			
			<a class="header" href="#" 
				onclick="javascript:onclickSelectAjax('TblChangeinfo');">企业注册变更信息</a>
			<div>
				<a class="addbutton" href="#" onclick="javascript:changeinfo();">添加企业注册变更信息</a>
				<div id="TblChangeinfodiv"></div>
			</div>
		</div>
	</div>
	<input type="text" id="Eid" value="<%=Eid%>" style="display: none;" />

<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/rootPath.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/decimal.js"></script>
<script type="text/javascript" src="<%=basePath%>js/transfer.js"></script>
<script type="text/javascript" src="<%=basePath%>js/companyApplyDiv.js"></script>
<script type="text/javascript" src="<%=basePath%>js/companyApplyValid.js"></script>
<script type="text/javascript" src="<%=basePath%>js/company.js"></script>
<script type="text/javascript" src="<%=basePath%>js/companyApply.js"></script>
<script type="text/javascript" src="<%=basePath%>js/client.js"></script>
<script type="text/javascript">
$(function() {
	showClientDetails("<%=Eid%>");
	$("#con").tabs();
	$("#companyBasic").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 0,
		header: "a.header",
	});
	$("#companyFinance, #companyCredit, #companyReginfo").accordion({
		heightStyle: "content",
		collapsible: true,
		active: 100,
		header: "a.header",
	});
	$("a.addbutton").button();
});
</script>
</body>
</html>