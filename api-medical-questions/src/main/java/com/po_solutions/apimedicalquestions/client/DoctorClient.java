package com.po_solutions.apimedicalquestions.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("api-doctor")
public interface DoctorClient {
	
	@GetMapping("/api-doctor/Welcome")
	public ResponseEntity<String> welcomeDoctor();
	
}
