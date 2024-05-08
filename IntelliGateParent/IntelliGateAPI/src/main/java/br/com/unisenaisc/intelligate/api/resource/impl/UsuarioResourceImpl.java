package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.annotation.ManagedBean;
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

	@Override
	public ICRUDService<Usuario> getService() {
		return new UsuarioService();
	}

	@Override
	public AbstractDTOConverter<Usuario, UsuarioDTO> getConverter() {
		return new UsuarioConverter();
	}


}
