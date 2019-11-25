package com.encee.MTA.controller.bank;

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
import com.encee.MTA.model.bank.BankModel;
import com.encee.MTA.response.ErrorObject;
import com.encee.MTA.response.Response;
import com.encee.MTA.service.bank.BankService;
import com.encee.MTA.utils.CommonUtils;

@RestController
@RequestMapping("/v2")
public class BankController {

	private static final Logger logger = LoggerFactory.getLogger(BankController.class);

	@Autowired
	BankService bankService;

	// Adding Bank Data Code Start Here.
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "Application/json")
	public Response addBank(@RequestBody BankModel bankModel, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Add Bank :Recevied request URL :" + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("add Bank :Recevied request" + CommonUtils.getJson(bankModel));
		return bankService.addBank(bankModel);
	}

	//Getting Single Bank Data Code Start Here.
	
	@RequestMapping(value = "/bank/{id}", method = RequestMethod.GET, produces = "Application/json")
	public @ResponseBody String getBank(@PathVariable("id") long id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("Get Bank Data :Recevied request URL :" + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		BankModel bankModel = bankService.getBank(id);
		Response response2 = CommonUtils.getResponseObject("Bank List Details");
		if (bankModel == null) {
			ErrorObject errorObject = CommonUtils.getErrorResponse("Bank Data Not Found", "Bank Data Not Found ");
			response2.setError(errorObject);
			response2.setStatusText(StatusCode.ERROR.name());
		} else {
			response2.setData(bankModel);
		}
		logger.info("Get Bank Data :Send Request");
		return CommonUtils.getJson(response2);

	}

//	Updating Bank data Code Start Here.
	
	@RequestMapping (value = "/update",method = RequestMethod.PUT,produces = "Application/json")
	public Response updateBank(@RequestBody BankModel bankModel,HttpServletRequest request ,HttpServletResponse response)
	throws Exception {
		logger.info("Getting Update Data: Recevied request URL " + request.getRequestURL().toString()
				+((request.getQueryString()==null)? "":"?" +request.getQueryString().toString()));
		logger.info("Updating Bank Data : Recevied Data" + CommonUtils.getJson(bankModel));
		return bankService.updateBank(bankModel);
	}
	
//	List of Bank Data Start code Here
	
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "Application/json")
	public  @ResponseBody String list(HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("List Bank Data :Request recevied URL " +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "":"?" +request.getQueryString().toString()));
		List<BankModel>list=bankService.getBanks();
		Response response2=CommonUtils.getResponseObject("List of Bank Data");
		if(list ==null) {
			ErrorObject err=CommonUtils.getErrorResponse("Customer Not Found", "Customer Not Found");
			response2.setError(err);
			response2.setStatusText(StatusCode.ERROR.name());
		}else {
			response2.setData(list);
		}
		logger.info("List Data :Recevied" );
		return CommonUtils.getJson(response2);
	}
	
//	Deleting Bank Data Code Start Here.
	
	@RequestMapping (value = "delete/{id}",method=RequestMethod.DELETE,produces="Application/json")
	public @ResponseBody Response deleteBank(@PathVariable ("id") long id,HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("Delete Bank Data :Request recevied URL " +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "":"?" +request.getQueryString().toString()));
		
		return bankService.deleteBank(id);
	}
}
