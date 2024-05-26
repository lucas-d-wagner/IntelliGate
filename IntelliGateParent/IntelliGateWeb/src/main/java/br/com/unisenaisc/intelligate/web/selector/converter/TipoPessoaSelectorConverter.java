package br.com.unisenaisc.intelligate.web.selector.converter;

import javax.faces.convert.FacesConverter;

import br.com.unisenaisc.intelligate.common.api.dto.TipoPessoaDTO;
import br.com.unisenaisc.intelligate.common.api.resource.TipoPessoaResource;

@FacesConverter(forClass = TipoPessoaDTO.class)
public class TipoPessoaSelectorConverter extends AbstractSelectorConverter<TipoPessoaDTO> {

	@Override
	public TipoPessoaDTO findDTO(Long id) {
		return getResource().find(id);
	}

	private TipoPessoaResource getResource() {
		return getResource(TipoPessoaResource.class);
	}
	
}
