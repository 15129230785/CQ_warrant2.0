<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>关于我们</title>
<%
	String username = (String) session.getAttribute("user");
	if (username == null || username.length() == 0) {
		out.println("用户登录已经过期，请重新登录");
		return;
	}
%>
<script type="text/javascript">
	function lianjie() {
		window.open("http://www.cqsoftware.net","_new");
	}
</script>
</head>
<body>
	<p>西安创强软件科技有限公司于2014年初创立于西安高新技术产业开发区，公司主要从事小微金融行业整体解决方案，包括担保、小额贷款管理系统及
		资金支付系统，集团信息化整体解决方案，电子商务平台整体解决方案等。公司以科技创新、自强不息为发展理念，以为客户提供优质、可持续的软件
		服务为使命，为广大中小企业的发展壮大保驾护航。</p>
	<p>联系电话：029-88869192</p>
	<p>联系地址：西安市南二环西段88号老三届世纪星大厦</p>
	<p>官方网站：<a href="#" onclick="lianjie()">www.cqsoftware.net</a></p>
	<div style="width: 100%; height: 563px;">
		<iframe style="width: 76%; height: 100%; border: 0px; margin-left: 12%" src="map.jsp"></iframe>
	</div>
</body>
</html>