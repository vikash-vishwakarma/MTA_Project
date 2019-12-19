package com.encee.MTA.admin.controller.digital;

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

import com.encee.MTA.admin.model.digital.DigitalModel;
import com.encee.MTA.admin.service.digital.DigitalService;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.ErrorObject;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@RestController
@RequestMapping(value = "/v0")
public class DigitalController {

	private static final Logger logger=LoggerFactory.getLogger(DigitalController.class);
	
	@Autowired
	DigitalService digitalService;
	
	
//	Adding Digital Media Data Code Start Here.
	
	@RequestMapping(value = "/CreatingDigital",method = RequestMethod.POST,produces = "Application/json")
	
	public Response create(@RequestBody DigitalModel digitalModel, HttpServletRequest request , HttpServletResponse response)
	throws Exception{
		logger.info("Send Data :Recevied request " +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "" :"?" +request.getQueryString().toString()));
		logger.info("Digital Data :Recevied Data " +CommonUtils.getJson(digitalModel));
		return digitalService.createDigital(digitalModel);
	}
	
//	Single Digital Media code Start Here.
	
	@RequestMapping(value = "/digitalData/{id}",method = RequestMethod.GET,produces = "Application/json")
	public String getDigital(@PathVariable ("id") long digitalId,HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("Send Data :Recevied request" +request.getRequestURL().toString()
				+((request.getQueryString()==null) ? "" : "?" +request.getQueryString().toString()));
		DigitalModel digitalModel=digitalService.getDigital(digitalId);
		Response res= CommonUtils.getResponseObject("Digital Media Data ");
		if(digitalModel == null ) {
			ErrorObject err = CommonUtils.getErrorResponse("Digital Media Data Not Found ","Digital Media Data Not Found ");
			res.setStatusText(StatusCode.ERROR.getDesc());
			res.setError(err);
		}else {
			res.setData(digitalModel);
		}
		logger.info("Send Data :Recevied request " +CommonUtils.getJson(digitalModel));
		return CommonUtils.getJson(digitalModel);
	}
	
	
//	Getting List of Digital Media Code Start Here.
	
	@RequestMapping(value = "listDigital",method=RequestMethod.GET,produces="Application/json")
	public @ResponseBody String list( HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("send Data: Recevied request URL " +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "" : "?"+request.getQueryString().toString()));
		List<DigitalModel>list=digitalService.listDigital();
				Response resp=CommonUtils.getResponseObject("List of Digital Data ");
		if(list == null) {
			ErrorObject err=CommonUtils.getErrorResponse("Data Not Found ","Data Not Found ");
			resp.setStatusText(StatusCode.ERROR.getDesc());
			resp.setError(err);
		}else {
			resp.setData(list);
		}
		logger.info("Get Data : Send Response");
		return CommonUtils.getJson(resp);
	}
	
	
//	Updating DigitalMedia Code Start Here.
	
	@RequestMapping(value = "updateDigital",method = RequestMethod.PUT,produces = "Application/json")
	public Response update(@RequestBody DigitalModel digitalModel,HttpServletRequest request,HttpServletResponse response)
    throws Exception{
		logger.info("send Data: Recevied request URL " +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "" : "?"+request.getQueryString().toString()));
		logger.info("Send Data : Digital Data Recevied " +CommonUtils.getJson(digitalModel));
		return digitalService.updateDigital(digitalModel);
		
	}
	
	
//	Deleting Digital Media Data Code Start Here.
	
	@RequestMapping(value = "/deleteDigital/{id}",method = RequestMethod.DELETE,produces = "AQpplication/json")
	public Response deleteDigital(@PathVariable ("id") long digitalId ,HttpServletRequest request,HttpServletResponse response )
	throws Exception {
		logger.info("send Data: Recevied request " +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "" : "?"+request.getQueryString().toString()));
		return digitalService.deleteDigital(digitalId);
	}
	
	
}
