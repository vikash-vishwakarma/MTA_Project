package com.encee.MTA.admin.dao.cities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encee.MTA.admin.domain.cities.CitiesDomain;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Transactional
@Repository
public class CitiesDAOImpl implements CitiesDAO {

	private static final Logger logger=LoggerFactory.getLogger(CitiesDAOImpl.class);
	
	@Autowired 
	EntityManager entityManager;

	@Override
	public Response addcities(CitiesDomain citiesDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("Adding Cities Data");
		try {
			entityManager.persist(citiesDomain);
			response.setStatusText(StatusCode.SUCCESS.getDesc());
			response.setMessage("Successfully Created Cities Data");
            response.setData(citiesDomain);			
		}catch(Exception e) {
			logger.info("Exception in Adding CitiesDomain");
			response.setStatusText(StatusCode.ERROR.getDesc());
			response.setError(e.getMessage());
		}
		return response;
	}

	@Override
	public Response updateCities(CitiesDomain citiesDomain) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CitiesDomain> listCities() throws Exception {
		try {
			String hql="From CitiesDomain where status=1";
			return (List<CitiesDomain>)entityManager.createQuery(hql).getResultList();
		}catch(Exception e) {
			logger.info("Exception getting data in CitiesDomain" +e.getMessage());
			return null;
		}
	}

	@Override
	public CitiesDomain getCities(long id) throws Exception {
		try {
			String hql="From CitiesDomain where id=?1";
			return (CitiesDomain)entityManager.createQuery(hql).setParameter(1, id).getSingleResult();
		}catch(Exception e) {
		logger.info("Exception in getting CitiesDomain" +e.getMessage());
		}
		return null;
	}

	@Override
	public Response deleteCities(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
