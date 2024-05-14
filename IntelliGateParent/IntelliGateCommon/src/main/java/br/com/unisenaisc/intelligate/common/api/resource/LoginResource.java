package br.com.unisenaisc.intelligate.common.api.resource;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.unisenaisc.intelligate.common.api.dto.LoginDTO;
import br.com.unisenaisc.intelligate.common.api.dto.TokenDTO;
import br.com.unisenaisc.intelligate.common.exception.BusinessCheckedException;

@Path(LoginResource.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface LoginResource {

	public static final String PATH = "/auth";
	
	@POST
	@Path("/login")
	@PermitAll
	TokenDTO login(LoginDTO dto) throws BusinessCheckedException;

}
