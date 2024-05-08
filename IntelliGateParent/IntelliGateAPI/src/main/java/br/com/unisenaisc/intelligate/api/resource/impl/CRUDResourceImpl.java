package br.com.unisenaisc.intelligate.api.resource.impl;

import java.util.Collection;

import br.com.unisenaisc.intelligate.api.business.model.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.api.business.service.ICRUDService;
import br.com.unisenaisc.intelligate.api.common.dto.AbstractDTO;
import br.com.unisenaisc.intelligate.api.common.resource.ICRUDResource;
import br.com.unisenaisc.intelligate.api.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.resource.AbstractResource;

public abstract class CRUDResourceImpl<E extends AbstractEntity, DTO extends AbstractDTO> extends AbstractResource implements ICRUDResource<DTO> {

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
 
	@Override
	public Long insert(DTO dto) {
		E entity = getConverter().convertToEntity(dto);
		return getService().insert(entity, getLoginContext());
	}

	@Override
	public void update(Long id, DTO dto) {
		E entity = getConverter().convertToEntity(dto);
		getService().update(id, entity, getLoginContext());
	}

	@Override
	public void delete(Long id) {
		getService().delete(id, getLoginContext());
	}
	
	public abstract ICRUDService<E> getService();
	
	public abstract AbstractDTOConverter<E, DTO> getConverter();
	
}
