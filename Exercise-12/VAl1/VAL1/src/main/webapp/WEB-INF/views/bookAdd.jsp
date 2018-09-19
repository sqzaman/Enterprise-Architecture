<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a book</title>
</head>
<body>
	<form:form action="../books/add" method="post" modelAttribute="book">
			<p>
	  		     <form:errors path="*" style="color : red;" /> 
	        </p>
		<table>
			<tr>
				<td>Title:</td>
				<td><form:input path="title"/> </td>
				
			</tr>
			<tr>
				<td>ISBN:</td>				
				<td><form:input path="ISBN"/>
				 </td>
			</tr>
			<tr>
				<td>Author:</td>
				<td>
				<form:input path="author"/>
				</td>
			</tr>
			<tr>
				<td>Price:</td>
				<td>
				<form:input path="price"/>
				</td>
			</tr>
		</table>
		<input type="submit" value="add"/>
	</form:form>	
</body>
</html>