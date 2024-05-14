package br.com.unisenaisc.intelligate.business.service;

import java.util.Collection;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.unisenaisc.intelligate.architecture.crud.DetailCRUDServiceImpl;
import br.com.unisenaisc.intelligate.architecture.persistence.IGenericRepository;
import br.com.unisenaisc.intelligate.business.repository.VeiculoIdentificacaoRepository;
import br.com.unisenaisc.intelligate.business.repository.VeiculoRepository;
import br.com.unisenaisc.intelligate.model.entity.Veiculo;
import br.com.unisenaisc.intelligate.model.entity.VeiculoIdentificacao;

@ManagedBean
public class VeiculoIdentificacaoService extends DetailCRUDServiceImpl<VeiculoIdentificacao, Veiculo> {

	@Inject
	private VeiculoIdentificacaoRepository repository;
	
	@Inject
	private VeiculoRepository parentRepository;
	
	@Override
	public void setParent(VeiculoIdentificacao detail, Veiculo master) {
		detail.setVeiculo(master);
	}

	@Override
	public Collection<VeiculoIdentificacao> getChildren(Veiculo master) {
		return master.getIdentificacoes();
	}

	@Override
	public void safeEdit(VeiculoIdentificacao entity, VeiculoIdentificacao entityManaged) {
		return;
	}

	@Override
	public IGenericRepository<VeiculoIdentificacao> getRepository() {
		return repository;
	}

	@Override
	public IGenericRepository<Veiculo> getParentRepository() {
		return parentRepository;
	}

}
