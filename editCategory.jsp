<%@page import="com.dto.Category"%>
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
	String user = (String) session.getAttribute("user");
	if (user != null) {
		out.print("<h2> Welcome " + user + "</h1>");
	} else {
		response.sendRedirect("login.jsp");
	}
	%>
	<%
	Category ct = (Category) request.getAttribute("CTG");
	%>
	
	<div class="container">
		<div class="jumbotron">
			<h1>UPDATE CATEGORY</h1>
		</div>
		
		<form action="updateCategory" method="post">
			<div class="form-group">
				<label for="exampleInputPassword1">Category ID: </label> <input type="text"
					class="form-control" name="uid" value="<%= ct.getUid() %>" id="exampleInputPassword1" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">Category Name : </label> <input
					type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="name" value="<%= ct.getName() %>">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Category Description : </label> <input
					type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="description" value="<%= ct.getDescription()%>">
			</div>
			<button type="submit" class="btn btn-primary" value="UPDATE">UPDATE</button>
		</form>

	</div>

</body>
</html>