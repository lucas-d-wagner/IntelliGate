package br.com.unisenaisc.intelligate.architecture.crud;

import java.util.Collection;
import java.util.Objects;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.architecture.persistence.IGenericRepository;
import br.com.unisenaisc.intelligate.common.context.LoginContext;

public abstract class CRUDServiceImpl<E extends AbstractEntity> implements ICRUDService<E> {

	@Override
	public Collection<E> findAll() {
		return getRepository().findAll();
	}

	@Override
	public E find(Long id) {
		return getRepository().find(id);
	}

	@Override
	public Long insert(E entity, LoginContext context) {
		validateInsert(entity, context);
		
		return getRepository().persist(entity).getId();
	}

	@Override
	public Long update(Long id, E entity, LoginContext context) {
		E entityManaged = getRepository().findNotNull(id);

		safeEdit(entity, entityManaged);
		
		validateUpdate(entityManaged, context);
		
		return getRepository().persist(entityManaged).getId();
	}

	@Override
	public void delete(Long id, LoginContext context) {
		E entity = getRepository().findNotNull(id);
		
		validateDelete(entity, context);
		
		getRepository().remove(entity);
	}
	
	public abstract void safeEdit(E entity, E entityManaged);
	
	public abstract IGenericRepository<E> getRepository();

	public IGenericValidator<E> getValidator() {
		return null;
	}
	
	private void validateInsert(E entity, LoginContext context) {
		IGenericValidator<E> validator = getValidator();
		if(Objects.nonNull(validator)) {
			validator.validateInsert(entity, context);
		}
	}
	
	private void validateUpdate(E entity, LoginContext context) {
		IGenericValidator<E> validator = getValidator();
		if(Objects.nonNull(validator)) {
			validator.validateUpdate(entity, context);
		}
	}

	private void validateDelete(E entity, LoginContext context) {
		IGenericValidator<E> validator = getValidator();
		if(Objects.nonNull(validator)) {
			validator.validateDelete(entity, context);
		}
	}
	
}
