package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.unisenaisc.intelligate.api.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.converter.LeitorConverter;
import br.com.unisenaisc.intelligate.architecture.crud.CRUDResourceImpl;
import br.com.unisenaisc.intelligate.architecture.crud.ICRUDService;
import br.com.unisenaisc.intelligate.business.service.LeitorService;
import br.com.unisenaisc.intelligate.common.api.dto.LeitorDTO;
import br.com.unisenaisc.intelligate.common.api.resource.LeitorResource;
import br.com.unisenaisc.intelligate.model.entity.Leitor;

@ManagedBean
@Transactional
public class LeitorResourceImpl extends CRUDResourceImpl<Leitor, LeitorDTO> implements LeitorResource {

	@Inject
	private LeitorService service;
	
	@Override
	public ICRUDService<Leitor> getService() {
		return service;
	}

	@Override
	public AbstractDTOConverter<Leitor, LeitorDTO> getConverter() {
		return new LeitorConverter();
	}

}
