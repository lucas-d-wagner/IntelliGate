package br.com.unisenaisc.intelligate.business.repository;

import javax.annotation.ManagedBean;

import br.com.unisenaisc.intelligate.business.repository.impl.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.Usuario;

@ManagedBean
public class UsuarioRepository extends GenericRepositoryImpl<Usuario> {

	public UsuarioRepository() {
		super(Usuario.class);
	}

}
