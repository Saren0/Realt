<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Task 1</title>
	<link rel="stylesheet" href="css/app-style.css">
</head>
<body>
	<h1>
		Список книг, количество которых не менее заданного.
	</h1>
	<a href='<c:url value="/index.jsp"/>' title="На главную">На главную</a><br><hr>
    
	<c:choose>
		<c:when test="${task4ResultList eq null or empty task4ResultList}">
			Нет книг.
		</c:when>
		<c:otherwise>
			<table>
				<caption>Книги.</caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>Область знаний</th>
						<th>Индекс в каталоге</th>
						<th>Авторы</th>
						<th>Название</th>
						<th>Год выпуска</th>
						<th>Цена</th>
						<th>Количество</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="resultLine" items="${task4ResultList}">
						<tr>
						<c:forEach var="item" items="${resultLine}">
							<td><c:out value="${item}"/></td>
						</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>