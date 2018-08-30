package com.sapient.pm.model;

public class Trader {

	private int traderId;
	private String ticker;
	private int quantity;
	private double price;
	private String side;
	
	public Trader() {
		// TODO Auto-generated constructor stub
	}

	public Trader(int traderId, String ticker, int quantity, double price, String side) {
		super();
		this.traderId = traderId;
		this.ticker = ticker;
		this.quantity = quantity;
		this.price = price;
		this.side = side;
	}

	public int getTraderId() {
		return traderId;
	}

	public void setTraderId(int traderId) {
		this.traderId = traderId;
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

	@Override
	public String toString() {
		return "Trader [traderId=" + traderId + ", ticker=" + ticker + ", quantity=" + quantity + ", price=" + price
				+ ", side=" + side + "]";
	}
	
	
	
}
