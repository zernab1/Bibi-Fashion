<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="beans.ShoppingCart"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>shoppingCart</title>
<form action="fetchDataSearch">
	<div style="float: right";">
		<input type="text" name="parm1"><br> <input type="submit"
			value="Search">
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
</head>


<br> The following are currently in your cart:
<ol>
	<%
		ShoppingCart sc = (ShoppingCart) session.getAttribute("SC");
		for (int i = 0; i < sc.size(); i++) {
	%>
	<li> <%=sc.getItem() %>
		<%
			}
		%>
	
</ol>
</br>
</FONT>
<hr>
<%@ include file="detailedSearchResults.jsp"%>
</html>