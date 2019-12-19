package com.encee.MTA.admin.service.state;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encee.MTA.admin.dao.state.StateDAO;
import com.encee.MTA.admin.domain.state.StateDomain;
import com.encee.MTA.admin.mapper.state.StateMapper;
import com.encee.MTA.admin.model.state.StateModel;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Service
public class StateServiceImpl implements StateService {

	private static final Logger logger=LoggerFactory.getLogger(StateServiceImpl.class);

	@Autowired
	StateDAO stateDAO;
	
	@Autowired
	StateMapper stateMapper;
	
	@Override
	public Response addState(StateModel stateModel) throws Exception {
		Response response=CommonUtils.getResponseObject("State Creation");
		try {
			StateDomain stateDomain= new StateDomain();
			BeanUtils.copyProperties(stateModel, stateDomain);
			response=stateDAO.addState(stateDomain);
		}catch(Exception e) {
			logger.error("Exception creation Adding in StateServiceImpl" +e.getMessage());
			response.setStatusText(StatusCode.ERROR.getDesc());
			response.setStatus(StatusCode.ERROR.getCode());
		} 
		return response;
	}

	@Override
	public List<StateModel> listState() throws Exception {
		try {
			List<StateDomain> listState =stateDAO.listState();
			return stateMapper.entityList(listState);
		}catch(Exception e) {
			logger.error("Exception list of data in StateDomain " +e.getMessage());
		}
		return null;	
	}
	@Override
	public StateModel getState(long id) throws Exception {
		try {
			StateModel stateModel=new StateModel();
			StateDomain stateDomain=stateDAO.getState(id);
		   BeanUtils.copyProperties(stateDomain,stateModel);
		   return stateModel;
		}catch(Exception e) {
			logger.error("Exception get State Data StateDomain " ,e);
			return null;
		}
	}

	@Override
	public Response deleteState(long id) throws Exception {
		try {
			return stateDAO.deleteState(id);
		}
		catch(Exception e) {
			logger.error("Exception deleting State Data " +e.getMessage());
		}
		return null;
	}

	@Override
	public Response updateState(StateModel stateModel) throws Exception {
		try {
			StateDomain stateDomain=new StateDomain();
			BeanUtils.copyProperties(stateModel, stateDomain);
			Response response=stateDAO.updateState(stateDomain);
			return response;
		}catch(Exception e) {
			logger.error("Exception in Updating State Data " +e.getMessage());
			
		}
		return null;
	}
}
