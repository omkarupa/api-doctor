package com.po_solutions.apidoctor.service;

import java.util.Optional;

import com.po_solutions.apidoctor.entity.Doctor;

public interface DoctorService {
	
	Optional<Doctor> getDoctorDetailsbyEmail (String Email);
	Optional<Doctor> getDoctorDetailsbyLicenseNumber (String licenseNumber);
	Optional<Doctor> getDoctorDetailsbyId (Long doctorId);
	public void saveDoctorDetails(Doctor doctor);
}
