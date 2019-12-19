package com.encee.MTA.admin.dao.project;

import java.util.List;

import com.encee.MTA.admin.domain.project.ProjectDomain;
import com.encee.MTA.response.Response;

public interface ProjectDAO {

	public Response addProject(ProjectDomain projectDomain)throws Exception;
	
	public Response updateProject(ProjectDomain projectDomain)throws Exception;
	
	public List<ProjectDomain>listProject()throws Exception;
	
	public ProjectDomain getProject(long projectId)throws Exception;
	
	public Response deleteProject(long projectId)throws Exception;
	
}
