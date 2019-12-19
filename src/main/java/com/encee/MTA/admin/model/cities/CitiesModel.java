package com.encee.MTA.admin.model.cities;

import java.io.Serializable;

public class CitiesModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9219254606561894183L;
	
	private long id;
	
	private String name;
	
	private int stateId;
	
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

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
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
