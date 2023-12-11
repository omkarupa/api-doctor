package com.po_solutions.apimedicalquestions.service;

import java.util.Map;

import com.po_solutions.apimedicalquestions.pojo.MedicalQuestionPojo;



public interface BasicMedicalQuestionService {
	
	public MedicalQuestionPojo getQuestionList(String patientId);
	
	public MedicalQuestionPojo getQuestionListUI(String patientId, Map<String, Object> requestMap);


}
