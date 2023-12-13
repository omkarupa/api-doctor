package com.po_solutions.apimedicalquestions.client.controller;

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

import com.po_solutions.apimedicalquestions.client.service.PatientService;
import com.po_solutions.apimedicalquestions.pojo.MedicalQuestionPojo;
import com.po_solutions.apimedicalquestions.service.BasicMedicalQuestionService;

@RestController
@RequestMapping("/api-medical-questions")
public class PatientClientController {
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	BasicMedicalQuestionService medicalQuestionService;
	
	@GetMapping("/patient/welcome")
	public ResponseEntity<String> welcomePatientAPI()
	{
		if(patientService.getPatientAPIWelcomeMessage() != null)
		{
			return new ResponseEntity<String> (patientService.getPatientAPIWelcomeMessage(),HttpStatus.OK);
		}
		
		return new ResponseEntity<String> (HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping("/patient/{patientId}")
	public ResponseEntity<MedicalQuestionPojo> createMedicalQuestionAnswersFromPatient(@PathVariable String patientId,@RequestBody Map<String, Object> requestMap)
	{
		
		MedicalQuestionPojo medicalQuestionPojo =  medicalQuestionService.getQuestionListUI(patientId, requestMap);
		
		if(medicalQuestionPojo != null)
		{
			return new ResponseEntity<MedicalQuestionPojo>(medicalQuestionPojo,HttpStatus.OK);
		}
		
		return new ResponseEntity<MedicalQuestionPojo>(HttpStatus.BAD_REQUEST);
		
	}

}
