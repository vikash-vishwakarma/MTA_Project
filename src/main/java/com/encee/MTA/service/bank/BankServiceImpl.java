package com.encee.MTA.service.bank;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.dao.bank.BankDAO;
import com.encee.MTA.domain.bank.BankDomain;
import com.encee.MTA.mapper.bank.BankMapper;
import com.encee.MTA.model.bank.BankModel;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Service
public class BankServiceImpl implements BankService {

	private static final Logger logger= LoggerFactory.getLogger(BankServiceImpl.class);
	
	@Autowired
	BankDAO bankDAO;
	
	@Autowired
	BankMapper bankMapper;

	@Override
	public Response addBank(BankModel bankModel) throws Exception {
		Response response=CommonUtils.getResponseObject("Customer Creation ");
		try {
			BankDomain bankDomain=new BankDomain();
			BeanUtils.copyProperties(bankModel, bankDomain);
			 response=bankDAO.addBank(bankDomain);
			return response;
		}catch(Exception e){
			logger.info("Exception in Adding Bank Data"+e.getMessage());
			 response=new Response();
			response.setStatusText(StatusCode.ERROR.name());
			response.setMessage(e.getMessage());
		}
		return null;
	}

	@Override
	public BankModel getBank(long id) throws Exception {
		try {
			BankModel bankModel=new BankModel();
			BankDomain bankDomain=bankDAO.getBank(id);
			BeanUtils.copyProperties(bankDomain, bankModel);
			return bankModel;
		}catch(Exception e) {
			logger.info("Exception in getting Bank Data",e);
		}
		return null;
	}

	@Override
	public List<BankModel> getBanks() throws Exception {
		try {
			List<BankDomain> list=bankDAO.getBanks();
			return bankMapper.entityList(list);
		}catch(Exception e) {
			logger.info("Exception in Getting list Bank Data " +e.getMessage());
		}
		return null;
	}

	@Override
	public Response deleteBank(long id) throws Exception {
		try {
			bankDAO.deleteBank(id);
			return CommonUtils.getResponseObject("Successfully Deleted id : " +id);
		}catch(Exception e) {
			logger.info("Exception in Deleting Bank Data" +e.getMessage());
			return null;
		}
		
	}

	@Override
	public Response updateBank(BankModel bankModel) throws Exception {
		BankDomain bankDomain=new BankDomain();
		BeanUtils.copyProperties(bankModel,bankDomain);
		Response response= bankDAO.updateBank(bankDomain);
		return response;
		
	}
	
	
}
