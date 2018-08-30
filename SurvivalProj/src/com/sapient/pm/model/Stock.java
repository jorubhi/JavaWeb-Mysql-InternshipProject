package com.sapient.pm.model;

public class Stock {
	private int quantity;
	private int status;
	private String stockName;
	private String ticker,traderId;
	
	
	public String getTraderId() {
		return traderId;
	}
	public void setTraderId(String traderId) {
		this.traderId = traderId;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getStatus() {
		return status;
	}
	public String getStockName() {
		return stockName;
	}
	public String getTicker() {
		return ticker;
	}
	public Stock(int quantity, int status, String ticker) {
		super();
		this.quantity = quantity;
		this.status = status;
	
		this.ticker = ticker;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Stock() {
		// TODO Auto-generated constructor stub
	}
	
	
		
		// TODO Auto-generated constructor stub
	
	@Override
	public String toString() {
		return "Stock [quantity=" + quantity + ", status=" + status + ", stockName=" + stockName + ", ticker=" + ticker
				+ "]";
	}
	

}
