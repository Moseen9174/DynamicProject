<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="CollegeCtl" method="post">
		<table>
			<tr>
				<th>First Name :</th>
				<td><input type="text" name="Name"></td>
			</tr>
			<tr>
				<th>Address :</th>
				<td><input type="text" name="Address"></td>
			</tr>
			<tr>
				<th>State :</th>
				<td><input type="text" name=State"></td>
			</tr>
			<tr>
				<th>City :</th>
				<td><input type="text" name="City"></td>
			</tr>
			<tr>
				<th>PhoneNo:</th>
				<td><input type="text" name="PhoneNo"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="Submite">
					<input type="submit" name="operation" value="Reset"></td>
			</tr>
		</table>
	</form>

</body>
</html>