package com.po_solutions.apimedicalquestions.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.po_solutions.apimedicalquestions.client.entity.Patient;


@FeignClient("api-patient")
@Service
public interface PatientClient{
	
	@GetMapping("/api-patient/")
	public ResponseEntity<String> patientURL();
	
	 @GetMapping("/patient/{patient-id}")
	 public ResponseEntity<Patient> getPatientByPatientId(@PathVariable("patient-id") String patientIdString);
	
	

}
