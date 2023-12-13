package com.po_solutions.apimedicalquestions.client.feignInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.po_solutions.apimedicalquestions.client.entity.Doctor;



@FeignClient("api-doctor")
public interface DoctorClient {
	
	@GetMapping("/api-doctor/Welcome")	
	 public ResponseEntity<String> welcomeDoctor();
	
	@GetMapping("/api-doctor/{doctorId}")
	public ResponseEntity<Doctor> getDoctorDetails(@PathVariable("doctorId") Long doctorId);
	
}
