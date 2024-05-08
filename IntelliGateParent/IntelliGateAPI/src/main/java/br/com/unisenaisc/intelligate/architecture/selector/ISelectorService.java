package br.com.unisenaisc.intelligate.architecture.selector;

import java.util.Collection;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;

public interface ISelectorService<E extends AbstractEntity> {

	Collection<E> findAll();
	
	E find(Long id);
	
}
