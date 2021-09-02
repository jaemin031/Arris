<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="js/modifyUser.js"></script>
<title>회원 정보 수정</title>
</head>

<body>
	<div class="row">
		<div class="col-sm-8">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="panel-title">
						<h3>회원 정보 수정</h3>
					</div>
				</div>
				<div class="panel-body">
					<form id="login-form" action="modifyUser.do">
						<div class="row">
							<div class="col-sm-3">
								<label for="Name_text">아이디:</label>
							</div>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="id"
									value="${login.id}" disabled="disabled">
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label for="Name_text">새 비밀번호:</label>
							</div>
							<div class="col-sm-9">
								<input type="password" id="pw" class="form-control" name="pw"
									placeholder="password" autofocus required>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label for="Name_text">새 비밀번호 확인:</label>
							</div>
							<div class="col-sm-9">
								<input type="password" id="pw_check" class="form-control"
									name="pw_check" placeholder="pw_check" autofocus required>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label for="Name_text">이름:</label>
							</div>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="name"
									value="${login.name}" autofocus required>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label for="gender">성별:</label>
							</div>
							<div class="col-sm-9">
								 <input type="radio" class="" name="gender"
									value="남자">남자 <input type="radio" class=""
									name="gender" value="여자">여자
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label for="Date">생일:</label>
							</div>
							<div class="col-sm-9">
								<input type="date" class="form-control" name="birthDate"
									value="${login.date}" required="required" required />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-4">&nbsp;</div>
							<div class="col-sm-4">
								<button type="reset" class="form-control btn btn-primary">초기화</button>
							</div>
							<div class="col-sm-4">
								<button type="submit" id="submitbtn"
									class="form-control btn btn-primary">정보 수정</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="card" style="width: 100%">
				<img class="card-img-top" src="img/char1.png" alt="Card image"
					style="width: 100%">
				<div class="card-body">
					<h4 class="card-title">${login.id}님</h4>
					<p class="card-text">접속을 환영합니다.</p>
				</div>
			</div>
			<a href="index.jsp?content=modifyUser.jsp">회원 정보 수정</a>&nbsp;| <a
				href="logout.do">로그아웃</a>&nbsp;| <a href="dropOut.do">탈퇴하기</a>
		</div>
	</div>
</body>
</html>