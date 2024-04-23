package br.com.unisenaisc.intelligate.common.service;

import java.util.Collection;

import br.com.unisenaisc.intelligate.common.AbstractEntity;

public interface ISelectorService<E extends AbstractEntity> {

	Collection<E> findAll();
	
	E find(Long id);
	
}
