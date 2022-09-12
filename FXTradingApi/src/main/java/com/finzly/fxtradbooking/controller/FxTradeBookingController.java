package com.finzly.fxtradbooking.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finzly.fxtradbooking.model.FxTradBookingModel;
import com.finzly.fxtradbooking.model.TradeBookedData;
import com.finzly.fxtradbooking.service.FxTradeBookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fxTradeBooking")
public class FxTradeBookingController {
	@Autowired
	private FxTradeBookingService service;
// 	to insert trade details into database
	@PostMapping("/bookTrade")
	public String bookTrade(@RequestBody FxTradBookingModel data) throws SQLException {
		System.out.println(data);
		String status = service.bookTrade(data);
		return status;
	}
//	to printTrade data
	@GetMapping("/printTrade")
	public ArrayList<TradeBookedData> printTrade() throws SQLException {
		return service.printTrade();
	}
//	Delete Table Data And to exit
	@DeleteMapping("/exit")
	public String deleteTable() throws SQLException {
		return service.deleteTable();
	}
}
