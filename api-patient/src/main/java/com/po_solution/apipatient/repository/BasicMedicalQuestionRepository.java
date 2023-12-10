package com.po_solution.apipatient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.po_solution.apipatient.entity.BasicMedicalQuestion;

public interface BasicMedicalQuestionRepository extends JpaRepository<BasicMedicalQuestion, Long> {
	
	public List<BasicMedicalQuestion> findByPatientId(Long patientId);

}
