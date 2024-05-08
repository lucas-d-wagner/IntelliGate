package br.com.unisenaisc.intelligate.api.business.repository;

import javax.ejb.Stateless;

import br.com.unisenaisc.intelligate.api.business.model.entity.Usuario;

@Stateless
public class UsuarioRepository extends GenericRepositoryImpl<Usuario> {

	public UsuarioRepository() {
		super(Usuario.class);
	}

}
