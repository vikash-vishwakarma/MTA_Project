package com.encee.MTA.admin.mapper.customer;

import org.springframework.stereotype.Component;

import com.encee.MTA.admin.domain.customer.CustomerDomain;
import com.encee.MTA.admin.model.customer.CustomerModel;
import com.encee.MTA.mapper.AbstractMapper;

@Component
public class CustomerMapper extends AbstractMapper <CustomerModel ,CustomerDomain>{

	@Override
	public Class<CustomerModel> entityType() {
		return CustomerModel.class;
	}

	@Override
	public Class<CustomerDomain> modelType() {
		return CustomerDomain.class;
	}

}
