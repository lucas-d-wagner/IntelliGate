package br.com.unisenaisc.intelligate.business.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.unisenaisc.intelligate.architecture.crud.CRUDServiceImpl;
import br.com.unisenaisc.intelligate.architecture.persistence.IGenericRepository;
import br.com.unisenaisc.intelligate.business.repository.VeiculoRepository;
import br.com.unisenaisc.intelligate.model.entity.Veiculo;

@ManagedBean
public class VeiculoService extends CRUDServiceImpl<Veiculo> {

	@Inject
	private VeiculoRepository repository;
	
	@Override
	public void safeEdit(Veiculo entity, Veiculo entityManaged) {
		entityManaged.setPlaca(entity.getPlaca());
		entityManaged.setModelo(entity.getModelo());
		entityManaged.setMarca(entity.getMarca());
		entityManaged.setAno(entity.getAno());
	}

	@Override
	public IGenericRepository<Veiculo> getRepository() {
		return repository;
	}

}
