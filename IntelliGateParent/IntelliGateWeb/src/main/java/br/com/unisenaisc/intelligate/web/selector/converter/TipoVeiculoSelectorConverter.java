package br.com.unisenaisc.intelligate.web.selector.converter;

import javax.faces.convert.FacesConverter;

import br.com.unisenaisc.intelligate.common.api.dto.TipoVeiculoDTO;
import br.com.unisenaisc.intelligate.common.api.resource.TipoVeiculoResource;
import br.com.unisenaisc.intelligate.common.architecture.restful.ISelectorResource;

@FacesConverter(forClass = TipoVeiculoDTO.class)
public class TipoVeiculoSelectorConverter extends AbstractSelectorConverter<TipoVeiculoDTO> {

	@Override
	public ISelectorResource<TipoVeiculoDTO> getSelectorResource() {
		return getResource(TipoVeiculoResource.class);
	}

}
