$(function() {
	$('#submitbtn').on({
		click : checkData
	});
});

function checkData() {
	var pw = document.getElementById('pw').value;
	var pw_check = document.getElementById('pw_check').value;
	if (pw != pw_check) {
		alert("비밀 번호가 일치하지 않습니다.");
		return false;
	}
	if (!pw.equals(pw_check)) {
		alert("비밀 번호가 일치하지 않습니다.");
		return false;
	}
}