package com.encee.MTA.admin.dao.digital;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.encee.MTA.admin.domain.digital.DigitalDomain;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Repository
@Transactional
public class DigitalDAOImpl implements DigitalDAO {
	
	private static final Logger logger=LoggerFactory.getLogger(DigitalDAOImpl.class);
	
	@Autowired
	EntityManager entityManager;

	@Override
	public Response createProject(DigitalDomain digitalDomain) throws Exception {
		Response response =CommonUtils.getResponseObject("Adding Digital Media ");
		try {
					entityManager.persist(digitalDomain);
					response.setStatusText(StatusCode.SUCCESS.getDesc());
					response.setMessage("Successfully Added Digital Media");
		}catch(Exception e) {
			logger.info("Exception in adding DigitalDomain data " , e);
			response.setStatusText(StatusCode.ERROR.getDesc());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public Response updateDigital(DigitalDomain digitalDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("updating Digital Media ");
		try {
			DigitalDomain updateDigital=get(digitalDomain.getDigitalId());
			updateDigital.setCreatedDate(digitalDomain.getCreatedDate());
			updateDigital.setModificationDate(digitalDomain.getModificationDate());
			updateDigital.setDigitalType(digitalDomain.getDigitalType());
			updateDigital.setTypeId(digitalDomain.getTypeId());
			entityManager.flush();
			response.setStatusText(StatusCode.SUCCESS.name());
		}catch(Exception e) {
			logger.info("Exception in updating DigitalDomain" ,e);
			response.setStatusText(StatusCode.ERROR.name());
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DigitalDomain> listDigital() throws Exception {
		try {
			String hql="From DigitalDomain where status=true";
			return (List<DigitalDomain>)entityManager.createQuery(hql).getResultList();
		}catch(Exception e) {
			logger.info("Exception in Getting All Digital Media Data "+e.getMessage());
		}
		return null;
	}

	@Override
	public DigitalDomain get(long digitalId) throws Exception {
		try {
			String hql= "From DigitalDomain where digitalId=?1 and status=true";
			return (DigitalDomain)entityManager.createQuery(hql).setParameter(1,digitalId).getSingleResult();
			
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		catch(Exception e) {
			logger.info("Exception in Getting DigitalDomain Data " ,e);
		}
		return null;
	}

	@Override
	public Response deleteDigital(long digitalId) throws Exception {
		Response response=CommonUtils.getResponseObject("Deleting Digital Media ");
		try {
			DigitalDomain digitalDomain=get(digitalId);
			digitalDomain.setStatus(false);
			entityManager.flush();
			response.setStatusText(StatusCode.SUCCESS.getDesc());
		}catch(Exception e) {
			logger.info("Exception in Deleting Digital Media",e);
			response.setStatusText(StatusCode.ERROR.name());
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	

}
