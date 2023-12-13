package com.po_solutions.apimedicalquestions.client.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Hospital {
	
	private Long hospitalId;
	private String name;
	private String address;
	private String city;
	private String phoneNumber;
	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	



}
