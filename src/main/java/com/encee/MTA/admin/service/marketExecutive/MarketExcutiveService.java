package com.encee.MTA.admin.service.marketExecutive;

import java.util.List;

import com.encee.MTA.admin.model.marketExecutive.MarketExecutiveModel;
import com.encee.MTA.response.Response;

public interface MarketExcutiveService {

	
	public Response create(MarketExecutiveModel marketExcutiveModel)throws Exception;
	
	public MarketExecutiveModel getData(long excutiveId)throws Exception;
	
	public List<MarketExecutiveModel>listDatas()throws Exception;
	
	public Response updateDatas(MarketExecutiveModel marketExecutiveModel)throws Exception;
	
	public Response deleteData(long excutiveId)throws Exception;
	
	
}
