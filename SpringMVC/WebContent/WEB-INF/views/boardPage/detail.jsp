<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	detail.jsp
	<form action="update" method="get">
		<div>
			<input type ="hidden" name="bno" value="${data.bno}"/>
			제목 <input type="text" name="title" value="${data.title}" disabled="disabled"/>
		</div>
		<div>
			작성자 <input type="text" name="writer" value="${data.writer}" disabled="disabled"/>
		</div>
		<div>
			내용
			<textarea disabled="disabled" name="content" rows="4" cols="80">${data.content }</textarea>
		</div>
		<div>
			<button type="submit">수정</button>
			<button type="button" onclick="javascript:history.back()">취소</button>
		</div>
	</form>
</body>
</html>