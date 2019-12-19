package com.encee.MTA.admin.dao.role;

import java.util.List;

import com.encee.MTA.admin.domain.role.RoleDomain;
import com.encee.MTA.response.Response;

public interface RoleDAO {

	public Response addRole(RoleDomain roleDomain)throws Exception;
	
	public Response updateRole(RoleDomain roleDomain)throws Exception;
	
	public Response deleteRole(long roleId)throws Exception;
	
	public List<RoleDomain>getRols()throws Exception;
	
	public RoleDomain getRole(long roleId)throws Exception;
}
