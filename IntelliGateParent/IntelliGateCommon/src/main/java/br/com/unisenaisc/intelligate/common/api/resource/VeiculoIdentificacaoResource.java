package br.com.unisenaisc.intelligate.common.api.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.unisenaisc.intelligate.common.api.dto.VeiculoIdentificacaoDTO;
import br.com.unisenaisc.intelligate.common.architecture.restful.IDetailCRUDResource;

@Path(VeiculoIdentificacaoResource.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface VeiculoIdentificacaoResource extends IDetailCRUDResource<VeiculoIdentificacaoDTO> {

	public static final String PATH = VeiculoResource.PATH + "/{parentId}/identificacao";
	
}
