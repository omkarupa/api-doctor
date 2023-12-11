package com.po_solutions.apimedicalquestions.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.po_solutions.apimedicalquestions.client.entity.Patient;

@Service
public class PatientServiceImpl {

	@Autowired
	PatientClient patientClient;
	
	public Patient getPatientByPatientId(String patientId)
	{
		return patientClient.getPatientByPatientId(patientId).getBody();
	}
	
	public String getPatientAPIWelcomeMessage()
	{
		return patientClient.patientURL().getBody();
	}
	

}
