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

import com.po_solution.apipatient.pojo.MedicalQuestionPojo;
import com.po_solution.apipatient.service.MedicalQuestionService;

@RestController
@RequestMapping("/api-patient/questions")
public class MedicalQuestionsController {
	
	@Autowired
	MedicalQuestionService medicalQuestionService;

	@PostMapping("/patient-id/{patientId}")
	public ResponseEntity<MedicalQuestionPojo> createMedicalQuestionAnswersFromPatient(@PathVariable String patientId,@RequestBody Map<String, Object> requestMap)
	{
		
		MedicalQuestionPojo medicalQuestionPojo =  medicalQuestionService.getQuestionListUI(patientId, requestMap);
		
		if(medicalQuestionPojo != null)
		{
			return new ResponseEntity<MedicalQuestionPojo>(medicalQuestionPojo,HttpStatus.OK);
		}
		
		return new ResponseEntity<MedicalQuestionPojo>(HttpStatus.BAD_REQUEST);
		
	}
	
	
	@GetMapping("/patient-id/{patientId}")
	public ResponseEntity<MedicalQuestionPojo> getMedicalQuestionAnswersFromPatient(@PathVariable String patientId)
	{
		
		MedicalQuestionPojo medicalQuestionPojo =  medicalQuestionService.getQuestionList(patientId);
		
		if(medicalQuestionPojo != null)
		{
			return new ResponseEntity<MedicalQuestionPojo>(medicalQuestionPojo,HttpStatus.OK);
		}
		
		return new ResponseEntity<MedicalQuestionPojo>(HttpStatus.BAD_REQUEST);
		
	}
	

}
