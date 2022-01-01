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
	<div class="container">
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
		String ms = (String) request.getAttribute("msg");
		%>

		<br> <a href="addAssets.jsp" class="btn btn-success">Add
			assets </a> <a href="listAssets" class="btn btn-success"> Assets List</a>
		<br> <br>
		<hr>
		<%
		if (ms != null)
			out.println("<h2 style='color:blue;'>" + ms + "</h2>");
		%>
		<form action="searchAsset" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Asset Name To Search: </label> <input
					type="text" class="form-control" id="exampleInputEmail1"
					placeholder="enter asset name " aria-describedby="emailHelp"
					name="name" required="required">
			</div>
			<button type="submit" class="btn btn-primary" value="SEACRH">SEARCH</button>
		</form>
		<br> <br>
		<%
		if (ast != null) {
		%>
		<table border="2" class="table">
			<tr>
				<th>NAME</th>
				<th>PURCHASE DATE</th>
				<th>CONDITION NOTES</th>
				<th>CATEGORY</th>
				<th>ASSIGNMENT STATUS</th>
			</tr>
			<tr>
				<td><%=ast.getName()%></td>
				<td><%=ast.getPurDate()%></td>
				<td><%=ast.getConNote()%></td>
				<td><%=ast.getCategory()%></td>
				<td><%=ast.getStatus()%></td>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>