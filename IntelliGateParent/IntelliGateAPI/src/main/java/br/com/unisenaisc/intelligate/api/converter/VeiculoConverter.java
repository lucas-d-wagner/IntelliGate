package br.com.unisenaisc.intelligate.api.converter;

import br.com.unisenaisc.intelligate.common.api.dto.VeiculoDTO;
import br.com.unisenaisc.intelligate.model.entity.Veiculo;

public class VeiculoConverter extends AbstractDTOConverter<Veiculo, VeiculoDTO> {

	@Override
	public VeiculoDTO convertToDTO(Veiculo entity) {
		if(entity == null) {
			return null;
		}
		
		VeiculoDTO dto = new VeiculoDTO();

		dto.setIdVeiculo(entity.getIdVeiculo());
		dto.setTipoVeiculo(getTipoVeiculoConverter().convertToDTO(entity.getTipoVeiculo()));
		dto.setPlaca(entity.getPlaca());
		dto.setModelo(entity.getModelo());
		dto.setMarca(entity.getMarca());
		dto.setAno(entity.getAno());
		
		return dto;
	}

	@Override
	public Veiculo convertToEntity(VeiculoDTO dto) {
		if(dto == null) {
			return null;
		}
		
		Veiculo entity = new Veiculo();

		entity.setIdVeiculo(dto.getIdVeiculo());
		entity.setTipoVeiculo(getTipoVeiculoConverter().convertToEntity(dto.getTipoVeiculo()));
		entity.setPlaca(dto.getPlaca());
		entity.setModelo(dto.getModelo());
		entity.setMarca(dto.getMarca());
		entity.setAno(dto.getAno());
		
		return entity;
	}
	
	private TipoVeiculoConverter getTipoVeiculoConverter() {
		return new TipoVeiculoConverter();
	}

}
