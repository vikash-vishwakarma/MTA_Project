package com.encee.MTA.service.customer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.dao.customer.CustomerDAO;
import com.encee.MTA.domain.customer.CustomerDomain;
import com.encee.MTA.mapper.customer.CustomerMapper;
import com.encee.MTA.model.customer.CustomerModel;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	CustomerMapper customerMapper;
	
	private static final Logger logger=LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public Response addCustomer(CustomerModel customerModel) throws Exception {
		Response response=CommonUtils.getResponseObject("Customer Creation ");
		try {
			CustomerDomain customerDomain= new CustomerDomain();
			BeanUtils.copyProperties(customerModel, customerDomain);
			response=customerDAO.addCustomer(customerDomain);
		}
		catch(Exception e) {
			logger.error("Exception in Adding Customer Data " + e.getMessage());
			response.setStatusText(StatusCode.ERROR.getDesc());
			response.setStatus(StatusCode.ERROR.getCode());
		}
		return response;
	}

	@Override
	public CustomerModel getCustomer(long id) throws Exception {
		try {
			CustomerModel customerModel= new CustomerModel();
			CustomerDomain customerDomain=customerDAO.getCustomer(id);
			BeanUtils.copyProperties(customerDomain,customerModel);
			return customerModel;
		}
		catch(Exception e) {
			logger.info("Exception in Getting customer id",e );
			return null;
		}
	}

	@Override
	public List<CustomerModel> getCustomers() throws Exception {
		try {
			List<CustomerDomain>list=customerDAO.getCustomers();
			return customerMapper.entityList(list);
		}
		catch(Exception e) {
			logger.error("Exception in getting Customer Data",e);
		}
		return null;
	}

	@Override
	public Response deleteCustomer(long id) throws Exception {
		try {
			return customerDAO.deleteCustomer(id);
		}
		catch(Exception e) {
			logger.info("Getting probleam to deleting Customer Data",e);
			return null;
			
		}
	}
	
	@Override
	public Response updateCustomer(CustomerModel customerModel)throws Exception
	{
		CustomerDomain customer=new CustomerDomain();
		BeanUtils.copyProperties(customerModel, customer);
		Response response=customerDAO.updateCustomer(customer);
		return response;
	}

}
