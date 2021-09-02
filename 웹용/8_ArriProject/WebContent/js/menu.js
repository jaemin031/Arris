$(function() {
	$("a").click(function() { 
		if($(".nav-link").hasClass("active")) {
			$(".nav-link").removeClass("active");
		}
		$(this).addClass("active");
	})
});