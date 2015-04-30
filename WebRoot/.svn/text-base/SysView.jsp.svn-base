<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Language" content="zh-cn" />
<title>主页面</title>
<script type="text/javascript">
	var oldWidth = 600;
	var startX = 0;
	var isDown = false;
	var target = '';
	var column = 0;
	function hideOrShow() {
		var widths = getFramesetWidths();
		if (widths[0] > 0) {
			setSize(-widths[0]);
		} else {
			setSize(oldWidth);
		}
	}

	function setSize(offset) {
		var fs = document.getElementById('topframeset');
		var widths = getFramesetWidths();
		widths[0] = parseInt(widths[0]) + parseInt(offset);
		if (widths[0] > 0) {
			oldWidth = widths[0];
		}
		widths[2] = parseInt(widths[2]) - parseInt(offset);
		var newCols = "";
		for (i = 0; i < widths.length - 1; i++) {
			newCols = newCols.concat(widths[i], ",");
		}
		newCols = newCols.concat(widths[widths.length - 1]);
		fs.cols = newCols;
	}
	function resize(offset) {
		var widths = getFramesetWidths();
		var actualOffset = offset;
		var newValue = parseInt(widths[i]) + parseInt(offset);
		if (newValue < 0) {
			actualOffset = -parseInt(widths[i]);
		}
		setSize(actualOffset);
	}

	function getWindowWidth() {
		if (typeof (window.innerWidth) == 'number') {
			//Non-IE
			return window.innerWidth;
		} else if (document.documentElement
				&& (document.documentElement.clientWidth || document.documentElement.clientHeight)) {
			//IE 6+ in 'standards compliant mode'
			return document.documentElement.clientWidth;
		} else if (document.body
				&& (document.body.clientWidth || document.body.clientHeight)) {
			//IE 4 compatible
			return document.body.clientWidth;
		} else {
			return 1024;
		}
	}

	function getFramesetWidths() {
		var fs = document.getElementById('topframeset');
		var oldCols = fs.cols;
		var widths = oldCols.split(',');
		var index = -1;
		var totalWidth = getWindowWidth();
		for (i = 0; i < widths.length; i++) {
			if (widths[i] == '*') {
				index = i;
				continue;
			}
			if (widths[i].indexOf('%') > 0) {
				widths[i] = (parseInt(widths[i].substring(0, widths[i].length)) / 100)
						* totalWidth;
			}
		}
		if (index >= 0) {
			widths[index] = totalWidth;
			for (i = 0; i < widths.length; i++) {
				if (i != index) {
					widths[index] = (parseInt(widths[index]) - parseInt(widths[i]));
				}
			}
		}
		return widths;
	}
</script>

</head>
<frameset cols="15%,70%,15%" frameborder="no">
	<frame src="${pageContext.request.contextPath}/frame_blank.jsp" noresize></frame>
	<frameset rows="110,*" frameborder="no">
		<frame src="${pageContext.request.contextPath}/frame_a.jsp" id="fa" style="border-bottom:1px solid #ccc;"></frame>
		<frameset id="topframeset" cols="28%,1%,*">
			<frame src="${pageContext.request.contextPath}/frame_b.jsp" name="b" id="fb"></frame>
			<frame src='${pageContext.request.contextPath}/frame_cont.jsp' noresize></frame>
			<frame src="${pageContext.request.contextPath}/frame_c.jsp" name="c" id="fc"></frame>
		</frameset>
	</frameset>
	<frame src="frame_blank.jsp" noresize></frame>
</frameset>
</html>