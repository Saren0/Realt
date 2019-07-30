<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
		<c:when test="${booksList eq null or empty booksList}">
			Список книг пуст.
		</c:when>
		<c:otherwise>
			<table>
				<caption>Таблица Книг</caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>Область знаний</th>
						<th>Индекс в каталоге</th>						
						<th>Авторы</th>
						<th>Название</th>
						<th>Год выпуска</th>
						<th>Цена</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="currentBook" items="${booksList}">
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
		<c:when test="${arrivalsList eq null or empty arrivalsList}">
			Список поступлений пуст.
		</c:when>
		<c:otherwise>
			<table>
				<caption>Таблица Поступлений</caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>Область знаний</th>
						<th>Индекс в каталоге</th>						
						<th>Количество</th>
						<th>Дата поступления</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="currentArrival" items="${arrivalsList}">
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
	<c:choose>
		<c:when test="${sellsList eq null or empty sellsList}">
			Список продаж пуст.
		</c:when>
		<c:otherwise>
			<table>
				<caption>Таблица Продаж</caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>Область знаний</th>
						<th>Индекс в каталоге</th>						
						<th>Количество</th>
						<th>Отпускная цена</th>
						<th>Дата продажи</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="currentSell" items="${sellsList}">
					<tr>
						<c:forEach var="item" items="${currentSell}">
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