package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.unisenaisc.intelligate.architecture.restful.AbstractResource;
import br.com.unisenaisc.intelligate.business.service.DashboardService;
import br.com.unisenaisc.intelligate.common.api.bean.DashboardDataBean;
import br.com.unisenaisc.intelligate.common.api.bean.DashboardFilterBean;
import br.com.unisenaisc.intelligate.common.api.resource.DashboardResource;
import br.com.unisenaisc.intelligate.common.exception.BusinessCheckedException;

@ManagedBean
@Transactional
public class DashboardResourceImpl extends AbstractResource implements DashboardResource{

	@Inject
	private DashboardService service;
	
	@Override
	public DashboardDataBean getDataWithFilter(DashboardFilterBean filter) throws BusinessCheckedException {
		return service.getDataWithFilter(filter);
	}

}
