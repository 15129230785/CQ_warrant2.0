function isTable() {
	if (top.target == '') {
		return false;
	} else {
		return true;
	}
}

function mouseMove(e) {
	e = e || window.event;
	if (isTable()) {
		resizetable_mouseMove(top.target, top.column, e);
	} else {
		resizeframe_mouseMove(e);
	}
}

function mouseUp(e) {
	e = e || window.event;
	if (isTable()) {
		resizetable_mouseUp(top.target, top.column, e);
	} else {
		resizeframe_mouseUp(e);
	}
}

function mouseDown(e) {
	e = e || window.event;
	resizeframe_mouseDown(e);
}


function resizeframe_mouseMove(e) {
	if (top.isDown) {
		var currentX = e.screenX;
		var offset = (currentX - top.startX);
		top.resize(offset);
		top.startX = currentX;
	}
}

function resizetable_mouseMove(table, col, e) {
	if (getStatus(table)) {
		var currentX = e.screenX;
		var offset = (currentX - getPosition(table));
		var c = getTitleCell(table, col);
		var width = resize(getWidth(c), offset);
		var i = 0;
		var rowCell = getCell(table, col, i);
		while (rowCell) {
			rowCell.width = width;
			i++;
			rowCell = getCell(table, col, i);
		}
		c.width = width;
		setPosition(table, currentX);
	}
}

function mouseDoubleClick(e) {
	top.hideOrShow();
}

function resizeframe_mouseDown(e) {
	top.isDown = true;
	top.startX = e.screenX;
	top.target = '';
}


function resizeframe_mouseUp(e) {
	top.isDown = false;
}

function resizetable_mouseDown(table, col, e) {
	e = e || window.event;
	setStatus(table, true);
	setPosition(table, e.screenX);
	top.target = table;
	top.column = col;
}


function changeCursor(cell, resize) {
	if (resize) {
		cell.style.cursor="w-resize";
	} else {
		cell.style.cursor="auto";
	}
}

function resizetable_mouseUp(table, col, e) {
	setStatus(table, false);
	top.target = '';
}

function resize(width, offset) {
	var w = parseInt(width) + parseInt(offset);
	if (w < 50) {
		w = 50;
	}
	return w;
}

function getWidth(cell) {
	var width = 0;
	
	if (!cell.width) {
		width = cell.clientWidth;
	} else if (cell.clientWidth < cell.width) {
		width = cell.clientWidth;
	} else if (cell.clientWidth > parseInt(cell.width) + 6) {
		width = cell.clientWidth;
	} else {
		width = cell.width;
	}
	return width;
}


function getTitleCell(table, col) {
	return document.getElementById(table + "Cell-1_" + col);
}

function getCell(table, col, row) {
	return document.getElementById(table + "Cell" + col + "_" + row);
}

function getStatus(table) {
	return eval('tableDown' + table);
}

function getPosition(table) {
	return eval('startX' + table);
}

function setStatus(table, value) {
	return eval('tableDown' + table + '=' + value + ';');
}

function setPosition(table, value) {
	return eval('startX' + table + '=' + value + ';');
}