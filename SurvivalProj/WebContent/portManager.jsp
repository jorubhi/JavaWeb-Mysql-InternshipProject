<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Portfolio Manager</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen" href="main.css" />
<style>
* {
    box-sizing: border-box;
}

input[type=text], select {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    resize: vertical;
}

label {
    padding: 12px 12px 12px 0;
    display: inline-block;
}

input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    float: left;
    width:30%;
   
}

input[type=submit]:hover {
    background-color: #45a049;
}

.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 2%;
    width:50%;
   padding-left:5%;
    
}

.col-25 {
    float: left;
    width: 25%;
    margin-top: 6px;
}

.col-75 {
    float: left;
    width: 60%;
    margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
    .col-25, .col-75, input[type=submit] {
        width: 80%;
        margin-top: 0;
    }
}
</style>
</head>


<div class="container">
	<h2>Welcome Portfolio Manager | Equity Simulation</h2>
	<ul class="nav nav-tabs">
		<li class="active"><a data-toggle="tab" href="#portfolio">Portfolio</a></li>
		<li><a data-toggle="tab" href="#order-Book">Order Book</a></li>
		<li><a data-toggle="tab" href="#order">Order</a></li>
	</ul>
	<div class="tab-content">
		<div id="portfolio" class="tab-pane fade in active">
			<div class="container">
				<h2>Portfolio</h2>
				<p>View Your Portfolio:</p>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>Ticker</th>
							<th>Price ($)</th>
							<th>Quantity</th>

							<th>Average Price</th>
							<th>Portfolio</th>

						</tr>
					</thead>
					<tbody>
						<tr>
							<td>XOM</td>
							<td>79</td>
							<td>50</td>
							<td>69</td>
							<td>20%</td>
						</tr>
						<tr>
							<td>APPL</td>
							<td>100</td>
							<td>20</td>
							<td>94</td>
							<td>54%</td>
						</tr>
						<tr>
							<td>BP</td>
							<td>60</td>
							<td>100</td>
							<td>62</td>
							<td>26%</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>

		<div id="order-Book" class="tab-pane fade">
			<form action="FetchData" id="find">
				<select class="form-control" style="width: 25%" name="selected">
					<option name="selected" value="1">All</option>
					<option name="selected" value="2">Partial</option>
					<option name="selected" value="3">Executed</option>
					<option name="selected" value="4">Open</option>
				</select>
				<button id="find" class="btn btn-primary">Get Data</button>
			</form>


			<h2>Order Book</h2>
			<p>View Your Order Form:</p>
			<table class="table table-bordered table-hover" id="orderbook-table">
				<thead>
					<tr>
						<th>Ticker</th>
						<th>Price ($)</th>
						<th>Quantity Submitted</th>

						<th>Time</th>
						<th>Quantity Filled</th>
						<th>Trader ID</th>
						<th>Status</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td>XOM</td>
						<td>77</td>
						<td>25</td>
						<td>7:30AM 03/23/2018</td>
						<td>15</td>
						<td>3</td>
						<td>Executed</td>
					</tr>
					<tr>
						<td>APPL</td>
						<td>95</td>
						<td>60</td>
						<td>9:20PM 03/25/2018</td>
						<td>20</td>
						<td>1</td>
						<td>Unexecuted</td>
					</tr>
					<tr>
						<td>BP</td>
						<td>60</td>
						<td>100</td>
						<td>10:00AM 03/23/2018</td>
						<td>100</td>
						<td>2</td>
						<td>Denied</td>
					</tr>
				</tbody>
			</table>
			<div class="settle-button">
				<button class="btn-primary">Settle</button>
			</div>
		</div>
		<div id="order" class="tab-pane fade">
			<div class="container">
<form action="fromPmToTrader" >
  <h1>Order Form</h1>
    <div class="row">
      <div class="col-25">
        <label for="SideType">Side Type</label>
      </div>
      <div class="col-75">
       <select id="sideV" class="btn btn-default dropdown-toggle" id="menu1" name="side">

					<option  value="none">--Choose--</option>
					<option value="buy">Buy</option>
					<option value="sell">Sell</option>
				</select> 
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="">Ticker</label>
      </div>
      <div class="col-75">
         <select id="tickerV" class="btn btn-default dropdown-toggle" name="ticker">

					<option value="none">--Select--</option>
					<option value="INF">INF</option>
					<option value="TCS">TCS</option>
					<option value="Venkys">VEN</option>

				</select>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="Quantity">Quantity</label>
      </div>
      <div class="col-75">
       <input id="quantity" class="fill" type="text" name="quantity"><label id="errorText"></label>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="Trader">Trader ID</label>
      </div>
      <div class="col-75">
       <select id="trader" class="btn btn-default dropdown-toggle" name="traderId">

					<option value="none">--Select--</option>
					<option value="buy">Buy</option>
					<option value="sell">Sell</option>
				</select>  
      </div>
    </div>
    <div class="row">
      <button id="btn" >Submit</button>
    </div>
  </form>


			</div>

		</div>
	

	</div>


</div>
<div id="menu2" class="tab-pane fade"></div>

</div>
</div>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="./jquery-3.3.1.js"></script>
<script src="./bookorder.js"></script>
</html>