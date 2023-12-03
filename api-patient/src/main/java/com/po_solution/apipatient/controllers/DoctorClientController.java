package com.po_solution.apipatient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.po_solution.apipatient.client.entity.Doctor;

@RestController
@RequestMapping("/api-patient")
public class DoctorClientController {
	
	@Autowired
	DoctorClient client;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMessageFromAPIDoctor() {
		
		return client.welcomeDoctor();
		
	}
	
	@GetMapping("/doctor/{doctorId}")
	public ResponseEntity<Doctor> getDoctorDetails(@PathVariable("doctorId") Long doctorId){	
		
		Doctor doctor =   client.getDoctorDetails(doctorId).getBody();
		
		if(doctor != null)
		{
			return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
		}	
		
		return new ResponseEntity<Doctor>(HttpStatus.BAD_REQUEST);
	}

}
