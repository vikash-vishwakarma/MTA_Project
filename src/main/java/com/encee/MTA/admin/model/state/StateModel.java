package com.encee.MTA.admin.model.state;

import java.io.Serializable;


public class StateModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8024043815357889104L;

	private long id;
	
	private String name;
	
	private int countryId;

	private boolean status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
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
