package br.com.unisenaisc.intelligate.api.business.service;

import br.com.unisenaisc.intelligate.api.business.model.entity.Usuario;
import br.com.unisenaisc.intelligate.api.business.repository.IGenericRepository;
import br.com.unisenaisc.intelligate.api.business.repository.UsuarioRepository;

public class UsuarioService extends CRUDServiceImpl<Usuario> {

	@Override
	public void safeEdit(Usuario entity, Usuario entityManaged) {
		entityManaged.setSenha(entity.getSenha());
	}

	@Override
	public IGenericRepository<Usuario> getRepository() {
		return new UsuarioRepository();
	}

}
