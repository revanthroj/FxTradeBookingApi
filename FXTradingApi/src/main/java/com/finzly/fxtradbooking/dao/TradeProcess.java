package com.finzly.fxtradbooking.dao;

import java.text.NumberFormat;
import java.util.Locale;

public class TradeProcess {

	static String CurrencyPair = "USDINR";
	private static Long usdToinr;
	private static float tranferRate = 66.00f;
	
	public String currencyPairCheck(String currencyPair) {
		if (CurrencyPair.equalsIgnoreCase(currencyPair)) {
			return currencyPair;
		}
		return ("Only" + CurrencyPair + " is accepted Try Again..");
	}
	
	
	public String inrConverter(Long transAmountLong) {
		if (transAmountLong > 0) {
			usdToinr = (long) (transAmountLong * tranferRate);
			NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
			String currency = formatter.format(usdToinr);
			return currency;
		}
		return ("Please Enter valid amount");
	}
}
