package br.com.unisenaisc.intelligate.common.api.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.unisenaisc.intelligate.common.api.bean.DashboardDataBean;
import br.com.unisenaisc.intelligate.common.api.bean.DashboardFilterBean;
import br.com.unisenaisc.intelligate.common.exception.BusinessCheckedException;

@Path(DashboardResource.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface DashboardResource {

	public static final String PATH = "/dashboard";
	
	@POST
	@Path("/get-data-with-filter")
	DashboardDataBean getDataWithFilter(DashboardFilterBean filter) throws BusinessCheckedException;
	
}
