package br.com.unisenaisc.intelligate.business.service;

import java.util.Date;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.unisenaisc.intelligate.business.repository.LogAcessoRepository;
import br.com.unisenaisc.intelligate.business.repository.VeiculoIdentificacaoRepository;
import br.com.unisenaisc.intelligate.common.context.LoginContext;
import br.com.unisenaisc.intelligate.common.exception.BusinessCheckedException;
import br.com.unisenaisc.intelligate.model.entity.LogAcesso;
import br.com.unisenaisc.intelligate.model.entity.VeiculoIdentificacao;

@ManagedBean
public class EstacionamentoService {

	@Inject
	private VeiculoIdentificacaoRepository veiculoIdentificacaoRepository;
	
	@Inject
	private LogAcessoRepository logAcessoRepository;
	
	public Boolean validarEntrada(String token, LoginContext context) throws BusinessCheckedException {
		VeiculoIdentificacao veiculoIdentificacao = veiculoIdentificacaoRepository.findByUUID(token);
		
		if(veiculoIdentificacao != null) {
			gravarHistoricoAcesso(veiculoIdentificacao, context);
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}

	private void gravarHistoricoAcesso(VeiculoIdentificacao veiculoIdentificacao, LoginContext context) {
		LogAcesso ultimoAcessoVeiculo = logAcessoRepository.findUltimoByVeiculo(veiculoIdentificacao.getVeiculo());
		
		if(ultimoAcessoVeiculo != null && ultimoAcessoVeiculo.getDataHoraSaida() == null) {
			// Se não é nullo e a saída está vazia, quer dizer que está saindo
			ultimoAcessoVeiculo.setDataHoraSaida(new Date());
			logAcessoRepository.merge(ultimoAcessoVeiculo);
		} else {
			// Se é nullo ou a saída está preenchida (já saiu) cria um novo log
			LogAcesso logAcesso = new LogAcesso();
			logAcesso.setVeiculo(veiculoIdentificacao.getVeiculo());
			logAcesso.setDataHoraEntrada(new Date());
			logAcessoRepository.persist(logAcesso);
		}
	}
	
}
