package br.com.unisenaisc.intelligate.api.business.service;

import java.util.Collection;

import br.com.unisenaisc.intelligate.api.business.model.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.common.context.LoginContext;

public interface ICRUDService<E extends AbstractEntity> {

	Collection<E> findAll();
	
	E find(Long id);
	
	Long insert(E entity, LoginContext context);
	
	Long update(Long id, E entity, LoginContext context);
	
	void delete(Long id, LoginContext context);
	
}
