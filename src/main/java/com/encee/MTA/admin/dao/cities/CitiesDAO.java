package com.encee.MTA.admin.dao.cities;

import java.util.List;

import com.encee.MTA.admin.domain.cities.CitiesDomain;
import com.encee.MTA.response.Response;

public interface CitiesDAO {

	public Response addcities(CitiesDomain citiesDomain)throws Exception;
	
	public Response updateCities(CitiesDomain citiesDomain)throws Exception;
	
	public List<CitiesDomain>listCities()throws Exception;
	
	public CitiesDomain getCities(long id)throws Exception;
	
	public Response deleteCities(long id)throws Exception;
}
