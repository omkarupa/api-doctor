package com.po_solutions.apidoctor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.po_solutions.apidoctor.entity.Doctor;
import com.po_solutions.apidoctor.repository.DoctorRepo;
@Service
public class DcotorServiceImpl implements DoctorService{

	@Autowired
	DoctorRepo doctorRepo;
	
	@Override
	public Optional<Doctor> getDoctorDetailsbyEmail(String Email) {
		return doctorRepo.findByEmail(Email);
	}

	@Override
	public Optional<Doctor> getDoctorDetailsbyLicenseNumber(String licenseNumber) {
		
		return doctorRepo.findByLicenseNumber(licenseNumber);
	}

	@Override
	public Optional<Doctor> getDoctorDetailsbyId(Long doctorId) {
		return doctorRepo.findByDoctorId(doctorId);
	}

	@Override
	public void saveDoctorDetails(Doctor doctor) {
		doctorRepo.save(doctor);
	}

}
