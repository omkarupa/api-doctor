package com.po_solutions.apidoctor.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/Welcome")
	public ResponseEntity<String> welcomeDoctor(){		 
		return new ResponseEntity<String>("Welcome Doctor",HttpStatus.OK);
	}
	
	@RequestMapping("/{doctorId}")
	@ResponseBody
	public ResponseEntity<Doctor> getDoctorDetails(@PathVariable("doctorId") Long doctorId){	
		
		Doctor doctor =   doctorService.getDoctorDetailsbyId(doctorId).orElse(null);
		
		if(doctor != null)
		{
			return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
		}	
		
		return new ResponseEntity<Doctor>(HttpStatus.BAD_REQUEST);
	}

	/*
	 * @PostMapping("/new")
	 * 
	 * @ResponseBody public String saveDoctorDetails(@RequestBody Doctor doctor){
	 * System.out.println(doctor); doctorService.saveDoctorDetails(doctor);
	 * 
	 * return "Doctor details Saved successfully."; }
	 */
	
	
	@PostMapping("/new")
	@ResponseBody
	public ResponseEntity<Doctor> createNewDoctor(@RequestBody Map<String, Object> reMap){		 
		System.out.println(reMap);
		Doctor doctor	= doctorService.createNewDoctor(reMap);
		
		if(doctor != null )
		{
			return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
		}
		
		return  new ResponseEntity<Doctor>(HttpStatus.BAD_REQUEST);
	}

}
