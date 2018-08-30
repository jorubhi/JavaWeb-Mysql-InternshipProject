<%@page import="java.sql.ResultSet"%>
<%@page import="com.sapient.pm.model.StockOrder"%>
<%@page import="java.util.List"%>
<%@page import="com.sapient.pm.model.StockOrder"%>
<%@page import="com.sapient.pm.repository.JdbcRepository"%>
<%@page import="com.sapient.pm.BlockLogic.BlockCreator"%>
<%@page import="com.sapient.pm.BlockLogic.PartialExecutor"%>
<%@page import="com.sapient.pm.repository.reposit"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trading</title>
</head>


<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Page Title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen" href="main.css" />
</head>

<body>
<img src="./logo.jpg" width="15%" height="7.5%"style="float:left">
<br>
<br>
<br>
<div class="container">
	<button type="button" class="btn btn-danger" style="position: absolute; top: 2%; right: 2%; border: 0;"><a href="index.html" style="text-decoration:none;">Log Out!</a></button>
		<button type="button" class="btn btn-primary" style="position: absolute; top: 2%; right: 12%; border: 0;"><a href="display-view.jsp" style="text-decoration:none;color:White">Transaction History</a></button>
	
	
	<h2>Welcome Trader | EquitySimulation</h2>
	

	<%reposit r= new reposit();  %>
	<%ResultSet result = r.getData(); %>
	<div class="w3-card-4" style="width: 100%">
		
		<header class="w3-container w3-light-grey">
		
		<h3>Your portfolio manager sent this</h3>
		<h4>List Book</h4>
		</header>
		<div class="tbl-header">
		<div style="width:100%;overflow:auto; max-height:250px;">
		<table class="table ">
			<thead>

				<tr>


					

					<td>Symbol</td>
					
					<td>Quantity</td>
					
					<td>Order Type</td>
					
					<td>Price</td>

				</tr>
			</thead>
			<tbody>
				<% JdbcRepository j = new JdbcRepository();
				while(result.next()) {
				%>
				<tr>
					<td><%=result.getString("ticker")%></td>
					<td><%=result.getInt("quantity")%></td>
					<td><%=result.getString("side")%></td>
					<td><%=j.getMarketData(result.getString("ticker"))%></td>
					
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		</div>
		</div>
	</div>

<form action="trigger2">
			<button class="w3-button w3-block w3-dark-grey">Create
				Blocks</button>
		</form>


			
		

</div>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</body>
</html>