package com.encee.MTA.admin.dao.project;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.encee.MTA.admin.domain.project.ProjectDomain;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {
	
	private static final Logger logger=LoggerFactory.getLogger(ProjectDAOImpl.class);

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Response addProject(ProjectDomain projectDomain) throws Exception {
		Response res=CommonUtils.getResponseObject("adding Project");
		try {
			entityManager.persist(projectDomain);
		    res.setStatusText(StatusCode.SUCCESS.getDesc());
		    res.setMessage("Successfully added Project");
		}catch(Exception e) {
			logger.info("Exception in Adding ProjectDomain Data"+e.getMessage());
			res.setStatusText(StatusCode.ERROR.getDesc());
		}
		return res;
	}

	@Override
	public Response updateProject(ProjectDomain projectDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("Updating Project Details");
		try {
			ProjectDomain updateProject=getProject(projectDomain.getProjectId());
			updateProject.setName(projectDomain.getName());
			updateProject.setProjectNo(projectDomain.getProjectNo());
			updateProject.setCreatedDate(projectDomain.getCreatedDate());
			updateProject.setModificationDate(projectDomain.getModificationDate());
			entityManager.flush();
			response.setStatusText(StatusCode.SUCCESS.name());
		}catch(Exception e) {
			logger.info("Exception in updating ProjectDomain" +e.getMessage());
			response.setStatusText(StatusCode.ERROR.name());
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectDomain> listProject() throws Exception {
		try {
			String hql="From ProjectDomain where status= true";
			return (List<ProjectDomain>)entityManager.createQuery(hql).getResultList();
			
		}catch(Exception e) {
			logger.info("EXception in getting List of ProjectDomain" ,e);
		}
		return null;
	}

	@Override
	public ProjectDomain getProject(long projectId) throws Exception {
		try {
			String hql="From ProjectDomain where projectId=?1 and status=true";
			return (ProjectDomain)entityManager.createQuery(hql).setParameter(1, projectId).getSingleResult();
		}
		catch(EmptyResultDataAccessException e) {
			return null;
		}catch(Exception e) {
			logger.info("Exception in getting ProjectDomain Data" +e.getMessage());
		}
		return null;
	}

	@Override
	public Response deleteProject(long projectId) throws Exception {
		Response response=CommonUtils.getResponseObject("Deleteing Project Data ");
		try {
			ProjectDomain projectDomain=getProject(projectId);
			projectDomain.setStatus(false);
			entityManager.flush();
			response.setStatusText(StatusCode.SUCCESS.getDesc());
		}catch(Exception e) {
			logger.info("Exception in Deleting ProjectDomain ",e);
			response.setStatusText(StatusCode.ERROR.name());
			response.setMessage(e.getMessage());
		}
		return response;
	}

}
