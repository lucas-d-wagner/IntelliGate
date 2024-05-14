package br.com.unisenaisc.intelligate.common.api.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.unisenaisc.intelligate.common.api.dto.TipoVeiculoDTO;
import br.com.unisenaisc.intelligate.common.architecture.restful.ISelectorResource;

@Path(TipoVeiculoResource.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TipoVeiculoResource extends ISelectorResource<TipoVeiculoDTO> {

	public static final String PATH = "/tipoveiculo";
	
}
