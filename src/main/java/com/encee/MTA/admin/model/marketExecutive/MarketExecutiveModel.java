package com.encee.MTA.admin.model.marketExecutive;

import java.io.Serializable;



public class MarketExecutiveModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6264408148108474081L;

	private long excutiveId;
	
	private String name;
	
	private long contactNo;
	
	private String email;
	
	private String dateOfBirth;
	
	private String stateId;
	
	private String cityId;
	
	private String pincode;
	
	private String address;
	
	private String assignedProject;
	
	private String registrationData;
	
	private String gender;
	
	private boolean status;

	public long getExcutiveId() {
		return excutiveId;
	}

	public void setExcutiveId(long excutiveId) {
		this.excutiveId = excutiveId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAssignedProject() {
		return assignedProject;
	}

	public void setAssignedProject(String assignedProject) {
		this.assignedProject = assignedProject;
	}

	public String getRegistrationData() {
		return registrationData;
	}

	public void setRegistrationData(String registrationData) {
		this.registrationData = registrationData;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
