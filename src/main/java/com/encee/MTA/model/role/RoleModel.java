package com.encee.MTA.model.role;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RoleModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 323831720640468789L;

	private long RoleId;
	
	private String roleName;
	
	private boolean isActive;

	public long getRoleId() {
		return RoleId;
	}

	public void setRoleId(long roleId) {
		RoleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
