package br.com.unisenaisc.intelligate.common.architecture.restful;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface ISelectorResource<DTO extends AbstractDTO> {

	@GET
	Collection<DTO> findAll();
	
	@GET
	@Path("{id}")
	DTO find(@PathParam("id") Long id);
	
}
