package com.po_solutions.apimedicalquestions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.po_solutions.apimedicalquestions.entity.BasicMedicalQuestion;

public interface BasicMedicalQuestionRepository extends JpaRepository<BasicMedicalQuestion, Long> {
	
	public List<BasicMedicalQuestion> findByPatientId(Long patientId);

}
