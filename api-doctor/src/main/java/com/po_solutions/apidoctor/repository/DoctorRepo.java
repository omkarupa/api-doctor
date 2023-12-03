package com.po_solutions.apidoctor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.po_solutions.apidoctor.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer>{
	
	Optional<Doctor> findByEmail(String email);
	Optional<Doctor> findByLicenseNumber(String licenseNumber);
	Optional<Doctor> findByDoctorId(Long doctorId);

}
