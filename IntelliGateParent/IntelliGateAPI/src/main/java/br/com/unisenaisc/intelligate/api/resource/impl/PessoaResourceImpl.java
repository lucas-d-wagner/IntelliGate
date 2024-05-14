package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.unisenaisc.intelligate.api.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.converter.PessoaConverter;
import br.com.unisenaisc.intelligate.architecture.crud.CRUDResourceImpl;
import br.com.unisenaisc.intelligate.architecture.crud.ICRUDService;
import br.com.unisenaisc.intelligate.business.service.PessoaService;
import br.com.unisenaisc.intelligate.common.api.dto.PessoaDTO;
import br.com.unisenaisc.intelligate.common.api.resource.PessoaResource;
import br.com.unisenaisc.intelligate.model.entity.Pessoa;

@ManagedBean
@Transactional
public class PessoaResourceImpl extends CRUDResourceImpl<Pessoa, PessoaDTO> implements PessoaResource {

	@Inject
	private PessoaService service;
	
	@Override
	public ICRUDService<Pessoa> getService() {
		return service;
	}

	@Override
	public AbstractDTOConverter<Pessoa, PessoaDTO> getConverter() {
		return new PessoaConverter();
	}

}
