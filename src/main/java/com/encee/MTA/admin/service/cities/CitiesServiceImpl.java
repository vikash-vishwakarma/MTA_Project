package com.encee.MTA.admin.service.cities;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encee.MTA.admin.dao.cities.CitiesDAO;
import com.encee.MTA.admin.domain.cities.CitiesDomain;
import com.encee.MTA.admin.mapper.cities.CitiesMapper;
import com.encee.MTA.admin.model.cities.CitiesModel;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Service
public class CitiesServiceImpl implements CitiesService {
	
	private static final Logger logger=LoggerFactory.getLogger(CitiesServiceImpl.class);
	
	@Autowired
	CitiesDAO citiesDAO;
	
	@Autowired
	CitiesMapper citiesMapper;

	@Override
	public Response addCities(CitiesModel citiesModel) throws Exception {
		Response response=CommonUtils.getResponseObject("Adding Data Cities");
		try {
			CitiesDomain citiesDomain=new CitiesDomain();
			BeanUtils.copyProperties( citiesModel,citiesDomain);
			response=citiesDAO.addcities(citiesDomain);
		}catch(Exception e) {
			logger.error("Exception in adding Cities Data");
			response.setStatusText(StatusCode.ERROR.getDesc());
			response.setError(e.getMessage());
		}
		return response;
	}

	@Override
	public Response updateCities(CitiesModel citiesModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CitiesModel> listCities() throws Exception {
		try {
			List<CitiesDomain>list=citiesDAO.listCities();
			return citiesMapper.entityList(list);
		}catch(Exception e) {
			logger.info("Exception in getting List of Data " +e.getMessage());
			
		}
		return null;
	}

	@Override
	public CitiesModel getCities(long id) throws Exception {
		try {
			CitiesModel citiesModel=new CitiesModel();
			CitiesDomain citiesDomain=citiesDAO.getCities(id);
			BeanUtils.copyProperties(citiesDomain, citiesModel);
			return citiesModel;
		}catch(Exception e) {
			logger.info("Exception in getting CitiesModel" +e.getMessage());
		}
		return null;
	}

	@Override
	public Response deleteCities(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
