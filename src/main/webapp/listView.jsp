<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
		href="<%=request.getContextPath()%>/mystyle.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ALL Persons</title>
</head>
<body>
	<center>
	
		<br> <br>
		<table border="1">
			<tr>
				<th>Person ID</th>
				<th>Person Name</th>
				<th>Person Contact Number</th>
				<th>Action Edit</th>
				<th>Action Delete</th>
			</tr>
			<c:forEach items="${personList}" var="person">
				<tr>
					<td>${person.id}</td>
					<td>${person.name}</td>
					<td>${person.contact}</td>
					<td><a
						href="<%=request.getContextPath()%>/person/get/${person.id}">Edit</a></td>
					<td><a
						href="<%=request.getContextPath()%>/person/delete/${person.id}"
						onclick="return window.confirm('Are you sure ?')">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</center>
	<center>
		<a href="<%=request.getContextPath()%>/index.jsp">Insert Person</a>
		<a href="<%=request.getContextPath()%>/person/get">List All Persons</a>
	</center>
</body>
</html>