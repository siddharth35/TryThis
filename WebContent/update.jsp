<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.deloitte.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
</head>
<body>
	<%
		User user = (User) session.getAttribute("user");
	%>
	<form action="UpdateVerification" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="number" readonly="readonly"
					value=<%=user.getId()%>></td>
			</tr>

			<tr>
				<td>Name:</td>
				<td><input type="text" readonly="readonly"
					value=<%=user.getName()%>></td>
			</tr>

			<tr>
				<td>Gender:</td>
				<td><input type="text" readonly="readonly"
					value=<%=user.getGender()%>></td>
			</tr>

			<tr>
				<td>Country:</td>
				<td><input type="text" readonly="readonly"
					value=<%=user.getCountry()%>></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="pass"></td>
			</tr>

			<tr>
				<td><input type="submit" value="UPDATE"></td>
				<td><a href="welcome.jsp">CANCEL</a></td>
			</tr>

			<tr>
				<%
					String error = (String) session.getAttribute("error");
					error = error != null ? error : "";
				%>
				<td colspan="2" rowspan="2"><%=error%></td>
			</tr>
			<%
				session.setAttribute("error", "");
			%>
		</table>
	</form>
</body>
</html>