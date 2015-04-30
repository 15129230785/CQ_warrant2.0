function getUserRight() {
	var xmlhttp = initxmlhttp();
	
	xmlhttp.open("GET", "GetUserRight" + "?rn=" + Math.random(), false);
	xmlhttp.send();
	data = eval("(" + xmlhttp.responseText + ")");
	if (data == null || data == "") {
		return null;
	}
	return data;
}

