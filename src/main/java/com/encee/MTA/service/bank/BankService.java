package com.encee.MTA.service.bank;

import java.util.List;

import com.encee.MTA.model.bank.BankModel;
import com.encee.MTA.response.Response;

public interface BankService {

	public Response addBank(BankModel bankModel)throws Exception;
	
	public BankModel getBank(long id) throws Exception;
	
	public List<BankModel>getBanks()throws Exception;
	
	public Response deleteBank(long id)throws Exception;
	
	public Response updateBank(BankModel bankModel)throws Exception;
}
