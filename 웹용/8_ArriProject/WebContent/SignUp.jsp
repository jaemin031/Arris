<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/signUp.js"></script>
	<link rel="stylesheet" href="css/signUpStyle.css">
	<title>기본 정보 입력</title>
</head>

<body>
	<div class="panel panel-success">
		<div class="panel-heading">
			<div class="panel-title" align="center">
				<h5>회원가입</h5>
			</div>
		</div>
		<div class="panel-body">
			<form id="login-form" action="signUp.do">
				<div class="row">
					<div class="col-sm-3">
						<label for="Name_text">아이디:</label>
					</div>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="id"
							placeholder="UserID" autofocus required>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<label for="Name_text">비밀번호:</label>
					</div>
					<div class="col-sm-9">
						<input type="password" id="pw" class="form-control" name="pw"
							placeholder="password" autofocus required>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<label for="Name_text">비밀번호 확인:</label>
					</div>
					<div class="col-sm-9">
						<input type="password" id="pw_check" class="form-control"
							name="password 확인" placeholder="pw_check" autofocus required>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<label for="Name_text">이름:</label>
					</div>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="name"
							placeholder="Username" autofocus required>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<label for="gender">성별:</label>
					</div>
					<div class="col-sm-9" align="left">
						<input type="radio" class="" name="gender" value="남자">남자
						<input type="radio" class="" name="gender" value="여자">여자
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<label for="Date">생일:</label>
					</div>
					<div class="col-sm-9">
						<input type="date" class="form-control" name="birthDate"
							required="required" required />
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4">&nbsp;</div>
					<div class="col-sm-2" align="left">
						<button type="reset" class="form-control btn btn-primary btn-sm">초기화</button>
					</div>
					<div class="col-sm-2" align="left">
						<button type="submit" id="submitbtn"
							class="form-control btn btn-primary btn-sm">회원가입</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>