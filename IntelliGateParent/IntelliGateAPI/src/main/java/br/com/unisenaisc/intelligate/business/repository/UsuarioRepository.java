package br.com.unisenaisc.intelligate.business.repository;

import javax.annotation.ManagedBean;

import br.com.unisenaisc.intelligate.architecture.persistence.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.entity.Usuario;

@ManagedBean
public class UsuarioRepository extends GenericRepositoryImpl<Usuario> {

	@Override
	public Class<Usuario> getEntityClass() {
		return Usuario.class;
	}

}
