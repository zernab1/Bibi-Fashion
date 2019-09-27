<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>detailedSearchResults</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">

</head>

<body>
	<%
		ResultSet rs = (ResultSet) session.getAttribute("RS");
		int i = Integer.valueOf(request.getParameter("rowid"));
			rs.absolute(i);
	%>
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
			<li><a href="#sale">Sale</a></li>
			<li><a href="Contact.html">Contact</a></li>
			<a href="shoppingCart.jsp"><img
				src=http://i62.tinypic.com/1znwox3.png></a>
		</ul>
	</div>
	<form action="cartManager.jsp?rid=<%=rs.getRow()%>">
		<table style="width: 100%">
			<tr>
				<td><img
					src="C:/Users/Kitten/workspace1/MyFirstJEE/WebContent/images/<%=rs.getString("Image")%>"
					height="170" width="130" /></td>
				<td><%=rs.getString("Name")%></td>
				<td>US$ <%=rs.getString("Price")%></td>
				<td><%=rs.getString("Color")%></td>
				<td><%=rs.getString("Description")%></td>
			</tr>
		</table>

		<select required>
			<option value="S">Small</option>
			<option value="M">Medium</option>
			<option value="L">Large</option>
		</select> <input type="submit" name="sizes" value="Add To Cart">
	</form>

</body>
</html>