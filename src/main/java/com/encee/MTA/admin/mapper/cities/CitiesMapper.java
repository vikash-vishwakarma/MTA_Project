package com.encee.MTA.admin.mapper.cities;

import org.springframework.stereotype.Component;

import com.encee.MTA.admin.domain.cities.CitiesDomain;
import com.encee.MTA.admin.model.cities.CitiesModel;
import com.encee.MTA.mapper.AbstractMapper;

@Component
public class CitiesMapper extends AbstractMapper< CitiesModel,CitiesDomain>{

	@Override
	public Class<CitiesModel> entityType() {
		return CitiesModel.class;
	}

	@Override
	public Class<CitiesDomain> modelType() {
		return CitiesDomain.class;
	}

}
