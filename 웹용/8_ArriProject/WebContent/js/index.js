/*function Request() {
	var requestParam = "";
	this.getParameter = function(param) {
		var url = unescape(location.href);
		var paramArr = (url.substring(url.indexOf("?") + 1, url.length)).split("&");

		for (var i = 0; i < paramArr.length; i++) {
			var temp = paramArr[i].split("=");

			if (temp[0].toUpperCase() == param.toUpperCase()) {
				requestParam = paramArr[i].split("=")[1];
				break;
			}
		}
		return requestParam;
	}
}

var request = new Request();
var message = request.getParameter("findId");
if(message != null) {
	alert(message);
}*/

/*$(function(){
$.ajax({
	type:"get",
	url:"IDfinder.jsp",
	data: findId,
	success: function(){alert(data);},
	error: function(){alert('error'+err.status);}
});
});*/