package com.encee.MTA.admin.controller.cities;

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

import com.encee.MTA.admin.model.cities.CitiesModel;
import com.encee.MTA.admin.service.cities.CitiesService;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.ErrorObject;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@RestController
@RequestMapping("/v5")
public class CitiesController {

	private static final Logger logger=LoggerFactory.getLogger(CitiesController.class);
	
	@Autowired
	CitiesService citiesService;
	
	@RequestMapping(value = "/addCities" ,method = RequestMethod.POST,produces = "Application/json")
	public Response createCities(@RequestBody CitiesModel citiesModel,HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("Add Cities :Recevied request URL " +request.getRequestURL().toString()
				+((request.getQueryString()==null) ? "" :"?" +request.getQueryString().toString()));
		logger.info("Cities Data : send Data" +CommonUtils.getJson(citiesModel) );
		return citiesService.addCities(citiesModel);
	}
	
	@RequestMapping(value = "/listCities",method = RequestMethod.GET,produces = "Application/json")
	public @ResponseBody String list(HttpServletResponse response,HttpServletRequest request)
	throws Exception {
		logger.info("getting Cities Data : Recevied request URL " +request.getRequestURL().toString()
				+((request.getQueryString()==null) ?"" : "?" +request.getQueryString().toString()));
		List<CitiesModel>list=citiesService.listCities();
		Response res=CommonUtils.getResponseObject("Getting List of Cities Data");
		if(list == null) {
			ErrorObject err=CommonUtils.getErrorResponse("List of Cities Data Not Found", "List of Cities Data Not Found");
			res.setError(err);
			res.setStatusText(StatusCode.ERROR.name());
		}else {
			res.setData(list);
		}logger.info("List Cities Data Recevied");
		return CommonUtils.getJson(list);
	}
	
	@RequestMapping(value = "/getCities/{id}",method = RequestMethod.GET,produces = "Application/json")
	public @ResponseBody String getCities(@PathVariable ("id") long id, HttpServletRequest request,HttpServletResponse response)
	throws Exception {
		logger.info("Get Citie : Request recevied URL" +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "" :"?" +request.getQueryString().toString()));
		CitiesModel city= citiesService.getCities(id);
		Response response2=CommonUtils.getResponseObject("Cities Data");
		if(city == null) {
			ErrorObject err =CommonUtils.getErrorResponse("Data Not Found", "Data Not Found");
			response2.setError(err);
			response2.setStatusText(StatusCode.ERROR.name());
		}else {
			response2.setData(city);
		}
		logger.info("Send Data :Recevied request ");
         return CommonUtils.getJson(response2);
	}
}
