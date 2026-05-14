
<%@page import="com.entity.Movie"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/form.css">
</head>
<body>
	<%
	Movie movie = (Movie) request.getAttribute("movie");
	%>

	<h2>BOOK UPDATE FORM</h2>

	<form action="updateMovie" method="get">
		<label>ID</label><br> <input type="text" name="id"
			value="<%=movie.getId()%>" readonly><br> <label>Name</label><br>
		<input type="text" name="name" value="<%=movie.getName()%>"><br>

		<label>Genre</label><br> <input type="text" name="gener"
			value="<%=movie.getGenre()%>"><br> <label>Budget</label><br>
		<input type="text" name="budget" value="<%=movie.getBudget()%>"><br>

		<label>Earning</label><br> <input type="text" name="earning"
			value="<%=movie.getEarning()%>"><br> <input
			type="submit" value="UPDATE">
	</form>

</body>
</html>