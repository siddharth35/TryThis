<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="LoginVerification" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="number" name="id" placeholder="User ID"
					required="required"></td>
				<td>Password:</td>
				<td><input type="password" name="pass" placeholder="Password"
					required="required"></td>
				<td><input type="submit" value="LOGIN"></td>
			</tr>
			<tr>
				<%
					String error = (String) session.getAttribute("error");
					error = error != null ? error : "";
				%>
				<td colspan="3"><%=error%></td>
			</tr>
			<tr>
				<td colspan="5" align="center">Don't have an account yet? <a
					href="signup.jsp">Sign Up</a> now.
				</td>
			</tr>
			<%
				session.setAttribute("error", "");
			%>
		</table>
	</form>
</body>
</html>