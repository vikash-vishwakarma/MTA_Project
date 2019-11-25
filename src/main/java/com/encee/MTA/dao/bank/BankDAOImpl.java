package com.encee.MTA.dao.bank;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.domain.bank.BankDomain;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Repository
@Transactional
public class BankDAOImpl implements BankDAO {

	
	private static final Logger logger= LoggerFactory.getLogger(BankDAOImpl.class);
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Response addBank(BankDomain bankDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("Adding Bank ");
		try {
			entityManager.persist(bankDomain);
			response.setStatusText(StatusCode.SUCCESS.name());
			response.setMessage("Successfully Added Bank ");
			response.setData(bankDomain);
		}catch(Exception e) {
			response.setError(StatusCode.ERROR.name());
			response.setError(e.getMessage());
		}
		return response;
	}

	@Override
	public Response updateBank(BankDomain bankDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("updating Bank Data");
		try {
			BankDomain updateData=getBank(bankDomain.getId());
			updateData.setBankName(bankDomain.getBankName());
			entityManager.flush();
			response.setStatusText(StatusCode.SUCCESS.name());
		}catch(Exception e) {
			logger.info("Exception in Updating Bank Data" +e.getMessage());
			response.setStatusText(StatusCode.ERROR.name());
		}
		return response;
	}

	@Override
	public BankDomain getBank(long id) throws Exception {
		try {
			String hql="From BankDomain where id=?1 and isActive=true";
			return (BankDomain)entityManager.createQuery(hql).setParameter(1,id).getSingleResult();	
		}
		catch(EmptyResultDataAccessException ex) {
			return null;
		}
		catch(Exception e) {
			logger.info("Exception in getting Data of Bank"+e.getMessage());
		}
		return null;
		
	}

	@Override
	public List<BankDomain> getBanks() throws Exception {
		try {
			String hql="From BankDomain where isActive=true";
			return (List<BankDomain>)entityManager.createQuery(hql).getResultList();
		}catch(Exception e) {
			logger.info("Exception in List Data " +e.getMessage());
		}
		return null;
	}

	@Override
	public Response deleteBank(long id) throws Exception {
		Response response=CommonUtils.getResponseObject("Deleted Bank data");
		try {
			BankDomain bankDomain=getBank(id);
			bankDomain.setActive(false);
			entityManager.flush();
			response.setStatusText(StatusCode.SUCCESS.name());
		}catch(Exception ex) {
			logger.error("Exception in Deleting Bank Data",ex);
			response.setStatusText(StatusCode.ERROR.name());
			response.setError(ex.getMessage());
		}
		return response;
	}
}
