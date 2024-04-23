package br.com.unisenaisc.intelligate.business.service.impl;

import java.util.Collection;

import br.com.unisenaisc.intelligate.common.AbstractEntity;
import br.com.unisenaisc.intelligate.common.context.LoginContext;
import br.com.unisenaisc.intelligate.common.service.ICRUDService;

public abstract class CRUDServiceImpl<E extends AbstractEntity> implements ICRUDService<E> {

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

	@Override
	public Long insert(E entity, LoginContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long update(Long id, E entity, LoginContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id, LoginContext contexts) {
		// TODO Auto-generated method stub
		
	}
	
}
