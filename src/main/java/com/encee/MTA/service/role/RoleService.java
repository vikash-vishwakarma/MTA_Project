package com.encee.MTA.service.role;

import java.util.List;

import com.encee.MTA.model.role.RoleModel;
import com.encee.MTA.response.Response;

public interface RoleService {

	public Response addRole(RoleModel roleModel)throws Exception;
	
	public Response updateRole(RoleModel roleModel)throws Exception;
	
	public List<RoleModel>getRols()throws Exception;
	
	public RoleModel getRole(long roleId)throws Exception;
	
	public Response deleteRole(long roleId)throws Exception;
	
}
