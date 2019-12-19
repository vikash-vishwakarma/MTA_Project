package com.encee.MTA.admin.mapper.project;

import org.springframework.stereotype.Component;

import com.encee.MTA.admin.domain.project.ProjectDomain;
import com.encee.MTA.admin.model.project.ProjectModel;
import com.encee.MTA.mapper.AbstractMapper;

@Component
public class ProjectMapper extends AbstractMapper<ProjectModel,ProjectDomain> {

	@Override
	public Class<ProjectModel> entityType() {
		
		return ProjectModel.class;
	}

	@Override
	public Class<ProjectDomain> modelType() {
		
		return ProjectDomain.class;
	}

}
