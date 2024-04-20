package br.com.unisenaisc.intelligate.api.resource.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.unisenaisc.intelligate.api.common.resource.UsuarioResource;
import br.com.unisenaisc.intelligate.model.Usuario;

public class UsuarioResourceImpl implements UsuarioResource {

	@Override
	public Response getTodosRegistros() {
		
		Usuario usuario = new Usuario();
		
		System.out.println(usuario);
		
		return Response.status(Status.FOUND).build();
	}

}
