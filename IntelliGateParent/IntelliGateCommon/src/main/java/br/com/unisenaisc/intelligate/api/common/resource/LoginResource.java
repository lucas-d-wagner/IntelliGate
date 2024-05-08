package br.com.unisenaisc.intelligate.api.common.resource;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.unisenaisc.intelligate.api.common.dto.LoginDTO;
import br.com.unisenaisc.intelligate.api.common.dto.TokenDTO;
import br.com.unisenaisc.intelligate.common.exception.BusinessCheckedException;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface LoginResource {

	@POST
	@Path("/login")
	@PermitAll
	TokenDTO login(LoginDTO dto) throws BusinessCheckedException;

	@GET
	@PermitAll
	void teste();
	
}
