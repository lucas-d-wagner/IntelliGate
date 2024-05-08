package br.com.unisenaisc.intelligate.api.business.service;

import java.util.Collection;

import br.com.unisenaisc.intelligate.api.business.model.entity.AbstractEntity;

public interface ISelectorService<E extends AbstractEntity> {

	Collection<E> findAll();
	
	E find(Long id);
	
}
