<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" media="screen" href="css/unfairJobResult.css">
	<title>알리 :: 부당 고용정보 체크</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<div id="unfairResult" align="center">
				<p id="result">
					${login.name} 님의 알바 고용 관련 부당한 내용은 다음으로 확인됩니다.
				</p>
				<hr>
				<br>
				<table id="lawResult">
					<tr>
						<th>조 항</th>
						<th>벌 금</th>
						<th>처 벌</th>
						<th>내 용</th>
					</tr>
					<c:forEach var="data" items="${law}">
						<tr>
							<td width="10%" id="tdresult">
								${data.article}
							</td>
							<td width="23%" id="tdresult">
								${data.fine}
							</td>
							<td width="12%" id="tdresult">
								${data.penalty}
							</td>
							<td width="55%" id="tdresult">
								${data.explain}
							</td>
						</tr>
					</c:forEach>
				</table>
				<br>
				<div id="calresult">
					<br>
					<table id="numbers">
						<tr>
							<th colspan="2">위반 관련 고용주 법칙금 :</th>
							<td id="ri">최대</td>
							<td colspan="5" id="strong">${resultPay}</td>
							<!-- 법칙금 넣기 -->
							<td>원</td>
						</tr>
						<tr>
							<th colspan="2">미지금 권장 수령액 :</th>
							<td id="ri">총</td>
							<td colspan="5" id="strong">${comPay}</td>
							<!-- 권장수령액 불러오기 -->
							<td>원</td>
						</tr>
						<tr>
							<td colspan="2"></td>
							<td colspan="2">= (권장 총 수령액:</td>
							<td colspan="2">${payMoney} 원</td>
							<!-- 받을금액 불러오기 -->
							<td>- 실수령액:</td>
							<td colspan="2">${payMoney} 원 )</td>
							<!-- 실수령액 불러오기 -->
						</tr>
					</table>
					<br>
					<br>
				</div>
				<div id="listLawyer" align="center">
					<table id="lawyerList">
						<tr>
							<th width="15%">분 야</th>
							<th width="10%")>이 름</th>
							<th width="10%">소 속</th>
							<th width="10%">연락처</th>
							<th width="55%">참 고</th>
						</tr>
						<c:forEach var="data" items="${lawyer}">
						<tr>
							<td id="tdresult">
								${data.lc_number}
							</td>
							<td id="tdresult">
								${data.name}
							</td>
							<td id="tdresult">
								${data.workPlace}
							</td>
							<td id="tdresult">
								${data.phone_number}
							</td>
							<td id="tdresult">
								${data.phrase}
							</td>
						</tr>
						</c:forEach>
					</table>
					<br>
					<br>
					<button type="button" class="btn btn-primary btn-sm"
						onclick="location.href='index.jsp'">메인으로</button>
					<br>
				</div>
			</div>
		</div>
	</div>
</body>
</html>