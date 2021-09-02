<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/loginStyle.css">
<title>Login</title>
</head>

<body>
	<div class="panel panel-success">
		<div class="panel-heading">
			<div class="panel-title"><hr><h6>::알리:: 접속하기</h6></div>
		</div>
		<div class="panel-body">
			<form id="login-form" action="login.do">
				<div>
					<input type="text" class="form-control" name="id"
						placeholder="UserID" autofocus>
				</div>
				<div>
					<input type="password" class="form-control" name="pw"
						placeholder="Password">
				</div>
				<div>
					<button type="submit" class="form-control btn btn-primary">로그인</button>
				</div>
				<div>
					<a href="index.jsp?content=Id_Pw_finder.jsp">ID / PW 찾기</a>&nbsp;|
					<a href="index.jsp?content=SignUp.jsp">회원가입</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>