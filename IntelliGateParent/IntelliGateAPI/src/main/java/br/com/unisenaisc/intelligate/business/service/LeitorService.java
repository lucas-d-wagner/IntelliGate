package br.com.unisenaisc.intelligate.business.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.unisenaisc.intelligate.architecture.crud.CRUDServiceImpl;
import br.com.unisenaisc.intelligate.architecture.persistence.IGenericRepository;
import br.com.unisenaisc.intelligate.business.repository.LeitorRepository;
import br.com.unisenaisc.intelligate.model.entity.Leitor;

@ManagedBean
public class LeitorService extends CRUDServiceImpl<Leitor> {

	@Inject
	private LeitorRepository repository;
	
	@Override
	public void safeEdit(Leitor entity, Leitor entityManaged) {
		entityManaged.setEndereco(entity.getEndereco());
		entityManaged.setDescricao(entity.getDescricao());
	}

	@Override
	public IGenericRepository<Leitor> getRepository() {
		return repository;
	}

}
