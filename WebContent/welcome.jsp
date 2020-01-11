<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.deloitte.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<%
		User user = (User) session.getAttribute("user");
	%>
	Hello,
	<%=user.getName()%>
	<br> Your ID is
	<%=user.getId()%>.
	<br> You are form
	<%=user.getCountry()%>
	and your gender is
	<%=user.getGender()%>
	<br>
	<br>
	<a href="CheckSession"><button>UPDATE</button></a>
	<a href="LogoutVerification"><button>LOGOUT</button></a>
</body>
</html>