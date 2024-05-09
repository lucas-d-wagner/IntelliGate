package br.com.unisenaisc.intelligate.architecture.crud;

import java.util.Collection;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.common.context.LoginContext;

public interface IDetailCRUDService<D extends AbstractEntity, M extends AbstractEntity> {

	Collection<D> findAll(Long parentId);
	
	D find(Long parentId, Long id);
	
	Long insert(Long parentId, D entity, LoginContext context);
	
	Long update(Long parentId, Long id, D entity, LoginContext context);
	
	void delete(Long parentId, Long id, LoginContext context);
	
}
