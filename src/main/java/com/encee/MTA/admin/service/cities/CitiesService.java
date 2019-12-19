package com.encee.MTA.admin.service.cities;

import java.util.List;

import com.encee.MTA.admin.model.cities.CitiesModel;
import com.encee.MTA.response.Response;

public interface CitiesService {
	
	public Response addCities(CitiesModel citiesModel)throws Exception;
	
	public Response updateCities(CitiesModel citiesModel)throws Exception;
	
	public List<CitiesModel>listCities()throws Exception;
	
	public CitiesModel getCities(long id)throws Exception;
	
	public Response deleteCities(long id)throws Exception;

}
