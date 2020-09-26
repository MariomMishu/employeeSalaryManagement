<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add </title>
</head>
<body>

	<h1>Add Basic Salary</h1>

	<form:form action="${pageContext.request.contextPath }/basicSalary/update"
		modelAttribute="basicSalary">
		<p>Basic : <form:input style="text-align:right" path="basicSalary"/></p>
		 <br>

		<input type="submit" name="submit" value="Add">
	</form:form>

</body>
</html>