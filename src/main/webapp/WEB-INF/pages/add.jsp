<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Contact</h1>

		<table>
			<form:form method="post" modelAttribute="studentForm"
				action="save">
				<tr>
					<td>Name:</td>
					<td><form:input path="name" type="text" /></td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><form:input path="age" type="text" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>