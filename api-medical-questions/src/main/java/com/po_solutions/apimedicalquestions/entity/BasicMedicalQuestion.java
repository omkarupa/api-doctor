package com.po_solutions.apimedicalquestions.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BasicMedicalQuestion {
	

	
	@Id
	@GeneratedValue
	private Long medicalQuestionId;
	
	private String question;
	private String questionSetCd;
	private String responseValue;
	private String detailDescription;
	
	private Long patientId;

	public Long getMedicalQuestionId() {
		return medicalQuestionId;
	}

	public void setMedicalQuestionId(Long medicalQuestionId) {
		this.medicalQuestionId = medicalQuestionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionSetCd() {
		return questionSetCd;
	}

	public void setQuestionSetCd(String questionSetCd) {
		this.questionSetCd = questionSetCd;
	}

	public String getResponseValue() {
		return responseValue;
	}

	public void setResponseValue(String responseValue) {
		this.responseValue = responseValue;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "BasicMedicalQuestion [medicalQuestionId=" + medicalQuestionId + ", question=" + question
				+ ", questionSetCd=" + questionSetCd + ", responseValue=" + responseValue + ", detailDescription="
				+ detailDescription + ", patientId=" + patientId + "]";
	}
	
	
	
	



}
