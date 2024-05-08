package br.com.unisenaisc.intelligate.architecture.selector;

import java.util.Collection;

import br.com.unisenaisc.intelligate.api.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;
import br.com.unisenaisc.intelligate.architecture.restful.AbstractResource;
import br.com.unisenaisc.intelligate.common.architecture.restful.AbstractDTO;
import br.com.unisenaisc.intelligate.common.architecture.restful.ISelectorResource;

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
