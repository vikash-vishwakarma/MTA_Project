package com.encee.MTA.admin.dao.state;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.encee.MTA.admin.domain.state.StateDomain;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Repository
@Transactional
public class StateDAOImpl implements StateDAO {

	private static final Logger logger=LoggerFactory.getLogger(StateDAOImpl.class);
	
	@Autowired
	EntityManager entityManager;

	@Override
	public Response addState(StateDomain stateDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("Adding City Data");
		try {
			entityManager.persist(stateDomain);
			response.setStatusText(StatusCode.SUCCESS.name());
			response.setStatus(StatusCode.SUCCESS.getCode());
			response.setData(stateDomain);
			response.setMessage("Successfully Added Data");
		}catch(Exception e) {
			logger.error("Exception Adding State Data in StateDAOImpl" +e.getMessage());
			response.setStatus(StatusCode.ERROR.getCode());
			response.setStatusText(StatusCode.ERROR.getDesc());
		}
		return response;
	}

	
	@SuppressWarnings("unchecked")
	public List<StateDomain> listState() throws Exception {
		try {
		String hql="From StateDomain where status=1";
			return (List<StateDomain>)entityManager.createQuery(hql).getResultList();
		}catch(Exception e) {
			logger.error("Exception list State in StateDomain" ,e);
		}
		return null;
	}

	@Override
	public StateDomain getState(long id) throws Exception {
		try {
			String hql="From StateDomain where id=?1 ";
			return(StateDomain) entityManager.createQuery(hql).setParameter(1, id).getSingleResult();
		}catch(EmptyResultDataAccessException e) {
			return null;
		}catch(Exception e) {
			logger.error("Exception in Getting Data StateDomain" +e.getMessage());
			return null;
		}
		
	}

	@Override
	public Response updateState(StateDomain stateDoamin) throws Exception {
		Response response=CommonUtils.getResponseObject("Updating State Data");
		try {
			StateDomain state=getState(stateDoamin.getId());
			state.setName(stateDoamin.getName());
			state.setCountryId(stateDoamin.getCountryId());
			entityManager.flush();
			response.setStatusText(StatusCode.SUCCESS.name());
			response.setStatus(StatusCode.SUCCESS.getCode());
		}catch(Exception e) {
			logger.error("Exception in Getting StateDomain " ,e);
			response.setStatusText(StatusCode.ERROR.name());
			return null;
		}
		return response;
	}

	@Override
	public Response deleteState(long id) throws Exception {
		Response response=CommonUtils.getResponseObject("Delete State Data");
		try {
			StateDomain stateDomain=getState(id);
			stateDomain.setStatus(false);
			entityManager.flush();
			response.setStatusText(StatusCode.SUCCESS.name());
		}catch(Exception e) {
			logger.error("Exception in Delete State Data " +e.getMessage());
			response.setStatusText(StatusCode.ERROR.name());
		}
		return response;
	}
}
