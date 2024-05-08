package br.com.unisenaisc.intelligate.api.business.repository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.unisenaisc.intelligate.api.business.model.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.common.exception.BusinessException;

@ManagedBean
public abstract class GenericRepositoryImpl<E extends AbstractEntity> implements IGenericRepository<E> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<E> findAll() {
		StringBuilder query = new StringBuilder();
		query.append("select entity from ").append(getEntityName()).append(" entity");
		return getResultList(createTypedQuery(query));
	}

	@Override
	public E find(Long id) {
		return entityManager.find(getEntityClass(), id);
	}

	@Override
	public E findNotNull(Long id) {
		E entity = find(id);
		if (Objects.isNull(entity)) {
			throw new BusinessException("Não encontrou entidade " + getEntityName() + " com o id " + id + ".");
		}
		return entity;
	}

	@Override
	public E persist(E entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public E merge(E entity) {
		entityManager.merge(entity);
		return entity;
	}

	@Override
	public E mergeOrPersist(E entity) {
		if(entity.isNew()) {
			entity = persist(entity);
		} else {
			entity = merge(entity);
		}
		return entity;
	}

	@Override
	public void remove(E entity) {
		entityManager.remove(entity);
	}
	
	@Override
	public TypedQuery<E> createTypedQuery(StringBuilder query) {
		return createTypedQuery(query.toString());
	}

	@Override
	public TypedQuery<E> createTypedQuery(String query) {
		return entityManager.createQuery(query, getEntityClass());
	}
	
	@Override
	public List<E> getResultList(TypedQuery<E> typedQuery) {
		try {
			return typedQuery.getResultList();
		} catch (NoResultException e) {
			return Collections.emptyList();
		}
	}
	
	@Override
	public E getSingleResult(TypedQuery<E> typedQuery) {
		try {
			return typedQuery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			throw new BusinessException("Foi encontrado mais de um resultado para a entidade " + getEntityName() + ".");
		}
	}
	
	public abstract Class<E> getEntityClass();
	
	private String getEntityName() {
		return getEntityClass().getSimpleName();
	}
}
