package com.po_solutions.apidoctor.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.po_solutions.apidoctor.client.entity.Patient;
import com.po_solutions.apidoctor.client.feignInterface.PatientClient;

@RestController
@RequestMapping("api-doctor")
public class PatientClientController {

	@Autowired
	PatientClient client;
	
	@GetMapping("/patient-client/welcome")
	public ResponseEntity<String> weilcomePatient(){
		return client.patientURL();
	}
	
	@GetMapping("Patient-client/{doctorId}")
	public ResponseEntity<Patient> getPatientDetails(@PathVariable("doctorId") String doctorId){
		 
		System.out.println("Patient fetch");
		  ResponseEntity<Patient> patient= client.getPatientByPatientId(doctorId);
		  patient.getBody(); 
		  if(null!=patient) 
			  return patient; 
		  return new ResponseEntity<Patient>(HttpStatus.BAD_REQUEST);
		 
		
	}
	
}
