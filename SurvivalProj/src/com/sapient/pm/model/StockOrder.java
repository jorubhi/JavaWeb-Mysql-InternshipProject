package com.sapient.pm.model;

public class StockOrder {
	
	int tid,quantity;
	String symbol,side;
	double price,stopLoss,targetPrice;
	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getStopLoss() {
		return stopLoss;
	}
	
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public void setStopLoss(double stopLoss) {
		this.stopLoss = stopLoss;
	}
	public double getTargetPrice() {
		return targetPrice;
	}
	public void setTargetPrice(double targetPrice) {
		this.targetPrice = targetPrice;
	}
	

}
