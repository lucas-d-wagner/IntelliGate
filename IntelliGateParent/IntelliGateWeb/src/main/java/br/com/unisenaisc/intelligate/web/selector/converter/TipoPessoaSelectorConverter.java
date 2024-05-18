package br.com.unisenaisc.intelligate.web.selector.converter;

import javax.faces.convert.FacesConverter;

import br.com.unisenaisc.intelligate.common.api.dto.TipoPessoaDTO;
import br.com.unisenaisc.intelligate.common.api.resource.TipoPessoaResource;
import br.com.unisenaisc.intelligate.common.architecture.restful.ISelectorResource;

@FacesConverter(forClass = TipoPessoaDTO.class)
public class TipoPessoaSelectorConverter extends AbstractSelectorConverter<TipoPessoaDTO> {

	@Override
	public ISelectorResource<TipoPessoaDTO> getSelectorResource() {
		return getResource(TipoPessoaResource.class);
	}

}
