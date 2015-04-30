function getTrackInfo(wid) {
	var data = null;
	var xmlhttp = initxmlhttp();
	
	if (xmlhttp != null) {
		xmlhttp.open("GET", "GetTrackInfo" + "?rn=" + Math.random()
				+ "&wid=" + wid, false);
		xmlhttp.send();
		data = xmlhttp.responseText;
		var tl = eval("(" + data + ")");
		if (tl == null) {
			return tl;
		}
		return tl.trackInfoList;
	}
	return null;
}

var track = null;
function showTrackInfo(id, trackInfo) {
	var service = $("#serviceType").val();
	var wid = $("#wid").val();
	
	var ret = pullDown(id);
	if (ret == false) {
		return;
	}
	if (track == null) {
		track = getTrackInfo(wid);
	}
	if (track == null || track.length == 0) {
		return;
	}
	var td = new Array();
	
	td.push('<table width="100%" border="0">');
	
	if (service == "1") {
		td.push('<tr>');
		td.push('<th width="15%">项目跟踪时间</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].date + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>跟踪人</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].person + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>项目运作</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].work + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>资金使用</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].fund + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>反担保物</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].antiwarrant + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>项目跟踪结论</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].conclusion + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>存在问题</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].issue + '</td>');
		}
		td.push('</tr>');
	} else {
		td.push('<tr>');
		td.push('<th width="15%">项目跟踪时间</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].date + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>跟踪人</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].person + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>项目运作</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].work + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>资金使用</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].fund + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>反担保物</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].antiwarrant + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>企业财务</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].finance + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>企业重大变化事项</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].matter + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>项目跟踪结论</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].conclusion + '</td>');
		}
		td.push('</tr>');
		
		td.push('<tr>');
		td.push('<th>存在问题</th>');
		for (var tn = 0; tn < track.length; tn++) {
			td.push('<td>' + track[tn].issue + '</td>');
		}
		td.push('</tr>');
	}
	td.push('</table>');
	document.getElementById(trackInfo).innerHTML = td.join('');
	td = null;
}


