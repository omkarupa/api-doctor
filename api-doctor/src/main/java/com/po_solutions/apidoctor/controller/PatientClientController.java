package com.po_solutions.apidoctor.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.po_solutions.apidoctor.client.entity.Patient;

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
		  return new ResponseEntity<Patient>(org.springframework.http.HttpStatus.BAD_REQUEST);
		 
		
	}
	
}
