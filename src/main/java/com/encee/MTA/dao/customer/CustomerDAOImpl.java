package com.encee.MTA.dao.customer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.domain.customer.CustomerDomain;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	EntityManager entityManager;
	
	private static final Logger logger=LoggerFactory.getLogger(CustomerDAOImpl.class);

	@Override
	public Response addCustomer(CustomerDomain customerDomain) {
		Response response=CommonUtils.getResponseObject("Add Customer Data");
		try {
			entityManager.persist(customerDomain);
			response.setStatusText(StatusCode.SUCCESS.name());
			response.setStatus(StatusCode.SUCCESS.getCode());
			response.setData(customerDomain);
		}
		catch(Exception e) {
			logger.error("Exception create in CustomerDAOImpl" + e.getMessage());
			response.setStatus(StatusCode.ERROR.getCode());
			response.setStatusText(StatusCode.ERROR.getDesc());
		}
		return response;
	}

	@Override
	public CustomerDomain getCustomer(long id) throws Exception {
		try 
		{
			String hql = "From CustomerDomain where id=?1 and isActive=true";
			return (CustomerDomain) entityManager.createQuery(hql).setParameter(1,id).getSingleResult();
		}
			catch (EmptyResultDataAccessException e) 
			{
				return null;
			} 
			catch (Exception e) 
			{
				logger.error("Exception in getting Customer Data"+ e.getMessage());
				return null;
			}
		}

	@Override
	public Response updateCustomer(CustomerDomain customer) throws Exception {
		Response response=CommonUtils.getResponseObject("Updating Customer Data");
		try {
			CustomerDomain customers=getCustomer(customer.getId());
			customers.setFirstName(customer.getFirstName());
			customers.setLastName(customer.getLastName());
			customers.setEmail(customer.getEmail());
			customers.setContactNo(customer.getContactNo());
			customers.setCity(customer.getCity());
			customers.setState(customer.getState());
			customers.setAddress(customer.getAddress());
			customers.setPinCode(customer.getPinCode());
			customers.setGender(customer.getGender());
			customers.setDateOfBirth(customer.getDateOfBirth());
			customers.setPassword(customer.getPassword());
			 entityManager.flush();
			 response.setStatusText(StatusCode.SUCCESS.name());
		}
		catch(Exception e) {
			logger.error("Exception in updating Customer Data",e);
			response.setStatusText(StatusCode.ERROR.name());
			response.setError(e.getMessage());
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerDomain> getCustomers() throws Exception 
	{
		try {
			String hql="From CustomerDomain where isActive=true";
			return (List<CustomerDomain>)entityManager.createQuery(hql).getResultList();
		}
		catch (Exception e) {
			logger.error("Exception in Getting Data", e);
		}
		return null;
		
		
	}

	@Override
	public Response deleteCustomer(long id) throws Exception {
		Response response = CommonUtils.getResponseObject("Deleted Customer Data ");
		try {
			CustomerDomain customerDomain=getCustomer(id);
			customerDomain.setActive(false);
			entityManager.flush();
			response.setStatusText(StatusCode.SUCCESS.name());
		}
		catch(Exception ex) {
			logger.error("Exception in Deleting Customer Data",ex);
			response.setStatusText(StatusCode.ERROR.name());
			response.setError(ex.getMessage());
		}
		return response;
	}

	
	
}
