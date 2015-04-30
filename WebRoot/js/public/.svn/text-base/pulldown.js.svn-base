function pullDown(id) {
	return true;
	var targetid, targetelement;
	//var el = jQuery(id);
	var el = document.getElementById(id);
	if (!el)
		return false;
	targetid = el.id + "d";
	//targetelement = jQuery(targetid);
	targetelement = document.getElementById(targetid);

	if (targetelement.style.display == "none") {
		if (el.id.substr(0, 1) == "m")
			cur_expand = el.id;
		el.className = "active";
		targetelement.style.display = '';
		return true;
	} else {
		el.className = "";
		targetelement.style.display = "none";
		return false;
	}
};

function openOrClose(id) {
	pullDown(id);
}

/*var jQuery = function(id) {
	return document.getElementById(id);
};*/
