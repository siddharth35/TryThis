<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<form action="SignUpVerification" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="number" name="id" required="required"></td>
			</tr>

			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" required="required"></td>
			</tr>

			<tr>
				<td>Gender:</td>
				<td><input type="radio" value="male" name="gender">Male
					<input type="radio" value="female" name="gender">Female <input
					type="radio" value="others" name="gender">Others</td>
			</tr>

			<tr>
				<td>Country:</td>
				<td><select name="country">
						<option value="India">India</option>
						<option value="Pakistan">Pakistan</option>
						<option value="West Indies">West Indies</option>
						<option value="Australia">Australia</option>
						<option value="USA">USA</option>
				</select></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="pass" required="required"></td>
			</tr>

			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="SIGN UP"></td>
			</tr>

			<tr>
				<%
					String error = (String) session.getAttribute("error");
					error = error != null ? error : "";
				%>
				<td colspan="2"><%=error%></td>
			</tr>

		</table>
		<%
			session.setAttribute("error", "");
		%>
	</form>
</body>
</html>