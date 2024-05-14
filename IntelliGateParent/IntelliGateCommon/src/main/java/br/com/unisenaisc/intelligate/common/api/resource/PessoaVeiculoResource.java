package br.com.unisenaisc.intelligate.common.api.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.unisenaisc.intelligate.common.api.dto.PessoaVeiculoDTO;
import br.com.unisenaisc.intelligate.common.architecture.restful.IDetailCRUDResource;

@Path(PessoaVeiculoResource.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PessoaVeiculoResource extends IDetailCRUDResource<PessoaVeiculoDTO> {

	public static final String PATH = PessoaResource.PATH + "/{parentId}/veiculo";
	
}