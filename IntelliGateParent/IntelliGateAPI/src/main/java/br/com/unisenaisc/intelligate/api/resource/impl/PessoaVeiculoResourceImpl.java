package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.unisenaisc.intelligate.api.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.converter.PessoaVeiculoConverter;
import br.com.unisenaisc.intelligate.architecture.crud.DetailCRUDResourceImpl;
import br.com.unisenaisc.intelligate.architecture.crud.IDetailCRUDService;
import br.com.unisenaisc.intelligate.business.service.PessoaVeiculoService;
import br.com.unisenaisc.intelligate.common.api.dto.PessoaVeiculoDTO;
import br.com.unisenaisc.intelligate.common.api.resource.PessoaVeiculoResource;
import br.com.unisenaisc.intelligate.model.entity.Pessoa;
import br.com.unisenaisc.intelligate.model.entity.PessoaVeiculo;

@ManagedBean
@Transactional
public class PessoaVeiculoResourceImpl extends DetailCRUDResourceImpl<PessoaVeiculo, Pessoa, PessoaVeiculoDTO> implements PessoaVeiculoResource {

	@Inject
	private PessoaVeiculoService service;
	
	@Override
	public IDetailCRUDService<PessoaVeiculo, Pessoa> getService() {
		return service;
	}

	@Override
	public AbstractDTOConverter<PessoaVeiculo, PessoaVeiculoDTO> getConverter() {
		return new PessoaVeiculoConverter();
	}

}
