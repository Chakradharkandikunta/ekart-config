package com.infosys.ekart.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AddressMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressMsApplication.class, args);
	}

}
