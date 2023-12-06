<%@page import="in.co.rays.model.CollegeModel"%>
<%@page import="in.co.rays.bean.CollegeBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="bean" class="in.co.rays.bean.CollegeBean" scope="request"></jsp:useBean>

	<form action="CollegeListCtl" method="post">
		<%@ include file="Header.jsp"%>

		<table>
			<%
			
				List list = (List) request.getAttribute("list");
				Iterator<CollegeBean> it = list.iterator();
				
			%>
		</table>
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>State</th>
				<th>City</th>
				<th>PhoneNo</th>
			</tr>
			<%
			
				while (it.hasNext()) {
				bean=(CollegeBean) it.next();
				
			%>
			<tr>
				<td><%=bean.getName()%></td>
				<td><%=bean.getAddress()%></td>
				<td><%=bean.getState()%></td>
				<td><%=bean.getCity()%></td>
				<td><%=bean.getPhoneNo()%></td>
			</tr>

			<%
				}
			%>
		</table>
	</form>

</body>
</html>