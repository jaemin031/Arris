<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세보기</title>
<script type="text/javascript">
   function modify(){ //수정 확인 기능 넣기
	   if(confirm("수정하시겠습니까?")){
		   return true;
	   }
	   return false;
   }		
</script>
</head>
<body>
	<div align="center">
		<h3>내용 상세보기</h3>
		<hr>
		<form action="deleteboard.do" method="get">
			<input type="hidden" name="seq" value="${board.seq}">
			<input type="hidden" name="userid" value="${board.userid}">
			<table border="1" width="80%">
				<tr>
					<td>분류</td>
					<td>
						${board.part }
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>${board.title}</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${board.writer}</td>
				</tr>
				<tr>
					<td>등록일</td>
					<td>${board.regdate}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="12" cols="50" name="coment" disabled="disabled" style="text-align: left">${board.coment}</textarea>
        			</td>
				</tr>
			</table>
			<input type="button" value="새글쓰기" onclick = "location.href='index.jsp?content=insertBoard.jsp'">
			<input type="button" value="수정하기" onclick = "location.href='index.jsp?content=modifyBoard.jsp'">
			<input type="submit" value="삭제하기" > <br><br>
		</form>
		<br>
		<a href="getBoardList.do">글목록으로</a>

	</div>
</body>
</html>