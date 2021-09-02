<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 등록하기</title>
<script type="text/javascript">
   function add(){
	   if(confirm("등록하시겠습니까?")){
		   return true;
	   }
	   return false;
   }		
</script>
</head>
<body>
	<div align="center">
		<h3>새글 쓰기</h3>
		<hr>
		<form action="inserBord.do" method="get">
			<input type="hidden" name="regdate" id="regdate" value="" /> <input
				type="hidden" name="userid" id="userid" value="${login.id}" />
			<table border="1">
				<tr>
					<td>분 류</td>
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
					<td>제 목</td>
					<td><input type="text" name="title" /></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" value="${login.name}" disabled="disabled"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="coment" rows="10" cols="40">
          				</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="등록하기"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
