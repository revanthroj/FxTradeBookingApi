package com.finzly.fxtradbooking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.finzly.fxtradbooking.jdbc.JDBC_Connection;
import com.finzly.fxtradbooking.model.FxTradBookingModel;
import com.finzly.fxtradbooking.model.TradeBookedData;

import org.springframework.stereotype.Repository;

@Repository
public class FxTradeBookingDao {
	static int tradeNo = 1;
	private Connection con;
	private String query;
	private Statement statement;
	private static float tranferRate;
	static String CurrencyPair = "USDINR";
	
	static TradeBookedData tradeBookedData;
	static FxTradBookingModel tradeData = new FxTradBookingModel();

	TradeProcess tradeProcess = new TradeProcess();
	static ArrayList<FxTradBookingModel> table = new ArrayList<>();

	public FxTradeBookingDao() throws SQLException {
		float rate = 66.00f;
		tranferRate = rate;
		con = JDBC_Connection.getConnection();
		statement = con.createStatement();
	}

	public String bookTrade(FxTradBookingModel data) throws SQLException {
		if(tradeNo == 1) {
			deleteData();
		}
		if ((tradeProcess.inrConverter(Long.parseLong(data.getTransferAmount())).equals("Please Enter valid amount"))) {
			return "Please Enter valid amount";
		}
		if (!tradeProcess.currencyPairCheck(data.getCurrencyPair()).equalsIgnoreCase(CurrencyPair)) {
			return CurrencyPair + " only approved";
		}
		if (data.getBookOrcancel().equalsIgnoreCase("book")) {
			if (data.getIsRate().equalsIgnoreCase("yes")) {
				return "You are transferring INR " + tradeProcess.inrConverter(Long.parseLong(data.getTransferAmount()))
						+ " to " + data.getUsername() + "(Assuming that rate was " + tranferRate + ")\n"
						+ insertTrade(data);
			}
			if (data.getIsRate().equalsIgnoreCase("no")) {
				return insertTrade(data);
			}
		} else if (data.getBookOrcancel().equalsIgnoreCase("cancel")) {
			return "Traded Canceled";
		}
		return "retry";
	}

	private String insertTrade(FxTradBookingModel data) throws SQLException {
		query = "insert into fxtradebooking(TradeNo, CurrencyPair, CustomerName, Amount,Rate) values(" + (tradeNo++)
				+ ",'" + data.getCurrencyPair().toUpperCase() + "','" + data.getUsername() + "','"
				+ tradeProcess.inrConverter(Long.parseLong(data.getTransferAmount())) + "','" + tranferRate + "')";
		statement.executeUpdate(query);
		return "Trade for " + CurrencyPair + " has been booked with rate " + tranferRate + ", The amount of "
				+ tradeProcess.inrConverter(Long.parseLong(data.getTransferAmount()))
				+ " will be transferred in 2 working days to " + data.getUsername() + ".";
	}

	public ArrayList<TradeBookedData> printTrade() throws SQLException {
		query = "select TradeNo,CurrencyPair,CustomerName,Amount,Rate from fxtradebooking";
		ResultSet rs = statement.executeQuery(query);
		ArrayList<TradeBookedData> bookedTrade = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				tradeBookedData = new TradeBookedData(rs.getLong("TradeNo"), rs.getString("CurrencyPair"),
						rs.getString("CustomerName"), rs.getString("Amount"), tranferRate);
				bookedTrade.add(tradeBookedData);
			}
			System.out.println("Booked Trade Details "+bookedTrade);
			return bookedTrade;
		}
		System.out.println("null");
		return null;
	}

	public String deleteTable() throws SQLException {
		deleteData();
		return "Bye - have a good day";
	}
	public void deleteData() throws SQLException {
		query = "truncate table fxtradebooking";
		statement.executeUpdate(query);
	}
}
