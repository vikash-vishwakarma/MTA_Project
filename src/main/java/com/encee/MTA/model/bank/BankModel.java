package com.encee.MTA.model.bank;

import java.io.Serializable;

public class BankModel implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3228249523296652739L;
	

	private long id;
	
	private String bankName;
	
	private boolean isActive;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
