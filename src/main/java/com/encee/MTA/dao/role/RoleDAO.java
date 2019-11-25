package com.encee.MTA.dao.role;

import java.util.List;

import com.encee.MTA.domain.role.RoleDomain;
import com.encee.MTA.response.Response;

public interface RoleDAO {

	public Response addRole(RoleDomain roleDomain)throws Exception;
	
	public Response updateRole(RoleDomain roleDomain)throws Exception;
	
	public Response deleteRole(long roleId)throws Exception;
	
	public List<RoleDomain>getRols()throws Exception;
	
	public RoleDomain getRole(long roleId)throws Exception;
}
