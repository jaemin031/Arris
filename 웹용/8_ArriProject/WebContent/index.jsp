<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ARRI 알바의 알 권리</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/indexStyle.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
<script src="js/index.js"></script>
</head>

<body>
	<div class="container">
		<div class="row page-header">
			<div class="col-sm-12">
				<div class="w3-container w3-tangerine">
					<p class="w3-jumbo"><img src="img/logo01.png"></p>
				</div>
			</div>
		</div>
		<div class="row nav">
			<div class="col-sm-12">
				<jsp:include page="menu.jsp" />
			</div>
		</div>
		<c:choose>
			<c:when test="${!empty content }">
				<%-- <jsp:include page="${content}" /> --%>
				<c:import url="${content}"></c:import>
			</c:when>
			<c:when test="${param.content != null }">
				<%-- <jsp:include page="${param.content}" /> --%>
				<c:import url="${param.content }"></c:import>
			</c:when>
			<c:otherwise>
				<jsp:include page="main_img.jsp" />
			</c:otherwise>
		</c:choose>
		
		<div class="row footer">
			<div class="col-sm-12">
				<jsp:include page="footer.jsp" />
			</div>
		</div>
	</div>
</body>
</html>