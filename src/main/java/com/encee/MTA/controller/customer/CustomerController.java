package com.encee.MTA.controller.customer;

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
import com.encee.MTA.model.customer.CustomerModel;
import com.encee.MTA.response.ErrorObject;
import com.encee.MTA.response.Response;
import com.encee.MTA.service.customer.CustomerService;
import com.encee.MTA.utils.CommonUtils;

@RestController
@RequestMapping("/v3")
public class CustomerController {

	private static final Logger logger=LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	
//Add Customer Data Start code Here 
	
	@RequestMapping(value = "/add",method=RequestMethod.POST,produces ="Application/json")
	public Response addCustomer(@RequestBody CustomerModel customerMdoel ,HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		logger.info("addParent: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addUser: Received request: "+ CommonUtils.getJson(customerMdoel));
		return customerService.addCustomer(customerMdoel);
	}
	
//	Deleting Customer Data Start Here
	
	@RequestMapping(value = "/delete/{customerId}",method=RequestMethod.DELETE,produces ="Application/json")
	public @ResponseBody Response DeleteCustomer (@PathVariable ("customerId")long id,HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("Delete Customer :Received request url :" + request.getRequestURL().toString()
				+((request.getQueryString() == null) ? "": "?" + request.getQueryString().toString()));
		return customerService.deleteCustomer(id);
	}
	
	// Getting Customer Single Id Code Start Here.
	
	@RequestMapping(value = "/customer/{id}",method=RequestMethod.GET,produces="Application/json")
	public @ResponseBody String getCustomer(@PathVariable("id") long id,HttpServletRequest request,HttpServletResponse response)
    throws Exception{
		logger.info("Getting data :Recevied request url :"+request.getRequestURL().toString()
				+((request.getQueryString() == null) ? "" : "?" +request.getQueryString().toString()));
		CustomerModel customerModel=customerService.getCustomer(id);
		Response res = CommonUtils.getResponseObject("customerList details");
		if(customerModel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("Customer Not Found", "Customer Not Found");
			res.setError(err);
			res.setStatusText(StatusCode.ERROR.name());
		} 
		else
		{
			res.setData(customerModel);
		}
		logger.info("Get customer :Send Response");
	      return CommonUtils.getJson(res);
	}
	
	//Getting All Customer Code Start Here.
	
	@RequestMapping(value = "/customer",method = RequestMethod.GET,produces = "Application/json")
	public @ResponseBody String getCustomers(HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("Getting data: Recevied request:"+request.getRequestURL().toString()
				+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
		
		       List<CustomerModel>list=customerService.getCustomers();
				Response res=CommonUtils.getResponseObject("List of Customer Data");
				
				if(list==null) {
					ErrorObject err=CommonUtils.getErrorResponse("Customer Not Found", "Customer Not Found");
					res.setError(err);
					res.setStatusText(StatusCode.ERROR.name());
				}else {
					res.setData(list);
				}
					logger.info("get Customers: sent response");
					return CommonUtils.getJson(res);
	}
	
	//updating Customer Code Start Here.
	
	@RequestMapping(value = "/customer",method = RequestMethod.PUT,produces = "Application/json")
	public Response updateCustomer(@RequestBody CustomerModel customerModel ,HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		logger.info("Getting Data Recevied request:"+request.getRequestURL().toString()
				+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
		logger.info("Update Customer: Recevied request"+CommonUtils.getJson(customerModel));
		return customerService.updateCustomer(customerModel);
	}
}
