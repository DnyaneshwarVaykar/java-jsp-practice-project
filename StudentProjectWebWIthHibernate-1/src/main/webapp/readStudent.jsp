<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.entity.Student"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALL Student</title>
<link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<body>
	<%
	List<Student> studentList = (List<Student>) request.getAttribute("studentList");
	%>

	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>MARK</th>
			<th>DELETE</th>
			<th>UPDATE</th>
		</tr>

		<%
		for (Student student : studentList) {
		%>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getMarks()%></td>
			<td><a href="deleteStudent?id=<%=student.getId()%>">DELETE</a></td>

			<td><a href="updateFormStudentServlet?id=<%=student.getId()%>">UPDATE</a>
			</td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>