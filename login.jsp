<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Asset Management - Admin Login </h1>
		</div>
		<%
		String m = (String) request.getAttribute("msg");
		if (m != null)
			out.println("<h2 style='color:red;'>" + m + " </h2>");
		%>
		<form action="adminLogin" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">User Name : </label> <input
					type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="uname">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" name="pwd"
					id="exampleInputPassword1">
			</div>

			<button type="submit" class="btn btn-primary" value="Login">Submit</button>
		</form>
	</div>
</body>
</html>