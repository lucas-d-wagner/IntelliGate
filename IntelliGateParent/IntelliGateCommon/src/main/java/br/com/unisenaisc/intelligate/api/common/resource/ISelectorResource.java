package br.com.unisenaisc.intelligate.api.common.resource;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import br.com.unisenaisc.intelligate.api.common.dto.AbstractDTO;

public interface ISelectorResource<DTO extends AbstractDTO> {

	@GET
	Collection<DTO> findAll();
	
	@GET
	@Path("{id}")
	DTO find(@PathParam("id") Long id);
	
}
