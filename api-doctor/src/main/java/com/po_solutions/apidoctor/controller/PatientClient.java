package com.po_solutions.apidoctor.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient("api-patient")
public interface PatientClient {
	
	@GetMapping("/api-patient")
	public ResponseEntity<String> patientURL();

}
