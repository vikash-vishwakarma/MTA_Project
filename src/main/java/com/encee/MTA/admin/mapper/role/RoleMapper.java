package com.encee.MTA.admin.mapper.role;

import org.springframework.stereotype.Component;

import com.encee.MTA.admin.domain.role.RoleDomain;
import com.encee.MTA.admin.model.role.RoleModel;
import com.encee.MTA.mapper.AbstractMapper;

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
