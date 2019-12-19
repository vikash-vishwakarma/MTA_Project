package com.encee.MTA.admin.domain.marketExecutive;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="market_excutive")
public class MarketExcutiveDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3435348219457870094L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long excutiveId;
	
	@Column
	private String name;
	
	@Column
	private long contactNo;
	
	@Column
	private String email;
	
	@Column
	private String dateOfBirth;
	
	@Column
	private String stateId;
	
	@Column
	private String cityId;
	
	@Column
	private String pincode;
	
	@Column
	private String address;
	
	@Column
	private String assignedProject;
	
	@Column
	private String registrationDate;
	
	@Column
	private String gender;
	
	@Column
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

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
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
