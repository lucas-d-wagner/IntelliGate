package br.com.unisenaisc.intelligate.api.business.repository;

import javax.annotation.ManagedBean;

import br.com.unisenaisc.intelligate.api.business.model.entity.Usuario;

@ManagedBean
public class UsuarioRepository extends GenericRepositoryImpl<Usuario> {

	@Override
	public Class<Usuario> getEntityClass() {
		return Usuario.class;
	}

}
