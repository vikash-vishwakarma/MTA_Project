package com.encee.MTA.admin.service.project;

import java.util.List;

import com.encee.MTA.admin.model.project.ProjectModel;
import com.encee.MTA.response.Response;

public interface ProjectService {

	public Response addProject(ProjectModel projectModel)throws Exception;
	
	public Response updateProject(ProjectModel projectModel)throws Exception;
	
	public ProjectModel get(long projectId)throws Exception;
	
	public List<ProjectModel>listProject()throws Exception;
	
	public Response deleteProject(long projectId)throws Exception;
	
	
}
