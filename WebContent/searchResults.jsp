<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>searchResults</title>
</head>
<body>
	<form action="fetchDataSearch">
		<div style="float: right";">
			<input type="text" name="parm1"><br> <input
				type="submit" value="Search">
		</div>
	</form>

	<div class="nav">
		<ul>
			<li><a href="Home.html">Home</a></li>
			<li><a href="Categories.html">Categories</a></li>
			<li><a href="Sale.jsp">Sale</a></li>
			<li><a href="Contact.html">Contact</a></li>
			<a href="shoppingCart.jsp"><img
				src=http://i62.tinypic.com/1znwox3.png></a>
		</ul>
	</div>
	<br />
	<%
		ResultSet resultSet = (ResultSet) session.getAttribute("RS");
		while (resultSet.next()) {
	%>

	<table style="width: 100%">
		<tr>
		<td><%=resultSet.getRow()%></td>
			<td><a href="detailedSearchResults.jsp?rowid=<%=resultSet.getRow()%>"><img
					src="C:/Users/Kitten/workspace1/MyFirstJEE/WebContent/images/<%=resultSet.getString("Image")%>"
					height="170" width="130" /></a></td>
			<td><%=resultSet.getString("Name")%></td>
			<td>US$ <%=resultSet.getString("Price")%></td>
		</tr>
	</table>
	<%
		}
	%>

</body>
</html>