package br.com.unisenaisc.intelligate.business.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.unisenaisc.intelligate.architecture.persistence.IGenericRepository;
import br.com.unisenaisc.intelligate.architecture.selector.SelectorServiceImpl;
import br.com.unisenaisc.intelligate.business.repository.TipoPessoaRepository;
import br.com.unisenaisc.intelligate.model.entity.TipoPessoa;

@ManagedBean
public class TipoPessoaService extends SelectorServiceImpl<TipoPessoa> {

	@Inject
	private TipoPessoaRepository repository;
	
	@Override
	public IGenericRepository<TipoPessoa> getRepository() {
		return repository;
	}

}
