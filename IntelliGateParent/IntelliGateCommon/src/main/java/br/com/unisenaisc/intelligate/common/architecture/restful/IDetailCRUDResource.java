package br.com.unisenaisc.intelligate.common.architecture.restful;

import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import br.com.unisenaisc.intelligate.common.api.dto.ResponseIdDTO;

public interface IDetailCRUDResource<DTO extends AbstractDTO> {

	@GET
	Collection<DTO> findAll(@PathParam("parentId") Long parentId);
	
	@GET
	@Path("{id}")
	DTO find(@PathParam("parentId") Long parentId, @PathParam("id") Long id);
	
	@POST
	ResponseIdDTO insert(@PathParam("parentId") Long parentId, DTO dto);
	
	@PUT
	@Path("{id}")
	void update(@PathParam("parentId") Long parentId, @PathParam("id") Long id, DTO dto);
	
	@DELETE
	@Path("{id}")
	void delete(@PathParam("parentId") Long parentId, @PathParam("id") Long id);
	
}
