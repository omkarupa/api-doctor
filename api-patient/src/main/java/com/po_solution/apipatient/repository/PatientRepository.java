package com.po_solution.apipatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.po_solution.apipatient.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	
	public Patient findByEmail(String email);
	
	public Patient findByCity(String city);
	
	public Patient findByfirstName(String firstName);
	
	public Patient findByLastName(String firstName);
	
	public Patient findByFirstNameAndMiddleNameAndLastName(String firstName,String middleName,String lastName);
	
	public Patient findByFirstNameOrMiddleNameOrLastName(String firstName,String middleName,String lastName);
	
	
}
