package br.com.unisenaisc.intelligate.api.resource.impl;

import java.util.Collection;

import br.com.unisenaisc.intelligate.api.common.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.common.dto.AbstractDTO;
import br.com.unisenaisc.intelligate.api.common.resource.ISelectorResource;
import br.com.unisenaisc.intelligate.api.resource.AbstractResource;
import br.com.unisenaisc.intelligate.business.service.impl.SelectorServiceImpl;
import br.com.unisenaisc.intelligate.common.AbstractEntity;

public abstract class SelectorResourceImpl<E extends AbstractEntity, DTO extends AbstractDTO, C extends AbstractDTOConverter<E, DTO>, S extends SelectorServiceImpl<E>> extends AbstractResource implements ISelectorResource<DTO> {

	@Override
	public Collection<DTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTO find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
