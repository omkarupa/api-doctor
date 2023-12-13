package com.po_solutions.apimedicalquestions.controller;

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

import com.po_solutions.apimedicalquestions.pojo.MedicalQuestionPojo;
import com.po_solutions.apimedicalquestions.service.BasicMedicalQuestionService;



@RestController
@RequestMapping("/api-medical-questions")
public class MedicalQuestionsController {
	
	@Autowired
	BasicMedicalQuestionService medicalQuestionService;
	
	

	
	@GetMapping("")
	public ResponseEntity<String> welcomeMedicalQuestionsAPI()
	{
		
		return new ResponseEntity<String>("Welcome to API Medical Questions",HttpStatus.OK);
	}
	
	
	
	
	
	
}
