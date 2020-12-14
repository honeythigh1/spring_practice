<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list }">
				<tr>
					<td>${item.bno}</td>
					<td><a href="detail?bno=${item.bno}">${item.title }</a></td>
					<td>${item.content}</td>
					<td>${item.writer}</td>
					<td>
						<fmt:parseDate value="${item.regDate}" var="regDate" pattern="yyyy-MM-dd"/>
						<fmt:formatDate value="${regDate}" pattern="yyyy.MM.dd" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<div>
				<input type="button" onclick="javascript:location.href='writerPage'" value="글쓰기"/>
			</div>
		</tfoot>
	</table>
</body>
</html>