package br.com.unisenaisc.intelligate.api.business.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.unisenaisc.intelligate.api.business.model.entity.Usuario;
import br.com.unisenaisc.intelligate.api.business.repository.IGenericRepository;
import br.com.unisenaisc.intelligate.api.business.repository.UsuarioRepository;

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
