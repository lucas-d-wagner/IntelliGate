package br.com.unisenaisc.intelligate.common.api.resource;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.unisenaisc.intelligate.common.api.annotation.ValidateClientAddress;
import br.com.unisenaisc.intelligate.common.api.dto.PayloadResponseDTO;
import br.com.unisenaisc.intelligate.common.exception.BusinessCheckedException;

@Path(EstacionamentoResource.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface EstacionamentoResource {

	public static final String PATH = "/estacionamento";
	
	@GET
	@Path("/validar-entrada")
	@PermitAll
	@ValidateClientAddress
	PayloadResponseDTO<Boolean> validarEntrada(@QueryParam("token") String token) throws BusinessCheckedException;
	
}
