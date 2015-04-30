<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户登录</title>

<style type="text/css">
*{padding:0;margin:0;}
ul,li{list-style:none;}
#bg{position:absolute;top:0px;left:0px;z-index:-999;}
.newLogin{position:absolute;top:50%;left:50%;margin:-150px 0 0 -160px;text-align:center;width:320px;height:300px;border:1px solid #ccc;border-radius:5px;-moz-border-radius:5px;-webkit-border-radius:5px;}
.newLogin h1{font:bold 20px "微软雅黑";color:#2c2b2b;padding:20px 0 0;}
.newLogin p{color:#ff0000;font:normal 14px "宋体";padding:10px 0;}
.newLogin li{height:28px;font:normal 12px/28px "宋体";color:#2c2b2b;margin:0 0 20px;}
.newLogin li .input{background:#fff;width:200px;height:22px;}
.newLogin li input[type='submit']{background:url(tabs/images/btnSubmit.png) no-repeat;width:94px;height:28px;border:none;cursor:pointer;margin:0 10px 0 42px;}
.newLogin li input[type='reset']{background:url(tabs/images/btnReset.png) no-repeat;width:94px;height:28px;border:none;cursor:pointer;}
</style>
<%
	session.invalidate();
%>
<script type="text/javascript">
	function validate_required(field, alerttxt) {
		with (field) {
			if (value == null || value == "") {
				alert(alerttxt);
				return false;
			} else {
				return true;
			}
		}
	}

	function yz(thisform) {
		with (thisform) {
			if (validate_required(username, "账号不能为空！") == false) {
				username.focus();

				return false;
			} else if (validate_required(password, "密码不能为空！") == false) {
				password.focus();
				return false;
			}
		}
	}

	window.onresize = window.onload = function() {
		var w, h;
		if (!!(window.attachEvent && !window.opera)) {
			h = document.documentElement.clientHeight;
			w = document.documentElement.clientWidth;
		} else {
			h = window.innerHeight;
			w = window.innerWidth;
		}
		document.getElementById('msg').value = '窗口大小：' + 'width:' + w
				+ '; height:' + h;
		var bgImg = document.getElementById('bg').getElementsByTagName('img')[0];
		bgImg.width = (w);
		bgImg.height = (h);
	};
	
	function refresh() {
		document.getElementById("authImg").src="${pageContext.request.contextPath }/verifyGraph?rn=" + Math.random();
	}
</script>
</head>
<body >
<div id="bg">
	<img src="${pageContext.request.contextPath}/tabs/images/bg.jpg" />
</div>
<div id="msg"></div>
<div class="newLogin">
	<form action="UserLoginaction" method="post" name="loginnew" onsubmit="yz(this)">
		<h1>创强担保业务管理系统</h1>
		<p align="center">${loginerror}</p>
		<ul>
			<li>用户名：<input type="text" name="username" id="user" class="input" value="a" /></li>
			<li>密　码：<input type="password" name="password" id="pass" class="input" value="password" /></li>
			<li>验证码：<input type="text" name="verifycode" id="verifycode" class="input" value="" /></li>
			<li><input type="submit" name="submit" value="" /><input type="reset" name="reset" value="" /></li>
		</ul>
	</form>
	验证码如图:<img src="${pageContext.request.contextPath }/verifyGraph" id="authImg" /><a href="javascript:refresh();">刷新</a>
</div>
</body>
</html>