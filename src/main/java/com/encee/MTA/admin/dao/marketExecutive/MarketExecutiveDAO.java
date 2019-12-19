package com.encee.MTA.admin.dao.marketExecutive;

import java.util.List;

import com.encee.MTA.admin.domain.marketExecutive.MarketExcutiveDomain;
import com.encee.MTA.response.Response;

public interface MarketExecutiveDAO {
	
	public Response updateData(MarketExcutiveDomain marketExcutiveDomain)throws Exception;
	
	public List<MarketExcutiveDomain>listDatas()throws Exception;
	
	public MarketExcutiveDomain getData(long excutiveId)throws Exception;
	
	public Response deleteData(long excutiveId)throws Exception;

	public Response create(MarketExcutiveDomain marketExcutiveDomain) throws Exception;
}
