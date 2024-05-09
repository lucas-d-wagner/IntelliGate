package br.com.unisenaisc.intelligate.business.repository;

import javax.annotation.ManagedBean;

import br.com.unisenaisc.intelligate.architecture.persistence.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.entity.TipoPessoa;

@ManagedBean
public class TipoPessoaRepository extends GenericRepositoryImpl<TipoPessoa> {

	@Override
	public Class<TipoPessoa> getEntityClass() {
		return TipoPessoa.class;
	}

}
