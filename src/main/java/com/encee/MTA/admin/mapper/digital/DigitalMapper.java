package com.encee.MTA.admin.mapper.digital;

import org.springframework.stereotype.Component;

import com.encee.MTA.admin.domain.digital.DigitalDomain;
import com.encee.MTA.admin.model.digital.DigitalModel;
import com.encee.MTA.mapper.AbstractMapper;

@Component
public class DigitalMapper extends AbstractMapper< DigitalModel,DigitalDomain>{

	@Override
	public Class<DigitalModel> entityType() {
		
		return DigitalModel.class;
	}

	@Override
	public Class<DigitalDomain> modelType() {
		
		return DigitalDomain.class;
	}

}
