package br.com.unisenaisc.intelligate.api.resource.impl;

import java.util.Collection;

import br.com.unisenaisc.intelligate.api.common.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.common.dto.AbstractDTO;
import br.com.unisenaisc.intelligate.api.common.resource.ICRUDResource;
import br.com.unisenaisc.intelligate.api.resource.AbstractResource;
import br.com.unisenaisc.intelligate.business.service.impl.CRUDServiceImpl;
import br.com.unisenaisc.intelligate.common.AbstractEntity;

public abstract class CRUDResourceImpl<E extends AbstractEntity, DTO extends AbstractDTO, C extends AbstractDTOConverter<E, DTO>, S extends CRUDServiceImpl<E>> extends AbstractResource implements ICRUDResource<DTO> {

	private S service;
	
	private C converter;
	
	public CRUDResourceImpl(S service, C converter) {
		this.service = service;
		this.converter = converter;
	}
	
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
	
	public S getService() {
		return service;
	}
	
	public C getConverter() {
		return converter;
	}
	
}
