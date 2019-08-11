<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Панель администратора</title>
	<link rel="stylesheet" href="css/app-style.css">
</head>
<body>
	<h1>Панель администратора</h1><hr>
	<a href='<c:url value='<%="/ViewDataController"%>'/>' 
		title="Показать всех данные БД">Показать все данные БД</a><br>
	<a href='<c:url value="login.html"/>' title="Выйти">Выйти</a><br>
	
    <c:if test="${not empty errorMessage}">
    	<div class="error">
	        <c:out value="${errorMessage}"/>
    	</div><hr>
    </c:if>
 
	<div>
		<h2>Вставить пользователя</h2>
		<form action="InsertUser" method="GET" accept-charset="utf-8">
			<label for="idLogin">Логин:</label>
			<input id="idLogin" type="text" name="Login"
				value="" required><br>
			<label for="idPassword">Пароль:</label>
			<input id="idPassword" type="text" name="Password"
				value="" required><br>
			<label for="idRoot">Права:</label>
			<input id="idRoot" type="text" name="Root"
				value="" required><br>
			<input type="submit" name="Submit1">
		</form>
	</div><hr>
	<div>
		<h2>Вставить апартаменты</h2>
		<form action="InsertApartment" method="GET" accept-charset="utf-8">
			<label for="idName">Название:</label>
			<input id="idName" type="text" name="Name"
				value="" required><br>
			<label for="idBedroom">Количество комнат:</label>
			<input id="idBedroom" type="text" name="Bedroom"
				value="" required><br>
			<label for="idSquare">Площадь:</label>
			<input id="idSquare" type="text" name="Square"
				value="" required><br>
			<label for="idPrice">Цена:</label>
			<input id="idPrice" type="text" name="Price"
				value="" required><br>
			<label for="idPhone">Телефон:</label>
			<input id="idPhone" type="text" name="Phone"
				   value="" required><br>
			<label for="idPicture">Ссылка на изображение:</label>
			<input id="idPicture" type="text" name="Picture"
				   value="" required><br>
			<input type="submit" name="Submit2">
		</form>
	</div><hr>
</body>
</html>