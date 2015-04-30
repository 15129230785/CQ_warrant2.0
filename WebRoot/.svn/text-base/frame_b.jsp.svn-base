<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
		
		<%
			String username = (String) session.getAttribute("user");
			if (username == null || username.length() == 0) {
				out.println("用户登录已经过期，请重新登录");
				return;
			}
		%>

		<style type="text/css">
			*{padding:0;margin:0;list-style-type:none;}
			body{width: 100%;height:100%;padding:0;margin:5px 0 0;}
			a{text-decoration:none;color:#4f6b72;}
			
			ul.boxmenu div.header{border:1px solid #B1CDE3;width:98%;cursor:pointer;margin:0 auto;text-align:center;background:url(${pageContext.request.contextPath}/tabs/images/bg.gif) repeat-x;}
			ul.boxmenu li div.header .label{cursor:pointer;font:normal 12px/50px "宋体";color:#4f6b72;}
			ul.boxmenu li{margin:0 0 5px;}
			ul.boxmenu li ul.menu{display:none;width:98%;margin:0 auto;}
			ul.boxmenu li ul.menu li{width:100%;margin:0;}
			ul.boxmenu li ul.menu li table{width:100%;border-collapse:collapse;border: 1px solid #B1CDE3;border-top:none;}
			ul.boxmenu li ul.menu li table td{text-align:center;border-collapse:collapse;border: 1px solid #B1CDE3;border-top:none;font:normal 12px/20px "宋体";color:#4f6b72;word-break:break-all;}
			ul.boxmenu li ul.menu li table td a:hover{text-decoration:underline;}
		</style>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/initXMLHTTP.js"></script>
		<script type="text/javascript">
			function getMyTaskList() {
				var xmlhttp = initxmlhttp();
				
				if (xmlhttp != null) {
					xmlhttp.open("GET", "GetMyTaskList" + "?rn=" + Math.random(), false);
					xmlhttp.send();
					//alert(xmlhttp.responseText);
					var data = xmlhttp.responseText;
					if (data == "null") {
						data = "";
					}
					document.getElementById("mytasklist").innerHTML = data;
				}
			}
			window.onload = function() {
				getMyTaskList();
				pswdOverdue();    //密码过期提醒
				newLetter(); 	  //新邮件提醒
				taskOverdue();	  //任务过期
				newTask();		  //未处理任务
			};
			setInterval("newTask()", 60000);
			setInterval("newLetter()", 71000);
		</script>
	</head>
	<body>
		<ul class="boxmenu">
			<!-- 循环开始 -->
			<li>
				<div class="header">
					<span class="label"><a href="${pageContext.request.contextPath}/frame_c.jsp" target="c">我的任务</a></span>
				</div>
				<ul class="menu" style="display:block;" id="mytasklist">
				</ul>
			</li>
			<!-- 循环结束 -->	
		</ul>
		<a href="${pageContext.request.contextPath}/stationLetter/stationLetter.jsp" target="c">
		<ul class="boxmenu" style="display:block;">
			<li>
				<div id="letter" class="header"><span class="label">站内信</span></div>
			</li>
		</ul>
		</a>
		<ul class="boxmenu">
			<li>
				<div class="header">
					<span class="label">系统消息提醒</span>
				</div>
				<ul class="menu" style="display:block;">
					<li>
						<table>
							<tr>
								<td id="tip">密码逾期</td>
							</tr>
							<tr>
								<td id="tip1">任务逾期</td>
							</tr>
							<tr>
								<td id="tip2">新任务</td>
							</tr>
							<tr>
								<td id="tip3">邮件</td>
							</tr>
						</table>
					</li>
				</ul>
			</li>
		</ul>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/public/rootPath.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/systemNewRemind.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("ul.boxmenu li > div.header").click(function() {
				$(this).parent().find("ul.menu").slideToggle();
			});
		});
	</script>
	</body>
</html>