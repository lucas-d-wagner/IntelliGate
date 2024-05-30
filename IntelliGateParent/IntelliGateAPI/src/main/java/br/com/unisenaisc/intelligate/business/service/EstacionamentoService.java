package br.com.unisenaisc.intelligate.business.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.unisenaisc.intelligate.business.repository.VeiculoIdentificacaoRepository;
import br.com.unisenaisc.intelligate.common.context.LoginContext;
import br.com.unisenaisc.intelligate.common.exception.BusinessCheckedException;
import br.com.unisenaisc.intelligate.model.entity.VeiculoIdentificacao;

@ManagedBean
public class EstacionamentoService {

	@Inject
	private VeiculoIdentificacaoRepository veiculoIdentificacaoRepository;
	
	public Boolean validarEntrada(String token, LoginContext context) throws BusinessCheckedException {
		VeiculoIdentificacao veiculoIdentificacao = veiculoIdentificacaoRepository.findByUUID(token);
		
		if(veiculoIdentificacao != null) {
			gravarHistoricoAcesso(veiculoIdentificacao, context);
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}

	private void gravarHistoricoAcesso(VeiculoIdentificacao veiculoIdentificacao, LoginContext context) {
		//TODO
	}
	
}
