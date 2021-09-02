<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/modifyBoard.css">
<title>글 수정하기</title>
		  

</head>
<body>
	<div align="center">
		<h4><strong>내용 수정하기</strong></h4>
		<hr>
		<form action="updateBoard.do" method="get">
			<input type="hidden" name="seq" value="${board.seq}">
			<input type="hidden" name="userid" value="${board.userid}">
			<table id="modifyBoard">
				<tr>
					<th>분류</th>
					<td><select name="part">
							<option value="공지사항">공지사항</option>
							<option value="임금체불">임금체불</option>
							<option value="근로계약서 미작성">근로계약서 미작성</option>
							<option value="폭력 행위">폭력 행위</option>
							<option value="최저임금 미준수">최저임금 미준수</option>
							<option value="주휴/초과수당 미지급">주휴/초과수당 미지급</option>
							<option value="부당해고">부당해고</option>
							<option value="임금 삭감 등 기타">임금 삭감 등 기타</option>
							<option value="재해 수당">재해 수당</option>
					</select></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value=" ${board.title}" size="60"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${board.writer}</td> <!-- 작성자 불러오기 -->
				</tr>
				<tr>
					<th>등록일</th>
					<td>${board.regdate}</td> <!-- 등록일 부럴오기 -->
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="15" cols="70" name="coment">
            			${board.coment}
       				</textarea></td>
				</tr>
			</table>
			<button type="submit" id="modify" class="btn btn-primary btn-sm">수정하기</button>
		</form>
		<br>
		<button type="button" class="btn btn-secondary btn-sm" onclick="location.href='getBoardList.do'">글 목록으로 </button>

	</div>
</body>
</html>