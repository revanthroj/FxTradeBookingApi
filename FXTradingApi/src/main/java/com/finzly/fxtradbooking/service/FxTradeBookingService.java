package com.finzly.fxtradbooking.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finzly.fxtradbooking.dao.FxTradeBookingDao;
import com.finzly.fxtradbooking.model.FxTradBookingModel;
import com.finzly.fxtradbooking.model.TradeBookedData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FxTradeBookingService {

	@Autowired
	FxTradeBookingDao dao;

	public String bookTrade(FxTradBookingModel data) throws SQLException {
		String status = dao.bookTrade(data);
		return status;
	}

	public ArrayList<TradeBookedData> printTrade() throws SQLException {
		return dao.printTrade();
	}

	public String deleteTable() throws SQLException {
		return dao.deleteTable();
	}

}
