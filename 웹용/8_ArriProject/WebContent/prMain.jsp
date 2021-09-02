<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/prMainStyle.css">
<title>PrMain</title>
</head>

<body>
	<div class="row">
		<div class="col-sm-8">
			<div class="row">
				<div class="col-sm-12">
					<hr>
					<h5 align="center">나의 고용 정보</h5>
						<table id="intro_table" align="center">
							<tr>
								<th colspan="5">기본 정보</th>
							</tr>
							<tr>
								<td>&nbsp;직종</td>
								<td colspan="2">
								<c:choose>
									<c:when test="${hire.jobNum == 1 }">
										요식업
									</c:when>
									<c:when test="${hire.jobNum == 2 }">
										유통/판매
									</c:when>
									<c:when test="${hire.jobNum == 3 }">
										서비스
									</c:when>
									<c:when test="${hire.jobNum == 4 }">
										사무직
									</c:when>
									<c:when test="${hire.jobNum == 5 }">
										교육
									</c:when>
									<c:when test="${hire.jobNum == 6 }">
										건설/생산
									</c:when>
									<c:when test="${hire.jobNum == 7 }">
										IT/디자인
									</c:when>
									<c:when test="${hire.jobNum == 8 }">
										영업
									</c:when>
								</c:choose>
								</td>
								<!-- 직종 출력 -->
								<td>보험 가입 여부</td>
								<td>${hire.insuCheck}</td>
								<!-- 보험가입여부 출력 -->
							</tr>
							<tr>
								<td>고용일수</td>
								<td colspan="2">평일 : 총 ${hire.d_day}&nbsp;일</td>
								<!-- 평일 총 일수 -->
								<td colspan="2">주말 : 총 ${hire.e_day}&nbsp;일</td>
								<!-- 주말 총 일수 -->
							</tr>
							<tr>
								<td>고용 시간</td>
								<td colspan="2">일 주간 : ${hire.d_time}&nbsp;시간</td>
								<!-- 주간 총 시간 -->
								<td colspan="2">일 야간 : ${hire.n_time}&nbsp;시간</td>
								<!-- 야간 총 시간 -->
							</tr>
							<tr>
								<td>금액</td>
								<td colspan="2">시급 : ${hire.wage}&nbsp;원</td>
								<!-- 기본 시급 -->
								<td colspan="2">실수령액 : ${hire.payMoney}&nbsp;원</td>
								<!-- 실수령액 -->
							</tr>
						</table>
					<div class="w3-tag w3-round w3-lightgray" style="padding: 1px">
							<br>
						<div class="w3-tag w3-round w3-black w3-border w3-border-white">
							<a href="index.jsp?content=HireInfo.jsp">입력 및 수정</a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<hr>
					<p id="Unfair.do">부당 고용 현황 확인</p>
					<div class="w3-tag w3-round w3-lightgray" style="padding: 1px">
						<br>
						<div class="w3-tag w3-round w3-black w3-border w3-border-white">
							<a href="Unfair.do">확인</a>
							<!-- 고용정보가 입력 되어있어야만 들어갈 수 있게 설정해야한다. -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="card" style="width: 80%" align="center">
				<img class="card-img-top" src="img/char1.png" alt="Card image"
					style="width: 70%">
				<div class="card-body">
					<h4 class="card-title">${login.id}님</h4>
					<p class="card-text">접속을 환영합니다.</p>
				</div>
			</div>
			<div id="buttons">
			<a href="index.jsp?content=modifyUser.jsp">회원 정보 수정</a>&nbsp;| <a
				href="logout.do">로그아웃</a>&nbsp;| <a href="dropOut.do">탈퇴하기</a>
		</div>
		</div>
	</div>
</body>
</html>