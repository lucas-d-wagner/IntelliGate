package br.com.unisenaisc.intelligate.api.converter;

import br.com.unisenaisc.intelligate.common.api.dto.TipoVeiculoDTO;
import br.com.unisenaisc.intelligate.model.entity.TipoVeiculo;

public class TipoVeiculoConverter extends AbstractDTOConverter<TipoVeiculo, TipoVeiculoDTO> {

	@Override
	public TipoVeiculoDTO convertToDTO(TipoVeiculo entity) {
		if(entity == null) {
			return null;
		}

		TipoVeiculoDTO dto = new TipoVeiculoDTO();
		
		dto.setIdTipoVeiculo(entity.getIdTipoVeiculo());
		dto.setCodigo(entity.getCodigo());
		dto.setDescricao(entity.getDescricao());
		
		return dto;
	}

	@Override
	public TipoVeiculo convertToEntity(TipoVeiculoDTO dto) {
		if(dto == null) {
			return null;
		}
		
		TipoVeiculo entity = new TipoVeiculo();

		entity.setIdTipoVeiculo(dto.getIdTipoVeiculo());
		entity.setCodigo(dto.getCodigo());
		entity.setDescricao(dto.getDescricao());
		
		return entity;
	}

}
