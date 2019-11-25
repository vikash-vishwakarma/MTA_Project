package com.encee.MTA.dao.customer;

import java.util.List;

import com.encee.MTA.domain.customer.CustomerDomain;
import com.encee.MTA.response.Response;

public interface CustomerDAO {

	public Response addCustomer(CustomerDomain customerDomain)throws Exception;
	
	public Response updateCustomer(CustomerDomain customerDomain)throws Exception;
	
	public List<CustomerDomain>getCustomers()throws Exception;

	CustomerDomain getCustomer(long l) throws Exception;

	Response deleteCustomer(long id) throws Exception;
}
