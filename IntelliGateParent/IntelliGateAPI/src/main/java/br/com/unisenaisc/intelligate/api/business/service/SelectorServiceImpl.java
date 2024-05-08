package br.com.unisenaisc.intelligate.api.business.service;

import java.util.Collection;

import br.com.unisenaisc.intelligate.api.business.model.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.api.business.repository.IGenericRepository;

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

