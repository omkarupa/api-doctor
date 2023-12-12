package com.po_solution.apipatient.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.po_solution.apipatient.entity.Patient;
import com.po_solution.apipatient.service.PatientService;

@RestController()
@RequestMapping("/api-patient")
public class PatientController {
	
	@Autowired
	PatientService service;
	
	@GetMapping("/")
	public ResponseEntity<String> patientURL()
	{
		return new ResponseEntity<String>("Welcome to Patient API",HttpStatus.OK);
	}


	 @PostMapping("/new")
	 public ResponseEntity<Patient>  createNewPatient(@RequestBody Map<String,String> requestMap )
	 {
	 
		Patient patient = service.createNewPatient(requestMap);
		 
		if(patient != null) 
		{
			return new ResponseEntity<>(patient,HttpStatus.OK);
		}
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	 }
		 
	 @GetMapping("/patient/{patient-id}")
	 public ResponseEntity<Patient> getPatientByPatientId(@PathVariable("patient-id") String patientIdString)
	 {
		 if(patientIdString != null)
		 {
			 try {
				 Long patientId = Long.parseLong(patientIdString);
				 
				 if(patientId > 0L)
				 {
					 Patient patient =  service.getPatientById(patientId);
					 
					 if(patient != null)
					 {
						 return new ResponseEntity<Patient>(patient,HttpStatus.OK);
					 }
					 else {
						 return new ResponseEntity<Patient> (HttpStatus.BAD_REQUEST);
					 }
				 }
			} catch (Exception e) {
				// TODO: handle exception
			}
			 
		 }
		 
		  return new ResponseEntity<Patient> (HttpStatus.BAD_REQUEST);
	 }
	 
}
