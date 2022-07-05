package com.seanlindev.netflixhystrixdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class NetflixHystrixDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixHystrixDemoApplication.class, args);
	}

}
