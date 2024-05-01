package br.com.unisenaisc.intelligate.api.resource.impl;

import java.util.Collection;

import br.com.unisenaisc.intelligate.api.common.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.common.dto.AbstractDTO;
import br.com.unisenaisc.intelligate.api.common.resource.ISelectorResource;
import br.com.unisenaisc.intelligate.api.resource.AbstractResource;
import br.com.unisenaisc.intelligate.common.AbstractEntity;
import br.com.unisenaisc.intelligate.common.service.ISelectorService;

public abstract class SelectorResourceImpl<E extends AbstractEntity, DTO extends AbstractDTO> extends AbstractResource implements ISelectorResource<DTO> {

	@Override
	public Collection<DTO> findAll() {
		Collection<E> entityList = getService().findAll();
		return getConverter().convertToDTO(entityList);
	}

	@Override
	public DTO find(Long id) {
		E entity = getService().find(id);
		return getConverter().convertToDTO(entity);
	}
	
	public abstract ISelectorService<E> getService();

	public abstract AbstractDTOConverter<E, DTO> getConverter();

}
