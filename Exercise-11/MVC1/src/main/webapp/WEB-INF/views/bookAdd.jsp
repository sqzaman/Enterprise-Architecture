<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a book</title>
</head>
<body>
	<form action="../books/add" method="post">
		<table>
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title" value="" /> </td>
			</tr>
			<tr>
				<td>ISBN:</td>
				<td><input type="text" name="ISBN" value="" /> </td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><input type="text" name="author" value="" /> </td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price" value="" /> </td>
			</tr>
		</table>
		<input type="submit" value="update"/>
	</form>	
</body>
</html>