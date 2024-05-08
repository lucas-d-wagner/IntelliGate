package br.com.unisenaisc.intelligate.architecture.selector;

import java.util.Collection;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.architecture.persistence.IGenericRepository;

public abstract class SelectorServiceImpl<E extends AbstractEntity> implements ISelectorService<E> {

	@Override
	public Collection<E> findAll() {
		return getRepository().findAll();
	}

	@Override
	public E find(Long id) {
		return getRepository().find(id);
	}
	
	public abstract IGenericRepository<E> getRepository();
	
}

