package br.com.unisenaisc.intelligate.business.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.unisenaisc.intelligate.architecture.persistence.IGenericRepository;
import br.com.unisenaisc.intelligate.architecture.selector.SelectorServiceImpl;
import br.com.unisenaisc.intelligate.business.repository.TipoVeiculoRepository;
import br.com.unisenaisc.intelligate.model.entity.TipoVeiculo;

@ManagedBean
public class TipoVeiculoService extends SelectorServiceImpl<TipoVeiculo> {

	@Inject
	private TipoVeiculoRepository repository;

	@Override
	public IGenericRepository<TipoVeiculo> getRepository() {
		return repository;
	}

}
