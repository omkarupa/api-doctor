package com.po_solutions.apidoctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiDoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDoctorApplication.class, args);
	}

}
