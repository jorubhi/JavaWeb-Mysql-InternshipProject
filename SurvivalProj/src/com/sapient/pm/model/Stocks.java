package com.sapient.pm.model;

public class Stocks {
	
	private int traderID;
	private String ticker;
	private int quantity;
	private double price;
	private String side;
	private int status;
	public Stocks() {
		// TODO Auto-generated constructor stub
	}
	public int getTraderID() {
		return traderID;
	}
	public void setTraderID(int traderID) {
		this.traderID = traderID;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Stocks(int traderID, String ticker, int quantity, double price, String side, int status) {
		super();
		this.traderID = traderID;
		this.ticker = ticker;
		this.quantity = quantity;
		this.price = price;
		this.side = side;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Stocks [traderID=" + traderID + ", ticker=" + ticker + ", quantity=" + quantity + ", price=" + price
				+ ", side=" + side + ", status=" + status + "]";
	}
	public Stocks(int quantity, int status, int traderID, String ticker) {
		super();
		this.traderID = traderID;
		this.ticker = ticker;
		this.quantity = quantity;
		this.status = status;
	}
	
	
	
	

}
