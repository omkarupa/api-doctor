package com.po_solution.apipatient.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.po_solution.apipatient.entity.Patient;
import com.po_solution.apipatient.repository.PatientRepository;
import com.po_solution.apipatient.utils.PatientUtil;

@Service
public class PatientServiceImpl implements PatientService {
	
	Log log = LogFactory.getLog(getClass());
	
	@Autowired
	PatientRepository patientRepo;
	
	

	@Override
	public Patient createNewPatient(Map<String, String> requestMap) {
		
		if(		requestMap.containsKey("firstName") && 
				requestMap.containsKey("middleName") && 
				requestMap.containsKey("lastName") && 
				requestMap.containsKey("mobile") && 
				requestMap.containsKey("email") && 
				requestMap.containsKey("password") && 
				requestMap.containsKey("address") && 
				requestMap.containsKey("city") && 
				requestMap.containsKey("dateOfBirth") && 
				requestMap.containsKey("identityNumber") &&
				requestMap.containsKey("bloodGroup") &&
				requestMap.containsKey("gender"))
		{
		
			if(requestMap.get("firstName") != null && 
					requestMap.get("middleName") != null && 
					requestMap.get("lastName") != null && 
					requestMap.get("mobile") != null && 
					requestMap.get("email") != null && 
					requestMap.get("password") != null && 
					requestMap.get("address") != null && 
					requestMap.get("city") != null && 
					requestMap.get("dateOfBirth") != null && 
					requestMap.get("identityNumber") != null &&
					requestMap.get("bloodGroup") != null &&
					requestMap.get("gender") != null) {
				
				Patient patient = convertPatientFromMap(requestMap);
				
				log.info("Patient info Before Save {}" + patient.toString());
				
				patient = patientRepo.save(patient);
				
				log.info("Patient info After Save {}" + patient.toString());
				
				return patient;
			}
				
		}
		
		return null;
	}

	@Override
	public Patient convertPatientFromMap(Map<String, String> requestMap) {
		
		
		Patient patient = new Patient();
		patient.setFirstName(requestMap.get("firstName"));
		patient.setMiddleName(requestMap.get("middleName"));
		patient.setLastName(requestMap.get("lastName"));
		patient.setMobile(requestMap.get("mobile"));
		patient.setEmail(requestMap.get("email"));
		patient.setPassword(requestMap.get("password"));
		patient.setDateOfBirth(PatientUtil.getInstance().convertToDate(requestMap.get("dateOfBirth")));
		patient.setAddress(requestMap.get("address"));
		patient.setBloodGroup(requestMap.get("bloodGroup"));
		patient.setCity(requestMap.get("city"));
		patient.setGender(requestMap.get("gender"));
		patient.setIdentityNumber(requestMap.get("identityNumber"));
		
		return patient;
		
	}

	@Override
	public List<Patient> getPatientById(String patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getPatientByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getPatientByFirstNameOrMiddleNameOrLastName(String firstName, String middleName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
