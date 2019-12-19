package com.encee.MTA.admin.service.project;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encee.MTA.admin.dao.project.ProjectDAO;
import com.encee.MTA.admin.domain.project.ProjectDomain;
import com.encee.MTA.admin.mapper.project.ProjectMapper;
import com.encee.MTA.admin.model.project.ProjectModel;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Service
public class ProjectServiceImpl implements ProjectService {

	private static final Logger logger=LoggerFactory.getLogger(ProjectServiceImpl.class);
	
	@Autowired
	ProjectDAO projectDAO;
	
	@Autowired
	ProjectMapper projectMapper;

	@Override
	public Response addProject(ProjectModel projectModel) throws Exception {
		Response response=CommonUtils.getResponseObject("Adding project Data");
		try {
			ProjectDomain projectDomain=new ProjectDomain();
			BeanUtils.copyProperties(projectModel, projectDomain);
			response=projectDAO.addProject(projectDomain);
		}catch(Exception e) {
			logger.info("Exception in adding ProjectDomain data " +e.getMessage());
			response.setStatusText(StatusCode.ERROR.getDesc());
		}
		return response;
	}

	@Override
	public Response updateProject(ProjectModel projectModel) throws Exception {
		ProjectDomain projectDomain=new ProjectDomain();
		BeanUtils.copyProperties(projectModel, projectDomain);
		Response response=projectDAO.updateProject(projectDomain);
		return response;
	}

	@Override
	public ProjectModel get(long projectId) throws Exception {
		try {
		    ProjectModel projectModel=new ProjectModel();
		    ProjectDomain projectDomain=projectDAO.getProject(projectId);
		    BeanUtils.copyProperties(projectDomain, projectModel);
		    return projectModel;
		}catch(Exception e) {
			logger.info("Exception getting ProjectModel Data" ,e);
		}
		return null;
	}

	@Override
	public List<ProjectModel> listProject() throws Exception {
		try {
			List<ProjectDomain>list=projectDAO.listProject();
			return projectMapper.entityList(list);
		}catch(Exception e) {
			logger.info("Exception in getting list of ProjectDomain",e);
		}
		return null;
	}

	@Override
	public Response deleteProject(long projectId) throws Exception {
		try {
			projectDAO.deleteProject(projectId);
			return CommonUtils.getResponseObject("Successfully Deleted Project: "+projectId);
		}catch(Exception e) {
			logger.info("Exception in Deleting Project Data" +e.getMessage());
		}
		return null;
	}
	
	
}
