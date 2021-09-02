<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/main_img.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Main_IMG</title>
<style>
img {
	display: block;
	height: 100%;
}
</style>
</head>

<body>
	<div class="row">
		<div class="col-sm-12">
			<div id="demo" class="carousel slide" data-ride="carousel">
				<ul class="carousel-indicators">
					<li data-target="#demo" data-slide-to="0" class="active"></li>
					<li data-target="#demo" data-slide-to="1"></li>
				</ul>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="img/main_1.jpeg">
						<div class="carousel-caption">
							<h3>글 1</h3>
							<p>작은 글 1</p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="img/main_2.jpeg">
						<div class="carousel-caption">
							<h3>글 2</h3>
							<p>작은 글 2</p>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#demo" data-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</a> <a class="carousel-control-next" href="#demo" data-slide="next">
					<span class="carousel-control-next-icon"></span>
				</a>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<hr>
			<div id="intro_h3">
				<h6>ARRI 소개</h6>
			</div>
			<p id="intro_p">
				우리는 알바생들의 고용 처우 개선과 권리 보장을 위해 시작된 <em>"알바의 알 권리, 알리"</em> 입니다.<br>
				<br>부당한 대우를 겪은 사람들에게 맞춤 법률 정보를 제공하고 관련 법률전문가를 매칭하도록 도와주며,<br>
				관련 근무자들간 정보교환의 장을 제공합니다.<br>

			</p>
			<div class="w3-tag w3-round w3-lightgray" style="padding: 3px">
				<div>
					<button type="button" class="btn btn-outline-info btn-sm">
						<a href="index.jsp?content=introduceUs.jsp">자세히</a>
					</button>
					<br>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<hr>
			<p id="intro_p">
				공지사항 <br> 게시판
			</p>
			<div class="w3-tag w3-round w3-lightgray" style="padding: 3px">
				<div>
					<button type="button" class="btn btn-outline-info btn-sm">
						<a href="getBoardList.do">자세히</a>
					</button>
					<!-- 로그인이 되어있어야만 들어갈 수 있게 설정해야한다. -->
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<c:choose>
				<c:when test="${!empty login}">
					<div class="card" style="width: 100%">
						<img class="card-img-top" src="img/char1.png" alt="Card image"
							style="width: 100%">
						<div class="card-body">
							<h4 class="card-title">${login.id}님</h4>
							<p class="card-text">접속을 환영합니다.</p>
						</div>
					</div>
					<a href="index.jsp?content=prMain.jsp">나의 정보 보기</a>&nbsp;| 
				<a href="getBoardList.do">글 쓰러 가기</a>&nbsp;|
				<a href="logout.do">로그아웃</a>
				</c:when>
				<c:otherwise>
					<jsp:include page="login.jsp" />
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>