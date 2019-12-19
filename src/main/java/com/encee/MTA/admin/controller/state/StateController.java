package com.encee.MTA.admin.controller.state;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.encee.MTA.admin.model.state.StateModel;
import com.encee.MTA.admin.service.state.StateService;
import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.response.ErrorObject;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@RestController
@RequestMapping(value = "/v4")
public class StateController {

	private static final Logger logger = LoggerFactory.getLogger(StateController.class);

	@Autowired
	StateService stateService;

//	Add Bank Data Code start Here.

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "Application/json")
	public Response addState(@RequestBody StateModel stateModel, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("Add State :Recevied request URL :" + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addState:Recevied request" + CommonUtils.getJson(stateModel));
		return stateService.addState(stateModel);
	}

//	Getting Single Data Code Start Here.

	@RequestMapping(value = "/state/{id}", method = RequestMethod.GET, produces = "Application/json")
	public @ResponseBody String getState(@PathVariable("id") long id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("getState: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		StateModel stateModel = stateService.getState(id);
		Response response2 = CommonUtils.getResponseObject("State Data");
		if (stateModel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("Role id Data Not Found :", "Role Id Data Not Found");
			response2.setError(err);
			response2.setStatusText(StatusCode.ERROR.name());
		} else {
			response2.setData(stateModel);
		}
		logger.info("Get State : " + CommonUtils.getJson(stateModel));
		return CommonUtils.getJson(response2);
	}

//	List of State Code Data Start Here.
	@RequestMapping(value = "/statelist", method = RequestMethod.GET, produces = "Application/json")
	public @ResponseBody String listState(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("State Data :Recevied request URL :" + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<StateModel> list = stateService.listState();

		Response res = CommonUtils.getResponseObject("State Data");
		if (list == null) {
			ErrorObject err = CommonUtils.getErrorResponse("List of State Data Not Found",
					"List of State Data Not Found");
			res.setError(err);
			res.setStatusText(StatusCode.ERROR.name());
		} else {
			res.setData(list);
		}
		logger.info("Get State Data : Send Data ");
		return CommonUtils.getJson(res);

	}

//     Update State Code Start Here.
	@RequestMapping(value = "/updateState", method = RequestMethod.PUT, produces = "Application/json")
	public Response updateState(@RequestBody StateModel stateModel, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("Getting State Data :Recevied request URL : " + request.getRequestURL()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("Update State Data : Recevied Request " + CommonUtils.getJson(stateModel));
		return stateService.updateState(stateModel);
	}

//     Delete State Code Start Here.

	@RequestMapping(value = "/deleteState/{id}", method = RequestMethod.DELETE, produces = "Application/json")
	public Response deleteState(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Delete State Data :Recevied request :" + request.getRequestURL()
				+ ((request.getQueryString() == null) ? " " : "?" + request.getQueryString().toString()));
		logger.info("Delete State Data :Recevied request " + CommonUtils.getJson(id));
		return stateService.deleteState(id);
	}
}
