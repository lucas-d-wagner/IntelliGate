package br.com.unisenaisc.intelligate.architecture.crud;

import java.util.Collection;
import java.util.Objects;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.architecture.persistence.IGenericRepository;
import br.com.unisenaisc.intelligate.common.context.LoginContext;

public abstract class DetailCRUDServiceImpl<D extends AbstractEntity, M extends AbstractEntity> implements IDetailCRUDService<D, M> {
	
	@Override
	public Collection<D> findAll(Long parentId) {
		M parent = getParentRepository().findNotNull(parentId);
		return getChildren(parent);
	}

	@Override
	public D find(Long parentId, Long id) {
		return getRepository().find(id);
	}

	@Override
	public Long insert(Long parentId, D entity, LoginContext context) {
		M parent = getParentRepository().findNotNull(parentId);
		
		setParent(entity, parent);
		
		validateInsert(entity, context);
		
		return getRepository().persist(entity).getId();
	}

	@Override
	public Long update(Long parentId, Long id, D entity, LoginContext context) {
		D entityManaged = getRepository().findNotNull(id);

		safeEdit(entity, entityManaged);
		
		validateUpdate(entityManaged, context);
		
		return getRepository().persist(entityManaged).getId();
	}

	@Override
	public void delete(Long parentId, Long id, LoginContext context) {
		D entity = getRepository().findNotNull(id);
		
		validateDelete(entity, context);
		
		getRepository().remove(entity);
	}

	public abstract void setParent(D detail, M master);
	
	public abstract Collection<D> getChildren(M master);
	
	public abstract void safeEdit(D entity, D entityManaged);
	
	public abstract IGenericRepository<D> getRepository();

	public abstract IGenericRepository<M> getParentRepository();
	
	public IGenericValidator<D> getValidator() {
		return null;
	}
	
	private void validateInsert(D entity, LoginContext context) {
		IGenericValidator<D> validator = getValidator();
		if(Objects.nonNull(validator)) {
			validator.validateInsert(entity, context);
		}
	}
	
	private void validateUpdate(D entity, LoginContext context) {
		IGenericValidator<D> validator = getValidator();
		if(Objects.nonNull(validator)) {
			validator.validateUpdate(entity, context);
		}
	}

	private void validateDelete(D entity, LoginContext context) {
		IGenericValidator<D> validator = getValidator();
		if(Objects.nonNull(validator)) {
			validator.validateDelete(entity, context);
		}
	}
	
}
