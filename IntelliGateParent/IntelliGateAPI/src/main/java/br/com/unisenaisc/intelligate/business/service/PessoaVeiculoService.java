package br.com.unisenaisc.intelligate.business.service;

import java.util.Collection;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.unisenaisc.intelligate.architecture.crud.DetailCRUDServiceImpl;
import br.com.unisenaisc.intelligate.architecture.persistence.IGenericRepository;
import br.com.unisenaisc.intelligate.business.repository.PessoaRepository;
import br.com.unisenaisc.intelligate.business.repository.PessoaVeiculoRepository;
import br.com.unisenaisc.intelligate.model.entity.Pessoa;
import br.com.unisenaisc.intelligate.model.entity.PessoaVeiculo;

@ManagedBean
public class PessoaVeiculoService extends DetailCRUDServiceImpl<PessoaVeiculo, Pessoa> {

	@Inject
	private PessoaVeiculoRepository repository;
	
	@Inject
	private PessoaRepository parentRepository;
	
	@Override
	public void setParent(PessoaVeiculo detail, Pessoa master) {
		detail.setPessoa(master);
	}

	@Override
	public Collection<PessoaVeiculo> getChildren(Pessoa master) {
		return master.getVeiculos();
	}

	@Override
	public void safeEdit(PessoaVeiculo entity, PessoaVeiculo entityManaged) {
		return;
	}

	@Override
	public IGenericRepository<PessoaVeiculo> getRepository() {
		return repository;
	}

	@Override
	public IGenericRepository<Pessoa> getParentRepository() {
		return parentRepository;
	}

}
