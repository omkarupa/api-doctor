package com.po_solutions.apimedicalquestions.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.po_solutions.apimedicalquestions.client.service.DoctorService;
import com.po_solutions.apimedicalquestions.client.service.PatientService;
import com.po_solutions.apimedicalquestions.service.BasicMedicalQuestionService;

@RestController
public class DoctorClientController {
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	BasicMedicalQuestionService medicalQuestionService;
	
	@GetMapping("/doctor/welcome")
	public ResponseEntity<String> welcomeDoctortAPI()
	{
		
		return null;
	}

}
