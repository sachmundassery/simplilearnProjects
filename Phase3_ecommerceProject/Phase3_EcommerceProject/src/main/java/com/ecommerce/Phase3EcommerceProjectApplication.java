package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Phase3EcommerceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Phase3EcommerceProjectApplication.class, args);
		
		
	}

}
