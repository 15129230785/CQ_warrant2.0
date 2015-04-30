<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.css" />
<link rel="stylesheet" href="<%=basePath%>Validform/style.css" />
<link rel="stylesheet" href="<%=basePath%>css/apply.css" />
<link rel="stylesheet" href="<%=basePath%>css/loan.css" />
<title>台账报表</title>
</head>

<body>
	<div id="con">
		<ul>
			<li><a class="selectTag" href="#companyPart" onclick="showTblWarrantinfoCompany()">公司部分</a></li>
			<li><a href="#personPart" onclick="showTblWarrantinfoPersonage()">个人部分</a></li>
		</ul>

		<div class="tagContent" id="companyPart">
			<!-- Begin: Add searching history projects by bank or date, by Luke Chen on 2015/04/14 -->
			<div>
				<table border="0">
					<tr id="searchRow">
						<td>
							<label for="bankSearch">贷款行：</label>
						</td>
						<td>
							<select name="Bank" id="Bank" style="width: 150px;" datatype="bank">
							</select>
						</td>
						<td width="30"></td>
						<td>
							<label for="loanDate">放款日期：</label>
						</td>
						<td>
							<input  type="text" 
								class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								name="loanDateFilter" id="loanDateFilterCompany"
								value="" datatype="*" />
						</td>
						<td width="30"></td>
						<td>
							<input type="button" value="查询" onclick="showTblWarrantinfoWithOptions('0')" />
						</td>
						<td width="38%"></td>
						<td>
							<form action="DownloadWarrantAction!download" >
								<input type="submit" value="导出" />
							</form>
						</td>
					</tr>
				</table><br/>
			</div>
			
			<!-- End: Add searching history projects by bank or date, by Luke Chen on 2015/04/14 -->
			<div id="body">
				<ul id="menu">
					<li id="companyDiv"></li>
				</ul>
			</div>
		</div>
		<div class="tagContent" id="personPart">
			<!-- Begin: Add searching history projects by bank or date, by Luke Chen on 2015/04/14 -->
			<div>
				<table border="0">
					<tr id="searchRow">
						<td>
							<label for="bankSearch">贷款行：</label>
						</td>
						<td>
							<select name="Bank" id="bankPersonSelect" style="width: 150px;" datatype="bank">
							</select>
						</td>
						<td width="30"></td>
						<td>
							<label for="loanDate">放款日期：</label>
						</td>
						<td>
							<input  type="text" 
								class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								name="SearchLoanDate" id="loanDateFilterPerson"
								value="" datatype="*" />
						</td>
						<td width="30"></td>
						<td>
							<input type="button" value="查询" onclick="showTblWarrantinfoWithOptions('1')" />
						</td>
						<td width="38%"></td>
						<td>
							<form action="DownloadWarrantAction!download" >
								<input type="submit" value="导出" />
							</form>
						</td>
					</tr>
				</table><br/>
			</div>
			<!-- End: Add searching history projects by bank or date, by Luke Chen on 2015/04/14 -->
			<div id="body">
				<ul id="menu">
					<li id="personageDiv"></li>
				</ul>
			</div>
		</div>
	</div>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-ui-1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
<script type="text/javascript" src="<%=basePath%>js/loan.js"></script>
<script type="text/javascript" src="<%=basePath%>js/personinit.js"></script>

</body>
</html>