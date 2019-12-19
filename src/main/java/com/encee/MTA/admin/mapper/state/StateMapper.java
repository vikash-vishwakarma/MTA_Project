package com.encee.MTA.admin.mapper.state;

import org.springframework.stereotype.Component;

import com.encee.MTA.admin.domain.state.StateDomain;
import com.encee.MTA.admin.model.state.StateModel;
import com.encee.MTA.mapper.AbstractMapper;

@Component
public class StateMapper extends AbstractMapper<StateModel,StateDomain> {

	@Override
	public Class<StateModel> entityType() {
		// TODO Auto-generated method stub
		return StateModel.class;
	}

	@Override
	public Class<StateDomain> modelType() {
		// TODO Auto-generated method stub
		return StateDomain.class;
	}

	
	

}
