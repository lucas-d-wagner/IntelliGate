package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.unisenaisc.intelligate.architecture.restful.AbstractResource;
import br.com.unisenaisc.intelligate.business.service.EstacionamentoService;
import br.com.unisenaisc.intelligate.common.api.dto.PayloadResponseDTO;
import br.com.unisenaisc.intelligate.common.api.resource.EstacionamentoResource;
import br.com.unisenaisc.intelligate.common.exception.BusinessCheckedException;

@ManagedBean
@Transactional
public class EstacionamentoResourceImpl extends AbstractResource implements EstacionamentoResource {

	@Inject
	private EstacionamentoService estacionamentoService;
	
	@Override
	public PayloadResponseDTO<Boolean> validarEntrada(String token) throws BusinessCheckedException {
		Boolean isValido = estacionamentoService.validarEntrada(token, getLoginContext());
		return new PayloadResponseDTO<Boolean>(isValido);
	}

}
