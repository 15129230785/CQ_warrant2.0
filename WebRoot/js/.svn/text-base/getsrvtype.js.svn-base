function getServiceType(wid) {
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetServiceType" + "?rn=" + Math.random() + "&wid="
				+ wid, false);
		xmlhttp.send();
		var data = xmlhttp.responseText;
		return data;
	}
}
