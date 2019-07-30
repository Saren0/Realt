<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Task 4</title>
	<link rel="stylesheet" href="css/app-style.css">
</head>
<body>
	<h1>
		Вывести список книг, количество которых не менее заданного.
	</h1><hr>
	<a href='<c:url value="/index.jsp"/>' title="На главную">На главную</a><br>	
	<div>
		<form action="Task4Controller" method="POST" accept-charset="utf-8">
			<label for="idbookCount">Введите количество книг:</label>
			<input id="idbookCount" type="text" name="bookCount" 
				value="" required><br>
			<input type="submit" name="Submit">
		</form>
	</div><hr>
</body>
</html>