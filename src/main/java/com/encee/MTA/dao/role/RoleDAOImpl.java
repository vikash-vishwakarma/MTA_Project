package com.encee.MTA.dao.role;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.domain.role.RoleDomain;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	 EntityManager entityManager;
	
	private static final Logger logger=LoggerFactory.getLogger(RoleDAOImpl.class);

	@Override
	public Response addRole(RoleDomain roleDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("Adding Role Data ");
		try {
			entityManager.persist(roleDomain);
			response.setStatusText(StatusCode.SUCCESS.name());
			response.setMessage("Successfully Added Role Data: ");
		}
		catch(Exception e) {
			response.setError(StatusCode.ERROR.name());
			response.setError(e.getMessage());
		}
		return response;
	}

	@Override
	public Response updateRole(RoleDomain roleDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("Updated Role Data");
		try {
			RoleDomain roleDomains=getRole(roleDomain.getRoleId());
			roleDomains.setRoleName(roleDomain.getRoleName());
			entityManager.flush();
			response.setStatusText(StatusCode.SUCCESS.name());
			response.setStatus(StatusCode.SUCCESS.getCode());
		}catch(Exception e) {
			logger.error("Exception in Updating Role Data" +e.getMessage());
			return null;
		}
		return response;
	}

	@Override
	public Response deleteRole(long roleId) throws Exception {
		Response response=CommonUtils.getResponseObject("Deleting Role Data");
		try {
			RoleDomain roleDomain=getRole(roleId);
			roleDomain.setActive(false);
			entityManager.flush();
			response.setStatusText(StatusCode.SUCCESS.name());
		}
		catch(Exception e) {
			logger.error("Exception in Deleting Role Data",e);
			response.setStatusText(StatusCode.ERROR.name());
			response.setError(e.getMessage());
			
		}
		return response;
	}

	@Override
	public List<RoleDomain> getRols() throws Exception {
		try {
			String hql="From RoleDomain where isActive=true";
			return (List<RoleDomain>)entityManager.createQuery(hql).getResultList();
		}
		catch(Exception e) {
			logger.error("Exception in Getting List Role Id",e);
		}
		return null;
	}

	@Override
	public RoleDomain getRole(long roleId) throws Exception {
		try {
			String hql="From RoleDomain where roleId=?1 and isActive=true";
			return (RoleDomain) entityManager.createQuery(hql).setParameter(1, roleId).getSingleResult();
		}
		catch(EmptyResultDataAccessException e) {
			return null;
		}
		catch(Exception e) {
			logger.error("Exception in getting Role Id Data" +e.getMessage());
			return null;
		}
	}
}
