$(function(){
	$(document).tooltip({
		show : {
			effect : "slide",
			delay : 500
		},
		hide : {
			effect : "explode",
			delay : 250
		},
		position : {
			my : "left top",
			at : "center bottom"
		},
		/*open : function(event, ui) {
			ui.tooltip.animate({
				right : ui.tooltip.position().right+30
				}, "slow");
		},*/
	});
});

