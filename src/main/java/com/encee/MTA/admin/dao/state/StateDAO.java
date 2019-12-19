package com.encee.MTA.admin.dao.state;

import java.util.List;

import com.encee.MTA.admin.domain.state.StateDomain;
import com.encee.MTA.response.Response;

public interface StateDAO {

	public Response addState(StateDomain stateDomain) throws Exception;

	public List<StateDomain> listState() throws Exception;

	public StateDomain getState(long id) throws Exception;

	public Response updateState(StateDomain stateDoamin) throws Exception;

	public Response deleteState(long id) throws Exception;
}
