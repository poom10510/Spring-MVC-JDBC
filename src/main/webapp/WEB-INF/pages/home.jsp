<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC -HelloWorld</title>
</head>
<body>
	<table border="1">
		<th>No</th>
		<th>Name</th>
		<th>Age</th>
		<th>Action</th>

		<c:forEach var="contact" items="${students}" varStatus="status">
			<tr>
				<td>${contact.id}</td>
				<td>${contact.name}</td>
				<td>${contact.age}</td>
				<td><a href="update/${contact.id }">Edit</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete/${contact.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>