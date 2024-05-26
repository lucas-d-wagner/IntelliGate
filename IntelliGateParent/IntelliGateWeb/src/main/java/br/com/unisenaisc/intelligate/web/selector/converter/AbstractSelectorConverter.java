package br.com.unisenaisc.intelligate.web.selector.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.unisenaisc.intelligate.common.architecture.restful.AbstractDTO;
import br.com.unisenaisc.intelligate.web.client.ClientRestProxyService;

public abstract class AbstractSelectorConverter<DTO extends AbstractDTO> implements Converter<DTO> {

	@Override
	public DTO getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(value);
		
		return findDTO(id);
	}
	

	@Override
	public String getAsString(FacesContext context, UIComponent component, DTO value) {
		if(value == null) {
			return "";
		}
		
		return String.valueOf(value.getId());
	}

	public abstract DTO findDTO(Long id);
	
	public <T> T getResource(Class<T> resourceInterface) {
		return new ClientRestProxyService().createProxy(resourceInterface);
	}
	
}
