package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.unisenaisc.intelligate.api.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.converter.VeiculoConverter;
import br.com.unisenaisc.intelligate.architecture.crud.CRUDResourceImpl;
import br.com.unisenaisc.intelligate.architecture.crud.ICRUDService;
import br.com.unisenaisc.intelligate.business.service.VeiculoService;
import br.com.unisenaisc.intelligate.common.api.dto.VeiculoDTO;
import br.com.unisenaisc.intelligate.common.api.resource.VeiculoResource;
import br.com.unisenaisc.intelligate.model.entity.Veiculo;

@ManagedBean
@Transactional
public class VeiculoResourceImpl extends CRUDResourceImpl<Veiculo, VeiculoDTO> implements VeiculoResource {

	@Inject
	private VeiculoService service;
	
	@Override
	public ICRUDService<Veiculo> getService() {
		return service;
	}

	@Override
	public AbstractDTOConverter<Veiculo, VeiculoDTO> getConverter() {
		return new VeiculoConverter();
	}

}
