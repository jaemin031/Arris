<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 완료</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty successSign}">
			죄송합니다. 회원가입에 실패하셨습니다. <br>
			<input type="button" name="idfinder" value="회원 가입하러 가기"
				onclick="location.href='index.jsp?content=SignUp.jsp'">
			<input type="button" name="login" value="메인창으로 가기"
				onclick="location.href='index.jsp'">
		</c:when>
		<c:otherwise>
			<div id="signup_result" align="center">
				<h3>회원 등록이 완료 되었습니다.</h3>
				<hr>
				<table border="1">
					<tr>
						<td>아이디</td>
						<td>${signup.id}</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>${signup.pw}</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${signup.name}</td>
					</tr>
					<tr>
						<td>성별</td>
						<td>${signup.gender}</td>
					</tr>
				</table>
				<br> <input type="button" name="login" value="로그인하기"
					onclick="location.href='index.jsp'">
			</div>
		</c:otherwise>
	</c:choose>

</body>
</html>