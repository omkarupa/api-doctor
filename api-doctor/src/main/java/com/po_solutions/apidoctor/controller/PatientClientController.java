package com.po_solutions.apidoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api-doctor")
public class PatientClientController {

	@Autowired
	PatientClient client;
	
	@GetMapping("patient-client/welcome")
	public ResponseEntity<String> weilcomePatient(){
		return client.patientURL();
	}
	
}
