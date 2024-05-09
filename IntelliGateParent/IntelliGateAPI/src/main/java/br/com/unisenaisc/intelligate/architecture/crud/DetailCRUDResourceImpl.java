package br.com.unisenaisc.intelligate.architecture.crud;

import java.util.Collection;

import br.com.unisenaisc.intelligate.api.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.architecture.restful.AbstractResource;
import br.com.unisenaisc.intelligate.common.architecture.restful.AbstractDTO;
import br.com.unisenaisc.intelligate.common.architecture.restful.IDetailCRUDResource;

public abstract class DetailCRUDResourceImpl<D extends AbstractEntity, M extends AbstractEntity, DTO extends AbstractDTO> extends AbstractResource implements IDetailCRUDResource<DTO> {

	@Override
	public Collection<DTO> findAll(Long parentId) {
		Collection<D> entityList = getService().findAll(parentId);
		return getConverter().convertToDTO(entityList);
	}

	@Override
	public DTO find(Long parentId, Long id) {
		D entity = getService().find(parentId, id);
		return getConverter().convertToDTO(entity);
	}

	@Override
	public Long insert(Long parentId, DTO dto) {
		D entity = getConverter().convertToEntity(dto);
		return getService().insert(parentId, entity, getLoginContext());
	}

	@Override
	public void update(Long parentId, Long id, DTO dto) {
		D entity = getConverter().convertToEntity(dto);
		getService().update(parentId, id, entity, getLoginContext());
	}

	@Override
	public void delete(Long parentId, Long id) {
		getService().delete(parentId, id, getLoginContext());
	}

	public abstract IDetailCRUDService<D, M> getService();
	
	public abstract AbstractDTOConverter<D, DTO> getConverter();
	
}
