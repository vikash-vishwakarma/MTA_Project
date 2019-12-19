package com.encee.MTA.admin.service.state;

import java.util.List;

import com.encee.MTA.admin.model.state.StateModel;
import com.encee.MTA.response.Response;

public interface StateService {

	public Response addState(StateModel stateModel) throws Exception;

	public List<StateModel> listState() throws Exception;

	public StateModel getState(long id) throws Exception;

	public Response deleteState(long id) throws Exception;

	public Response updateState(StateModel stateModel) throws Exception;
}
