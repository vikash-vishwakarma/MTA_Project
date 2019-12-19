package com.encee.MTA.admin.model.bank;

import java.io.Serializable;

public class BankModel implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3228249523296652739L;
	

	private long id;
	
	private String bankName;
	
	private boolean status;

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
