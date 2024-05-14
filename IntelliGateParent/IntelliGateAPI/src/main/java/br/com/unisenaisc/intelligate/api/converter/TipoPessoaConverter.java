package br.com.unisenaisc.intelligate.api.converter;

import br.com.unisenaisc.intelligate.common.api.dto.TipoPessoaDTO;
import br.com.unisenaisc.intelligate.model.entity.TipoPessoa;

public class TipoPessoaConverter extends AbstractDTOConverter<TipoPessoa, TipoPessoaDTO> {

	@Override
	public TipoPessoaDTO convertToDTO(TipoPessoa entity) {
		if(entity == null) {
			return null;
		}

		TipoPessoaDTO dto = new TipoPessoaDTO();
		
		dto.setIdTipoPessoa(entity.getIdTipoPessoa());
		dto.setCodigo(entity.getCodigo());
		dto.setDescricao(entity.getDescricao());
		
		return dto;
	}

	@Override
	public TipoPessoa convertToEntity(TipoPessoaDTO dto) {
		if(dto == null) {
			return null;
		}
		
		TipoPessoa entity = new TipoPessoa();

		entity.setIdTipoPessoa(dto.getIdTipoPessoa());
		entity.setCodigo(dto.getCodigo());
		entity.setDescricao(dto.getDescricao());
		
		return entity;
	}

}
