package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.unisenaisc.intelligate.api.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.converter.VeiculoIdentificacaoConverter;
import br.com.unisenaisc.intelligate.architecture.crud.DetailCRUDResourceImpl;
import br.com.unisenaisc.intelligate.architecture.crud.IDetailCRUDService;
import br.com.unisenaisc.intelligate.business.service.VeiculoIdentificacaoService;
import br.com.unisenaisc.intelligate.common.api.dto.VeiculoIdentificacaoDTO;
import br.com.unisenaisc.intelligate.common.api.resource.VeiculoIdentificacaoResource;
import br.com.unisenaisc.intelligate.model.entity.Veiculo;
import br.com.unisenaisc.intelligate.model.entity.VeiculoIdentificacao;

@ManagedBean
@Transactional
public class VeiculoIdentificacaoResourceImpl extends DetailCRUDResourceImpl<VeiculoIdentificacao, Veiculo, VeiculoIdentificacaoDTO> implements VeiculoIdentificacaoResource {

	@Inject
	private VeiculoIdentificacaoService service;
	
	@Override
	public IDetailCRUDService<VeiculoIdentificacao, Veiculo> getService() {
		return service;
	}

	@Override
	public AbstractDTOConverter<VeiculoIdentificacao, VeiculoIdentificacaoDTO> getConverter() {
		return new VeiculoIdentificacaoConverter();
	}

}
