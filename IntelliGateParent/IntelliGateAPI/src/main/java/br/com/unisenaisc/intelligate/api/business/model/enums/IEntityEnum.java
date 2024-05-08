package br.com.unisenaisc.intelligate.api.business.model.enums;

import br.com.unisenaisc.intelligate.api.business.model.entity.AbstractEntity;

public interface IEntityEnum<E extends AbstractEntity> {

	E getEntity();

}