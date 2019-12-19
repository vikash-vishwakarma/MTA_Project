package com.encee.MTA.admin.controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.encee.MTA.admin.model.project.ProjectModel;
import com.encee.MTA.admin.service.project.ProjectService;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.ErrorObject;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@RestController
@RequestMapping(value="/v0")
public class ProjectController {

	private static final Logger logger=LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	ProjectService projectService;
	
//	Creating Project code start Here.
	
	@RequestMapping(value = "/addProject",method = RequestMethod.POST,produces = "Application/json")
	public Response createProject(@RequestBody ProjectModel projectModel,HttpServletRequest request,HttpServletResponse response)
	throws Exception {
		logger.info("Add Project: Request recevied URL : " +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "" :"?" +request.getQueryString().toString()));
		
		logger.info("Project Data :Recevied request " +CommonUtils.getJson(projectModel));
		return projectService.addProject(projectModel);
	}
	
//	Getting single Project Data Code Start Here.
	
	@RequestMapping(value = "/projectData/{id}", method = RequestMethod.GET,produces = "Application/json")
	 public @ResponseBody String getProject(@PathVariable ("id")long projectId,HttpServletRequest request,HttpServletResponse response )
	 throws Exception{
		logger.info("Get Data: Recevied request " +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "":"?" +request.getQueryString().toString()));
		ProjectModel projectModel=projectService.get(projectId);
		Response res = CommonUtils.getResponseObject("Getting Project Data");
		if(projectModel == null) {
			ErrorObject err=CommonUtils.getErrorResponse("Data Not Found ","Data Not Found ");
			res.setStatusText(StatusCode.ERROR.getDesc());
			res.setError(err);
		}else {
			res.setData(projectModel);
		}
		logger.info("Data :Request send " +CommonUtils.getJson(projectModel));
		return CommonUtils.getJson(res);
	}
	
//	List of Project Data Code start Here.
	
	@RequestMapping(value = "/listProject",method = RequestMethod.GET,produces = "Application/json")
	public @ResponseBody String list (HttpServletResponse response,HttpServletRequest request)
	throws Exception{
		logger.info("Send Data :Recevied request" +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "": "?" +request.getQueryString().toString()));
		List<ProjectModel>list=projectService.listProject();
		Response resp=CommonUtils.getResponseObject("List of Project Data");
		if(list == null) {
			ErrorObject error=CommonUtils.getErrorResponse("Data Not Found","Data Not Found");
			resp.setError(error);
			resp.setStatusText(StatusCode.ERROR.getDesc());
		}else {
			resp.setData(list);
		}
		logger.info("Get Data :Send Response");
		return CommonUtils.getJson(resp);
	}
	
//Deleting Project Code Written Here.
	
	@RequestMapping(value = "/deletingProject/{id}",method = RequestMethod.DELETE,produces = "Application/json")
	public Response DeleteProject (@PathVariable ("id") long projectId,HttpServletRequest request,HttpServletResponse response)
	throws Exception {
		logger.info("Send Data :Recevied request " +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "" :"?" +request.getQueryString().toString()));
		return projectService.deleteProject(projectId);
	}
	
	
//	Updating Project Details Code start Here.
	
	@RequestMapping(value = "/updatingProject",method = RequestMethod.PUT,produces = "Application/json")
	public Response updateProject (@RequestBody ProjectModel projectModel,HttpServletRequest request,HttpServletResponse response)
	throws Exception {
		logger.info("Send Data: Recevied request " +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "" : "?" +request.getQueryString().toString()));
		logger.info("updating Project Data :Recevied request " +CommonUtils.getJson(projectModel));
		return projectService.updateProject(projectModel);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
