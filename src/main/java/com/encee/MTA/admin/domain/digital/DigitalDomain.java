package com.encee.MTA.admin.domain.digital;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="digital")
public class DigitalDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7920462617974319605L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long digitalId;
	
	@Column(name="digital_type")
	private String digitalType;
	
	@Column(name="type_id")
	private int typeId;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="modification_date")
	private Date modificationDate;
	
	@Column(name="status")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
