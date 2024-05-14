package br.com.unisenaisc.intelligate.common.api.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.unisenaisc.intelligate.common.api.dto.VeiculoDTO;
import br.com.unisenaisc.intelligate.common.architecture.restful.ICRUDResource;

@Path(VeiculoResource.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface VeiculoResource extends ICRUDResource<VeiculoDTO> {

	public static final String PATH = "/veiculo";
	
}
