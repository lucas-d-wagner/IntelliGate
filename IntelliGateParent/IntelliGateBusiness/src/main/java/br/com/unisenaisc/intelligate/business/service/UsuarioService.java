package br.com.unisenaisc.intelligate.business.service;

import br.com.unisenaisc.intelligate.business.repository.UsuarioRepository;
import br.com.unisenaisc.intelligate.business.service.impl.CRUDServiceImpl;
import br.com.unisenaisc.intelligate.common.repository.IGenericRepository;
import br.com.unisenaisc.intelligate.model.Usuario;

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
