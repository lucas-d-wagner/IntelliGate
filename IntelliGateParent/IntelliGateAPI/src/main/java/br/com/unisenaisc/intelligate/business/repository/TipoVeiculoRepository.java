package br.com.unisenaisc.intelligate.business.repository;

import javax.annotation.ManagedBean;

import br.com.unisenaisc.intelligate.architecture.persistence.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.entity.TipoVeiculo;

@ManagedBean
public class TipoVeiculoRepository extends GenericRepositoryImpl<TipoVeiculo> {

	@Override
	public Class<TipoVeiculo> getEntityClass() {
		return TipoVeiculo.class;
	}

}
