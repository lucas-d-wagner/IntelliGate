package br.com.unisenaisc.intelligate.architecture.crud;

import java.util.Collection;

import br.com.unisenaisc.intelligate.api.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.architecture.restful.AbstractResource;
import br.com.unisenaisc.intelligate.common.api.dto.ResponseIdDTO;
import br.com.unisenaisc.intelligate.common.architecture.restful.AbstractDTO;
import br.com.unisenaisc.intelligate.common.architecture.restful.ICRUDResource;

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
	public ResponseIdDTO insert(DTO dto) {
		E entity = getConverter().convertToEntity(dto);
		Long id = getService().insert(entity, getLoginContext());
		return new ResponseIdDTO(id);
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
