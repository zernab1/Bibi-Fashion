<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="beans.ShoppingCart"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<style>
  p    {color:red}
  p    {font-size: 35px}
</style>
<title>cartManager</title>
</head>
<body>
	<%
		ResultSet rs = (ResultSet) session.getAttribute("RS");
	ShoppingCart sc = new ShoppingCart();
	sc.setItem(rs.getInt("DressID"));
	session.setAttribute("SC", sc);
	%>
	<form action="fetchDataSearch">
		<div style="float: right";">
			<input type="text" name="parm1"><br> <input
				type="submit" value="Search">
		</div>
	</form>

	<table style="width: 100%">
		<tr>
			<p>This item is now in your cart!</p>
		</tr>
		<tr>
			<td><img
				src="C:/Users/Kitten/workspace1/MyFirstJEE/WebContent/images/<%=rs.getString("Image")%>"
				height="170" width="130" /></td>
			<td><%=rs.getInt("DressID")%></td>	
			<td><%=rs.getString("Name")%></td>
			<td>US$ <%=rs.getString("Price")%></td>
			<td>
				<form action="">
					<input type="submit" value="Proceed To Checkout">
				</form>
			</td>
			<td>
				<form>
					<INPUT Type="button" VALUE="Continue Shopping"
						onClick="history.go(-1);return true;">
				</form>
			</td>
			<td>
				<form action="shoppingCart.jsp">
					<input type="submit" value="View Your Cart">
				</form>
			</td>
		</tr>
	</table>

</body>
</html>