package com.encee.MTA.admin.mapper.marketExecutive;

import org.springframework.stereotype.Component;

import com.encee.MTA.admin.domain.marketExecutive.MarketExcutiveDomain;
import com.encee.MTA.admin.model.marketExecutive.MarketExecutiveModel;
import com.encee.MTA.mapper.AbstractMapper;

@Component
public class MarketExecutiveMapper extends AbstractMapper<MarketExecutiveModel, MarketExcutiveDomain> {

	@Override
	public Class<MarketExecutiveModel> entityType() {
		
		return MarketExecutiveModel.class;
	}

	@Override
	public Class<MarketExcutiveDomain> modelType() {
		
		return MarketExcutiveDomain.class;
	}

}
