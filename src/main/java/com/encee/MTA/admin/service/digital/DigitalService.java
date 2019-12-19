package com.encee.MTA.admin.service.digital;

import java.util.List;

import com.encee.MTA.admin.model.digital.DigitalModel;
import com.encee.MTA.response.Response;

public interface DigitalService {

	public Response createDigital(DigitalModel digitalModel)throws Exception;
	
	public Response updateDigital(DigitalModel digitalModel)throws Exception;
	
	public List<DigitalModel>listDigital()throws Exception;
	
	public DigitalModel getDigital(long digitalId)throws Exception;
	
	public Response deleteDigital(long digitalId)throws Exception;
	
	
}
