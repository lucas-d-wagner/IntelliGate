package br.com.unisenaisc.intelligate.business.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.unisenaisc.intelligate.architecture.crud.CRUDServiceImpl;
import br.com.unisenaisc.intelligate.architecture.persistence.IGenericRepository;
import br.com.unisenaisc.intelligate.business.repository.UsuarioRepository;
import br.com.unisenaisc.intelligate.model.entity.Usuario;

@ManagedBean
public class UsuarioService extends CRUDServiceImpl<Usuario> {

	@Inject
	private UsuarioRepository repository;
	
	@Override
	public void safeEdit(Usuario entity, Usuario entityManaged) {
		entityManaged.setSenha(entity.getSenha());
	}

	@Override
	public IGenericRepository<Usuario> getRepository() {
		return repository;
	}

}
