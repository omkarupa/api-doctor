package com.po_solution.apipatient.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po_solution.apipatient.client.entity.Doctor;

@FeignClient("api-doctor")
@Service
public interface DoctorClient {
	
	@GetMapping("/api-doctor/Welcome")	
	 public ResponseEntity<String> welcomeDoctor();

	@GetMapping("/api-doctor/{doctorId}")
	public ResponseEntity<Doctor> getDoctorDetails(@PathVariable("doctorId") Long doctorId);
	

}
