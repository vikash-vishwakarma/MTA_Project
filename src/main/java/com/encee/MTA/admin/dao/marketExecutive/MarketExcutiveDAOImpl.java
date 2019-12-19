package com.encee.MTA.admin.dao.marketExecutive;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.encee.MTA.admin.domain.marketExecutive.MarketExcutiveDomain;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Repository
@Transactional
public class MarketExcutiveDAOImpl implements MarketExecutiveDAO {

	private static final Logger logger=LoggerFactory.getLogger(MarketExcutiveDAOImpl.class);
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public Response create(MarketExcutiveDomain marketExcutiveDomain)throws Exception {
		Response response=CommonUtils.getResponseObject("create Data");
		try {
			entityManager.persist(marketExcutiveDomain);
			response.setStatusText(StatusCode.SUCCESS.name());
			response.setMessage("Successfully Added Data: ");
		}catch(Exception e) {
			logger.error("Exception in create Data " +e.getMessage());
			response.setStatus(StatusCode.ERROR.getCode());
			response.setStatusText(StatusCode.ERROR.getDesc());
		}
		return response;
		
	}

	@Override
	public Response updateData(MarketExcutiveDomain marketExcutiveDomain) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarketExcutiveDomain> listDatas() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MarketExcutiveDomain getData(long excutiveId) throws Exception {
		try {
			String hql="From MarketExcutiveDomain where excutiveId=?1 and status=true";
			return (MarketExcutiveDomain) entityManager.createQuery(hql).setParameter(1, excutiveId).getSingleResult();
			
		}catch(EmptyResultDataAccessException e) {
			return null;
		}catch(Exception e) {
			logger.error("Exception in getting Data MarketExcutiveDomain" +e.getMessage());
		}
		return null;
	}

	@Override
	public Response deleteData(long excutiveId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
