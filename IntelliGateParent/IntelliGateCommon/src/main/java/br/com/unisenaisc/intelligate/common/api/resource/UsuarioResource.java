package br.com.unisenaisc.intelligate.common.api.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.unisenaisc.intelligate.common.api.dto.UsuarioDTO;
import br.com.unisenaisc.intelligate.common.architecture.restful.ICRUDResource;

@Path(UsuarioResource.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UsuarioResource extends ICRUDResource<UsuarioDTO> {
	
	public static final String PATH = "/usuario";

}
