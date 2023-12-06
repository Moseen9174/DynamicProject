<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% UserBean bean1 = (UserBean)request.getAttribute("user");%>
	<% if(bean1 !=null) { %>
	<h3>Hii
	<%= bean1.getFirstName() %>
	<a href="UserListCtl"> UserList</a>
	<a href="CollegeListView"> CollegeList</a>
	</h3>
	<% } %>
	<hr>
</body>
</html>