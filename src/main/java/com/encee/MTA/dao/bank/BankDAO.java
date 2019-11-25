package com.encee.MTA.dao.bank;

import java.util.List;

import com.encee.MTA.domain.bank.BankDomain;
import com.encee.MTA.response.Response;

public interface BankDAO {

	public Response addBank(BankDomain bankDomain)throws Exception;
	
	public Response updateBank(BankDomain bankDomain)throws Exception;
	
	public List<BankDomain>getBanks()throws Exception;
	
	public Response deleteBank(long id)throws Exception;

	BankDomain getBank(long id) throws Exception;
	
}
