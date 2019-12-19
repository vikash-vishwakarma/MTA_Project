package com.encee.MTA.admin.service.customer;

import java.util.List;

import com.encee.MTA.admin.model.customer.CustomerModel;
import com.encee.MTA.response.Response;

public interface CustomerService {

	public Response addCustomer(CustomerModel customerModel)throws Exception;
	
	public  List<CustomerModel> getCustomers()throws Exception;
	
	Response updateCustomer(CustomerModel customerMdodel) throws Exception;

	CustomerModel getCustomer(long id) throws Exception;

	Response deleteCustomer(long id) throws Exception;
}
