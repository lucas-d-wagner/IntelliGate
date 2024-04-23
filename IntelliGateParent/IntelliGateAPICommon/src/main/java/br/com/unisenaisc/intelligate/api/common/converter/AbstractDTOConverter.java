package br.com.unisenaisc.intelligate.api.common.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.unisenaisc.intelligate.api.common.dto.AbstractDTO;
import br.com.unisenaisc.intelligate.common.AbstractEntity;
import br.com.unisenaisc.intelligate.common.util.CollectionsUtil;

public abstract class AbstractDTOConverter<E extends AbstractEntity, DTO extends AbstractDTO> {

	public abstract DTO convertToDTO(E entity);
	public abstract E convertToEntity(DTO dto);

	public Collection<DTO> convertToDTO(Collection<E> entityList) {
		List<DTO> dtoList = new ArrayList<>();
		
		for (E entity : CollectionsUtil.notNull(entityList)) {
			DTO dto = convertToDTO(entity);
			dtoList.add(dto);
		}
		
		return dtoList;
	}
	
	public Collection<E> convertToEntity(Collection<DTO> dtoList) {
		List<E> entityList = new ArrayList<>();
		
		for (DTO dto : CollectionsUtil.notNull(dtoList)) {
			E entity = convertToEntity(dto);
			entityList.add(entity);
		}
		
		return entityList;
	}
	
}
