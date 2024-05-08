package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.unisenaisc.intelligate.api.business.model.entity.Usuario;
import br.com.unisenaisc.intelligate.api.business.service.ICRUDService;
import br.com.unisenaisc.intelligate.api.business.service.UsuarioService;
import br.com.unisenaisc.intelligate.api.common.dto.UsuarioDTO;
import br.com.unisenaisc.intelligate.api.common.resource.UsuarioResource;
import br.com.unisenaisc.intelligate.api.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.converter.UsuarioConverter;

@ManagedBean
@Transactional
public class UsuarioResourceImpl extends CRUDResourceImpl<Usuario, UsuarioDTO> implements UsuarioResource {

	@Inject 
	private UsuarioService service;
	
	@Override
	public ICRUDService<Usuario> getService() {
		return service;
	}

	@Override
	public AbstractDTOConverter<Usuario, UsuarioDTO> getConverter() {
		return new UsuarioConverter();
	}


}
