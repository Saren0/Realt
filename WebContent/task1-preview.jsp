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
		Вывести список книг поступивших в заданную дату.
	</h1><hr>
	<a href='<c:url value="/index.jsp"/>' title="На главную">На главную</a><br><hr>
	
    <c:if test="${not empty errorMessage}">
    	<div class="error">
	        <c:out value="${errorMessage}"/>
    	</div><hr>
    </c:if>
    
    <div>
		<h2>Введите точку</h2>
		<form action="Task1Controller" method="POST" accept-charset="utf-8">
			<label for="idFindDate">Введите дату:</label>
			<input id="idFindDate" type="text" name="FindDate" 
				value="" placeholder="yyyy-mm-dd" required><br>
			<input type="submit" name="Submit">
		</form>
	</div><hr>
</body>
</html>