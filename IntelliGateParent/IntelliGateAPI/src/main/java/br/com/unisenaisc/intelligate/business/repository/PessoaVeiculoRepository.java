package br.com.unisenaisc.intelligate.business.repository;

import javax.annotation.ManagedBean;

import br.com.unisenaisc.intelligate.architecture.persistence.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.entity.PessoaVeiculo;

@ManagedBean
public class PessoaVeiculoRepository extends GenericRepositoryImpl<PessoaVeiculo> {

	@Override
	public Class<PessoaVeiculo> getEntityClass() {
		return PessoaVeiculo.class;
	}

}