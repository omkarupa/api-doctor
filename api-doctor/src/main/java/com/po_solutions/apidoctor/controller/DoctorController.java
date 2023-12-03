package com.po_solutions.apidoctor.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.po_solutions.apidoctor.entity.Doctor;
import com.po_solutions.apidoctor.service.DoctorService;

@RestController
@RequestMapping("/api-doctor")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	@RequestMapping("/Welcome")
	@ResponseBody
	public String welcomeDoctor(){		 
		return "Welcome Doctor";
	}
	
	@RequestMapping("/{doctorId}")
	@ResponseBody
	public Optional<Doctor> getDoctorDetails(@PathVariable("doctorId") Long doctorId){		 
		return doctorService.getDoctorDetailsbyId(doctorId);
	}
	@PostMapping("/new")
	@ResponseBody
	public String saveDoctorDetails(@RequestBody Doctor doctor){		 
		System.out.println(doctor);
		doctorService.saveDoctorDetails(doctor);
		
		return "Doctor details Saved successfully.";
	}
	@PostMapping("/newA")
	@ResponseBody
	public String saveDoctorDetailsMap(@RequestBody Map<String, Object> reMap){		 
		System.out.println(reMap);
		doctorService.createNewDoctor(reMap);
		
		return "Doctor details Saved successfully.";
	}

}
