package com.encee.MTA.admin.domain.state;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="states")
public class StateDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2917046486242910175L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="state_id")
    private long id;
	
	@Column(name="state_name")
	private String name;
	
	@Column(name="country_id")
	private int countryId;
	
	@Column(name="status")
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
