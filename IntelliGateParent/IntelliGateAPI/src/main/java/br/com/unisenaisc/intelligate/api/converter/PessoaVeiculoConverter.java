package br.com.unisenaisc.intelligate.api.converter;

import br.com.unisenaisc.intelligate.common.api.dto.PessoaVeiculoDTO;
import br.com.unisenaisc.intelligate.model.entity.PessoaVeiculo;

public class PessoaVeiculoConverter extends AbstractDTOConverter<PessoaVeiculo, PessoaVeiculoDTO> {

	@Override
	public PessoaVeiculoDTO convertToDTO(PessoaVeiculo entity) {
		if(entity == null) {
			return null;
		}
		
		PessoaVeiculoDTO dto = new PessoaVeiculoDTO();

		dto.setIdPessoaVeiculo(entity.getIdPessoaVeiculo());
		dto.setPessoa(getPessoaConverter().convertToDTO(entity.getPessoa()));
		dto.setVeiculo(getVeiculoConverter().convertToDTO(entity.getVeiculo()));
		
		return dto;
	}

	@Override
	public PessoaVeiculo convertToEntity(PessoaVeiculoDTO dto) {
		if(dto == null) {
			return null;
		}
		
		PessoaVeiculo entity = new PessoaVeiculo();

		entity.setIdPessoaVeiculo(dto.getIdPessoaVeiculo());
		entity.setPessoa(getPessoaConverter().convertToEntity(dto.getPessoa()));
		entity.setVeiculo(getVeiculoConverter().convertToEntity(dto.getVeiculo()));
		
		return entity;
	}
	
	private PessoaConverter getPessoaConverter() {
		return new PessoaConverter();
	}
	
	private VeiculoConverter getVeiculoConverter() {
		return new VeiculoConverter();
	}

}
