package com.encee.MTA.mapper.bank;

import org.springframework.stereotype.Component;

import com.encee.MTA.domain.bank.BankDomain;
import com.encee.MTA.mapper.AbstractMapper;
import com.encee.MTA.model.bank.BankModel;

@Component
public class BankMapper extends AbstractMapper<BankModel, BankDomain> {

	@Override
	public Class<BankModel> entityType() {
		// TODO Auto-generated method stub
		return BankModel.class;
	}

	@Override
	public Class<BankDomain> modelType() {
		// TODO Auto-generated method stub
		return BankDomain.class;
	}

}
