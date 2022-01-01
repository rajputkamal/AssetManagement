<%@page import="com.dto.Asset"%>
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
	ArrayList<Asset> list = (ArrayList<Asset>) request.getAttribute("LIST");
	%>
		<a href="addAssets.jsp" class="btn btn-success">Add assets	</a> 
	
	<div class="container">
		<div class="jumbotron">
			<h1>Asset Details</h1>
		</div>
		<%
		if (ms != null)
			out.print("<h2 style='color:green;'>" + ms + "</h2>");
		%>
		<table border="2" class="table">
			<tr>
				<th>NAME</th>
				<th>PURCHASE DATE</th>
				<th>CONDITION NOTES</th>
				<th>CATEGORY</th>
				<th>ASSIGNMENT STATUS</th>
				<th>DELETION</th>
				<th>UPDATION</th>
				<th>ASSIGN</th>
			</tr>
			<%
			for (Asset ss : list) {
			%>
			<tr>
				<td><%=ss.getName()%></td>
				<td><%=ss.getPurDate()%></td>
				<td><%=ss.getConNote()%></td>
				<td><%=ss.getCategory()%></td>
				<td><%=ss.getStatus()%></td>
				<td><a href="deleteAsset?name=<%=ss.getName()%>"
					class="btn btn-danger"
					onclick="return confirm('Are You Sure To Delete This Asset')">
						DELETE </a></td>

				<td><a href="updateAsset?name=<%=ss.getName()%>"
					class="btn btn-primary"> EDIT </a></td>
				<td><a href="assignAssetToEmployee?name=<%=ss.getName()%>"
					class="btn btn-primary"> ASSIGN ASSET TO EMPLOYEE </a></td>
			
			</tr>
			<%
			}
			%>
		</table>
	</div>


</body>
</html>