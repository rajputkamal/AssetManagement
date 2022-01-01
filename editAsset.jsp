<%@page import="com.dto.Asset"%>
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
	Asset ast = (Asset) request.getAttribute("AST");
	%>

	<div class="container">
		<div class="jumbotron">
			<h1>UPDATE ASSET</h1>
		</div>

		<form action="updateAsset" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Asset Name : </label> <input
					type="text"  class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="name" value="<%=ast.getName()%>" required="required">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Purchase Date : </label> <input
					type="date" class="form-control" value="<%=ast.getPurDate()%>" id="exampleInputEmail1"
					required="required" aria-describedby="emailHelp" name="purDate">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Condition Note : </label> <input
					required="required" type="text" value="<%=ast.getConNote()%>" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp" name="conNote">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Category : </label> <input
					required="required" type="text" class="form-control" value="<%=ast.getCategory()%>"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					name="category">
			</div>
			<div class="dropdown">
				<span>ASSIGN STATUS: </span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
				<select value="<%=ast.getStatus()%>" name="status" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">
					<option class="dropdown-item" name="status">---SELECT---</option>
					<option value="available" name="status" class="dropdown-item">AVAILABLE</option>
					<option value="assigned" name="status" class="dropdown-item">ASSIGNED</option>
					<option value="recovered" name="status" class="dropdown-item">RECOVERED</option>
				</select>
			</div>
			<br>
			<button type="submit" class="btn btn-primary" value="UPDATE">UPDATE</button>
		</form>

	</div>

</body>
</html>