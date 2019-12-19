package com.encee.MTA.admin.domain.role;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class RoleDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5801787732213905286L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roleId;
	
	@Column
	private String roleName;

	@Column
	private boolean status;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
