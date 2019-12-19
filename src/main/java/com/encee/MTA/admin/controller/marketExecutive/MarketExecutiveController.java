package com.encee.MTA.admin.controller.marketExecutive;

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

import com.encee.MTA.admin.model.marketExecutive.MarketExecutiveModel;
import com.encee.MTA.admin.service.marketExecutive.MarketExcutiveService;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.ErrorObject;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@RestController
@RequestMapping("/v8")
public class MarketExecutiveController {
	
	@Autowired
	MarketExcutiveService marketExcutiveService;

	private static final Logger logger=LoggerFactory.getLogger(MarketExecutiveController.class);
	
	
//	Create Code Start Here.
	
	@RequestMapping(value = "/create", method= RequestMethod.POST, produces = "Application/json" )
	
	public Response create(@RequestBody MarketExecutiveModel marketExecutiveModel,HttpServletRequest request,HttpServletResponse response)
	throws Exception {
		logger.info("Add MarketExcutive :Recevied request URL :" + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		
		logger.info("Add MarketExecutive Data :Request recevied" +CommonUtils.getJson(marketExecutiveModel));
		return marketExcutiveService.create(marketExecutiveModel);
	}
	
//	Getting Single data Code Start Here.
	
	@RequestMapping(value = "/getdata/{id}",method = RequestMethod.GET,produces = "Application/json")
	public @ResponseBody String getData(@PathVariable("id")long excutiveId,HttpServletRequest request,HttpServletResponse response)
	throws Exception {
		logger.info("get Data: Recevied request URL " +request.getRequestURL().toString()
				+((request.getQueryString()==null)? " " : "?" +request.getQueryString().toString()));

        MarketExecutiveModel marketExcutiveModel=marketExcutiveService.getData(excutiveId);
        Response res =CommonUtils.getResponseObject("Getting single MarketExcutive Data");
        if(marketExcutiveModel ==null) {
        	ErrorObject err = CommonUtils.getErrorResponse("Data Not Found", "Data Not Found");
        	res.setError(err);
        	res.setStatusText(StatusCode.ERROR.getDesc());
        }else {
        	res.setData(marketExcutiveModel);
        }
        logger.info("Get Data : Send Request ");
        return  CommonUtils.getJson(res);
     }
  }
