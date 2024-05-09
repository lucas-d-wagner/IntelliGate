package br.com.unisenaisc.intelligate.business.repository;

import javax.annotation.ManagedBean;

import br.com.unisenaisc.intelligate.architecture.persistence.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.entity.Veiculo;

@ManagedBean
public class VeiculoRepository extends GenericRepositoryImpl<Veiculo> {

	@Override
	public Class<Veiculo> getEntityClass() {
		return Veiculo.class;
	}

}
