<%@page import="com.sapient.pm.repository.JdbcRepository"%>
<%@page import="com.sapient.pm.model.StockOrder"%>
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
<link rel="stylesheet" type="text/css" media="screen" href="main.css" />
<title>Trading</title>
</head>


<body>
<img src="./logo.jpg" width="15%" height="7.5%"style="float:left">
<br>
<br>
<br>
<button type="button" class="btn btn-danger"
	style="position: absolute; top: 2%; right: 2%; border: 0;">
	<a href="index.html" style="text-decoration: none;">Log Out!</a>
</button>
<button type="button" class="btn btn-primary"
	style="position: absolute; top: 2%; right: 12%; border: 0;">
	<a href="display-view.jsp" style="text-decoration: none; color: White">Transaction
		History</a>
</button>

<div style="width: 90%">
	<h2>Welcome Trader | EquitySimulation</h2>

	<div style="width: 100%">
		<%
			reposit r = new reposit();
		%>
		<%
			ResultSet result = r.getData();
		%>

		<div class="w3-card-4" style="width: 100%">

			<h3>Your portfolio manager sent this</h3>

			<div class="tbl-header">
				<div style="width: 100%; overflow: auto; max-height: 250px;">
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
							<% JdbcRepository j3 = new JdbcRepository();
								while (result.next()) {
							%>
							<tr>
								<td><%=result.getString("ticker")%></td>
								<td><%=result.getInt("quantity")%></td>
								<td><%=result.getString("side")%></td>
								<td><%=j3.getMarketData(result.getString("ticker"))%></td>

							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>


		<%
			reposit repository = new reposit();
		%>
		<%
			ResultSet resultSet = repository.getData();
		%>

		<%
			BlockCreator creator = new BlockCreator();
		%>

		<%
			creator.blockCreator();
		%>

		<%
			Map<String, Integer> mapBuy = creator.buyBlock;
		%>
		<%
			Map<String, Integer> mapSell = creator.sellBlock;
		%>
		
		<div class="col-xs-4 left" style="width: 100%">
			<div id="trigger" class="tab-pane fade in active">

				<div id="trigger" class="tab-pane fade in active">
					<div class="w3-container">


						<div class="w3-card-4" style="width: 100%">
							<header class="w3-container w3-light-grey">
							<div class="col-xs-12 left">
								<div id="trigger" class="tab-pane fade in active">

									<div id="trigger" class="tab-pane fade in active">
										<div class="w3-container">


											<div class="w3-card-4" style="width: 100%">
												<header class="w3-container w3-light-grey">
												<h3>Buy</h3>
												</header>
												<div class="tbl-header">
													<div
														style="width: 100%; overflow: auto; max-height: 150px;">
														<table class="table table-striped">
															<thead>

																<tr>
																	<td>Symbol</td>

																	<td>Quantity</td>
																	<td>Market Price</td>

																</tr>
															</thead>
															<tbody>
																<% JdbcRepository j = new JdbcRepository();
																	for (String s : mapBuy.keySet()) {
																%>
																<tr>
																	<td><%=s%></td>

																	<td><%=mapBuy.get(s)%></td>
																	<td><%=j.getMarketData(s)%></td>


																</tr>
																<%
																	}
																	mapBuy.clear();
																%>






															</tbody>
														</table>

													</div>
												</div>

											</div>
										</div>

									</div>
								</div>
							</div>
							<div id="right" class="col-xs-12 right">
								<div id="trigger" class="tab-pane fade in active">
									<%
										List<StockOrder> stockList2 = (List<StockOrder>) request.getAttribute("stockList");
									%>
									<div id="trigger" class="tab-pane fade in active">
										<div class="w3-container">


											<div class="w3-card-4" style="width: 100%">
												<header class="w3-container w3-light-grey">
												<h3>Sell</h3>
												</header>
												<div class="tbl-header">
													<div
														style="width: 100%; overflow: auto; max-height: 150px;">
														<table class="table table-striped">
															<thead>

																<tr>
																<tr>
																	<td>Symbol</td>

																	<td>Quantity</td>

																	<td>Market Price</td>

																</tr>
																</tr>
															</thead>
															<tbody>
																<% JdbcRepository j1 = new JdbcRepository();
																
																	for (String s : mapSell.keySet()) {
																%>
																<tr>
																	<td><%=s%></td>

																	<td><%=mapSell.get(s)%></td>
																	<td><%=j1.getMarketData(s)%></td>
																	
																</tr>
																<%
																	}
																	mapSell.clear();
																%>
															</tbody>
														</table>
													</div>
												</div>

											</div>

										</div>

									</div>

									<div align="right">
										<form action="trigger4">
											<button class="btn btn-success">Place Order</button>
										</form>
									</div>

								</div>

							</div>
						</div>
					</div>

				</div>
			</div>
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