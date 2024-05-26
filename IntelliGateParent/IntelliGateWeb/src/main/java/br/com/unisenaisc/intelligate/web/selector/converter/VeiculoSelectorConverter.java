package br.com.unisenaisc.intelligate.web.selector.converter;

import javax.faces.convert.FacesConverter;

import br.com.unisenaisc.intelligate.common.api.dto.VeiculoDTO;
import br.com.unisenaisc.intelligate.common.api.resource.VeiculoResource;

@FacesConverter(forClass = VeiculoDTO.class)
public class VeiculoSelectorConverter extends AbstractSelectorConverter<VeiculoDTO> {

	@Override
	public VeiculoDTO findDTO(Long id) {
		return getResource().find(id);
	}
	
	private VeiculoResource getResource() {
		return getResource(VeiculoResource.class);
	}
	
}
