
<%@page import="com.entity.Movie"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<body>
	<%
	List<Movie> list = (List<Movie>) request.getAttribute("list");
	%>

	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>GENER</th>
			<th>BUDGET</th>
			<th>EARNING</th>
			<th>DELETE</th>
			<th>UPDATE</th>
		</tr>




		<c:forEach var="movie" items="${list}">


			<tr>
				<td><c:out value="${ movie.getId() }"></c:out></td>
				<td><c:out value="${ movie.getName() }"></c:out></td>
				<td><c:out value="${ movie.getGenre() }"></c:out></td>
				<td><c:out value="${ movie.getBudget() }"></c:out></td>
				<td><c:out value="${ movie.getEarning() }"></c:out></td>

				<td><a href="deleteMovie?id=${ movie.getId() }">DELETE</a></td>

				<td><a href="updateMovieFormServLet?id=${ movie.getId() }">UPDATE</a>
				</td>
		</c:forEach>
		</tr>

	</table>

</body>
</html>