package com.infosys.infytel.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EkartDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkartDiscoveryServerApplication.class, args);
	}

}
