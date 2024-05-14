package br.com.unisenaisc.intelligate.api.converter;

import br.com.unisenaisc.intelligate.common.api.dto.VeiculoIdentificacaoDTO;
import br.com.unisenaisc.intelligate.model.entity.VeiculoIdentificacao;

public class VeiculoIdentificacaoConverter extends AbstractDTOConverter<VeiculoIdentificacao, VeiculoIdentificacaoDTO>{

	@Override
	public VeiculoIdentificacaoDTO convertToDTO(VeiculoIdentificacao entity) {
		if(entity == null) {
			return null;
		}

		VeiculoIdentificacaoDTO dto = new VeiculoIdentificacaoDTO();
		
		dto.setIdVeiculoIdentificacao(entity.getIdVeiculoIdentificacao());
		dto.setVeiculo(getVeiculoConverter().convertToDTO(entity.getVeiculo()));
		dto.setUUID(entity.getUUID());
		
		return dto;
	}

	@Override
	public VeiculoIdentificacao convertToEntity(VeiculoIdentificacaoDTO dto) {
		if(dto == null) {
			return null;
		}
		
		VeiculoIdentificacao entity = new VeiculoIdentificacao();
		
		entity.setIdVeiculoIdentificacao(dto.getIdVeiculoIdentificacao());
		entity.setVeiculo(getVeiculoConverter().convertToEntity(dto.getVeiculo()));
		entity.setUUID(dto.getUUID());
		
		return entity;
	}
	
	private VeiculoConverter getVeiculoConverter() {
		return new VeiculoConverter();
	}

}
