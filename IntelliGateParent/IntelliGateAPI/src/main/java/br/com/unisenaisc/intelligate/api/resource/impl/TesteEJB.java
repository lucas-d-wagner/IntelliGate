package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.unisenaisc.intelligate.api.business.model.entity.Usuario;

@Stateless
public class TesteEJB {

	@PersistenceContext
	EntityManager entityManager;

	public void teste() {
		
		Usuario usuario = entityManager.find(Usuario.class, 1L);
		
		System.out.println(usuario);
	}
}
