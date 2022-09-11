package com.finzly.fxtradbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.finzly")
public class FxTradingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FxTradingApiApplication.class, args);
	}

}
