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
	<div class="container">
		<div class="jumbotron">
			<h1>ADD CATEGORY</h1>
		</div>
		<%
		String m = (String) request.getAttribute("msg");
		if (m != null) {
			if (m.equals("success")) {
				out.print("<h1 style='color:green;'>Category Added Successfully </h1>");
			} else if (m.equals("fail")) {
				out.print("<h1 style='color:red;'> Category Not Added </h1>");
			}
		}
		%>
		<form action="addCategory" method="post">
			<div class="form-group">
				<label for="exampleInputPassword1">Category ID: </label> <input
					type="text" class="form-control" name="uid"
					id="exampleInputPassword1" required="required">
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">Category Name : </label> <input
					type="text" required="required" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp" name="name">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Category Description : </label> <input
					type="text" required="required" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					name="description">
			</div>

			<button type="submit" class="btn btn-primary" value="ADD">ADD</button>
		</form>

	</div>

</body>
</html>