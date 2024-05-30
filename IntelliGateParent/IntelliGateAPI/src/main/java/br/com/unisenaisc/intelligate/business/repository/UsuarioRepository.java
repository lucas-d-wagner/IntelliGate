package br.com.unisenaisc.intelligate.business.repository;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import br.com.unisenaisc.intelligate.architecture.persistence.GenericRepositoryImpl;
import br.com.unisenaisc.intelligate.model.entity.Usuario;

@ManagedBean
public class UsuarioRepository extends GenericRepositoryImpl<Usuario> {

	@Override
	public Class<Usuario> getEntityClass() {
		return Usuario.class;
	}

	public Usuario findByLogin(String login) {
		TypedQuery<Usuario> typedQuery = createTypedQuery("SELECT u FROM Usuario u WHERE u.login = :login");
		typedQuery.setParameter("login", login);
		return getSingleResult(typedQuery);
	}
	
}
