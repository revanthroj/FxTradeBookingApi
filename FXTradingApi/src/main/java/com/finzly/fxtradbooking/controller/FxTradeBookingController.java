package com.finzly.fxtradbooking.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finzly.fxtradbooking.model.FxTradBookingModel;
import com.finzly.fxtradbooking.model.TradeChioce;
import com.finzly.fxtradbooking.service.FxTradeBookingService;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("/bookTrade")
	public String bookTrade(@RequestBody FxTradBookingModel data) throws SQLException {
		System.out.println(data);
		String status = service.bookTrade(data);
		return status;
	}
	
	@GetMapping("/printTrade")
	public ArrayList<FxTradBookingModel> printTrade() throws SQLException {
		return service.printTrade();
	}

}
