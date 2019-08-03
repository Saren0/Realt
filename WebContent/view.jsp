<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Просмотр всех данных БД</title>
	<link rel="stylesheet" href="css/app-style.css">
</head>
<body>
	<h1>Просмотр всех данных БД</h1><hr>
	<a href='<c:url value="/index.jsp"/>' title="На главную">На главную</a><br><hr>

	<c:choose>
		<c:when test="${usersList eq null or empty usersList}">
			Список пользователей пуст.
		</c:when>
		<c:otherwise>
			<table>
				<caption>Таблица Пользователей</caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>Логин</th>
						<th>Пароль</th>
						<th>Права</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="currentBook" items="${usersList}">
					<tr>
						<c:forEach var="item" items="${currentBook}">
							<td>
				    			<c:out value="${item}" />
						    </td>
					     </c:forEach>
				     </tr>
				</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${apartmentsList eq null or empty apartmentsList}">
			Список апартаментов пуст.
		</c:when>
		<c:otherwise>
			<table>
				<caption>Таблица Апартаментов</caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>Название</th>
						<th>Количество комнат</th>
						<th>Площадь</th>
						<th>Цена</th>
						<th>Телефон</th>
						<th>Ссылка на изображение</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="currentArrival" items="${apartmentsList}">
					<tr>
						<c:forEach var="item" items="${currentArrival}">
							<td>
				    			<c:out value="${item}" />
						    </td>
					     </c:forEach>
				     </tr>
				</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>