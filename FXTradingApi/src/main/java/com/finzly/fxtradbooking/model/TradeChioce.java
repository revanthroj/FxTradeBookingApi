package com.finzly.fxtradbooking.model;

public class TradeChioce {
	private String isRate;
	private String bookOrcancel;
	
	public String getIsRate() {
		return isRate;
	}
	public void setIsRate(String isRate) {
		this.isRate = isRate;
	}
	public String getBookOrcancel() {
		return bookOrcancel;
	}
	public void setBookOrcancel(String bookOrcancel) {
		this.bookOrcancel = bookOrcancel;
	}
	@Override
	public String toString() {
		return "TradeChioce [isRate=" + isRate + ", bookOrcancel=" + bookOrcancel + "]";
	}
	
}
