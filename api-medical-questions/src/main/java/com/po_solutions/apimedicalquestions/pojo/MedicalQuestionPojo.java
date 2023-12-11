package com.po_solutions.apimedicalquestions.pojo;

import java.util.List;

import com.po_solutions.apimedicalquestions.entity.BasicMedicalQuestion;



public class MedicalQuestionPojo {

	private Long patientId;
	
	private List<BasicMedicalQuestion> basicMedicalQuestions;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public List<BasicMedicalQuestion> getBasicMedicalQuestions() {
		return basicMedicalQuestions;
	}

	public void setBasicMedicalQuestions(List<BasicMedicalQuestion> basicMedicalQuestions) {
		this.basicMedicalQuestions = basicMedicalQuestions;
	}
	
	
	


	
}
