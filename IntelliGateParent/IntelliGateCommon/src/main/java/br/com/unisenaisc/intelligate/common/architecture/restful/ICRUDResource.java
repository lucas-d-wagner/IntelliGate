package br.com.unisenaisc.intelligate.common.architecture.restful;

import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface ICRUDResource<DTO extends AbstractDTO> {

	@GET
	Collection<DTO> findAll();
	
	@GET
	@Path("{id}")
	DTO find(@PathParam("id") Long id);
	
	@POST
	Long insert(DTO dto);
	
	@PUT
	@Path("{id}")
	void update(@PathParam("id") Long id, DTO dto);
	
	@DELETE
	@Path("{id}")
	void delete(@PathParam("id") Long id);
	
}
