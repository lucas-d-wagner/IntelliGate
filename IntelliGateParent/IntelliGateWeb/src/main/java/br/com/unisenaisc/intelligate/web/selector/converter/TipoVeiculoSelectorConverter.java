package br.com.unisenaisc.intelligate.web.selector.converter;

import javax.faces.convert.FacesConverter;

import br.com.unisenaisc.intelligate.common.api.dto.TipoVeiculoDTO;
import br.com.unisenaisc.intelligate.common.api.resource.TipoVeiculoResource;

@FacesConverter(forClass = TipoVeiculoDTO.class)
public class TipoVeiculoSelectorConverter extends AbstractSelectorConverter<TipoVeiculoDTO> {

	@Override
	public TipoVeiculoDTO findDTO(Long id) {
		return getResource().find(id);
	}

	private TipoVeiculoResource getResource() {
		return getResource(TipoVeiculoResource.class);
	}
	
}
