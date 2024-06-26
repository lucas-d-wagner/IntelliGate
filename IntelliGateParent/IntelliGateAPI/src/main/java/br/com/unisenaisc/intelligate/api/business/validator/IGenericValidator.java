package br.com.unisenaisc.intelligate.api.business.validator;

import br.com.unisenaisc.intelligate.api.business.model.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.common.context.LoginContext;

public interface IGenericValidator<E extends AbstractEntity> {

	void validateInsert(E entity, LoginContext context);
	
	void validateUpdate(E entity, LoginContext context);
	
	void validateDelete(E entity, LoginContext context);
	
}
