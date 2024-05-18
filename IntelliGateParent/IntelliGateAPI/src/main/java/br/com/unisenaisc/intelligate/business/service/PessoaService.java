package br.com.unisenaisc.intelligate.business.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.unisenaisc.intelligate.architecture.crud.CRUDServiceImpl;
import br.com.unisenaisc.intelligate.architecture.persistence.IGenericRepository;
import br.com.unisenaisc.intelligate.business.repository.PessoaRepository;
import br.com.unisenaisc.intelligate.model.entity.Pessoa;

@ManagedBean
public class PessoaService extends CRUDServiceImpl<Pessoa> {

	@Inject
	private PessoaRepository repository;
	
	@Override
	public void safeEdit(Pessoa entity, Pessoa entityManaged) {
		entityManaged.setNome(entity.getNome());
		entityManaged.setEmail(entity.getEmail());
		entityManaged.setTelefone(entity.getTelefone());
	}

	@Override
	public IGenericRepository<Pessoa> getRepository() {
		return repository;
	}

}
