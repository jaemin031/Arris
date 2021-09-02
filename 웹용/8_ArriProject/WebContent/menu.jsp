<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<link rel="stylesheet" href="css/menu.css">
<script type="text/javascript" src="js/menu.js"></script>
<title>menu</title>
</head>

<body>

	<div id="nav">
		<ul class="nav nav-pills">
			<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
			<li class="nav-item"><a class="nav-link"
				href="index.jsp?content=introduceUs.jsp">서비스 소개</a></li>
			<li class="nav-item"><a class="nav-link"
				href="getBoardList.do">게시판</a></li>
			<li class="nav-item"><a class="nav-link" href="prMain.do">나의 정보</a></li>
			<li class="nav-item"><a class="nav-link" href="index.jsp?content=HireInfo.jsp">나의 고용 정보</a></li>
			<li class="nav-item"><a class="nav-link" href="Unfair.do">부당 고용 체크</a></li>			
		</ul>
	</div>
</body>
</html>