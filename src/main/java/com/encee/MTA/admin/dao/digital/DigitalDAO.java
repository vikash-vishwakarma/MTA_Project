package com.encee.MTA.admin.dao.digital;

import java.util.List;

import com.encee.MTA.admin.domain.digital.DigitalDomain;
import com.encee.MTA.response.Response;

public interface DigitalDAO {

	public Response createProject(DigitalDomain digitalDomain)throws Exception;
	
	public Response updateDigital(DigitalDomain digitalDomain)throws Exception;
	
	public List<DigitalDomain>listDigital()throws Exception;
	
	public DigitalDomain get(long digitalId)throws Exception;
	
	public Response deleteDigital(long digitalId)throws Exception;
}
