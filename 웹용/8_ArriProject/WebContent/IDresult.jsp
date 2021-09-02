<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID 찾기 겷과</title>
</head>
<body>
	<div id="idresult" align="center">
		<h3>아이디 찾기 결과</h3>

		<c:choose>
			<c:when test="${empty findId}">
				죄송합니다. 입력하신 조건과 일치하는 아이디가 없습니다. <br>
				<input type="button" name="idfinder" value="아이디 다시 찾기"
					onclick="location.href='index.jsp?content=IDfinder.jsp'">
				<input type="button" name="login" value="로그인하기"
					onclick="location.href='index.jsp'">
			</c:when>
			<c:otherwise>
				<table border="1">
					<tr>
						<td colspan="2">찾으시는 아이디는 다음과 같습니다.</td>
					</tr>
					<tr>
						<th>아이디</th>
						<th>이름</th>
					</tr>
					<tr>
						<td>${findId}</td>
						<td>${findName}</td>
				</table>
				<br>
				<input type="button" name="pwfinder" value="비밀번호 찾기"
					onclick="location.href='index.jsp?content=Id_Pw_finder.jsp'">
				<input type="button" name="login" value="로그인하기"
					onclick="location.href='index.jsp'">
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>