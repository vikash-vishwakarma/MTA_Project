package com.encee.MTA.admin.service.marketExecutive;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encee.MTA.admin.dao.marketExecutive.MarketExecutiveDAO;
import com.encee.MTA.admin.domain.marketExecutive.MarketExcutiveDomain;
import com.encee.MTA.admin.mapper.marketExecutive.MarketExecutiveMapper;
import com.encee.MTA.admin.model.marketExecutive.MarketExecutiveModel;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Service
public class MarketExcutiveServiceImpl implements MarketExcutiveService {

	@Autowired
	MarketExecutiveDAO marketExecutiveDAO;
	
	@Autowired
	MarketExecutiveMapper marketExecutiveMapper;
	
	private static final Logger logger=LoggerFactory.getLogger(MarketExcutiveServiceImpl.class);

	@Override
	public Response create(MarketExecutiveModel marketExcutiveModel) throws Exception {
		Response response=CommonUtils.getResponseObject("Adding MarketExcutive Data");
		try {
			MarketExcutiveDomain marketExcutiveDomain= new MarketExcutiveDomain();
			BeanUtils.copyProperties(marketExcutiveModel, marketExcutiveDomain);
			response= marketExecutiveDAO.create(marketExcutiveDomain);
		}catch(Exception e) {
			logger.error("Exception Create Data in MarketExcutiveDomain" +e.getMessage());
			response.setStatusText(StatusCode.ERROR.getDesc());
			response.setStatus(StatusCode.ERROR.getCode());
		}
		return response;
	}

	@Override
	public MarketExecutiveModel getData(long excutiveId) throws Exception {
		try {
			MarketExecutiveModel marketExecutiveModel=new MarketExecutiveModel();
			MarketExcutiveDomain marketExecutiveDomain=marketExecutiveDAO.getData(excutiveId);
			BeanUtils.copyProperties(marketExecutiveDomain,marketExecutiveModel);
			return marketExecutiveModel;
		}catch(Exception e) {
			logger.info("Exception getting Single Data in marketExecutiveModel" ,e);
		}
		return null;
	}

	@Override
	public List<MarketExecutiveModel> listDatas() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateDatas(MarketExecutiveModel marketExecutiveModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteData(long excutiveId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
