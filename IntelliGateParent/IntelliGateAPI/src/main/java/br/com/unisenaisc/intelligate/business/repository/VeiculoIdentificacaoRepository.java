package br.com.unisenaisc.intelligate.business.repository;

import javax.annotation.ManagedBean;

import br.com.unisenaisc.intelligate.architecture.persistence.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.entity.VeiculoIdentificacao;

@ManagedBean
public class VeiculoIdentificacaoRepository extends GenericRepositoryImpl<VeiculoIdentificacao> {

	@Override
	public Class<VeiculoIdentificacao> getEntityClass() {
		return VeiculoIdentificacao.class;
	}

}
