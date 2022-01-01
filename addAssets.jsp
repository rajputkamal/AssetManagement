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
	<a href="listAssets" class="btn btn-success"> Assets List</a> 
	
	<div class="container">
		<div class="jumbotron">
			<h1>ADD ASSET</h1>
		</div>
		<%
		String m = (String) request.getAttribute("msg");
		if (m != null) {
			if (m.equals("success")) {
				out.print("<h1 style='color:green;'>Asset Added Successfully </h1>");
			} else if (m.equals("fail")) {
				out.print("<h1 style='color:red;'> Asset Not Added </h1>");
			}
		}
		%>
		<form action="addAsset" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Asset Name : </label> <input
					type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="name" required="required">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Purchase Date : </label> <input
					type="date" class="form-control" id="exampleInputEmail1"
					required="required" aria-describedby="emailHelp" name="purDate">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Condition Note : </label> <input
					required="required" type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp" name="conNote">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Category : </label> <input
					required="required" type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					name="category">
			</div>
			<div class="dropdown">
				<span>ASSIGN STATUS: </span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <select
					name="status" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">
					<option class="dropdown-item" name="status">---SELECT---</option>
					<option value="available" name="status" class="dropdown-item">AVAILABLE</option>
					<option value="assigned" name="status" class="dropdown-item">ASSIGNED</option>
					<option value="recovered" name="status" class="dropdown-item">RECOVERED</option>
				</select>
			</div>
			<br>
			<button type="submit" class="btn btn-primary" value="ADD">ADD</button>
			<br> <br>
		</form>

	</div>

</body>
</html>