package com.po_solutions.apidoctor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.po_solutions.apidoctor.entity.Doctor;
import com.po_solutions.apidoctor.entity.Hospital;
import com.po_solutions.apidoctor.repository.DoctorRepo;

@Service
public class DoctorServiceImpl implements DoctorService {

	Log log = LogFactory.getLog(getClass());

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

	@Override
	public Doctor createNewDoctor(Map<String, Object> requestMap) {
		

		if (requestMap.containsKey("firstName") && requestMap.containsKey("middleName")
				&& requestMap.containsKey("lastName") && requestMap.containsKey("mobile")
				&& requestMap.containsKey("email") && requestMap.containsKey("password")
				&& requestMap.containsKey("address") && requestMap.containsKey("city")
				&& requestMap.containsKey("licenseNumber") && requestMap.containsKey("qualification")
				&& requestMap.containsKey("gender") && requestMap.containsKey("experienceInYears")
				&& requestMap.containsKey("specialization") && requestMap.containsKey("hospital")) {

			if (null!=requestMap.get("firstName") && null!=requestMap.get("middleName")
					&& null!=requestMap.get("lastName") && null!=requestMap.get("mobile")
					&& null!=requestMap.get("email") && null!=requestMap.get("password")
					&& null!=requestMap.get("address") && null!=requestMap.get("city")
					&& null!=requestMap.get("licenseNumber") && null!=requestMap.get("qualification")
					&& null!=requestMap.get("gender") && null!=requestMap.get("experienceInYears")
					&& null!=requestMap.get("specialization") && null!=requestMap.get("hospital")) {
				
				List<Hospital> hospitals = new ArrayList<Hospital>();
				List<Map<String, String>> hospitalMap = (List<Map<String, String>>) requestMap.get("hospital");
				
				for(Map<String, String> hospMap : hospitalMap )
				{
					hospitals.add(convertHospitalFromMap(hospMap)); 
				}

				Doctor doctor = convertDoctorFromMap(requestMap,hospitals);

				log.info("Doctor info Before Save {}" + doctor.toString());

				doctor = doctorRepo.save(doctor);

				log.info("Patient info After Save {}" + doctor.toString());

				return doctor;
			}

		}

		return null;
	}

	private Hospital convertHospitalFromMap(Map<String, String> hospMap) {
		
		if(hospMap.containsKey("name") && hospMap.containsKey("address") && hospMap.containsKey("city") && hospMap.containsKey("phoneNumber")) {
			if(null!=hospMap.get("name") && null!=hospMap.get("address") && null!=hospMap.get("city") && null!=hospMap.get("phoneNumber")) {
				Hospital hospital = new Hospital();
				hospital.setName(hospMap.get("name"));
				hospital.setAddress(hospMap.get("address"));
				hospital.setCity(hospMap.get("city"));
				hospital.setPhoneNumber(hospMap.get("phoneNumber"));
				
				
				System.out.println( "Creating Hospiotal Object");
				return hospital;
			}
		}
		
		return null;
		
		
	}

	@Override
	public Doctor convertDoctorFromMap(Map<String, Object> requestMap,List<Hospital> hospitals) {
		Doctor doctor = new Doctor();
		doctor.setFirstName(requestMap.get("firstName").toString());
		doctor.setMiddleName(requestMap.get("middleName").toString());
		doctor.setLastName(requestMap.get("lastName").toString());
		doctor.setMobile(requestMap.get("mobile").toString());
		doctor.setEmail(requestMap.get("email").toString());
		doctor.setPassword(requestMap.get("password").toString());
		doctor.setLicenseNumber(requestMap.get("licenseNumber").toString());
		doctor.setAddress(requestMap.get("address").toString());
		doctor.setCity(requestMap.get("city").toString());
		doctor.setGender(requestMap.get("gender").toString());
		doctor.setQualification(requestMap.get("qualification").toString());
		doctor.setSpecialization(requestMap.get("specialization").toString());
		doctor.setExperienceInYears(requestMap.get("experienceInYears").toString());
		doctor.setHospital(hospitals);
		System.out.println(requestMap.get("hospital"));

		return doctor;
	}

}
