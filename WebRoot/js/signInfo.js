function getRiskReviewInfo(wid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetRiskReviewInfo" + "?rn=" + Math.random() + "&wid="
				+ wid, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		var ssl = eval("(" + data + ")");
		if (ssl == null) {
			return null;
		}
		return ssl.riskReviewInfo;
	}
}

function getReviewerList() {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetReviewerList" + "?rn=" + Math.random(), false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		if(data == null || "" == data) {
			return null;
		}
		var rl = eval("(" + data + ")");
		return rl;
	}
}



