<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>자유게시판</title>
<script type="text/javascript">
   function remove(){
	   if(confirm("삭제하시겠습니까?")){
		   return true;
	   }
	   return false;
   }		
   
   $(function(){
	   $("button").click(function(){
			switch (this.id) {
			case "insert" :
				
				break;
			case "delete" :
				
				break;
			}
		});
   });
</script>
</head>
<body>
	<div align="center">
		<h2>알리 게시판</h2>
		<form method="post" action="boardSearch.do">		<!-- 검색 -->
			<select name="condition" id="condition">
				<option value="seq">번호</option>
				<option value="part">분류</option>
				<option value="title">글제목</option>
				<option value="coment">글내용</option>
				<option value="writer">작성자</option>
			</select> 
			<input type="text" name="keyword" id = "keyword"/> 
			<input type="submit" value="검색" />
		</form>
		
		<form action="" name="blf">		<!-- 제거 -->
			<table border="1" width="80%">
				<tr>
					<td>선택</td>
					<td>번호</td>
					<td>분류</td>
					<td>제목</td>
					<td>작성자</td>
					<td>등록일</td>
					<td>조회수</td>
				</tr>
				<c:forEach var="data" items="${list}">
					<tr>
						<td><input type="checkbox" name="seq" value="${data.seq}">
						<td>${data.seq}</td>
						<td>
								${data.part}
						</td>
						<td><a href="viewBoard.do?seq=${data.seq}">${data.title}</a></td>
						<td>${data.writer}</td>
						<td>${data.regdate}</td>
						<td>${data.cnt}</td>
					</tr>
				</c:forEach>
			</table>
			
			<input type="button" id="insert" value="등록하기" onclick = "location.href='index.jsp?content=insertBoard.jsp'">
			<input type="button" id="delete" value="삭제하기" />
		</form>
	</div>
</body>
</html>