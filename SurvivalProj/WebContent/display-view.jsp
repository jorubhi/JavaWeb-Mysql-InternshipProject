<%@page import="com.sapient.pm.BlockLogic.BlockExecutor"%>
<%@page import="com.sapient.pm.model.Stock"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GFI</title>
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
<button type="button" class="btn btn-danger" style="position: absolute; top: 2%; right: 2%; border: 0;"><a href="index.html" style="text-decoration:none;color:white">Log Out</a></button>
	<button type="button" class="btn btn-primary" style="position: absolute; top: 2%; right: 10%; border: 0;"><a href="TraderLandingPage.jsp" style="text-decoration:none;color:White">View Orders</a></button>
	
<div class="container">
	<h2>Welcome Trader | EquitySimulation | View Transaction History</h2>
 	<h3>View Transaction History</h3>
	<div class="tab-content">
<form action="callRefresh">
<button  class="btn btn-primary"
	style="position: absolute; top: 2%; right: 20%; border: 0;">
	Refresh
</button>
</form>
		<form action="FetchData">
			<select class="form-control" style="width: 25%" name="selected">
				<option name="selected" value="4">All</option>
				<option name="selected" value="1">Completed</option>
				<option name="selected" value="2">Partial</option>
				<option name="selected" value="3">Denied</option>
				<option name="selected" value="0">Open</option>
			</select>
			<button class="btn btn-primary">Get Data</button>
		</form>


		<table class="table table-striped">
			<thead>

				<tr>
					
					<td>TICKER</td>
					<td>QUANTITY</td>
					<td>STATUS</td>
				</tr>
			</thead>
			<tbody>
				<%
					List<Stock> stockList = (List<Stock>) request.getAttribute("stockList");
					if (stockList != null){
						for (Stock stock : stockList) {
							
				%>
				<tr>
					
					<td><%=stock.getTicker()%></td>
					<td><%=stock.getQuantity()%></td>
					<td><%if(stock.getStatus()==1) 
					  out.print("Completed");
					if(stock.getStatus()==2) 
						  out.print("Denied");
					if(stock.getStatus()==3) 
						  out.print("Partial");
					if(stock.getStatus()==0) 
						  out.print("Open");
					  
					  
					  
					  
					  %></td>
				</tr>
				<%
						}
						}
				%>
			</tbody>
		</table>
		
		
	</div>
</div>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="./main.js`" type="text/javascript"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>