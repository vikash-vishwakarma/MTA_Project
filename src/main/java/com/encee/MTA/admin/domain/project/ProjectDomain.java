package com.encee.MTA.admin.domain.project;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
@Entity
@Table(name="project")
public class ProjectDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8699737128224636304L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long projectId;
	
	@Column(name="project_name")
	private String name;
	
	@Column(name="project_no")
	private String projectNo;
	
	@Column(name="created_date")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="modification_date")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date modificationDate;
	
	@Column(name="online")
	private boolean onLine;
	
	@Column(name="offline")
	private boolean offLine;
	
	@Column(name="status")
	private boolean status;

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
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

	public boolean isOnLine() {
		return onLine;
	}

	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}

	public boolean isOffLine() {
		return offLine;
	}

	public void setOffLine(boolean offLine) {
		this.offLine = offLine;
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
