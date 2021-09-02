<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-6">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="panel-title">
						<h3>아이디 찾기</h3>
					</div>
				</div>
				<div class="panel-body">
					<form id="login-form" action="idFinder.do">
						<div class="row">
							<div class="col-sm-3">
								<label for="Name_text">이름:</label>
							</div>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="Name_text"
									placeholder="Username" autofocus required>
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
							<div class="col-sm-4">
								<button type="reset" class="form-control btn btn-primary">초기화</button>
							</div>
							<div class="col-sm-4">
								<button type="submit" class="form-control btn btn-primary">찾기</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="panel-title">
						<h3>비밀번호 찾기</h3>
					</div>
				</div>
				<div class="panel-body">
					<form id="login-form" action="pwFinder.do">
						<div class="row">
							<div class="col-sm-3">
								<label for="Name_text">ID:</label>
							</div>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="Id_text"
									placeholder="UserID" autofocus required>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label for="Name_text">이름:</label>
							</div>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="Name_text"
									placeholder="Username" autofocus required>
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
							<div class="col-sm-4">
								<button type="reset" class="form-control btn btn-primary">초기화</button>
							</div>
							<div class="col-sm-4">
								<button type="submit" id="pwSubmit"
									class="form-control btn btn-primary">찾기</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>