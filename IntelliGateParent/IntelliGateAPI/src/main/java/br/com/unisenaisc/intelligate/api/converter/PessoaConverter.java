package br.com.unisenaisc.intelligate.api.converter;

import br.com.unisenaisc.intelligate.common.api.dto.PessoaDTO;
import br.com.unisenaisc.intelligate.model.entity.Pessoa;

public class PessoaConverter extends AbstractDTOConverter<Pessoa, PessoaDTO>{

	@Override
	public PessoaDTO convertToDTO(Pessoa entity) {
		if(entity == null) {
			return null;
		}

		PessoaDTO dto = new PessoaDTO();
		
		dto.setIdPessoa(entity.getIdPessoa());
		dto.setTipoPessoa(getTipoPessoaConverter().convertToDTO(entity.getTipoPessoa()));
		dto.setCpfCnpj(entity.getCpfCnpj());
		dto.setEmail(entity.getEmail());
		dto.setTelefone(entity.getTelefone());
		
		return dto;
	}

	@Override
	public Pessoa convertToEntity(PessoaDTO dto) {
		if(dto == null) {
			return null;
		}

		Pessoa entity = new Pessoa();
		
		entity.setIdPessoa(dto.getIdPessoa());
		entity.setTipoPessoa(getTipoPessoaConverter().convertToEntity(dto.getTipoPessoa()));
		entity.setCpfCnpj(dto.getCpfCnpj());
		entity.setEmail(dto.getEmail());
		entity.setTelefone(dto.getTelefone());
		
		return entity;
	}
	
	private TipoPessoaConverter getTipoPessoaConverter() {
		return new TipoPessoaConverter();
	}

}
