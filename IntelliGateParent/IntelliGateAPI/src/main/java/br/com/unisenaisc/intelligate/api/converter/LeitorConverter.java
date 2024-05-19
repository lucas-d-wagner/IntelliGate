package br.com.unisenaisc.intelligate.api.converter;

import br.com.unisenaisc.intelligate.common.api.dto.LeitorDTO;
import br.com.unisenaisc.intelligate.model.entity.Leitor;

public class LeitorConverter extends AbstractDTOConverter<Leitor, LeitorDTO> {

	@Override
	public LeitorDTO convertToDTO(Leitor entity) {
		if(entity == null) {
			return null;
		}

		LeitorDTO dto = new LeitorDTO();
		
		dto.setIdLeitor(entity.getIdLeitor());
		dto.setEndereco(entity.getEndereco());
		dto.setDescricao(entity.getDescricao());
		
		return dto;
	}

	@Override
	public Leitor convertToEntity(LeitorDTO dto) {
		if(dto == null) {
			return null;
		}

		Leitor entity = new Leitor();
		
		entity.setIdLeitor(dto.getIdLeitor());
		entity.setEndereco(dto.getEndereco());
		entity.setDescricao(dto.getDescricao());
		
		return entity;
	}

}
