package com.retail.rewards;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RewardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardsApplication.class, args);
		log.info("Testing the application");
	}

}
