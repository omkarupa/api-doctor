package com.po_solutions.apidoctor.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


import com.po_solutions.apidoctor.entity.Doctor;
import com.po_solutions.apidoctor.entity.Hospital;

public interface DoctorService {
	
	Optional<Doctor> getDoctorDetailsbyEmail (String Email);
	Optional<Doctor> getDoctorDetailsbyLicenseNumber (String licenseNumber);
	Optional<Doctor> getDoctorDetailsbyId (Long doctorId);
	public void saveDoctorDetails(Doctor doctor);
	public Doctor createNewDoctor(Map<String, Object> requestMap);
	Doctor convertDoctorFromMap(Map<String, Object> requestMap, List<Hospital> hospitals);
}
