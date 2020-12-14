<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
update.jsp
	<form action="updateComplete" method="get">
		<div>
			<input type ="hidden" name="bno" value="${data.bno}"/>
			제목 <input type="text" name="title" value="${data.title}"/>
		</div>
		<div>
			작성자 <input type="text" name="writer" value="${data.writer}"/>
		</div>
		<div>
			내용
			<textarea name="content" rows="4" cols="80">${data.content }</textarea>
		</div>
		<div>
			<button type="submit">수정</button>
			<button type="button">취소</button>
		</div>
	</form>
</body>
</html>