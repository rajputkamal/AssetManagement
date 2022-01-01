<%@page import="com.dto.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="adminHeader.jsp"%>

<body>
	<%
	String ms = (String) request.getAttribute("msg");
	%>
	<%
	String user = (String) session.getAttribute("user");
	if (user != null) {
		out.print("<h2> Welcome " + user + "</h1>");
	} else {
		response.sendRedirect("login.jsp");
	}
	%>
	<%
	ArrayList<Category> list = (ArrayList<Category>) request.getAttribute("LIST");
	%>
	<div class="container">
		<div class="jumbotron">
			<h1>Student Details</h1>
		</div>
		<%
		if (ms != null)
			out.print("<h2 style='color:green;'>" + ms + "</h2>");
		%>
		<table border="2" class="table">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>DESCRIPTION</th>
				<th>UPDATION</th>
			</tr>
			<%
			for (Category ss : list) {
			%>
			<tr>
				<td><%=ss.getUid()%></td>
				<td><%=ss.getName()%></td>
				<td><%=ss.getDescription()%></td>
				<td><a href="updateCategory?uid=<%=ss.getUid()%>"
					class="btn btn-primary"> EDIT </a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>