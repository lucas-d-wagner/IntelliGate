package br.com.unisenaisc.intelligate.business.repository;

import javax.annotation.ManagedBean;

import br.com.unisenaisc.intelligate.architecture.persistence.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.entity.Leitor;

@ManagedBean
public class LeitorRepository extends GenericRepositoryImpl<Leitor> {

	@Override
	public Class<Leitor> getEntityClass() {
		return Leitor.class;
	}

}
