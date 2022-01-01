<%@page import="com.dto.Asset"%>
<%@page import="com.dto.Employee"%>
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
	String user = (String) session.getAttribute("user");
	if (user != null) {
		out.print("<h2> Welcome " + user + "</h1>");
	} else {
		response.sendRedirect("login.jsp");
	}
	%>

	<%
	String msg = (String) request.getAttribute("msg");
	ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("LIST_EMP");
	Asset ast = (Asset) request.getAttribute("AST");
	%>
	<%
	if (msg != null)
		out.println("<h2 style='color:green;'>" + msg + " </h2>");
	%>
	<div class="container">
		<a href="addAssets.jsp" class="btn btn-success">Add assets </a> <a
			href="listAssets" class="btn btn-success"> Assets List</a> <br>
		<br>
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
				<th>ASSIGN TO EMPLOYEE</th>

			</tr>
			<tr>
				<td><%=ast.getName()%></td>
				<td><%=ast.getPurDate()%></td>
				<td><%=ast.getConNote()%></td>
				<td><%=ast.getCategory()%></td>
				<td><%=ast.getStatus()%></td>
				<td><select name="name">
						<%
						for (Employee e : list) {
						%>
						<option value="<%=e.getName()%>">
							<%=e.getName()%>
						</option>
						<%
						}
						%>
				</select></td>
				<td>
				<td><a href="assignEmployee?name=<%=ast.getName()%>"
					class="btn btn-primary">ASSIGN </a></td>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>