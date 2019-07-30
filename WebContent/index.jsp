<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Индексная страница</title>
	<link rel="stylesheet" href="css/app-style.css">
</head>
<body>
	<h1>Книжный магазин</h1><hr>
	<a href='<c:url value='<%="/ViewDataController"%>'/>' 
		title="Показать всех данные БД">Показать все данные БД</a><br>
	<a href='<c:url value="task1-preview.jsp"/>' title="Задача 1">Задача 1</a><br>
	<a href='<c:url value="task3.jsp"/>' title="Задача 2">Задача 2</a><br>
	<a href='<c:url value="task4.jsp"/>' title="Задача 3">Задача 3</a><br>
	<a href='<c:url value="task5.jsp"/>' title="Задача 4">Задача 4</a><br>
	
    <c:if test="${not empty errorMessage}">
    	<div class="error">
	        <c:out value="${errorMessage}"/>
    	</div><hr>
    </c:if>
 
	<div>
		<h2>Вставить книгу</h2>
		<form action="InsertBooks" method="GET" accept-charset="utf-8">
			<label for="idOZ_k">Область знаний:</label>
			<input id="idOZ_k" type="text" name="OZ_k" 
				value="" required><br>
			<label for="idIn_v_kat_k">Индекс в каталоге:</label>
			<input id="idIn_v_kat_k" type="text" name="In_v_kat_k" 
				value="" required><br>
			<label for="idAuthor_k">Авторы:</label>
			<input id="idAuthor_k" type="text" name="Author_k" 
				value="" required><br>
			<label for="idNazvanie_k">Название:</label>
			<input id="idNazvanie_k" type="text" name="Nazvanie_k" 
				value="" required><br>
			<label for="idYear_k">Год выпуска:</label>
			<input id="idYear_k" type="text" name="Year_k" 
				value="" placeholder="yyyy" required><br>
			<label for="idPrice_k">Цена:</label>
			<input id="idPrice_k" type="text" name="Price_k" 
				value="" required><br>
			<input type="submit" name="Submit1">
		</form>
	</div><hr>
	<div>
		<h2>Вставить поступление</h2>
		<form action="InsertArrive" method="GET" accept-charset="utf-8">
			<label for="idOZ_a">Область знаний:</label>
			<input id="idOZ_a" type="text" name="OZ_a" 
				value="" required><br>
			<label for="idIndex_a">Индекс в каталоге:</label>
			<input id="idIndex_a" type="text" name="Index_a" 
				value="" required><br>
			<label for="idKolvo_a">Количество:</label>
			<input id="idKolvo_a" type="text" name="Kolvo_a" 
				value="" required><br>
			<label for="idDate_a">Дата поступления:</label>
			<input id="idDate_a" type="text" name="Date_a" 
				value="" placeholder="yyyy-mm-dd" required><br>
			<input type="submit" name="Submit2">
		</form>
	</div><hr>
	<div>
		<h2>Вставить продажи</h2>
		<form action="InsertSells" method="GET" accept-charset="utf-8">
			<label for="idOZ_a">Область знаний:</label>
			<input id="idOZ_a" type="text" name="OZ_s" 
				value="" required><br>
			<label for="idIndex_a">Индекс в каталоге:</label>
			<input id="idIndex_a" type="text" name="Index_s" 
				value="" required><br>
			<label for="idKolvo_a">Количество:</label>
			<input id="idKolvo_a" type="text" name="Kolvo_s" 
				value="" required><br>
			<label for="idPrice_s">Отпускная цена:</label>
			<input id="idPrice_s" type="text" name="Price_s" 
				value="" required><br>
			<label for="idDate_s">Дата продажи:</label>
			<input id="idDate_s" type="text" name="Date_s" 
				value="" placeholder="yyyy-mm-dd" required><br>
			<input type="submit" name="Submit1">
		</form>
	</div><hr>
</body>
</html>