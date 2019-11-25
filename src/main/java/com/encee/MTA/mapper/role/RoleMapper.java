package com.encee.MTA.mapper.role;

import org.springframework.stereotype.Component;

import com.encee.MTA.domain.role.RoleDomain;
import com.encee.MTA.mapper.AbstractMapper;
import com.encee.MTA.model.role.RoleModel;

@Component
public class RoleMapper extends AbstractMapper<RoleModel, RoleDomain> {

	@Override
	public Class<RoleModel> entityType() {
		// TODO Auto-generated method stub
		return RoleModel.class;
	}

	@Override
	public Class<RoleDomain> modelType() {
		// TODO Auto-generated method stub
		return RoleDomain.class;
	}

}
