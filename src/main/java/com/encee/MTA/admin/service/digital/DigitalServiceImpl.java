package com.encee.MTA.admin.service.digital;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encee.MTA.admin.dao.digital.DigitalDAO;
import com.encee.MTA.admin.domain.digital.DigitalDomain;
import com.encee.MTA.admin.mapper.digital.DigitalMapper;
import com.encee.MTA.admin.model.digital.DigitalModel;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Service
public class DigitalServiceImpl implements DigitalService {

	
	private static final Logger logger =LoggerFactory.getLogger(DigitalServiceImpl.class);
	
	@Autowired
	DigitalDAO digitalDAO;
	
	@Autowired
	DigitalMapper digitalMapper;

	@Override
	public Response createDigital(DigitalModel digitalModel) throws Exception {
		Response response=CommonUtils.getResponseObject("Adding Digital Media");
		try {
			DigitalDomain digitalDomain=new DigitalDomain();
			BeanUtils.copyProperties(digitalModel, digitalDomain);
			response = digitalDAO.createProject(digitalDomain);
		}catch(Exception e) {
			logger.info("Exception in Adding Media DigitalModel" ,e);
			response.setStatusText(StatusCode.ERROR.getDesc());
		}
		return response;
	}

	@Override
	public Response updateDigital(DigitalModel digitalModel) throws Exception {
			DigitalDomain digitalDomain=new DigitalDomain();
			BeanUtils.copyProperties(digitalModel, digitalDomain);
			Response response=digitalDAO.updateDigital(digitalDomain);
		return response;
	}

	@Override
	public List<DigitalModel> listDigital() throws Exception {
		try {
			List<DigitalDomain>list=digitalDAO.listDigital();
			return digitalMapper.entityList(list);
		}catch(Exception e) {
			logger.info("Excepiton in Getting List of Digital Media Data "+e.getMessage());
		}
		return null;
	}

	@Override
	public DigitalModel getDigital(long digitalId) throws Exception {
		try {
			DigitalModel digitalModel= new DigitalModel();
			DigitalDomain digitalDomain=digitalDAO.get(digitalId);
			BeanUtils.copyProperties(digitalDomain, digitalModel);
			return digitalModel;
			
		}catch(Exception e) {
			logger.info("Exception in Getting DigitalModel ",e);
		}
		return null;
	}

	@Override
	public Response deleteDigital(long digitalId) throws Exception {
		try {
			digitalDAO.deleteDigital(digitalId);
			return CommonUtils.getResponseObject("Successfully deleted Digital Data :" +digitalId);
		}catch(Exception e) {
			logger.info("Exception in Getting Digital Media Data " +e.getMessage());
		}
		return null;
	}
	
	
}
