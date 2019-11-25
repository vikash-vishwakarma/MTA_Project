package com.encee.MTA.controller.role;

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

import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.model.role.RoleModel;
import com.encee.MTA.response.ErrorObject;
import com.encee.MTA.response.Response;
import com.encee.MTA.service.role.RoleService;
import com.encee.MTA.utils.CommonUtils;

@RestController
@RequestMapping("/v1")
public class RoleController {

	private static final Logger logger=LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	RoleService roleService;
	
	
	//Adding Role Data Code Start Here.
	
	@RequestMapping(value="/role",method =RequestMethod.POST,produces = "Application/json")
	public Response addRole(@RequestBody RoleModel roleModel,HttpServletRequest request,HttpServletResponse response)
			throws Exception	{ 
		logger.info("addRole: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("Add Role's :Recevied request id" +CommonUtils.getJson(roleModel));
		return roleService.addRole(roleModel);
	
	}
	
	//Getting single RoleID Data Code Start Here.
	
	@RequestMapping(value="/role/{id}",method=RequestMethod.GET,produces = "Application/json")
	public @ResponseBody String getRoleId(@PathVariable("id")long roleId,HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("getRole: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		RoleModel roleModel=roleService.getRole(roleId);
		Response res=CommonUtils.getResponseObject("Role Data");
		if(roleModel == null) {
			ErrorObject err=CommonUtils.getErrorResponse("Role id Data Not Found :","Role Id Data Not Found");
			res.setError(err);
			res.setStatusText(StatusCode.ERROR.name());
		}else {
			res.setData(roleModel);
		}
		logger.info("Get Role : "+CommonUtils.getJson(roleModel));
		return CommonUtils.getJson(res);
	}
	
	
	//	deleting Role Id Data Code Start Here.
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE,produces = "Application/json")
	public @ResponseBody Response DeleteRoleId(@PathVariable ("id") long roleId ,HttpServletRequest request,HttpServletResponse response) 
	throws Exception {
		logger.info("Delete Role Id: Recevied request URl :" +request.getRequestURL().toString()
				+((request.getQueryString()==null) ? "": "?" +request.getQueryString().toString()));
		return roleService.deleteRole(roleId);
	}

	// Getting List of Data Code start Here.
	
	@RequestMapping(value = "/List",method = RequestMethod.GET,produces = "Application/json")
	public @ResponseBody String getRols(HttpServletRequest request,HttpServletResponse response)throws Exception{
		logger.info("Getting data: Recevied request:"+request.getRequestURL().toString()
				+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
		
		List<RoleModel>list=roleService.getRols();
		
		Response response2=CommonUtils.getResponseObject("List or Rols Data");
		if(list == null) {
			ErrorObject err=CommonUtils.getErrorResponse("Role Data Not Found","Role Data Not Found");
			response2.setError(err);
			response2.setStatusText(StatusCode.ERROR.name());
		}else {
			response2.setData(list);
		}
		logger.info("Get Roles Data: Send response ");
		return CommonUtils.getJson(response2);
	}
	
//	Updating Role Data Code Start Here.
	@RequestMapping(value = "/update",method = RequestMethod.PUT,produces = "Application/json")
	public Response updateRole(@RequestBody RoleModel roleModel,HttpServletRequest request
			,HttpServletResponse response)throws Exception {
		logger.info("Getting Data Recevied request:"+request.getRequestURL().toString()
				+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
		logger.info("Update Customer: Recevied request"+CommonUtils.getJson(roleModel));
		return roleService.updateRole(roleModel);
	}
}

