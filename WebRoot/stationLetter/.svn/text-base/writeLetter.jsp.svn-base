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
		<link type="text/css" rel="stylesheet" href="<%=basePath%>Validform/style.css" />
		
		<style type="text/css">
			.a{text-decoration: none}
			#table{width:100%;border-collapse:collapse;border: 2px solid #B1CDE3;}
			#table tr td{width:100%;border-collapse:collapse;border: 2px solid #B1CDE3;}
		</style>
		
	</head>
	
	<body style="text-align: center;" onload="getUserList()" >
		<a href="writeLetter.jsp" target="c"  style="font-size: 24px" class="a">写邮件</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="receiverLetter.jsp" target="c"  style="font-size: 24px" class="a">收件箱</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="addresser.jsp" target="c"  style="font-size: 24px" class="a">发件箱</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="draft.jsp" target="c"  style="font-size: 24px" class="a">回收站</a>
		<hr/>
		<form action="StationLetter!addReceiver" method="post" class="a1" >
		<table id="table">
			<tr>
				<td width="100px" >发送形式:</td>
				<td align="left" >
					个人:<input type="radio" name="dispatch" onclick="getUserList()" checked="checked" value="0" />
					群组:<input type="radio" name="dispatch" onclick="getGroupList()" value="1" />
				</td>
			</tr>
			<tr>
				<td width="100px" >收件人:</td>
				<td align="left" ><select name="recID" id="recID" style="width: 150px" ></select></td>
			</tr>
			<tr>
				<td>标题:</td>
				<td align="left"><input type="text" name="caption" datatype="noNull" sucmsg=" " errormsg="不能为空" style="width: 300px" /></td>
			</tr>
			<tr>
				<td>内容:</td>
				<td align="left"><textarea name="message" id="message" style="width: 600px; height: 180px" datatype="*" errormsg="不能为空"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><input type="submit" value="发送"><input type="reset" name="重置" /></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>Validform/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/public/rootPath.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/public/initXMLHTTP.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/letter.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/letterAll.js"></script>
	<script type="text/javascript">
	$(function () {
		$(".a1").Validform({
			tiptype : 3,
			label : ".label",
			showAllError : true,
			datatype : {
				"noNull":/[\w\W]+/,
			}
		});
		
	});
	</script>
	</body>
</html>