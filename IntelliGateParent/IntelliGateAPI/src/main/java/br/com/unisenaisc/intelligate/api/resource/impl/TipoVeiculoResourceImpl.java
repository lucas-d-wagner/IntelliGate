package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.unisenaisc.intelligate.api.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.converter.TipoVeiculoConverter;
import br.com.unisenaisc.intelligate.architecture.selector.ISelectorService;
import br.com.unisenaisc.intelligate.architecture.selector.SelectorResourceImpl;
import br.com.unisenaisc.intelligate.business.service.TipoVeiculoService;
import br.com.unisenaisc.intelligate.common.api.dto.TipoVeiculoDTO;
import br.com.unisenaisc.intelligate.common.api.resource.TipoVeiculoResource;
import br.com.unisenaisc.intelligate.model.entity.TipoVeiculo;

@ManagedBean
@Transactional
public class TipoVeiculoResourceImpl extends SelectorResourceImpl<TipoVeiculo, TipoVeiculoDTO> implements TipoVeiculoResource {

	@Inject
	private TipoVeiculoService service;
	
	@Override
	public ISelectorService<TipoVeiculo> getService() {
		return service;
	}

	@Override
	public AbstractDTOConverter<TipoVeiculo, TipoVeiculoDTO> getConverter() {
		return new TipoVeiculoConverter();
	}

}
