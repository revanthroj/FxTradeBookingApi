package com.finzly.fxtradbooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class FxTradBookingModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tradeNo;
	private String username;
	private String currencyPair;
	private String transferAmount;
	private float tranferRate = 66.00f;

	public FxTradBookingModel() {
		// TODO Auto-generated constructor stub
	}

	public FxTradBookingModel(Long tradeNo, String username, String currencyPair, String transferAmount,
			float tranferRate) {
		this.tradeNo = tradeNo;
		this.username = username;
		this.currencyPair = currencyPair;
		this.transferAmount = transferAmount;
		this.tranferRate = tranferRate;
	}

	@Column
	public Long getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(Long tradeNo) {
		this.tradeNo = tradeNo;
	}

	@Column
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column
	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	@Column
	public String getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(String transferAmount) {
		this.transferAmount = transferAmount;
	}

	@Column
	public float getTranferRate() {
		return tranferRate;
	}

	public void setTranferRate(float tranferRate) {
		this.tranferRate = tranferRate;
	}

	private String isRate ;
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
		return "FxTradBookingModel [tradeNo=" + tradeNo + ", username=" + username + ", currencyPair=" + currencyPair
				+ ", transferAmount=" + transferAmount + ", tranferRate=" + tranferRate + "]";
	}

}
