<%@page import="com.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPADTE BOOK FORM</title>
<link rel="stylesheet" type="text/css" href="css/form.css">
</head>
<body>

	<%
	Student student = (Student) request.getAttribute("student");
	%>

	<h2>UPDATE STUDENT FORM</h2>

	<form action="updateStudent" method="get">
		<label>ID</label><br> <input type="text" name="id" value="<%=student.getId()%>" readonly><br> 
		<label>NAME</label><br>
		<input type="text" name="name" value="<%=student.getName()%>"><br>

		<label>MARKS</label><br> <input type="text" name="marks"
			value="<%=student.getMarks()%>"><br> <input
			type="submit" value="UPDATE">
	</form>

</body>
</html>