package com.encee.MTA.admin.mapper.bank;

import org.springframework.stereotype.Component;

import com.encee.MTA.admin.domain.bank.BankDomain;
import com.encee.MTA.admin.model.bank.BankModel;
import com.encee.MTA.mapper.AbstractMapper;

@Component
public class BankMapper extends AbstractMapper<BankModel, BankDomain> {

	@Override
	public Class<BankModel> entityType() {
		return BankModel.class;
	}

	@Override
	public Class<BankDomain> modelType() {
		return BankDomain.class;
	}

}
