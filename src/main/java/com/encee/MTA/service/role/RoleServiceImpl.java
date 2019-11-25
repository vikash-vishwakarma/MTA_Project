package com.encee.MTA.service.role;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.dao.role.RoleDAO;
import com.encee.MTA.domain.role.RoleDomain;
import com.encee.MTA.mapper.role.RoleMapper;
import com.encee.MTA.model.role.RoleModel;
import com.encee.MTA.response.Response;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO roleDAO;
	
    @Autowired
	RoleMapper roleMapper;
    
    private static final Logger logger=LoggerFactory.getLogger(RoleServiceImpl.class);

	@Override
	public Response addRole(RoleModel roleModel) throws Exception {
		try {
			RoleDomain roleDomain=new RoleDomain();
			BeanUtils.copyProperties(roleModel, roleDomain);
			Response response=roleDAO.addRole(roleDomain);
			return response;
		}
		catch(Exception e) {
			logger.info("Exception in Adding Role Data:"+e.getMessage());
			Response response=new Response();
			response.setStatusText(StatusCode.ERROR.name());
			response.setMessage(e.getMessage());
			return response;
		}
	}

	@Override
	public Response updateRole(RoleModel roleModel) throws Exception {
		try {
			RoleDomain roleDomain= new RoleDomain();
			BeanUtils.copyProperties(roleModel, roleDomain);
			Response response=roleDAO.updateRole(roleDomain);
			return response;
		}catch(Exception e) {
			logger.error("Exception in Updating Role Data" + e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<RoleModel> getRols() throws Exception {
		try {
			List<RoleDomain> list=roleDAO.getRols();
			return roleMapper.entityList(list);
		}
		catch(Exception e) {
			logger.error("Exception in getting List of Role Data",e);
		}
		return null;
	}

	@Override
	public RoleModel getRole(long roleId) throws Exception {
		try {
			RoleModel roleModel= new RoleModel();
			RoleDomain roleDomain=roleDAO.getRole(roleId);
			BeanUtils.copyProperties(roleDomain,roleModel);
			return roleModel;
		}
		catch(Exception e) {
			logger.info("Exception in Getting Role Id Data",e);
			return null;
		}
	}

	@Override
	public Response deleteRole(long roleId) throws Exception {
		try {
			return roleDAO.deleteRole(roleId);
		}
		catch(Exception e) {
			logger.info("Exception in Deleting Role Data",e);
			return null;
		}
	}
    
}
