package com.encee.MTA.mapper.customer;

import org.springframework.stereotype.Component;

import com.encee.MTA.domain.customer.CustomerDomain;
import com.encee.MTA.mapper.AbstractMapper;
import com.encee.MTA.model.customer.CustomerModel;

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
