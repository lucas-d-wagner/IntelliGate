package br.com.unisenaisc.intelligate.common.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.unisenaisc.intelligate.common.AbstractEntity;

public interface IGenericRepository<E extends AbstractEntity> {

	List<E> findAll();
	
	E find(Long id);
	
	E findNotNull(Long id);
	
	E persist(E entity);
	
	E merge(E entity);
	
	E mergeOrPersist(E entity);
	
	void remove(E entity);
	
	List<E> getResultList(TypedQuery<E> typedQuery);
	
	E getSingleResult(TypedQuery<E> typedQuery);

	TypedQuery<E> createTypedQuery(StringBuilder query);

	TypedQuery<E> createTypedQuery(String query);
	
}
