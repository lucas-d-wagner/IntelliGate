package br.com.unisenaisc.intelligate.business.service.impl;

import java.util.Collection;

import br.com.unisenaisc.intelligate.common.AbstractEntity;
import br.com.unisenaisc.intelligate.common.service.ISelectorService;

public abstract class SelectorServiceImpl<E extends AbstractEntity> implements ISelectorService<E> {

	@Override
	public Collection<E> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
