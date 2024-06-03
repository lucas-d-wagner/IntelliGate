package br.com.unisenaisc.intelligate.business.repository;

import javax.annotation.ManagedBean;

import br.com.unisenaisc.intelligate.architecture.persistence.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.entity.LogAcesso;

@ManagedBean
public class LogAcessoRepository extends GenericRepositoryImpl<LogAcesso> {

	@Override
	public Class<LogAcesso> getEntityClass() {
		return LogAcesso.class;
	}

}
