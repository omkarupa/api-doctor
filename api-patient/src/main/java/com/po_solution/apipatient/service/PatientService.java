package com.po_solution.apipatient.service;

import java.util.List;
import java.util.Map;

import com.po_solution.apipatient.entity.Patient;

public interface PatientService {
	
	
	public Patient createNewPatient(Map<String, String> requestMap);
	
	public Patient convertPatientFromMap(Map<String, String> requestMap);
	
	public List<Patient> getPatientById(String patientId);
	
	public List<Patient> getAllPatients();
	
	public Patient getPatientByFirstNameAndMiddleNameAndLastName(String firstName,String middleName,String lastName);
	
	public Patient getPatientByFirstNameOrMiddleNameOrLastName(String firstName,String middleName,String lastName);
	
	

}
