package br.com.unisenaisc.intelligate.business.repository;

import javax.annotation.ManagedBean;

import br.com.unisenaisc.intelligate.architecture.persistence.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.entity.Pessoa;

@ManagedBean
public class PessoaRepository extends GenericRepositoryImpl<Pessoa> {

	@Override
	public Class<Pessoa> getEntityClass() {
		return Pessoa.class;
	}

}
