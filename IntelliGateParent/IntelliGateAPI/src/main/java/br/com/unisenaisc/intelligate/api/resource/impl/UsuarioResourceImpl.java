package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.unisenaisc.intelligate.api.converter.AbstractDTOConverter;
import br.com.unisenaisc.intelligate.api.converter.UsuarioConverter;
import br.com.unisenaisc.intelligate.architecture.crud.CRUDResourceImpl;
import br.com.unisenaisc.intelligate.architecture.crud.ICRUDService;
import br.com.unisenaisc.intelligate.business.service.UsuarioService;
import br.com.unisenaisc.intelligate.common.api.dto.UsuarioDTO;
import br.com.unisenaisc.intelligate.common.api.resource.UsuarioResource;
import br.com.unisenaisc.intelligate.model.entity.Usuario;

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
