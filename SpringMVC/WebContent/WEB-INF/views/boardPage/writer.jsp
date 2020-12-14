<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
writer.jsp page

	<form action="writer" method="get">
		<div>
			제목 <input type="text" name="title"/>
		</div>
		<div>
			작성자 <input type="text" name="writer"/>
		</div>
		<div>
			내용 <textarea name="content" rows="4" cols="80"></textarea>
		</div>
		<div>
			<button type="submit">확인</button>
			<button type="button" onclick="javascript:history.back()">취소</button>
		</div>
	</form>
</body>
</html>