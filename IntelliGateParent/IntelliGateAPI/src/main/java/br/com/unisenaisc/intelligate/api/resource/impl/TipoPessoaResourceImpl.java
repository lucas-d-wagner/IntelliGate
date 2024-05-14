package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.unisenaisc.intelligate.api.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.converter.TipoPessoaConverter;
import br.com.unisenaisc.intelligate.architecture.selector.ISelectorService;
import br.com.unisenaisc.intelligate.architecture.selector.SelectorResourceImpl;
import br.com.unisenaisc.intelligate.business.service.TipoPessoaService;
import br.com.unisenaisc.intelligate.common.api.dto.TipoPessoaDTO;
import br.com.unisenaisc.intelligate.common.api.resource.TipoPessoaResource;
import br.com.unisenaisc.intelligate.model.entity.TipoPessoa;

@ManagedBean
@Transactional
public class TipoPessoaResourceImpl extends SelectorResourceImpl<TipoPessoa, TipoPessoaDTO> implements TipoPessoaResource {
	
	@Inject 
	private TipoPessoaService service;

	@Override
	public ISelectorService<TipoPessoa> getService() {
		return service;
	}

	@Override
	public AbstractDTOConverter<TipoPessoa, TipoPessoaDTO> getConverter() {
		return new TipoPessoaConverter();
	}

}
