package com.po_solution.apipatient.service;

import java.util.List;
import java.util.Map;

import com.po_solution.apipatient.entity.BasicMedicalQuestion;
import com.po_solution.apipatient.pojo.MedicalQuestionPojo;

public interface MedicalQuestionService {
	
	
	public MedicalQuestionPojo getQuestionList(String patientId);
	
	public MedicalQuestionPojo getQuestionListUI(String patientId, Map<String, Object> requestMap);
}
