package com.encee.MTA.admin.model.digital;

import java.io.Serializable;
import java.util.Date;

public class DigitalModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -981831722530807172L;

	private long digitalId;
	
	private String digitalType;
	
	private int typeId;
	
	private Date createdDate;
	
	private Date modificationDate;
	
	private boolean status;

	public long getDigitalId() {
		return digitalId;
	}

	public void setDigitalId(long digitalId) {
		this.digitalId = digitalId;
	}

	public String getDigitalType() {
		return digitalType;
	}

	public void setDigitalType(String digitalType) {
		this.digitalType = digitalType;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
