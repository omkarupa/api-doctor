package com.po_solutions.apidoctor.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.po_solutions.apidoctor.client.entity.Patient;

@Service
@FeignClient("api-patient")
public interface PatientClient {
	
	@GetMapping("/api-patient")
	public ResponseEntity<String> patientURL();
	
	@GetMapping("/api-patient/patient/{patient-id}")
	public ResponseEntity<Patient> getPatientByPatientId(@PathVariable("patient-id") String patientIdString);


}
